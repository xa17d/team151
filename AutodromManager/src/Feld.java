import java.util.ArrayList;


public class Feld {
	
	private ArrayList<Auto> cars;
	private int width;
	private int height;
	private boolean race = false;
	
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
		System.out.println("*** Start Race ***");
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
	public Position checkPosition(Auto auto, Position b) {
		//System.out.println(auto.toString() + " checkPosition()");
		int punktAuto = 0;
		int punktA = 0;
		for(Auto a : cars){
			if(a.getPosition().getX() ==b.getX() && a.getPosition().getY() == b.getY()){
				int richtung = a.getPosition().getRichtung() - b.getRichtung();
				if(Math.abs(richtung) == 180){ //Frontalcrash +1 fuer beide Autos
					punktAuto = 1;
					punktA = 1;
				} else { //Sonst seitlich oder von hinten hineingefahren -1 fuer erwischtes Auto (a) und +1 fuer Auto (auto) 
					punktAuto = 1;
					punktA = -1;
				}
					
				/* ERKL€RUNG
				if(a.getPosition().getRichtung() == 90){ //Das erwischte Auto faehrt nach Norden
					if(b.getRichtung() == 90){ //Hinten aufgefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == 0) {//Seitlich (links) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == -90) { //Frontalcrash beide +1 Punkt
						punktAuto = 1;
						punktA = 1;
					} else {//Seitlich (rechts) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					}
				} else if (a.getPosition().getRichtung() == 0){ //Das erwischte Auto faehrt nach Osten
					if(b.getRichtung() == 90){ //Seitlich (rechts) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == 0) {//Hinten aufgefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == -90) {//Seitlich (links) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else { //Frontalcrash beide +1 Punkt
						punktAuto = 1;
						punktA = 1;
					}
				} else if (a.getPosition().getRichtung() == -90){ //Das erwischte Auto faehrt nach Sueden
					if(b.getRichtung() == 90){ //Frontalcrash beide +1 Punkt
						punktAuto = 1;
						punktA = 1;
					} else if (b.getRichtung() == 0) {//Seitlich (rechts) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == -90) { //Hinten aufgefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else {//Seitlich (links) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					}
				} else { //Das erwischte Auto faehrt nach Westen
					if(b.getRichtung() == 90){ //Seitlich (links) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else if (b.getRichtung() == 0) { //Frontalcrash beide +1 Punkt
						punktAuto = 1;
						punktA = 1;
					} else if (b.getRichtung() == -90) { //Seitlich (rechts) hineingefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					} else { //Hinten aufgefahren +1 Punkt fuer auto -1 Punkt fuer a
						punktAuto = 1;
						punktA = -1;
					}
				} */
				System.out.println("Kollision von " + a.toString() + " und " + auto.toString());
				a.punkteVergeben(punktA);
				auto.punkteVergeben(punktAuto);			
			}
		}
		return b;
	}
	
	/**
	 * Beendet alle Threads aller Autos in der ArrayList cars
	 */
	public void stopRace() {
		System.out.println("*** Stop Race ***");
		for(Auto a : cars){
			a.stop();
		}
		this.race = false;
	}
	
	public void win(Auto a){
		System.out.println("*** " + a.toString() + " hat gewonnen!");
		stopRace();
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
		
		boolean carthere = false;
		
		for(int y = 0; y < getHeight(); y++){
			ret += "|";
			for(int x = 0; x < getWidth(); x++){
				for(Auto a : cars){
					if(a.getPosition().getX() == x && a.getPosition().getY() == y)
						carthere = true;
				}
				if(carthere)
					ret += ">";
				else
					ret += " ";
				carthere = false;
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
