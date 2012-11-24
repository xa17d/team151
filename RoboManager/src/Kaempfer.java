/**
 * stellen alle Androide des Typs Kaempfer dar
 * @author Lucas
 */
public class Kaempfer extends Beschuetzer{

	@Override
	public String checkSoftwareStufe(SoftwareStufe softwareStufe) {
		return softwareStufe.vonKaempferVerwendet(this);
	}

	@Override
	public String toString() {
		return "Kaempfer";
	}
}
