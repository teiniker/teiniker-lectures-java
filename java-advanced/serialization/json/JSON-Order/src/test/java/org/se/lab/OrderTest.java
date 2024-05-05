package org.se.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
	private ObjectMapper mapper;

	@Before
	public void setup() 
	{
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
		
	@Test
	public void testOrderToJsonString() throws IOException
	{
	    Order order = new Order(100, "001-20151020-007");
	    order.getLines().add(new OrderLine(101, 2, new Product(102, "Effective Java", 3336)));
	    order.getLines().add(new OrderLine(101, 2, new Product(103, "Design Patterns", 5280)));

		String jsonString = mapper.writeValueAsString(order);
		System.out.println(jsonString);
	}

	@Test
	public void testOrderToJsonFile() throws IOException
	{
		Order order = new Order(100, "001-20151020-007");
		order.getLines().add(new OrderLine(101, 2, new Product(102, "Effective Java", 3336)));
		order.getLines().add(new OrderLine(101, 2, new Product(103, "Design Patterns", 5280)));

		mapper.writeValue(new File("order.json"), order);
	}


	@Test
	public void testOrderFromJsonString() throws IOException
	{
		String jsonString = 
		"""
		{
		"id" : 100,
		"name" : "001-20151020-007",
		"lines" : 
		[ 
			{
				"id" : 101,
				"quantity" : 2,
				"product" : 
				{
					"id" : 102,
					"description" : "Effective Java",
					"price" : 3336
				}
			}, 
			{
				"id" : 101,
				"quantity" : 2,
				"product" : 
				{
					"id" : 103,
					"description" : "Design Patterns",
					"price" : 5280
				}
			} 
		]
		}	
		""";
		Order order = mapper.readValue(jsonString, Order.class);

		Assert.assertEquals(100, order.getId());
		Assert.assertEquals("001-20151020-007", order.getName());
		Assert.assertEquals(2, order.getLines().size());
		Assert.assertEquals(101, order.getLines().get(0).getId());
		Assert.assertEquals(102, order.getLines().get(0).getProduct().getId());
	}

	@Test
	public void testOrderFromJsonFile() throws IOException
	{
		Order order = mapper.readValue(new File("src/test/resources/json/order.json"), Order.class);

		Assert.assertEquals(100, order.getId());
		Assert.assertEquals("001-20151020-007", order.getName());
		Assert.assertEquals(2, order.getLines().size());
		Assert.assertEquals(101, order.getLines().get(0).getId());
		Assert.assertEquals(102, order.getLines().get(0).getProduct().getId());
	}
}