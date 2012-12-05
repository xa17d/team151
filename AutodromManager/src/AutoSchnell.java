/**
 * Schnelles Auto. Bewegt sich zufaellig in einem Interval von 100ms
 * @author Daniel 
 */
public abstract class AutoSchnell extends Auto {
	public AutoSchnell(Feld feld, Position anfangsPosition, int maxBewegungen, String name) {
		super(feld, anfangsPosition, 50, maxBewegungen, name);
	}
}
