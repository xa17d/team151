import java.util.*;

/**
 * verwaltet die gesamten Finanzen der Band
 */
public class BandFinance {
	OtherFinance of;
	
	private HashMap<CalculationType, Calculation> calculationMap = new HashMap<CalculationType, Calculation>();
	
	private TreeMap<Date,OtherFinance> incomeMap = new TreeMap<Date,OtherFinance>();
	private TreeMap<Date,OtherFinance> expenseMap = new TreeMap<Date,OtherFinance>();
	
	/**
	 * fuegt eine neue Einnahme hinzu
	 * @param name Einnahme
	 * @param date Datum
	 * @param description Beschreibung
	 * @param income Betrag
	 */
	public void addIncome(String name, Date date, String description, long income) {
		of = new OtherFinance(name, date, description, income);
		incomeMap.put(date, of);
	}
	
	/**
	 * fuegt eine neue Ausgabe hinzu
	 * @param name Einnahme
	 * @param date Datum
	 * @param description Beschreibung
	 * @param expense Betrag
	 */
	public void addExpense(String name, Date date, String description, long expense) {
		of = new OtherFinance(name, date, description, expense);
		expenseMap.put(date, of);
	}

	/**
	 * berechnet die Einnahmen bzw. Ausgaben fuer einen bestimmten Zeitraum
	 * @param ct Typ der Berechnung
	 * @param dateFrom Anfangsdatum
	 * @param dateTo Enddatum
	 * @param appFinList Liste mit Finanzen aller Termine
	 * @return Einnahmen bzw. Ausgaben
	 */
	public long getFinance(CalculationType ct, Date dateFrom, Date dateTo, ArrayList<Appointment> appList) {
		calculationMap.put(CalculationType.Gig, new GigCalculation(appList));
		calculationMap.put(CalculationType.Rehearsal, new RehearsalCalculation(appList));
		calculationMap.put(CalculationType.Income, new IncomeCalculation(incomeMap));
		calculationMap.put(CalculationType.Expense, new ExpenseCalculation(expenseMap));
		
		Calculation c = calculationMap.get(ct);
		return c.getFinance(dateFrom, dateTo);
	}
}