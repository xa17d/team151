/**
 * Bewegliches Auto. Bewegt sich in einem Interval von 200ms
 * @author Daniel
 */
public abstract class AutoBeweglich extends Auto {
	public AutoBeweglich(Feld feld, Position anfangsPosition, int maxBewegungen, String name) {
		super(feld, anfangsPosition, 100, maxBewegungen, name);
	}
}
