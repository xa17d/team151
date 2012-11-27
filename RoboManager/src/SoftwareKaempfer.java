/**
 * Software fuer einen Kaempfer
 * @author Daniel
 *
 */
public class SoftwareKaempfer extends Software {
	public SoftwareKaempfer(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Kaempfer Software ("+getStufe()+")";
	}
}