/**
 * stellt einen beruehrungssensitiven Skin dar
 * @author Lucas
 */
public class BeruehrungssensitiverSkin extends Skin {

	@Override
	public String vonBedienerGetragen(Bediener bediener) {
		return null;
	}

	@Override
	public String vonSchwerarbeiterGetragen(Schwerarbeiter schwerarbeiter) {
		return null;
	}

	@Override
	public String vonBeschuetzerGetragen(Beschuetzer beschuetzer) {
		return null;
	}

	@Override
	public String toString() {
		return "beruehrungssensitiver Skin";
	}
}
