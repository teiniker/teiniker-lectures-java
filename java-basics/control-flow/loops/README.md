# Loops 

Loops are used to execute a block of code repeatedly under certain conditions. 
This allows for efficient code writing, especially when dealing with repetitive tasks.

## for Loops

The **for loop** is used when you **know in advance how many times you want to execute 
a block of code**. 

It consists of three parts: **initialization**, **condition**, and **iteration statement**, 
all included in a single line.

_Example:_ `for` loop
```Java
for (initialization; condition; iteration) 
{
    // code block to be executed
}
```

* **Initialization**: It initializes the loop variable and is executed once at the 
    beginning of the loop.
* **Condition**: Before each loop iteration, this condition is checked. 
    If the condition is true, the loop body is executed. If it is false, the loop ends.
* **Iteration**: It updates the loop variable after each iteration.


The **for-each loop**, it is designed to simplify the **iteration over arrays and collections**. 
It eliminates the need for using an indexing variable to access elements.

_Example:_ `for-each` loop
```Java
for (type variableName : arrayName) 
{
    // code block using variableName
}
```

Here, **type** is the data type of the elements in the array or collection, 
**variableName** is the variable that iterates over each element, 
and **arrayName** is the array or collection being iterated over.


## while Loops

The `while` loop is used to execute a block of code as long as a specified condition 
is true. The **condition is evaluated before the execution of the loop's body**.

_Example:_ `while` loop
```Java
while (condition) 
{
    // code block to be executed
}
```

This loop will continue to execute the block of code as long as the condition 
remains true.


The `do-while` loop is similar to the while loop, except that it 
**tests the condition at the end of the loop body**. 
This means the loop's body will be executed at least once, even if the condition is false.

_Example:_ `do-while` loop
```Java
do 
{
    // code block to be executed
} 
while (condition);
```

## Loop Control Statements

Java also provides control statements that you can use to 
**manipulate the flow of the loop execution**:

* **break**: Terminates the loop or switch statement and transfers execution 
    to the statement immediately following the loop or switch.
* **continue**: Causes the loop to skip the remainder of its body and then 
    immediately retest its condition prior to reiterating.
* **return**: Exits from the current method, and control flow returns to where 
    the method was invoked.


## References

* [The Java™ Tutorials: Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)

*Egon Teiniker, 2024, GPL v3.0*