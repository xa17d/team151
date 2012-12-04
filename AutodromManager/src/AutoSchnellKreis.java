/**
 * implementiert ein schnelles Auto, das immer im Kreis faehrt
 * hat die Geschwindigkeit eines schnellen Autos
 * @author Lucas
 */
public class AutoSchnellKreis extends AutoSchnellZufall {
	int bewegungen;
	
	/**
	 * Konstruktor des schnellen Autos, das im Kreis faehrt
	 * @param feld Feld auf dem es fahren soll
	 * @param anfangsPosition Startposition (!null)
	 */
	public AutoSchnellKreis(Feld feld, Position anfangsPosition) {
		super(feld, anfangsPosition);

		bewegungen = 0;
	}
	
	/**
	 * Wird im festgelegten Intervall aufgerufen.
	 * Das Auto faehr im Kreis
	 * @param p Aktuelle Position und Richtung des Autos (niemals null)
	 * @return Position und Richtung des Autos nach diesem Bewegungsschritt (niemals null)
	 */
	@Override
	protected Position bewegen(Position b) {
		//0 <= bewegungen <= 16
		bewegungen++;		
		
		if(bewegungen == 3 || bewegungen == 4 || bewegungen == 7 || bewegungen == 8 || bewegungen == 11 || bewegungen == 12 || bewegungen == 15)
			return b.halbRechts();
		else if(bewegungen == 16){
			bewegungen = 0;
			return b.halbRechts();
		}
		else
			return b.vorwaerts();
	}
}
