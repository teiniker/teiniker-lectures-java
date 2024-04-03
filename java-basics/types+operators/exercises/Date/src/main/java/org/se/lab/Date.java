package org.se.lab;

public class Date
{
    // Constructors
    public Date(int day, int month, int year)
    {
		this.day = day;
		this.month = month;
		this.year = year;
    }

	public Date(String date)
	{
		// Split the string by "."
		String[] parts = date.split("\\.");	// 18.3.2024 => ["18","3","2024"]

		// Convert the substrings into int values
		this.day = Integer.parseInt(parts[0]);
		this.month = Integer.parseInt(parts[1]);
		this.year = Integer.parseInt(parts[2]);
	}

	// Read-only properties
	private final int day;
    public int getDay()
    {
        return day;
    }

	private final int month;
    public int getMonth()
    {
        return month;
    }

	private final int year;
    public int getYear()
    {
        return year;
    }

	// Operations
	boolean isLeapYear()
	{
        return (year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0);
	}

	public boolean isValid()
	{
		if (year < 1)
		{
			return false;
		}

		if (month < 1 || month > 12)
		{
			return false;
		}

		// Adjust for leap year
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (isLeapYear() && month == 2)
		{
			daysInMonth[1] = 29;
		}
		int maxDay = daysInMonth[month - 1];
        return day >= 1 && day <= maxDay;
    }

	// Object methods

	@Override
	public String toString()
	{
		return "Date{" +
				"day=" + day +
				", month=" + month +
				", year=" + year +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Date date = (Date) o;

		if (day != date.day) return false;
		if (month != date.month) return false;
        return year == date.year;
    }

	@Override
	public int hashCode()
	{
		int result = day;
		result = 31 * result + month;
		result = 31 * result + year;
		return result;
	}
}
