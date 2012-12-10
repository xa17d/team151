
public class Traktor implements IteratableObject {
	public Traktor(int id) { this.id = id; }
	private int id;
	public int getId() { return id; }
	
	@Override
	public boolean iteration(Iteration iteration) {
		return iteration.iterationTraktor(this);
	}
}
