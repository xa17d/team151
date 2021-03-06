import java.util.Iterator;

/**
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
		RoboShop shop = new RoboShop();
		int seriennummer = 1;
		String fehlercode;
		
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
		AktorenKit ak1 = new AktorenKitLeistung1();
		AktorenKit ak5 = new AktorenKitLeistung5();
		AktorenKit ak10 = new AktorenKitLeistung10();
		AktorenKit aku = new AktorenKitLeistungUnlimitiert();
		
		
		//TEST
		//insert Hilfskraft mit falschem Skin
		fehlercode = shop.insert(seriennummer++, h, gS, new SoftwareHilfskraft(s1), ak1);
		printFehlercode(fehlercode);
		
		//insert Gesellschafter mit falschem AktorenKit
		fehlercode = shop.insert(seriennummer++, g, bS, new SoftwareGesellschafter(s1), ak10);
		printFehlercode(fehlercode);
		
		//insert Schwerarbeiter(ServiceTechniker) mit falschem AktorenKit (wegen zu geringer SoftwareStufe)
		fehlercode = shop.insert(seriennummer++, s, bS, new SoftwareServiceTechniker(s3), ak10);
		printFehlercode(fehlercode);
		
		//insert Schwerarbeiter(ServiceTechniker) mit korrektem AktorenKit (wegen passender SoftwareStufe im Vergleich zu vorigem Bsp.)
		fehlercode = shop.insert(seriennummer++, s, bS, new SoftwareServiceTechniker(s4), ak10);
		printFehlercode(fehlercode);
		
		//insert Transportarbeiter mit falschem AktorenKit
		fehlercode = shop.insert(seriennummer++, t, bS, new SoftwareTransportarbeiter(s3), aku);
		printFehlercode(fehlercode);
		
		//insert Schwerarbeiter mit falscher Software
		fehlercode = shop.insert(seriennummer++, b, bS, new SoftwareBauarbeiter(s2), ak1);
		printFehlercode(fehlercode);
		
		//insert Kaempfer mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, k, gS, new SoftwareKaempfer(s5), aku);
		printFehlercode(fehlercode);
		
		//insert Kaempfer mit falscher Software
		fehlercode = shop.insert(seriennummer++, k, gS, new SoftwareKaempfer(s4), aku);
		printFehlercode(fehlercode);
		
		//insert Transportarbeiter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, t, hS, new SoftwareTransportarbeiter(s3), ak5);
		printFehlercode(fehlercode);
		
		//insert Objektbewacher mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, o, bS, new SoftwareObjektbewacher(s4), ak10);
		printFehlercode(fehlercode);
		
		//insert Leibwaechter mit falschem Skin und falscher Software
		fehlercode = shop.insert(seriennummer++, l, gS, new SoftwareLeibwaechter(s2), ak1);
		printFehlercode(fehlercode);
		
		//insert Gesellschafter mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, g, bS, new SoftwareGesellschafter(s1), ak1);
		printFehlercode(fehlercode);
		
		//insert Service-Techniker mit falscher Software
		fehlercode = shop.insert(seriennummer++, s, gS, new SoftwareServiceTechniker(s5), ak10);
		printFehlercode(fehlercode);
		
		//insert Objektbewacher mit falschem Software-Typ
		fehlercode = shop.insert(seriennummer++, o, bS, new SoftwareKaempfer(s4), ak10);
		printFehlercode(fehlercode);
		
		//insert Hilfskraft mit zugelassenen Parametern
		fehlercode = shop.insert(seriennummer++, h, bS, new SoftwareHilfskraft(s1), ak1);
		printFehlercode(fehlercode);
		
		//einen Androiden suchen
		System.out.println("\nAndroide mit der Seriennummer 4: " + shop.find(4));
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide:");
		Iterator<AusgelieferterAndroide> iter1 = shop.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next().toString());
		
		System.out.println("\nVeraenderungen vornehmen:");
		//Androide veraendern
		fehlercode = shop.insert(7, k, bS, new SoftwareKaempfer(s5), ak5); // aenderung des Skins und Sensor-Aktor-Kit (erlaubt)
		printFehlercode(fehlercode);
		fehlercode = shop.insert(7, k, bS, new SoftwareKaempfer(s5), ak1); // aenderung des Sensor-Aktor-Kit (erlaubt)
		printFehlercode(fehlercode);
		fehlercode = shop.insert(9, k, bS, new SoftwareKaempfer(s5), aku); // unerlaupte Typaenderung
		printFehlercode(fehlercode);
		fehlercode = shop.insert(4, s, bS, new SoftwareServiceTechniker(s4), aku); //Ungueltiges AktorenKit
		printFehlercode(fehlercode);
		fehlercode = shop.insert(15, h, bS, new SoftwareHilfskraft(s2), ak1); // aenderung der Software-Stufe (verboten)
		printFehlercode(fehlercode);
		fehlercode = shop.insert(15, g, bS, new SoftwareGesellschafter(s1), ak1); // aenderung der Untertyps (erlaubt)
		printFehlercode(fehlercode);
		
		//alle Androiden ausgeben
		System.out.println("\nalle ausgelieferten Androide nach Veraenderung (inklusive Vorgaengerversionen):");
		iter1 = shop.iterator();
		while(iter1.hasNext()) {
			AusgelieferterAndroide a = iter1.next();
			System.out.println(a.toString());
			
			a = a.getVorgaenger();
			while (a != null) {
				System.out.println("\t"+a.toString());
				a = a.getVorgaenger();
			}
		}
		
		//alle Seriennummern ausgeben
		System.out.println("\nalle ausgelieferten anhand der Seriennummer (RoboShop.find):");
		for (int i = 1; i < seriennummer; i++) {
			System.out.println(i+":\t"+shop.find(i));
		}
	}
	
	private static void printFehlercode(String fehlercode) {
		if(fehlercode!=null) {
			System.out.println("FEHLER: "+ fehlercode);
		}
		else {
			System.out.println("OK");
		}
	}
}