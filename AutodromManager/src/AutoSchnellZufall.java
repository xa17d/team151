import java.util.Random;

/**
 * Schnelles Auto. Bewegt sich zufaellig in einem Interval von 100ms
 * @author Daniel, Raphael
 */
public class AutoSchnellZufall extends AutoSchnell {
	public AutoSchnellZufall(Feld feld, Position anfangsPosition) {
		super(feld, anfangsPosition);
	}

	/**
	 * Auto bewegt sich zufaellig vor, links oder nach rechts.
	 * Da ein schnelles Auto in einer Ecke gefangen sein kann
	 * wird dies verhindert.
	 * @param b Position an die sich das Auto hinbewegen soll.
	 * @return neue gueltige Position
	 */
	@Override
	protected Position bewegen(Position b) {
		int i = new Random().nextInt(3);
		Position neu = null;
		if(i == 0){ //Vorwaerts
			neu = b.vorwaerts();
		}
		else if(i == 1){ //Rechts
			neu = b.halbRechts();
		}
		else{ //Links
			neu = b.halbLinks();
		}
		if(!(((neu.getRichtung() == 90 || neu.getRichtung() ==-270) && 0 < neu.getY())
				&& (neu.getRichtung() == 0 && neu.getX() < getFieldWidth())
				&& (Math.abs(neu.getRichtung()) == 180 && 0 < neu.getX())
				&& (neu.getRichtung() == -90 || neu.getRichtung() == 90) && neu.getY() < getFieldHeight())){
			neu = bewegen(b);
		}
		return neu;
	}
}
