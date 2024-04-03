package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class MultipleCatchTest
{
	private Connection getConnection(String propertyFileName)
	{
		final String driver;
		final String url;
		final String user;
		final String password;  
	    
    	Properties jdbcProperties = new Properties();
		try
		{
			jdbcProperties.load(new FileInputStream(new File("src/test/resources", propertyFileName)));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			user = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password"); 
			
			Class.forName(driver);
	        Connection con = DriverManager.getConnection(url, user, password);
	        return con;
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			throw new ServiceException("Can't connect to the database", e);
		}
	}

	
	@Test(expected = ServiceException.class)
	public void testReadFirstLineFinally()
	{
		getConnection("jdbc.properties");
	}
}
