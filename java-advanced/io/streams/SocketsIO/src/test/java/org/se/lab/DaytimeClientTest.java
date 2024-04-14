package org.se.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import org.junit.Test;

public class DaytimeClientTest
{
	@Test
	public void testInputStream() throws IOException
	{
		Socket socket = new Socket("localhost", 9013);
		
		InputStream in = socket.getInputStream();
		StringBuilder message = new StringBuilder();
		int c;
		while((c=in.read()) != -1)
			message.append((char)c);
		
		System.out.println("It is : " + message);
		socket.close();
	}


	@Test
	public void testBufferedReader() throws IOException
	{
		Socket socket = new Socket("localhost", 9013);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String message = in.readLine();		
		
		System.out.println("It is : " + message);
		socket.close();
	}
}