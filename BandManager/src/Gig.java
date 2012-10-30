import java.util.*;

/**
 * Gig erweitert die abstrakte Klasse Appointment
 * Es wird um die Variable salary (Gage) erweitert.
 */

/*GUT: Verwendung von Getter und Setter 
 *     Setter werden auch im Konstruktor verwendet,
 *     dadurch ist eine bessere Wartbarkeit gegeben
 *     falls es einmal eine Manipulation der Paramter
 *     geben sollte.
 */
public class Gig extends Appointment {
	private long salary;
	private ArrayList<Gig> gigChangeList;
	
	//location = gueltiger Ort, dBegin = gueltiges Datum, duration >= 0, salary >= 0 (precondition)
	public Gig(Location location, Date dBegin, long duration, long salary){
		setLocation(location);
		setdBegin(dBegin);
		setDuration(duration);
		setCash(salary);
	}
	
	//salary >= 0 (precondition)
	public void setCash(long salary) {
		this.salary = salary;
	}
	
	//salary >= 0 (postcondition)
	public long getCash() {
		return salary;
	}

	//location = gueltiger Ort, dBegin = gueltiges Datum, duration >= 0, salary >= 0 (precondition)
	public void addChange(Location location, Date dBegin, long duration, long cash,
			boolean canceled) {
		
		//Wenn gigChangeList noch nie verwendet wurde wird sie initialisiert (postcondition bzw. history-constraint: Client)
		if(gigChangeList == null)
			gigChangeList = new ArrayList<Gig>();
		
		//gigChangeList neues Element ist gueltig, da der aktuelle Gig gueltig sein muss (precondition).
		//Hinzufuegen des aktuellen Zustands. (History Constraint: Server)

		gigChangeList.add(new Gig(getLocation(), getdBegin(), getDuration(), getCash()));
		//Waehrend die setMethoden aufgerufen werden, entsteht ein inkonsistenter Zustand
		//des Objekts mit gemischten Werten (alt und neu) danach nicht mehr (postcondition)
		this.setdBegin(dBegin);
		this.setLocation(location);
		this.setDuration(duration);
		this.setCash(cash);
		this.setCanceled(canceled);
	}

	//undo waehrend undo werden Zustaende von aktuellem und wiederherzustellendem Gig
	//gemischt. danach wieder konsistenter Zustand (postcondition bzw. history-constraint: Server (gigChangeList))
	@Override
	public void undo() {
		int lastIndex = gigChangeList.size() - 1;
		this.setdBegin(gigChangeList.get(lastIndex).getdBegin());
		this.setLocation(gigChangeList.get(lastIndex).getLocation());
		this.setDuration(gigChangeList.get(lastIndex).getDuration());
		this.setCash(gigChangeList.get(lastIndex).getCash());
		this.setCanceled(gigChangeList.get(lastIndex).isCanceled());
		gigChangeList.remove(lastIndex);
	}
}
