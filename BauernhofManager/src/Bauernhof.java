/**
 * Repraesentiert einen Bauernhof
 * @author Daniel
 */
@AuthorAnnotation(author="Daniel")
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
	 * Gibt den Bauernhof Informationen zurueck
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append("=== Bauernhof "+getName()+" ===\n");
		s.append("Name: "+getName()+"\n");
		s.append("Traktor-Liste:\n-----\n");
		s.append(traktors.toString());
		s.append("-----\n");
		s.append("Statistik:\n");
		s.append("  durchschnittliche Anzahl der Betriebsstunden\n");
		s.append("    alle:    "+berechneAvgBetiebsstunden()+"\n");
		s.append("    Saeen:   "+berechneAvgBetiebsstundenSaeen()+"\n");
		s.append("    Duengen: "+berechneAvgBetiebsstundenDuengen()+"\n");
		s.append("    Diesel:  "+berechneAvgBetiebsstundenDiesel()+"\n");
		s.append("    Biogas:  "+berechneAvgBetiebsstundenBiogas()+"\n");
		s.append("  durchschnittlicher Dieselverbrauch\n");
		s.append("    alle:    "+berechneAvgDieselverbrauch()+"\n");
		s.append("    Saeen:   "+berechneAvgDieselverbrauchSaeen()+"\n");
		s.append("    Duengen: "+berechneAvgDieselverbrauchDuengen()+"\n");
		s.append("  durchschnittlicher Gasverbrauch\n");
		s.append("    alle:    "+berechneAvgGasverbrauch()+"\n");
		s.append("    Saeen:   "+berechneAvgGasverbrauchSaeen()+"\n");
		s.append("    Duengen: "+berechneAvgGasverbrauchDuengen()+"\n");
		s.append("  minimale und maximale Anzahl an Säscharen\n");
		s.append("    alle:  \t"+berechneMinAnzahlSaescharen()+"\t"+berechneMaxAnzahlSaescharen()+"\n");
		s.append("    Diesel:\t"+berechneMinAnzahlSaescharenDiesel()+"\t"+berechneMaxAnzahlSaescharenDiesel()+"\n");
		s.append("    Biogas:\t"+berechneMinAnzahlSaescharenBiogas()+"\t"+berechneMaxAnzahlSaescharenBiogas()+"\n");
		s.append("\n");
		
		return s.toString();
	}

	/**
	 * ruft iteration.iterationBauernhof auf.
	 */
	@Override
	public void iteration(Iteration iteration) {
		iteration.iterationBauernhof(this);		
	}
	
	/**
	 * Fuert eine Iteration ueber alle Traktoren durch mit iteration und gibt den Durchschnittswert von avg zurueck.
	 * @param iteration Iteration die ueber alle Traktoren durchgefuehrt werden soll
	 * @param avg Durchschnittswert der zurueckgegeben werden soll
	 * @return Durchschnittswert von avg
	 */
	private double berechneAvg(Iteration iteration, IterationAvgCounter avg) {
		traktors.iterate(iteration);
		return avg.getAvg();
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren
	 */
	public double berechneAvgBetiebsstunden()  {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Drillmaschinen-Modul
	 */
	public double berechneAvgBetiebsstundenSaeen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Duengerstreuer-Modul
	 */
	public double berechneAvgBetiebsstundenDuengen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Diesel-Traktoren
	 */
	public double berechneAvgBetiebsstundenDiesel() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.Diesel(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Biogas-Traktoren
	 */
	public double berechneAvgBetiebsstundenBiogas() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.Biogas(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren
	 */
	public double berechneAvgDieselverbrauch() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren mit Drillmaschinen-Modul
	 */
	public double berechneAvgDieselverbrauchSaeen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren mit Duengerstreuer-Modul
	 */
	public double berechneAvgDieselverbrauchDuengen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren
	 */
	public double berechneAvgGasverbrauch() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren mit Drillmaschinen-Modul
	 */
	public double berechneAvgGasverbrauchSaeen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren mit Duengerstreuer-Modul
	 */
	public double berechneAvgGasverbrauchDuengen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters
	 */
	public double berechneAvgFassungskapazitaet() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(i, i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Dieseltraktoren
	 */
	public double berechneAvgFassungskapazitaetDiesel() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Diesel(i), i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Biogastraktoren
	 */
	public double berechneAvgFassungskapazitaetBiogas() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Biogas(i), i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Dieseltraktoren
	 */
	public int berechneMinAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren
	 */
	public int berechneMaxAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMax();
	}
	
	/**
	 * @return Die minimale Anzahl an Saescharen aller Traktoren aller Dieseltraktoren
	 */
	public int berechneMinAnzahlSaescharenDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren aller Dieseltraktoren
	 */
	public int berechneMaxAnzahlSaescharenDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMax();
	}
	
	/**
	 * @return Die minimale Anzahl an Saescharen aller Traktoren aller Biogastraktoren
	 */
	public int berechneMinAnzahlSaescharenBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren aller Biogastraktoren
	 */
	public int berechneMaxAnzahlSaescharenBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMax();
	}
	
	/**
	 * Iteration die einen Durchschnittswert berechner
	 * @author Daniel
	 */
	private class IterationAvgCounter extends Iteration {
		/**
		 * Summe
		 */
		private double sum = 0;
		/**
		 * Anzahl der gezaehlten Werte
		 */
		private int item_count = 0;
		
		/**
		 * Zaehlt einen Wert
		 * @param value Wert der gezaehlt werden soll
		 */
		protected void count(double value) {
			sum += value;
			item_count++;
		}
		
		/**
		 * Gibt den Durschnitt aller gezaehlten Werte zurueck, 0 falls keine Werte gezaehlt wurden
		 * @return Durchschnitt, 0 falls keine Werte gezaehlt wurden
		 */
		public double getAvg() {
			if (item_count == 0) {
				return 0;
			} else {
				return sum/item_count;
			}
		}
	}
	
	/**
	 * Iteration die den Durchschnitt von Traktor-Betriebsstunden erfasst
	 * @author Daniel
	 */
	private class IterationAvgBetriebsstunden extends IterationAvgCounter {
		@Override
		public void iterationTraktor(Traktor item) {
			// TODO:
			//count(item.getBetriebsstunden());
			count(1);
		}
	}
	
	/**
	 * Iteration die den Durchschnitt vom Dieselverbrauch erfasst
	 * @author Daniel
	 */
	private class IterationAvgDieselverbrauch extends IterationAvgCounter {
		@Override
		public void iterationTraktorDiesel(TraktorDiesel item) {
			// TODO:
			//count(item.getDieselverbrauch());
			count(1);
		}
	}
	
	/**
	 * Iteration die den Durchschnitt vom Biogasverbrauch erfasst
	 * @author Daniel
	 */
	private class IterationAvgGasverbrauch extends IterationAvgCounter {
		@Override
		public void iterationTraktorBiogas(TraktorBiogas item) {
			// TODO:
			//count(item.getGasverbrauch());
			count(1);
		}
	}
	
	/**
	 * Iteration die den Durchschnitt der Fassungskapazitaet aller Traktoren mit Duengerstreuer erfasst
	 * @author Daniel
	 */
	private class IterationAvgFassungsvermoegen extends IterationAvgCounter {
		@Override
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			count(modul.getFassungskapazitaet());
		}
	}
	
	/**
	 * Iteration die die Minimal- und Maximalanzahl der Saescharen aller Traktoren mit Drillmaschine erfasst
	 * @author Daniel
	 */
	private class IterationAnzahlSaescharen extends Iteration {
		/**
		 * Minimal Wert
		 */
		private int min = Integer.MAX_VALUE;
		/**
		 * Maximal Wert
		 */
		private int max = Integer.MIN_VALUE;
		/**
		 * true wenn mindestens ein Wert gezaehlt wurde, sonst false
		 */
		private boolean valid = false;
		
		@Override
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			int c = modul.getAnzahlSaehscharen();
			if (c < min) { min = c; }
			if (c > max) { max = c; }
			valid = true;
		}
		
		/**
 		 * @return Gibt die Minimalanzahl der Saescharen zurueck, 0 falls keine Saescharen erfasst wurden
		 */
		public int getMin() {
			if (valid) {
				return min;
			} else {
				return 0;
			}
		}
		
		/**
 		 * @return Gibt die Maximalanzahl der Saescharen zurueck, 0 falls keine Saescharen erfasst wurden
		 */
		public int getMax() {
			if (valid) {
				return max;
			} else {
				return 0;
			}
		}
	}
}
