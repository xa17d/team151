import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OrderedMap<T extends Shorter<T> ,U> extends Set<T> { // TODO: Set<T> muss auf OrderedSet<T> geaendert werden

	private class MappedItems implements Shorter<T>, Iterable<U> {

		public MappedItems(T mapKey) {
			this.mapKey = mapKey;
			first = new MappedNode(null);
		}
		
		private T mapKey;
		private MappedNode first;
		
		@Override
		public boolean shorter(T other) {
			return mapKey.shorter(other);
		}

		@Override
		public ListIterator<U> iterator() {
			return new MappedItemsIterator(this);
		}
		
		private class MappedNode {
			private MappedNode next;
			private U item;
			
			public MappedNode(U item) {
				next = null;
				setItem(item);
			}
			
			public MappedNode getNext() { 
				return next;
			}
			
			public void setNext(MappedNode next) {
				this.next = next; 
			}
			
			public U getItem() {
				return item;
			}
			
			private void setItem(U item) {
				this.item = item; 
			}
		}
		
		private class MappedItemsIterator implements ListIterator<U> {

			private MappedNode pointer;
			private MappedNode lastPointer;
			private boolean removed;
			
			public MappedItemsIterator(MappedItems owner)
			{
				pointer = owner.first;
				lastPointer = null;
				removed = true;
			}
			
			@Override
			public void add(U e) {
				MappedNode newNode = new MappedNode(e);
				newNode.setNext(pointer.getNext());
				pointer.setNext(newNode);
				pointer = newNode;
			}

			@Override
			public boolean hasNext() {
				return (pointer.getNext() != null);
			}

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
			
			@Override
			public boolean hasPrevious() { throw new UnsupportedOperationException("not implemented"); }

			@Override
			public int nextIndex() { throw new UnsupportedOperationException("not implemented"); }

			@Override
			public U previous() { throw new UnsupportedOperationException("not implemented"); }

			@Override
			public int previousIndex() { throw new UnsupportedOperationException("not implemented"); }

			@Override
			public void set(U e) { throw new UnsupportedOperationException("not implemented"); }
			
		}
	}
	
	private Set<MappedItems> mappedItems; // TODO: Set<T> muss auf OrderedSet<T> geaendert werden
	
	public boolean insert(T t) {
		if (super.insert(t))
		{
			mappedItems.insert(new MappedItems(t));
			return true;
		}
		else { return false; }
	}
	
	public MapIterator iterator() {
		return new MapIterator(super.iterator(), mappedItems.iterator());
	}
	
	public class MapIterator implements Iterator<T> {

		private MapIterator(Iterator<T> keyIterator, Iterator<MappedItems> valuesIterator) {
			this.keyIterator = keyIterator;
			this.valuesIterator = valuesIterator;
		}
		
		private Iterator<T> keyIterator;
		private Iterator<MappedItems> valuesIterator;
		private MappedItems currentMappedItems; 
		
		@Override
		public boolean hasNext() {
			return keyIterator.hasNext();
		}

		@Override
		public T next() {
			currentMappedItems = valuesIterator.next();
			return keyIterator.next();
		}

		@Override
		public void remove() {
			keyIterator.remove();
			valuesIterator.remove();
		}
		
		public ListIterator<U> iterator() {
			return currentMappedItems.iterator();
		}
	}
}
