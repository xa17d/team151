
public class TraktorDiesel extends Traktor {
	public TraktorDiesel(int id) { super(id); }
	@Override
	public boolean iteration(Iteration iteration) {
		return iteration.iterationTraktorDiesel(this);
	}
}
