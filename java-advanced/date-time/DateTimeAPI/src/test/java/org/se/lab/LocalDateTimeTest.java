package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class LocalDateTimeTest
{
	@Test
	public void testLocalDateNow()
	{
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println(datetime);

		System.out.println("Day: " + datetime.getDayOfMonth());
		System.out.println("Month: "+ datetime.getMonth().name());
		System.out.println("Year: " + datetime.getYear());
		System.out.println("Hour: " + datetime.getHour());
		System.out.println("Minute: "+ datetime.getMinute());
		System.out.println("Second: " + datetime.getSecond());
	}

	@Test
	public void testLocalDateOf()
	{
		LocalDateTime datetime = LocalDateTime.of(1912, 6, 23, 11, 23, 17);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		String datetimeString = datetime.format(formatter);

		System.out.println("Date/Time: "+ datetimeString);
		Assert.assertEquals("23.06.1912 11:23:17", datetimeString);
	}

	@Test
	public void testLocalDateParse()
	{
		LocalDateTime datetime = LocalDateTime.parse("1912-06-23T11:23:17");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		String datetimeString = datetime.format(formatter);

		System.out.println("Date: "+ datetimeString);
		Assert.assertEquals("23.06.1912 11:23:17", datetimeString);
	}

	@Test
	public void testLocalDatePlus()
	{
		LocalDateTime datetime = LocalDateTime.parse("1912-06-23T11:23:17");

		LocalDateTime later = datetime.plus(100, ChronoUnit.YEARS);

		LocalDateTime expected = LocalDateTime.parse("2012-06-23T11:23:17");
		Assert.assertTrue(later.isEqual(expected));
		Assert.assertTrue(later.isAfter(datetime));		// 2012-06-23 23:11:17 is after 1912-06-23 23:11:17
		Assert.assertTrue(datetime.isBefore(later));	// 1912-06-23 23:11:17 is before 2012-06-23 23:11:17
	}
}

