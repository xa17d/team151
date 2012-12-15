/**
 * Backmaschine die einen Keks bestehen aus einer Unter- und einer identischen Oberseite baeckt
 * @author Lucas
 */
public class DoppelKeksBackmaschine {
	
	/**
	 * 
	 * @param keks 1.Keks der als Vorlage fuer den 2. Keks dient
	 * @param fuellung Fuellung != null
	 * @return Doppelseitiger Keks
	 */
	public DoppelKeks backeKeks(EinfacherKeks keks, Fuellung fuellung) {
		return new DoppelKeks(keks, keks.clone(), fuellung);
	}
}
