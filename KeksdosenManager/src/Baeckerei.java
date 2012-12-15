/**
 * Repraesentiert eine Baeckerei
 * @author daniel
 */
public class Baeckerei {
	EinfachKeksBackmaschine backmaschineRund;
	EinfachKeksBackmaschine backmaschineMond;
	EinfachKeksBackmaschine backmaschineWeihnachtsmann;
	DoppelKeksBackmaschine backmaschineDoppel;
	
	RundeForm rund = new RundeForm();
	MondForm mond = new MondForm();
	WeihnachtsmannForm weihnachtsmann = new WeihnachtsmannForm();
	
	public Baeckerei() {
		backmaschineRund = new EinfachKeksBackmaschine(rund);
		backmaschineMond = new EinfachKeksBackmaschine(mond);
		backmaschineWeihnachtsmann = new EinfachKeksBackmaschine(weihnachtsmann);
		backmaschineDoppel = new DoppelKeksBackmaschine();
	}
	
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
					//TODO dynamisch erkennen
					if(p.getForm().getClass() == rund.getClass())
						dose.addKeks(backmaschineRund.backeKeks(p.getTeig()));
					else if(p.getForm().getClass() == mond.getClass())
						dose.addKeks(backmaschineMond.backeKeks(p.getTeig()));
					else if(p.getForm().getClass() == weihnachtsmann.getClass())
						dose.addKeks(backmaschineWeihnachtsmann.backeKeks(p.getTeig()));
				}
				else {
					//TODO dynamisch erkennen
					if(p.getForm().getClass() == rund.getClass())
						dose.addKeks(backmaschineDoppel.backeKeks(backmaschineRund.backeKeks(p.getTeig()), p.getFuellung()));
					else if(p.getForm().getClass() == mond.getClass())
						dose.addKeks(backmaschineDoppel.backeKeks(backmaschineMond.backeKeks(p.getTeig()), p.getFuellung()));
					else if(p.getForm().getClass() == weihnachtsmann.getClass())
						dose.addKeks(backmaschineDoppel.backeKeks(backmaschineWeihnachtsmann.backeKeks(p.getTeig()), p.getFuellung()));
					
				}
				
			}
		}
		
		return dose;
	}
}
