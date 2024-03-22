# Conditional Statements 

Conditional statements are used to perform different actions based on 
different conditions. These statements allow your program to **make decisions** 
and execute certain parts of code based on whether a condition is true or false. 

Conditional statements are a fundamental part of Java programming, allowing 
for dynamic behavior based on different conditions within a program.


## if-then-else Statements

The **if statement** is the simplest form of control flow statement. 
It **evaluates a boolean expression** and executes the block of code inside it 
if the expression is true.

_Example:_ `if` statement
```Java
if (condition) 
{
    // block of code to be executed if the condition is true
}
```

The **if-else statement** provides a secondary path of execution when an `if` 
condition evaluates to false.

_Example:_ `if-else` statement
```Java
if (condition) 
{
    // block of code to be executed if the condition is true
} 
else 
{
    // block of code to be executed if the condition is false
}
```

An **else-if ladder** is used to specify **multiple conditions**. 
It executes one block of code among multiple blocks, depending on the 
condition that is true first in the sequence.

_Example:_ `else-if` statement
```Java
if (condition1) 
{
    // block of code to be executed if condition1 is true
} 
else if (condition2) 
{
    // block of code to be executed if condition2 is true
} 
else 
{
    // block of code to be executed if all the conditions are false
}
```


## Switch Statements

The switch statement allows a variable to be tested for **equality against a list 
of values**. Each value is called a case, and the variable being switched on is 
checked for each case.

_Example:_ `switch` statement
```Java
switch(expression) 
{
    case value1:
        // code block
        break; // optional
    case value2:
        // code block
        break; // optional
    // You can have any number of case statements.
    default: // Optional
        // code block
}
```

* **expression**: This is the value that is compared with the values of each case.
* **case**: This represents a value that the expression can be equal to.
* **break**: If present, it breaks out of the switch block. 
    This will stop the execution of more code and case testing within the block. 
    If break is omitted, the execution will continue into the next case.
* **default**: The default block is optional and executes if none of the cases are true.


**A switch statement works only with four primitives and their wrappers as well as with 
the enum type and the String class**:
* byte and Byte
* short and Short
* int and Integer
* char and Character
* enum
* String


## Switch Expressions

Switch expressions (since Java 14) marked a significant change in how switch statements can be used in Java, 
introducing several new features:

* **Expression-Based**: Unlike traditional `switch` statements that execute a block of statements, 
    `switch` expressions **return a value**. This makes it possible to use a `switch` expression on 
    the right-hand side of an assignment statement.

* **Arrow Labels (->)**: Introduced a new syntax for case labels using the arrow token (->). 
    This syntax **eliminates the need for break statements** to prevent fall-through.

* **Yield Statement**: For switch blocks that use the traditional colon (:) syntax, the yield statement 
    is used to return a value from a block of code.

_Example:_ Switch expression
```Java
String dayType = switch(day) 
{
    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
    case SATURDAY, SUNDAY -> "Weekend";
};
```

## Pattern Matching for Switch
 
Pattern matching (Java 21) for `switch` extends the `switch` expression to **allow for type patterns in case labels**, 
making it easier to conditionally execute blocks of code based on the type of an expression. 

**Type Patterns** allow `switch` to test the type of an expression against a range of types, 
and automatically casts the switch argument to that type within the case block.

_Example:_ Pattern matching in a switch expression
```Java
Object obj = // ...
String formatted = switch(obj) 
{
    case Integer i -> String.format("int %d", i);
    case Long l    -> String.format("long %d", l);
    case Double d  -> String.format("double %f", d);
    case String s  -> String.format("String %s", s);
    default        -> obj.toString();
};
```

## References

* [The Java™ Tutorials: Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

* [Baeldung: Java Switch Statement](https://www.baeldung.com/java-switch)
* [Pattern Matching for Switch](https://www.baeldung.com/java-switch-pattern-matching)

*Egon Teiniker, 2024, GPL v3.0*