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
	public String checkSoftwareStufe(SoftwareStufe softwareStufe) {
		return softwareStufe.vonBedienerVerwendet(this);
	}
	
	@Override
	public String checkAktorenKit(AktorenKit aktorenKit, SoftwareStufe softwareStufe){
		return aktorenKit.vonBedienerBenutzt(this);
	}
}
