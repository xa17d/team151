
public class Test {
	public static void main(String[] args) {
		
		Feld f = new Feld();
		Position b = new Position(0,0,0);
		AutoSchnell a = new AutoSchnell(f, b);
		a.start();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
