
public abstract class Traktor implements IteratableObject {
	public Traktor(int id) { this.id = id; }
	private int id;
	public int getId() { return id; }
	private Modul modul;
	public Modul getModul() { return modul; }
	
	/**
	 * Ruft iteration.iterationTraktor auf. Auch Untertypen von Traktor rufen genau diese Methode auf
	 */
	@Override
	public final void iteration(Iteration iteration) {
		iteration.iterationTraktor(this);
	}
	
	/**
	 * Ruft je nach Untertyp iteration.iterationTraktorBiogas oder iteration.iterationTraktorDiesel auf
	 * @param iteration Iteration
	 */
	public abstract void interationTyp(Iteration iteration);
	
	/**
	 * Ruf je nach Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer auf
	 * @param iteration Iteration
	 */
	public void interationModul(Iteration iteration) {
		modul.interationModul(iteration, this);
	}
}
