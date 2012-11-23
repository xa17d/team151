/**
 * @author OOP151
 */
public class Test {
	public static void main(String[] args) {
		String fehlercode = "";
		
		RoboShop shop = new RoboShop();
		Androide h = new Hilfskraft();
		Skin gS = new gepanzerterSkin();
		Skin bS = new beruehrungssensitiverSkin();
		
		fehlercode = shop.insert(1, h, gS);
		if(!fehlercode.equals(""))
			System.out.println("FEHLER: "+ fehlercode);
		
		fehlercode = shop.insert(1, h, bS);
		if(!fehlercode.equals(""))
			System.out.println("FEHLER: "+ fehlercode);
	}
}