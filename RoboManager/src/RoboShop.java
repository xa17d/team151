import java.util.*;

public class RoboShop {
	private TreeMap<Integer, AusgelieferterAndroide> androideMap = new TreeMap<Integer,AusgelieferterAndroide>();
	
	public String insert(int seriennummer, Androide androide, Skin skin, Software software/*, ArrayList<SensorenAktoren> sensorenAktoren*/) {
		//Ueberpruefung auf zugelassene Eingabeparameter
		String errorSkin = androide.checkSkin(skin);
		String errorSoftware = androide.checkSoftware(software);
		//TODO noch auf SensorenAktoren pruefen
		
		if(errorSkin!=null)
			return errorSkin;
		else if(errorSoftware!=null)
			return errorSoftware;
		
		//TODO NoSuchElementException im Iterator irgendwie anders vermeiden
		//zu Testzwecken um NoSuchElementException zu verhindern
		AusgelieferterAndroide a = new AusgelieferterAndroide(0, new Bauarbeiter(), new gepanzerterSkin(), new SoftwareStufe1());
		androideMap.put(0, a);
		//------------------------------------------------------
		
		AusgelieferterAndroide neuerAndroide = new AusgelieferterAndroide(seriennummer, androide, skin, software);
		androideMap.put(seriennummer, neuerAndroide);
		
		return null;
	}
	
	public String find(int seriennummer) {
		Iterator<AusgelieferterAndroide> iter = this.iterator();
		
		while(iter.hasNext()) {
			AusgelieferterAndroide next = iter.next();
			//TODO If-Abfrage irgendwie ersetzen
			if(next.getSeriennummer() == seriennummer)
				return next.toString();
		}

		return null;
	}
	
	public AndroidIterator iterator() {
		return new AndroidIterator();
	}
	
	private class AndroidIterator implements Iterator<AusgelieferterAndroide> {

		int key = androideMap.firstKey();
		
		@Override
		public boolean hasNext() {
			if(androideMap.higherKey(key)==null)
				return false;
			else
				return true;
		}

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
