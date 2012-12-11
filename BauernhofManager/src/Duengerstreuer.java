@ClassAuthorAnnotation(author="Lucas", className="Duengerstreuer")
public class Duengerstreuer extends Modul {
	@Override
	@MethodAuthorAnnotation(author="Lucas", methodName="iterationModul")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDuengerstreuer(this, traktor);
	}
	
	
}
