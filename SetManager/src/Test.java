import java.awt.List;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Test-Methode
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
	
	//TEST1 - Strings
	System.out.println("*** Set ***");
	Set<String> set1 = new Set<String>();
	String s1 = "hallo";
	String s2 = "welt";
	String s3 = "!";
	
	set1.insert(s1);
	set1.insert(s1);	//identisches Element
	set1.insert(s2);
	set1.insert(s1);	//identisches Element
	set1.insert(s3);
	set1.insert(s3);	//identisches Element
	
	Iterator<String> iter1 = set1.iterator();
	
	while(iter1.hasNext())
		System.out.println(iter1.next());
	
	//TEST2 - MeanElapsedTime
	System.out.println("\n*** MeanElapsedTime ***");
	MeanElapsedTime met1 = new MeanElapsedTime();
	met1.addValue(15.2);
	met1.addValue(12.3);
	met1.addValue(34.2);
	met1.addValue(2.5);
	
	System.out.println("MET1-Durchschnitt: " + met1.mean());
	System.out.println("MET1-Maximum: " + met1.max());
	
	MeanElapsedTime met2 = new MeanElapsedTime();
	met2.addValue(16.9);
	met2.addValue(31.3);
	met2.addValue(22.8);
	met2.addValue(4.6);
	
	System.out.println("MET2-Durchschnitt: " + met2.mean());
	System.out.println("MET2-Maximum: " + met2.max());
	
	System.out.println("MET1 shorter MET2: " + met1.shorter(met2));
	System.out.println("MET2 shorter MET1: " + met2.shorter(met1));
	
	//TEST3 - MeanElapsedTime
	System.out.println("\n*** CompositeTime ***");
	double[] time1 = {16.9, 31.3, 22.8, 4.6};
	CompositeTime ct1 = new CompositeTime(time1);
	
	System.out.println("CT1-Summe: " + ct1.sum());
	System.out.println("CT1-Minimum: " + ct1.min());
	
	double[] time2 = {15.2, 12.3, 34.2, 2.5};
	CompositeTime ct2 = new CompositeTime(time2);
	
	System.out.println("CT2-Summe: " + ct2.sum());
	System.out.println("CT2-Minimum: " + ct2.min());
	
	System.out.println("CT1 shorter CT2: " + ct1.shorter(ct2));
	System.out.println("CT2 shorter CT1: " + ct2.shorter(ct1));
	
	//TEST4 - OrderedMap
	System.out.println("\n*** OrderedMap ***");
	OrderedMap<MeanElapsedTime, CompositeTime> map1 = new OrderedMap<MeanElapsedTime, CompositeTime>();
	map1.insert(met1);
	map1.insert(met2);
	
	OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator1 = map1.iterator();
	int i = 0;
	while (mapIterator1.hasNext()) {
		
		MeanElapsedTime element = mapIterator1.next();
		
		ListIterator<CompositeTime> subIterator1 = mapIterator1.iterator();
		subIterator1.add(new CompositeTime(new double[] { i, i+1, element.max() }));
		subIterator1.add(new CompositeTime(new double[] { i+2, i+3 }));
		subIterator1.add(new CompositeTime(new double[] { i+4, i+5 }));
		
		i++;
	}
	
	OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator2 = map1.iterator();
	int deleteIndex = 0;
	while (mapIterator2.hasNext()) {
		
		MeanElapsedTime element = mapIterator2.next();
		System.out.println(element.mean());
		
		ListIterator<CompositeTime> subIterator1 = mapIterator2.iterator();
		int index = 0;
		while (subIterator1.hasNext()) {
			
			CompositeTime object = subIterator1.next();
			System.out.println("\t"+object.min());
			
			if (deleteIndex == index) { subIterator1.remove(); }
			
			index++;
		}

		deleteIndex++;
	}
	
	System.out.println("\nnach dem einige Objekt 0.0 und 3.0  geloescht wurden:");
	
	OrderedMap<MeanElapsedTime, CompositeTime>.MapIterator mapIterator3 = map1.iterator();
	while (mapIterator3.hasNext()) {
		
		MeanElapsedTime element = mapIterator3.next();
		System.out.println(element.mean());
		
		ListIterator<CompositeTime> subIterator1 = mapIterator3.iterator();
		while (subIterator1.hasNext()) {
			
			CompositeTime object = subIterator1.next();
			System.out.println("\t"+object.min());
		}
	}
	}
}
