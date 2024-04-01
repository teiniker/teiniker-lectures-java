# Classes

The class defines what attributes and behaviors are possible, while the object represents 
specific instances with actual values and states.


## Building Blocks of Classes

Classes are fundamental to Java's object-oriented programming (OOP) model, 
allowing developers to create and manage new types of objects that can 
encapsulate both data and behaviors.

The building blocks of a Java class can be described as follows:

* **Fields (or Variables)**: Fields represent the state of an object. They are used 
    to store data values for the object. Fields can be of any data type, including 
    primitives (like int, double, etc.), strings, or other objects.

* **Methods**: Methods define the behavior of an object. They are blocks of code that 
    perform operations or actions, possibly using the object's fields or returning a 
    value. Methods can accept parameters and can also return a value.

* **Constructors**: Constructors are special types of methods used to initialize new 
    objects. They are called when an instance of a class is created. Constructors have 
    the same name as the class and do not have a return type.

* **Class Members**: This includes static methods and static variables. Static members 
    belong to the class rather than any instance of the class. Static variables are 
    shared among all instances of the class, and static methods can be called without 
    creating an instance of the class.

* **Blocks**: Blocks are used to initialize objects. There are two types of blocks in Java:
    * **Static blocks**: Used for static initializations of a class. It runs only once 
        when the class is loaded into memory.
    * **Instance blocks**: Runs each time a new instance of the class is created. It is 
        used for initializing instance variables.

* **Nested Classes**: Classes can contain other classes, known as nested classes, 
    which can be static or non-static. Interfaces can also be nested within classes. 
    Nested classes are used to logically group classes that are only used in one place, to 
    increase the use of encapsulation, or to create more readable and maintainable code.

These elements work together to define the properties, behaviors, and initial state of objects 
created from the class. 


## Acces Control 

Access control in Java is defined through the use of access modifiers, which 
**determine the visibility of classes, fields, methods, and constructors** to other 
parts of our code. 

There are four **access modifiers**:

* **public**: The member is accessible from any other class. 
    For classes, this means they can be accessed from any other class. 
    For fields, methods, and constructors, it means they can be accessed from any 
    class, whether in the same package or not.

* **protected**: The member is accessible within its own package (like package-private) 
    and also by subclasses of its class in other packages. 
    This is less restrictive than package-private but more restrictive than public.

* **package-private**: When no access modifier is specified, it defaults to package-private. 
    This means the member is accessible only within its own package. 
    This applies to classes, fields, methods, and constructors.

* **private**: The member is accessible only within its own class. It's the most 
    restrictive access level and is used to encapsulate the internals of the class.

**Classes** can only be public or default (package-private), which means they can be 
    public to all or restricted to the same package, respectively.

All four access modifiers can be applied to **class members**. 

Access control is a fundamental aspect of Java's object-oriented design, allowing for 
encapsulation by restricting access to certain parts of a class. 
**Encapsulation is a core principle of object-oriented programming** that helps in maintaining 
the integrity of the data within an object and protects it from unwanted access and modification 
from outside code.


## Examples

_Example:_ [Book: Constructor, properties, methods](Book/)


## References
* [The Java™ Tutorials: Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)

*Egon Teiniker, 2024, GPL v3.0*
