
public class TraktorBiogas extends Traktor {
	public TraktorBiogas(int id) { super(id); }
	@Override
	public boolean iteration(Iteration iteration) {
		return iteration.iterationTraktorBiogas(this);
	}
}
