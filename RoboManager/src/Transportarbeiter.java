/**
 * stellen alle Androide des Typs Transportarbeiter dar
 * @author Lucas
 */
public class Transportarbeiter extends Schwerarbeiter{

	@Override
	public String checkSoftware(Software software) {
		return software.vonTransportarbeiterVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Transportarbeiter";
	}
}
