/**
 * fuer Reflections um Annotationen zur Laufzeit auszulesen
 */
import java.lang.reflect.*;

@AuthorAnnotation()
public class Test {
	@AuthorAnnotation()
	public static void main(String[] args) {
		BauernhofSet hoefe = new BauernhofSet();
		
		int bNr = 0; //Nummer des Bauernhofs
		
		while(bNr < 5){
			String bauernhof = "Bauernhof " + bNr;
			
			//Bauernhof bNr anlegen
			hoefe.insert(new Bauernhof(bauernhof));
			
			int tId = 0; //Traktor Id
			
			//Bauernhof bNr Traktoren hinzufuegen
			//20 Biogastraktoren mit Duengstreuer hinzufuegen
			while(tId < 3){
				hoefe.get(bauernhof).addTraktor(new TraktorBiogas(tId, new Duengerstreuer(Math.abs(Math.random()*100+1))));
				tId++;
			}
			
			//20 Biogastraktoren mit Drillmaschine hinzufuegen
			while(tId < 6){
				hoefe.get(bauernhof).addTraktor(new TraktorBiogas(tId, new Drillmaschine((int) Math.abs(Math.random()*10+1))));
				tId++;
			}
			
			//20 Dieseltraktoren mit Duengstreuer hinzufuegen
			while(tId < 9){
				hoefe.get(bauernhof).addTraktor(new TraktorDiesel(tId, new Duengerstreuer(Math.abs(Math.random()*100+1))));
				tId++;
			}
			
			//20 Dieseltraktoren mit Duengstreuer hinzufuegen
			while(tId < 12){
				hoefe.get(bauernhof).addTraktor(new TraktorDiesel(tId, new Drillmaschine((int) Math.abs(Math.random()*10+1))));
				tId++;
			}

			//Betriebsstunden + Verbrauch der Traktoren aendern
			tId = 0;
			while(tId < 12){
				Traktor t = hoefe.get(bauernhof).getTraktor(tId);
				t.setBetriebsstunden((int) Math.abs(Math.random()*10000+1));
				if(t instanceof TraktorBiogas)
					((TraktorBiogas)t).setVerbrauch(Math.abs(Math.random()*1000+1));
				else if (t instanceof TraktorDiesel)
					((TraktorDiesel)t).setVerbrauch((int)Math.abs(Math.random()*1000+1));
				tId++;
			}
			bNr++;
		}
		
		//Division durch 0: Bauernhof mit 0 Traktoren
		hoefe.insert(new Bauernhof("Bauernhof mit 0 Traktoren"));
		
		
		System.out.print(hoefe);
		
		/**
		 * Annotationen Test
		 */
		printClassInfo(Test.class);
		printClassInfo(Bauernhof.class);
		printClassInfo(BauernhofSet.class);
		printClassInfo(Drillmaschine.class);
		printClassInfo(Duengerstreuer.class);
		printClassInfo(Filters.class);
		printClassInfo(Filters.Biogas.class);
		printClassInfo(Filters.Diesel.class);
		printClassInfo(Filters.ModulDrillmaschine.class);
		printClassInfo(Filters.ModulDuengerstreuer.class);
		printClassInfo(Filters.TraktorModul.class);
		printClassInfo(Filters.TraktorTyp.class);
		printClassInfo(Iteration.class);
		printClassInfo(IterationFilter.class);
		printClassInfo(Modul.class);
		printClassInfo(Set.class);
		printClassInfo(Traktor.class);
		printClassInfo(TraktorBiogas.class);
		printClassInfo(TraktorDiesel.class);
		printClassInfo(TraktorSet.class);
		printClassInfo(AuthorAnnotation.class);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void printClassInfo(Class c) {
		AuthorAnnotation annotation;
		int i = 0;
		
		//Annotatione einer Klasse ausgeben
		System.out.println("Annotation der Klasse *" + c.getName() + "*:");
		if (c.isAnnotationPresent(AuthorAnnotation.class)) {
			annotation = (AuthorAnnotation) c.getAnnotation(AuthorAnnotation.class);
			System.out.println(c.getName() + ": " + annotation.author());
		}
			
		//Annotationen der Methoden (und Konstruktoren) einer bestimmten Klasse ausgeben
		System.out.println("Konstruktoren:");
		
		Constructor[] constructors = c.getConstructors();
		for(Constructor co : constructors) {
			i++;
			if(co.isAnnotationPresent(AuthorAnnotation.class)) {
				annotation = (AuthorAnnotation) co.getAnnotation(AuthorAnnotation.class);
				System.out.println("\t" + co.getName() + "#" + i + ": " + annotation.author());
			}
		}
		
		System.out.println("Methoden:");
		Method[] methods = c.getMethods();
		for(Method m : methods) {
			if(m.isAnnotationPresent(AuthorAnnotation.class)) {
				annotation = m.getAnnotation(AuthorAnnotation.class);
				System.out.println("\t" + m.getName() + ": " + annotation.author());
			}
		}
		
		System.out.println("");
	}
}
