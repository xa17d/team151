import java.util.*;

/**
 * implementiert den Filter fuer sonstige Ausgaben
 */
public class ExpenseCalculation extends Calculation {
	private TreeMap<Date,OtherFinance> expenseMap = new TreeMap<Date,OtherFinance>();
	private Date dateFrom;
	private Date dateTo;
	
	public ExpenseCalculation(TreeMap<Date,OtherFinance> expenseMap) {
		setExpenseMap(expenseMap);
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
	 * filtert alle sonstigen Ausgaben
	 * @return Liste alle Kostenpunkte
	 */
	public ArrayList<Long> filter() {
		ArrayList<Long> result = new ArrayList<Long>();
		Collection<OtherFinance> finList = new ArrayList<OtherFinance>();
		
		finList = expenseMap.subMap(dateFrom, dateTo).values();
		
		for(OtherFinance of : finList) {
			result.add(of.getAmount());
		}
		
		return result;
	}
	
	//SET
	public void setExpenseMap(TreeMap<Date,OtherFinance> expenseMap) { this.expenseMap = expenseMap; }
}