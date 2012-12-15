
public class Test {
	public static void main(String[] args) {
		//Teig
		Teig schokoTeig = new Schokoladenteig();
		Teig muerbTeig = new Muerbteig();
		Teig zimtsternTeig = new Zimtsternteig();
		
		//Form
		Form rundeForm = new RundeForm();
		Form mondForm = new MondForm();
		Form weihnachtsmannForm = new WeihnachtsmannForm();
		
		//Fuellung
		Fuellung schokoFuellung = new Schokoladenfuellung();
		Fuellung marmeladenFuellung = new Marmeladenfuellung();
		
		//neue Baeckerei
		Baeckerei baeckerei = new Baeckerei();
		Keksdose kd = new Keksdose();
		
		//Bestellung 1
		Bestellung bestellung1 = new Bestellung();
		bestellung1.addPosition(new Position(5, weihnachtsmannForm, muerbTeig, null));
		bestellung1.addPosition(new Position(15, rundeForm, zimtsternTeig, null));
		bestellung1.addPosition(new Position(15, mondForm, schokoTeig, null));
		bestellung1.addPosition(new Position(5, weihnachtsmannForm, schokoTeig, marmeladenFuellung));
		
		System.out.println("** 1. Bestellung: Bestellliste **");
		bestellung1.drucke();
		
		kd = baeckerei.backen(bestellung1);
		
		System.out.println("\n** 1. Bestellung: Keksdose **");
		kd.inhalt();
		
		//Bestellung 2
		Bestellung bestellung2 = new Bestellung();
		bestellung2.addPosition(new Position(2, rundeForm, muerbTeig, schokoFuellung));
		bestellung2.addPosition(new Position(4, rundeForm, muerbTeig, null));
		bestellung2.addPosition(new Position(1, weihnachtsmannForm, zimtsternTeig, null));
		
		System.out.println("\n\n** 2. Bestellung: Bestellliste **");
		bestellung2.drucke();
		
		kd = baeckerei.backen(bestellung2);
		
		System.out.println("\n** 2. Bestellung: Keksdose **");
		kd.inhalt();
	}
}
