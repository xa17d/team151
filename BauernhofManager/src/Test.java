/**
 * fuer Reflections um Annotationen zur Laufzeit auszulesen
 */
import java.lang.reflect.*;

@AuthorAnnotation()
public class Test {
	@AuthorAnnotation()
	public static void main(String[] args) {
		BauernhofSet hoefe = new BauernhofSet();
		
		hoefe.insert(new Bauernhof("Goldweide"));
		hoefe.insert(new Bauernhof("Cow-Paradise"));
		hoefe.insert(new Bauernhof("Frischheu"));
		
		//Bauernhof Goldweide
		//Biogastraktoren
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(1, new Duengerstreuer(10.5)));
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(2, new Duengerstreuer(20.5)));
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(3, new Drillmaschine(3)));
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(4, new Drillmaschine(10)));
		
		//Dieseltraktoren
		hoefe.get("Goldweide").addTraktor(new TraktorDiesel(5, new Duengerstreuer(500)));
		hoefe.get("Goldweide").addTraktor(new TraktorDiesel(6, new Duengerstreuer(200)));
		hoefe.get("Goldweide").addTraktor(new TraktorDiesel(7, new Drillmaschine(5)));

		//Betriebsstunden des Traktors 1,2,3,7 aendern
		hoefe.get("Goldweide").getTraktor(1).setBetriebsstunden(1000);
		hoefe.get("Goldweide").getTraktor(2).setBetriebsstunden(10);
		hoefe.get("Goldweide").getTraktor(3).setBetriebsstunden(5000);
		hoefe.get("Goldweide").getTraktor(7).setBetriebsstunden(10000);
		
		//Verbrauch fuer die Traktoren setzen
		((TraktorDiesel)hoefe.get("Goldweide").getTraktor(7)).setVerbrauch(1000);
		((TraktorBiogas)hoefe.get("Goldweide").getTraktor(1)).setVerbrauch(500.9);
		((TraktorBiogas)hoefe.get("Goldweide").getTraktor(2)).setVerbrauch(1000.00);
		((TraktorBiogas)hoefe.get("Goldweide").getTraktor(3)).setVerbrauch(200.27);
		
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
