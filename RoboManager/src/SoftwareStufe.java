/**
 * Obertyp saemtlicher Software-Stufen
 * @author Lucas
 */
public abstract class SoftwareStufe {
	
	/**
	 * ueberprueft ob Software-Stufe von einem Bediener verwendet werden darf
	 * @param bediener Bediener
	 * @return Fehlercode: falls Software-Stufe von Bediener nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerVerwendet(Bediener bediener);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Gesellschafter verwendet werden darf
	 * @param gesellschafter Gesellschafter
	 * @return Fehlercode: falls Software-Stufe von Gesellschafter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterVerwendet(Gesellschafter gesellschafter);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Schwerarbeiter verwendet werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Software-Stufe von Schwerarbeiter nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterVerwendet(Schwerarbeiter schwerarbeiter);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Beschuetzer verwendet werden darf
	 * @param beschuetzer Beschuetzer
	 * @return Fehlercode: falls Software-Stufe von Beschuetzer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerVerwendet(Beschuetzer beschuetzer);
	
	/**
	 * ueberprueft ob Software-Stufe von einem Kaempfer verwendet werden darf
	 * @param kaempfer Kaempfer
	 * @return Fehlercode: falls Software-Stufe von Kaempfer nicht verwendet werden darf
	 * 		   null: falls Software-Stufe fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferVerwendet(Kaempfer kaempfer);
	
	/**
	 * erzeut einen String mit der Stufe der Software
	 * @return Stufe der Software
	 */
	public abstract String toString();
}
