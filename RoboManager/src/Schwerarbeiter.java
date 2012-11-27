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
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		// TODO: Methode implementieren:
		//return aktorenKit.vonSchwerarbeiterBenutzt(this);
		return "aktorenKit.vonSchwerarbeiterBenutzt nicht vollstaendig implementiert";
	}
}
