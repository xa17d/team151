import java.util.Iterator;
import java.util.ListIterator;

/**
 * Test-Methode
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
		//
		// Test 1
		//
		System.out.println("*** Test1: OrderedSet ***");
		Set<Description> os = new OrderedSet<Description>();
		
		Description d1 = new Description("a");
		Description d2 = new Description("bb");
		Description d3 = new Description("ccc");
		Description d4 = new Description("dddd");
		Description d5 = new Description("eeeee");
		Description d6 = new Description("ffffff");
		Description d7 = new Description("ggggggg");
		
		os.insert(d1);
		os.insert(d2);
		os.insert(d3);
		os.insert(d2); // identisches einfuegen
		os.insert(d4);
		os.insert(d7);
		
		
		Iterator<Description> osIter = os.iterator();
		
		while(osIter.hasNext())
			System.out.println(osIter.next().toString());
		
		
		System.out.println("Aenderungen durchfuehren und erneut ausgeben:");
		//Aenderungen durchfuehren
		os.insert(d6);
		os.insert(d5);
		
		//Bereits identisches Element einfuegen
		os.insert(d7);
		os.insert(d7);
		os.insert(d6);
		
		osIter = os.iterator();
		
		while(osIter.hasNext())
			System.out.println(osIter.next().toString());
		
		//erneutes Ausgeben
		
		//Test leeres OrderedSet
		//Neues OrderedSet anlegen und sofort durchgehen ohne Elemente
		Set<Description> ostwo = new OrderedSet<Description>();
		
		Iterator<Description> ostwoIter = ostwo.iterator();
		
		while(ostwoIter.hasNext())
			System.out.println(ostwoIter.next().toString());
		
		Description desOne = new Description("1");
		Description desTwo = new Description("2");
		
		System.out.println("Gleich lange Descriptions einfuegen + ausgeben");
		
		ostwo.insert(desOne);
		ostwo.insert(desTwo);
		
		while(ostwoIter.hasNext())
			System.out.println(ostwoIter.next().toString());
		
		//
		// Test 2 - OrderedMap<MeanElapsedTime, CompositeTime>
		//
		System.out.println("\n*** Test2: OrderedMap ***");
		
		// OrderedMap erstellen
		OrderedMap<MeanElapsedTime, CompositeTime> map1 = new OrderedMap<MeanElapsedTime, CompositeTime>();

		// Beispielwerte einfuegen
		MeanElapsedTime met1 = new MeanElapsedTime();
		met1.addValue(15.2);
		met1.addValue(12.3);
		met1.addValue(34.2);
		met1.addValue(2.5);

		MeanElapsedTime met2 = new MeanElapsedTime();
		met2.addValue(16.9);
		met2.addValue(31.3);
		met2.addValue(22.8);
		met2.addValue(4.6);
		
		MeanElapsedTime met3 = new MeanElapsedTime();
		met3.addValue(0);
		met3.addValue(0.5);
		
		map1.insert(met1);
		map1.insert(met2);
		map1.insert(met3);
		
		// Objekte einfuegen auf die verwiesen wird
		OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator1 = map1.iterator();
		int i = 0;
		while (mapIterator1.hasNext()) {
			
			mapIterator1.next();
			
			// Objekte mittels Iterator des Map-Iterators einfuegen
			ListIterator<CompositeTime> subIterator1 = mapIterator1.iterator();
			subIterator1.add(new CompositeTime(new double[] { i+0.1, i+0.01, }));
			subIterator1.add(new CompositeTime(new double[] { i+0.2, i+0.02 }));
			subIterator1.add(new CompositeTime(new double[] { i+0.3, i+0.03 }));
			
			i++;
		}
		
		// Elemente mit den verwiesenen Objekten ausgeben
		printMap(map1);
		
		// Elemente veraendern
		System.out.println("\n*** veraenderte OrderedMap ***");
		
		// zweites CompositeTime Objekt entfernen auf das das erste Element verweist:
		OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator2 = map1.iterator();
		mapIterator2.next();
		ListIterator<CompositeTime> subIterator1 = mapIterator2.iterator();
		subIterator1.next();
		subIterator1.next();
		subIterator1.remove();
		
		// zweites Element: erstes Objekt entfernen, nach dem zweiten ein neues einfuegen
		mapIterator2.next();
		ListIterator<CompositeTime> subIterator2 = mapIterator2.iterator();
		subIterator2.next();
		subIterator2.remove();
		subIterator2.next();
		subIterator2.add(new CompositeTime(new double[] { 999 }));
		
		// Geaenderte Map ausgeben
		printMap(map1);
		
		//
		// Test 3 - OrderedMap als OrderedSet
		//
		
		System.out.println("\n*** Test 3: OrderedMap als OrderedSet ***");
		
		OrderedSet<MeanElapsedTime> orderedSet2 = map1;
		
		// Werte ins OrderedSet einfuegen
		MeanElapsedTime met4 = new MeanElapsedTime();
		met4.addValue(31);
		met4.addValue(34);
		
		MeanElapsedTime met5 = new MeanElapsedTime();
		met5.addValue(99);
		met5.addValue(100);
		
		orderedSet2.insert(met4);
		orderedSet2.insert(met5);
		
		// Map als OrderedSet ausgeben
		Iterator<MeanElapsedTime> setIterator1 = orderedSet2.iterator();
		while (setIterator1.hasNext()) {
			MeanElapsedTime element = setIterator1.next();
			System.out.println(element.max());
		}
		
		
		//
		// Test 4
		//
		System.out.println("*** Test 4 ***");
		OrderedSet<ElapsedTime> osET = new OrderedSet<ElapsedTime>();
		
		/* Erzeugen Sie eine Instanz von OrderedSet, deren Elemente vom Typ ElapsedTime 
		 * sind. Lesen Sie alle Elemente der in Punkt 2 erzeugten (und moeglicherweise in 
		 * Punkt 3 erweiterten) Menge und alle Objekte, auf welche die Elemente verweisen, 
		 * aus und fuegen Sie diese (Instanzen von MeanElapsedTime ebenso wie von CompositeTime) 
		 * in die neue Menge ein. Lesen Sie alle Elemente der neuen Menge aus, und schreiben 
		 * Sie die durch count ermittelten Werte in die Standard-Ausgabe.
		 **/
		
		OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIt = map1.iterator();
		
		while (mapIt.hasNext()) {	//Einfuegen der Menge in OrderedSet
				osET.insert(mapIt.next());
		}
		
		Iterator<ElapsedTime> itET = osET.iterator();
		
		while(itET.hasNext()){		//Auslesen der Elemente + count Ausgabe
			ElapsedTime et = itET.next();
			System.out.println("Time: " + et.time() + " count: " + et.count());
		}
		
		//
		// Test 5: Unserer Meinung nach sind mit den obigen Beispielen
		//         alle noetigen Tests durchgefuehrt worden
		//
	}
	
	private static void printMap(OrderedMap<MeanElapsedTime, CompositeTime> map)
	{
		OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator = map.iterator();
		while (mapIterator.hasNext()) {
			
			MeanElapsedTime element = mapIterator.next();
			// Groesster Messwert ausgeben
			System.out.println(element.max());
			
			ListIterator<CompositeTime> subIterator = mapIterator.iterator();
			while (subIterator.hasNext()) {
				
				CompositeTime object = subIterator.next();
				// Kuerzeste Einzelzeit der Objekte ausgeben
				System.out.println("\t"+object.min());
			}
		}
	}
}
