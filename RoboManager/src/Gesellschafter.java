
public class Gesellschafter extends Bediener{

	@Override
	public String checkSoftware(Software software) {
		return software.vonGesellschafterVerwendet(this);
	}

	@Override
	public String toString() {
		return "Gesellschafter";
	}
}
