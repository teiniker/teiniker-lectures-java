package org.se.lab;

public class IntegerSequence
{
	private static int value;

	// Static initialization block
	static
	{
		value = 0;
	}

	public static int nextValue()
	{
		return value++;
	}

	public static void resetValue()
	{
		value = 0;
	}
}
