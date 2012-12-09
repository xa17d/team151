import java.util.Iterator;

/**
 * Set das mehrere Traktoren speichern kann
 * @author Daniel
 */
public class TraktorSet implements Iterable<Traktor> {
	
	/**
	 * Internes Set in dem die Traktoren abgespeichert werden.
	 * Alle Elemente sind von Typ Traktor
	 */
	private Set set;
	
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
	 * Gibt einen Iterator fuer das TraktorSet zurueck
	 */
	public Iterator<Traktor> iterator() {
		return new TraktorSetIterator(set.iterator());
	}

	/**
	 * TraktorSet-Iterator. Wrapper fuer den Iterator des Sets.
	 * @author Daniel
	 */
	private class TraktorSetIterator implements Iterator<Traktor> {

		/**
		 * Erzeugt einen neuen TraktorSetIterator
		 * @param iterator Iterator der gewrapped werden soll (darf nicht null sein, alle Elemente muessen vom Typ Traktor sein)
		 */
		public TraktorSetIterator(Iterator<Object> iterator) {
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
		public Traktor next() {
			return (Traktor)iterator.next();
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
