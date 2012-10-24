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

	/**
	 * Konstruktor um neue Band zu initialisieren
	 * @param name Name der Musikgruppe
	 * @param genre Ausrichtung der Musikgruppe
	 */
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
	
	/**
	 * Gibt alle Locations zurueck, die mindestens bestimmte Infrastruktur bieten
	 * @param neccenecessaryInfrastructureItems Infrastruktur die unbeding benoetigt wird, null wenn keine bestimmte Infrastruktur benoetigt wird
	 * @return Orte die die gewuenschte Infrastruktur bieten
	 */
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
	
	
	//MEMBER
	/**
	 * fuegt neues Mitglied hinzu
	 * @param member neues Mitglied
	 */
	public void addMember(Member member) {		
		mHistory.add(member);
	}
	
	/**
	 * liefert Liste mit allen Mitgliedern die zurzeit in der Musikgruppe sind
	 * @return Liste aller Mitglieder
	 */
	public ArrayList<Member> listMember() {
		return listMember(new Date());
	}
	
	/**
	 * liefert Liste mit allen Mitgliedern die zu einem bestimmten Zeitpunkt in der Musikgruppe waren
	 * @param date Zeitpunkt
	 * @return Liste aller Mitglieder
	 */
	public ArrayList<Member> listMember(Date date) {
		return mHistory.list(date);
	}
	
	/**
	 * loescht ein Mitglied aus der Musikgruppe
	 * @param member zu loeschendes Mitglied
	 * @return hat funktioniert
	 */
	public boolean deleteMember(Member member) {
		return mHistory.delete(member);
	}
	
	
	//SONG
	/**
	 * fuegt ein Lied zum aktuellen Repertoire hinzu
	 * @param song neues Lied
	 */
	public void addSong(Song song) {
		sHistory.add(song);
	}
	
	/**
	 * liefert List mit allen Liedern die zurzeit im Repertoire sind
	 * @return Liste alles Lieder
	 */
	public ArrayList<Song> listSongs() {
		return listSongs(new Date());
	}
	
	/**
	 * liefert List mit allen Liedern die zu einem bestimmten Zeitpunkt im Repertoire waren
	 * @param date Zeitpunkt
	 * @return Liste alles Lieder
	 */
	public ArrayList<Song> listSongs(Date date) {
		return sHistory.list(date);
	}
	
	/**
	 * loescht ein Lied aus dem aktuellen Repertoire
	 * @param song zu loeschendes Lied
	 * @return hat funktioniert
	 */
	public boolean deleteSong(Song song) {
		return sHistory.delete(song);
	}
	
	
	//APPOINTMENT	
	/**
	 * erstellt den Termin eines neuen Auftritts
	 * @param location Ort
	 * @param dateTime Datum und Uhrzeit
	 * @param duration Dauer
	 * @param money Gage
	 */
	public void addGig(Gig gig) {
		appList.add(gig);
	}
	
	/**
	 * erstellt den Termin einer neuen Probe
	 * @param location Ort
	 * @param dateTime Datum und Uhrzeit
	 * @param duration Dauer
	 * @param money Miete
	 */
	public void addRehearsal(Rehearsal rehearsal) {
		appList.add(rehearsal);
	}
	
	/**
	 * liefert eine ArrayList in der alle Auftritte UND Proben in einem bestimmten Zeitraum aufgelistet sind
	 * @param dateFrom Anfangsdatum des Zeitraums
	 * @param dateTo Enddatum des Zeitraums
	 * @return Auflistung der Auftritte und Proben
	 */
	public ArrayList<Appointment> listAppointment(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0)
				ret.add(app);
		}
		
		return ret;
	}
	
	/**
	 * liefert eine ArrayList in der alle Auftritte in einem bestimmten Zeitraum aufgelistet sind
	 * @param dateFrom Anfangsdatum des Zeitraums
	 * @param dateTo Enddatum des Zeitraums
	 * @return Auflistung der Auftritte
	 */
	public ArrayList<Appointment> listGig(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0 && app instanceof Gig)
				ret.add(app);
		}
		
		return ret;
	}
	
	/**
	 * liefert eine ArrayList in der alle Proben in einem bestimmten Zeitraum aufgelistet sind
	 * @param dateFrom Anfangsdatum des Zeitraums
	 * @param dateTo Enddatum des Zeitraums
	 * @return Auflistung der Proben
	 */
	public ArrayList<Appointment> listRehearsal(Date dateFrom, Date dateTo) {
		ArrayList<Appointment> ret = new ArrayList<Appointment>();
		
		for(Appointment app : appList){
			if((dateFrom.compareTo(app.getdBegin()) + dateTo.compareTo(app.getdBegin())) == 0 && app instanceof Rehearsal)
				ret.add(app);
		}
		
		return ret;
	}
	
	/**
	 * Ueberschreibt die Aenderungen in der Appointment List
	 * das vorherige Appointment wird in der changeList des
	 * jeweiligen Appointmens gespeichert.
	 * Somit kann jede Veraenderung nachverfolgt und auch wieder rekonstruiert werden.
	 * @param app ... Appointment welches geaendert wird.
	 * @param id
	 * @param location 
	 * @param dBegin
	 * @param duration
	 * @param money
	 */
	public void changeAppointment(Appointment app, Location location, Date dBegin, long duration, long cash){
		appList.get(appList.indexOf(app)).addChange(location, dBegin, duration, cash, app.isCanceled());
	}
	
	/**
	 * Absagen eines Appointments durch aufrufen der Appointment Methode
	 * @param app
	 */
	public void cancelAppointment(Appointment app){
		appList.get(appList.indexOf(app)).addChange(app.getLocation(), app.getdBegin(), app.getDuration(), app.getCash(), app.isCanceled());
		appList.get(appList.indexOf(app)).setCanceled(true);
	}
	
	
	/**
	 * Liefert den Index eines Appointment anhand er uebergebenen id
	 * in der Liste der Appointments appList
	 * @param id zu suchende Id
	 * @return Appointment, wenn nicht gefunden -1
	 */
	public int getAppointmentIndex(int id){
		for(int i = 0; i < appList.size(); i++){
			if(appList.get(i).getId() == id)
				return i;
			System.out.println("i: " + i);
		}
		return -1;
	}
	
	/**
	 * Liefert das Appointment aus der appList
	 * anhand seiner Id.
	 * @param id
	 * @return Appointment, wenn nicht gefunden null
	 */
	public Appointment getAppointment(int id){
		for(Appointment app : appList){
			if(app.getId() == id)
				return app;
		}
		return null;
	}
	
	/**
	 * Stellt den Status vor der letzten Veraenderung wieder her
	 * @param app
	 */
	public void undoAppointmentChange(Appointment app){
		try{
			appList.get(appList.indexOf(app)).undo();
		} catch (ArrayIndexOutOfBoundsException ex){
			System.err.println("Fehler in undoAppointmentChange:\n" + ex.getLocalizedMessage() + 
					"\nMoeglicherweise gibt es keine Veraenderungen");
		}
	}
	
	
	//EINNAHMEN UND AUSGABEN
	/**
	 * berechnet die Einnahmen bzw. Ausgaben fuer einen bestimmten Zeitraum
	 * @param ct Typ der Berechnung
	 * @param dateFrom Anfangsdatum
	 * @param dateTo Enddatum
	 * @return Einnahmen bzw. Ausgaben
	 */
	public long finance(CalculationType ct, Date dateFrom, Date dateTo) {
		return bf.getFinance(ct, dateFrom, dateTo, appList);
	}
	
	/**
	 * fuegt eine neue Einnahme hinzu
	 * @param name Einnahme
	 * @param date Datum
	 * @param description Beschreibung
	 * @param income Betrag
	 */
	public void addIncome(String name, Date date, String description, long income) {
		bf.addIncome(name, date, description, income);
	}
	
	/**
	 * fuegt eine neue Ausgabe hinzu
	 * @param name Einnahme
	 * @param date Datum
	 * @param description Beschreibung
	 * @param expense Betrag
	 */
	public void addExpense(String name, Date date, String description, long expense) {
		bf.addExpense(name, date, description, expense);
	}
	
	//GET
	public String getBandName() { return bandName; }
	public Genre getGenre() { return genre; }
	public BandFinance getBandFinance() { return bf; }
	
	//SET
	public void setBandName(String bandName) { this.bandName = bandName; }
	public void setGenre(Genre genre) { this.genre = genre; }
}