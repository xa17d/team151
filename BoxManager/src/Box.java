/**
 * Stellt aus druckbaren Zeichen geformte Rechtecke dar. 
 * @author Raphae Kamper
 */
public class Box implements Pict{
	private double height;
	private double width;
	private char border;
	private char content;
	
	/**
	 * Konstruktor
	 * @param height > 0
	 * @param width > 0
	 * @param border darf kein Leerzeichen sein.
	 * @param content
	 */
	public Box(double height, double width, char border, char content) {
		this.height = height;
		this.width = width;
		this.border = border;
		this.content = content;
	}

	/**
	 * multipliziert die Seitenlaengen mit dem als Parameter uebergebenen Faktor. 
	 * Erst bei Umformung in eine Zeichenkette durch toString werden Hoehe und
	 * Breite auf ganze Zahlen aufgerundet (also in Richtung groesserer Zahlen).
	 * @param factor > 0
	 */
	@Override
	public void scale(double factor) {
		height *= factor;
		width *= factor;
	}
	
	/**
	 * @return Liefert die Box zeilenweise (pro ganzzahlige height eine Zeile)
	 * als String height und width werden aufgerundet.
	 * mindestens die Raender also eine 2 x 2 Box
	 */
	@Override
	public String toString(){
		String ret = "";
		for(int i = 0; i <= Math.ceil(getHeight());i++){
			for(int j = 0; j <= Math.ceil(getWidth());j++){
				if(i == 0 || i == Math.ceil(getHeight())) //erste Zeile || letzte Zeile
					ret += border;
				else if (i != 0 && (j == 0 || j == Math.ceil(getWidth()))) //Rand links und rechts
					ret += border;
				else
					ret += content;
			}
			ret += "\n";
		}
		return ret;
	}

	/**
	 * Getter
	 * @return height > 0
	 */
	protected double getHeight() {
		return height;
	}
	
	/**
	 * Getter
	 * @return width > 0
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Setter
	 * @param content != ' '
	 */
	protected void setContent(char content){
		this.content = content;
	}
	
	/**
	 * Setter
	 * @param border != ' '
	 */
	protected void setBorder(char border){
		this.border = border;
	}
}
