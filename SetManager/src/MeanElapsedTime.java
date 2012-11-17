import java.util.Iterator;

public class MeanElapsedTime extends ElapsedTime<MeanElapsedTime> {
	private Set<Double> elapsedTimeSet;
	
	public MeanElapsedTime() {
		elapsedTimeSet = new Set<Double>();
	}
	
	@Override
	public boolean shorter(MeanElapsedTime that) {
		if(this.mean() < that.mean())
			return true;
		else
			return false;
	}
	
	@Override
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
	
	public void addValue(double time) {
		elapsedTimeSet.insert(time);
	}
	
	//TODO public oder private Methode (laut Angabe)????
	public double mean() {
		Iterator<Double> iter = elapsedTimeSet.iterator();
		double sum = 0;
		
		while(iter.hasNext())
			sum += iter.next();
		
		return sum / this.count();			
	}
	
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
