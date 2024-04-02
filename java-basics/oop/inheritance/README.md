# Inheritance

Inheritance is a fundamental concept in Java and many other object-oriented 
programming languages, allowing for a class to **inherit fields and methods** 
from another class. 

## Class Inheritance

This mechanism provides a powerful way to establish a relationship between the general 
**parent class** and the specific **child class**, promoting code reusability and 
establishing a hierarchical classification of classes:

* **Superclass (Parent Class)**: The class whose features are inherited. It's a more 
    general class, also referred to as the base class.

* **Subclass (Child Class)**: The class that inherits from another class. It's a more 
    specific class, also referred to as the derived class. A subclass can add its own 
    fields and methods in addition to the superclass fields and methods it inherits.

Key Features of inheritance are:
* **Code Reusability**: Inheritance supports the reuse of fields and methods, 
    thereby **reducing code duplication**. Instead of writing the same code again 
    in the subclass, you inherit it from the superclass.

* **Method Overriding**: A subclass can override methods from its superclass, 
    providing a specific implementation while maintaining the same method signature. 
    This is a cornerstone of polymorphism in Java.

Note that **constructors are not inherited**. However, the subclass constructor 
can call the superclass constructor using `super()`. This call can be used to 
initialize the superclass's fields when creating an instance of the subclass.

We can **prevent a class from being inherited** by marking it with the `final` keyword. 
If a class is declared as final, it cannot be subclassed. This is particularly useful 
when we want to make sure that the behavior defined in a class cannot be altered.


## Abstract Classes

An abstract class is used as a **base class** for other classes to inherit from but 
**is never instantiated on its own**. Its main purpose is to provide a common definition 
of a base class that multiple derived classes can share and extend.

Key characteristics of abstract classes:
* **Cannot Be Instantiated**: We cannot create an object of an abstract class directly. 
    They are meant to be subclassed by other classes.
* **Contain Abstract Methods**: An abstract class can contain abstract methods — **methods 
    without a body**. These methods are meant to be implemented by subclasses. 
    However, it's not mandatory for an abstract class to have abstract methods.
* **Can Contain Concrete Methods**: Besides abstract methods, abstract classes can 
    also have concrete methods (methods with an implementation). This allows you to 
    provide some common functionality to all subclasses while leaving the specifics 
    to be defined by the subclasses.
* **Constructor**: Abstract classes can have constructors. These constructors are called 
    when a subclass is instantiated.
* **Fields**: Abstract classes can contain fields that can be inherited by subclasses.


## Interface Inheritance


In Java, interface inheritance allows an interface to **inherit from one or more other 
interfaces**, enabling a form of multiple inheritance that classes do not directly support. 

This mechanism allows for the **creation of complex hierarchies of interfaces**, enabling 
developers to design highly flexible and modular systems.

Key characteristics of interface inheritance:

* **Multiple Inheritance**: Unlike classes, which can only extend one other class, interfaces 
    can extend multiple other interfaces. This allows a single interface to inherit the method 
    signatures from multiple sources, facilitating a rich form of polymorphism.

* **Method Signature Inheritance**: When an interface inherits from another interface, it 
    inherits all the abstract method signatures. This means that any class implementing the 
    child interface must provide implementations for all inherited abstract methods unless the 
    class itself is abstract.

* **Default and Static Methods**: Interfaces can contain default methods (methods with an 
    implementation) and static methods. When an interface inherits from another, it also 
    inherits its default methods. However, if there are conflicts (e.g., two interfaces 
    define a default method with the same signature), the implementing class must override 
    the method to resolve the conflict.


## References

* [The Java™ Tutorials: Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
* [Baeldung: Guide to Inheritance in Java](https://www.baeldung.com/java-inheritance)


*Egon Teiniker, 2024, GPL v3.0*