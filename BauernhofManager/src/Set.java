import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Container in dem verschiedene Objects abgelegt werden koennen.
 * Als verkettete Liste implementiert.
 * @author daniel
 */
public class Set implements Iterable<Object> {
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
	 * Fuegt ein neues Element in das Set ein
	 * @param item neues Element
	 * @return true wenn das Element eingefuegt wurde, sonst false
	 */
	public boolean insert(Object item) {
		SetNode current = first;
		
		//alle Elemente durchgehen, bis zum Letzten.
		while(current.getNext() != null)
		{
			current = current.getNext();
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
	public boolean remove(Object item) {
		Iterator<Object> setIterator = iterator();
		while (setIterator.hasNext()) {
			Object i = setIterator.next();
			
			if (i.equals(item)) {
				setIterator.remove();
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * liefert neuen Iterator
	 */
	public Iterator<Object> iterator() {
		return new SetIterator(this);
	}
	
	/**
	 * innere Klasse SetIterator
	 * implementiert den Iterator
	 */
	private class SetIterator implements Iterator<Object> {
		/**
		 * Aktuelle Position des Iterators
		 */
		private SetNode pointer;
		
		/**
		 * Konstruktor
		 */
		public SetIterator(Set set) {
			pointer = set.first;
		}
		
		/**
		 * abfrage ob es ein naechstes Element im Set gibt
		 * @return true: es gibt ein weiteres Element - false: letztes Element in Set
		 */
		public boolean hasNext() {
			if(pointer.getNext() != null)
				return true;
			else
				return false;
		}
		
		/**
		 * liefert naechstes Element aus dem Set
		 * @return Element
		 */
		public Object next() {
			Object temp;
			if(pointer.getNext() != null)
			{
				temp = pointer.getNext().getItem();
				pointer = pointer.getNext();
				return temp;
			}
			else
				throw new NoSuchElementException();
		}
		
		/**
		 * Loescht aktuelles Element aus dem Set
		 */
		public void remove() {
			pointer.setNext(pointer.getNext().getNext());
		}
	}
	
	/**
	 * innere Klasse SetNode implementiert die Knotenpunkte des Sets
	 */
	private class SetNode {
		private SetNode next;
		private Object item;
		
		/**
		 * Erstellt ein neues Node
		 * @param item Element
		 */
		public SetNode(Object item) {
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
		public Object getItem() {
			return item;
		}
	}
}