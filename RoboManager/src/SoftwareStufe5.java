/**
 * stellt die Software der Stufe 5 dar
 * @author Lucas
 */
public class SoftwareStufe5 extends SoftwareStufe {
	
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung1 kit) {
		return "Bediener darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung5 kit) {
		return "Bediener darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung10 kit) {
		return "Bediener darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistungUnlimitiert kit) {
		return "Bediener darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung1 kit) {
		return "Gesellschafter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung5 kit) {
		return "Gesellschafter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung10 kit) {
		return "Gesellschafter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistungUnlimitiert kit) {
		return "Gesellschafter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung1 kit) {
		return "Schwerarbeiter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung5 kit) {
		return "Schwerarbeiter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung10 kit) {
		return "Schwerarbeiter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistungUnlimitiert kit) {
		return "Schwerarbeiter darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung1 kit) {
		return "Beschuetzer darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung5 kit) {
		return "Beschuetzer darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung10 kit) {
		return "Beschuetzer darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistungUnlimitiert kit) {
		return "Beschuetzer darf Software der Stufe 5 nicht verwenden";
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung1 kit) {
		return null;
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung5 kit) {
		return null;
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung10 kit) {
		return null;
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistungUnlimitiert kit) {
		return null;
	}
	@Override
	public String aenderungZuStufe5() {
		return null;
	}

	@Override
	public String checkAenderungStufe(SoftwareStufe vorgaengerStufe) {
		return vorgaengerStufe.aenderungZuStufe5();
	}
	
	@Override
	public String toString() {
		return "Software-Stufe 5";
	}
}
