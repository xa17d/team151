/**
 * stellt die Gesamtzeit eines aus mehreren Einzelzeiten zusammengesetzten Vorgangs dar
 * @author Lucas Dobler
 */
public class CompositeTime extends ElapsedTime<CompositeTime>{
	private double[] singleTime;
	
	/**
	 * Konstruktor
	 * erstellt neues Array bestehend aus allen Einzelzeiten
	 * @param singleTime Array mit allen Einzelzeiten
	 */
	public CompositeTime(double[] singleTime) {
		this.singleTime = singleTime;
	}
	
	@Override
	/**
	 * vergleicht die Summe aller Zeitmessungen eines Sets mit der eines anderen Sets
	 * @param that zu vergleichendes Set
	 * @return ob Summe eines Sets kuerzer ist als die des zu vergleichenden Sets
	 */
	public boolean shorter(CompositeTime that) {
		if(this.sum() < that.sum())
			return true;
		else
			return false;
	}

	@Override
	/**
	 * liefert Anzahl der Elemente die im Array gespeichert sind
	 * @return Anzahl der einzelnen Zeitmessungen
	 */
	public int count() {
		return singleTime.length + 1;
	}
	
	/**
	 * berechnet die Summe aller Werte des Arrays
	 * @return Summe
	 */
	public double sum() {
		double result = 0;
		
		for(int i = 0; i < singleTime.length; i++)
			result += singleTime[i];
		
		return result;
	}
	
	/**
	 * berechnet das Minimum aller Werte des Arrays
	 * @return Minimum
	 */
	public double min() {
		double result = sum();
		
		for(int i = 0; i < singleTime.length; i++)
			if(result > singleTime[i])
				result = singleTime[i];
		
		return result;
	}
	
}
