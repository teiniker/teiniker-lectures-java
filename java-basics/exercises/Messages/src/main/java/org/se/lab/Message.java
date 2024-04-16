package org.se.lab;

public abstract class Message
{
	// Property: message:String
	private String message;
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}

	public abstract String toJson();
}
