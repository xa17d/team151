import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MethodAuthorAnnotation {
	String author() default "OOP151";		//Author der Methode
	String methodName();					//Name der Methode
}
