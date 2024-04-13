package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class PrintWriterTest
{
	private int i = 7;
	private double pi = 3.14159265359;
	private String name = "Homer";

	@Test
	public void testOutPrintln()
	{
		System.out.println("Data: " + i + ", " + pi + ", \"" + name + "\"");
	}

	@Test
	public void testOutFormat()
	{
		System.out.format("Data: %03d,%4.2f,\"%s\"", i, pi, name);
	}

}
