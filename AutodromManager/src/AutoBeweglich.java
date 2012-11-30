import java.util.Random;

/**
 * Bewegliches Auto. Bewegt sich in einem Interval von 200ms
 * @author Daniel
 */
public class AutoBeweglich extends Auto {
	public AutoBeweglich(Feld feld, Position anfangsPosition) {
		super(feld, 200, anfangsPosition);
	}

	@Override
	protected Position bewegen(Position b) {
		System.out.println(new Random().nextInt(3));
		return b.halbRechts();
	}
}
