/**
 * Description ist ein Untertyp von Shorter, der einen beschreibenden Text darstellt. Der Text wird im Konstruktor gesetzt und durch toString ausgelesen.
 */
public class Description implements Shorter<Description> {

	/**
	 * Initialisiert ein neues Description-Objekt mit einem dem beschreibenden Text
	 * @param text beschreibender Text (!=null)
	 */
	public Description(String text)
	{
		this.text = text;
	}
	
	private String text;
	
	/**
	 * Ein Vergleich mit shorter vergleicht die Texte anhand ihrer Laengen in Zeichen. Es gibt eine Methode um die Anzahl der Zeilen zu ermitteln.
	 * @see Shorter#shorter(java.lang.Object)
	 */
	@Override
	public boolean shorter(Description other) {
		return (text.length() < other.text.length());
	}

	/**
	 * Gibt den beschreibenden Text zurueck
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
