import java.util.ArrayList;


public class Feld {
	
	private ArrayList<Auto> cars;
	private int width;
	private int height;
	
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
	
	public Position checkPosition(Position b) {
		return b;
	}
	
	/**
	 * Beendet alle Threads aller Autos in der ArrayList cars
	 */
	public void stopRace() {
		for(Auto a : cars){
			a.stop();
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
				for(Auto a : cars){
					if(a.getPosition().getX() == x && a.getPosition().getY() == y)
						ret += ">";
					else
						ret += " ";
				}
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
}
