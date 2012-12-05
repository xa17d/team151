import java.util.ArrayList;

/**
 * Representiert ein Feld auf dem sich Autos bewegen koennen
 */
public class Feld {
	
	private ArrayList<Auto> cars; // Alle Autos uf diesem Feld
	private int width;            // Breite des Feldes
	private int height;           // Hoehe des Feldes
	private boolean race = false; // true wenn gerade ein Rennen im Gange ist, sonst false

	/**
	 * Konstruktor fuer ein rechteckiges Feld
	 * @param width Breite
	 * @param height Hoehe
	 */
	public Feld(int width, int height){
		cars = new ArrayList<Auto>();
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Starten den jeweiligen Thread pro Auto
	 * von saemtlichen Autos in der ArrayList cars
	 */
	public void startRace(){
		this.race = true;

		for(Auto a : cars){
			a.start();
		}
		
	}
	
	/**
	 * Fuegt ein Auto zur ArrayList cars hinzu
	 * @param auto Auto darf nicht null sein
	 */
	public void addCar(Auto auto){
		cars.add(auto);
	}
	
	/**
	 * Ueberprueft die neue Position eines Autos inklusive
	 * Kollisionserkennung und vergibt die Punkte bei einer Kollision
	 * @param auto Auto das seine Position aendert
	 * @param b neue Position die ueberprueft wird
	 * @return neue Position des Autos auto
	 */
	public synchronized void checkPosition(Auto auto, Position b) {
		//System.out.println(auto.toString() + " checkPosition()");
		int punktAuto = 0;
		int punktA = 0;
		for(Auto a : cars){
			if(a.getPosition().getX() == b.getX() && a.getPosition().getY() == b.getY()){
				int crashWinkel = ((b.getRichtung() - a.getPosition().getRichtung())+360) % 360;
				
				if ((crashWinkel >= 90)&&(crashWinkel <= 270)) { // seitlich oder von hinten hineingefahren -1 fuer erwischtes Auto (a) und +1 fuer Auto (auto)
					punktAuto = 1;
					punktA = -1;
				}
				else //Frontalcrash +1 fuer beide Autos
				{
					punktAuto = 1;
					punktA = 1;
				}
				
				//System.out.println("Kollision von " + a.toString() + " und " + auto.toString());
				a.punkteVergeben(punktA);
				auto.punkteVergeben(punktAuto);			
			}
		}
		auto.setPosition(b);
	}
	
	/**
	 * Beendet alle Threads aller Autos in der ArrayList cars
	 * und gibt die Rangliste aus
	 */
	public synchronized void stopRace() {
		if (race)
		{		
			for(Auto a : cars){
				a.stop();
				System.out.println(a.toString());
			}
			
			this.race = false;
		}
	}

	/**
	 * @return Breite des Feldes > 0
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return Hoehe des Feldes > 0
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gibt das aktuelle Feld mit allen darauf befindlichen Autos aus.
	 */
	@Override
	public String toString(){
		String ret = " ";
		int i = 0;
		while(i < getWidth()){
			ret += "_"; //Obere Wand 
			i++;
		}
		ret += "\n";
		
		for(int y = 0; y < getHeight(); y++){
			ret += "|";
			for(int x = 0; x < getWidth(); x++){
				
				String c = null;
				
				for(Auto a : cars){
					if(a.getPosition().getX() == x && a.getPosition().getY() == y)
						c = a.toString();
				}
				if(c!=null && c.length() > 0)
					ret += c.charAt(0);
				else
					ret += " ";
			}
			ret += "|\n";
		}
		ret += " ";
		i = 0;
		while(i < getWidth()){
			ret += "-"; //Untere Wand
			i++;
		}
		ret += "\n";
		return ret;
	}

	public boolean isRace() {
		return race;
	}
}
