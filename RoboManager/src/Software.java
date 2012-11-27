/**
 * stellt Obertyp aller Software-Typen dar
 * @author Daniel
 *
 */
public abstract class Software {
	public Software(SoftwareStufe stufe) {
		this.stufe = stufe;
	}
	
	private SoftwareStufe stufe;
	public SoftwareStufe getStufe() { return stufe; }
	
	public String vonHilfskraftVerwendet(Hilfskraft hilfskraft) {
		return "Hilfskraft darf diesen Software-Typ nicht verwenden";
	}
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf diesen Software-Typ nicht verwenden";
	}
	public String vonBauarbeiterVerwendet(Bauarbeiter bauarbeiter) {
		return "Bauarbeiter darf diesen Software-Typ nicht verwenden";
	}
	public String vonServiceTechnikerVerwendet(ServiceTechniker serviceTechniker) {
		return "ServiceTechniker darf diesen Software-Typ nicht verwenden";
	}
	public String vonTransportarbeiterVerwendet(Transportarbeiter transportarbeiter) {
		return "Transportarbeiter darf diesen Software-Typ nicht verwenden";
	}
	public String vonObjektbewacherVerwendet(Objektbewacher objektbewacher) {
		return "ServiceTechniker darf diesen Software-Typ nicht verwenden";
	}
	public String vonLeibwaechterVerwendet(Leibwaechter leibwaechter) {
		return "Leibwaechter darf diesen Software-Typ nicht verwenden";
	}
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return "Kaempfer darf diesen Software-Typ nicht verwenden";
	}
}
