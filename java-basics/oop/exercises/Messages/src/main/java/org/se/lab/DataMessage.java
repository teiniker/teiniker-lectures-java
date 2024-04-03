package org.se.lab;

public class DataMessage
	extends Message
{
	public DataMessage(long id, String message)
	{
		setId(id);
		setMessage(message);
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
		String json = "{\"id\":\"" + id + ",\"message\":\"" + getMessage() + "\"}";
		return json;
	}
}
