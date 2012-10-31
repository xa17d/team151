import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * GUT: Generische Klasse fuer History, damit kann diese Klasse fuer Songs und Mitglieder verwendet werden, ohne doppelten Code zu verursachen
 */
public class History<T> {
	
	// Erzeugt eine neue History und gibt das neue Objekt zurueck (postcondition)
	public History()
	{
		historyMap = new TreeMap<Date, ArrayList<T>>();
	}
	
	private TreeMap<Date, ArrayList<T>> historyMap; // historyMap != null
	
	// Gibt den aktuellen Timestamp zurueck (postcondition)
	private Date now()
	{
		return new Date();
	}
	
	// Fuegt ein neues Element ein (history-constraint); item: neues Element (darf nicht null sein) (precondition)
	public void add(T item)
	{
		if (item == null) { throw new IllegalArgumentException("item darf nicht null sein"); }
		
		ArrayList<T> elementsOld = list();
		ArrayList<T> elementsNew = new ArrayList<T>(elementsOld);
		
		elementsNew.add(item);
		
		historyMap.put(now(), elementsNew);
	}
	
	// Loescht ein Element (history-constraint)
	// item: zu loeschendes Element (precondition)
	// Ergebnis: true wenn das Element entfernt wurde, false falls die momentane Auflistung dieses Element nicht enthaelt. (postcondition)
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
	
	// Gibt eine Liste mit den momentan enthaltenen Elementen zurueck (postcondition)
	public ArrayList<T> list()
	{
		return list(now());
	}
	
	// Gibt eine Liste mit den Elementen zurueck, die sich zum Zeitpunkt time in der History befunden haben (ist niemals null, kann aber leer sein) (postcondition)
	// time: Zeitpunkt, darf nicht null sein (precondition)
	public ArrayList<T> list(Date time)
	{
		Map.Entry<Date, ArrayList<T>> entry = historyMap.floorEntry(time);
		if (entry != null)
		{
			return entry.getValue();
		}
		else
		{
			return new ArrayList<T>();
		}
	}

	// Gibt alle in dieser History vorhandenen Elemente fuer jeden Zeitpunkt als String zurueck. (postcondition)
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
