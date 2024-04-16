package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest
{
	@Test
	public void testDataMessage()
	{
		Message data = new DataMessage(7, "3.14,-2.9,34.87,99.0");

		String json = data.toJson();
		Assert.assertEquals("{\"id\":\"7,\"message\":\"3.14,-2.9,34.87,99.0\"}", json);
	}

	@Test
	public void testErrorMessage()
	{
		Message error = new ErrorMessage(-17, "Invalid Sensor!");

		String json = error.toJson();
		Assert.assertEquals("{\"error\":-17,\"message\":\"Invalid Sensor!\"}", json);
	}

	@Test
	public void testNotificationMessage()
	{
		Message notification = new NotificationMessage(666);

		String json = notification.toJson();
		Assert.assertEquals("{\"id\":666}", json);
	}
}