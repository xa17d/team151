
public abstract class Schwerarbeiter extends Androide{
	
	@Override
	public String checkSkin(Skin skin) {
		return skin.vonSchwerarbeiterGetragen(this);
	}
	
	@Override
	public String checkSoftware(Software software) {
		return software.vonSchwerarbeiterVerwendet(this);
	}
}
