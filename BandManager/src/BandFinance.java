import java.util.*;

public class BandFinance {
	OtherFinance of;
	
	private HashMap<CalculationType, Calculation> calculationMap = new HashMap<CalculationType, Calculation>();
	
	private TreeMap<Date,OtherFinance> incomeMap = new TreeMap<Date,OtherFinance>();
	private TreeMap<Date,OtherFinance> expenseMap = new TreeMap<Date,OtherFinance>();

	//VB: income > 0; dateFrom < dateTo
	public void addIncome(String name, Date date, String description, long income) {
		of = new OtherFinance(name, date, description, income);
		incomeMap.put(date, of);
	}

	//VB: expense > 0; dateFrom < dateTo;
	public void addExpense(String name, Date date, String description, long expense) {
		of = new OtherFinance(name, date, description, expense);
		expenseMap.put(date, of);
	}
	
	//VB: dateFrom < dateTo;
	public long getFinance(CalculationType ct, Date dateFrom, Date dateTo, ArrayList<Appointment> appList) {
		calculationMap.put(CalculationType.Gig, new GigCalculation(appList));
		calculationMap.put(CalculationType.Rehearsal, new RehearsalCalculation(appList));
		calculationMap.put(CalculationType.Income, new IncomeCalculation(incomeMap));
		calculationMap.put(CalculationType.Expense, new ExpenseCalculation(expenseMap));
		
		Calculation c = calculationMap.get(ct);
		return c.getFinance(dateFrom, dateTo);
	}
}