import java.util.ArrayList;
import java.util.Date;

/**
 * Repraesentiert ein Mitglied einer Musikgruppe
 *
 */
public class Member {
	
	public Member() {}
	public Member(String name, String phonenumber, Instrument instrument)
	{
		repertoire = new History<Song>();
		
		setName(name);
		setPhonenumber(phonenumber);
		setInstrument(instrument);
	}
	
	private String name;
	private String phonenumber;
	private Instrument instrument;
	
	private History<Song> repertoire;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getPhonenumber() { return phonenumber; }
	public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
	
	public Instrument getInstrument() { return instrument; }
	public void setInstrument(Instrument instrument) { this.instrument = instrument; }
	
	public void addSong(Song song) { repertoire.add(song); }
	public boolean deleteSong(Song song) { return repertoire.delete(song); }
	public ArrayList<Song> listSongs() { return repertoire.list(); }
	public ArrayList<Song> listSongs(Date time) { return repertoire.list(time); }
	 
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
	
	@Override
	public int hashCode() {
        int hash = 1;
        hash = hash * 17 + (name == null ? 0 : name.hashCode());
        hash = hash * 31 + (phonenumber == null ? 0 : phonenumber.hashCode());
        hash = hash * 13 + (instrument.hashCode());
        return hash;
	}
	
	@Override
	public String toString() {
		return getName() + " ("+getInstrument().toString()+"; Tel: "+getPhonenumber()+")";
	}
}
