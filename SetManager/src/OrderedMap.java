import java.util.Iterator;
import java.util.ListIterator;

public class OrderedMap<T extends Shorter<T> ,U> extends Set<T> { // TODO: Set<T> muss auf OrderedSet<T> geaendert werden

	private class MappedItems implements Shorter<T>, Iterable<U> {

		public MappedItems(T mapKey) {
			this.mapKey = mapKey;
		}
		
		private T mapKey;
		
		@Override
		public boolean shorter(T other) {
			return mapKey.shorter(other);
		}

		@Override
		public ListIterator<U> iterator() {
			return new MappedItemsIterator();
		}
		
		private class MappedItemsIterator implements ListIterator<U> {

			@Override
			public void add(U e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public U next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public U previous() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void set(U e) {
				// TODO Auto-generated method stub
				
			}
			
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
