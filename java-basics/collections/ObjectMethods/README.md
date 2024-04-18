# Example: Object Methods

## Implementing hashCode() and equals()

In order to be able to manage the `Book` class in a **HashSet**, the two 
methods `hashCode()` and `equals()` are implemented.

```Java 
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

In this implementation, `Book` objects are only compared based on their `ISBN` number.

In order to be able to use objects of the `Book` class in a **TreeSet**, 
we have to implement the `Comparable<Book>` interface with the `compareTo()` 
method.


## Providing a Comparator

If we want to change the sorting order and the property by which we want 
to sort, we can give the collection constructor a comparator object.

```Java 
import java.util.Comparator;

public class TitleComparator
    implements Comparator<Book>
{
    @Override
    public int compare(Book o1, Book o2)
    {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
```

```Java 
	@Test
	public void testComparator()
	{
		set = new TreeSet<>(new TitleComparator());

		set.add(new Book("9780132350881", "Robert C. Martin", "Clean Code"));
		set.add(new Book("9780132350882", "Joshua Bloch", "Effective Java"));
		set.add(new Book("9780132350883", "Robert C. Martin", "Clean Architecture"));

		for(Book book : set)
		{
			System.out.println(book);
		}
	}
```

We will see later that such simple `Comparator` objects can be replaced 
by **Lambda Expressions**.

*Egon Teiniker, 2024, GPL v3.0*