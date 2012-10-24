/**
 * Repraesentiert ein Infrastruktur Element fuer einen Ort
 */
public class InfrastructureItem {
	public InfrastructureItem() {}
	public InfrastructureItem(String name)
	{
		setName(name);
	}
	
	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof InfrastructureItem)) { return false; }
		final InfrastructureItem other = (InfrastructureItem) obj;
		
		return
			((name == other.name) || (name != null && name.equals(other.name)));
	}
	
	@Override
	public int hashCode() {
        return (name == null ? 0 : name.hashCode());
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
