package org.se.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FinallyTest
{
	private String readFirstLine(String path)
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		}
		catch(IOException e)
		{
			// Exception wrapping
			throw new ServiceException("Can't read from " + path, e);
		}
		finally
		{
			// Close resources
			try
			{
				if (br != null)
					br.close();
			}
			catch(IOException e)
			{
				// Log that event;
			}
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
