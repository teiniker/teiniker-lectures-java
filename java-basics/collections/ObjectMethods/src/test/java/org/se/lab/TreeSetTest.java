package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;

public class TreeSetTest
{
	private Set<Book> set;

	@Before
	public void setUp()
	{
		set = new TreeSet<>();

		set.add(new Book("9780132350881", "Robert C. Martin", "Clean Code"));
		set.add(new Book("9780132350882", "Joshua Bloch", "Effective Java"));
		set.add(new Book("9780132350883", "Robert C. Martin", "Clean Architecture"));
	}

	@Test
	public void testSize()
	{
		Assert.assertEquals(3, set.size());
	}

	@Test
	public void testContains()
	{
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Assert.assertTrue(set.contains(book));
	}

	@Test
	public void testContainsNot()
	{
		Book book = new Book("0000000000000", "Robert C. Martin", "Clean Code");
		Assert.assertFalse(set.contains(book));
	}

	@Test
	public void testAddSame()
	{
		set.add(new Book("9780134685991", "Joshua Bloch", "Effective Java"));
		Assert.assertEquals(3, set.size());
	}

	@Test
	public void testForEachLoop()
	{
		for(Book book : set)
		{
			System.out.println(book);
		}
	}

	@Test
	public void testComparator()
	{
		set = new TreeSet<>(new TitleComparator());
		//set = new TreeSet<>((o1,o2) -> o1.getTitle().compareTo(o2.getTitle()));
		//set = new TreeSet<>(Comparator.comparing(Book::getTitle));

		set.add(new Book("9780132350881", "Robert C. Martin", "Clean Code"));
		set.add(new Book("9780132350882", "Joshua Bloch", "Effective Java"));
		set.add(new Book("9780132350883", "Robert C. Martin", "Clean Architecture"));

		for(Book book : set)
		{
			System.out.println(book);
		}
	}
}
