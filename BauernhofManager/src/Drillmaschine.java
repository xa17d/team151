
public class Drillmaschine extends Modul {
	@Override
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDrillmaschine(this, traktor);
	}
}
