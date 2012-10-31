import java.util.*;

/**
 * Musikgruppe
 */
public class Band {
	
	private String bandName;
	private Genre genre;
	private BandFinance bf;
	
	private History<Member> mHistory = new History<Member>();
	private History<Song> sHistory = new History<Song>();
	
	private ArrayList<Appointment> appList = new ArrayList<Appointment>();

	public Band(String bandName, Genre genre) {
		setBandName(bandName);
		setGenre(genre);
		
		bf = new BandFinance();
	}
	
	//LOCATION
	private ArrayList<Location> locations = new ArrayList<Location>();
	
	public void addLocation(Location location)
	{
		locations.add(location);
	}
	
	public boolean deleteLocation(Location location)
	{
		return locations.remove(location);
	}

	public ArrayList<Location> getLocations(Collection<InfrastructureItem> neccenecessaryInfrastructureItems)
	{
		ArrayList<Location> filteredLocations = new ArrayList<Location>();
		
		if (neccenecessaryInfrastructureItems == null)
		{
			filteredLocations.addAll(locations);
		}
		else
		{
			for (Location location : locations) {
				if (location.checkInfrastructure(neccenecessaryInfrastructureItems))
				{
					filteredLocations.add(location);
				}
			}
		}
		
		return filteredLocations;
	}

	public void addMember(Member member) {		
		mHistory.add(member);
	}

	public ArrayList<Member> listMember() {
		return listMember(new Date());
	}

	public ArrayList<Member> listMember(Date date) {
		return mHistory.list(date);
	}

	public boolean deleteMember(Member member) {
		return mHistory.delete(member);
	}

	public void addSong(Song song) {
		sHistory.add(song);
	}

	public ArrayList<Song> listSongs() {
		return listSongs(new Date());
	}

	public ArrayList<Song> listSongs(Date date) {
		return sHistory.list(date);
	}

	public boolean deleteSong(Song song) {
		return sHistory.delete(song);
	}

	//Gig = gueltiger Gig laut Konstruktor (precondition)
	//appList.add (history-constraint: Server)
	public void addGig(Gig gig) {
		appList.add(gig);
	}

	//rehearsal = gueltige Rehearsal laut Konstruktor (precondition)
	//appList.add (history-constraint: Server)
	public void addRehearsal(Rehearsal rehearsal) {
		appList.add(rehearsal);
	}

	//dateFrom & dateTo = gueltiges Datum (precondition)
	public ArrayList<Appointment> listAppointment(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0)
				ret.add(app);
		}
		
		return ret;
	}

	//dateFrom & dateTo = gueltiges Datum (precondition)
	public ArrayList<Appointment> listGig(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0 && app instanceof Gig)
				ret.add(app);
		}
		
		return ret;
	}

	//dateFrom & dateTo = gueltiges Datum (precondition)
	public ArrayList<Appointment> listRehearsal(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0 && app instanceof Rehearsal)
				ret.add(app);
		}
		
		return ret;
	}
	
	//app muss ein gueltiger Gig bzw. Rehearsal sein, location = gueltige Location, dBegin = gueltiges Datum, duration >= 0, cash >= 0 (precondition)
	public void changeAppointment(Appointment app, Location location, Date dBegin, long duration, long cash){
		appList.get(appList.indexOf(app)).addChange(location, dBegin, duration, cash, app.isCanceled());
	}

	//Bei app muss es sich um ein existierendes Appointment in der List appList handeln (precondition)
	public void cancelAppointment(Appointment app){
		appList.get(appList.indexOf(app)).addChange(app.getLocation(), app.getdBegin(), app.getDuration(), app.getCash(), app.isCanceled());
		appList.get(appList.indexOf(app)).setCanceled(true);
	}
	
	// SCHLECHT: unused
	public int getAppointmentIndex(int id){
		for(int i = 0; i < appList.size(); i++){
			if(appList.get(i).getId() == id)
				return i;
			System.out.println("i: " + i);
		}
		return -1;
	}

	// SCHLECHT: unused
	public Appointment getAppointment(int id){
		for(Appointment app : appList){
			if(app.getId() == id)
				return app;
		}
		return null;
	}

	// es muss sich um ein existierendes Appointment in der List appList handeln (precondition)
	// Wenn ein Element noch nie veraendert wurde tritt eine ArrayIndexOutOfBoundsException auf. (postcondition)
	public void undoAppointmentChange(Appointment app){
		try{
			appList.get(appList.indexOf(app)).undo();
		} catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("Fehler in undoAppointmentChange:\n" + ex.getLocalizedMessage() + 
					"\nMoeglicherweise gibt es keine Veraenderungen");
		}
	}
	
	//VB: dateFrom < dateTo
	public long finance(CalculationType ct, Date dateFrom, Date dateTo) {
		return bf.getFinance(ct, dateFrom, dateTo, appList);
	}

	//VB: income > 0; dateFrom < dateTo
	public void addIncome(String name, Date date, String description, long income) {
		bf.addIncome(name, date, description, income);
	}
	

	//VB: expense > 0; dateFrom < dateTo
	public void addExpense(String name, Date date, String description, long expense) {
		bf.addExpense(name, date, description, expense);
	}

	public String getBandName() { return bandName; }
	public Genre getGenre() { return genre; }
	public BandFinance getBandFinance() { return bf; }

	public void setBandName(String bandName) { this.bandName = bandName; }
	public void setGenre(Genre genre) { this.genre = genre; }
}