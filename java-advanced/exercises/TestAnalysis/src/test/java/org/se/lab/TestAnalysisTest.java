package org.se.lab;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class TestAnalysisTest
{
	private TestClassAlaysis analysis;

	@Before
	public void setUp()
	{
		analysis = new TestClassAlaysis(this.getClass());
	}

	@Test
	public void testHasBefore()
	{
		Assert.assertTrue(analysis.hasBefore());
	}

	@Test
	public void testHasAfter()
	{
		Assert.assertFalse(analysis.hasAfter());
	}

	@Test
	public void testHasTest()
	{
		Assert.assertTrue(analysis.hasTest());
	}

	@Test
	public void testGetTestMethods()
	{
		List<String> tests = analysis.getTestMethods();
		System.out.println(tests);
		Assert.assertEquals(4, tests.size());
	}
}
