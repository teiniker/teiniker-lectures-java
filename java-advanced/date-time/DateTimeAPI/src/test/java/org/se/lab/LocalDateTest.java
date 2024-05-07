package org.se.lab;

import java.time.LocalDate;
import java.time.Month;


import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.junit.Assert;


public class LocalDateTest
{
	@Test
	public void testLocalDateNow()
	{
		LocalDate date = LocalDate.now();
		System.out.println(date);

		System.out.println("Day: " + date.getDayOfMonth());
		System.out.println("Month: "+ date.getMonth().name());
		System.out.println("Year: " + date.getYear());
	}

	@Test
	public void testLocalDateOf()
	{
		LocalDate date = LocalDate.of(1912, 6, 23);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String dateString = date.format(formatter);

		System.out.println("Date: "+ dateString);
		Assert.assertEquals("23.06.1912", dateString);
	}

	@Test
	public void testLocalDateParse()
	{
		LocalDate date = LocalDate.parse("1912-06-23");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String dateString = date.format(formatter);

		System.out.println("Date: "+ dateString);
		Assert.assertEquals("23.06.1912", dateString);
	}

	@Test
	public void testLocalDatePlus()
	{
		LocalDate date = LocalDate.parse("1912-06-23");

		LocalDate later = date.plus(100, ChronoUnit.YEARS);

		LocalDate expected = LocalDate.parse("2012-06-23");
		Assert.assertTrue(later.isEqual(expected));
		Assert.assertTrue(later.isAfter(date));		// 2012-06-23 is after 1912-06-23
		Assert.assertTrue(date.isBefore(later));	// 1912-06-23 is before 2012-06-23
	}

	@Test
	public void testLocalDateLeapYear()
	{
		LocalDate date = LocalDate.parse("2024-05-05");

		Assert.assertTrue(date.isLeapYear());
		Assert.assertFalse(date.plusYears(1).isLeapYear());
		Assert.assertFalse(date.minusYears(1).isLeapYear());
	}
}
