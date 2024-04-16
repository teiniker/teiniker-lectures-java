package org.se.lab;

public class Message
{
	public Message(MessageType type)
	{
		setType(type);
	}

	// Property: type:MessageType
	private MessageType type;
	public MessageType getType()
	{
		return type;
	}
	public void setType(MessageType type)
	{
		this.type = type;
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

	// Property: errorNumber:int
	private int errorNumber;
	public int getErrorNumber()
	{
		return errorNumber;
	}
	public void setErrorNumber(int errorNumber)
	{
		this.errorNumber = errorNumber;
	}

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

	public String toJson()
	{
		String json = switch(type)
		{
			case DATA -> "{\"id\":\"" + id + ",\"message\":\"" + message + "\"}";
			case ERROR -> "{\"error\":" + errorNumber + ",\"message\":\"" + message + "\"}";
			case NOTIFICATION -> "{\"id\":" + id + "}";
		};
		return json;
	}

}
