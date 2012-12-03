/**
 * Repraesentiert ein Auto im Autodrom
 * @author Daniel
 *
 */
public abstract class Auto implements Runnable {
	/**
	 * Erzeugt ein neues Auto
	 * @param feld Spielfeld des Autodrom (!=null)
	 * @param intervall Intervall in Millisekunden in dem sich das Auto um ein Feld weiterbewegt
	 * @param anfangsPosition Anfangsposition und Richtung des Autos  (!=null) 
	 */
	public Auto(Feld feld, int intervall, Position anfangsPosition) {
		this.feld = feld;
		this.intervall = intervall;
		this.position = anfangsPosition;
		this.punkte = 0;
		this.bewegungen = 0;
		thread = new Thread(this);
	}
	
	private Position position; // Aktuelle Position und Richtung des Autos (immer != null)
	private Thread thread;     // Thread der die Bewegungen des Autos durchfuert
	private int intervall;     // Intervall in Millisekunden in dem sich das Auto um ein Feld weiterbewegt
	private Feld feld;         // Spielfeld des Autodrom (immer != null)
	private int punkte;        // Punkte die dieses Auto momentan hat
	private int bewegungen;    // Anzahl Bewegungen
	
	/**
	 * Setzt die aktuelle Position und Richtung des Autos
	 * @param position neue Position (!=null)
	 */
	public synchronized void setPosition(Position position) {
		if (!this.position.equals(position)) {
			this.position = position;
			bewegungen++;
			
			if (bewegungen >= 1000000000) {
				feld.stopRace();
			}
		}
	}
	
	/**
	 * Gibt dem Auto Punkte oder zieht ihm welche ab.
	 * Erreicht das Auto 10 oder mehr Punkte, wird die Simulation beendet (durch feld.stop())
	 * @param punkte Gibt dem Auto Punkte (bei positivem Wert), oder zieht im welche ab (bei negativem Wert)
	 */
	public void punkteVergeben(int punkte) {
		this.punkte += punkte;
		
		if (this.punkte >= 10) {
			feld.win(this);
		}
	}
	
	/**
	 * Startet den Thread der das Auto bewegen laesst. Darf nur einmal aufgerufen werden.
	 */
	public void start() {
		thread.start();
	}
	
	/**
	 * Beendet den Thread des Autos. Nach dem Aufruf bleibt das Auto stehen. Darf nur
	 * aufgerufen werden wenn zuvor start() aufgerufen wurde.
	 */
	public void stop() {
		thread.interrupt();
	}

	/**
	 * Fuert die Bewegung des Autos durch.
	 * sperrt den Bereich in dem die eigentliche Bewegung durchgefuehrt wird
	 * mittels eine ReentrantLock aus dem Feld damit immer eine Bewegung nach der
	 * anderen durchgefuehrt wird.
	 */
	@Override
	public void run() {
		while(feld.isRace()){
			try {
				Thread.sleep(intervall);
				Position b = bewegen(position);
				feld.lock.lock();
				b = feld.checkPosition(this, b);
				setPosition(b);
				feld.lock.unlock();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		} 
	}
	
	/**
	 * Wird im festgelegten Intervall aufgerufen. Diese Methode legt die
	 * Bewegungsstrategie fest. 
	 * @param p Aktuelle Position und Richtung des Autos (niemals null)
	 * @return Position und Richtung des Autos nach diesem Bewegungsschritt (niemals null)
	 */
	protected abstract Position bewegen(Position p);
	
	/**
	 * @return Breite des Feldes in dem sich das Auto befindet.
	 */
	protected int getFieldWidth(){
		return feld.getWidth();
	}
	
	/**
	 * @return Hoehe des Feldes in dem sich das Auto befindet.
	 */
	protected int getFieldHeight(){
		return feld.getHeight();
	}
	
	/**
	 * @return aktuelle Position des Autos.
	 */
	public Position getPosition(){
		return this.position;
	}
	
	@Override
	public String toString() {
		return position+" Punkte: "+punkte;
	}
}
