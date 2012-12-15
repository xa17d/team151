/**
 * Backmaschine die einen Keks bestehend aus einer Unter- und einer aequivalenten Oberseite mit Fuellung baeckt
 * @author lucas
 */
public class DoppelKeksBackmaschine {
	
	/**
	 * beackt Keks bestehend aus einer Unter- und Oberseite mit Fuellung
	 * @param keks 1.Keks der als Vorlage fuer den 2. Keks dient
	 * @param fuellung Fuellung != null
	 * @return Doppelter Keks
	 */
	public DoppelKeks backeKeks(EinfacherKeks keks, Fuellung fuellung) {
		return new DoppelKeks(keks, keks.clone(), fuellung);
	}
}
