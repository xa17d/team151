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
		
		//AktorenKits
		AktorenKitLeistung1 ak1 = new AktorenKitLeistung1();
		AktorenKitLeistung5 ak5 = new AktorenKitLeistung5();
		AktorenKitLeistung10 ak10 = new AktorenKitLeistung10();
		AktorenKitLeistungUnlimitiert aku = new AktorenKitLeistungUnlimitiert();
		
		
		//TEST
		//insert Hilfskraft mit falschem Skin
		fehlercode = shop.insert(seriennummer++, h, gS, s1, ak1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Gesellschafter mit falschem AktorenKit
		fehlercode = shop.insert(seriennummer++, g, bS, s1, ak10);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Schwerarbeiter(ServiceTechniker) mit falschem AktorenKit (wegen zu geringer SoftwareStufe)
		fehlercode = shop.insert(seriennummer++, s, bS, s3, ak10);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Schwerarbeiter(ServiceTechniker) mit korrektem AktorenKit (wegen passender SoftwareStufe im Vergleich zu vorigem Bsp.)
		fehlercode = shop.insert(seriennummer++, s, bS, s4, ak10);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Transportarbeiter mit falschem AktorenKit
		fehlercode = shop.insert(seriennummer++, t, bS, s3, aku);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Schwerarbeiter mit falscher Software
		fehlercode = shop.insert(seriennummer++, b, bS, s2, ak1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Kaempfer mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, k, gS, s5, aku);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Kaempfer mit falscher Software
		fehlercode = shop.insert(seriennummer++, k, gS, s4, aku);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Transportarbeiter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, t, hS, s3, ak5);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Objektbewacher mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, o, bS, s4, ak10);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Leibwaechter mit falschem Skin und falscher Software
		fehlercode = shop.insert(seriennummer++, l, gS, s2, ak1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Gesellschafter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, g, bS, s1, ak1);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Service-Techniker mit falscher Software
		fehlercode = shop.insert(seriennummer++, s, gS, s5, ak10);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//einen Androiden suchen
		System.out.println("\nAndroide mit der Seriennummer 4: " + shop.find(4));
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide:");
		Iterator<AusgelieferterAndroide> iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
		System.out.println("\nVeraenderungen vornehmen:");
		//Androide veraendern
		fehlercode = shop.insert(7, o, gS, s4, ak5);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		fehlercode = shop.insert(9, k, bS, s5, aku);
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		fehlercode = shop.insert(4, s, bS, s4, aku); //Ungueltiges AktorenKit
		if(fehlercode!=null)
			System.out.println("FEHLER: "+ fehlercode);
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide nach Veraenderung:");
		iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
	}
}