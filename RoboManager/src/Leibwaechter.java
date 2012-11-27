/**
 * stellen alle Androide des Typs Leibwaechter dar
 * @author Lucas
 */
public class Leibwaechter extends Beschuetzer{

	@Override
	public String checkSoftware(Software software) {
		return software.vonLeibwaechterVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Leibwaechter";
	}
}
