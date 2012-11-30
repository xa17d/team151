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
		return b.halbRechts();
	}
}
