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
		BauernhofFinderIteration i = new BauernhofFinderIteration(name);
		set.iterate(i);
		return i.getBauernhof();
	}
	
	/**
	 * Iteration Klasse die einen Bauernhof mit bestimmtem Namen sucht
	 * @author Daniel
	 */
	private class BauernhofFinderIteration extends Iteration {
		/**
		 * Konstruktor
		 * @param id Bauernhof-Name nach dem gesucht werden soll
		 */
		public BauernhofFinderIteration(String name) {
			this.name = name;
		}
		
		/**
		 * @see Iteration#iterationBauernhof(Bauernhof)
		 */
		@Override
		public void iterationBauernhof(Bauernhof item) {
			if (item.getName().equals(name)) {
				bauernhof = item;
			}
		}
		
		/**
		 * Name des gesuchten Bauernhofs
		 */
		private String name;
		/**
		 * enthaelt den gefundenen Bauernhof, null falls der Bauernhof (noch) nicht gefunden wurde
		 */
		private Bauernhof bauernhof = null;
		/**
		 * @return gefundener Bauernhof, null falls der Bauernhof nicht gefunden wurde
		 */
		public Bauernhof getBauernhof() { return bauernhof; }
	}
}
