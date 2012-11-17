import java.lang.Iterable;
import java.util.*;
/**
 * implementiert Set
 * @author Lucas
 * @param <T>
 */
public class Set<T> implements Iterable<T> {
	private SetNode first;
	
	/**
	 * Konstruktor
	 */
	public Set() {
		first = new SetNode(null);
	}
	
	public boolean insert(T t) {
		SetNode current = first;
		
		//alle Elemente durchgehen, bis zum Letzten
		while(current.getNext() != null)
		{
			current = current.getNext();
			if(current.getItem().equals(t))
				return false;
		}
		
		//wenn nich Identisch, als neues Element einfuegen
		current.setNext(new SetNode(t));
		return true;
	}
	
	/**
	 * liefert neuen Iterator
	 */
	public Iterator<T> iterator() {
		return new SetIterator();
	}
	
	/**
	 * innere Klasse SetIterator
	 * implementiert den Iterator
	 * @author Lucas
	 * @param <E>
	 */
	private class SetIterator implements Iterator<T> {
		private SetNode pointer;
		
		/**
		 * Konstruktor
		 */
		public SetIterator() {
			pointer = first;
		}
		
		/**
		 * abfrage ob es ein naechstes Element gibt
		 * @return true: es gibt ein weiteres Element - false: letztes Element in Liste
		 */
		public boolean hasNext() {
			if(pointer.getNext() != null)
				return true;
			else
				return false;
		}
		
		/**
		 * liefert naechstes Element
		 * @return Element vom Typ E
		 */
		public T next() {
			T temp;
			if(pointer.getNext() != null)
			{
				temp = pointer.getNext().getItem();
				remove();
				return temp;
			}
			else
				throw new NoSuchElementException();
		}
		
		/**
		 * streicht aktuelles Element von der Iterator-Liste
		 */
		public void remove() {
			pointer = pointer.getNext();
		}
	}
	
	/**
	 * innere Klasse SetNode implementiert die Knotenpunkte des Sets
	 * @author Lucas
	 */
	private class SetNode {
		SetNode next;
		T item;
		
		public SetNode(T item) {
			next = null;
			setItem(item);
		}
		
		public SetNode getNext() { 
			return next;
		}
		
		public void setNext(SetNode next) {
			this.next = next; 
		}
		
		public T getItem() {
			return item;
		}
		
		private void setItem(T item) {
			this.item = item; 
		}
	}
}
