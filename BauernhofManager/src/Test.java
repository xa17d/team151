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
		
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(1));

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
