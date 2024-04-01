# Class Members 

Class (static) members refer to the fields and methods that belong to a class. 

Class members are essential components of Java classes, allowing us to encapsulate 
data and functionality within a single unit. 

* **Static Fields**: Also known as class variables, these are shared among all 
    instances of a class. They are declared with the `static` keyword and are 
    initialized when the class is loaded.

    Static fields are used to represent properties that are common to all objects 
    of that class. 

* **Static Methods**: These methods also belong to the class rather than any specific 
    instance. They can be called without creating an instance of the class. 
    
    Static methods can access other static fields and static methods directly but 
    cannot access instance members directly because they do not operate on an 
    instance of the class.

* **Constants**: The `static` modifier, in combination with the `final` modifier, 
    is also used to define constants. The `final` modifier indicates that 
    **the value of this field cannot change**.

* **Static Initialization Blocks**: In addition to fields and methods, classes can include 
    initialization blocks, which are **blocks of code that run when the class is 
    loaded**.

_Example_: [IntegerSequence: Using static fields, methods and initialization block](IntegerSequence/)

_Example_: [HelloApplication: Using a static main() method](HelloApplication/)

_Example_: [MathLib: Using a utility class from the standard library](MathLib/)


## References

* [The Java™ Tutorials: Understanding Class Members](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

*Egon Teiniker, 2024, GPL v3.0*