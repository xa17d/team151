import java.util.*;

public class IncomeCalculation extends Calculation {
	private TreeMap<Date,OtherFinance> incomeMap = new TreeMap<Date,OtherFinance>();
	private Date dateFrom;
	private Date dateTo;
	
	public IncomeCalculation(TreeMap<Date,OtherFinance> incomeMap) {
		setIncomeMap(incomeMap);
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
		Collection<OtherFinance> finList = new ArrayList<OtherFinance>();
		
		finList = incomeMap.subMap(dateFrom, dateTo).values();
		
		for(OtherFinance of : finList) {
			result.add(of.getAmount());
		}
		
		return result;
		//NB: result > 0;
	}
	
	public void setIncomeMap(TreeMap<Date,OtherFinance> incomeMap) { this.incomeMap = incomeMap; }
}