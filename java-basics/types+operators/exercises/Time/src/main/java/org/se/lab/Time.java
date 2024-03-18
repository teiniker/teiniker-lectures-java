package org.se.lab;

public class Time
{
    // Constructors
    public Time(int hours, int minutes, int seconds)
    {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
    }

	public Time(String time)
	{
		// Split the string by "."
		String[] parts = time.split(":");

		// Convert the substrings into int values
		this.hours = Integer.parseInt(parts[0]);
		this.minutes = Integer.parseInt(parts[1]);
		this.seconds = Integer.parseInt(parts[2]);
	}

	// Read-only properties
	private final int hours;
    public int getHours()
    {
        return hours;
    }

	private final int minutes;
    public int getMinutes()
    {
        return minutes;
    }

	private final int seconds;
    public int getSeconds()
    {
        return seconds;
    }

	// Operations

	public int toSeconds()
	{
		return (hours * 3600) + (minutes * 60) + seconds;
	}

	public Time fromSeconds(long totalSeconds)
	{
		int hours = (int) (totalSeconds / 3600);
		int remainingSeconds = (int) (totalSeconds % 3600);
		int minutes = remainingSeconds / 60;
		remainingSeconds = remainingSeconds % 60;

		return new Time(hours, minutes, remainingSeconds);
	}

	// Object methods

	@Override
	public String toString()
	{
		return "Time{" +
				"hours=" + hours +
				", minutes=" + minutes +
				", seconds=" + seconds +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Time time = (Time) o;

		if (hours != time.hours) return false;
		if (minutes != time.minutes) return false;
        return seconds == time.seconds;
    }

	@Override
	public int hashCode()
	{
		int result = hours;
		result = 31 * result + minutes;
		result = 31 * result + seconds;
		return result;
	}
}
