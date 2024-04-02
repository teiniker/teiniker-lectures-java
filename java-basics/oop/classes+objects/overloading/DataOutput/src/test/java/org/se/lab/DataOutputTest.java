package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataOutputTest
{
	@Test
	public void testConstructor()
	{
		DataOutput out = new DataOutput("data> ");
		Assert.assertEquals("data> ", out.getPrefix());
	}

	@Test
	public void testDefaultConstructor()
	{
		DataOutput out = new DataOutput();
		Assert.assertEquals("output> ", out.getPrefix());
	}

	@Test
	public void testPrintMethods()
	{
		DataOutput out = new DataOutput();

		// The compiler uses the right implementation of the overloaded methods.
		out.print(7);
		out.print(3.1415);
		out.print("Hello World!!");
	}
}