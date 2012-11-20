import java.util.Iterator;

/**
 * stellt die durchschnittliche Zeit einer Messreihe dar
 * @author Lucas Dobler
 */
public class MeanElapsedTime extends ElapsedTime {
	private Set<Double> elapsedTimeSet;
	
	/**
	 * Konstruktor
	 * erstellt neues double-Set
	 */
	public MeanElapsedTime() {
		elapsedTimeSet = new Set<Double>();
	}
	
	/**
	 * @see ElapsedTime#time()
	 */
	@Override
	protected double time() {
		return mean();
	}
	
	@Override
	/**
	 * liefert Anzahl der Elemente die im Set gespeichert sind
	 * @return Anzahl der Elemente
	 */
	public int count() {
		Iterator<Double> iter = elapsedTimeSet.iterator();
		int result = 0;
		
		while(iter.hasNext())
		{
			result += 1;
			iter.next();
		}
		
		return result;
	}
	
	/**
	 * fuegt neuen Wert zum Set hinzu
	 * @param time Wert
	 */
	public void addValue(double time) {
		elapsedTimeSet.insert(time);
	}
	
	/**
	 * berechnet den Mittelwert aller Werte des Sets
	 * @return Mittelwert
	 */
	public double mean() {
		Iterator<Double> iter = elapsedTimeSet.iterator();
		double sum = 0;
		
		while(iter.hasNext())
			sum += iter.next();
		
		return sum / this.count();			
	}
	
	/**
	 * berechnet das Maximum aller Werte des Sets
	 * @return Mittelwert
	 */
	public double max() {
		Iterator<Double> iter = elapsedTimeSet.iterator();
		double max = 0;
		double temp;
		
		while(iter.hasNext())
		{
			temp = iter.next();
			
			if(max < temp)
				max = temp;
		}
			
		return max;
	}
}
