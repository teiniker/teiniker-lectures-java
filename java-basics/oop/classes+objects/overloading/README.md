# Overloading 


## Method Overloading

Method overloading is a feature in Java that allows a class to have 
**more than one method with the same name, provided that each method has a different 
parameter list** 
(i.e., the number of parameters, the type of parameters, or both, must differ). 

This concept is a cornerstone of polymorphism in Java, enabling developers to write 
more readable and maintainable code by allowing methods to handle different types 
of data or operations through the same method name but with different parameters.

The Java compiler distinguishes between overloaded methods based on their 
**method signatures**. A method signature includes the method name and the 
parameter list (types, order, and number of parameters). 
**The return type of the method is not considered part of the method signature 
for the purpose of overloading**.

When a method is called, the Java compiler looks at the method name and the passed 
argument(s) to determine which version of the overloaded method should be executed. 
This decision is made at compile time, making method overloading a static form of 
polymorphism.

Method overloading enhances the functionality and flexibility of methods in Java, 
making it easier to handle different data types and operations with a unified interface.


## Constructor Overloading

Constructor overloading in Java is a concept that allows a class to have **more than 
one constructor, each having different parameter lists**. 

Similar to method overloading, constructor overloading enables the creation of objects 
in different states depending on the arguments passed to the constructors. This provides 
flexibility and improves code readability by allowing multiple ways to initialize an 
object's state.

The Java compiler differentiates between the overloaded constructors based on the 
number of parameters and their types (i.e., the constructor signature). When a new 
object is created, the compiler selects the appropriate constructor to call based 
on the arguments provided.

Constructor overloading is a powerful feature for defining multiple ways to initialize 
objects, making classes more flexible and easier to use correctly.


## References

* [Baeldung: Method Overloading and Overriding in Java](https://www.baeldung.com/java-method-overload-override)

*Egon Teiniker, 2024, GPL v3.0*
