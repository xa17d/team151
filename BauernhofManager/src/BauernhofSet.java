import java.util.Iterator;

/**
 * Set das mehrere Bauernhoefe speichern kann
 * @author Daniel
 */
public class BauernhofSet implements Iterable<Bauernhof> {
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
	 * Gibt einen Iterator fuer das BaurnhofSet zurueck
	 */
	public Iterator<Bauernhof> iterator() {
		return new BauernhofSetIterator(set.iterator());
	}
	
	/**
	 * Bauernhof anhand seines Namens finden
	 * @param name Name des Bauernhofs
	 * @return Bauernhof mit gesuchtem Namen, null falls der Bauernhof sich nicht im Set befindet
	 */
	public Bauernhof get(String name) {
		for (Bauernhof bauernhof : this) {
			if (bauernhof.getName().equals(name)) {
				return bauernhof;
			}
		}
		return null;
	}

	/**
	 * BauernhofSet-Iterator. Wrapper fuer den Iterator des Sets.
	 * @author Daniel
	 */
	private class BauernhofSetIterator implements Iterator<Bauernhof> {

		/**
		 * Erzeugt einen neuen BauernhofSetIterator
		 * @param iterator Iterator der gewrapped werden soll (darf nicht null sein, alle Elemente muessen vom Typ Bauernhof sein)
		 */
		public BauernhofSetIterator(Iterator<Object> iterator) {
			this.iterator = iterator;
		}
		
		/**
		 * Iterator der gewrapped wird (niemals null)
		 */
		private Iterator<Object> iterator;

		/**
		 * @see Iterator.hasNext()
		 */
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		/**
		 * @see Iterator.next()
		 */
		@Override
		public Bauernhof next() {
			return (Bauernhof)iterator.next();
		}

		/**
		 * @see Iterator.remove()
		 */
		@Override
		public void remove() {
			iterator.remove();
		}
		
	}
}
