public class CompositeTime extends ElapsedTime<CompositeTime>{
	private double[] singleTime;
	
	public CompositeTime(double[] singleTime) {
		this.singleTime = singleTime;
	}
	
	@Override
	public boolean shorter(CompositeTime that) {
		if(this.sum() < that.sum())
			return true;
		else
			return false;
	}

	@Override
	public int count() {
		return singleTime.length + 1;
	}
	
	//TODO public oder private Methode (laut Angabe)????
	public double sum() {
		double result = 0;
		
		for(int i = 0; i < singleTime.length; i++)
			result += singleTime[i];
		
		return result;
	}
	
	public double min() {
		double result = sum();
		
		for(int i = 0; i < singleTime.length; i++)
			if(result > singleTime[i])
				result = singleTime[i];
		
		return result;
	}
	
}
