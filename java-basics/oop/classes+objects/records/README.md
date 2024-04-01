# Java Records

Introduced in Java 14 as a preview feature and made stable in Java 16, records provide 
a compact syntax for declaring classes that are meant to be simple **data carriers** — 
immutable classes whose main purpose is to encapsulate data. 
Records **reduce the boilerplate code** that is typically associated with such classes.

The key characteristics of records are:
* **Immutable by Default**: The fields of a record are `final`, meaning that their 
    values are assigned once upon creation of the record instance and cannot be changed 
    later. This immutability aligns with the principle of designing immutable data 
    structures that are thread-safe and less prone to errors.

* **Concise Syntax**: Records automatically generate a public constructor, the 
    `equals()`, `hashCode()`, and `toString()` methods, and public getters for 
    accessing the fields, significantly reducing boilerplate code.

* **Not Intended for Extensibility**: Records cannot be abstract, and they cannot 
    extend other classes. They are implicitly final. 
    However, a record can implement interfaces.

Records are ideal for creating simple classes that serve primarily as data carriers 
without the need for modification of their state. 

They are particularly useful for:
* Data Transfer Objects (DTOs)
* Value objects in domain-driven design
* Messages in systems (e.g., events, requests, responses)

By automatically providing essential components and enforcing immutability, records help 
developers focus on the domain logic rather than boilerplate code, leading to clearer, 
more maintainable programs.


## References
* [Baeldung: Java 14 Record Keyword](https://www.baeldung.com/java-record-keyword)
* [Java Language Updates: Record Classes](https://docs.oracle.com/en/java/javase/17/language/records.html)


*Egon Teiniker, 2024, GPL v3.0*
