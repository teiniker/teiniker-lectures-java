# Java Data Types

## Primitive Types 

Java has eight primitive data types, each serving a specific purpose:

* **byte**: This is an **8-bit signed integer**. It has a minimum value 
    of **-128** and a maximum value of **127** (inclusive). 
    It's useful for saving memory in large arrays where the memory savings 
    are most needed. It can also be used in place of int where their limits 
    help to clarify your code.

* **short**: A **16-bit signed integer**, with a minimum value of **-32768** 
    and a maximum value of **32767** (inclusive). 
    Like byte, it's used to save memory in large arrays.

* **int**: A **32-bit signed integer**, with a minimum value of **-2^31** and 
    a maximum value of **2^31-1**. This is the most commonly used integer type.

* **long**: A **64-bit signed integer**, with a minimum value of **-2^63** and 
    a maximum value of **2^63-1**. 
    It's used when a wider range than int is needed.

* **float**: A **single-precision 32-bit IEEE 754 floating point**. 
    Its range of values is beyond the scope of this summary, but it's used for 
    floating-point calculations where exact precision is not necessary. 
    Precision might be lost when dealing with very large or small numbers.

* **double**: A **double-precision 64-bit IEEE 754 floating point**. Like float, 
    it's used for floating-point calculations but is more precise, hence it's 
    the default choice for floating-point calculations in Java.

* **boolean**: It has only two possible values, **true** and **false**. 
    It's used for simple flags that track true/false conditions.

* **char**: A **single 16-bit Unicode character**. 
    It has a minimum value of **\u0000 (or 0)** and a maximum value of **\uffff (or 65,535 inclusive)**.

These primitive types are not considered objects and thus do not have methods of their own. 


## Wrapper Class

Each primitive data type has a corresponding wrapper class in the `java.lang package` 
that **encapsulates the primitive type as an object**. These wrapper classes are used to 
convert primitive types into objects, which is necessary when working with collections or 
utilizing methods in classes that require objects as arguments

* **Byte**: Encapsulates the primitive byte data type. It contains methods like `byteValue()` 
    to retrieve the byte value and `parseByte(String s)` to convert a string to a byte.

* **Short**: Wraps the primitive short type. It includes methods such as `shortValue()` to 
    get the short value and `parseShort(String s)` for converting a string to a short.

* **Integer**: Encapsulates the primitive int type. It provides methods like `intValue()` 
    to get the int value and `parseInt(String s)` for parsing a string to an int.

* **Long**: Wraps the primitive long type. It includes methods such as `longValue()` for 
    retrieving the long value and `parseLong(String s)` to convert a string to a long.

* **Float**: Encapsulates the primitive float type. It contains methods like `floatValue()` 
    to get the float value and `parseFloat(String s)` for converting a string to a float.

* **Double**: Wraps the primitive double type. It includes methods such as `doubleValue()` 
    to retrieve the double value and `parseDouble(String s)` to convert a string to a double.

* **Boolean**: Encapsulates the primitive boolean type. It offers methods like `booleanValue()` 
    to get the boolean value and `parseBoolean(String s)` for converting a string to a boolean.

* **Character**: Wraps the primitive char type. It includes methods such as `charValue()` 
    to get the char value.

These wrapper classes also offer a variety of utility methods for converting between types, 
comparing objects, and converting objects to and from strings. For example, they each have 
a `valueOf()` method that returns an instance of the wrapper object containing the specified 
primitive value or string.


With the introduction of **autoboxing** and **unboxing** in Java 5, the conversion between 
primitive types and their corresponding wrapper classes is automated, allowing for easier 
coding and readability. 
Autoboxing refers to the automatic conversion of a primitive type to its corresponding wrapper 
class object when needed, while unboxing is the reverse process, converting an object of a 
wrapper class back to its corresponding primitive type.

In Java, **null** is a special literal that can be assigned to any reference type to indicate 
that the reference does not point to any object in memory. It's important to note that 
**null is not applicable to primitive types** - it can only be assigned to variables of the 
wrapper classes.


## String Class

The **String** class in Java, defined in the `java.lang package`, is one of the most used 
classes in Java development. It represents a sequence of characters and provides a wide 
array of methods to manipulate and inspect strings. 

Unlike primitive data types, a `String` is a **reference type** and has some key features:

* **Immutable**: Strings are immutable in Java, meaning **once a `String` object is created, 
its value cannot be changed**. If you try to modify a `String`, a new `String` object is 
created instead of changing the existing one. 
This design choice helps in caching, and security for string operations.

* **Interning**: Java uses a concept called interning to ensure that **all `String` literals 
with the same content share the same memory space**. This is possible because strings are 
immutable. When a `String` literal is created, Java checks the `String` pool first; if the 
`String` already exists, the new reference points to the existing `String`. 
Otherwise, a new `String` is created in the pool.

* **Constructors**: The `String` class provides several constructors to create Strings in 
different ways, including copying characters from character arrays, using byte arrays 
(optionally specifying the charset), and more.

* **Concatenation**: `Strings` can be concatenated using the **+ operator**. 
This operation is internally implemented using a `StringBuilder` or `StringBuffer` 
to create a new string with the combined content.

* **Comparison**: To compare `Strings` for equality, we should use the **equals(Object anObject)** 
method, which compares the content of the `Strings`. 
The **== operator**, on the other hand, checks for reference equality and 
**should not be used for String content comparison**.

* **Conversion**: `Strings` can be converted to and from other data types and objects. 
The `toString()` method is used to convert objects to strings, while parsing methods like 
`Integer.parseInt(String s)` or `Double.parseDouble(String s)` are used to convert `Strings` 
to other types.

* **Methods**: The `String` class includes numerous methods for string manipulation and inspection:
    * **length()**: Returns the length of the string.
    * **charAt(int index)**: Returns the character at the specified index.
    * **substring(int beginIndex, int endIndex)**: Returns a new string that is a substring 
        of the original string.
    * **contains(CharSequence s)**: Returns true if the string contains the specified sequence 
        of char values.
    * **startsWith(String prefix)** and **endsWith(String suffix)**: Check if the string starts 
        or ends with the specified prefix or suffix, respectively.
    * **indexOf(int ch)** and **lastIndexOf(int ch)**: Return the index of the first 
        or last occurrence of the specified character, respectively.
    * **toUpperCase()** and **toLowerCase()**: Return a new string in all uppercase or lowercase.
    * **trim()**: Returns a new string with whitespace removed from the beginning and end.
    * **replace(char oldChar, char newChar)**: Returns a new string resulting from replacing 
        all occurrences of oldChar in the string with newChar.
    * **split(String regex)**: Splits the string around matches of the given regular expression.

The `String` class, with its rich set of features and methods, is essential for handling text 
data in Java programs.


## Literals 

In Java, **literals represent fixed values** that are directly inserted into the code. 
They are used to **initialize variables or constants** and are categorized by their types. 

Here's an overview of the different types of literals in Java:

* **Integer Literals**: These are used for initializing variables of integer types 
    (`byte`, `short`, `int`, `long`). We can specify integer literals in **decimal (base 10)**, 
    **hexadecimal (base 16, prefixed with 0x or 0X)**, **octal (base 8, prefixed with 0)**, 
    or **binary (base 2, prefixed with 0b or 0B)**. 
    
    _Examples:_ 
    ```Java
        int dec = 100;
        int hex = 0xFF;
        int oct = 077;
        int bin = 0b1010; 
    ```
    
    **Long literals are suffixed with an L or l**.
    
    _Example:_ 
    ```Java
        long l = 100L;
    ```

* **Floating-Point Literals**: These represent floating-point numbers for `float` and `double` 
    types. 
    
    **Floating-point literals are double by default**. 
    
    To specify a **float literal, suffix it with an F or f**. 
    
    They can be written in **standard decimal form** or in **scientific notation**. 
    
    _Examples:_
    ```Java
        double d = 123.4;
        float f = 123.4f;
        double sci = 1.234e2;
    ```Java

* **Boolean Literals**: The two `boolean` literals are `true` and `false`, 
    representing the two truth values of the boolean type. 
    
    _Example:_
    ```Java 
        boolean b = true;
    ```

* **Character Literals**: Character literals are enclosed in **single quotes** 
    and represent single **Unicode characters**. 
    
    _Example:_
    ```Java
        char ch = 'a';
    ```
    
    Special characters can be represented using **escape sequences** like `\n` (newline), 
    `\t` (tab), `\\` (backslash), `\'` (single quote), and `\"` (double quote).

* **String Literals**: `String` literals are enclosed in **double quotes** and represent 
    sequences of characters. 
    
    _Example:_
    ```Java
        String str = "Hello, World!";
    ```

    String literals can contain **escape sequences** like characters.

* **Null Literal**: The `null` literal is used to represent the **absence of a reference**. 
    It can be assigned to any reference type to indicate that it currently points to no 
    object. 
    
    _Example:_
    ```Java
        String str = null;
    ```

Java literals provide a straightforward way to express constant values in our code. 
They are directly written in the code without requiring computation, making them efficient to use. 


## Arrays

In Java, an array is a container object that holds a **fixed number of values of a single type**. 
The length of an array is established when the array is created, and after creation, its length 
is fixed. Each item in an array is called an element, and each element is accessed by its numerical 
index. 

Arrays are **zero-indexed**: The first element of the array is at index 0, the second is at index 1, 
and so on. 

Arrays can store either primitive data types (int, char, etc.) or objects of a class depending on 
the declaration of the array.

* **Declaration**: Array variables are declared by specifying the data type of the elements that 
    the array will hold, followed by square brackets. 
    
    _Examples:_
    ```Java
        int[] myIntArray;
        String[] myStringArray;
    ```
* **Instantiation**: Arrays are instantiated using the `new` keyword, followed by the data type 
    and the array size in square brackets. 
    
    _Examples:_
    ```Java
        myIntArray = new int[10];
        myStringArray = new String[5];
    ```

* **Initialization**: Arrays can be **initialized at the time of declaration** by enclosing 
    the initial values in curly braces. 
    
    _Examples:_
    ```Java
        int[] myIntArray = {1, 2, 3, 4, 5};
        String[] myStringArray = {"Hello", "World"};
    ```

* **Accessing Elements**: Elements in an array are accessed using the array name followed 
    by the **index in square brackets**. The index of the first element is 0. 
    
    _Example:_
    ```Java 
        int firstElement = myIntArray[0]; 
        String secondElement = myStringArray[1];
    ```

* **Properties**: The **length** property of an array is used to find out how many elements 
    it can hold. For example, `myIntArray.length` would return `10` in the case of the 
    instantiation example above.

* **Multidimensional Arrays**: Java supports multidimensional arrays, which are arrays of 
    arrays. The most common type is the two-dimensional array. 
    
    _Example:_
    ```Java
        int[][] myMatrix = new int[3][2]; // creates a matrix with 3 rows and 2 columns.
    ```


* **Limitations and Alternatives**: Arrays have a fixed size. 
    For **dynamic-size collections**, Java offers classes like **ArrayList**, **LinkedList**, etc.
    Arrays can hold only one type of data. To store different types of objects, consider using 
    collections.
    For more operations not supported by arrays (like insertion and deletion), also 
    use Java collection classes.

Arrays are a fundamental aspect of Java programming, offering a simple and efficient way 
to store and access a collection of values. Their straightforward syntax and fast access times 
make them suitable for many situations, especially when the size of the collection is known ahead 
of time and is fixed.


## References

* [The Java™ Tutorials: Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

* [Java API: Class Integer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html)



* [Java API: Class String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)

* [The Java™ Tutorials: Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)

*Egon Teiniker, 2024, GPL v3.0*