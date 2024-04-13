package org.se.lab;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileServiceTest
{
	private FileService service;

	@Before
	public void setUp()
	{
		service = new FileService();
	}

	@Test
	public void testBinaryFileCopy()
	{
		service.binaryFileCopy("logo.png", "copy.png");
	}

	@Test
	public void testTextFileCopy()
	{
		service.textFileCopy("song.txt", "copy.txt");
	}

	@Test
	public void testTextFileCopyLineByLine()
	{
		service.textFileCopyLineByLine("song.txt", "copy.txt");
	}
}
