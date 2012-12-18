import java.util.ArrayList;

/**
 * 
 * @author raphael
 *
 */
public class Keksdose {
	private ArrayList<Keks> keksDosenInhalt;
	
	/**
	 * Keksdosen Konstruktor
	 * initialisiert den keksDosenInhalt
	 * Keksdose ist ab jetzt leer.
	 */
	public Keksdose(){
		keksDosenInhalt = new ArrayList<Keks>();
	}
	
	/**
	 * Fuegt einen neuen Keks zum keksDosenInhalt hinzu
	 * @param keks (darf nicht null sein)
	 */
	public void addKeks(Keks keks){
		keksDosenInhalt.add(keks);
	}
	
	/**
	 * Gibt den Inhalt der Keksdose auf der Standardausgabe aus.
	 * Wenn kein Keks vorhanden - keine Ausgabe
	 */
	public void inhalt(){
		for(Keks k : keksDosenInhalt)
			System.out.println(k.toString());
	}
}
