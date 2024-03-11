package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

public class StringTest
{
	@Test
	public void testStringConcatenation()
	{
		int i = 7;
		String s = "i" + "=" + i;

		assertEquals("i=7", s);
	}

	@Test
	public void testStringConcatenationUsingStringBuilder()
	{
		int i = 7;
		StringBuilder s = new StringBuilder();
		s.append("i");
		s.append("=").append(i);

		assertEquals("i=7", s.toString());
	}

	// Some comment

	@Test
	public void testStringValueOf()
	{
		double pi = 3.1415;
		String s = String.valueOf(pi);

		assertEquals("3.1415", s);
	}


	@Test
	public void testStringFormat()
	{
		String s = String.format(Locale.US, "PI = %3.2f", Math.PI);
		assertEquals("PI = 3.14", s);
	}


	@Test
	public void testStringTrim()
	{
		String input = "    3.1415   ";

		// Note that we get a new String object from trim()
		String pi = input.trim();
		assertEquals("3.1415", pi);
	}
}
