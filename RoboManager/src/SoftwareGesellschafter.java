/**
 * Software fuer einen Gesellschafter
 * @author Daniel
 *
 */
public class SoftwareGesellschafter extends Software {
	public SoftwareGesellschafter(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Gesellschafter Software ("+getStufe()+")";
	}
}