/**
 * stellt ein Modul des Typs Duengerstreuer dar
 * @author Lucas
 */
@AuthorAnnotation(author="Lucas")
public class Duengerstreuer extends Modul {
	private double fassungskapazitaet;
	
	/**
	 * Konstruktor
	 * erzeugt neuen Duengerstreuer
	 * @param fassungskapazitaet Fassungskapazitaet > 0
	 */
	@AuthorAnnotation(author="Lucas")
	public Duengerstreuer(double fassungskapazitaet) {
		this.fassungskapazitaet = fassungskapazitaet;
	}
	
	/**
	 * liefert die Fassungskapazitaet des Duengerstreuers
	 * @return Fassungskapazitaet > 0
	 */
	@AuthorAnnotation(author="Lucas")
	public double getFassungskapazitaet() {
		return fassungskapazitaet;
	}
	
	@Override
	@AuthorAnnotation(author="Lucas")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDuengerstreuer(this, traktor);
	}
}
