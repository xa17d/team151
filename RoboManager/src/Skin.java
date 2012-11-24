/**
 * stellt Obertyp aller Skins dar
 * @author Lucas
 */
public abstract class Skin {
	
	/**
	 * ueberprueft ob Skin von einem Bediener getragen werden darf
	 * @param bediener Bediener
	 * @return Fehlercode: falls Skin von Bediener nicht getragen werden darf
	 * 		   null: falls Skin fuer einen Bediener zugelassen ist
	 */
	public abstract String vonBedienerGetragen(Bediener bediener);
	
	/**
	 * ueberprueft ob Skin von einem Schwerarbeiter getragen werden darf
	 * @param schwerarbeiter Schwerarbeiter
	 * @return Fehlercode: falls Skin von Schwerarbeiter nicht getragen werden darf
	 * 		   null: falls Skin fuer einen Schwerarbeiter zugelassen ist
	 */
	public abstract String vonSchwerarbeiterGetragen(Schwerarbeiter schwerarbeiter);
	
	/**
	 * ueberprueft ob Skin von einem Beschuetzer getragen werden darf
	 * @param beschuetzer Beschuetzer
	 * @return Fehlercode: falls Skin von Beschuetzer nicht getragen werden darf
	 * 		   null: falls Skin fuer einen Beschuetzer zugelassen ist
	 */
	public abstract String vonBeschuetzerGetragen(Beschuetzer beschuetzer);
	
	/**
	 * erzeut einen String mit dem Namen des Skins
	 * @return Skin-Name
	 */
	public abstract String toString();
}
