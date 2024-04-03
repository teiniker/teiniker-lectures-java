package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TryWithResourcesTest
{
	private String readFirstLine(String path)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
		}
		catch(IOException e)
		{
			throw new ServiceException("Can't read from " + path, e);
		}
	}


	@Test
	public void testReadFirstLine()
	{
		String line = readFirstLine("Information.txt");

		Assert.assertEquals("Information for this Example:", line);
	}

	@Test(expected = ServiceException.class)
	public void testReadFirstLine_UnknownFile()
	{
		readFirstLine("README.txt");
	}
}
