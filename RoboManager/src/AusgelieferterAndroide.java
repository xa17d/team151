/**
 * stellt einen ausgelieferten Androiden dar
 * @author Lucas
 */
public class AusgelieferterAndroide {
	/**
	 * Seriennummer
	 */
	private int seriennummer;
	/**
	 * Androide (niemals null)
	 */
	private Androide androide;
	/**
	 * Skin des Androiden (niemals null)
	 */
	private Skin skin;
	/**
	 * Software des Androiden (niemals null)
	 */
	private Software software;
	/**
	 * Sensor-Aktor-Kit des Androiden (niemals null)
	 */
	private AktorenKit aktorenKit;
	/**
	 * Vorgaenger dieses Ausgelieferten-Androiden, null falls es keinen Vorgaenger gibt.
	 */
	private AusgelieferterAndroide vorgaenger;
	
	//TODO weitere Parameter speichern
	/**
	 * Konstruktor
	 * @param seriennummer Seriennummer
	 * @param androide Androide (!=null)
	 * @param skin Skin-Typ (!=null)
	 * @param software Software (!=null)
	 */
	public AusgelieferterAndroide(int seriennummer, Androide androide, Skin skin, Software software, AktorenKit aktorenKit, AusgelieferterAndroide vorgaenger) {
		this.seriennummer = seriennummer;
		this.androide = androide;
		this.skin = skin;
		this.software = software;
		this.aktorenKit = aktorenKit;
		this.vorgaenger = vorgaenger;
	}
	
	/**
	 * liefert die Seriennummer des ausgelieferten Androiden
	 * @return Seriennummer
	 */
	public int getSeriennummer() {
		return seriennummer;
	}
	
	/**
	 * liefert den Androiden
	 * @return Androide (!=null)
	 */
	public Androide getAndroide() {
		return androide;
	}
	
	/**
	 * liefert die Software
	 * @return Software (!=null)
	 */
	public Software getSoftware() {
		return software;
	}
	
	/**
	 * Gibt den Vorgaenger dieses Ausgelieferten-Androiden zurueck, falls es keinen Vorgaenger gibt, wir null zurueckgegeben.
	 * @return Vorgaenger oder null wenn es kein Vorgaenger gibt
	 */
	public AusgelieferterAndroide getVorgaenger() {
		return vorgaenger;
	}
	
	/**
	 * liefert einen lesbaren String mit allen Parametern des ausgelieferten Androiden
	 * @return ausgelieferter Androide
	 */
	@Override
	public String toString() {
		return "(" + seriennummer + ", " + androide.toString() + ", " + skin.toString() + ", " + software.toString() + ", " + aktorenKit.toString() + ")"; 
	}
}