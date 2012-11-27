/**
 * stellen alle Androide des Typs Objektbewacher dar
 * @author Lucas
 */
public class Objektbewacher extends Beschuetzer {

	@Override
	public String toString() {
		return "Objektbewacher";
	}

	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonObjektbewacherBenutzt(this);
	}
}
