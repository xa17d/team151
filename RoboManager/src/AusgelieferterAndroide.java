
public class AusgelieferterAndroide {
	private int seriennummer;
	private Androide androide;
	private Skin skin;
	private Software software;
	
	public AusgelieferterAndroide(int seriennummer, Androide androide, Skin skin, Software software) {
		this.seriennummer = seriennummer;
		this.androide = androide;
		this.skin = skin;
		this.software = software;
	}
	
	public int getSeriennummer() {
		return seriennummer;
	}
	
	@Override
	public String toString() {
		return "(" + seriennummer + ", " + androide.toString() + ", " + skin.toString() + ", " + software + ")"; 
	}
}