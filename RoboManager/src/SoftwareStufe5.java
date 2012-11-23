
public class SoftwareStufe5 extends Software {
	
	@Override
	public String vonBedienerVerwendet(Bediener bediener) {
		return "Bediener darf Software der Stufe 5 nicht verwenden";
	}

	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf Software der Stufe 5 nicht verwenden";
	}

	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter) {
		return "Schwerarbeiter darf Software der Stufe 5 nicht verwenden";
	}

	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer) {
		return "Beschuetzer darf Software der Stufe 5 nicht verwenden";
	}

	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return null;
	}

	@Override
	public String toString() {
		return "Software Stufe 5";
	}
}
