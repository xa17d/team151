/**
 * Obertyp saemtlicher Androiden
 * @author Lucas
 */
public abstract class Androide {
	
	/**
	 * ueberprueft ob der Skin kompatibel mit dem Typ des Androiden ist
	 * @param skin (!=null)
	 * @return Fehlercode: falls Skin inkompatibel zum Androiden
	 * 		   null: falls Androide mit dieser Skin ausgeliefert werden kann
	 */
	public abstract String checkSkin(Skin skin);
	
	/**
	 * ueberprueft ob die Software-Stufe und das Aktoren-Kit kompatibel mit dem Typ des Androiden ist
	 * @param aktorenKit zu verwendendes AktorenKit (!=null)
	 * @param softwareStufe Stufe der Software (!=null)
	 * @return Fehlercode: falls Software-Stufe inkompatibel zum Androiden
	 * 		   null: falls Androide mit dieser Software und Aktoren-Kit ausgeliefert werden kann
	 */
	public abstract String checkAktorenKitSoftware(AktorenKit aktorenKit, SoftwareStufe softwareStufe);
	
	/**
	 * ueberprueft ob der Software-Typ mit dem Androiden kompatibel ist.
	 * @param software Software (!=null)
	 * @return Fehlercode: falls Software-Stufe inkompatibel zum Androiden
	 * 		   null: falls Androide mit dieser Software ausgeliefert werden kann
	 */
	public abstract String checkSoftware(Software software);
	
	/**
	 * Prueft ob der Typ des Vorgaengers dieses Androiden zum Typ dieses Androiden gaendert werden kann
	 * @param vorgaengerAndroide Vorgaenger Androide (!=null)
	 * @return Fehlercode: falls Typ nicht veraendert werden darf
	 * 		   null: falls Typ Aenderung zugelassen ist
	 */
	public abstract String checkAenderungTyp(Androide vorgaengerAndroide);
	
	/**
	 * Prueft ob der Typ dieses Androiden zu Bediener geaendert werden kann
	 * @return Fehlercode: falls Typ nicht veraendert werden darf
	 * 		   null: falls Typ Aenderung zugelassen ist
	 */
	protected String aenderungZuBediener() {
		return "Aenderung des Android-Typs nicht zulaessig";
	}
	
	/**
	 * Prueft ob der Typ dieses Androiden zu Bediener geaendert werden kann
	 * @return Fehlercode: falls Typ nicht veraendert werden darf
	 * 		   null: falls Typ Aenderung zugelassen ist
	 */
	protected String aenderungZuSchwerarbeiter() {
		return "Aenderung des Android-Typs nicht zulaessig";
	}
	
	/**
	 * Prueft ob der Typ dieses Androiden zu Bediener geaendert werden kann
	 * @return Fehlercode: falls Typ nicht veraendert werden darf
	 * 		   null: falls Typ Aenderung zugelassen ist
	 */
	protected String aenderungZuBeschuetzer() {
		return "Aenderung des Android-Typs nicht zulaessig";
	}
	
	/**
	 * erzeut einen String mit dem Typ-Namen des Androiden
	 * @return Androiden-Typ
	 */
	public abstract String toString();
}
