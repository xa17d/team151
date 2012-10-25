/**
 * Appointment beinhaltet einen Ort, ein Datum (inklusive
 * Startzeitpunkt in Stunden und Minuten) sowie seine
 * Dauer.
 *
 * @version 1.0
 */
import java.text.*;

public abstract class Appointment {
	private Location location;
	private Date dBegin;
	private long duration;
	private int id;
	private boolean canceled = false;
	
	//um Sekundenangabe bei der Ausgabe zu entfernen um Ueberpruefung einfacher zu halten (aufgrund ungenauer Calendar-Klasse)
	DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 3);
	
	private ArrayList<Member> memberList = new ArrayList<Member>();
	
	public abstract long getCash();
	
	public abstract void setCash(long cash);
	
	public abstract void addChange(Location location, Date dBegin, long duration, long cash, boolean canceled);
	
	public abstract void undo();
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Date getdBegin() {
		return dBegin;
	}

	public void setdBegin(Date dBegin) {
		this.dBegin = dBegin;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	//MEMBER
	public void addMember(Member m){
		memberList.add(m);
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	public ArrayList<Song> getRepertoire(Date time)
	{
		ArrayList<Member> members = getMemberList();
		ArrayList<Song> repertoire = new ArrayList<Song>();
		
		boolean first = true;
		for (Member member : members) {
			ArrayList<Song> memberSongs = member.listSongs(time);
			if (first)
			{
				// Repertoire des ersten Members in die Liste aufnehmen
				repertoire.addAll(memberSongs);
				first = false;
			}
			else
			{
				// fuer jeden Song im noch uebrigen Repertoire pruefen ob
				// dieses Member ihn spielen kann
				for (int i = 0; i < repertoire.size(); i++) {
					Song song = repertoire.get(i);
					if (!memberSongs.contains(song))
					{
						// falls das Mitglied diesen Song nicht Spielen kann:
						// aus dem Repertoire entfernen
						repertoire.remove(i);
						i--;
					}
				}
			}
		}
		
		return repertoire;
	}

	/**
	 * Wird von den erweiternden Klassen ueberschrieben.
	 * um die Geldbetraege hinzuzufuegen
	 * 
	 * @return Ort, Beginn-Datum, Dauer 
	 */
	@Override
	public String toString(){
		return getLocation() + " (" + dateFormat.format(getdBegin()) + 
				", " + getDuration() + 
				", " + getCash() + 
				", " + isCanceled() + ")";
	}
}
