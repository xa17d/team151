/**
 * stellen alle Androide des Typs Objektbewacher dar
 * @author Lucas
 */
public class Objektbewacher extends Beschuetzer {

	@Override
	public String checkSoftware(Software software) {
		return software.vonObjektbewacherVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Objektbewacher";
	}
}
