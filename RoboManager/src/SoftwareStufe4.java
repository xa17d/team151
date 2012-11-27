/**
 * stellt die Software der Stufe 4 dar
 * @author Lucas, Daniel
 */
public class SoftwareStufe4 extends SoftwareStufe {

	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung1 kit) {
		return "Bediener darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung5 kit) {
		return "Bediener darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung10 kit) {
		return "Bediener darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistungUnlimitiert kit) {
		return "Bediener darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung1 kit) {
		return "Gesellschafter darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung5 kit) {
		return "Gesellschafter darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung10 kit) {
		return "Gesellschafter darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistungUnlimitiert kit) {
		return "Gesellschafter darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung1 kit) {
		return null;
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung5 kit) {
		return null;
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung10 kit) {
		return null;
	}
	@Override
	public String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistungUnlimitiert kit) {
		return "Schwerarbeiter mit Software der Stufe 4 darf kein Aktoren-Kit >10kW besitzen";
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung1 kit) {
		return null;
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung5 kit) {
		return null;
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung10 kit) {
		return null;
	}
	@Override
	public String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistungUnlimitiert kit) {
		return "Beschuetzer mit Software der Stufe 4 darf kein Aktoren-Kit >10kW besitzen";
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung1 kit) {
		return "Kaempfer darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung5 kit) {
		return "Kaempfer darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung10 kit) {
		return "Kaempfer darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistungUnlimitiert kit) {
		return "Kaempfer darf Software der Stufe 4 nicht verwenden";
	}
	@Override
	public String aenderungZuStufe4() {
		return null;
	}
	
	@Override
	public String checkAenderungStufe(SoftwareStufe vorgaengerStufe) {
		return vorgaengerStufe.aenderungZuStufe4();
	}

	@Override
	public String toString() {
		return "Stufe 4";
	}
}
