import java.util.ArrayList;
import java.util.Collection;

/**
 * Repraesentiert einen Probe- oder Auftrittsort
 *
 */
public class Location {
	
	public Location() {}
	public Location(String name, String address)
	{
		infrastructureItems = new ArrayList<InfrastructureItem>();
		
		setName(name);
		setAddress(address);
	}
	
	private String name;
	private String address;
	private ArrayList<InfrastructureItem> infrastructureItems;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	/**
	 * Gibt eine Liste mit allen Infrastruktur-Elementen fuer diesen Ort zurueck
	 * @return Infrastruktur Elemente
	 */
	public ArrayList<InfrastructureItem> getInfrastructureItems()
	{
		return infrastructureItems;
	}
	
	public void addInfrastructureItem(InfrastructureItem item)
	{
		infrastructureItems.add(item);
	}
	
	public boolean deleteInfrastructureItem(InfrastructureItem item)
	{
		return infrastructureItems.remove(item);
	}
	
	public boolean checkInfrastructure(Collection<InfrastructureItem> neccenecessaryInfrastructureItems)
	{
		return infrastructureItems.containsAll(neccenecessaryInfrastructureItems);
	}
	
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
	
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 19 + (name == null ? 0 : name.hashCode());
        hash = hash * 17 + (address == null ? 0 : address.hashCode());
        hash = hash * 13 + (infrastructureItems.hashCode());
        return hash;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
