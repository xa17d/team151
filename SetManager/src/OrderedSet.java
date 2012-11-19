import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * @author Raphael Kamper
 *
 * @param <T> Typparameter
 */
public class OrderedSet <T extends Shorter<T>> extends Set<T>{
	private OrderedSetNode first;
	
	public OrderedSet(){
		this.first = new OrderedSetNode(null);
	}
	
	/**
	 * liefert neuen Iterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new OrderedSetIterator();
	}
	
	/**
	 * fuegt ein Element vom Typ T in das Set ein
	 * @param t einzufuegendes Element
	 * @return Einfuegen erfolgreich
	 */
	@Override
	public boolean insert(T t) {
		OrderedSetNode current = first;
		
		
		if(first.getNext() == null){ //Keine Element vorhanden
			first.setNext(new OrderedSetNode(t));
			System.out.println("First");
			return true;
		}
		while(current.getNext() != null)
		{
			if(t.shorter(current.getNext().getItem())){ //als neues Element einfuegen
				OrderedSetNode n = new OrderedSetNode(t);
				n.setNext(current.getNext());
				current.setNext(n);
				return true;
			}else
				current = current.getNext();
			
			//auf identitaet ueberpruefen
			if(current.getItem().equals(t))
				return false;
		}
		//Kein Element kleiner -> Am Ende einfuegen
		current.setNext(new OrderedSetNode(t));
		return true;
		
		
	}
	
	/**
	 * innere Klasse SetIterator
	 * implementiert den Iterator
	 * @author Lucas Dobler
	 */

	private class OrderedSetIterator implements Iterator<T> {
		private OrderedSetNode pointer;
		
		/**
		 * Konstruktor
		 */
		public OrderedSetIterator() {
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
	 * 
	 * @author Lucas Dobler, Raphael Kamper
	 *
	 */
	private class OrderedSetNode {
		OrderedSetNode next;
		T item;
		
		/**
		 * Konstruktor fuegt das Element ein und setzt den Link zum naechsten Knoten auf null
		 * @param item Element
		 */
		public OrderedSetNode(T item) {
			next = null;
			setItem(item);
		}
		
		/**
		 * liefert den naechsten Knoten
		 * @return naechsten Knoten
		 */
		public OrderedSetNode getNext() { 
			return next;
		}
		
		/**
		 * naechsten Knoten definieren
		 * @param next naechster Knoten
		 */
		public void setNext(OrderedSetNode next) {
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
