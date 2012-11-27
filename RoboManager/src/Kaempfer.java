/**
 * stellen alle Androide des Typs Kaempfer dar
 * @author Lucas
 */
public class Kaempfer extends Beschuetzer{


	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonKaempferBenutzt(this, softwareStufe);
	}

	@Override
	public String checkSoftware(Software software) {
		return software.vonKaempferVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Kaempfer";
	}
}
