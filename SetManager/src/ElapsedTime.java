/**
 * stellt die gemessene Zeit eines Vorgangs dar
 * @author Lucas
 * @param <T> Typ T ist Untertyp von ElapsedTime
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime> {
	
	/**
	 * vergleicht die laenge des Objekts mit einem anderen Objekt
	 * @param that zu vergleichendes Objekt
	 * @return ob Objekt kuerzer ist als zu vergleichendes Objekt
	 */
	public boolean shorter(ElapsedTime that) {
		return (time() < that.time());
	}
	
	/**
	 * gibt die Zeit zurueck mit der der shorter-Vergleich
	 * durchgefuert werden soll
	 * @return Zeit fuer den Vergleich
	 */
	protected abstract double time();
	
	/**
	 * liefert Anzahl der Elemente
	 * @return Anzahl der Elemente
	 */
	public abstract int count();
	
}