
public abstract class Traktor implements IteratableObject {
	public Traktor(int id) { this.id = id; }
	private int id;
	public int getId() { return id; }
	private Modul modul;
	public Modul getModul() { return modul; }
	
	@Override
	public final void iteration(Iteration iteration) {
		iteration.iterationTraktor(this);
	}
	
	public abstract void interationTyp(Iteration iteration);
	
	public void interationModul(Iteration iteration) {
		modul.interationModul(iteration, this);
	}
}
