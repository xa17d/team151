/**
 * Leitet nur bestimmte Items an das output-Iteraion-Objekt weiter
 * @author Daniel
 *
 */
@AuthorAnnotation(author="Daniel")
public abstract class IterationFilter extends Iteration {
	/**
	 * Erstellt einen neuen Filter
	 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
	 */
	@AuthorAnnotation(author="Daniel")
	public IterationFilter(Iteration output) {
		this.output = output;
	}
	
	private Iteration output;
	/**
	 * Leitet ein bestimmtes Element an das output-Iteraion-Objekt weiter (ruft output.iteration auf)
	 * @param item Element
	 */
	@AuthorAnnotation(author="Daniel")
	protected void Out(IteratableObject item) {
		output.iteration(item);
	}
}
