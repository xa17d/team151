
public class Test {
	public static void main(String[] args) {
		
		Feld f = new Feld(10,10);
		Position b = new Position(0,0,0);
		AutoSchnell a = new AutoSchnell(f, b);
		f.addCar(a);
		f.startRace();
		while (true) {
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
