
public class hochfesterSkin extends Skin{

	@Override
	public String vonBedienerGetragen(Bediener bediener) {
		return "Bediener darf keinen hochfesten Skin tragen";
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
		return "hochfester Skin";
	}
}
