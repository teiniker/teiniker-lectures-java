# Example: Daytime - Socket Communication

A daytime service simply sends the current date and time as a character string without regard to the input.

One daytime service is defined as a connection based application on TCP.
A server listens for TCP connections on TCP port 13. 
Once a connection is established the current date and time is sent out the 
connection as an ASCII character string (and any data received is thrown away).
The service closes the connection after sending the quote.
There is no specific syntax for the daytime.


## Build and Run 

First we compile the example and then we start the `DaytimeServer` class:
``` 
$ mvn compile
$ java -cp ./target/classes org.se.lab.DaytimeServer
```

On the client side we can:

* Run the `DaytimeClientTest` in the **JUnit Test Runner**.

* Use **telnet** on the command line
    ```
    $ telnet localhost 9013
    ```

## Server Implementation

This Java program is an example of a simple server application using sockets, 
specifically tailored to act as a **daytime** server. This type of server listens 
for client connections and sends the current date and time to the client. 

```Java
	public static void main(String... args)
	{
		try(ServerSocket server = new ServerSocket(9013))
		{
			while (true)
			{
				try(Socket connection = server.accept())
				{
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
``` 

Let's break down the main components and the flow of the program:

* **ServerSocket Initialization**: The ServerSocket is created on port `9013`. 
    The try-with-resources statement ensures that the `ServerSocket` will be closed 
    automatically when it is no longer needed or if an exception occurs.

* **Infinite Loop**: The server runs an infinite loop `while(true)`, repeatedly 
    waiting for new client connections.

* **Accept Connection**: `server.accept()` blocks (waits) until a client connects. 
    Once a client connects, it returns a `Socket` object representing the connection.

* **Sending Data**: A `Writer` object is created to write data to the client via the 
    connection's output stream. The server writes the current date and time followed 
    by a carriage return and line feed `"\r\n"` to ensure compatibility with clients 
    expecting this format (like telnet).

* **Flush Output**: The `out.flush()` call ensures that the date and time data is 
    sent immediately without buffering.

* **Catch Blocks**: The code has two catch blocks for handling `IOException`:
    * Inside the loop, if there's an issue with handling the connection (like sending data), 
        it throws a new `IllegalStateException`.
    * Outside the loop, if there's an issue creating the `ServerSocket`, it throws 
        another `IllegalStateException`.


## Client Implementation

The client code provided in your example is designed to connect to a server running on 
**localhost at port 9013**, read a single line of text (presumably the date and time 
sent by the server), and then print this information to the console. 

```Java 
	@Test
	public void testBufferedReader() throws IOException
	{
		Socket socket = new Socket("localhost", 9013);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String message = in.readLine();		
		
		System.out.println("It is : " + message);
		socket.close();
	}
```

Here is a breakdown of each part of the code:

* **Socket Creation**: `new Socket("localhost", 9013)` establishes a new connection to 
    the server located at localhost on port 9013. This is the port where the `DaytimeServer` 
    is listening for incoming connections.

* **BufferedReader Initialization**: A `BufferedReader` wrapped around an `InputStreamReader` 
    that itself wraps the socket's input stream is created. This setup is used to read text 
    data efficiently from the input stream.

* **Read Data**: `in.readLine()` reads data from the input stream until it encounters a line 
    termination character `\n` or `\r\n`. This is expected to be the current date and time 
    string sent by the server.

* **Socket Closure**: Finally, `socket.close()` is called to close the network socket, 
    thereby freeing up the network resources and properly terminating the connection to the server.


## References

* [RFC 867 Daytime Protocol](https://datatracker.ietf.org/doc/html/rfc867)

*Egon Teiniker, 2024, GPL v3.0*