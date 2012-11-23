import java.util.*;

public class RoboShop {
	
	public String insert(int seriennummer, Androide androide, Skin skin/*, Software software, ArrayList<SensorenAktoren> sensorenAktoren*/) {
		String existingAndroide = this.find(seriennummer);
		
		if(existingAndroide==null) {
			//TODO INSERT
			String check;
			
			check = androide.checkSkin(skin);
			
			if(check==null) {
				androide.setSkin(skin);
				return "";
			}
			else
				return check;
		}
		else {
			//TODO UPDATE
			return null;
		}
	}
	
	public String find(int seriennummer) {
		//TODO SUCHE
		return null;
	}
	
	public AndroidIterator iterator() {
		return new AndroidIterator();
	}
	
	private class AndroidIterator implements Iterator<Androide> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Androide next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
