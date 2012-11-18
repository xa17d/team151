import java.lang.Iterable;
import java.util.*;
/**
 * implementiert Set
 * @author Lucas Dobler
 * @param <T> beliebiger Typ T
 */
public class Set<T> implements Iterable<T> {
	private SetNode first;
	
	/**
	 * Konstruktor
	 * Erstellt einen leeren Knoten der den Anfangsknoten des Sets darstellt
	 */
	public Set() {
		first = new SetNode(null);
	}
	
	/**
	 * fuegt ein Element vom Typ T in das Set ein
	 * @param t einzufuegendes Element
	 * @return Einfuegen erfolgreich
	 */
	public boolean insert(T t) {
		SetNode current = first;
		
		//alle Elemente durchgehen, bis zum Letzten
		while(current.getNext() != null)
		{
			current = current.getNext();
			
			//auf identitaet ueberpruefen
			if(current.getItem().equals(t))
				return false;
		}
		
		//als neues Element einfuegen
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
	 * @author Lucas Dobler
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
		 * abfrage ob es ein naechstes Element im Set gibt
		 * @return true: es gibt ein weiteres Element - false: letztes Element in Liste
		 */
		public boolean hasNext() {
			if(pointer.getNext() != null)
				return true;
			else
				return false;
		}
		
		/**
		 * liefert naechstes Element aus dem Set
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
	 * @author Lucas Dobler
	 */
	private class SetNode {
		SetNode next;
		T item;
		
		/**
		 * Konstruktor fuegt das Element ein und setzt den Link zum naechsten Knoten auf null
		 * @param item Element
		 */
		public SetNode(T item) {
			next = null;
			setItem(item);
		}
		
		/**
		 * liefert den naechsten Knoten
		 * @return naechsten Knoten
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
		public T getItem() {
			return item;
		}
		
		/**
		 * Element einfuegen
		 * @param item Element
		 */
		private void setItem(T item) {
			this.item = item; 
		}
	}
}
