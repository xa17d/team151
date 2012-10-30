import java.util.ArrayList;
import java.util.Date;

public class Member {
	
	/**
	 * Erzeugt ein neues Member Objekt und gibt es zurueck
	 * FEHLER: es sollte sichergestellt werden, dass name, phonenumber und repertoire nicht null sind.
	 */
	public Member() {}
	/**
	 * Erzeugt ein neues Member Objekt und gibt es zurueck
	 * @param name Name des Mitglieds, darf nicht null sein
	 * @param phonenumber Telefonnummer des Mitglieds, darf nicht null sein
	 * @param instrument Instrument das das Mitglied spielt
	 */
	public Member(String name, String phonenumber, Instrument instrument)
	{
		repertoire = new History<Song>();
		
		setName(name);
		setPhonenumber(phonenumber);
		setInstrument(instrument);
	}
	
	private String name; // Name des Mitglieds, darf nicht null sein
	private String phonenumber; // Telefonnummer, darf nicht null sein
	private Instrument instrument; // Instrument das das Mitglied spielt
	
	private History<Song> repertoire; // Repertoire dieses Mitglieds, darf nicht null sein

	/**
	 * Gibt den Namen zurueck
	 * @return Name
	 */
	public String getName() { return name; }
	/**
	 * Setzt den Namen
	 * @param name neuer Name, darf nicht null sein
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Gibt die Telefonnummer zurueck
	 * @return Telefonnummer
	 */
	public String getPhonenumber() { return phonenumber; }
	/**
	 * Setzt die Telefonnummer
	 * @param phonenumber neue Telefonnummer, darf nicht null sein
	 */
	public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
	
	/**
	 * Gibt das Instrument zurueck
	 * @return Instrument das das Mitglied spielt
	 */
	public Instrument getInstrument() { return instrument; }
	/**
	 * Setzt das Instrument, das das Mitglied spielt
	 * @param instrument neues Instrument
	 */
	public void setInstrument(Instrument instrument) { this.instrument = instrument; }
	
	/**
	 * Fuegt einen neuen Song ins Repertoire ein
	 * @param song neuer Song, darf nicht null sein
	 */
	public void addSong(Song song) { repertoire.add(song); }
	/**
	 * Loescht einen Song aus dem Repertoire
	 * @param song Song der geloescht werden soll
	 * @return true wenn der Song geloescht wurde, false wenn der Song nicht gefunden wurden
	 */
	public boolean deleteSong(Song song) { return repertoire.delete(song); }
	/**
	 * Gibt alle Songs zurueck die das Mitglied momentan spielen kann
	 * @return
	 */
	public ArrayList<Song> listSongs() { return repertoire.list(); }
	/**
	 * Gibt alle Songs zurueck die das Mitglied zu einem bestimmten Zeitpunkt spielen konnte
	 * @param time Zeitpunkt
	 * @return Liste mit den Songs
	 */
	public ArrayList<Song> listSongs(Date time) { return repertoire.list(time); }
	 
	/**
	 * Gibt true zurueck, wenn obj inhaltlich gleich ist wie dieses Objekt
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Member)) { return false; }
		final Member other = (Member) obj;
		
		return
			((name == other.name) || (name != null && name.equals(other.name))) &&
			((phonenumber == other.phonenumber) || (phonenumber != null && phonenumber.equals(other.phonenumber))) &&
			(instrument.equals(other.instrument));
	}
	
	/**
	 * Gibt einen HashCode fuer dieses Objekt zurueck
	 */
	@Override
	public int hashCode() {
        int hash = 1;
        hash = hash * 17 + (name == null ? 0 : name.hashCode());
        hash = hash * 31 + (phonenumber == null ? 0 : phonenumber.hashCode());
        hash = hash * 13 + (instrument.hashCode());
        return hash;
	}
	
	/**
	 * Gibt dieses Objekt als String zurueck
	 */
	@Override
	public String toString() {
		return getName() + " ("+getInstrument().toString()+"; Tel: "+getPhonenumber()+")";
	}
}
