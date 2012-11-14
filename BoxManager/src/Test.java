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
		//
		//  Programmtests
		//
		System.out.println("*********************");
		System.out.println("*** Programmtests ***");
		System.out.println("*********************");
		
		//BOX
		Box b = new Box(3.4, 2.4, 'o', '-');
		System.out.println("*** Ausgabe Box ***\n" + b.toString());
		b.scale(0.5);
		b.scale(0.5);
		System.out.println("*** Ausgabe Box nach 2 x scale(0.5) ***\n" + b.toString());
		
		//CELAR BOX
		ClearBox cb = new ClearBox(4, 4);
		System.out.println("*** Ausgabe Clear-Box ***\n" + cb.toString());
		System.out.println("*** Ausgabe delta von Clear-Box ***\n" + cb.delta());
		cb.scale(0.5);
		cb.scale(0.5);
		System.out.println("*** Ausgabe Clear-Box nach 2 x scale(0.5) ***\n" + cb.toString());
		
		//DARK BOX
		DarkBox db = new DarkBox(6, 6, '#');
		System.out.println("*** Ausgabe Dark-Box ***\n" + db.toString());
		db.scale(0.5);
		System.out.println("*** Ausgabe Dark-Box nach scale(0.5) ***\n" + db.toString());

		//Repeated
		String[][] repeatedString = new String[][] {
				new String[] { "1", "22\n22" },
				new String[] { "333\n333\n333", "4444\n4444\n4444\n4444" }
		};
		
		Repeated<String> repeated1 = new Repeated<String>(repeatedString);
		
		System.out.println("*** Repeated 1 ***");
		System.out.println(repeated1.toString());
		
		System.out.println("*** Repeated 1 Skaliert 0.5 ***");
		repeated1.scale(0.5);
		System.out.println(repeated1.toString());
		
		System.out.println("*** Repeated 1 Skaliert 0.5*2.5 = 1.25 ***");
		repeated1.scale(2.5);
		System.out.println(repeated1.toString());
		
		// FreeBox (Beispiel aus der Angabe)
		FreeBox freeBox1 = new FreeBox("1234\n5678");
		System.out.println("*** Freebox 1 ***");
		System.out.println(freeBox1.toString());
		
		System.out.println("*** Freebox 1 Skaliert 1.5***");
		freeBox1.scale(1.5);
		System.out.println(freeBox1.toString());
		
		
		//Scaled (mit Boxen)
		System.out.println("*** Scaled 1 ***");
		Box[][] boxArray = new Box[2][2];
		boxArray[0][0] = cb;
		boxArray[1][0] = db;
		boxArray[0][1] = b;
		boxArray[1][1] = new ClearBox(1,5);
		Scaled<Box> scaledBox = new Scaled<Box>(boxArray);
		
		scaledBox.scale(2);
		System.out.println(scaledBox.toString());
		
		//Scaled (mit Pict)
		System.out.println("*** Scaled 2 ***");
		Pict[][] pictArray = new Pict[2][3];
		pictArray[0][0] = freeBox1;
		pictArray[1][0] = db;
		pictArray[0][1] = b;
		pictArray[1][1] = cb;
		pictArray[0][2] = new Box(6, 4, '=', ':');
		pictArray[1][2] = repeated1;
		
		Scaled<Pict> scaledPict = new Scaled<Pict>(pictArray);
		System.out.println(scaledPict.toString());
		
		System.out.println("*** Scaled 2 Skaliert 0.6***");
		scaledPict.scale(0.6);
		System.out.println(scaledPict.toString());
		
		System.out.println("*** Scaled 2 Skaliert 0.6*3 = 1.8***");
		scaledPict.scale(3);
		System.out.println(scaledPict.toString());
		
		//ACHTUNG: Scaled<String> kann nicht instanziert werden, da String KEIN Untertyp von Pict ist!!!
		//Scaled<String> stringBox = new Scaled<String>(repeatedString);
		
		//
		//  Untersuchung von Typ-Beziehungen
		//
		System.out.println("****************************************");
		System.out.println("*** Untersuchung von Typ-Beziehungen ***");
		System.out.println("****************************************");
		
		// Box - ClearBox / Box - DarkBox
		
		// Ueberall wo Box gefordert ist, kann auch ClearBox und DarkBox
		// angegeben werden. ClearBox und DarkBox haben (bis auf den Konstruktor)
		// alle Methoden, die Box auch hat (sind somit Untertypen von Box)
		
		Box box1 = new ClearBox(5,5);
		System.out.println("*** ClearBox als Box ***");
		System.out.println(box1.toString());
		
		Box box2 = new DarkBox(5,5,'X');
		System.out.println("*** DarkBox als Box ***");
		System.out.println(box1.toString());
		
		// Mit Box ist es zwar moeglich den selben Output wie ClearBox oder
		// DarkBox zu erzeugen, Box bietet aber nicht alle Methoden die
		// ClearBox und DarkBox anbieten.
		
		// Box - FreeBox
		// haben keine Untertypsbezieheung, da sie bis auf das Pict Interface
		// keine Gemeinsamkeiten haben
		
		// Box - Repeated<P> fuer alle P
		// keine Beziehung
		
		// FreeBox - Repeated<P> fuer P ist unbekannt
		// keine Beziehung
		
		// FreeBox - Repeated<Char>
		// In diesem Fall sind FreeBox und Repeated<Char> ersetzbar.
		// Beide bieten die selben Methoden und haben die selben Zusicherungen

		// Scaled<P extends Pict> - Repeated<P> fuer P ist Untertyp von Pict
		// Bieten zwar die selben Methoden, allerdings unterscheiden
		// sich die exakten Zusicherungen der Methode scaled. Somit keine
		// Ersetzbarkeit.
		
	}

}
