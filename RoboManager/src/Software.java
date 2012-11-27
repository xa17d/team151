/**
 * stellt Obertyp aller Software-Typen dar
 * @author Daniel
 *
 */
public abstract class Software {
	/**
	 * Kostruktor
	 * @param stufe Softwarestufe (!=null)
	 */
	public Software(SoftwareStufe stufe) {
		this.stufe = stufe;
	}
	
	/**
	 * Software-Stufe (!=null)
	 */
	private SoftwareStufe stufe;
	/**
	 * Gibt die Software-Stufe zuerueck
	 * @return Software-Stufe (!=null)
	 */
	public SoftwareStufe getStufe() { return stufe; }

	/**
	 * ueberprueft ob diese Software von einer Hilfskraft verwendet werden darf
	 * @param hilfskraft Hilfskraft
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonHilfskraftVerwendet(Hilfskraft hilfskraft) {
		return "Hilfskraft darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Gesellschafter verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Bauarbeiter verwendet werden darf
	 * @param bauarbeiter Bauarbeiter
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonBauarbeiterVerwendet(Bauarbeiter bauarbeiter) {
		return "Bauarbeiter darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem ServiceTechniker verwendet werden darf
	 * @param serviceTechniker ServiceTechniker
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonServiceTechnikerVerwendet(ServiceTechniker serviceTechniker) {
		return "ServiceTechniker darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Transportarbeiter verwendet werden darf
	 * @param transportarbeiter Transportarbeiter
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonTransportarbeiterVerwendet(Transportarbeiter transportarbeiter) {
		return "Transportarbeiter darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Objektbewacher verwendet werden darf
	 * @param objektbewacher Objektbewacher
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonObjektbewacherVerwendet(Objektbewacher objektbewacher) {
		return "Objektbewacher darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Leibwaechter verwendet werden darf
	 * @param leibwaechter Leibwaechter
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonLeibwaechterVerwendet(Leibwaechter leibwaechter) {
		return "Leibwaechter darf diesen Software-Typ nicht verwenden";
	}
	/**
	 * ueberprueft ob diese Software von einem Kaempfer verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software nicht verwendet werden darf
	 * 		   null: falls zugelassen
	 */
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return "Kaempfer darf diesen Software-Typ nicht verwenden";
	}
}
