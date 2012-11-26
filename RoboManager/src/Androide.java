/**
 * Obertyp saemtlicher Androiden
 * @author Lucas
 */
public abstract class Androide {
	
	/**
	 * ueberprueft ob der Skin kompatibel mit dem Typ des Androiden ist
	 * @param skin
	 * @return Fehlercode: falls Skin inkompatibel zum Androiden
	 * 		   null: falls Androide mit dieser Skin ausgeliefert werden kann
	 */
	public abstract String checkSkin(Skin skin);
	
	/**
	 * ueberprueft ob die Software-Stufe kompatibel mit dem Typ des Androiden ist
	 * @param softwareStufe Stufe der Software
	 * @return Fehlercode: falls Software-Stufe inkompatibel zum Androiden
	 * 		   null: falls Androide mit dieser Software ausgeliefert werden kann
	 */
	public abstract String checkSoftwareStufe(SoftwareStufe softwareStufe);

	
	public abstract String checkAktorenKit(AktorenKit aktorenKit, SoftwareStufe softwareStufe);
	
	/**
	 * erzeut einen String mit dem Typ-Namen des Androiden
	 * @return Androiden-Typ
	 */
	public abstract String toString();
}
