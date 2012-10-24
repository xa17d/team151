import java.util.*;

/**
 * implementiert den Filter fuer Probenausgaben
 */
public class RehearsalCalculation extends Calculation {
	private ArrayList<Appointment> appList = new ArrayList<Appointment>();
	private Date dateFrom;
	private Date dateTo;
	
	public RehearsalCalculation(ArrayList<Appointment> appList) {
		setAppList(appList);
	}
	
	/**
	 * speichert Zeitraum und laesst Finanzen von Oberklasse berechnen
	 */
	public long getFinance(Date dateFrom, Date dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		
		return super.getFinance(dateFrom, dateTo);
	}
	
	/**
	 * filtert alle Probenausgaben
	 * @return Liste alle Kostenpunkte
	 */
	public ArrayList<Long> filter() {
		ArrayList<Long> result = new ArrayList<Long>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0) {
				if(app instanceof Rehearsal)
					result.add(app.getCash());
			}
		}
		
		return result;
	}
	
	//SET
	private void setAppList(ArrayList<Appointment> appList) { this.appList = appList; }
}