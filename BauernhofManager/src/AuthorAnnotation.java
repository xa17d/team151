/**
 * enthaelt u.a.:
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
 * definiert dass Annotation vor Klassen (inkl. Interfaces und Enumerationen), Methoden und Konstruktoren stehen kann
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})

/**
 * Annotation zur Bestimmung des Autors einer Methode
 * @author Lucas
 */
@AuthorAnnotation(author="Lucas")
public @interface AuthorAnnotation {
	
	/**
	 * Author der Methode
	 * wird kein Autor angegeben, wird als Standart-Wert "OOP151" angenommen
	 * @return Name des Authors
	 */
	@AuthorAnnotation(author="Lucas")
	String author() default "OOP151";
}
