package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSetTest
{
	private Set<String> set;

	@Before
	public void setup()
	{
		set = new HashSet<>();
		//set = new TreeSet<>();
		set.add("Homer");
		set.add("Marge");
		set.add("Bart");
		set.add("Lisa");
		set.add("Maggie");
	}
	
	@Test
	public void testSize()
	{
		int size = set.size();
		Assert.assertEquals(5, size);
	}

	@Test
	public void testForEachLoop()
	{
		// for-each loop to iterate elements
		for(String element : set)
		{
			System.out.print("\"" + element + "\" ");
		}
	}

	@Test
	public void testConatins()
	{
		Assert.assertTrue(set.contains("Homer"));
		Assert.assertFalse(set.contains("Burns"));
		Assert.assertTrue(set.contains("Marge"));
	}


	@Test
	public void testReadOnlySet()
	{
		Set unmodifableSet = Set.of("Homer", "Marge", "Bart", "Lisa", "Maggie");
		Assert.assertTrue(unmodifableSet.contains("Lisa"));
		Assert.assertFalse(unmodifableSet.contains("Burns"));
		Assert.assertTrue(unmodifableSet.contains("Bart"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testReadOnlySetModification()
	{
		Set unmodifableSet = Set.of("");
		unmodifableSet.add(99);
	}
}
