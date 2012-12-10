
public final class Filters {

	public static abstract class TraktorTyp extends IterationFilter {
		public TraktorTyp(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationTyp(this);
		}
	}
	
	public static class Biogas extends TraktorTyp {
		public Biogas(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktorBiogas(TraktorBiogas item) {
			Out(item);
		}
	}
	
	public static class Diesel extends TraktorTyp {
		public Diesel(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktorDiesel(TraktorDiesel item) {
			Out(item);
		}
	}
	
	public static abstract class TraktorModul extends IterationFilter {
		public TraktorModul(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationTraktor(Traktor item) {
			item.interationModul(this);
		}
	}
	
	public static class ModulDrillmaschine extends TraktorModul {
		public ModulDrillmaschine(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) {
			Out(traktor);
		}
	}
	
	public static class ModulDuengerstreuer extends TraktorModul {
		public ModulDuengerstreuer(Iteration output) {
			super(output);
		}
		
		@Override
		public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) {
			Out(traktor);
		}
	}
}
