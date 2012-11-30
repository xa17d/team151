import java.util.Random;

/**
 * Schnelles Auto. Bewegt sich in einem Interval von 100ms
 * @author Daniel
 */
public class AutoSchnell extends Auto {
	public AutoSchnell(Feld feld, Position anfangsPosition) {
		super(feld, 100, anfangsPosition);
	}

	@Override
	protected Position bewegen(Position b) {
		int i = new Random().nextInt(3);
		System.out.println(i);
		if(i == 0)
			return b.halbRechts();
		if(i == 1)
			return b.halbLinks();
		//sonst
			return b.vorwaerts();
	}
}
