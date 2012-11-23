
public class gepanzerterSkin extends Skin {

	@Override
	public String vonBedienerGetragen(Bediener bediener) {
		return "Bediener darf keinen gepanzerten Skin tragen";
	}

	@Override
	public String vonSchwerarbeiterGetragen(Schwerarbeiter schwerarbeiter) {
		return "Schwerarbeiter darf keinen gepanzerten Skin tragen";
	}

	@Override
	public String vonBeschuetzerGetragen(Beschuetzer beschuetzer) {
		return null;
	}

	@Override
	public String toString() {
		return "gepanzerter Skin";
	}
}
