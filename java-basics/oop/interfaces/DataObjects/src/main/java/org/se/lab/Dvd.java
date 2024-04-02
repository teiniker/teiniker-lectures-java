package org.se.lab;

public class Dvd
	implements DataObject
{
	/*
	 * Constructor
	 */
	public Dvd(String productId, String director, String title)
	{
		this.productId = productId;
		this.director = director;
		this.title = title;
	}

	/*
	 * Property: productId:String
	 */
	private String productId;
	public String getProductId()
	{
		return productId;
	}
	public void setProductId(String productId)
	{
		this.productId = productId;
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

	/*
	 * Property: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}


	public String toCsv()
	{
		return "\"" + productId + "\"," + "\"" + director + "\",\"" + title + "\"";
	}

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return "Dvd{" +
				"productId='" + productId + '\'' +
				", director=" + director +
				", title=" + title +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Dvd dvd = (Dvd) o;

		if (!productId.equals(dvd.productId)) return false;
		if (director != null ? !director.equals(dvd.director) : dvd.director != null) return false;
        return title != null ? title.equals(dvd.title) : dvd.title == null;
    }

	@Override
	public int hashCode()
	{
		return productId.hashCode();
	}
}
