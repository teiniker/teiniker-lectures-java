# Example: Input Validation - Book

## Using Exceptions 

The Java method `setIsbn(String isbn)` is designed to set the value 
of an `isbn` field in a class. The method includes specific 
**pre-conditions** that must be met before the `isbn` field can 
be successfully set. 

```Java
	public void setIsbn(String isbn)
	{
		if(isbn == null || isbn.isBlank())
			throw new IllegalArgumentException("Invalid isbn number!");

		this.isbn = isbn;
	}
```

* **Condition Check**: The method first checks whether the provided 
    `isbn` string is either `null` or blank (empty or containing 
    only whitespace).

* **Exception Handling**: If the `isbn` is `null` or blank, the 
    method throws an `IllegalArgumentException` with a message 
    indicating that the provided `isbn` number is invalid:

These pre-conditions ensure that the `isbn` field of an object is 
always a meaningful string, preventing the class from holding an 
invalid or nonsensical ISBN value. 

This method exemplifies **defensive programming**, where methods 
check their arguments for validity before proceeding with operations, 
ensuring that the object's state remains consistent and valid 
throughout its lifecycle.


## Unit Tests 

The following test cases show how you can test pre-conditions:

There are multiple ways to test for exceptions. The following 
examples illustrate two common approaches to testing exception 
handling in methods:

* **Using try-catch blocks** 

```Java
	@Test
	public void testInvalidIsbn_Blank()
	{
		try
		{
			new Book("", "Robert C. Martin", "Clean Code");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Invalid isbn number!", e.getMessage());
			// passed
		}
	}
```

* **Using the expected attribute of the @Test annotation**

```Java
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidIsbn_Null()
	{
		new Book(null, "Robert C. Martin", "Clean Code");
	}
```

Choosing between these methods depends on the specifics of what we need 
to test about the exception:

* We use the **try-catch** method if we need to perform additional 
    validations on the exception itself (like checking the error message).
* We use the **expected** attribute for a straightforward check that 
    an exception is thrown, when no further details about the exception 
    are necessary.

*Egon Teiniker, 2024, GPL v3.0*
