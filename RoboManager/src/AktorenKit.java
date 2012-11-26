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
	public abstract String vonBedienerBenutzt(Bediener bediener);
	
	public abstract String vonSchwerarbeiterBenutzt(Schwerarbeiter schwerarbeiter, SoftwareStufe3 softwareStufe3);
	
	public abstract String vonSchwerarbeiterBenutzt(Schwerarbeiter schwerarbeiter, SoftwareStufe4 softwareStufe4);
	
	public abstract String vonLeibwaechterBenutzt(Leibwaechter leibwaechter);
	
	public abstract String vonObjektbewacherBenutzt(Objektbewacher objektbewacher);
	
	public abstract String vonKaempferBenutzt(Kaempfer kaempfer);
	
	/**
	 * erzeut einen String mit dem Namen des Skins
	 * @return Skin-Name
	 */
	public abstract String toString();
}
