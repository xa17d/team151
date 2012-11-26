/**
 * stellen alle Androide des Typs Leibwaechter dar
 * @author Lucas
 */
public class Leibwaechter extends Beschuetzer{

	@Override
	public String toString() {
		return "Leibwaechter";
	}

	@Override
	public String checkAktorenKit(AktorenKit aktorenKit, SoftwareStufe softwareStufe) {
		return aktorenKit.vonLeibwaechterBenutzt(this);
	}
}
