/**
 * stellen alle Androide des Typs Bauarbeiter dar
 * @author Lucas
 */
public class Bauarbeiter extends Schwerarbeiter{

	@Override
	public String checkSoftware(Software software) {
		return software.vonBauarbeiterVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Bauarbeiter";
	}
}
