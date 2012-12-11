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
	 * Ruft fuer jedes Element im Set die Methode iteration.iteration(...) auf.
	 * @param iteration Iteration-Instanz dessen iteration(...) Methode aufgerufen werden soll.
	 */
	public void iterate(Iteration iteration) {
		set.iterate(iteration);
	}
	
	/**
	 * Traktor anhand seiner Nummer finden
	 * @param id Nummer des Traktors
	 * @return Traktor gesuchter Nummer, null falls der Traktor sich nicht im Set befindet
	 */
	public Traktor get(int id) {
		TraktorFinderIteration i = new TraktorFinderIteration(id);
		set.iterate(i);
		return i.getTraktor();
	}
	
	/**
	 * Iteration Klasse die einen Traktor mit bestimmter ID sucht
	 * @author Daniel
	 */
	private class TraktorFinderIteration extends Iteration {
		/**
		 * Konstruktor
		 * @param id Traktor-ID nach der gesucht werden soll
		 */
		public TraktorFinderIteration(int id) {
			this.id = id;
		}
		
		/**
		 * @see Iteration#iterationTraktor(Traktor)
		 */
		@Override
		public void iterationTraktor(Traktor item) {
			if (item.getId() == id) {
				traktor = item;
			}
		}
		
		/**
		 * Id des gesuchten Traktors
		 */
		private int id;
		/**
		 * enthaelt den gefundenen Traktor, null falls der Traktor (noch) nicht gefunden wurde
		 */
		private Traktor traktor = null;
		/**
		 * @return gefundener Traktor, null falls der Traktor nicht gefunden wurde
		 */
		public Traktor getTraktor() { return traktor; }
	}
	
	/**
	 * Listet alle Elemente des Sets als String auf
	 */
	@Override
	public String toString() {
		return set.toString();
	}
}
