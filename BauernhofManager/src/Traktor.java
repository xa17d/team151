/**
 * Repraesentiert einen Traktor durch seine id, betriebsstunden und ein Modul
 * @author raphael
 */
@AuthorAnnotation(author="Raphael")
public abstract class Traktor implements IteratableObject {
	
	private int id;
	private int betriebsstunden;
	private Modul modul;
	
	
	/**
	 * Konstruktor
	 * Setzt die id des Traktors und das Modul Betriebsstunden werden beim neuen
	 * Anlegen eines Traktors auf 0 gesetzt.
	 * @param id
	 * @param modul
	 */
	@AuthorAnnotation(author="Raphael")
	public Traktor(int id, Modul modul) { this.id = id; setModul(modul); this.betriebsstunden = 0; }
	
	/**
	 * @return id des Traktors
	 */
	@AuthorAnnotation(author="Raphael")
	public int getId() { return id; }
	
	/**
	 * @return aktuellen Betriebsstunden des Traktors
	 */
	@AuthorAnnotation(author="Raphael")
	public int getBetriebsstunden() {
		return betriebsstunden;
	}

	/**
	 * @param betriebsstunden setzt die Betriebsstunden fuer den Traktor
	 */
	@AuthorAnnotation(author="Raphael")
	public void setBetriebsstunden(int betriebsstunden) {
		this.betriebsstunden = betriebsstunden;
	}
	
	/**
	 * 
	 * @return Modul des Traktors (z.B. Duengstreuer, Drillmaschine)
	 */
	@AuthorAnnotation(author="Raphael")
	public Modul getModul() { return modul; }
	
	/**
	 * @param modul Aendert das Modul des Traktors
	 */
	@AuthorAnnotation(author="Raphael")
	public void setModul(Modul modul) { this.modul = modul; }
	
	/**
	 * Ruft iteration.iterationTraktor auf. Auch Untertypen von Traktor rufen genau diese Methode auf
	 */
	@Override
	@AuthorAnnotation(author="Raphael")
	public final void iteration(Iteration iteration) {
		iteration.iterationTraktor(this);
	}
	
	/**
	 * Ruft je nach Untertyp iteration.iterationTraktorBiogas oder iteration.iterationTraktorDiesel auf
	 * @param iteration Iteration
	 */
	@AuthorAnnotation(author="Raphael")
	public abstract void interationTyp(Iteration iteration);
	
	/**
	 * Ruf je nach Modul iteration.iterationModulDrillmaschine oder iteration.iterationModulDuengerstreuer auf. Ist kein Modul angebracht, wird nichts aufgerufen.
	 * @param iteration Iteration
	 */
	@AuthorAnnotation(author="Raphael")
	public void interationModul(Iteration iteration) {
		if (modul != null) {
			modul.interationModul(iteration, this);
		}
	}

	@Override
	@AuthorAnnotation(author="Raphael")
	public String toString(){
		return "Id: " + id + ", Betriebsstunden: " + betriebsstunden + ", Modul: " + modul.toString();
	}
}
