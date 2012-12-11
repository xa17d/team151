/**
 * stellt ein Modul des Typs Drillmaschine dar
 * @author Lucas
 */
@ClassAuthorAnnotation(author="Lucas", className="Drillmaschine")
public class Drillmaschine extends Modul {
	private int anzahlSaehscharen;
	
	/**
	 * Konstruktor
	 * erzeugt neue Drillmaschine
	 * @param anzahlSaescharen Anzahl der Saescheren > 0
	 */
	@MethodAuthorAnnotation(author="Lucas", methodName="Drillmaschine-Konstruktor")
	public Drillmaschine(int anzahlSaescharen) {
		this.anzahlSaehscharen = anzahlSaescharen;
	}
	
	/**
	 * liefert die Anzahl der Saescheren des Duengerstreuers
	 * @return Anzahl der Saescheren > 0
	 */
	@MethodAuthorAnnotation(author="Lucas", methodName="getAnzahlSaehscharen")
	public int getAnzahlSaehscharen() {
		return anzahlSaehscharen;
	}
	
	@Override
	@MethodAuthorAnnotation(author="Lucas", methodName="iterationModul")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDrillmaschine(this, traktor);
	}
}
