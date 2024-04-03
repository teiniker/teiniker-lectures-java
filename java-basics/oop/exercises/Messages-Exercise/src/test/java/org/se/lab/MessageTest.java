package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest
{
	@Test
	public void testDataMessage()
	{
		Message data = new Message(MessageType.DATA);
		data.setId(7);
		data.setMessage("3.14,-2.9,34.87,99.0");

		String json = data.toJson();
		Assert.assertEquals("{\"id\":\"7,\"message\":\"3.14,-2.9,34.87,99.0\"}", json);
	}

	@Test
	public void testErrorMessage()
	{
		Message error = new Message(MessageType.ERROR);
		error.setErrorNumber(-17);
		error.setMessage("Invalid Sensor!");

		String json = error.toJson();
		Assert.assertEquals("{\"error\":-17,\"message\":\"Invalid Sensor!\"}", json);
	}

	@Test
	public void testNotificationMessage()
	{
		Message notification = new Message(MessageType.NOTIFICATION);
		notification.setId(666);

		String json = notification.toJson();
		Assert.assertEquals("{\"id\":666}", json);
	}
}