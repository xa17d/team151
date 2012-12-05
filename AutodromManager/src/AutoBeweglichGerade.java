/**
 * 
 * @author Lucas
 *
 */
public class AutoBeweglichGerade extends AutoBeweglich {
	int bewegungen;
	Feld feld;
	
	public AutoBeweglichGerade(Feld feld, Position anfangsPosition, int maxBewegungen, String name) {		
		super(feld, anfangsPosition, maxBewegungen, name);
		
		this.feld = feld;
		bewegungen = -1;
	}
	
	@Override
	protected Position bewegen(Position b) {
		bewegungen++;
		
		if(bewegungen == feld.getWidth() - 1)
			return b.links();
		if(bewegungen == feld.getWidth())
			return b.links();
		if(bewegungen == 2*(feld.getWidth()) - 1)
			return b.links();
		else if(bewegungen == 2*(feld.getWidth())){
			bewegungen = 0;
			return b.links();
		}
		else
			return b.vorwaerts();
	}
}
