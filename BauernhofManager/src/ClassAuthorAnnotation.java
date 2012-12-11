/**
 * enthaelt:
 * java.lang.annotation.Retention;
 * java.lang.annotation.Target;
 * java.lang.annotation.RetentionPolicy;
 * java.lang.annotation.ElementType;
 */
import java.lang.annotation.*;

/**
 * Meta-Annotation
 * definiert dass Annotation zur Laufzeit zugreifbar ist
 */
@Retention(RetentionPolicy.RUNTIME)

/**
 * Meta-Annotation
 * definiert dass Annotation vor Klassen, Interfaces oder Enumerationen stehen kann
 */
@Target(ElementType.TYPE)

/**
 * Annotation zur Bestimmung des Autors einer Klasse
 * @author Lucas
 */
public @interface ClassAuthorAnnotation {
	
	/**
	 * Author der Klasse
	 * @return Name des Authors
	 */
	String author() default "OOP151";
	
	/**
	 * Bezeichnung der Klasse
	 * @return Bezeichnung
	 */
	String className();
}
