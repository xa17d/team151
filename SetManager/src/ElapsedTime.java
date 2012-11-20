/**
 * stellt die gemessene Zeit eines Vorgangs dar
 * @author Lucas
 * @param <T> Typ T ist Untertyp von ElapsedTime
 */
public abstract class ElapsedTime<T> implements Shorter<T> {
	
	/**
	 * vergleicht die laenge des Objekts mit einem anderen Objekt
	 * @param that zu vergleichendes Objekt
	 * @return ob Objekt kuerzer ist als zu vergleichendes Objekt
	 */
	public abstract boolean shorter(T that);
	
	/**
	 * liefert Anzahl der Elemente
	 * @return Anzahl der Elemente
	 */
	public abstract int count();
	
}
