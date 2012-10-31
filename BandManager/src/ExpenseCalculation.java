import java.util.*;

public class ExpenseCalculation extends Calculation {
	private TreeMap<Date,OtherFinance> expenseMap = new TreeMap<Date,OtherFinance>();
	private Date dateFrom;
	private Date dateTo;
	
	public ExpenseCalculation(TreeMap<Date,OtherFinance> expenseMap) {
		setExpenseMap(expenseMap);
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
		
		finList = expenseMap.subMap(dateFrom, dateTo).values();
		
		for(OtherFinance of : finList) {
			result.add(of.getAmount());
		}
		
		return result;
		//NB: result > 0;
	}
	
	public void setExpenseMap(TreeMap<Date,OtherFinance> expenseMap) { this.expenseMap = expenseMap; }
}