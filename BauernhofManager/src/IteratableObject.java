/**
 * Objekt das in ein Set eingefuegt werden kann
 * @author Daniel
 */
@AuthorAnnotation(author="Daniel")
public interface IteratableObject {
	/**
	 * Methode, die je nach Typ die entsprechende Methode in interation aufruft.
	 * @param iteration Iteration (!=null)
	 */
	@AuthorAnnotation(author="Daniel")
	public void iteration(Iteration iteration);
}
