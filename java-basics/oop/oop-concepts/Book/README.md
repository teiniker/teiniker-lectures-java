# Example: Book

In this example, a class Book will be implemented and its individual parts will be explained.

The most important elements of a class are described in the following sections.

## Constructor

A constructor is a special type of operation in object-oriented programming used to **initialize a newly created object**. 

Constructors prepare new objects for use, often accepting arguments that the constructor uses to set required member 
variables and allocate resources.

```Java
public class Book
{
    public Book(String isbn, String author, String title)
    {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }
    //...
}
```

Note the use of the **this** reference, which always refers to members of your own object. 
Here, the distinction between parameters and fields of the object is made with the help of `this`.


## Properties

The concept of a property in Java is commonly implemented using a combination of private class fields and 
public methods to access (getter) and modify (setter) those fields. 

This practice adheres to the principle of encapsulation, a core tenet of object-oriented programming, 
by restricting direct access to the class's fields and providing controlled access through methods.

```Java
	private String isbn;
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
```

This technique prevents direct access to object fields. 
In addition, you can further restrict access to the fields via the visibility of getter and setter methods 
(e.g.: read-only fields). 
Validation of the data in the setter methods is also possible.


## Object Class Methods

It's a bit confusing, but in Java there is a base class from which all classes are implicitly derived - 
this class is called **Object**.

`Object` defines methods that every data class (a class that serves as a container for data) should override.

```Java
	@Override
	public String toString()
	{
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", author=" + author +
				", title=" + title +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

	@Override
	public int hashCode()
	{
		return isbn.hashCode();
	}
```

* **toString()**: Returns a string representation of the object. By default, it returns a string consisting of the 
    class name followed by the "@" symbol and the object's hashcode in hexadecimal. It is often overridden to provide 
    a more informative string representation of the object.

* **equals(Object obj)**: Determines whether some other object is "equal to" this one. The `equals()` method must 
follow an equivalence relation (it must be reflexive, symmetric, transitive, and consistent) and must return false 
if the passed object is not an instance of the class in which `equals()` is defined (or a subclass thereof).

* **hashCode()**: Returns an integer hash code value for the object. This method is crucial for the proper functioning 
of hash-based collections, such as `HashSet`, `HashMap`, and `HashTable`. The general contract of `hashCode()` is that 
if two objects are equal according to the `equals(Object)` method, then calling the `hashCode()` method on each of the 
two objects must produce the same integer result.


## More Methods

A class can implement any additional methods. Preferably methods that refer to the Object's fields.

_Example:_ `toJson()` serializes a `Book` object into its JSON string 
```Java
	public String toJson()
	{
		return "{" +
				"\"isbn\":\"" + isbn + "\"," +
				"\"author\":\"" + author.replace("\"", "\\\"") + "\"," +
				"\"title\":\"" + title.replace("\"", "\\\"") + "\"" +
				"}";
	}
```

This code transforms an Object into its JSON representation.
```
{
    "isbn":"9780132350884",
    "author":"Robert C. Martin",
    "title":"Clean Code"
}
```

## Unit Tests 

To check whether a method has been implemented correctly, we write unit tests.

```Java
@Test
	public void testToJson()
	{
		// Setup
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		// Exercise
		String json = book.toJson();

		// verify
		String expected = "{\"isbn\":\"9780132350884\",\"author\":\"Robert C. Martin\",\"title\":\"Clean Code\"}";
		Assert.assertEquals(expected, json);

		// Teardown
	}
```

Note that teardown for objects in memory is performed automatically - the object is deleted by the garbage collector.


