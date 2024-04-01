# Math Class

The class `Math` contains methods for performing basic numeric operations such as the 
elementary exponential, logarithm, square root, and trigonometric functions.

```Java
public final class Math 
{
    private Math() {}

    public static final double E = 2.7182818284590452354;
    public static final double PI = 3.14159265358979323846;
    // ...

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }
    //...
}
```

The Java `Math` class is an example of a utility class that **only has static members**.

To prevent instantiation, the **constructor is set to private**.


## References

* [Java API: java.lang.Math](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/lang/Math.html)

*Egon Teiniker, 2024, GPL v3.0*


