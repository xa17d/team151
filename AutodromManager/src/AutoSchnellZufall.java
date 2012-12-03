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
		Position neu = null;
		if(i == 0){ //Vorwaerts
			neu = b.vorwaerts();
			if(!(1 < neu.getX() && neu.getX()< getFieldWidth() - 1 && 1 < neu.getY() && neu.getY() < getFieldHeight() - 1))
				neu = bewegen(b);
		}
		else if(i == 1){ //Rechts
			neu = b.halbRechts();
			if(!(1 < neu.getX() && neu.getX()< getFieldWidth() - 1 && 1 < neu.getY() && neu.getY() < getFieldHeight() - 1))
				neu = bewegen(b);
		}
		else{ //Links
			neu = b.halbLinks();
			if(!(1 < neu.getX() && neu.getX()< getFieldWidth() - 1 && 1 < neu.getY() && neu.getY() < getFieldHeight() - 1))
				neu = bewegen(b);
		}
		return neu;
	}
}
