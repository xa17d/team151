/**
 * stellen alle Androide des Typs Gesellschafter dar
 * @author Lucas
 */
public class Gesellschafter extends Bediener{

	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		// TODO: Methode implementieren:
		//return aktorenKit.vonGesellschafterBenutzt(this);
		return "aktorenKit.vonGesellschafterBenutzt nicht implementiert";
	}
	@Override
	public String toString() {
		return "Gesellschafter";
	}
}
