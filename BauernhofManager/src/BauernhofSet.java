/**
 * Set das mehrere Bauernhoefe speichern kann
 * @author Daniel
 */
public class BauernhofSet {
	/**
	 * Internes Set in dem die Bauernhoefe abgespeichert werden.
	 * Alle Elemente sind von Typ Bauernhof
	 */
	private Set set = new Set();
	
	/**
	 * Fuegt einen neuen Bauernhof in das Set ein
	 * @param item neuer Bauernhof
	 * @return true wenn der Bauernhof eingefuegt wurde, sonst false
	 */
	public boolean insert(Bauernhof item) {
		return set.insert(item); 
	}

	/**
	 * Entfernt einen Bauernhof aus dem Set
	 * @param item zu entfernender Bauernhof
	 * @return true wenn der Bauernhof entfernt wurde, false wenn sich dieser Bauernhof nicht im Set befindet
	 */
	public boolean remove(Bauernhof item) {
		return set.remove(item);
	}
	
	/**
	 * Bauernhof anhand seines Namens finden
	 * @param name Name des Bauernhofs
	 * @return Bauernhof mit gesuchtem Namen, null falls der Bauernhof sich nicht im Set befindet
	 */
	public Bauernhof get(String name) {
		Set.Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Bauernhof bauernhof = (Bauernhof)iterator.next();
			if (bauernhof.getName().equals(name)) {
				return bauernhof;
			}
		}

		return null;
	}
}
