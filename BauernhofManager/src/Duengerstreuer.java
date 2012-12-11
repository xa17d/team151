/**
 * stellt ein Modul des Typs Duengerstreuer dar
 * @author Lucas
 */
@ClassAuthorAnnotation(author="Lucas", className="Duengerstreuer")
public class Duengerstreuer extends Modul {
	private double fassungskapazitaet;
	
	/**
	 * Konstruktor
	 * erzeugt neuen Duengerstreuer
	 * @param fassungskapazitaet Fassungskapazitaet > 0
	 */
	@MethodAuthorAnnotation(author="Lucas", methodName="Duengerstreuer-Konstruktor")
	public Duengerstreuer(double fassungskapazitaet) {
		this.fassungskapazitaet = fassungskapazitaet;
	}
	
	/**
	 * liefert die Fassungskapazitaet des Duengerstreuers
	 * @return Fassungskapazitaet > 0
	 */
	@MethodAuthorAnnotation(author="Lucas", methodName="getFassungskapazitaet")
	public double getFassungskapazitaet() {
		return fassungskapazitaet;
	}
	
	@Override
	@MethodAuthorAnnotation(author="Lucas", methodName="iterationModul")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDuengerstreuer(this, traktor);
	}
}
