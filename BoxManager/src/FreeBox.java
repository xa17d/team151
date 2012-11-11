/**
 * 
 * @author daniel
 *
 */
public class FreeBox implements Pict {
	public FreeBox(String body) {
		
		this.body = new Repeated<String>(
				new String[][] {
						new String[] { body }
				}
			);
	}
	
	Repeated<String> body;
	
	public void scale(double factor) {
		body.scale(factor);
	}
	
	@Override
	public String toString() {
		return body.toString();
	}
}
