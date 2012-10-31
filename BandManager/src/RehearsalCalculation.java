import java.util.*;

public class RehearsalCalculation extends Calculation {
	private ArrayList<Appointment> appList = new ArrayList<Appointment>();
	private Date dateFrom;
	private Date dateTo;
	
	public RehearsalCalculation(ArrayList<Appointment> appList) {
		setAppList(appList);
	}

	//VB: dateFrom < dateTo;
	public long getFinance(Date dateFrom, Date dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		
		return super.getFinance(dateFrom, dateTo);
		//NB: return >= 0;
	}

	public ArrayList<Long> filter() {
		//IV: result !< 0;
		ArrayList<Long> result = new ArrayList<Long>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0) {
				if(app instanceof Rehearsal)
					result.add(app.getCash());
			}
		}
		
		return result;
		//NB: result > 0;
	}

	private void setAppList(ArrayList<Appointment> appList) { this.appList = appList; }
}