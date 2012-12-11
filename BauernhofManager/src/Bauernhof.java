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
	@AuthorAnnotation(author="Daniel")
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
	@AuthorAnnotation(author="Daniel")
	public String getName() {
		return name;
	}
	
	/**
	 * Fuegt einen Traktor dem Bauernhof hinzu
	 * @param item Neuer Traktor
	 */
	@AuthorAnnotation(author="Daniel")
	public void addTraktor(Traktor item) {
		traktors.insert(item);
	}
	
	/**
	 * Entfernt einen Traktor vom Bauernhof
	 * @param item zu entfernender Traktor
	 */
	@AuthorAnnotation(author="Daniel")
	public void removeTraktor(Traktor item) {
		traktors.remove(item);
	}
	
	/**
	 * Traktor anhand seiner eindeutigen Nummer finden
	 * @param id Eindeutige Nummer
	 * @return Traktor mit gesuchter Nummer, null falls sich der Traktor nicht auf diesem Bauernhof befindet 
	 */
	@AuthorAnnotation(author="Daniel")
	public Traktor getTraktor(int id) {
		return traktors.get(id);
	}
	
	/**
	 * Gibt den Bauernhof Informationen zurueck
	 */
	@AuthorAnnotation(author="Daniel")
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append("=== Bauernhof "+getName()+" ===\n");
		s.append("Name: "+getName()+"\n");
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
	@AuthorAnnotation(author="Daniel")
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
	@AuthorAnnotation(author="Daniel")
	private double berechneAvg(Iteration iteration, IterationAvgCounter avg) {
		traktors.iterate(iteration);
		return avg.getAvg();
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgBetiebsstunden()  {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Drillmaschinen-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgBetiebsstundenSaeen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Duengerstreuer-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgBetiebsstundenDuengen() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Diesel-Traktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgBetiebsstundenDiesel() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.Diesel(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Anzahl der Betriebsstunden aller Biogas-Traktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgBetiebsstundenBiogas() {
		IterationAvgBetriebsstunden i = new IterationAvgBetriebsstunden();
		return berechneAvg(new Filters.Biogas(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgDieselverbrauch() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren mit Drillmaschinen-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgDieselverbrauchSaeen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Dieselverbrauch aller Diesetraktoren mit Duengerstreuer-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgDieselverbrauchDuengen() {
		IterationAvgDieselverbrauch i = new IterationAvgDieselverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgGasverbrauch() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(i,i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren mit Drillmaschinen-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgGasverbrauchSaeen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDrillmaschine(i),i);
	}
	
	/**
	 * @return Der durchschnittliche Gasverbrauch aller Biogastraktoren mit Duengerstreuer-Modul
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgGasverbrauchDuengen() {
		IterationAvgGasverbrauch i = new IterationAvgGasverbrauch();
		return berechneAvg(new Filters.ModulDuengerstreuer(i),i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgFassungskapazitaet() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(i, i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Dieseltraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgFassungskapazitaetDiesel() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Diesel(i), i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Biogastraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public double berechneAvgFassungskapazitaetBiogas() {
		IterationAvgFassungsvermoegen i = new IterationAvgFassungsvermoegen();
		return berechneAvg(new Filters.Biogas(i), i);
	}
	
	/**
	 * @return Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Dieseltraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMinAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMaxAnzahlSaescharen() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(i);
		return i.getMax();
	}
	
	/**
	 * @return Die minimale Anzahl an Saescharen aller Traktoren aller Dieseltraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMinAnzahlSaescharenDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren aller Dieseltraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMaxAnzahlSaescharenDiesel() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Diesel(i));
		return i.getMax();
	}
	
	/**
	 * @return Die minimale Anzahl an Saescharen aller Traktoren aller Biogastraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMinAnzahlSaescharenBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMin();
	}
	
	/**
	 * @return Die maximale Anzahl an Saescharen aller Traktoren aller Biogastraktoren
	 */
	@AuthorAnnotation(author="Daniel")
	public int berechneMaxAnzahlSaescharenBiogas() {
		IterationAnzahlSaescharen i = new IterationAnzahlSaescharen();
		traktors.iterate(new Filters.Biogas(i));
		return i.getMax();
	}
	
	/**
	 * Iteration die einen Durchschnittswert berechner
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
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
		@AuthorAnnotation(author="Daniel")
		protected void count(double value) {
			sum += value;
			item_count++;
		}
		
		/**
		 * Gibt den Durschnitt aller gezaehlten Werte zurueck, 0 falls keine Werte gezaehlt wurden
		 * @return Durchschnitt, 0 falls keine Werte gezaehlt wurden
		 */
		@AuthorAnnotation(author="Daniel")
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
	@AuthorAnnotation(author="Daniel")
	private class IterationAvgBetriebsstunden extends IterationAvgCounter {
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktor(Traktor item) {
			count(item.getBetriebsstunden());
		}
	}
	
	/**
	 * Iteration die den Durchschnitt vom Dieselverbrauch erfasst
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	private class IterationAvgDieselverbrauch extends IterationAvgCounter {
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktorDiesel(TraktorDiesel item) {
			count(item.getVerbrauch());
		}
		
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationTyp(this);
		}
	}
	
	/**
	 * Iteration die den Durchschnitt vom Biogasverbrauch erfasst
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	private class IterationAvgGasverbrauch extends IterationAvgCounter {
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktorBiogas(TraktorBiogas item) {
			count(item.getVerbrauch());
		}
		
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationTyp(this);
		}
	}
	
	/**
	 * Iteration die den Durchschnitt der Fassungskapazitaet aller Traktoren mit Duengerstreuer erfasst
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	private class IterationAvgFassungsvermoegen extends IterationAvgCounter {
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			count(modul.getFassungskapazitaet());
		}
		
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationModul(this);
		}
	}
	
	/**
	 * Iteration die die Minimal- und Maximalanzahl der Saescharen aller Traktoren mit Drillmaschine erfasst
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
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
		
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			int c = modul.getAnzahlSaehscharen();
			if (c < min) { min = c; }
			if (c > max) { max = c; }
			valid = true;
		}
		
		@AuthorAnnotation(author="Daniel")
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationModul(this);
		}
		
		/**
 		 * @return Gibt die Minimalanzahl der Saescharen zurueck, 0 falls keine Saescharen erfasst wurden
		 */
		@AuthorAnnotation(author="Daniel")
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
		@AuthorAnnotation(author="Daniel")
		public int getMax() {
			if (valid) {
				return max;
			} else {
				return 0;
			}
		}
	}
}
