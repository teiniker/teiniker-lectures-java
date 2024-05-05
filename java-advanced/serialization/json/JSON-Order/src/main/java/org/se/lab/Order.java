package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Order
	extends Entity
{
	/*
	 * Constructor
	 */
    protected Order()
    {      
    }
    
	public Order(long id, String name)
	{
		setId(id);
		setName(name);
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}
	
	/*
	 * Association: ---[*]-> OrderLines
	 */
	private List<OrderLine> lines = new ArrayList<>();
    public List<OrderLine> getLines()
    {
        return lines;
    }
    public void setLines(List<OrderLine> lines)
    {
        if(lines == null)
            throw new IllegalArgumentException();
        this.lines = lines;
    }	
}
