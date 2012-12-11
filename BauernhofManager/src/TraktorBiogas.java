/**
 * Repraesentiert einen Biogastraktor durch zusaetliche Angabe des Volumenverbrauchs.
 * @author raphael
 */
@AuthorAnnotation(author="Raphael")
public class TraktorBiogas extends Traktor {
	
	private double verbrauch;
	
	/**
	 * Konstruktor
	 * @param id
	 */
	@AuthorAnnotation(author="Raphael")
	public TraktorBiogas(int id, Modul modul) { super(id, modul); }
	
	/**
	 * @return aktuellen Verbrauch an Biogas
	 */
	@AuthorAnnotation(author="Raphael")
	public double getVerbrauch() {
		return verbrauch;
	}

	/**
	 * @param setzt den bisherigen Verbrauch
	 */
	@AuthorAnnotation(author="Raphael")
	public void setVerbrauch(double verbrauch) {
		this.verbrauch = verbrauch;
	}
	
	@Override
	@AuthorAnnotation(author="Raphael")
	public void interationTyp(Iteration iteration) {
		iteration.iterationTraktorBiogas(this);
	}
	
	@Override
	@AuthorAnnotation(author="Raphael")
	public String toString(){
		return "Biogastraktor: " + super.toString();
	}
}
