package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntegerListTest
{
	private List<Integer> list;

	@Before
	public void setup()
	{
		list = new ArrayList<>();	// Implementation as array
		//list = new LinkedList<>();	// Implementation as linked list
		list.add(98);	// append
		list.add(-12);
		list.add(32);
		list.add(-4);
		list.add(3);
		list.add(64);
		list.add(-1);
		list.add(5);
		list.add(12);
		list.add(-7);
	}
	
	@Test
	public void testSize()
	{
		int size = list.size();
		Assert.assertEquals(10, size);
	}

	@Test
	public void testForEachLoop()
	{
		// for-each loop to iterate elements
		for(int element : list)
		{
			System.out.print(element + " ");
		}
	}

	@Test
	public void testGet()
	{
		Assert.assertEquals(Integer.valueOf(98), list.get(0));
		Assert.assertEquals(Integer.valueOf(-12), list.get(1));
		Assert.assertEquals(Integer.valueOf(32), list.get(2));
		//...
		Assert.assertEquals(Integer.valueOf(-7), list.get(9));
	}

	@Test
	public void testSet()
	{
		list.set(1, 66);
		Assert.assertEquals(Integer.valueOf(66), list.get(1));
	}

	@Test
	public void testContains()
	{
		Assert.assertTrue(list.contains(-1));
		Assert.assertFalse(list.contains(-2));
		Assert.assertTrue(list.contains(-4));
	}

	@Test
	public void testReadOnlyList()
	{
		List unmodifableList = List.of(98,-12,32,-4,3,64,-1,5,12,-7);

		Assert.assertEquals(Integer.valueOf(98), unmodifableList.get(0));
		//...
		Assert.assertEquals(Integer.valueOf(-7), unmodifableList.get(9));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testReadOnlyListModification()
	{
		List unmodifableList = List.of(98,-12,32,-4,3,64,-1,5,12,-7);
		unmodifableList.add(99);
	}
}
