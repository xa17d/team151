/**
 * stellen alle Androide des Typs Gesellschafter dar
 * @author Lucas
 */
public class Gesellschafter extends Bediener{

	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonGesellschafterBenutzt(this, softwareStufe);
	}
	
	@Override
	public String checkSoftware(Software software) {
		return software.vonGesellschafterVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Gesellschafter";
	}
}
