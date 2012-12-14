/**
 * Position einer Bestellung.
 * Sie gibt jeweils die Anzahl, Form, Teigart und Fuelle (wenn Doppelkekse gewuenscht sind, sonst keine Fuelle) an
 * @author daniel
 */
public class Position {
	/**
	 * Erstellt eine neue Position
	 * @param anzahl Anzahl der Kekse dieser Art
	 * @param form Form der Kekse
	 * @param teig Teig der neuen Keks
	 * @param fuellung Fuellung wenn es sich um einen Doppelkeks handelt, null fuer einen einfachen Kekes.
	 */
	public Position(int anzahl, Form form, Teig teig, Fuellung fuellung) {
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = fuellung;
	}
	
	/**
	 * Anzahl der Kekse dieser Art
	 */
	private int anzahl;
	/**
	 * Form der neuen Kekse
	 */
	private Form form;
	/**
	 * Teig der neuen Keks
	 */
	private Teig teig;
	/**
	 * Fuellung wenn es sich um einen Doppelkeks handelt, null fuer einen einfachen Kekes.
	 */
	private Fuellung fuellung;
	
	/**
	 * @return Anzahl der Kekse dieser Art zurueck
	 */
	public int getAnzahl() { return anzahl; }
	/**
	 * @return Form der neuen Kekse
	 */
	public Form getForm() { return form; }
	/**
	 * @return Teig der neuen Keks
	 */
	public Teig getTeig() { return teig; }
	/**
	 * @return Fuellung wenn es sich um einen Doppelkeks handelt, null fuer einen einfachen Kekes.
	 */
	public Fuellung getFuellung() { return fuellung; }
	
	@Override
	public String toString() {
		return getAnzahl()+"x "+getForm()+" "+getTeig()+(fuellung != null ? " "+fuellung : "");
	}
}
