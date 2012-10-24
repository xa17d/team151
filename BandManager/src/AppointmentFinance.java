/**
 * Verknuepft die Termine der Band mit ihren Finanzen
 */
public class AppointmentFinance {
	private Appointment p;
	private long amount;
	
	public AppointmentFinance(Appointment p, long amount) {
		setAppointment(p);
		setAmount(amount);
	}
	
	//SET
	public void setAppointment(Appointment p) { this.p = p; }
	public void setAmount(long amount) { this.amount = amount; }
	
	//GET
	public Appointment getAppointment() { return p; }
	public long getAmount() { return amount; }
}