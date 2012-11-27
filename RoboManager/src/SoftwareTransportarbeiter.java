/**
 * Software fuer einen Transportarbeiter
 * @author Daniel
 *
 */
public class SoftwareTransportarbeiter extends Software {
	public SoftwareTransportarbeiter(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonTransportarbeiterVerwendet(Transportarbeiter transportarbeiter) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Transportarbeiter Software ("+getStufe()+")";
	}
}