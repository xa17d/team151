
public class Kaempfer extends Beschuetzer{

	@Override
	public String checkSoftware(Software software) {
		return software.vonKaempferVerwendet(this);
	}

	@Override
	public String toString() {
		return "Kaempfer";
	}
}
