/**
 * implementiert ein bewegliches Auto, das immer im Kreis faehrt
 * hat die Geschwindigkeit eines beweglichen Autos
 * @author Lucas
 */
public class AutoBeweglichKreis extends AutoBeweglich {
	int bewegungen;
	
	/**
	 * Konstruktor des beweglichen Autos, das im Kreis faehrt
	 * @param feld Feld auf dem es fahren soll
	 * @param anfangsPosition Startposition (!null)
	 */
	public AutoBeweglichKreis(Feld feld, Position anfangsPosition, int maxBewegungen, String name) {
		super(feld, anfangsPosition, maxBewegungen, name);
		
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
		//0 <= bewegungen <= 20
		bewegungen++;
		
		if(bewegungen == 5 || bewegungen == 10 || bewegungen == 15)
			return b.links();
		else if(bewegungen == 20){
			bewegungen = 0;
			return b.links();
		}
		else
			return b.vorwaerts();
	}
}
