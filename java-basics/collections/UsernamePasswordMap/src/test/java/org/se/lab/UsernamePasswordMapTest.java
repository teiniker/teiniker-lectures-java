package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsernamePasswordMapTest
{
	private Map<String, String> map;	// Map<Key,Value>

	@Before
	public void setup()
	{
		map = new HashMap<>();
		//set = new TreeMap<>();
		map.put("Homer", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201");
		map.put("Marge", "18edfe67035984ee8ccb892c7def65f1302fc608f3473c339bbd7ee15ab6c5c3");
		map.put("Bart", "eb27d253723c2e85787db841d64b1eb87ad5ea0dc6d7daf94e4edfc689d31a6a");
		map.put("Lisa", "864282b76c39e6748fa8b9accb2953bc89a3ec4f6c5ca1627624d6a58edd5619");
		map.put("Maggie", "87ff2d3e9553ae41ee4733d5d6596a50453c91ac12c0e187f2827a86397a39ed");
	}
	
	@Test
	public void testSize()
	{
		int size = map.size();
		Assert.assertEquals(5, size);
	}

	@Test
	public void testForEachLoop()
	{
		// for-each loop to iterate elements
		for (Map.Entry<String, String> entry : map.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		// We can't directly iterate over the map itself since it's a collection of key-value
		// pairs (entries), not a single list of elements. However, we can iterate over the
		// entrySet() of the map, which is a Set of Map.Entry objects, each representing a
		// key-value pair.
	}

	@Test
	public void testContainsKey()
	{
		Assert.assertTrue(map.containsKey("Lisa"));
		Assert.assertFalse(map.containsKey("Burns"));
		Assert.assertTrue(map.containsKey("Bart"));
	}

	@Test
	public void testGet()
	{
		Assert.assertEquals("864282b76c39e6748fa8b9accb2953bc89a3ec4f6c5ca1627624d6a58edd5619", map.get("Lisa"));
		Assert.assertEquals("eb27d253723c2e85787db841d64b1eb87ad5ea0dc6d7daf94e4edfc689d31a6a", map.get("Bart"));
	}


	@Test
	public void testKeySet()
	{
		Set<String> keys = map.keySet();
		Assert.assertEquals(5, keys.size());

		for(String key : keys)
		{
			System.out.println(key);
		}
	}

	@Test
	public void testValues()
	{
		Collection<String> values = map.values();
		Assert.assertEquals(5, values.size());

		for(String value : values)
		{
			System.out.println(value);
		}
	}

	@Test
	public void testReadOnlyMap()
	{
		Map<String, String> unmodifableMap = Map.of(
				"Homer", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201",
				"Marge", "18edfe67035984ee8ccb892c7def65f1302fc608f3473c339bbd7ee15ab6c5c3",
				"Bart", "eb27d253723c2e85787db841d64b1eb87ad5ea0dc6d7daf94e4edfc689d31a6a",
				"Lisa", "864282b76c39e6748fa8b9accb2953bc89a3ec4f6c5ca1627624d6a58edd5619",
				"Maggie", "87ff2d3e9553ae41ee4733d5d6596a50453c91ac12c0e187f2827a86397a39ed"
		);

		Assert.assertEquals("864282b76c39e6748fa8b9accb2953bc89a3ec4f6c5ca1627624d6a58edd5619", unmodifableMap.get("Lisa"));
		Assert.assertEquals("eb27d253723c2e85787db841d64b1eb87ad5ea0dc6d7daf94e4edfc689d31a6a", unmodifableMap.get("Bart"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testReadOnlyMapModification()
	{
		Map<String, String> unmodifableMap = Map.of(
				"Homer", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201",
				"Marge", "18edfe67035984ee8ccb892c7def65f1302fc608f3473c339bbd7ee15ab6c5c3",
				"Bart", "eb27d253723c2e85787db841d64b1eb87ad5ea0dc6d7daf94e4edfc689d31a6a",
				"Lisa", "864282b76c39e6748fa8b9accb2953bc89a3ec4f6c5ca1627624d6a58edd5619",
				"Maggie", "87ff2d3e9553ae41ee4733d5d6596a50453c91ac12c0e187f2827a86397a39ed"
		);

		unmodifableMap.put("Burns", "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
}
