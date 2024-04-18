package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class HashSetTest
{
	private Set<Book> set;

	@Before
	public void setUp()
	{
		set = new HashSet<>();
		set.add(new Book("9780132350884", "Robert C. Martin", "Clean Code"));
		set.add(new Book("9780134685991", "Joshua Bloch", "Effective Java"));
		set.add(new Book("9780134494166", "Robert C. Martin", "Clean Architecture"));
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

}
