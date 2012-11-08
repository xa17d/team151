/**
 * Das Zeichen fuer den Inhalt enspricht stets dem Zeichen fuer
 * die Raender. Zusaetzlich gibt es eine Moeglichkeit, dieses
 * Zeichen jederzeit zu aendern.
 * @author Raphael Kamper
 *
 */
public class DarkBox extends Box {

	/**
	 * Konstruktor
	 * 
	 * @param height > 0
	 * @param width > 0
	 * @param symbol != ' '
	 */
	public DarkBox(double height, double width, char symbol) {
		super(height, width, symbol, symbol);
	}
	
	/**
	 * Setzt das Zeichen fuer die komplette Box
	 * @param symbol != ' '
	 */
	protected void setSign(char symbol){
		setBorder(symbol);
		setContent(symbol);
	}	
}
