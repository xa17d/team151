
public class SoftwareStufe4 extends Software {

	@Override
	public String vonBedienerVerwendet(Bediener bediener) {
		return "Bediener darf Software der Stufe 4 nicht verwenden";
	}

	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf Software der Stufe 4 nicht verwenden";
	}

	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter) {
		return null;
	}

	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer) {
		return null;
	}

	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return "Kaempfer darf Software der Stufe 4 nicht verwenden";
	}
}
