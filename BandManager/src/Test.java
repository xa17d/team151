import java.util.*;

//HALLO WELT!!!!

//Hallo welt 2

/**
 * Testprogramm
 */
public class Test {
	/**
	 * Main-Methode
	 * fuehrt eine Testroutine durch
	 */
	public static void main(String[] args) {
		// Test
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		
		int correct = 0;
		int i = 0;
		String s = "";
		long m = 0;
		
		//neue Band gruenden
		System.out.println("** 'The Beatles' im Genre 'Rock' wird gegruendet");
		Band b1 = new Band("The Beatles",Genre.Rock);
		
		
		//Mitglieder hinzufuegen
		System.out.println("** 4 neue Mitglieder werden zu hinzugefuegt");
		Member m1 = new Member("John Lennon", "0664/1234567", Instrument.AcousticGuitar);
		Member m2 = new Member("Paul McCartney", "0699/1234567", Instrument.BassGuitar);
		Member m3 = new Member("George Harrison", "0660/1234567", Instrument.Guitar);
		Member m4 = new Member("Ringo Starr", "0680/1234567", Instrument.Drums);
		b1.addMember(m1);
		b1.addMember(m2);
		b1.addMember(m3);
		b1.addMember(m4);
		
		try { Thread.sleep(50); } catch(InterruptedException e) { }
		Date dSave = new Date();
		try { Thread.sleep(50); } catch(InterruptedException e) { }
		
		//aktuelle Mitglieder auflisten
		s = b1.listMember().toString();
		i++;
		if(s.equals("[John Lennon (AcousticGuitar; Tel: 0664/1234567), Paul McCartney (BassGuitar; Tel: 0699/1234567), George Harrison (Guitar; Tel: 0660/1234567), Ringo Starr (Drums; Tel: 0680/1234567)]"))
			correct++;
		
		System.out.println("Die aktuellen Mitglieder sind: " + s);
		
		//Ein Mitglied verlaesst die Band
		System.out.println("** John Lennon verlaesst die Band");
		b1.deleteMember(m1);
		
		//aktuelle Mitglieder auflisten
		s = b1.listMember().toString();
		i++;
		if(s.equals("[Paul McCartney (BassGuitar; Tel: 0699/1234567), George Harrison (Guitar; Tel: 0660/1234567), Ringo Starr (Drums; Tel: 0680/1234567)]"))
			correct++;
		
		System.out.println("Die aktuellen Mitglieder sind :" + s);
		
		//ehemalige Mitglieder auflisten
		s = b1.listMember(dSave).toString();
		i++;
		if(s.equals("[John Lennon (AcousticGuitar; Tel: 0664/1234567), Paul McCartney (BassGuitar; Tel: 0699/1234567), George Harrison (Guitar; Tel: 0660/1234567), Ringo Starr (Drums; Tel: 0680/1234567)]"))
			correct++;
		
		System.out.println("Die ehemaligen Mitglieder waren: " + s);
		
		
		//neue Lieder ins Repertoire aufnehmen
		System.out.println("** Band lernt 2 neue Lieder");
		Song s1 = new Song("Love Me Do", 212);
		Song s2 = new Song("A Hard Day's Night", 168);
		b1.addSong(s1);
		b1.addSong(s2);
		
		try { Thread.sleep(50); } catch(InterruptedException e) { }
		dSave = new Date();
		try { Thread.sleep(50); } catch(InterruptedException e) { }
		
		//aktuelles Repertoire aufzaehlen
		s = b1.listSongs().toString();
		i++;
		if(s.equals("[Love Me Do (212s), A Hard Day's Night (168s)]"))
			correct++;
		
		System.out.println("Folgende Lieder kann die Band derzeit spielen: " + s);
		
		//neues Lied lernen und altes Lied verlernen
		System.out.println("** Band lernt ein neues Lied, verlernt dafuer ihr erstes Lied");
		Song s3 = new Song("Yesterday", 182);
		b1.deleteSong(s1);
		b1.addSong(s3);
		
		//aktuelles Repertoire aufzaehlen
		s = b1.listSongs().toString();
		i++;
		if(s.equals("[A Hard Day's Night (168s), Yesterday (182s)]"))
			correct++;
		
		System.out.println("Folgende Lieder kann die Band derzeit spielen: " + s);
		
		//ehemaliges Repertoire aufzaehlen
		s = b1.listSongs(dSave).toString();
		i++;
		if(s.equals("[Love Me Do (212s), A Hard Day's Night (168s)]"))
			correct++;
		
		System.out.println("Folgende Lieder konnte die Band frueher spielen: " + s);
		
		// Locations
		Location abbeyRoad = new Location("Abbey Road", "Abbey Road, London");
		Location hollywoodBowl = new Location("Hollywood Bowl", "2301 North Highland Avenue, Los Angeles");
		Location wembley = new Location("Wembley", "Wembley Stadium, Wembley, London");
		Location puchberg = new Location("Puchberg", "Puchberg am Schneeberg");
		Location irgendwo = new Location("Irgendwo", "Somestreet 1, Somewhere");
		Location nirgendwo = new Location("Nirgendwo", "Nostreet 99, Nowhere");
		
		// Infrastruktur Elemente erzeugen und zu den Locations zuweisen
		InfrastructureItem mikrofon = new InfrastructureItem("Mikrofon");
		InfrastructureItem verstaerker = new InfrastructureItem("Verstaerker");
		InfrastructureItem scheinwerfer = new InfrastructureItem("Scheinwerfer");
		
		hollywoodBowl.addInfrastructureItem(mikrofon);
		hollywoodBowl.addInfrastructureItem(verstaerker);
		hollywoodBowl.addInfrastructureItem(scheinwerfer);
		
		wembley.addInfrastructureItem(mikrofon);
		wembley.addInfrastructureItem(verstaerker);
		wembley.addInfrastructureItem(scheinwerfer);
		
		puchberg.addInfrastructureItem(mikrofon);
		puchberg.addInfrastructureItem(verstaerker);
		
		// Locations zur Band hinzufuegen
		b1.addLocation(abbeyRoad);
		b1.addLocation(hollywoodBowl);
		b1.addLocation(wembley);
		b1.addLocation(puchberg);
		b1.addLocation(irgendwo);
		b1.addLocation(nirgendwo);
		
		
		ArrayList<InfrastructureItem> items = new ArrayList<InfrastructureItem>();
		items.add(mikrofon);
		s = b1.getLocations(items).toString();
		i++;
		if(s.equals("[Hollywood Bowl, Wembley, Puchberg]"))
			correct++;
		
		items.add(scheinwerfer);
		s = b1.getLocations(items).toString();
		i++;
		if(s.equals("[Hollywood Bowl, Wembley]"))
			correct++;
		
		//Probe veranstalten
		System.out.println("** Band fuehrt 3 Proben durch");
		
		c.set(2011,8,12,18,0);
		d = c.getTime();
		Rehearsal r1 = new Rehearsal(abbeyRoad, d, 120, 50);
		b1.addRehearsal(r1);
		c.set(2011,10,5,19,15);
		d = c.getTime();
		Rehearsal r2 = new Rehearsal(abbeyRoad, d, 100, 40);
		b1.addRehearsal(r2);
		c.set(2012,6,12,16,30);
		d = c.getTime();
		Rehearsal r3 = new Rehearsal(hollywoodBowl, d, 240, 100);
		b1.addRehearsal(r3);
		
		//Konzerte spielen
		System.out.println("** Band spielt 2 Konzerte");
		c.set(2011,11,20,22,10);
		d = c.getTime();
		Gig g1 = new Gig(wembley, d, 90, 200);
		b1.addGig(g1);
		c.set(2012,6,13,19,0);
		d = c.getTime();
		Gig g2 = new Gig(hollywoodBowl, d, 60, 500);
		b1.addGig(g2);
		
		//alle Termine aufzaehlen
		c.set(2011,1,1);
		Date df = c.getTime();
		c.set(2012,12,31);
		Date dt = c.getTime();
		
		s = b1.listAppointment(df, dt).toString();
		i++;
		if(s.equals("[Abbey Road (12. September 2011 18:00, 120, 50, false), Abbey Road (05. November 2011 19:15, 100, 40, false), Hollywood Bowl (12. Juli 2012 16:30, 240, 100, false), Wembley (20. Dezember 2011 22:10, 90, 200, false), Hollywood Bowl (13. Juli 2012 19:00, 60, 500, false)]"))
			correct++;
		
		System.out.println("alle Termine der Band: " + s);
		
		//nur Proben vom August 2011 aufzaehlen
		c.set(2011,8,1);
		df = c.getTime();
		c.set(2011,8,30);
		dt = c.getTime();
		
		s = b1.listRehearsal(df, dt).toString();
		i++;
		if(s.equals("[Abbey Road (12. September 2011 18:00, 120, 50, false)]"))
			correct++;
		
		System.out.println("im August 2012 hatte die Band folgende Proben: " + s);
		
		//nur Konzerte von 2012 aufzaehlen
		c.set(2012,1,1);
		df = c.getTime();
		dt = new Date();
		
		s = b1.listGig(df, dt).toString();
		i++;
		if(s.equals("[Hollywood Bowl (13. Juli 2012 19:00, 60, 500, false)]"))
			correct++;
		
		System.out.println("seit Jannuar 2012 hatte die Band folgende Konzerte: " + s);
		
		//sonstige Einnahmen und Ausgaben
		b1.addIncome("CD", dt, "Einnahmen aus CD verkaufen", 300);
		b1.addExpense("Gitarre", dt, "Gitarrist kauf neue Gitarre", 200);
		
		
		//Einnahmen berechnen
		c.set(2012,1,1);
		df = c.getTime();
		c.set(2012,12,31);
		dt = c.getTime();
		
		m = b1.finance(CalculationType.Gig, df, dt);
		i++;
		if(m == 500)
			correct++;
		
		System.out.println("Einnahmen aus Konzerten in 2012: " + m);
		
		//Ausgaben berechnen
		c.set(2011,1,1);
		df = c.getTime();
		c.set(2011,12,31);
		dt = c.getTime();
		
		m = b1.finance(CalculationType.Rehearsal, df, dt);
		i++;
		if(m == 90)
			correct++;
		System.out.println("Ausgaben fuer Proberaeume in 2011: " + m);
		
		
		//Gewinn berechnen
		c.set(2011,1,1);
		df = c.getTime();
		c.set(2012,12,31);
		dt = c.getTime();
		
		m = b1.finance(CalculationType.Gig, df, dt)
				+ b1.finance(CalculationType.Income, df, dt)
				- b1.finance(CalculationType.Rehearsal, df, dt)
				- b1.finance(CalculationType.Expense, df, dt);
		i++;
		if(m == 610)
			correct++;
		System.out.println("gesamter Gewinn der Beatles: " + m);
		
		//Appointment Changes		
		b1.changeAppointment(r1, puchberg, r1.getdBegin(), r1.getDuration(), r1.getCash());
		b1.changeAppointment(r1, wembley, r1.getdBegin(), r1.getDuration(), r1.getCash());
		b1.changeAppointment(r1, irgendwo, r1.getdBegin(), r1.getDuration(), r1.getCash());
		b1.changeAppointment(r1, nirgendwo, r1.getdBegin(), r1.getDuration(), r1.getCash());
		
		//Ausgabe nach Veraenderungen
		System.out.println(r1.toString());
		
		//Undo Appointment 1
		b1.undoAppointmentChange(r1);
		
		//Undo Appointment 1
		b1.undoAppointmentChange(r1);
		
		//Ausgabe nach 2 x Undo
		System.out.println(r1.toString());
		
		//undo Appointment 2 --> Existiert nicht --> Fehlertest
		b1.undoAppointmentChange(r2);
		
		System.out.println(r1.isCanceled());
		
		//Cancel Appointment 1
		b1.cancelAppointment(r1);
		
		
		//AUSWERTUNG
		String out = "";
		
		if(correct == i)
			out = "\nTEST ERFOLGREICH";
		else
			out = "\nTEST FEHLGESCHLAGEN";
		
		out += "\n" + correct + " von " + i + " Testfaelle erfolgreich";
		
		System.out.println(out);		
	}
}