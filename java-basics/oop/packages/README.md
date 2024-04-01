# Packages

> A **package** is a grouping of related types providing access protection 
> and name space management. Note that types refers to classes, interfaces, 
> enumerations, and annotation types. Enumerations and annotation types are 
> special kinds of classes and interfaces, respectively, so types are often 
> referred to in this lesson simply as classes and interfaces.

* **Organization**: Packages help in organizing your code logically. we can 
    group related classes and interfaces together. This makes your code easier 
    to manage and use by others (or by you in the future).

* **Access Control**: Packages enable us to define access levels for classes 
    and class members (methods and variables) using access modifiers (public, 
    protected, and default/no modifier). This helps in encapsulating your code 
    and making it more secure.

* **Name Space Management**: By using packages, we can create classes with names 
    that might be common but are in different packages, thus avoiding name 
    conflicts. For example, we might have a `Date` class in a package named 
    `org.se.lab` and another `Date` class in `java.util` without 
    any conflict.

The types that are part of the Java platform are members of various packages 
that bundle classes by function: fundamental classes are in **java.lang**, 
classes for reading and writing (input and output) are in **java.io**, and so on. 
We can put our types in packages too.


## Creating a Package

To **create a package** in Java, we use the `package` keyword at the beginning 
of our Java source file. Every class declared in this file will belong to the 
specified package.

_Example:_ Create a package
```Java
package org.se.lab;
```

It's a common practice to use your domain name, in reverse, as the base of our 
package name to ensure uniqueness across projects worldwide.


## Importing a Package

To **use a class or a type from another package**, we need to import it into 
our Java file. We can do this using the `import` statement. We can import a 
single class or all classes within a package.

_Example:_ Importing a single class
```Java
import java.util.ArrayList;
```

_Example:_ Importing all classes in a package
```Java
import java.util.*;
```

## Package Visibility
The visibility of classes, interfaces, and members within packages is controlled 
by **access modifiers**:

* **Public**: The class or member is accessible from any other class.
* **Package Private (No Modifier)**: The class or member is accessible only within its 
    own package.



## Standard Packages

The Java Development Kit (JDK) comes with a wide range of standard packages 
that provide essential functionalities for various aspects of programming. 

* **java.lang**: This package is automatically imported into all Java programs 
    and contains classes that are fundamental to the design of the Java programming language.
    
    Key Classes: `String`, `Object`, `System`, `Thread`, `Math`, `Exception`, and wrapper classes like `Integer`, `Character`, and `Double`.

* **java.util**: Contains collections framework, legacy collection classes, 
    event model, date and time facilities, and miscellaneous utility classes.    

    Key Classes: `ArrayList`, `HashMap`, `HashSet`, `Scanner`, `Date`, `Calendar`, 
        `TimeZone`.

* **java.math**: Provides classes for performing arbitrary-precision integer arithmetic 
    (`BigInteger`) and arbitrary-precision decimal arithmetic (`BigDecimal`).

* **java.io**: Provides classes and interfaces for system input and output through data 
    streams, serialization, and the file system.

    Key Classes: `File`, `InputStream`, `OutputStream`, `FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter`.

* **java.nio**: Offers a more comprehensive set of I/O classes for high-speed, 
    non-blocking I/O operations. It stands for New I/O.

    Key Components: Buffers (`ByteBuffer`, `CharBuffer`, etc.), Channels, Selectors, 
    and character set encoders and decoders.

* **java.net**: Contains classes and interfaces for networking operations such as working 
    with sockets, URLs, and implementing networking protocols.

    Key Classes: `URL`, `URLConnection`, `HttpURLConnection`, `Socket`, `ServerSocket`.

* **java.sql**: Includes classes and interfaces for accessing and processing data 
    stored in a database.

    Key Interfaces: `Connection`, `Statement`, `ResultSet`, `DriverManager`.

* **java.security**: Contains classes and interfaces for the security framework. 
    This includes implementations for public key infrastructure (PKI), message digests, 
    digital signatures, and security providers.

## References

* [The Java™ Tutorials: Creating and Using Packages](https://docs.oracle.com/javase/tutorial/java/package/packages.html)


*Egon Teiniker, 2024, GPL v3.0*
