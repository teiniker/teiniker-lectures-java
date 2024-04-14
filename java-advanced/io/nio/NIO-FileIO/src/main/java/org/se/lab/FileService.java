package org.se.lab;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileService
{
	public void fileCopy(String sourceFile, String destFile)
	{
		try
		{
			Path sourcePath = Paths.get(sourceFile);
			Path destPath = Paths.get(destFile);

			Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy binary file!", e);
		}
	}

	public List<String> textFileToList(String sourceFile)
	{
		Path path = Paths.get(sourceFile);

		if (!Files.exists(path))
			throw new IllegalArgumentException("File " + sourceFile + " doesn't exist!");

		try
		{
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			return lines;
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't read file!", e);
		}
	}
}
