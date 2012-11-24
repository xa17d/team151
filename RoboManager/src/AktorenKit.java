/**
 * stellt Obertyp aller AktorenKits dar.
 * @author raphael, lucas
 */
public abstract class AktorenKit {

	/**
	 * ueberprueft ob Skin von einem Bediener getragen werden darf
	 * @param bediener Bediener
	 * @return Fehlercode: falls Skin von Bediener nicht getragen werden darf
	 * 		   null: falls Skin fuer einen Bediener zugelassen ist
	 */
	public abstract String vonAndroidSoftwareStufe1(SoftwareStufe1 softwareStufe1);
		
	public abstract String vonAndroidSoftwareStufe2(SoftwareStufe2 softwareStufe2);
	
	public abstract String vonAndroidSoftwareStufe3(SoftwareStufe3 softwareStufe3);
	
	public abstract String vonAndroidSoftwareStufe4(SoftwareStufe4 softwareStufe4);
	
	public abstract String vonAndroidSoftwareStufe5(SoftwareStufe5 softwareStufe5);
	
	
	/**
	 * erzeut einen String mit dem Namen des Skins
	 * @return Skin-Name
	 */
	public abstract String toString();
}
