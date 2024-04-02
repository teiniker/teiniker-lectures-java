package org.se.lab;

public class Dvd
	extends DataEntity
{
	/*
	 * Constructor
	 */
	public Dvd(String productId, String director, String title)
	{
		super(productId, title);
		this.director = director;
	}

	/*
	 * Property: director:String
	 */
	private String director;
	public String getDirector()
	{
		return director;
	}
	public void setDirector(String director)
	{
		this.director = director;
	}

	public String toCsv()
	{
		return "\"" + getId() + "\"," + "\"" + director + "\",\"" + getTitle() + "\"";
	}

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return "Dvd{" +
				"productId='" + getId() + '\'' +
				", director=" + director +
				", title=" + getTitle() +
				'}';
	}
}
