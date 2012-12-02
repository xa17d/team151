
public class Test {
	public static void main(String[] args) {
		
		Feld f = new Feld(10,10);
		Position p1 = new Position(0,5,5);
		Position p2 = new Position(0,2,2);
		Position p3 = new Position(90, 6, 6);
		Auto abk1 = new AutoBeweglichKreis(f, p1);
		Auto ask1 = new AutoSchnellKreis(f,p2);
		Auto abg1 = new AutoBeweglichGerade(f);
		Auto asz1 = new AutoSchnellZufall(f, p3);
		f.addCar(abk1);
		f.addCar(ask1);
		f.addCar(abg1);
		f.addCar(asz1);
		f.startRace();
		while (f.isRace()) {
			try {
				System.out.println(f.toString());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
