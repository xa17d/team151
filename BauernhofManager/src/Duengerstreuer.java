
public class Duengerstreuer extends Modul {
	@Override
	public void interationModul(Iteration iteration, Traktor traktor) {
		iteration.iterationModulDuengerstreuer(this, traktor);
	}
}
