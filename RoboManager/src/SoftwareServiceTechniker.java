/**
 * Software fuer einen ServiceTechniker
 * @author Daniel
 *
 */
public class SoftwareServiceTechniker extends Software {
	public SoftwareServiceTechniker(SoftwareStufe stufe) {
		super(stufe);
	}
	
	@Override
	public String vonServiceTechnikerVerwendet(ServiceTechniker serviceTechniker) {
		return null;
	}
}