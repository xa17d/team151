/**
 * als Zeichen fuer die Raender wird immer * verwendet und fuer den 
 * Inhalt das Leerzeichen. Zusaetzlich gibt es eine Moeglichkeit,
 * das Seitenverhaeltnis abzufragen (Breite dividiert durch Hoehe).
 * @author Raphael Kamper
 *
 */
public class ClearBox extends Box {

	/**
	 * Konstruktor
	 * border = *
	 * content = Leerzeichen
	 * @param height > 0
	 * @param width > 0
	 */
	public ClearBox(double height, double width) {
		super(height, width, '*', ' ');
	}
	
	/**
	 * Berechnet das Seitenverhaeltnis
	 * @return widht/height
	 */
	protected double delta(){
		return getWidth()/getHeight();
	}
	
}
