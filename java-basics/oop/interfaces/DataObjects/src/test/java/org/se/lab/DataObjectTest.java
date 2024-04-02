package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class DataObjectTest
{
	@Test
	public void testBook()
	{
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertEquals("\"9780132350884\",\"Robert C. Martin\",\"Clean Code\"", book.toCsv());
	}

	@Test
	public void testDvd()
	{
		Dvd dvd = new Dvd("3636208", "Matt Groening", "The Simpsons - Season 11");

		Assert.assertEquals("\"3636208\",\"Matt Groening\",\"The Simpsons - Season 11\"", dvd.toCsv());
	}

	@Test
	public void testDataObject()
	{
		DataObject obj = new Dvd("3636208", "Matt Groening", "The Simpsons - Season 11");

		Assert.assertEquals("\"3636208\",\"Matt Groening\",\"The Simpsons - Season 11\"", obj.toCsv());
	}

	@Test
	public void testPolymorphism()
	{
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		String bookCsv = toCsv(book);
		Assert.assertEquals("\"9780132350884\",\"Robert C. Martin\",\"Clean Code\"", bookCsv);

		Dvd dvd = new Dvd("3636208", "Matt Groening", "The Simpsons - Season 11");
		String dvdCsv = toCsv(dvd);
		Assert.assertEquals("\"3636208\",\"Matt Groening\",\"The Simpsons - Season 11\"", dvdCsv);
	}

	// This method accepts all objects which implement the interface DataObject
	private String toCsv(DataObject obj)
	{
		return obj.toCsv();
	}
}