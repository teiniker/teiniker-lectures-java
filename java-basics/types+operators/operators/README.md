# Operators 

Java operators are special symbols that **perform operations on variables and values**, 
resulting in a new value. Operators in Java can be categorized into several types based 
on the functionality they provide.

## Arithmetic Operators
These operators are used for arithmetic calculations:

* **+ (Addition)**: Adds two values.
* **- (Subtraction)**: Subtracts one value from another.
* **\* (Multiplication)**: Multiplies two values.
* **/ (Division)**: Divides one value by another.
* **% (Modulus)**: Returns the remainder of a division.

## Unary Operators
These operators perform various operations on a single operand:

* **+ (Unary Plus)**: Indicates a positive value (not necessary to use explicitly).
* **- (Unary Minus)**: Negates an expression.
* **++ (Increment)**: Increases a value by `1`.
* **-- (Decrement)**: Decreases a value by `1`.
* **! (Logical NOT)**: Inverts the value of a boolean.

## Assignment Operators
Assignment operators assign a value to a variable:

* **= (Assignment)**: Assigns a value to a variable.
* **+= (Add and Assign)**: Adds the right operand to the left operand and assigns 
    the result to the left operand.
* **-= (Subtract and Assign)**: Subtracts the right operand from the left operand 
    and assigns the result to the left operand.
* ***= (Multiply and Assign)**: Multiplies the left operand by the right operand 
    and assigns the result to the left operand.
* **/= (Divide and Assign)**: Divides the left operand by the right operand and 
    assigns the result to the left operand.
* **%= (Modulus and Assign)**: Takes the modulus using two operands and assigns 
    the result to the left operand.

## Relational Operators
These operators compare two operands and return a boolean value based on the comparison:

* **== (Equal to)**: Checks if two operands are equal.
* **!= (Not Equal to)**: Checks if two operands are not equal.
* **> (Greater than)**: Checks if the left operand is greater than the right operand.
* **< (Less than)**: Checks if the left operand is less than the right operand.
* **>= (Greater than or equal to)**: Checks if the left operand is greater than or 
    equal to the right operand.
* **<= (Less than or equal to)**: Checks if the left operand is less than or equal 
    to the right operand. 

## Logical Operators
Logical operators are used with boolean values to perform logical operations:

* **&& (Logical AND)**: Returns true if both operands are true.
* **|| (Logical OR)**: Returns true if at least one of the operands is true.
* **! (Logical NOT)**: Returns true if the operand is false and vice versa.


## Bitwise Operators
Bitwise operators perform operations on the bits of integer types:

* **& (Bitwise AND)**
* **| (Bitwise OR)**
* **^ (Bitwise XOR)**
* **~ (Bitwise NOT)**
* **<< (Left Shift)**
* **>> (Right Shift)**
* **>>> (Unsigned Right Shift)**


## Ternary Operator
The ternary operator is a shorthand for the `if-else` statement and has 
the form: 
```Java
    condition ? value if true : value if false
```

## instanceof Operator
The instanceof operator checks whether an object is an instance of a specific class 
or interface.

Java operators are the building blocks of Java expressions and play a crucial role 
in **manipulating data and controlling the flow of programs**.


## References

* [The Java™ Tutorials: Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

*Egon Teiniker, 2024, GPL v3.0*



