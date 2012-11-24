/**
 * Obertyp saemtlicher Beschuetzer
 * @author Lucas
 */
public abstract class Beschuetzer extends Androide{
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonBeschuetzerGetragen(this);
	}
	
	@Override
	public String checkSoftwareStufe(SoftwareStufe softwareStufe) {
		return softwareStufe.vonBeschuetzerVerwendet(this);
	}
}
