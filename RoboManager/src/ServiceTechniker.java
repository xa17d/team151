/**
 * stellen alle Androide des Typs Service-Techniker dar
 * @author Lucas
 */
public class ServiceTechniker extends Schwerarbeiter {

	@Override
	public String checkSoftware(Software software) {
		return software.vonServiceTechnikerVerwendet(this);
	}
	
	@Override
	public String toString() {
		return "Service-Techniker";
	}
}
