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
		thread = new Thread(this);
	}
	
	private Position position; // Aktuelle Position und Richtung des Autos (immer != null)
	private Thread thread;     // Thread der die Bewegungen des Autos durchfuert
	private int intervall;     // Intervall in Millisekunden in dem sich das Auto um ein Feld weiterbewegt
	private Feld feld;         // Spielfeld des Autodrom (immer != null)
	
	/**
	 * Setzt die aktuelle Position und Richtung des Autos
	 * @param position neue Position
	 */
	public synchronized void setPosition(Position position) {
		this.position = position;
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
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Position b = bewegen(position);
				b = feld.checkPosition(b);
				setPosition(b);
				System.out.println(b);
				
				Thread.sleep(intervall);
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	/**
	 * Wird im festgelegten Intervall aufgerufen. Diese Methode legt die
	 * Bewegungsstrategie fest. 
	 * @param p Aktuelle Position und Richtung des Autos (niemals null)
	 * @return Position und Richtung des Autos nach diesem Bewegungsschritt (niemals null)
	 */
	protected abstract Position bewegen(Position p);
}
