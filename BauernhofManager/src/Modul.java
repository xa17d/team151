/**
 * stellt ein Modul eines Traktors dar
 * @author Lucas
 */
@AuthorAnnotation(author="Lucas")
public abstract class Modul {
	
	/**
	 * Ruft je nach Untertyp von Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer auf
	 * @param iteration Iterator
	 * @param traktor Traktor zu dem Modul gehoert != null
	 */
	@AuthorAnnotation(author="Lucas")
	public abstract void interationModul(Iteration iteration, Traktor traktor);
}
