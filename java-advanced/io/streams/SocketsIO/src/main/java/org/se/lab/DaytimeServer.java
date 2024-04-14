package org.se.lab;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer
{
	public static void main(String... args)
	{
		System.out.print("Starting server..");

		try(ServerSocket server = new ServerSocket(9013))
		{
			System.out.println("..done");
			while (true)
			{
				try(Socket connection = server.accept())
				{
					System.out.println(connection);
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
				} 
				catch (IOException e)
				{
					throw new IllegalStateException("Can't establish a socket connection!", e);
				} 
			}
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Can't create a socket!", e);
		}
	}
}
