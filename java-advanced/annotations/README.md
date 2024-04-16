# Java Annotations

Annotations are a form of metadata that provide data about a program 
but are not part of the program itself. Annotations have no direct 
effect on the operation of the code they annotate, but they can be 
used to **provide information to the compiler or to be utilized through
reflection at runtime**.

## Defining an Annotation

Annotations are defined using the `@interface` keyword. 

_Example_: Defining an Annotation for classes and interfaces which is 
    available for analysis at runtime.
```Java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Version
{
	int major() default 1;
	int minor() default 0;
	int bugfix() default 0;
}
```

Annotations can be applied to declarations like classes, methods, fields, or other program elements depending on their `@Target` configuration.

Annotations can be retained (`@Retention`) at different stages of the program:
* **Source**: Annotations are only available in the source code and 
    are discarded by the compiler.
* **Class**: Annotations are recorded in the class file by the compiler but 
    not available at runtime through reflection.
* **Runtime**: Annotations are recorded in the class file by the compiler 
    and available at runtime through reflection.

## Using Annotations

The annotation defined above can be evaluated at runtime using the 
**Reflection API**.

```Java
	@Test
	public void testVersionElements()
	{
		User user = new User(7, "Franz Kafka");
		
		AnnotatedElement type = user.getClass();
		assertTrue(type.isAnnotationPresent(Version.class));
		
		int major = type.getAnnotation(Version.class).major();
		int minor = type.getAnnotation(Version.class).minor();
		int bugfix = type.getAnnotation(Version.class).bugfix();
		assertEquals(2, major);
		assertEquals(3, minor);
		assertEquals(17, bugfix);	
	}
```

`user.getClass()` retrieves the `Class` object that represents the 
class of user.

`AnnotatedElement` is an interface implemented by Java reflection 
objects that can have annotations, such as classes, methods, and fields.

The expression `type.isAnnotationPresent(Version.class)` checks whether 
the `User` class is annotated with `@Version`.

`getAnnotation(Version.class)` retrieves the `@Version` annotation 
from the `User` class.
`.major()`, `.minor()`, and `.bugfix()` are methods defined in the 
`@Version` annotation, presumably to hold versioning information.


## Built-in Java Annotations

Java provides several built-in annotations like:

* **@Override**: Indicates that a method declaration is intended to 
    override a method declaration in a superclass.
* **@Deprecated**: Marks the annotated element as deprecated, 
    indicating that it should no longer be used.
* **@SuppressWarnings**: Instructs the compiler to suppress specific 
    warnings it would otherwise generate.
* **@FunctionalInterface**: This annotation is used to indicate that 
    an interface is intended to be a functional interface. Functional 
    interfaces are a key feature in Java, especially since they serve as the basis for lambda expressions introduced in Java 8.


## References

* [YouTube: Annotations In Java Tutorial - How To Create And Use Your Own Custom Annotations](https://youtu.be/DkZr7_c9ry8?si=mQnIKhgZXw0mZGSU)

* [The Java™ Tutorials: Annotations](https://docs.oracle.com/javase/tutorial/java/annotations/)

* [Baeldung: Creating a Custom Annotation in Java](https://www.baeldung.com/java-custom-annotation)
* [Baeldung: Overview of Java Built-in Annotations](https://www.baeldung.com/java-default-annotations)

* Java API:
    * [Interface AnnotatedElement](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/reflect/AnnotatedElement.html)


*Egon Teiniker, 2024, GPL v3.0*
