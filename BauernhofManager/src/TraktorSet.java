/**
 * Set das mehrere Traktoren speichern kann
 * @author Daniel
 */
public class TraktorSet {
	
	/**
	 * Internes Set in dem die Traktoren abgespeichert werden.
	 * Alle Elemente sind von Typ Traktor
	 */
	private Set set = new Set();
	
	/**
	 * Fuegt einen neuen Traktor in das Set ein
	 * @param item neuer Traktor
	 * @return true wenn der Traktor eingefuegt wurde, sonst false
	 */
	public boolean insert(Traktor item) {
		return set.insert(item); 
	}

	/**
	 * Entfernt einen Traktor aus dem Set
	 * @param item zu entfernender Traktor
	 * @return true wenn der Traktor entfernt wurde, false wenn sich dieser Traktor nicht im Set befindet
	 */
	public boolean remove(Traktor item) {
		return set.remove(item);
	}
	
	/**
	 * Traktor anhand seiner Nummer finden
	 * @param id Nummer des Traktors
	 * @return Traktor gesuchter Nummer, null falls der Traktor sich nicht im Set befindet
	 */
	public Traktor get(int id) {
		Set.Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Traktor traktor = (Traktor)iterator.next();
			if (traktor.getId() == id) {
				return traktor;
			}
		}

		return null;
	}
}
