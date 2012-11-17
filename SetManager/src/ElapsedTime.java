public abstract class ElapsedTime<T extends ElapsedTime<? super T>> /*implements Shorter*/{
	
	public abstract boolean shorter(T that);	
	public abstract int count();
	
}
