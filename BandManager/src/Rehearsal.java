import java.util.*;

/**
 * Rehearsal erweitert die abstrakte Klasse Appointment
 * Es wird um die Variable fee (Kosten) erweitert.
 */

public class Rehearsal extends Appointment{
	private long fee;
	private ArrayList<Rehearsal> rehearsalChangeList = new ArrayList<Rehearsal>();
	
	public Rehearsal(Location location, Date dBegin, long duration, long fee){
		setLocation(location);
		setdBegin(dBegin);
		setDuration(duration);
		setCash(fee);
	}
	
	public void setCash(long fee) {
		this.fee = fee;
	}
	
	public long getCash() {
		return fee;
	}
	
	public void addChange(Location location, Date dBegin, long duration, long cash,
			boolean canceled) {
		if(rehearsalChangeList == null)
			rehearsalChangeList = new ArrayList<Rehearsal>();
		//Alte Werte in die Liste speichern
		rehearsalChangeList.add(new Rehearsal(getLocation(), getdBegin(), getDuration(), getCash()));
		//Neue Werte zuweisen
		this.setdBegin(dBegin);
		this.setLocation(location);
		this.setDuration(duration);
		this.setCash(cash);
		this.setCanceled(canceled);
	}

	@Override
	public void undo() {
		int lastIndex = rehearsalChangeList.size() - 1;	//Letztes element = letzte Aenderung
		//Wiederherstellen
		this.setdBegin(rehearsalChangeList.get(lastIndex).getdBegin());
		this.setLocation(rehearsalChangeList.get(lastIndex).getLocation());
		this.setDuration(rehearsalChangeList.get(lastIndex).getDuration());
		this.setCash(rehearsalChangeList.get(lastIndex).getCash());
		this.setCanceled(rehearsalChangeList.get(lastIndex).isCanceled());
		//Wiederherstellen abgeschlossen
		rehearsalChangeList.remove(lastIndex);	//Entfernen des wiederhergestellten Elements aus der Liste
	}
}
