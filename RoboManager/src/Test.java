/**
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
		String fehlercode = "";
		
		RoboShop shop = new RoboShop();
		
		Androide h = new Hilfskraft();
		Androide g = new Gesellschafter();
		Androide b = new Bauarbeiter();
		Androide k = new Kaempfer();
		
		Skin bS = new beruehrungssensitiverSkin();
		Skin hS = new hochfesterSkin();
		Skin gS = new gepanzerterSkin();
		
		Software s1 = new SoftwareStufe1();
		Software s2 = new SoftwareStufe2();
		Software s3 = new SoftwareStufe3();
		Software s4 = new SoftwareStufe4();
		Software s5 = new SoftwareStufe5();
		
		//insert Hilfskraft mit falschem Skin
		fehlercode = shop.insert(1, h, gS, s1);
		if(!fehlercode.equals(""))
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Schwerarbeiter mit falscher Software
		fehlercode = shop.insert(1, b, bS, s2);
		if(!fehlercode.equals(""))
			System.out.println("FEHLER: "+ fehlercode);
		
		//insert Kaempfer mit zugelassenen Parametern
		fehlercode = shop.insert(1, k, gS, s5);
		if(!fehlercode.equals(""))
			System.out.println("FEHLER: "+ fehlercode);
	}
}