
public class InfrastructureItem {
	
	// Erzeugt ein neues InfrastructureItem und gibt es zurueck
	// FEHLER: es sollte sichgestellt werden dass name != null ist
	public InfrastructureItem() {}
	
	// Erzeugt ein neues InfrastructureItem und gibt es zurueck (postcondition)
	// name setzen, darf nicht null sein (precondition)
	public InfrastructureItem(String name)
	{
		setName(name);
	}
	
	private String name; // Bezeichnung des Infrastruktur-Elements, name != null
	
	// Gibt den Namen zurueck (postcondition)
	public String getName() { return name; }
	// Setzt den Namen
	// name: neuer Name, darf nicht null sein (precondition)
	public void setName(String name) { this.name = name; }
	
	// Gibt true zurueck, wenn obj inhaltlich gleich ist wie dieses Objekt (postcondition)
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof InfrastructureItem)) { return false; }
		final InfrastructureItem other = (InfrastructureItem) obj;
		
		return
			((name == other.name) || (name != null && name.equals(other.name)));
	}
	
	// Gibt einen HashCode fuer dieses Objekt zurueck (postcondition)
	@Override
	public int hashCode() {
        return (name == null ? 0 : name.hashCode());
	}
	
	// Gibt dieses Objekt als String zurueck (postcondition)
	@Override
	public String toString() {
		return getName();
	}
}
