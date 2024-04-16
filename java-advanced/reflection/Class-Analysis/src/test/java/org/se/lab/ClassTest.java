package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class ClassTest
{
	@Test
	public void testGetClass()
	{
		User u = new User(7,"teini", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201");
		
		Class<?> c = u.getClass();
		Assert.assertEquals("org.se.lab.User", c.getName());
	}

	
	@Test
	public void testClass()
	{
		Class<User> c = User.class;		
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
	
	
	@Test
	public void testForName() throws ClassNotFoundException
	{
		Class<?> c = Class.forName("org.se.lab.User");
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}	
}

