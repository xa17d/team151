/**
 * stellen alle Androide des Typs Hilfskraft dar
 * @author Lucas
 */
public class Hilfskraft extends Bediener {

	@Override
	public String checkSoftware(Software software) {
		return software.vonHilfskraftVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Hilfskraft";
	}
}
