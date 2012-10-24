import java.util.*;

/**
 * Verwaltet alle sonstigen Finanzen
 */
public class OtherFinance {
	private String name;
	private Date date;
	private String description;
	private long amount;
	
	public OtherFinance(String name, Date date, String description, long amount) {
		setName(name);
		setDate(date);
		setDescription(description);
		setAmount(amount);
	}
	
	//SET
	public void setName(String name) { this.name = name; }
	public void setDate(Date date) { this.date = date; }
	public void setDescription(String description) { this.description = description; }
	public void setAmount(long amount) { this.amount = amount; }
	
	//GET
	public String getName() { return name; }
	public Date getDate() { return date; }
	public String getDescription() { return description; }
	public long getAmount() { return amount; }
}