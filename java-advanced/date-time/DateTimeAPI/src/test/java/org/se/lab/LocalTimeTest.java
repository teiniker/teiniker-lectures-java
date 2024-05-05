package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class LocalTimeTest
{
	@Test
	public void testLocalTimeNow()
	{
		LocalTime time = LocalTime.now();
		System.out.println(time);

		System.out.println("Hour: " + time.getHour());
		System.out.println("Minute: "+ time.getMinute());
		System.out.println("Second: " + time.getSecond());
	}

	@Test
	public void testLocalTimeOf()
	{
		LocalTime time = LocalTime.of(11, 23, 17);


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Assert.assertEquals("11:23:17", time.format(formatter));
	}

	@Test
	public void testLocalTimeParse()
	{
		LocalTime time = LocalTime.parse("11:23:17");

		LocalTime expected = LocalTime.of(11, 23, 17);
		Assert.assertEquals(expected, time);
	}

	@Test
	public void testLocalTimePlus()
	{
		LocalTime time = LocalTime.parse("11:23:17");

		LocalTime later = time.plus(2, ChronoUnit.HOURS);

		Assert.assertTrue(time.isBefore(later));	// 11:23:17 is before 13:23:17
		Assert.assertTrue(later.isAfter(time));		// 13:23:17 is after 11:23:17

		Assert.assertEquals(LocalTime.parse("13:23:17"), later);
	}
}
