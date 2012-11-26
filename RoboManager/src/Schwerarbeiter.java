/**
 * Obertyp saemtlicher Schwerarbeiter
 * @author Lucas
 */
public abstract class Schwerarbeiter extends Androide{
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonSchwerarbeiterGetragen(this);
	}
	
	@Override
	public String checkSoftwareStufe(SoftwareStufe softwareStufe) {
		return softwareStufe.vonSchwerarbeiterVerwendet(this);
	}
	
	@Override
	public String checkAktorenKit(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return null;
	}
}
