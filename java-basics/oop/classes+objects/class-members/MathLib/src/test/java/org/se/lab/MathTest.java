package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class MathTest
{
	// Absolute error for comparing floating-point numbers
	private final double DELTA = 1E-6;

	@Test
	public void testAbs()
	{
		Assert.assertEquals(17, Math.abs(-17));
	}

	@Test
	public void testSqrt()
	{
		Assert.assertEquals(1.41421356, Math.sqrt(2.0), DELTA);
	}

	@Test
	public void testSin()
	{
		Assert.assertEquals(1.0, Math.sin(Math.PI/2), DELTA);
	}

	@Test
	public void testLog10()
	{
		Assert.assertEquals(3.0, Math.log10(1000), DELTA);
	}

	//...
}