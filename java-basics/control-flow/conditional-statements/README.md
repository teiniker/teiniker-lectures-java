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


## switch statements

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




## References

* [The Java™ Tutorials: Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

*Egon Teiniker, 2024, GPL v3.0*