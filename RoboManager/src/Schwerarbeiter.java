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
	public String checkAenderungTyp(Androide vorgaengerAndroide) {
		return vorgaengerAndroide.aenderungZuSchwerarbeiter();
	}
	
	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonSchwerarbeiterBenutzt(this, softwareStufe);
	}
	
	@Override
	protected String aenderungZuSchwerarbeiter() {
		return null;
	}
}
