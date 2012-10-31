/**
 * Appointment beinhaltet einen Ort, ein Datum (inklusive
 * Startzeitpunkt in Stunden und Minuten) sowie seine
 * Dauer.
 *
 * @version 1.0
 */
import java.text.*;
import java.util.ArrayList;
import java.util.Date;

/* GUT: Durch das Verwenden eines abstrakten Appointments
 *      ist eine leichtere Wartbarkeit gegeben.
 *      Auch im Falle moeglicher neuer Appointments gibt
 *      es eine Wiederverwendung der Klasse Appointment.
 */
public abstract class Appointment {
	private Location location;
	private Date dBegin;
	private long duration;
	private int id;
	private boolean canceled = false;
	
	//um Sekundenangabe bei der Ausgabe zu entfernen um Ueberpruefung einfacher zu halten (aufgrund ungenauer Calendar-Klasse)
	DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 3);
	
	private ArrayList<Member> memberList = new ArrayList<Member>(); //history-constraint: Client
	
	//liefert Wert >= 0 (postcondition)
	public abstract long getCash();
	
	public abstract void setCash(long cash);
	
	/*
	 * SCHLECHT: Wenn in der jeweiligen erbenden Klasse bei dem setter interen
	 * ein "addChange" durchgefuehrt werden wuerde, muesste nicht bei einer Veraenderung
	 * einer einzelnen Eigenschaft immer alle anderen Datne mitangeben werden.
	 * Dies verringert die Verarbeitungszeit (Wuerde uebers Netzwerk) den Traffic senken.
	 * und man muesste sich in der klasse Band nicht darum kuemmern...
	 */
	//location = gueltiger Ort, dBegin = gueltiges Datum, duration >= 0, salary >= 0 (precondition)
	public abstract void addChange(Location location, Date dBegin, long duration, long cash, boolean canceled);
	
	public abstract void undo();
	
	//liefert gueltige Location (postcondition)
	public Location getLocation() {
		return location;
	}

	//location = gueltiger Ort (precondition)
	public void setLocation(Location location) {
		this.location = location;
	}

	//duration >= 0 (postcondition)
	public long getDuration() {
		return duration;
	}

	//duration >= 0 (precondition)
	public void setDuration(long duration) {
		this.duration = duration;
	}

	//dBegin = gueltiges Datum (postcondition)
	public Date getdBegin() {
		return dBegin;
	}

	//dBegin = gueltiges Datum (precondition)
	public void setdBegin(Date dBegin) {
		this.dBegin = dBegin;
	}
	
	// SCHLECHT: unused
	public int getId() {
		return id;
	}

	// SCHLECHT: unused
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
	//m = guelitger Member (precondition)
	//memberList --> add (history-constraint: Server)
	public void addMember(Member m){
		memberList.add(m);
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	
	// Gibt eine Liste mit allen Songs die die aktuellen Teilnehmer dieses Treffens zu einem bestimmten Zeitpunkt spielen konnten (ist niemals null, kann aber leer sein) (postcondition)
	// time: Zeitpunkt, darf nich null sein (precondition)
	public ArrayList<Song> getRepertoire(Date time)
	{
		ArrayList<Member> members = getMemberList();
		ArrayList<Song> repertoire = new ArrayList<Song>();
		
		boolean first = true;
		for (Member member : members) {
			ArrayList<Song> memberSongs = member.listSongs(time);
			if (first)
			{
				repertoire.addAll(memberSongs);
				first = false;
			}
			else
			{
				for (int i = 0; i < repertoire.size(); i++) {
					Song song = repertoire.get(i);
					if (!memberSongs.contains(song))
					{
						repertoire.remove(i);
						i--;
					}
				}
			}
		}
		
		return repertoire;
	}

	@Override
	public String toString(){
		return getLocation() + " (" + dateFormat.format(getdBegin()) + 
				", " + getDuration() + 
				", " + getCash() + 
				", " + isCanceled() + ")";
	}
}
