package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class DateTest
{
	@Test
	public void testIntegerConstructor()
	{
		Date date = new Date(18, 3, 2024);

		Assert.assertEquals(18, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testStringConstructor()
	{
		Date date = new Date("18.3.2024");

		Assert.assertEquals(18, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testToString()
	{
		Date date = new Date(18, 3, 2024);

		Assert.assertEquals("Date{day=18, month=3, year=2024}", date.toString());
	}

	@Test
	public void testHashCodeAndEquals()
	{
		Date date1 = new Date(18, 3, 2024);
		Date date2 = new Date(18, 3, 2024);

		Assert.assertFalse(date1 == date2);
		Assert.assertTrue(date1.equals(date2));
		Assert.assertTrue(date2.equals(date1));

		Assert.assertTrue(date1.hashCode() ==  date2.hashCode());
	}

	@Test
	public void testIsLeapYear()
	{
		Assert.assertFalse(new Date(1, 1, 1900).isLeapYear());
		Assert.assertFalse(new Date(1, 1, 1999).isLeapYear());
		Assert.assertTrue(new Date(1, 1, 2000).isLeapYear());
		Assert.assertTrue(new Date(1, 1, 2024).isLeapYear());
	}

	@Test
	public void testIsValid()
	{
		Assert.assertTrue(new Date(19, 3, 2024).isValid());

		Assert.assertFalse(new Date(0, 2, 2024).isValid());
		Assert.assertTrue(new Date(29, 2, 2024).isValid());
		Assert.assertFalse(new Date(30, 2, 2024).isValid());

		Assert.assertFalse(new Date(1, 0, 2024).isValid());
		Assert.assertFalse(new Date(1, 13, 2024).isValid());

		Assert.assertFalse(new Date(1, 1, 0).isValid());
	}

}