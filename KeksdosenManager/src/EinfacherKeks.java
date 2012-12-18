/**
 * 
 * @author raphael, lucas
 *
 */
public class EinfacherKeks extends Keks{
	private Form form;
	private Teig teigart;
	
	/**
	 * EinfacherKeks Konstruktor
	 * @param form (darf nicht null sein)
	 * @param teigart (darf nicht null sein)
	 */
	public EinfacherKeks (Form form, Teig teigart){
		this.form = form;
		this.teigart = teigart;
	}
	
	/**
	 * Form Getter
	 * @return form (nicht null)
	 */
	public Form getForm() { return form; }
	
	/**
	 * Teigart Getter
	 * @return teigart (nicht null)
	 */
	public Teig getTeigart() { return teigart; }
	
	@Override
	public String toString(){
		return "Einfacher Keks mit Teigart: " + teigart.toString() + " Form: " + form.toString();
	}
	
	@Override
	protected EinfacherKeks clone() {
		return new EinfacherKeks(form, teigart);
	}
}
