/**
 * Obertyp saemtlicher Bediener
 * @author Lucas
 */
public abstract class Bediener extends Androide {
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonBedienerGetragen(this);
	}
	
	@Override
	public String checkAenderungTyp(Androide vorgaengerAndroide) {
		return vorgaengerAndroide.aenderungZuBediener();
	}
	
	@Override
	public String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonBedienerBenutzt(this, softwareStufe);
	}
	
	@Override
	protected String aenderungZuBediener() {
		return null;
	}
}
