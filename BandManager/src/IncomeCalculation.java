import java.util.*;

/**
 * implementiert den Filter fuer sonstige Einnahmen
 */
public class IncomeCalculation extends Calculation {
	private TreeMap<Date,OtherFinance> incomeMap = new TreeMap<Date,OtherFinance>();
	private Date dateFrom;
	private Date dateTo;
	
	public IncomeCalculation(TreeMap<Date,OtherFinance> incomeMap) {
		setIncomeMap(incomeMap);
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
	 * filtert alle sonstigen Einnahmen
	 * @return Liste alle Kostenpunkte
	 */
	public ArrayList<Long> filter() {
		ArrayList<Long> result = new ArrayList<Long>();
		Collection<OtherFinance> finList = new ArrayList<OtherFinance>();
		
		finList = incomeMap.subMap(dateFrom, dateTo).values();
		
		for(OtherFinance of : finList) {
			result.add(of.getAmount());
		}
		
		return result;
	}
	
	//SET
	public void setIncomeMap(TreeMap<Date,OtherFinance> incomeMap) { this.incomeMap = incomeMap; }
}