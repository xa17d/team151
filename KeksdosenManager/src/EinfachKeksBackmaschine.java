/**
 * Backmaschine die einen einfachen Keks baeckt
 * @author lucas
 */
public class EinfachKeksBackmaschine {
	Form form;
	
	/**
	 * Konstruktor
	 * @param form Form der Kekse die Backmaschine backen kann != null
	 */
	public EinfachKeksBackmaschine(Form form) {
		this.form = form;
	}
	
	/**
	 * baeckt einen neuen Keks
	 * @param teig Teigart != null
	 * @return neuer Keks
	 */
	public EinfacherKeks backeKeks(Teig teig) {
		return new EinfacherKeks(form, teig);
	}
}
