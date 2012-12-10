/**
 * Repraesentier einen Bauernhof
 * @author Daniel
 */
public class Bauernhof implements IteratableObject {

	/**
	 * Erstellt einen neuen Bauernhof mit bestimmten Namen
	 * @param name Name (!=null)
	 */
	public Bauernhof(String name) {
		this.name = name;
	}
	
	/**
	 * Name des Bauernhofs (ist niemals null)
	 */
	private String name;
	/**
	 * TraktorSet in dem die Traktoren des Bauernhofs gespeichert werden
	 */
	private TraktorSet traktors = new TraktorSet();
	
	/**
	 * @return Name des Bauernhofs
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Fuegt einen Traktor dem Bauernhof hinzu
	 * @param item Neuer Traktor
	 */
	public void addTraktor(Traktor item) {
		traktors.insert(item);
	}
	
	/**
	 * Entfernt einen Traktor vom Bauernhof
	 * @param item zu entfernender Traktor
	 */
	public void removeTraktor(Traktor item) {
		traktors.remove(item);
	}
	
	/**
	 * Traktor anhand seiner eindeutigen Nummer finden
	 * @param id Eindeutige Nummer
	 * @return Traktor mit gesuchter Nummer, null falls sich der Traktor nicht auf diesem Bauernhof befindet 
	 */
	public Traktor getTraktor(int id) {
		return traktors.get(id);
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean iteration(Iteration iteration) {
		return iteration.iterationBauernhof(this);		
	}
}
