
public class AutoSchnell extends Auto {
	public AutoSchnell(Feld feld, Position anfangsPosition) {
		super(feld, 100, anfangsPosition);
	}

	@Override
	protected Position bewegen(Position b) {
		return b.links();
	}
}
