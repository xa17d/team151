/**
 * stellt die Software der Stufe 3 dar
 * @author Lucas
 */
public class SoftwareStufe3 extends SoftwareStufe {
	
	@Override
	public String vonBedienerVerwendet(Bediener bediener) {
		return "Bediener darf Software der Stufe 3 nicht verwenden";
	}

	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter) {
		return "Gesellschafter darf Software der Stufe 3 nicht verwenden";
	}

	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter) {
		return null;
	}

	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer) {
		return "Beschuetzer darf Software der Stufe 3 nicht verwenden";
	}

	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer) {
		return "Kaempfer darf Software der Stufe 3 nicht verwenden";
	}

	@Override
	public String toString() {
		return "Software-Stufe 3";
	}
}
