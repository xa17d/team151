/**
 * Leitet nur bestimmte Items an das output-Iteraion-Objekt weiter
 * @author Daniel
 *
 */
public abstract class IterationFilter extends Iteration {
	/**
	 * Erstellt einen neuen Filter
	 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
	 */
	public IterationFilter(Iteration output) {
		this.output = output;
	}
	
	private Iteration output;
	/**
	 * Leitet ein bestimmtes Element an das output-Iteraion-Objekt weiter (ruft output.iteration auf)
	 * @param item Element
	 */
	protected void Out(IteratableObject item) {
		output.iteration(item);
	}
}
