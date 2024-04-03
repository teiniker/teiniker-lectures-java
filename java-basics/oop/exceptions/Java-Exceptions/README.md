# Example: Exception Handling

Errors are common when accessing the file system. Either the file name is wrong 
or the program does not have permission to read a file, etc.

The `readLine()` method used throws a **checked exception** (`IOException`) in 
the event of an error.

```Java
public String readLine() throws IOException {
        return readLine(false, null);
    }
```

## Exception Wrapping

Exception wrapping, also known as exception chaining, is a technique in Java 
that allows one **exception to be caught and rethrown as a different exception**. 

This approach is particularly useful when implementing abstraction layers or when 
working with APIs that should not expose lower-level exceptions to their callers. 
Exception wrapping can help preserve the original exception's stack trace and cause, 
making it easier to debug the root cause of an issue while allowing higher-level code 
to throw exceptions that are more meaningful in its context.

```Java
		try
		{
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		}
		catch(IOException e)
		{
			throw new ServiceException("Can't read from " + path, e);
		}
```
Exception wrapping is often used to switch from a checked exception to a 
runtime exception.

The following example shows how you can implement a runtime exception yourself.
```Java
public class ServiceException
    extends RuntimeException
{
    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
```

## Using finally 

In the example given, a `finally` block is used to close the file in any case. 
Unfortunately, the `close()` method itself can also throw an `IOException`, 
which also needs to be handled.

```Java
		finally
		{
			// Close resources
			try
			{
				if (br != null)
					br.close();
			}
			catch(IOException e)
			{
				// Log that event;
			}
```

To prevent an exception from the `finally` block from covering up a thrown exception, 
a message is written to a log file in the unlikely event that `close()` does not work.


## Using try With Resources

The try-with-resources statement is a `try` statement that declares one or
more resources. A resource is an object that must be closed after the
program is finished with it.

**The try-with-resources statement ensures that each resource is closed at
the end of the statement**.

Any object that implements `java.lang.AutoCloseable`, which includes all
objects which implement `java.io.Closeable`, can be used as a resource.

```Java
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
		catch(IOException e)
		{
			throw new ServiceException("Can't read from " + path, e);
		}
```

The class `BufferedReader` implements the interface `java.lang.AutoCloseable`.

Because the `BufferedReader` instance is declared in a try-with-resource 
statement, it will be closed regardless of whether the `try` statement 
completes normally or abruptly.


## Multiple Catch

A single `catch` block can handle more than one type of exceptions. 
This feature can reduce code duplication and lessen the temptation 
to catch an overly broad exception.

```Java
		try
		{
            // ...
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			throw new ServiceException("Can't connect to the database", e);
		}
```

Note: If a `catch` block handles more than one exception type, then the 
catch parameter is implicitly final.

*Egon Teiniker, 2024, GPL v3.0* 