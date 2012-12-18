/**
 * DoppelKeks besteht aus einem Einfachkeks als Unterseite einer Fuellung und einem Einfachkeks
 * als Oberseite
 * @author raphael
 *
 */
public class DoppelKeks extends Keks{
	private EinfacherKeks keksUnterseite;
	private EinfacherKeks keksOberseite;
	private Fuellung fuellung;
	
	/**
	 * Doppelkeks Konstruktor
	 * @param keksUnterseite Unterseitenkeks (darf nicht null sein)
	 * @param keksOberseite Oberseitenkeks (darf nicht null sein)
	 * @param fuellung verwendete Fuellung (darf nicht null sein)
	 */
	public DoppelKeks(EinfacherKeks keksUnterseite, EinfacherKeks keksOberseite, Fuellung fuellung){
		this.keksUnterseite = keksUnterseite;
		this.fuellung = fuellung;
		this.keksOberseite = keksOberseite;
	}
	
	/**
	 * @return verwendete Fuellung fuer den Doppelkeks (ist nicht null)
	 */
	public Fuellung getFuellung() { return fuellung; }

	/**
	 * @return Unterseitenkeks
	 */
	public EinfacherKeks getKeksUnterseite() {
		return keksUnterseite;
	}
	
	/**
	 * @return Oberseitenkeks
	 */
	public EinfacherKeks getKeksOberseite() {
		return keksOberseite;
	}
	
	@Override
	public String toString(){
		return "Doppelkeks bestehend aus: " + keksUnterseite.toString() + " und " + fuellung.toString();
	}
}
