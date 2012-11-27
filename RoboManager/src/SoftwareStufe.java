/**
 * Obertyp saemtlicher Software-Stufen
 * @author Lucas, Daniel
 */
public abstract class SoftwareStufe {
	
	/**
	 * ueberprueft ob Software-Stufe von einem Bediener mit AktorenKitLeistung1 verwendet werden darf
	 * @param bediener Bediener (darf kein Gesellschafter sein)
	 * @return Fehlercode: falls Software-Stufe von Bediener nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung1 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Bediener mit AktorenKitLeistung5 verwendet werden darf
	 * @param bediener Bediener (darf kein Gesellschafter sein)
	 * @return Fehlercode: falls Software-Stufe von Bediener nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung5 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Bediener mit AktorenKitLeistung10 verwendet werden darf
	 * @param bediener Bediener (darf kein Gesellschafter sein)
	 * @return Fehlercode: falls Software-Stufe von Bediener nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistung10 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Bediener mit AktorenKitLeistungUnlimitiert verwendet werden darf
	 * @param bediener Bediener (darf kein Gesellschafter sein)
	 * @return Fehlercode: falls Software-Stufe von Bediener nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerVerwendet(Bediener bediener, AktorenKitLeistungUnlimitiert kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Gesellschafter mit AktorenKitLeistung1 verwendet verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software-Stufe von Gesellschafter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung1 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Gesellschafter mit AktorenKitLeistung5 verwendet verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software-Stufe von Gesellschafter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung5 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Gesellschafter mit AktorenKitLeistung10 verwendet verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software-Stufe von Gesellschafter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistung10 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Gesellschafter mit AktorenKitLeistungUnlimitiert verwendet verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software-Stufe von Gesellschafter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterVerwendet(Gesellschafter gesellschafter, AktorenKitLeistungUnlimitiert kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Schwerarbeiter mit AktorenKitLeistung1 verwendet werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Software-Stufe von Schwerarbeiter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung1 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Schwerarbeiter mit AktorenKitLeistung5 verwendet werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Software-Stufe von Schwerarbeiter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung5 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Schwerarbeiter mit AktorenKitLeistung10 verwendet werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Software-Stufe von Schwerarbeiter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistung10 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Schwerarbeiter mit AktorenKitLeistungUnlimitiert verwendet werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Software-Stufe von Schwerarbeiter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter, AktorenKitLeistungUnlimitiert kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Beschuetzer mit AktorenKitLeistung1 verwendet werden darf
	 * @param beschuetzer Beschuetzer (darf kein Kaempfer sein)
	 * @return Fehlercode: falls Software-Stufe von Beschuetzer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung1 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Beschuetzer mit AktorenKitLeistung5 verwendet werden darf
	 * @param beschuetzer Beschuetzer (darf kein Kaempfer sein)
	 * @return Fehlercode: falls Software-Stufe von Beschuetzer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung5 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Beschuetzer mit AktorenKitLeistung10 verwendet werden darf
	 * @param beschuetzer Beschuetzer (darf kein Kaempfer sein)
	 * @return Fehlercode: falls Software-Stufe von Beschuetzer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistung10 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Beschuetzer mit AktorenKitLeistungUnlimitiert verwendet werden darf
	 * @param beschuetzer Beschuetzer (darf kein Kaempfer sein)
	 * @return Fehlercode: falls Software-Stufe von Beschuetzer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerVerwendet(Beschuetzer beschuetzer, AktorenKitLeistungUnlimitiert kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Kaempfer mit AktorenKitLeistung1 verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software-Stufe von Kaempfer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung1 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Kaempfer mit AktorenKitLeistung5 verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software-Stufe von Kaempfer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung5 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Kaempfer mit AktorenKitLeistung10 verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software-Stufe von Kaempfer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistung10 kit);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Kaempfer mit AktorenKitLeistungUnlimitiert verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software-Stufe von Kaempfer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferVerwendet(Kaempfer kaempfer, AktorenKitLeistungUnlimitiert kit);
	
	
	/**
	 * Prueft ob die Stufe des Vorgaengers dieser Stufe zu dieser Stufe gaendert werden kann
	 * @param vorgaengerStufe Vorgaenger Stufe (!=null)
	 * @return Fehlercode: falls Stufe nicht veraendert werden darf
	 * 		   null: falls Stufen-Aenderung zugelassen ist
	 */
	public abstract String checkAenderungStufe(SoftwareStufe vorgaengerStufe);
	
	/**
	 * Prueft ob diese Software-Stufe zu Stufe 1 veraendert werden kann
	 * @return Fehlercode: falls Software-Stufe nicht veraendert werden darf
	 * 		   null: falls Software-Stufen Aenderung zugelassen ist
	 */
	public String aenderungZuStufe1() {
		return "Stufe kann nicht veraendert werden";
	}
	
	/**
	 * Prueft ob diese Software-Stufe zu Stufe 2 veraendert werden kann
	 * @return Fehlercode: falls Software-Stufe nicht veraendert werden darf
	 * 		   null: falls Software-Stufen Aenderung zugelassen ist
	 */
	public String aenderungZuStufe2() {
		return "Stufe kann nicht veraendert werden";
	}
	
	/**
	 * Prueft ob diese Software-Stufe zu Stufe 3 veraendert werden kann
	 * @return Fehlercode: falls Software-Stufe nicht veraendert werden darf
	 * 		   null: falls Software-Stufen Aenderung zugelassen ist
	 */
	public String aenderungZuStufe3() {
		return "Stufe kann nicht veraendert werden";
	}
	
	/**
	 * Prueft ob diese Software-Stufe zu Stufe 4 veraendert werden kann
	 * @return Fehlercode: falls Software-Stufe nicht veraendert werden darf
	 * 		   null: falls Software-Stufen Aenderung zugelassen ist
	 */
	public String aenderungZuStufe4() {
		return "Stufe kann nicht veraendert werden";
	}
	
	/**
	 * Prueft ob diese Software-Stufe zu Stufe 5 veraendert werden kann
	 * @return Fehlercode: falls Software-Stufe nicht veraendert werden darf
	 * 		   null: falls Software-Stufen Aenderung zugelassen ist
	 */
	public String aenderungZuStufe5() {
		return "Stufe kann nicht veraendert werden";
	}
	
	/**
	 * erzeut einen String mit der Stufe der Software
	 * @return Stufe der Software
	 */
	public abstract String toString();
}
