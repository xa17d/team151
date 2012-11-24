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
	public String insert(int seriennummer, Androide androide, Skin skin, /*SoftwareTyp softwareTyp,*/ SoftwareStufe softwareStufe/*, ArrayList<SensorenAktoren> sensorenAktoren*/) {
		//Ueberpruefung auf zugelassene Eingabeparameter
		String errorSkin = androide.checkSkin(skin);
		String errorSoftwareStufe = androide.checkSoftwareStufe(softwareStufe);
		
		//TODO SoftwareTyp und SensorenAktoren
		
		if(errorSkin!=null)
			return errorSkin;
		else if(errorSoftwareStufe!=null)
			return errorSoftwareStufe;
		
		//TODO NoSuchElementException im Iterator irgendwie anders vermeiden
		//zu Testzwecken um NoSuchElementException zu verhindern
		AusgelieferterAndroide a = new AusgelieferterAndroide(0, new Bauarbeiter(), new GepanzerterSkin(), new SoftwareStufe1());
		androideMap.put(0, a);
		//------------------------------------------------------
		
		AusgelieferterAndroide neuerAndroide = new AusgelieferterAndroide(seriennummer, androide, skin, softwareStufe);
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
		Map.Entry<Integer, AusgelieferterAndroide> entry = androideMap.floorEntry(seriennummer);
		if (entry != null) {
			return entry.getValue().toString();
		}
		else { return null; }
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

		int key = androideMap.firstKey();
		
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
		 */
		@Override
		public AusgelieferterAndroide next() {
			key = androideMap.higherKey(key);
			return androideMap.get(key);
		}

		@Override
		public void remove() {
			//KEINE AKTION, DA DAS LOESCHEN VON ANDROIDEN NICHT GESTATTET IST!
		}
		
	}
}
