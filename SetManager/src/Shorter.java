
public interface Shorter<T> {
	/**
	 * Ueberprueft welches Objekt kuerzer ist.
	 * @param other Vergleichsobjekt
	 * @return Gibt die genau dann true zurueckgibt, wenn this kuerzer als other ist.
	 */
	boolean shorter(T other); 
}
