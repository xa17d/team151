/**
 * Sammlung von verschiednen Iterationsfiltern
 * @author Daniel
 */
@AuthorAnnotation(author="Daniel")
public final class Filters {

	/**
	 * Ueberschreibt interationTraktor so, dass je nach TraktorTyp iterationTraktorDiesel oder iterationTraktorBiogas aufgerufen wird.
	 * @author Daniel
	 */
	@AuthorAnnotation(author="Daniel")
	public static abstract class TraktorTyp extends IterationFilter {
		
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		@AuthorAnnotation(author="Daniel")
		public TraktorTyp(Iteration output) {
			super(output);
		}
		
		@Override
		@AuthorAnnotation(author="Daniel")
		public void iterationTraktor(Traktor item) {
			item.interationTyp(this);
		}
	}
	
	public static class Biogas extends TraktorTyp {
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		public Biogas(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktorBiogas(TraktorBiogas item) {
			Out(item);
		}
	}
	
	public static class Diesel extends TraktorTyp {
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		public Diesel(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktorDiesel(TraktorDiesel item) {
			Out(item);
		}
	}
	
	public static abstract class TraktorModul extends IterationFilter {
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		public TraktorModul(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationModul(this);
		}
	}
	
	public static class ModulDrillmaschine extends TraktorModul {
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		public ModulDrillmaschine(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			Out(traktor);
		}
	}
	
	public static class ModulDuengerstreuer extends TraktorModul {
		/**
		 * Erstellt einen neuen Filter
		 * @param output Iteration-Objekt an das die gefilterten Items weitergeleitet werden sollen
		 */
		public ModulDuengerstreuer(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			Out(traktor);
		}
	}
}
