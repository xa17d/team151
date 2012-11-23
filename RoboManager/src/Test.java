import java.util.Iterator;

/**
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
		RoboShop shop = new RoboShop();
		int seriennummer = 1;
		String fehlercode = "";
		
		//Androiden-Typen
		Androide h = new Hilfskraft();
		Androide g = new Gesellschafter();
		Androide b = new Bauarbeiter();
		Androide s = new ServiceTechniker();
		Androide t = new Transportarbeiter();
		Androide o = new Objektbewacher();
		Androide l = new Leibwaechter();
		Androide k = new Kaempfer();
		
		//Skin-Typen
		Skin bS = new beruehrungssensitiverSkin();
		Skin hS = new hochfesterSkin();
		Skin gS = new gepanzerterSkin();
		
		//Software-Versionen
		Software s1 = new SoftwareStufe1();
		Software s2 = new SoftwareStufe2();
		Software s3 = new SoftwareStufe3();
		Software s4 = new SoftwareStufe4();
		Software s5 = new SoftwareStufe5();
		
		
		//TEST
		//insert Hilfskraft mit falschem Skin
		fehlercode = shop.insert(seriennummer++, h, gS, s1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Schwerarbeiter mit falscher Software
		fehlercode = shop.insert(seriennummer++, b, bS, s2);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Kaempfer mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, k, gS, s5);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Kaempfer mit falscher Software
		fehlercode = shop.insert(seriennummer++, k, gS, s4);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Transportarbeiter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, t, hS, s3);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Objektbewacher mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, o, bS, s4);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//einen Androiden suchen
		System.out.println("\nAndroide mit der Seriennummer 3: " + shop.find(3));
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide:");
		Iterator<AusgelieferterAndroide> iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
		//Androide veraendern
		fehlercode = shop.insert(6, o, gS, s4);
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide:");
		iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
	}
}