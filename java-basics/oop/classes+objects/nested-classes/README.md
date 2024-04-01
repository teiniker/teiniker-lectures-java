# Nested-Classes

 The concept of nested classes allows **a class to be defined within another class**. 
 
 A nested class is a member of its enclosing class and can be classified mainly into 
 two types:  

* **Static Nested Classes**: A static nested class is declared `static` and cannot 
    access the instance variables of the outer class directly. It interacts with 
    them through objects. Static nested classes are used when the nested class 
    doesn't need to reference an instance of the outer class.

* **Inner Classes**: An inner class is a non-static nested class. It has access 
    to the fields and methods of the enclosing class. 
 
 Nested classes are used for **logically grouping classes** that are only used in 
 one place, increasing the use of encapsulation, and creating more readable and 
 maintainable code.

## References
* [The Java™ Tutorials: Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
* [Baeldung: Nested Classes in Java](https://www.baeldung.com/java-nested-classes)

*Egon Teiniker, 2024, GPL v3.0*
