import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
	
	Set<String> set1 = new Set<String>();
	String s1 = "hallo";
	String s2 = "welt";
	String s3 = "!";
	
	set1.insert(s1);
	set1.insert(s1);
	set1.insert(s2);
	set1.insert(s1);
	set1.insert(s3);
	
	Iterator<String> iter1 = set1.iterator();
	
	while(iter1.hasNext())
		System.out.println(iter1.next());
	}
}
