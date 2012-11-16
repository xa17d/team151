import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
	
	Set<String> set1 = new Set<String>();
	
	set1.insert("hallo");
	set1.insert("welt");
	set1.insert("!");
	
	Iterator<String> iter1 = set1.iterator();
	
	while(iter1.hasNext())
		System.out.println(iter1.next());
	}
}
