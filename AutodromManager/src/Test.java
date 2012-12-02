
public class Test {
	public static void main(String[] args) {
		
		Feld f = new Feld(10,10);
		Position p1 = new Position(0,5,5);
		Position p2 = new Position(0,2,2);
		Auto abk1 = new AutoBeweglichKreis(f, p1);
		Auto ask1 = new AutoSchnellKreis(f,p2);
		Auto abg1 = new AutoBeweglichGerade(f);
		f.addCar(abk1);
		f.addCar(ask1);
		f.addCar(abg1);
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
