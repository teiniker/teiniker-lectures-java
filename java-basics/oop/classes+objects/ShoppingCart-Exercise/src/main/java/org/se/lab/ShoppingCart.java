package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
	/*
	 * Constructor
	 */
	public ShoppingCart()
	{
		setTaxrate(20); // default value
	}

	/*
	 * Property: taxrate:int
	 */
	private int taxrate;
	public int getTaxrate()
	{
		return taxrate;
	}
	public void setTaxrate(int taxrate)
	{
		if(taxrate < 0)
			throw new IllegalArgumentException("Tax rate < 0: " + taxrate);
		
		this.taxrate = taxrate;
	}


	/*
	 * Association: ----[1..*]-> products:Product
	 */
	private List<Product> products = new ArrayList<Product>();
	public void addProduct(Product p)
	{
		if(p == null)
			throw new IllegalArgumentException("Product is null!");
		
		products.add(p);
	}
	public List<Product> getProducts()
	{
		return products;
	}

	
	/*
	 * Operations
	 */

	public long calculateTotalSum()
	{
		long sum = 0;
		for(Product p : getProducts())
		{
			sum += p.getPrice();
		}
		return sum;
	}


	public long calculateTax()
	{
		long tax = calculateTotalSum() * getTaxrate() /100;
		return tax;
	}
}
