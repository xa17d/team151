import java.util.*;

public abstract class Calculation {
	//VB: dateFrom < dateTo;
	public long getFinance(Date dateFrom, Date dateTo) {
		//IV: sum !< 0;
		ArrayList<Long> amountList = new ArrayList<Long>();
		long sum = 0;
		
		amountList = filter();
		
		for(Long i : amountList)
			sum += i;
		
		return sum;
		//NB: sum >= 0;
	}
	
	//GUT: Vererbung
	public abstract ArrayList<Long> filter();
}