/**
 * stellt Obertyp aller AktorenKits dar.
 * @author raphael, lucas
 */
public abstract class AktorenKit {

	/**
	 * ueberprueft ob AktorenKit von einem Bediener mit bestimmter Software werden darf
	 * @param bediener Bediener
	 * @param softwareStufe SoftwareStufe
	 * @return Fehlercode: falls AktorenKit nicht von Bediener mit dieser SoftwareStufe verwendet werden darf
	 * 		   null: falls AktorenKit-Leistung fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerBenutzt(Bediener bediener, SoftwareStufe softwareStufe);
	
	/**
	 * ueberprueft ob AktorenKit von einem Gesellschafter mit bestimmter Software werden darf
	 * @param bediener Bediener
	 * @param softwareStufe SoftwareStufe
	 * @return Fehlercode: falls AktorenKit nicht von Gesellschafter mit dieser SoftwareStufe verwendet werden darf
	 * 		   null: falls AktorenKit-Leistung fuer einen Gesellschafter zugelassen ist
	 */
	public abstract String vonGesellschafterBenutzt(Gesellschafter gesellschafter, SoftwareStufe softwareStufe);
	
	/**
	 * ueberprueft AktorenKit von einem Schwerarbeiter mit bestimmter Software werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @param softwareStufe SoftwareStufe
	 * @return Fehlercode: falls AktorenKit nicht von Schwerarbeiter mit dieser SoftwareStufe verwendet werden darf
	 * 		   null: falls AktorenKit-Leistung fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterBenutzt(Schwerarbeiter schwerarbeiter, SoftwareStufe softwareStufe);
	
	/**
	 * ueberprueft AktorenKit von einem Beschuetzer mit bestimmter Software werden darf
	 * @param beschuetzer Beschuetzer
	 * @param softwareStufe SoftwareStufe
	 * @return Fehlercode: falls AktorenKit nicht von Beschuetzer mit dieser SoftwareStufe verwendet werden darf
	 * 		   null: falls AktorenKit-Leistung fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerBenutzt(Beschuetzer beschuetzer, SoftwareStufe softwareStufe);
	
	/**
	 * ueberprueft AktorenKit von einem Kaempfer mit bestimmter Software werden darf
	 * @param kaempfer Kaempfer
	 * @param softwareStufe SoftwareStufe
	 * @return Fehlercode: falls AktorenKit nicht von Kaempfer mit dieser SoftwareStufe verwendet werden darf
	 * 		   null: falls AktorenKit-Leistung fuer einen Kaempfer zugelassen ist
	 */
	public abstract String vonKaempferBenutzt(Kaempfer kaempfer, SoftwareStufe softwareStufe);
	
	/**
	 * erzeut einen String mit dem Namen des Skins
	 * @return Skin-Name
	 */
	public abstract String toString();
}
