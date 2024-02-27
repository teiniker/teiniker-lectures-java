import org.junit.Test;
import org.se.lab.Hello;

import static org.junit.Assert.assertEquals;

public class HelloTest
{
    @Test
    public void testSayHelloTo()
    {
        Hello hello = new Hello();
        int length = hello.sayHelloTo("Homer");
        assertEquals(12, length);
    }
}
