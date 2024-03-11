package org.se.lab;

public class Book
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

	public String toJson()
	{
		return "{" +
				"\"isbn\":\"" + isbn + "\"," +
				"\"author\":\"" + author.replace("\"", "\\\"") + "\"," +
				"\"title\":\"" + title.replace("\"", "\\\"") + "\"" +
				"}";
	}

	/*
	 * Object methods
	 */

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
}
