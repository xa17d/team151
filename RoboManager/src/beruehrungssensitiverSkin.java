
public class beruehrungssensitiverSkin extends Skin {

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
		return "Beschuetzer darf keinen beruehrungssensitiven Skin tragen";
	}

}
