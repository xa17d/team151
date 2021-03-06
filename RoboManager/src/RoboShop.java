import java.util.*;

/**
 * verwaltet die Liste alles ausgelieferten Androiden
 * @author Lucas
 */
public class RoboShop {
	/**
	 * liste aller ausgelieferten Androiden, sortiert nach Seriennummer
	 */
	private TreeMap<Integer, AusgelieferterAndroide> androideMap = new TreeMap<Integer,AusgelieferterAndroide>();
	
	/**
	 * stellt neuen Androiden zusammen
	 * befor der Android ausgeliefert werden kann, muss die Kompatibilitaet der verscheidenen Komponenten ueberprueft werden
	 * @param seriennummer eindeutige Identifikationsnummer
	 * @param androide Androide-Typ
	 * @param skin	Skin-Typ
	 * @param softwareTyp Typ der Software
	 * @param softwareStufe Stude der Software
	 * @param sensorenAktoren Liste mit allen verbauten Sensoren und Aktoren
	 * @return falls Eingabe nicht korrekt: Fehlercode
	 * 		   falls Androide ausgeliefert werden kann: null
	 */
	public String insert(int seriennummer, Androide androide, Skin skin, Software software, AktorenKit aktorenKit) {
		//Ueberpruefung auf zugelassene Eingabeparameter
		String errorSkin = androide.checkSkin(skin);
		String errorSoftware = androide.checkSoftware(software);
		String errorAktorenKitSoftware = androide.checkAktorenKitSoftware(aktorenKit, software.getStufe());
		
		//TODO SoftwareTyp und SensorenAktoren
		
		if(errorSkin!=null)
			return errorSkin;
		else if (errorSoftware!=null)
			return errorSoftware;
		else if(errorAktorenKitSoftware != null)
			return errorAktorenKitSoftware;
		
		AusgelieferterAndroide alterAndroide = androideMap.get(seriennummer);
		AusgelieferterAndroide neuerAndroide = new AusgelieferterAndroide(seriennummer, androide, skin, software, aktorenKit, alterAndroide);
		if (alterAndroide != null) {
			String errorTypAenderung = androide.checkAenderungTyp(alterAndroide.getAndroide());
			String errorSoftwareAenderung = software.getStufe().checkAenderungStufe(alterAndroide.getSoftware().getStufe());
			
			if(errorTypAenderung!=null)
				return errorTypAenderung;
			else if (errorSoftwareAenderung!=null)
				return errorSoftwareAenderung; 
		}
		
		androideMap.put(seriennummer, neuerAndroide);
		
		return null;
	}
	
	/**
	 * kann verwendet werden um einen ausgelieferten Androiden nach seiner Seriennummer zu suchen
	 * @param seriennummer
	 * @return seriennummer existiert: einen String mit saemtlichen Komponenten des Androiden
	 *	   seriennummer existiert nicht: null
	 */
	public String find(int seriennummer) {
		AusgelieferterAndroide a = androideMap.get(seriennummer);
		if (a==null) { return null; }
		else { return a.toString(); }
	}
	
	/**
	 * liefert einen Iterator um durch die Liste aller Androiden zu gehen
	 * @return Iterator
	 */
	public AndroidIterator iterator() {
		return new AndroidIterator();
	}
	
	/**
	 * innere Klasse Iterator
	 * implementiert den Iterator der durch die Liste alles ausgelieferter Androiden geht
	 * @author Lucas
	 */
	private class AndroidIterator implements Iterator<AusgelieferterAndroide> {

		int key = androideMap.firstKey()-1;
		
		/**
		 * liefert boolschen Wert ob es noch ein naechstes Element in der Liste gibt
		 * @return true: falls noch ein weiteres Element in der Liste, sonst false
		 */
		@Override
		public boolean hasNext() {
			if(androideMap.higherKey(key)==null)
				return false;
			else
				return true;
		}

		/**
		 * liefert naechsten Androiden in der Liste
		 * @return neachster Androide
		 */
		@Override
		public AusgelieferterAndroide next() {
			key = androideMap.higherKey(key);
			AusgelieferterAndroide result = androideMap.get(key);
			return result;
			
		}

		@Override
		public void remove() {
			//KEINE AKTION, DA DAS LOESCHEN VON ANDROIDEN NICHT GESTATTET IST!
		}
		
	}
}
