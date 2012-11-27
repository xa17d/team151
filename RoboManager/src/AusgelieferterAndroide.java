/**
 * stellt einen ausgelieferten Androiden dar
 * @author Lucas
 */
public class AusgelieferterAndroide {
	private int seriennummer;
	private Androide androide;
	private Skin skin;
	private Software software;
	private AktorenKit aktorenKit;
	
	//TODO weitere Parameter speichern
	/**
	 * Konstruktor
	 * @param seriennummer Seriennummer
	 * @param androide Androide (!=null)
	 * @param skin Skin-Typ (!=null)
	 * @param software Software (!=null)
	 */
	public AusgelieferterAndroide(int seriennummer, Androide androide, Skin skin, Software software, AktorenKit aktorenKit) {
		this.seriennummer = seriennummer;
		this.androide = androide;
		this.skin = skin;
		this.software = software;
		this.aktorenKit = aktorenKit;
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
	 * liefert einen lesbaren String mit allen Parametern des ausgelieferten Androiden
	 * @return ausgelieferter Androide
	 */
	@Override
	public String toString() {
		return "(" + seriennummer + ", " + androide.toString() + ", " + skin.toString() + ", " + software.toString() + "," + aktorenKit.toString() + ")"; 
	}
}