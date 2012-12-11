@ClassAuthorAnnotation(author="Lucas", className="Modul")
public abstract class Modul {
	
	/**
	 * Ruft je nach Untertyp von Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer auf
	 * @param iteration Iterator
	 * @param traktor Traktor zu dem Modul gehoert != null
	 */
	@MethodAuthorAnnotation(author="Lucas", methodName="iterationModul")
	public abstract void interationModul(Iteration iteration, Traktor traktor);
}
