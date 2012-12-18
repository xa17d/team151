/**
 * Repraesentiert eine Baeckerei
 * @author daniel, lucas
 */
public class Baeckerei {
	/**
	 * Erzeugt eine neue Baeckerei
	 */
	public Baeckerei() {
		backmaschineDoppel = new DoppelKeksBackmaschine();
	}
	
	/**
	 * Backmaschine fuer Doppelkekse
	 */
	private DoppelKeksBackmaschine backmaschineDoppel;
	
	/**
	 * Fuehrt eine Bestellung aus
	 * @param bestellung Bestellung (darf nicht null sein)
	 * @return Keksdose mit den bestellten Keksen.
	 */
	public Keksdose backen(Bestellung bestellung) {
		Keksdose dose = new Keksdose();
		Keks keks = null;
		EinfacherKeks einfacherKeks = null;
	
		for (Position p : bestellung) {
			for (int i = 0; i < p.getAnzahl(); i++) {
				if (p.getFuellung() == null) {
					//Einfacher Keks
					keks = p.getForm().backeForm(p.getTeig());
				}
				else {
					//Doppelter Keks
					einfacherKeks = p.getForm().backeForm(p.getTeig());
					keks = backmaschineDoppel.backeKeks(einfacherKeks, p.getFuellung());	
					
				}
				
				dose.addKeks(keks);
			}
		}
		
		return dose;
	}
}
