/**
 * Schnelles Auto. Bewegt sich zufaellig in einem Interval von 100ms
 * @author Daniel 
 */
public abstract class AutoSchnell extends Auto {
	public AutoSchnell(Feld feld, Position anfangsPosition) {
		super(feld, 100, anfangsPosition);
	}
}
