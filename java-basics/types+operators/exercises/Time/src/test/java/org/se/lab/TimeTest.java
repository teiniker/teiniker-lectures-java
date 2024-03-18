package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class TimeTest
{
	@Test
	public void testIntegerConstructor()
	{
		Time time = new Time(20, 30, 0);

		Assert.assertEquals(20, time.getHours());
		Assert.assertEquals(30, time.getMinutes());
		Assert.assertEquals(0, time.getSeconds());
	}

	@Test
	public void testStringConstructor()
	{
		Time time = new Time("20:30:00");

		Assert.assertEquals(20, time.getHours());
		Assert.assertEquals(30, time.getMinutes());
		Assert.assertEquals(0, time.getSeconds());
	}

	@Test
	public void testToString()
	{
		Time time = new Time(20, 30, 0);

		Assert.assertEquals("Time{hours=20, minutes=30, seconds=0}", time.toString());
	}

	@Test
	public void testHashCodeAndEquals()
	{
		Time time1 = new Time(20, 30, 0);
		Time time2 = new Time(20, 30, 0);

        Assert.assertNotSame(time1, time2);
        Assert.assertEquals(time1, time2);
        Assert.assertEquals(time2, time1);

        Assert.assertEquals(time1.hashCode(), time2.hashCode());
	}

	@Test
	public void testToSeconds()
	{
		Time time = new Time(20, 30, 0);

		Assert.assertEquals(73800, time.toSeconds());
	}

	@Test
	public void testFromSeconds()
	{
		Time time1 = new Time(20, 30, 0);
		Time time2 = time1.fromSeconds(73800);

        Assert.assertEquals(time1, time2);
	}
}