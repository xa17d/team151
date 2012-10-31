import java.util.*;

public class OtherFinance {
	private String name;
	private Date date;
	private String description;
	private long amount;
	
	//VB: amount > 0;
	public OtherFinance(String name, Date date, String description, long amount) {
		setName(name);
		setDate(date);
		setDescription(description);
		setAmount(amount);
	}
	
	public void setName(String name) { this.name = name; }
	public void setDate(Date date) { this.date = date; }
	public void setDescription(String description) { this.description = description; }
	public void setAmount(long amount) { this.amount = amount; }
	
	public String getName() { return name; }
	public Date getDate() { return date; }
	public String getDescription() { return description; }
	public long getAmount() { return amount; }
}