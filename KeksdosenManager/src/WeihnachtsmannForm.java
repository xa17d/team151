/**
 * 
 * @author raphael, lucas
 *
 */
public class WeihnachtsmannForm extends Form {
	private EinfachKeksBackmaschine backmaschine;
	
	public WeihnachtsmannForm() {
		backmaschine = new EinfachKeksBackmaschine(this);
	}

	@Override
	public EinfacherKeks backeForm(Teig teigart) {
		return backmaschine.backeKeks(teigart);
	}
	
	@Override
	public String toString(){
		return "Weihnachtsmannfoermig";
	}
}
