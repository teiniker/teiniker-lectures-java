# Interfaces

An interface is a reference type, similar to a class, that can contain only constants, 
method signatures, default methods, static methods, and nested types. 

**Interfaces cannot contain instance fields**. 
**The methods in interfaces are abstract by default**, which means they do not have 
a body and must be implemented by classes that choose to implement the interface.

Interfaces are used to specify a set of methods that a class must implement.

Key points about interfaces in Java:

* **Abstraction**: Interfaces provide a way to **define a contract** for what a 
    class can do, without specifying how it does it. This allows you to program 
    at a higher level of abstraction, focusing on the operations your code 
    needs to perform rather than the details of how they are accomplished.

* **A class can implement multiple interfaces**:
    This is a way around the restriction that Java classes cannot inherit from 
    more than one class. It allows a class to inherit many sets of method 
    definitions from different sources.

* **Polymorphism**: Interfaces are a way to achieve polymorphism. A variable 
    of an interface type can refer to any object that implements the interface, 
    allowing different implementations to be used interchangeably, as long as 
    they fulfill the interface contract.

* **Modularity and Separation of Concerns**: Interfaces help in building highly 
    modular software. Since you code against an interface, not an implementation, 
    you can change the underlying implementation without changing the code that 
    uses the interface. This enhances the separation of concerns within a program.

* **Default Methods and Static Methods**: Interfaces can contain default methods 
    and static methods. 
    
    Default methods are methods with a body, which can be 
    inherited by classes that implement the interface without the need for an 
    explicit implementation. 
    
    Static methods belong to the interface itself rather than an instance of any 
    class that implements the interface.


## Marker Interfaces

A marker interface is an **interface with no method declarations**, effectively 
_marking_ a class that implements it as having a particular property or behavior. 

Marker interfaces are used to indicate that a class adheres to a certain contract 
or capability, even though they don't explicitly define any behavior through methods.

Examples of marker interfaces in Java:
* **Serializable Interface**: This is perhaps the most well-known marker interface 
    in Java. A class implements `Serializable` to indicate that its instances can 
    be serialized — converted into a byte stream suitable for saving to disk or 
    transmitting over a network. The serialization mechanism checks if a class 
    implements this interface and throws a `NotSerializableException` if an attempt 
    is made to serialize an object of a class that does not implement `Serializable`.

* **Cloneable Interface**: Another example is the `Cloneable` interface. It indicates 
    that an instance of the class can be cloned via the `clone()` method of `Object`. 
    If a class does not implement `Cloneable`, a call to its clone method will result 
    in a `CloneNotSupportedException`.

With the introduction of **annotations** in Java 5, many use cases for marker interfaces 
can be handled more cleanly. Annotations allow for more flexible and powerful ways to 
**attach metadata to classes, methods, and fields**. They can contain elements to store 
additional information, and their presence can be easily checked through reflection.

## References

* [Baeldung: Java Interfaces](https://www.baeldung.com/java-interfaces)
* [The Java™ Tutorials: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

*Egon Teiniker, 2024, GPL v3.0*