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
		
		//erstes Element einfuegen ohne Ueberpruefung auf Gleichheit
		if(current.getItem() == null)
		{
			current.setNext(new SetNode(t));
			return true;
		}
		
		//alle anderen Elemente durchgehen, bis zum Letzten
		while(current.getNext() != null)
		{
			if(current.getItem().equals(t))
				return false;
			
			current = current.getNext();
		}
		
		//wenn nich Gleich, als neues Element einfuegen
		if(current.getItem().equals(t))
			return false;
		else
		{
			current.setNext(new SetNode(t));
			return true;
		}
	}
	
	/**
	 * ruft neuen Iterator auf
	 */
	public Iterator<T> iterator() {
		return new SetIterator<T>();
	}
	
	/**
	 * innere Klasse SetIterator
	 * implementiert den Iterator
	 * @author Lucas
	 * @param <E>
	 */
	private class SetIterator<E> implements Iterator<E> {
		private SetNode current;
		
		/**
		 * Konstruktor
		 */
		public SetIterator() {
			current = first;
		}
		
		/**
		 * abfrage ob es ein naechstes Element gibt
		 */
		public boolean hasNext() {
			if(current.getNext() != null)
				return true;
			else
				return false;
		}
		
		/**
		 * liefert naechstes Element
		 */
		public E next() {
			T temp;
			if(current.getNext() != null)
			{
				temp = current.getNext().getItem();
				remove();
				//TODO typecast umgehen
				return (E) temp;
			}
			else
				throw new NoSuchElementException();
		}
		
		/**
		 * "loescht" letztes Element von der Liste
		 */
		public void remove() {
			current = current.getNext();
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
