
public abstract class Bediener extends Androide {
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonBedienerGetragen(this);
	}
	
	@Override
	public String checkSoftware(Software software) {
		return software.vonBedienerVerwendet(this);
	}
}
