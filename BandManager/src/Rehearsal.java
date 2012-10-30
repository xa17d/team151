import java.util.*;

/**
 * Rehearsal erweitert die abstrakte Klasse Appointment
 * Es wird um die Variable fee (Kosten) erweitert.
 */
/*GUT: Verwendung von Getter und Setter 
 *     Setter werden auch im Konstruktor verwendet,
 *     dadurch ist eine bessere Wartbarkeit gegeben
 *     falls es einmal eine Manipulation der Paramter
 *     geben sollte.
 */
public class Rehearsal extends Appointment{
	private long fee;
	private ArrayList<Rehearsal> rehearsalChangeList = new ArrayList<Rehearsal>();
	
	//location = gueltiger Ort, dBegin = gueltiges Datum, duration >= 0, fee >= 0 (precondition)
	public Rehearsal(Location location, Date dBegin, long duration, long fee){
		setLocation(location);
		setdBegin(dBegin);
		setDuration(duration);
		setCash(fee);
	}
	
	//fee >= 0 (precondition)
	public void setCash(long fee) {
		this.fee = fee;
	}
	
	//fee >= 0 (postcondition)
	public long getCash() {
		return fee;
	}
	
	//location = gueltiger Ort, dBegin = gueltiges Datum, duration >= 0, cash >= 0 (precondition)
	public void addChange(Location location, Date dBegin, long duration, long cash,
			boolean canceled) {
		
		//Wenn rehearsalChangeList noch nie verwendet wurde wird sie initialisiert (postcondition bzw. history-constraint: Client)
		if(rehearsalChangeList == null)
			rehearsalChangeList = new ArrayList<Rehearsal>();
		
		//rehearsalChangeList neues Element ist gueltig, da aktuelle Rehearsal gueltig sein muss (precondition).
		//Hinzufuegen des aktuellen Zustands. (History Constraint: Server)
		rehearsalChangeList.add(new Rehearsal(getLocation(), getdBegin(), getDuration(), getCash()));
		//Waehrend die setMethoden aufgerufen werden, entsteht ein inkonsistenter Zustand
		//des Objekts mit gemischten Werten (alt und neu) danach nicht mehr (postcondition)
		this.setdBegin(dBegin);
		this.setLocation(location);
		this.setDuration(duration);
		this.setCash(cash);
		this.setCanceled(canceled);
	}

	//undo waehrend undo werden Zustaende von aktuellem und wiederherzustellendem Rehearsal
	//gemischt. danach wieder konsistenter Zustand (postcondition bzw. history-constraint: Server (rehearsalChangeList))
	@Override
	public void undo() {
		int lastIndex = rehearsalChangeList.size() - 1;
		this.setdBegin(rehearsalChangeList.get(lastIndex).getdBegin());
		this.setLocation(rehearsalChangeList.get(lastIndex).getLocation());
		this.setDuration(rehearsalChangeList.get(lastIndex).getDuration());
		this.setCash(rehearsalChangeList.get(lastIndex).getCash());
		this.setCanceled(rehearsalChangeList.get(lastIndex).isCanceled());
		rehearsalChangeList.remove(lastIndex);
	}
}
