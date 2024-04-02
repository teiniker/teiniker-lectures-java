package org.se.lab;

public class DataOutput
{
	private final String prefix;
	public String getPrefix()
	{
		return prefix;
	}

	// Constructor Overloading
	public DataOutput()
	{
		prefix = "output> ";
	}

	public DataOutput(String prefix)
	{
		this.prefix = prefix;
	}


	// Method Overloading
	void print(int value)
	{
		System.out.println(prefix + "[int] value = " + value);
	}

	void print(double value)
	{
		System.out.println(prefix + "[double] value = " + value);
	}

	void print(String value)
	{
		System.out.println(prefix + "[String] value = " + value);
	}
}
