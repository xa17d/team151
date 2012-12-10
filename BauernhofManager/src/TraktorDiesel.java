
public class TraktorDiesel extends Traktor {
	public TraktorDiesel(int id) { super(id); }
	
	@Override
	public void interationTyp(Iteration iteration) {
		iteration.iterationTraktorDiesel(this);
	}
}
