/**
 * Software fuer eine Hilfskraft
 * @author Daniel
 *
 */
public class SoftwareHilfskraft extends Software {
	public SoftwareHilfskraft(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonHilfskraftVerwendet(Hilfskraft hilfskraft) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Hilfskraft Software ("+getStufe()+")";
	}
}
