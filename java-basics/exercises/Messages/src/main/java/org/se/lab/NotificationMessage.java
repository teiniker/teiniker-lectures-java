package org.se.lab;

public class NotificationMessage
	extends Message
{
	public NotificationMessage(long id)
	{
		setId(id);
	}

	// Property: id:long
	private long id;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}

	public String toJson()
	{
		String json = "{\"id\":" + id + "}";
		return json;
	}
}
