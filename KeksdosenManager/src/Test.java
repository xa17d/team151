
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
		
		//Kekse
		EinfacherKeks runderKeks = new EinfacherKeks(rundeForm, schokoTeig);
		EinfacherKeks mondKeks = new EinfacherKeks(mondForm, muerbTeig);
		EinfacherKeks weihnachtsmannKeks = new EinfacherKeks(weihnachtsmannForm, zimtsternTeig);
		Keks doppelKeks = new DoppelKeks(runderKeks, runderKeks, schokoFuellung);
		
		//Keksdose
		Keksdose kd = new Keksdose();
		kd.addKeks(runderKeks);
		kd.addKeks(mondKeks);
		kd.addKeks(weihnachtsmannKeks);
		kd.addKeks(doppelKeks);
		
		kd.inhalt();
		
		// Baeckerei
		Baeckerei baeckerei = new Baeckerei();
		Bestellung bestellung = new Bestellung();
		bestellung.addPosition(new Position(5, weihnachtsmannForm, muerbTeig, null));
		bestellung.addPosition(new Position(15, rundeForm, zimtsternTeig, null));
		bestellung.addPosition(new Position(15, mondForm, schokoTeig, null));
		bestellung.addPosition(new Position(5, weihnachtsmannForm, schokoTeig, marmeladenFuellung));
		bestellung.drucke();
		
		kd = baeckerei.backen(bestellung);
		
		kd.inhalt();
	}
}
