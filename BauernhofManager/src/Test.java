import java.lang.reflect.*;		//fuer Reflections um Annotationen zur Laufzeit auszulesen

@ClassAuthorAnnotation(className="Test-Klasse")
public class Test {
	public static void main(String[] args) {
		BauernhofSet hoefe = new BauernhofSet();
		
		hoefe.insert(new Bauernhof("Goldweide"));
		hoefe.insert(new Bauernhof("Cow-Paradise"));
		hoefe.insert(new Bauernhof("Frischheu"));
		
		hoefe.get("Goldweide").addTraktor(new TraktorBiogas(1));
		//...
		
		
		
		
		
		
		/**
		 * Annotationen Test
		 */
		MethodAuthorAnnotation methodAnnotation;
		ClassAuthorAnnotation classAnnotation;
		
		//Annotatione einer Klasse ausgeben
		System.out.println("Annotation der Klasse *Duengerstreuer*:");
		classAnnotation = Duengerstreuer.class.getAnnotation(ClassAuthorAnnotation.class);
		System.out.println(classAnnotation.className() + ": " + classAnnotation.author());
		
		System.out.println("Annotation der Klasse *Test*:");
		classAnnotation = Test.class.getAnnotation(ClassAuthorAnnotation.class);
		System.out.println(classAnnotation.className() + ": " + classAnnotation.author());
		
		
		//Annotationen der Methoden (und Konstruktoren) einer bestimmten Klasse ausgeben
		System.out.println("\nAnnotationen der Methoden der Klasse *Duengerstreuer*:");
		
		/*
		//---------------------------------------------
		//NICHT SEHR GUT, DA KONSTRUKTOREN GENERISCHE GESPEICHERT WERDEN SOLLTEN
		//leider nicht erlaubt...
		//alternativen? konstruktoren weglassen?
		Constructor[] constructors = Duengerstreuer.class.getConstructors();
		for(Constructor c : constructors) {
			if(c.isAnnotationPresent(MethodAuthorAnnotation.class)) {
				methodAnnotation = (MethodAuthorAnnotation) c.getAnnotation(MethodAuthorAnnotation.class);
				System.out.println(methodAnnotation.methodName() + ": " + methodAnnotation.author());
			}
		}
		//---------------------------------------------
		*/
		
		Method[] methods = Duengerstreuer.class.getMethods();
		for(Method m : methods) {
			if(m.isAnnotationPresent(MethodAuthorAnnotation.class)) {
				methodAnnotation = m.getAnnotation(MethodAuthorAnnotation.class);
				System.out.println(methodAnnotation.methodName() + ": " + methodAnnotation.author());
			}
		}
	}
}
