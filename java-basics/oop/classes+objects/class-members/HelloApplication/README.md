# The main() Method

The `main` method in Java is the **entry point of any standalone Java application**. 

It is the method that is first executed when a Java program is run. The signature of 
the main method has a specific format, making it possible for the Java runtime environment 
to recognize it as the starting point of the program.

```Java
    public static void main(String[] args)
    {
        //...
    }
```

* `public`: `main()` must be declared as `public`. This is because the `main()` method 
    must be accessible by the Java runtime environment from outside the class to serve 
    as the entry point of the application.
* `static`: `main()` must be `static`, meaning it can be called without creating an
    instance of the class. This is necessary because the `main()` method is called 
    by the Java Virtual Machine (JVM) before any objects are made, and it does not 
    operate on individual objects.
* `void`: `main()` does not return any value, hence it is declared with a void return type.

* `String[] args`: The `main()` method takes a single argument: an array of strings. 
    This array contains the **command-line arguments passed to the program** when it is 
    executed. Each element in the array args is a string representing a command-line argument.


After compiling, we can run the program using the `java` command and pass a command-line 
argument to it:

```
$ mvn compile

$ java -cp target/classes/ org.se.lab.Application Egon
```

The main method is crucial for the execution of standalone Java applications and serves 
as the foundation from which the JVM starts program execution:

* While a Java class can have multiple methods, the `main()` method is unique in 
    its role as the entry point for the application.

* It's possible for a Java program to contain multiple classes each with a `main()`
    method. However, when executing the program, we specify the class whose `main()` 
    method should be invoked.    

## References

* [Baeldung: Java main() Method Explained](https://www.baeldung.com/java-main-method)

*Egon Teiniker, 2024, GPL v3.0*