/**
 * Wird fuer Iterationen des Sets verwendet. Wird im Set die Methode
 * iterate(...) mit einem Objekt dieser Klasse aufgerufen, wird fuer
 * jedes Element im Set die Methode iteration(...) aufgerufen.
 * @author Daniel
 *
 */
public abstract class Iteration {
	/**
	 * Wird fuer jedes Element eines Sets aufgerufen.
	 * Ist diese Methode nicht ueberschrieben worden, dann wird die iteratio-Methode des items aufgerufen
	 * @param item Element (!=null)
	 * @return true, wenn die Methode bereit fuer ein weiteres Element ist, false wenn die Iteration abgebrochen werden soll
	 */
	public boolean iteration(IteratableObject item) {
		return item.iteration(this);
	}

	/**
	 * Wird fuer jeden Bauernhof des Sets aufgerufen, falls iteration nicht ueberschrieben worden ist.
	 * @param item Bauernhof (!=null)
	 * @return true, wenn die Methode bereit fuer ein weiteres Element ist, false wenn die Iteration abgebrochen werden soll
	 */
	public boolean iterationBauernhof(Bauernhof item) {
		return true;
	}
	
	/**
	 * Wird fuer jeden Diesel-Traktor des Sets aufgerufen, falls iteration nicht ueberschrieben worden ist.
	 * Ruft, falls nicht ueberschrieben, iterationTraktor auf.
	 * @param item Diesel-Traktor (!=null)
	 * @return true, wenn die Methode bereit fuer ein weiteres Element ist, false wenn die Iteration abgebrochen werden soll
	 */
	public boolean iterationTraktorDiesel(TraktorDiesel item) {
		return iterationTraktor(item);
	}

	/**
	 * Wird fuer jeden Biogas-Traktor des Sets aufgerufen, falls iteration nicht ueberschrieben worden ist.
	 * Ruft, falls nicht ueberschrieben, iterationTraktor auf.
	 * @param item Diesel-Traktor (!=null)
	 * @return true, wenn die Methode bereit fuer ein weiteres Element ist, false wenn die Iteration abgebrochen werden soll
	 */
	public boolean iterationTraktorBiogas(TraktorBiogas item) {
		return iterationTraktor(item);
	}
	
	/**
	 * Wird fuer jeden Traktor des Sets aufgerufen, falls iteration, iterationTraktorDiesel und iterationTraktorBiogas nicht ueberschrieben worden ist.
	 * Ruft, falls nicht ueberschrieben, iterationTraktor auf.
	 * @param item Traktor (!=null)
	 * @return true, wenn die Methode bereit fuer ein weiteres Element ist, false wenn die Iteration abgebrochen werden soll
	 */
	public boolean iterationTraktor(Traktor item) {
		return true;
	}
}
