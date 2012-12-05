
public class Test {
	public static void main(String[] args) {

		// Test1
		System.out.println("Test 1:");
		Feld f = new Feld(10,10);
		Position p1 = new Position(0,5,5);
		Position p2 = new Position(0,2,2);
		Position p3 = new Position(0,1,3);
		Position p4 = new Position(0,0,3);
		
		Auto abk1 = new AutoBeweglichKreis(f, p1, 30, "A"); // maximale Schritte so eingestellt, dass die Simulation max. 3 Sekunden dauert.
		Auto ask1 = new AutoSchnellKreis(f,p2, 60, "B");
		Auto ask2 = new AutoSchnellKreis(f,p3, 60, "C");
		Auto abg1 = new AutoBeweglichGerade(f, p4, 30, "D");
		f.addCar(abk1);
		f.addCar(ask1);
		f.addCar(ask2);
		f.addCar(abg1);
		f.startRace();
		while (f.isRace()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Test2
		System.out.println("\nTest 2:");
		f = new Feld(10,10);

		Position p5 = new Position(0,0,3);
		Position p6 = new Position(0,1,3);
		
		Auto abg3 = new AutoBeweglichGerade(f, p5, 30, "E");
		Auto abg4 = new AutoBeweglichGerade(f, p6, 30, "F");
		f.addCar(abg3);
		f.addCar(abg4);
		f.startRace();
		while (f.isRace()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Test3
		System.out.println("\nTest 3:");
		f = new Feld(10,15);

		Position p7 = new Position(0,0,3);
		Position p8 = new Position(0,1,3);
		Position p9 = new Position(0,2,3);
		Position p10 = new Position(0,3,3);
		Position p11 = new Position(0,4,3);
		Position p12 = new Position(0,5,3);
		
		Auto abg5 = new AutoBeweglichGerade(f, p7, 30, "G");
		Auto abg6 = new AutoBeweglichGerade(f, p8, 30, "H");
		Auto abk2 = new AutoBeweglichKreis(f, p9, 30, "I");
		Auto ask3 = new AutoSchnellKreis(f,p10, 60, "J");
		Auto abk4 = new AutoBeweglichKreis(f, p11, 30, "K");
		Auto ask4 = new AutoSchnellKreis(f,p12, 60, "L");
		f.addCar(abg5);
		f.addCar(abg6);
		f.addCar(abk2);
		f.addCar(ask3);
		f.addCar(abk4);
		f.addCar(ask4);
		f.startRace();
		while (f.isRace()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
