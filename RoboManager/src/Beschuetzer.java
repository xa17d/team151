
public abstract class Beschuetzer extends Androide{
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonBeschuetzerGetragen(this);
	}
	
	@Override
	public String checkSoftware(Software software) {
		return software.vonBeschuetzerVerwendet(this);
	}
}
