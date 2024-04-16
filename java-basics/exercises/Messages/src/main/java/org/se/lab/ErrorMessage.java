package org.se.lab;

public class ErrorMessage
	extends Message
{
	public ErrorMessage(int errorNumber, String message)
	{
		setErrorNumber(errorNumber);
		setMessage(message);
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

	public String toJson()
	{
		String json = "{\"error\":" + errorNumber + ",\"message\":\"" + getMessage() + "\"}";
		return json;
	}
}
