package org.se.lab;

public class Book
	implements Comparable<Book>
{
	/*
	 * Constructor
	 */
	public Book(String isbn, String author, String title)
	{
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}

	/*
	 * Property: isbn:String
	 */
	private String isbn;
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	/*
	 * Property: author:String
	 */
	private String author;
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/*
	 * Property: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", author='" + author +
				"', title='" + title +
				"'}";
	}


	@Override
	public boolean equals(Object o)
	{
		System.out.println("Book.equals()");
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

	@Override
	public int hashCode()
	{
		System.out.println("Book.hashCode()");
		return isbn.hashCode();
	}

	@Override
	public int compareTo(Book o)
	{
		return getIsbn().compareTo(o.isbn);
	}
}
