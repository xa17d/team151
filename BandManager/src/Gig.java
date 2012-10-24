import java.util.*;

/**
 * Gig erweitert die abstrakte Klasse Appointment
 * Es wird um die Variable salary (Gage) erweitert.
 */

public class Gig extends Appointment {
	private long salary;
	private ArrayList<Gig> gigChangeList;
	
	public Gig(Location location, Date dBegin, long duration, long salary){
		setLocation(location);
		setdBegin(dBegin);
		setDuration(duration);
		setCash(salary);
	}
	
	public void setCash(long salary) {
		this.salary = salary;
	}
	
	public long getCash() {
		return salary;
	}

	public void addChange(Location location, Date dBegin, long duration, long cash,
			boolean canceled) {
		if(gigChangeList == null)
			gigChangeList = new ArrayList<Gig>();
		//Alte Werte in die Liste speichern
		gigChangeList.add(new Gig(getLocation(), getdBegin(), getDuration(), getCash()));
		//Neue Werte zuweisen
		this.setdBegin(dBegin);
		this.setLocation(location);
		this.setDuration(duration);
		this.setCash(cash);
		this.setCanceled(canceled);
	}

	@Override
	public void undo() {
		int lastIndex = gigChangeList.size() - 1;	//Letztes element = letzte Aenderung
		//Wiederherstellen
		this.setdBegin(gigChangeList.get(lastIndex).getdBegin());
		this.setLocation(gigChangeList.get(lastIndex).getLocation());
		this.setDuration(gigChangeList.get(lastIndex).getDuration());
		this.setCash(gigChangeList.get(lastIndex).getCash());
		this.setCanceled(gigChangeList.get(lastIndex).isCanceled());
		//Wiederherstellen abgeschlossen
		gigChangeList.remove(lastIndex);	//Entfernen des wiederhergestellten Elements aus der Liste
	}
}
