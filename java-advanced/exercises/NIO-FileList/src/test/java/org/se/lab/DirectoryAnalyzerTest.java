package org.se.lab;

import java.nio.file.Path;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectoryAnalyzerTest
{
	private DirectoryAnalyzer analyzer;

	@Before
	public void setUp()
	{
		analyzer = new DirectoryAnalyzer();
	}

	@Test
	public void testTextFileToList()
	{
		List<Path> listOfFiles = analyzer.getListOfFiles("./data");
		Assert.assertEquals(3, listOfFiles.size());

		List<String> list = analyzer.generateFileList(listOfFiles);
		Assert.assertEquals("File: logo.png - Size: 16703 bytes", list.get(0));
		Assert.assertEquals("Directory: tmp - Size: 0 bytes", list.get(1));
		Assert.assertEquals("File: song.txt - Size: 2240 bytes", list.get(2));
	}
}
