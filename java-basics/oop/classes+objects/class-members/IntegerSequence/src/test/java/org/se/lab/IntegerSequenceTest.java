package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerSequenceTest
{
	@Before
	public void setUp()
	{
		// We use resetValue() to setup the class for every test case.
		IntegerSequence.resetValue();
	}

	@Test
	public void testNextValueOnce()
	{
		Assert.assertEquals(0,IntegerSequence.nextValue());
	}

	@Test
	public void testNextValue()
	{
		Assert.assertEquals(0,IntegerSequence.nextValue());
		Assert.assertEquals(1,IntegerSequence.nextValue());
		Assert.assertEquals(2,IntegerSequence.nextValue());
	}
}