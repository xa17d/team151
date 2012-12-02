import java.util.Random;

/**
 * Schnelles Auto. Bewegt sich zufaellig in einem Interval von 100ms
 * @author Daniel, Raphael
 */
public class AutoSchnellZufall extends Auto {
	public AutoSchnellZufall(Feld feld, Position anfangsPosition) {
		super(feld, /*100 TEST:*/ 100, anfangsPosition);
	}

	@Override
	protected Position bewegen(Position b) {
		int i = new Random().nextInt(3);
		if(i == 0){
			if(b.halbRechts().getX() > 1 && b.halbRechts().getY() > 1 && b.halbRechts().getX() < getFieldWidth() - 1 && b.halbRechts().getY() < getFieldHeight() - 1)
				return b.halbRechts();
			else
				return bewegen(b);
		}
		else if(i == 1){
			if(b.halbRechts().getX() > 1 && b.halbRechts().getY() > 1 && b.halbRechts().getX() < getFieldWidth() - 1 && b.halbRechts().getY() < getFieldHeight() - 1)
				return b.halbLinks();
			else
				return bewegen(b);
		}
		else{
			if(b.halbRechts().getX() > 1 && b.halbRechts().getY() > 1 && b.halbRechts().getX() < getFieldWidth() - 1 && b.halbRechts().getY() < getFieldHeight() - 1)
				return b.vorwaerts();
			else
				return bewegen(b);
		}
	}
}
