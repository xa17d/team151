/**
 * 
 * @author raphael, lucas
 *
 */
public class RundeForm extends Form{
	private EinfachKeksBackmaschine backmaschine;
	
	public RundeForm() {
		backmaschine = new EinfachKeksBackmaschine(this);
	}

	@Override
	public EinfacherKeks backeForm(Teig teigart) {
		return backmaschine.backeKeks(teigart);
	}
	
	@Override
	public String toString(){
		return "Rund";
	}
}
