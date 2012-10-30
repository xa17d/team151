import java.util.ArrayList;
import java.util.Collection;

public class Location {
	
	/**
	 * Erzeugt ein neues Location Objekt und gibt es zurueck
	 * FEHLER: es sollte sichergestellt werden, dass name, address und infrastructureItems nicht null sind.
	 */
	public Location() {}
	
	/**
	 * Erzeugt ein neues Location Objekt und gibt es zurueck
	 * @param name Name des Orts, darf nicht null sein
	 * @param address Adresse des Orts, darf nicht null sein
	 */
	public Location(String name, String address)
	{
		infrastructureItems = new ArrayList<InfrastructureItem>();
		
		setName(name);
		setAddress(address);
	}
	
	private String name; // Name des Orts, darf nicht null sein
	private String address; // Adresse des Orts, darf nicht null sein
	private ArrayList<InfrastructureItem> infrastructureItems; // Infrastruktur-Elemnte, darf nicht null sein
	
	/**
	 * Gibt den Namen des Ortes zurueck
	 * @return Name
	 */
	public String getName() { return name; }
	/**
	 * Setzt den Namen
	 * @param name neuer Name, darf nicht null sein
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Gibt die Adresse zurueck
	 * @return
	 */
	public String getAddress() { return address; }
	/**
	 * Setzt die Adresse
	 * @param address neue Adresse, darf nicht null sein
	 */
	public void setAddress(String address) { this.address = address; }
	
	/**
	 * Gibt eine Liste mit allen Infrastruktur-Elementen fuer diesen Ort zurueck
	 * @return Infrastruktur Elemente
	 */
	public ArrayList<InfrastructureItem> getInfrastructureItems()
	{
		return infrastructureItems;
	}
	
	/**
	 * Fuegt ein neues InfrastructureItem zu diesem Ort hinzu
	 * @param item neues Element, darf nicht null sein
	 */
	public void addInfrastructureItem(InfrastructureItem item)
	{
		infrastructureItems.add(item);
	}
	
	/**
	 * Loescht ein InfrastructureItem aus diesem Ort
	 * @param item zu loeschendes Element
	 * @return true wenn das Element entfernt wurde, false wenn das Element nicht gefunden wurde
	 */
	public boolean deleteInfrastructureItem(InfrastructureItem item)
	{
		return infrastructureItems.remove(item);
	}
	
	/**
	 * Prueft ob bestimmte InfrastructureItems an diesem Ort vorhanden sind
	 * @param neccenecessaryInfrastructureItems Collection mit allen InfrastructureItems die an diesem Ort vorhanden sein muessen, darf nicht null sein.
	 * @return true wenn alle Items vorhanden sind, false wenn mindestens ein Item nicht vorhanden ist.
	 */
	public boolean checkInfrastructure(Collection<InfrastructureItem> neccenecessaryInfrastructureItems)
	{
		return infrastructureItems.containsAll(neccenecessaryInfrastructureItems);
	}
	
	/**
	 * Gibt true zurueck, wenn obj inhaltlich gleich ist wie dieses Objekt
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Location)) { return false; }
		final Location other = (Location) obj;
		
		return
			((name == other.name) || (name != null && name.equals(other.name))) &&
			((address == other.address) || (address != null && address.equals(other.address))) &&
			(infrastructureItems.equals(other.getInfrastructureItems()));
	}
	
	/**
	 * Gibt einen HashCode fuer dieses Objekt zurueck
	 */
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 19 + (name == null ? 0 : name.hashCode());
        hash = hash * 17 + (address == null ? 0 : address.hashCode());
        hash = hash * 13 + (infrastructureItems.hashCode());
        return hash;
	}
	
	/**
	 * Gibt dieses Objekt als String zurueck
	 */
	@Override
	public String toString() {
		return getName();
	}
}
