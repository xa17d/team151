/**
 * Software fuer einen Bauarbeiter
 * @author Daniel
 *
 */
public class SoftwareBauarbeiter extends Software {
	public SoftwareBauarbeiter(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonBauarbeiterVerwendet(Bauarbeiter bauarbeiter) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Bauarbeiter Software ("+getStufe()+")";
	}
}