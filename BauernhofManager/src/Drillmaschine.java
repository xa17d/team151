@ClassAuthorAnnotation(author="Lucas", className="Drillmaschine")
public class Drillmaschine extends Modul {
	@Override
	@MethodAuthorAnnotation(author="Lucas", methodName="iterationModul")
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDrillmaschine(this, traktor);
	}
	
	
}
