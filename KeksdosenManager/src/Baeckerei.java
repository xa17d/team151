/**
 * Repraesentiert eine Baeckerei
 * @author daniel
 */
public class Baeckerei {
	/**
	 * Fuehrt eine Bestellung aus
	 * @param bestellung Bestellung
	 * @return Keksdose mit den bestellten Keksen.
	 */
	public Keksdose backen(Bestellung bestellung) {
		Keksdose dose = new Keksdose();
	
		for (Position p : bestellung) {
			for (int i = 0; i < p.getAnzahl(); i++) {
				
				if (p.getFuellung() == null) {
					// Einfacher Keks
				}
				else {
					// Doppel Keks
					
				}
				
			}
		}
		
		return dose;
	}
}
