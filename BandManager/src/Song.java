/**
 * Repraesentiert ein Musikstueck
 *
 */
public class Song {
	
	/**
	 * Erzeugt ein neues Song Objekt und gibt es zurueck
	 * FEHLER: es sollte sichergestellt werden, dass name nicht null ist.
	 */
	public Song() {}
	/**
	 * Erzeugt ein neues Song Objekt und gibt es zurueck
	 * @param name Name des Songs, darf nicht null sein
	 * @param duration Dauer des Songs in Sekunden, dauer >= 0
	 */
	public Song(String name, int duration)
	{
		setName(name);
		setDuration(duration);
	}
	
	private String name; // Name des Songs, darf nicht null sein
	private int duration; // Dauer des Songs in Sekunden, dauer >= 0

	/**
	 * Gibt den Namen des Songs zurueck
	 * @return Name des Songs
	 */
	public String getName() { return name; }
	/**
	 * Setzt den Namen des Songs
	 * @param name neuer Name, darf nicht null sein
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Gibt die Laenge des Stuecks in Sekunden zurueck
	 * @return Laenge des Stuecks
	 */
	public int getDuration() { return duration; }
	/**
	 * Setzt die Laenge des Musikstuecks
	 * @param duration neue Laenge in Sekunden, muss >= 0 sein
	 */
	public void setDuration(int duration)
	{
		if (duration < 0) { throw new IllegalArgumentException("duration muss groesser als 0 sein"); }
		this.duration = duration;
	}
	
	// Gibt true zurueck, wenn obj inhaltlich gleich ist wie dieses Objekt (postcondition)
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Song)) { return false; }
		final Song other = (Song) obj;
		
		return
			((name == other.name) || (name != null && name.equals(other.name))) &&
			(duration == other.duration);
	}
	
	// Gibt einen HashCode fuer dieses Objekt zurueck (postcondition)
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 17 + (name == null ? 0 : name.hashCode());
        hash = hash * 13 + (duration);
        return hash;
	}
	
	// Gibt dieses Objekt als String zurueck (postcondition)
	@Override
	public String toString() {
		return getName() + " ("+getDuration()+"s)";
	}
}
