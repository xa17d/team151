/**
 * 
 * @author Lucas
 *
 */
public class AutoBeweglichKreis extends AutoBeweglich {
	int bewegungen;
	
	public AutoBeweglichKreis(Feld feld, Position anfangsPosition) {
		super(feld, anfangsPosition);
		
		bewegungen = 0;
	}
	
	@Override
	protected Position bewegen(Position b) {
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
