/**
 * stellen alle Androide des Typs Gesellschafter dar
 * @author Lucas
 */
public class Gesellschafter extends Bediener{

	@Override
	public String checkSoftwareStufe(SoftwareStufe softwareStufe) {
		return softwareStufe.vonGesellschafterVerwendet(this);
	}

	@Override
	public String toString() {
		return "Gesellschafter";
	}
}
