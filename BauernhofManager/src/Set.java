/**
 * Container in dem verschiedene Objects abgelegt werden koennen.
 * Als verkettete Liste implementiert.
 * @author daniel
 */
public class Set {
	/**
	 * Konstruktor. Erstellt ein neues Set
	 */
	public Set() {
		first = new SetNode(null);
	}
	
	/**
	 * Node das auf das erste Element verweist (niemals null)
	 */
	private SetNode first;
	
	/**
	 * Fuegt ein neues Element in das Set ein, falls es nicht bereits im Set ist
	 * @param item neues Element (!=null)
	 * @return true wenn das Element eingefuegt wurde, false wenn sich das Element bereits im Set befindet
	 */
	public boolean insert(IteratableObject item) {
		SetNode current = first;
		
		//alle Elemente durchgehen, bis zum Letzten.
		while(current.getNext() != null)
		{
			current = current.getNext();
			
			if (current.getItem().equals(item)) { return false; }
		}
		
		//als neues Element einfuegen
		current.setNext(new SetNode(item));
		return true;
	}
	
	/**
	 * Entfernt ein Element aus dem Set
	 * @param item zu entfernendes Element
	 * @return true wenn das Element entfernt wurde, false wenn es nicht gefunden wurde
	 */
	public boolean remove(IteratableObject item) {
		SetNode current = first;
		SetNode previous;
		
		while(current.getNext() != null)
		{
			previous = current;
			current = current.getNext();
			
			if (current.getItem().equals(item)) {
				previous.setNext(current.getNext());
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Ruft fuer jedes Element im Set die Methode iteration.iteration(...) auf.
	 * @param iteration Iteration-Instanz dessen iteration(...) Methode aufgerufen werden soll.
	 */
	public void iterate(Iteration iteration)
	{
		SetNode current = first.getNext();

		while(current != null)
		{
			iteration.iteration(current.getItem());
			current = current.getNext();
		}
	}
	
	/**
	 * innere Klasse SetNode implementiert die Knotenpunkte des Sets
	 */
	private class SetNode {
		private SetNode next;
		private IteratableObject item;
		
		/**
		 * Erstellt ein neues Node
		 * @param item Element
		 */
		public SetNode(IteratableObject item) {
			next = null;
			this.item = item;
		}
		
		/**
		 * liefert den naechsten Knoten
		 * @return naechster Knoten
		 */
		public SetNode getNext() { 
			return next;
		}
		
		/**
		 * naechsten Knoten definieren
		 * @param next naechster Knoten
		 */
		public void setNext(SetNode next) {
			this.next = next; 
		}
		
		/**
		 * leifert Element des Knotens
		 * @return Element
		 */
		public IteratableObject getItem() {
			return item;
		}
	}
	
	/**
	 * Listet alle Elemente des Sets als String auf
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		SetNode current = first.getNext();
		while(current != null)
		{
			s.append(current.getItem() + "\n");
			current = current.getNext();
		}
		
		return s.toString();
	}
}