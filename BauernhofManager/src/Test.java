/**
 * fuer Reflections um Annotationen zur Laufzeit auszulesen
 */
import java.lang.reflect.*;

@ClassAuthorAnnotation(className="Test-Klasse")
public class Test {
	@MethodAuthorAnnotation(methodName="Test-Methode")
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
		/*
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
		printClassInfo(Test.class);
		printClassInfo(Traktor.class);
		printClassInfo(TraktorBiogas.class);
		printClassInfo(TraktorDiesel.class);
		printClassInfo(TraktorSet.class);
		*/
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void printClassInfo(Class c) {
		//Annotatione einer Klasse ausgeben
		System.out.println("Annotation der Klasse *"+c.getName()+"*:");
		if (c.isAnnotationPresent(ClassAuthorAnnotation.class)) {
			ClassAuthorAnnotation classAnnotation = Duengerstreuer.class.getAnnotation(ClassAuthorAnnotation.class);
			System.out.println(classAnnotation.className()+": " + classAnnotation.author());
		}
			
		//Annotationen der Methoden (und Konstruktoren) einer bestimmten Klasse ausgeben
		System.out.println("Konstruktoren:");
		
		Constructor[] constructors = c.getConstructors();
		for(Constructor co : constructors) {
			if(co.isAnnotationPresent(MethodAuthorAnnotation.class)) {
				MethodAuthorAnnotation methodAnnotation = (MethodAuthorAnnotation)co.getAnnotation(MethodAuthorAnnotation.class);
				System.out.println("\t"+methodAnnotation.methodName() + ": " + methodAnnotation.author());
			}
		}
		
		System.out.println("Methoden:");
		Method[] methods = c.getMethods();
		for(Method m : methods) {
			if(m.isAnnotationPresent(MethodAuthorAnnotation.class)) {
				MethodAuthorAnnotation methodAnnotation = m.getAnnotation(MethodAuthorAnnotation.class);
				System.out.println("\t"+methodAnnotation.methodName() + ": " + methodAnnotation.author());
			}
		}
		
		System.out.println("");
	}
}
