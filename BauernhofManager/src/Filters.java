/**
 * Sammlung von verschiednen Iterationsfiltern
 * @author Daniel
 */
@AuthorAnnotation(author="Daniel")
public final class Filters {

	/**
	 * Ueberschreibt interationTraktor so, dass je nach Traktor Typ iterationTraktorDiesel oder iterationTraktorBiogas aufgerufen wird.
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static abstract class TraktorTyp extends IterationFilter {
		
		/**
		 * Erstellt einen neuen TraktorTyp-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public TraktorTyp(Iteration output) {
			super(output);
		}
		
		/**
		 * je nach Traktor Typ iterationTraktorDiesel oder iterationTraktorBiogas aufrufen
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationTraktor(Traktor item) {
			item.interationTyp(this);
		}
	}
	
	/**
	 * Filter fuer Biogas-Traktoren
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static class Biogas extends TraktorTyp {
		/**
		 * Erstellt einen neuen Biogas-Traktor-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public Biogas(Iteration output) {
			super(output);
		}
		
		/**
		 * Leitet nur Biogas-Traktoren an die Output-Iteration weiter
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationTraktorBiogas(TraktorBiogas item) {
			Out(item);
		}
	}
	
	/**
	 * Filter fuer Diesel-Traktoren
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static class Diesel extends TraktorTyp {
		/**
		 * Erstellt einen neuen Diesel-Traktor-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public Diesel(Iteration output) {
			super(output);
		}
		
		/**
		 * Leitet nur Diesel-Traktoren an die Output-Iteration weiter
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationTraktorDiesel(TraktorDiesel item) {
			Out(item);
		}
	}
	
	/**
	 * Ueberschreibt interationTraktor so, dass je nach Traktor Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer aufgerufen wird
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static abstract class TraktorModul extends IterationFilter {
		/**
		 * Erstellt einen neuen TraktorModul-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public TraktorModul(Iteration output) {
			super(output);
		}
		
		/**
		 * Je nach Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer aufrufen
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationTraktor(Traktor item) {
			item.interationModul(this);
		}
	}
	
	/**
	 * Filter fuer Traktoren mit Drillmaschinen-Modul
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static class ModulDrillmaschine extends TraktorModul {
		/**
		 * Erstellt einen neuen Drillmaschine-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public ModulDrillmaschine(Iteration output) {
			super(output);
		}
		
		/**
		 * Leitet nur Traktoren mit Drillmaschinen an die Output-Iteration weiter
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			Out(traktor);
		}
	}
	
	/**
	 * Filter fuer Traktoren mit Duengerstreuer-Modul
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static class ModulDuengerstreuer extends TraktorModul {
		/**
		 * Erstellt einen neuen Duengerstreuer-Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public ModulDuengerstreuer(Iteration output) {
			super(output);
		}
		
		/**
		 * Leitet nur Traktoren mit Duengerstreuer an die Output-Iteration weiter
		 */
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			Out(traktor);
		}
	}
}
