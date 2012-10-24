import java.util.*;

/**
 * berechnet einen bestimmten Typ von Einnahmen oder Ausgaben
 */
public abstract class Calculation {
	/**
	 * summiert alle Kostenpunkte die das Filter aufgelistet hat
	 * @param dateFrom Anfangsdatum
	 * @param dateTo Enddatum
	 * @return Summe aller Kostanpunkte
	 */
	public long getFinance(Date dateFrom, Date dateTo) {
		ArrayList<Long> amountList = new ArrayList<Long>();
		long sum = 0;
		
		amountList = filter();
		
		for(Long i : amountList)
			sum += i;
		
		return sum;		
	}
	
	/**
	 * filtert alle gewuenschten Kostenpunkte
	 * @return Liste alle Kostenpunkte
	 */
	public abstract ArrayList<Long> filter();
}