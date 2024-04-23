# Exceptions 

Exceptions are events that disrupt the normal flow of a program's instructions. 
They are **objects that wrap an error event** that occurred within a method and contain 
information about the error, including its type and the state of the program when 
the error occurred. 

Java uses exceptions to **manage errors and other exceptional events** and provides a 
robust framework for handling them.

## Types of Exceptions
Java categorizes exceptions into two main types, based on how they are checked by 
the compiler:

* **Checked Exceptions**: These are exceptions that must be either caught or declared 
    in the method where they occur. They extend the `Exception` class. Checked exceptions 
    are used for **recoverable conditions**; the compiler ensures that these exceptions 
    are either surrounded with a `try-catch` block or declared with a `throws` clause in 
    the method signature.

* **Unchecked Exceptions**: These exceptions include `RuntimeException` and its 
    subclasses, and `Error` and its subclasses. Unchecked exceptions represent problems 
    that are typically the result of **programming errors**, such as logic errors or 
    improper use of an API. `Error` is used for serious errors from which recovery is 
    not expected, like `OutOfMemoryError`. 
    Unchecked exceptions do not need to be declared in a method's throws clause.

## Exception Handling

Java provides several mechanisms for handling exceptions:

* **try-catch Block**: The `try-catch` block is used to catch exceptions. The code 
    that might throw an exception is placed inside the `try` block, and the `catch` 
    block is used to handle the exception that occurs. 
    We can have multiple `catch` blocks to handle different types of exceptions.

* **finally Block**: The `finally` block is optional and follows the `try-catch` blocks. 
    It **contains code that is always executed**, regardless of whether an exception was 
    thrown or caught. It's typically used for cleanup activities.

* **throws Keyword**: The `throws` keyword is used in a method's signature to declare 
    that the method might throw certain exceptions. 
    The calling method must handle these exceptions.

* **throw Keyword**: The `throw` keyword is used to explicitly throw an exception, 
    either a newly instantiated one or one that was caught.

_Example:_ Input validation 
```Java
	public void setIsbn(String isbn)
	{
		if(isbn == null || isbn.isBlank())
			throw new IllegalArgumentException("Invalid isbn number!");

		this.isbn = isbn;
	}
```


_Example:_ Try with resources and exception wrapping
```Java
	private String readFirstLine(String path)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
		catch(IOException e)
		{
			throw new ServiceException("Can't read from " + path, e);
		}
	}
```

Understanding and properly using exceptions is crucial for building robust, 
error-resistant Java applications.


## Standard Exceptions

The Java libraries provide a set of exceptions that covers most of the 
exception-throwing needs of most APIs.
Reusning standard exceptions make an API easier to learn and use because 
it matches the established conventions that programmers are already 
familiar with.

**Do not reuse Exception, RuntimeException, Throwable, or Error directly.**

The most commonly reused exception type is **IllegalArgumentException**.
This is the exception to throw when the caller passes in an arguent whose 
value is inapproriate.

If a caller passes null in some parameter for which null values are prohibited, 
convention dictates that 
**NullPointerException** be thrown rather than `IllegalArgumentException`.
Similarly, if a caller passes out-of-range value in a parameter representing 
an index into a sequence, 
**IndexOutOfBoundsException** should be thrown rather than IllegalArgumentException.

Another commonly reused exception is **IllegalStateException**. This is 
generally the exception to throw if the invocation is illegal because of the 
state of the receiving object.

The **UnsupportedOperationException** is thrown if an object does not support 
an attempted operation.
This exception is used by classes that fail to implement one or more optional 
operations defined by an interface they implement.

It would be appropriate to reuse **ArithmeticException** and 
**NumberFormatException** if you were implementing arithmetic objects such 
as complex numbers or rational numbers.

If an exception fits your needs, go ahead and use it, but only if the 
conditions under which you would throw it are consistent with the 
exception's documentation: **Reuse must be based on documented semantics, 
not just on name**.

## References

* [The Java™ Tutorials: Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
* [Baeldung: Exception Handling in Java](https://www.baeldung.com/java-exceptions)

*Egon Teiniker, 2024, GPL v3.0* 
