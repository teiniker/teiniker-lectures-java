package org.se.lab;

public class Application
{
	public static void main(String[] args)
	{
		String name = null;

		if(args.length == 1)
		{
			name = args[0];
		}
		else
		{
			name = "World";
		}

		Hello hello = new Hello();
		hello.sayHelloTo(name);
	}
}
