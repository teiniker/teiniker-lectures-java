package org.se.lab;

import java.lang.reflect.Field;
import java.util.List;

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
		service.fileCopy("logo.png", "copy.png");
	}

	@Test
	public void testTextFileCopy()
	{
		service.fileCopy("song.txt", "copy.txt");
	}

	@Test
	public void testTextFileToList()
	{
		List<String> list = service.textFileToList("song.txt");

		Assert.assertEquals(75, list.size());
	}
}
