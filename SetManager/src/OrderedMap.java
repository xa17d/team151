import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * OrderedMap unterscheidet sich von OrderedSet nur dadurch, dass jedes Element der Menge auf weitere Objekte verweisen kann.
 * Der Typ dieser Objekte wird durch einen weiteren Typparameter bestimmt.
 * @author Daniel Gehrer
 *
 * @param <T> Typ der Elemente (muss Untertyp von Shorter<T> sein)
 * @param <U> Typ der Objekte auf die verwiesen wird
 */
public class OrderedMap<T extends Shorter<? super T> ,U> extends OrderedSet<T> {

	/**
	 * Erzeugt ein neues OrderedMap
	 */
	public OrderedMap()
	{
		mappedItems = new OrderedSet<MappedItems>();
	}
	
	/**
	 * OrderedSet in dem die Verweise auf die Objekte gespeichert werden.
	 * MappedItems speichert das Element und die Objekte die dazu gehoeren.
	 * Wird shorter aufgerufen, ruft MappedItems die shorter-Funktion des
     * Elements auf. Dadurch ist die Reihenfolge in diesem Set exakt die
     * selbe wie im Set der Elemente.
	 */
	private OrderedSet<MappedItems> mappedItems;
	
	/**
	 * Klasse die die Objekte, die zu einem Element gehoeren abspeichert.
	 * Weiters wird das Element gespeichert zu dem die Objekte gehoeren.
	 * MappedItems implementiert Shorter<T> aus folgendem Grund:
	 * Wenn die MappedItems in ein OrderedSet eingefuegt werden,
	 * haben die MappedItems in diesem Set genau die gleiche Reihenfolge
	 * wie Elemente in einem OrderedSet in dem sich die Elemente befinden.
	 * Somit lassen sich MappedItems und das zugehoerige Element einfach
	 * ermitteln.
	 */
	private class MappedItems implements Shorter<MappedItems>, Iterable<U> {

		/**
		 * Erzeugt ein MappedItems-Objekt fuer ein Element
		 * @param element Das Element fuer das die Objekte gespeichert werden sollen (!=null)
		 */
		public MappedItems(T element) {
			this.element = element;
			first = new MappedNode(null);
		}
		
		/**
		 * Element fuer das zugehoerige Objekte gespeichert werden
		 */
		private T element;
		/**
		 * Verweis auf das MappedNode, das auf das erste wirkliche Objekt verweist.
		 * darf niemals null sein.
		 */
		private MappedNode first;
		
		/**
		 * Fuert die shorter-Methode des Elements aus.
		 */
		@Override
		public boolean shorter(MappedItems other) {
			return element.shorter(other.element);
		}

		/**
		 * Gibt einen ListIterator zurueck mit dem die Objekte verwaltet werden koennen.
		 * Achtung: es sind nur die Methoden add, hasNext, next und remove implementiert.
		 */
		@Override
		public ListIterator<U> iterator() {
			return new MappedItemsIterator(this);
		}
		
		/**
		 * Repraesentiert ein Speicher fuer ein Objekt und kann auf einen
		 * naechsten MappedNode verweisen
		 */
		private class MappedNode {
			
			/**
			 * Erzeugt ein neues MappedNode
			 * @param item zu speicherndes Objekt (!=null)
			 */
			public MappedNode(U item) {
				next = null;
				this.item = item;
			}
			
			/**
			 * naechstes MappedNode (null falls es kein naechstes Objekt gibt)
			 */
			private MappedNode next;
			/**
			 * Gespeichertes Objekt
			 */
			private U item;
			
			/**
			 * @return das nachfolgende MappedNode. Falls dieses Node das letzte ist, wird null zurueckgegeben.
			 */
			public MappedNode getNext() { 
				return next;
			}
			
			/**
			 * Setzt das nachfolgende Node
			 * @param next nachfolgendes Node
			 */
			public void setNext(MappedNode next) {
				this.next = next; 
			}
			
			/**
			 * @return gespeichertes Objekt
			 */
			public U getItem() {
				return item;
			}
		}
		
		/**
		 * Iterator fuer ein MappedItems-Objekt.
		 * Achtung: es sind nur die Methoden add, hasNext, next und remove implementiert.
		 */
		private class MappedItemsIterator implements ListIterator<U> {

			/**
			 * Erstellt einen MappedItemsIterator fuer ein bestimmtes MappedItems.
			 * @param owner MappedItems fuer das der Iterator erzeugt wird.
			 */
			public MappedItemsIterator(MappedItems owner)
			{
				pointer = owner.first;
				lastPointer = null;
				removed = true;
			}
			
			/**
			 * aktuelles Objekt (niemals null)
			 */
			private MappedNode pointer;
			/**
			 * das letzte Objekt
			 */
			private MappedNode lastPointer;
			/**
			 * true wenn das Objekt entfernt wurde, aber bis jetzt noch kein next() gefolgt ist
			 */
			private boolean removed;

			/**
			 * @see java.util.ListIterator#add(java.lang.Object)
			 */
			@Override
			public void add(U e) {
				MappedNode newNode = new MappedNode(e);
				newNode.setNext(pointer.getNext());
				pointer.setNext(newNode);
				pointer = newNode;
			}

			/**
			 * @see java.util.ListIterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				return (pointer.getNext() != null);
			}

			/**
			 * @see java.util.ListIterator#next()
			 */
			@Override
			public U next() {
				if (hasNext()) {
					lastPointer = pointer;
					pointer = pointer.getNext();
					removed = false;
					return pointer.getItem();
				}
				else
				{ throw new NoSuchElementException(); }
			}
			
			/**
			 * @see java.util.ListIterator#remove()
			 */
			@Override
			public void remove() {
				if ((lastPointer != null) && (!removed)) {
					removed = true;
					lastPointer.setNext(pointer.getNext());
				}
				else {
					throw new IllegalStateException();
				}
			}
			
			/**
			 * nicht implementiert!
			 */
			@Override
			public boolean hasPrevious() { throw new UnsupportedOperationException("not implemented"); }

			/**
			 * nicht implementiert!
			 */
			@Override
			public int nextIndex() { throw new UnsupportedOperationException("not implemented"); }

			/**
			 * nicht implementiert!
			 */
			@Override
			public U previous() { throw new UnsupportedOperationException("not implemented"); }

			/**
			 * nicht implementiert!
			 */
			@Override
			public int previousIndex() { throw new UnsupportedOperationException("not implemented"); }

			/**
			 * nicht implementiert!
			 */
			@Override
			public void set(U e) { throw new UnsupportedOperationException("not implemented"); }
			
		}
	}
	
	/**
	 * @see OrderedSet#insert(java.lang.Object)
	 */
	public boolean insert(T t) {
		if (super.insert(t))
		{
			mappedItems.insert(new MappedItems(t));
			return true;
		}
		else { return false; }
	}
	
	/**
	 * Gibt einen MapIterator fuer dieses Set zurueck.
	 */
	public MapIterator iterator() {
		return new MapIterator(super.iterator(), mappedItems.iterator());
	}
	
	/**
	 * Iterator fuer eine Map
	 * besitzt zusaetlich eine iterator()-Methode fuer die Objekte auf die die Elemente verweisen
	 */
	public class MapIterator implements Iterator<T> {

		/**
		 * Erzeugt einen neuen MapIterator
		 * @param elementsIterator Iterator fuer die Elemente
		 * @param objectsIterator Iterator fuer die MappedItems die die Objekte speichern
		 */
		private MapIterator(Iterator<T> elementsIterator, Iterator<MappedItems> objectsIterator) {
			this.elementsIterator = elementsIterator;
			this.objectsIterator = objectsIterator;
		}
		
		/**
		 * Iterator fuer die Elemente
		 */
		private Iterator<T> elementsIterator;
		/**
		 * Iterator fuer die MappedItems die die Objekte speichern
		 */
		private Iterator<MappedItems> objectsIterator;
		/**
		 * aktuelles MappedItems
		 */
		private MappedItems currentMappedItems; 
		
		/**
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return elementsIterator.hasNext();
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			currentMappedItems = objectsIterator.next(); // MappedItems auslesen
			return elementsIterator.next(); // Element zurueckgeben
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			// muss aus beiden Sets entfernt werden 
			elementsIterator.remove();
			objectsIterator.remove();
		}
		
		/**
		 * Gibt einen ListIterator fuer die Objekte auf die das Element verweist zurueck
		 * Achtung: es sind nur die Methoden add, hasNext, next und remove implementiert.
		 * @return ListIterator fuer Objekte
		 */
		public ListIterator<U> iterator() {
			return currentMappedItems.iterator();
		}
	}
}
