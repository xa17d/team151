
public abstract class Bediener extends Androide {
	public String checkSkin(Skin skin) {
		return skin.vonBedienerGetragen(this);
	}
}
