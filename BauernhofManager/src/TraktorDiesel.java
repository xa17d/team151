/**
 * Repraesentiert einen Dieseltraktor mit zusaetlicher Angabe des Dieselerbrauchs in Liter.
 * @author raphael
 */
@AuthorAnnotation(author="Raphael")
public class TraktorDiesel extends Traktor {
	
	private int verbrauch; //Verbrauch in Liter 
	
	/**
	 * Konstruktor
	 * @param id
	 */
	@AuthorAnnotation(author="Raphael")
	public TraktorDiesel(int id, Modul modul) { super(id, modul); }
	
	@Override
	@AuthorAnnotation(author="Raphael")
	public void interationTyp(Iteration iteration) {
		iteration.iterationTraktorDiesel(this);
	}

	/**
	 * @return Verbrauch in Liter (Diesel)
	 */
	@AuthorAnnotation(author="Raphael")
	public int getVerbrauch() {
		return verbrauch;
	}

	/**
	 * @param Setzt den bisherigen Vebrauch
	 */
	@AuthorAnnotation(author="Raphael")
	public void setVerbrauch(int verbrauch) {
		this.verbrauch = verbrauch;
	}
	
	@Override
	@AuthorAnnotation(author="Raphael")
	public String toString(){
		return "Dieseltraktor: " + super.toString();
	}
}
