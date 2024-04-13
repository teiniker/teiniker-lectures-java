package org.se.lab;

import java.io.*;

public class FileService
{
	public void binaryFileCopy(String sourceFile, String destFile)
	{
		try (FileInputStream in = new FileInputStream(sourceFile);
			 FileOutputStream out = new FileOutputStream(destFile))
		{
			int c;
			while ((c = in.read()) != -1)
			{
				out.write(c);
			}
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy binary file!",e);
		}
	}

	public void textFileCopy(String sourceFile, String destFile)
	{
		try (FileReader in = new FileReader(sourceFile);
			 FileWriter out = new FileWriter(destFile))
		{
			int c;
			while ((c = in.read()) != -1)
			{
				out.write(c);
			}
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy text file!",e);
		}
	}

	public void textFileCopyLineByLine(String sourceFile, String destFile)
	{
		try (BufferedReader in = new BufferedReader(new FileReader(sourceFile));
			 PrintWriter  out = new PrintWriter(new FileWriter(destFile)))
		{
			String line;
			while ((line = in.readLine()) != null)
			{
				out.println(line);
			}
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy text file!",e);
		}
	}
}
