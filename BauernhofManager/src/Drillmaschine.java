/**
 * stellt ein Modul des Typs Drillmaschine dar
 * @author Lucas
 */
@AuthorAnnotation(author="Lucas")
public class Drillmaschine extends Modul {
	private int anzahlSaehscharen;
	
	/**
	 * Konstruktor
	 * erzeugt neue Drillmaschine
	 * @param anzahlSaescharen Anzahl der Saescheren > 0
	 */
	@AuthorAnnotation(author="Lucas")
	public Drillmaschine(int anzahlSaescharen) {
		this.anzahlSaehscharen = anzahlSaescharen;
	}
	
	/**
	 * liefert die Anzahl der Saescheren des Duengerstreuers
	 * @return Anzahl der Saescheren > 0
	 */
	@AuthorAnnotation(author="Lucas")
	public int getAnzahlSaehscharen() {
		return anzahlSaehscharen;
	}
	
	@Override
	@AuthorAnnotation(author="Lucas")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDrillmaschine(this, traktor);
	}
}
