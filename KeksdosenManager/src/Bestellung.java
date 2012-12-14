import java.util.ArrayList;

/**
 * Repraesentiert eine Bestellung.
 * @author daniel
 */
public class Bestellung {
	/**
	 * Erzeugt eine neue Bestellung
	 */
	public Bestellung() {
		positionen = new ArrayList<Position>();
	}
	
	/**
	 * beinhaltet alle Positionen der Bestellung
	 */
	private ArrayList<Position> positionen;
	
	/**
	 * Fuegt eine neue Position der Bestellung hinzu
	 * @param position neue Position
	 */
	public void addPosition(Position position) {
		positionen.add(position);
	}
	
	/**
	 * Listet alle Positionen in der Standardausgabe auf 
	 */
	public void drucke() {
		int i = 1;
		for (Position p : positionen) {
			System.out.println(i+".\t"+p);
			i++;
		}
	}
}
