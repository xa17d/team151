import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassAuthorAnnotation {
	String author() default "OOP151";		//Author der Klasse
	String className();						//Name der Klasse
}
