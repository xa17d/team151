
public class Bauernhof {
	public Bauernhof(String name) {
		this.name = name;
	}
	
	private String name;
	private TraktorSet traktors = new TraktorSet();
	
	public void addTraktor(Traktor item) {
		traktors.insert(item);
	}
	
	public void removeTraktor(Traktor item) {
		traktors.remove(item);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
