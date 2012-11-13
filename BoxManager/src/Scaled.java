/**
 * enthaelt ein 2 dimensionales Array in dem Elemente vom Typ P gespeichert sind
 * 
 * @param <P> P ist Untertyp von Pict oder Pict selbst
 * @author Lucas Dobler
 */
public class Scaled<P extends Pict> implements Pict{
	/**
	 * rechteckiges Array
	 * fuer alle zeile=0..p.length-1, spalte=0..p.length-1 gilt: p[zeile][spalte] ist vom Typ P oder dessen Untertyp und != null
	 */
	private P[][] picture;
	
	/**
	 * Konstruktor
	 * @param picture rechteckiges Array
	 * 				  fuer alle zeile=0..p.length-1, spalte=0..p.length-1 gilt: p[zeile][spalte] ist vom Typ P oder dessen Untertyp und != null
	 */
	public Scaled(P[][] picture) {
		setPicture(picture);
	}
	
	/**
	 * skaliert jedes Element des Arrays auf die des Typs spezifizierte Art
	 * @param factor 0.1 <= factor <= 10.0
	 */
	public void scale(double factor) {
		for(int i = 0; i < picture.length; i++) {
			for(int j = 0; j < picture[0].length; j++) {
				picture[i][j].scale(factor);
			}
		}
	}
	
	/**
	 * Elemente des rechteckigen Arrays werden als String nebeneinander und uebereinander liegend zurueckgegeben.
	 * Haben die Elemente unterschiedliche Hoehe bzw. Breite, werden die kleineren Elemente unterhalb bzw. rechts
     * mit Leerzeichen aufgefuellt.
     * Ist der durch (wiederholte) Aufrufe von scale gesetzte Skalierungsfaktor kleiner 1.0, so liefert toString
     * nur die entsprechend große linke obere Ecke. Ist der Skalierungsfaktor groesser als 1.0, so wird der Text
     * entsprechend oft neben- bzw. uebereinander wiederholt.
	 */
	@Override
	public String toString() {
		Repeated<P> rep = new Repeated<P>(picture);
		
		return rep.toString();
	}
	
	/**
	 * Setter
	 * @param picture rechteckiges Array
	 * 				  fuer alle zeile=0..p.length-1, spalte=0..p.length-1 gilt: p[zeile][spalte] ist vom Typ P oder dessen Untertyp und != null
	 */
	private void setPicture(P[][] picture) { this.picture = picture; }
}