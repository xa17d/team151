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

		// Repeated
		Repeated<String> repeated1 = new Repeated<String>(

				new String[][] {
						new String[] { "1", "22\n22" },
						new String[] { "333\n333\n333", "4444\n4444\n4444\n4444" }
				}
				
			);
		
		System.out.println("*** Repeated 1 ***");
		System.out.println(repeated1.toString());
		
		System.out.println("*** Repeated 1 Skaliert 0.5 ***");
		repeated1.scale(0.5);
		System.out.println(repeated1.toString());
		
		System.out.println("*** Repeated 1 Skaliert 0.5*2.5 = 1.25 ***");
		repeated1.scale(2.5);
		System.out.println(repeated1.toString());
		
		// FreeBox
		FreeBox freeBox1 = new FreeBox("1234\n5678");
		System.out.println("*** Freebox 1 ***");
		System.out.println(freeBox1.toString());
		
		System.out.println("*** Freebox 1 Skaliert 1.5***"); // (Beispiel aus der Angabe)
		freeBox1.scale(1.5);
		System.out.println(freeBox1.toString());
	}

}
