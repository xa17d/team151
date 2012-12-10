/**
 * Repraesentiert einen Bauernhof
 * @author Daniel
 */
public class Bauernhof implements IteratableObject {

	/**
	 * Erstellt einen neuen Bauernhof mit bestimmten Namen
	 * @param name Name (!=null)
	 */
	public Bauernhof(String name) {
		this.name = name;
	}
	
	/**
	 * Name des Bauernhofs (ist niemals null)
	 */
	private String name;
	/**
	 * TraktorSet in dem die Traktoren des Bauernhofs gespeichert werden
	 */
	private TraktorSet traktors = new TraktorSet();
	
	/**
	 * @return Name des Bauernhofs
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Fuegt einen Traktor dem Bauernhof hinzu
	 * @param item Neuer Traktor
	 */
	public void addTraktor(Traktor item) {
		traktors.insert(item);
	}
	
	/**
	 * Entfernt einen Traktor vom Bauernhof
	 * @param item zu entfernender Traktor
	 */
	public void removeTraktor(Traktor item) {
		traktors.remove(item);
	}
	
	/**
	 * Traktor anhand seiner eindeutigen Nummer finden
	 * @param id Eindeutige Nummer
	 * @return Traktor mit gesuchter Nummer, null falls sich der Traktor nicht auf diesem Bauernhof befindet 
	 */
	public Traktor getTraktor(int id) {
		return traktors.get(id);
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public void iteration(Iteration iteration) {
		iteration.iterationBauernhof(this);		
	}
	
	private double berechneAvgBetiebsstunden(Iteration iteration, IterationAvgBetriebsstunden betriebsstunden) {
		traktors.iterate(iteration);
		return betriebsstunden.getAvg();
	}
	
	public double berechneAvgBetiebsstunden()  {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvgBetiebsstunden(i,i);
	}
	
	public double berechneAvgBetiebsstundenSaeen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvgBetiebsstunden(new Filters.ModulDrillmaschine(i),i);
	}
	public double berechneAvgBetiebsstundenDuengen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvgBetiebsstunden(new Filters.ModulDuengerstreuer(i),i);
	}
	public double berechneAvgBetiebsstundenDiesel() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvgBetiebsstunden(new Filters.Diesel(i),i);
	}
	public double berechneAvgBetiebsstundenBiogas() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvgBetiebsstunden(new Filters.Biogas(i),i);
	}
	
	private class IterationAvgCounter extends Iteration {
		private double sum = 0;
		private int item_count = 0;
		
		protected void count(double value) {
			sum += value;
			item_count++;
		}
		
		public double getAvg() {
			if (item_count == 0) {
				return 0;
			} else {
				return sum/item_count;
			}
		}
	}
	
	private class IterationAvgBetriebsstunden extends IterationAvgCounter {
		@Override
		public void iterationTraktor(Traktor item) {
			// TODO:
			//count(item.getBetriebsstunden());
			count(1);
		}
	}
}
