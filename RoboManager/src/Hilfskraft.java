
public class Hilfskraft extends Bediener {
	private Skin skin;
	
	public String checkSkin(Skin skin) {
		return skin.vonHilfskraftGetragen(this);
	}
	
	public void setSkin(Skin skin) {
		this.skin = skin;
	}
}
