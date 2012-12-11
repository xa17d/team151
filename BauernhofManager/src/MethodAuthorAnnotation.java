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
 * definiert dass Annotation vor Methoden und Konstruktoren stehen kann
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})

/**
 * Annotation zur Bestimmung des Autors einer Methode
 * @author Lucas
 */
public @interface MethodAuthorAnnotation {
	
	/**
	 * Author der Methode
	 * @return Name des Authors
	 */
	String author() default "OOP151";
	
	/**
	 * Bezeichnung der Methode
	 * @return Bezeichnung
	 */
	String methodName();
}
