/**
 * 
 * @author raphael, lucas
 *
 */
public class MondForm extends Form{
	private EinfachKeksBackmaschine backmaschine;
	
	public MondForm() {
		backmaschine = new EinfachKeksBackmaschine(this);
	}

	@Override
	public EinfacherKeks backeForm(Teig teigart) {
		return backmaschine.backeKeks(teigart);
	}
	
	@Override
	public String toString(){
		return "Mondfoermig";
	}
}
