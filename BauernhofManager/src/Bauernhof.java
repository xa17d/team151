
public class Bauernhof {

	/**
	 * Erstellt einen neuen Bauernhof mit bestimmten Namen
	 * @param name Name (!=null)
	 */
	public Bauernhof(String name) {
		this.name = name;
	}
	
	private String name;
	private TraktorSet traktors = new TraktorSet();
	
	public String getName() {
		return name;
	}
	
	public void addTraktor(Traktor item) {
		traktors.insert(item);
	}
	
	public void removeTraktor(Traktor item) {
		traktors.remove(item);
	}
	
	public Traktor getTraktor(int id) {
		return traktors.get(id);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
