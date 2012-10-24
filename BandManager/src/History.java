import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Kann mehrere Elemente speichern und die Elemente fuer jeden Zeitpunkt wieder zurueckgeben
 * @param <T> Typ der Elemente
 */
public class History<T> {
	
	public History()
	{
		historyMap = new TreeMap<Date, ArrayList<T>>();
	}
	
	/**
	 * in dieser TreeMap werden fuer jede Aenderung der Zeitpunkt und die enthaltenen Elemente gespeichert
	 */
	private TreeMap<Date, ArrayList<T>> historyMap;
	
	/**
	 * Gibt den aktuellen Timestamp zurueck
	 * @return aktueller Timestamp
	 */
	private Date now()
	{
		return new Date();
	}
	
	/**
	 * Fuegt ein neues Element ein
	 * @param item neues Element (darf nicht null sein)
	 */
	public void add(T item)
	{
		if (item == null) { throw new IllegalArgumentException("item darf nicht null sein"); }
		
		ArrayList<T> elementsOld = list();
		ArrayList<T> elementsNew = new ArrayList<T>(elementsOld);
		
		elementsNew.add(item);
		
		historyMap.put(now(), elementsNew);
	}
	
	/**
	 * Loescht ein Element
	 * @param item zu loeschendes Element
	 * @return true wenn das Element entfernt wurde, false falls die momentane Auflistung dieses Element nicht enthaelt.
	 */
	public boolean delete(T item)
	{
		if (item == null) { return false; }
		
		ArrayList<T> elementsOld = list();
		
		if (elementsOld.contains(item))
		{
			ArrayList<T> elementsNew = new ArrayList<T>(elementsOld);
			elementsNew.remove(item);
			historyMap.put(now(), elementsNew);
			return true;
		}
		else
		{ return false; }
	}
	
	/**
	 * Gibt eine Liste mit den momentan enthaltenen Elementen zurueck
	 * @return Liste mit momentan enthaltenen Elementen
	 */
	public ArrayList<T> list()
	{
		return list(now());
	}
	
	/**
	 * Gibt eine Liste mit den Elementen zurueck, die sich zum Zeitpunkt time in der History befunden haben.
	 * @param time Zeitpunkt
	 * @return Liste mit den Elementen zum Zeitpunkt time
	 */
	public ArrayList<T> list(Date time)
	{
		Map.Entry<Date, ArrayList<T>> entry = historyMap.floorEntry(time);
		if (entry != null)
		{
			return entry.getValue();
		}
		else
		{
			return new ArrayList<T>(); // leere Liste
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (Map.Entry<Date, ArrayList<T>> entry : historyMap.entrySet()) {
			Date time = entry.getKey();
			s.append("*** "+time.toString()+" ***\n");
			for (T element : entry.getValue()) {
				s.append(element.toString()+"\n");
			}
		}
		
		return s.toString();
	}
}
