/**
 * Ein aus druckbaren Zeichen geformtes Rechteck mit fixem Seitenverhaeltnis, das nur durch scale geaendert werden kann.
 * Alle Zeichen des gesamten Rechtecks werden durch Uebergabe eines (rechteckigen) Textes an den Konstruktor gesetzt.
 * Die anfaengliche Hoehe und Breite ergeben sich aus diesem Text. Aufrufe von scale aendern die Seitenlaengen, ohne
 * jedoch den Text selbst zu aendern.
 * @author daniel
 *
 */
public class FreeBox implements Pict {
	/**
	 * Konstruktor
	 * @param body rechteckiger Text der den Koerper der Box darstellt. Die anfaengliche Groesse der Box ergiebt sich aus diesem Text.
	 */
	public FreeBox(String body) {
		
		this.body = new Repeated<String>(
				new String[][] {
						new String[] { body }
				}
			);
	}
	
	/**
	 * body rechteckiger Text der den Koerper der Box darstellt
	 */
	Repeated<String> body;
	
	/**
	 * resize the picture
	 * @param factor 0.1 <= factor <= 10.0
	 */
	public void scale(double factor) {
		body.scale(factor);
	}
	
	/**
	 * Gibt die Box als Text zurueck. Falls die aktuellen Seitenlaengen kleiner sind als der Text, gibt toString
     * nur das linke obere Eck des Textes in der entsprechenden Groesse (aufgerundet) zurueck. Bei groesseren
	 * Seitenlaengen wird der Text so oft wie noetig neben- bzw. uebereinandergestellt. 
	 */
	@Override
	public String toString() {
		return body.toString();
	}
}
