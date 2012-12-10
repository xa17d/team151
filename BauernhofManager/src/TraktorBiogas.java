
public class TraktorBiogas extends Traktor {
	public TraktorBiogas(int id) { super(id); }
	
	@Override
	public void interationTyp(Iteration iteration) {
		iteration.iterationTraktorBiogas(this);
	}
}
