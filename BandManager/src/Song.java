/**
 * Repraesentiert ein Musikstueck
 *
 */
public class Song {
	
	public Song() {}
	public Song(String name, int duration)
	{
		setName(name);
		setDuration(duration);
	}
	
	private String name;
	private int duration;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	/**
	 * Gibt die Laenge des Stuecks in Sekunden zurueck
	 * @return Laenge des Stuecks
	 */
	public int getDuration() { return duration; }
	/**
	 * Setzt die Laenge des Musikstuecks
	 * @param duration neue Laenge in Sekunden
	 */
	public void setDuration(int duration)
	{
		if (duration < 0) { throw new IllegalArgumentException("duration muss groesser als 0 sein"); }
		this.duration = duration;
	}
	
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
	
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 17 + (name == null ? 0 : name.hashCode());
        hash = hash * 13 + (duration);
        return hash;
	}
	
	@Override
	public String toString() {
		return getName() + " ("+getDuration()+"s)";
	}
}
