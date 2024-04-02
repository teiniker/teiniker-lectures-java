package org.se.lab;

public class Book
	extends DataEntity
{
	/*
	 * Constructor
	 */
	public Book(String isbn, String author, String title)
	{
		super(isbn, title);
		this.author = author;
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

	public String toCsv()
	{
		return "\"" + getId() + "\"," + "\"" + author + "\",\"" + getTitle() + "\"";
	}

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return "Book{" +
				"isbn='" + getId() + '\'' +
				", author=" + author +
				", title=" + getTitle() +
				'}';
	}
}
