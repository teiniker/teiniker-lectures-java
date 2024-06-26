package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerStackTest
{
	private Stack<Integer> stack;

	@Before
	public void setup()
	{
		stack = new StackImpl<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		
	}
	
	@Test
	public void testSize()
	{
		int size = stack.size();
		
		Assert.assertEquals(4, size);
	}

	@Test
	public void testTop()
	{
		Integer value = stack.top();
		Assert.assertEquals(Integer.valueOf(4), value);
	}

	@Test
	public void testPop()
	{
		Assert.assertEquals(Integer.valueOf(4), stack.pop());
		Assert.assertEquals(Integer.valueOf(3), stack.pop());
		Assert.assertEquals(Integer.valueOf(2), stack.pop());
		Assert.assertEquals(Integer.valueOf(1), stack.pop());
		
		Assert.assertEquals(0, stack.size());
		Assert.assertTrue(stack.isEmpty());
		Assert.assertNull(stack.pop());
	}
}
