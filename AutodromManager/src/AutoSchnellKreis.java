/**
 * 
 * @author Lucas
 *
 */
public class AutoSchnellKreis extends AutoSchnellZufall {
	int bewegungen;
	
	public AutoSchnellKreis(Feld feld, Position anfangsPosition) {
		super(feld, anfangsPosition);
		
		bewegungen = 0;
	}
	
	@Override
	protected Position bewegen(Position b) {
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
