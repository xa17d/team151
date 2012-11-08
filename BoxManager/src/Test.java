/**
 * Testklasse fuer Aufgabe 4
 * @author OOP 151
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//BOX
		Box b = new Box(3.4, 2.4, 'o', '-');
		System.out.println(b.toString());
		b.scale(0.5);
		b.scale(0.5);
		b.scale(0.5);
		b.scale(0.5);
		System.out.println(b.toString());
		
		//CELAR BOX
		ClearBox cb = new ClearBox(4, 4);
		System.out.println(cb.toString());
		System.out.println(cb.delta());
		cb.scale(0.5);
		cb.scale(0.5);
		System.out.println(cb.toString());
		
		//DARK BOX
		DarkBox db = new DarkBox(6, 6, '#');
		System.out.println(db.toString());
		db.scale(0.5);
		System.out.println(db.toString());
		
	}

}
