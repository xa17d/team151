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
		Skin bS = new BeruehrungssensitiverSkin();
		Skin hS = new HochfesterSkin();
		Skin gS = new GepanzerterSkin();
		
		//Software-Versionen
		SoftwareStufe s1 = new SoftwareStufe1();
		SoftwareStufe s2 = new SoftwareStufe2();
		SoftwareStufe s3 = new SoftwareStufe3();
		SoftwareStufe s4 = new SoftwareStufe4();
		SoftwareStufe s5 = new SoftwareStufe5();
		
		
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
		
		//insert Leibwaechter mit falschem Skin und falscher Software
		fehlercode = shop.insert(seriennummer++, l, gS, s2);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Gesellschafter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, g, bS, s1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Service-Techniker mit falscher Software
		fehlercode = shop.insert(seriennummer++, s, gS, s5);
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
		shop.insert(6, o, gS, s4);
		shop.insert(8, k, bS, s5);
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide:");
		iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
	}
}