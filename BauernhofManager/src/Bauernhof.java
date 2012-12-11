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
	
	/**
	 * Gibt den Namen des Bauernhofs zurueck
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @see IteratableObject#iteration(Iteration)
	 */
	@Override
	public void iteration(Iteration iteration) {
		iteration.iterationBauernhof(this);		
	}
	
	private double berechneAvg(Iteration iteration, IterationAvgCounter avg) {
		traktors.iterate(iteration);
		return avg.getAvg();
	}
	
	public double berechneAvgBetiebsstunden()  {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(i,i);
	}
	
	public double berechneAvgBetiebsstundenSaeen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	public double berechneAvgBetiebsstundenDuengen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	public double berechneAvgBetiebsstundenDiesel() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.Diesel(i),i);
	}
	public double berechneAvgDieselverbrauch() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(i,i);
	}
	public double berechneAvgDieselverbrauchSaeen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	public double berechneAvgDieselverbrauchDuengen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	public double berechneAvgGasverbrauchSaeen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	public double berechneAvgGasverbrauchDuengen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	public double berechneAvgFassungskapazitaet() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(i, i);
	}
	public double berechneAvgFassungskapazitaetDiesel() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Diesel(i), i);
	}
	public double berechneAvgFassungskapazitaetBiogas() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Biogas(i), i);
	}
	public double berechneMinAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMin();
	}
	public double berechneMaxAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMax();
	}
	public double berechneMinAnzahlDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMin();
	}
	public double berechneMaxAnzahlDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMax();
	}
	public double berechneMinAnzahlBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMin();
	}
	public double berechneMaxAnzahlBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMax();
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
	
	private class IterationAvgDieselverbrauch extends IterationAvgCounter {
		@Override
		public void iterationTraktorDiesel(TraktorDiesel item) {
			// TODO:
			//count(item.getDieselverbrauch());
			count(1);
		}
	}
	
	private class IterationAvgGasverbrauch extends IterationAvgCounter {
		@Override
		public void iterationTraktorBiogas(TraktorBiogas item) {
			// TODO:
			//count(item.getGasverbrauch());
			count(1);
		}
	}
	
	private class IterationAvgFassungsvermoegen extends IterationAvgCounter {
		@Override
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			count(modul.getFassungskapazitaet());
		}
	}
	
	private class IterationAnzahlSaescharen extends Iteration {
		private int min = Integer.MAX_VALUE;
		private int max = Integer.MIN_VALUE;
		private boolean valid = false;
		
		@Override
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			int c = modul.getAnzahlSaehscharen();
			if (c < min) { min = c; }
			if (c > max) { max = c; }
			valid = true;
		}
		
		public int getMin() {
			if (valid) {
				return min;
			} else {
				return 0;
			}
		}
		
		public int getMax() {
			if (valid) {
				return max;
			} else {
				return 0;
			}
		}
	}
}
