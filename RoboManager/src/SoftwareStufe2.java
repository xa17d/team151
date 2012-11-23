
public class SoftwareStufe2 extends Software {

	@Override
	public String vonBedienerVerwendet(Bediener bediener) {
		return null;
	}

	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf Software der Stufe 2 nicht verwenden";
	}

	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter) {
		return "Schwerarbeiter darf Software der Stufe 2 nicht verwenden";
	}

	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer) {
		return "Beschuetzer darf Software der Stufe 2 nicht verwenden";
	}

	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return "Kaempfer darf Software der Stufe 2 nicht verwenden";
	}

	@Override
	public String toString() {
		return "Software Stufe 2";
	}
}
