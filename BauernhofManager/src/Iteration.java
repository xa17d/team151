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
	 */
	public void iteration(IteratableObject item) {
		item.iteration(this);
	}

	/**
	 * Wird fuer jeden Bauernhof des Sets aufgerufen, falls iteration nicht ueberschrieben worden ist.
	 * @param item Bauernhof (!=null)
	 */
	public void iterationBauernhof(Bauernhof item) { }
	
	/**
	 * Wird von Traktor.iterationTyp(...) aufgerufen, falls es sich um einen Diesel Traktor handelt
	 * @param item Diesel-Traktor (!=null)
	 */
	public void iterationTraktorDiesel(TraktorDiesel item) { }

	/**
	 * Wird von Traktor.iterationTyp(...) aufgerufen, falls es sich um einen Biogas Traktor handelt
	 * @param item Biogas-Traktor (!=null)
	 */
	public void iterationTraktorBiogas(TraktorBiogas item) { }
	
	/**
	 * Wird von Traktor.iteration(...) fuer jeden Traktor des Sets aufgerufen, falls iteration nicht ueberschrieben worden ist.
	 * zur Typunterscheidung kann diese Methode ueberschrieben werden: item.interationTyp(this);
	 * zur Modulunterscheidung kann diese Methode ueberschrieben werden: item.interationModul(this);
	 * @param item Traktor (!=null)
	 */
	public void iterationTraktor(Traktor item) { }
	
	/**
	 * Wird von der Methode Modul.iterationModul(...) aufgerufen, die von Traktor.interationModul(...) aufgerufen wird, falls der Traktor ein Dirllmaschinen-Modul montiert hat 
	 * @param modul Modul
	 * @param traktor Traktor auf dem das Modul montiert ist
	 */
	public void iterationModulDrillmaschine(Drillmaschine modul, Traktor traktor) { }
	
	/**
	 * Wird von der Methode Modul.iterationModul(...) aufgerufen, die von Traktor.interationModul(...) aufgerufen wird, falls der Traktor ein Duengerstreuer-Modul montiert hat 
	 * @param modul Modul
	 * @param traktor Traktor auf dem das Modul montiert ist
	 */
	public void iterationModulDuengerstreuer(Duengerstreuer modul, Traktor traktor) { }
}
