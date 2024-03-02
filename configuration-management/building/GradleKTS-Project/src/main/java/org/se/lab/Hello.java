package org.se.lab;

public class Hello
{
    public int sayHelloTo(String name)
    {
        String msg = "Hello " + name + "!";
        int result = msg.length();
        System.out.println(msg);
        return result;
    }
}
