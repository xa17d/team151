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
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonBeschuetzerBenutzt(this, softwareStufe);
	}
}
