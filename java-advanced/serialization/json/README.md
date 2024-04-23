# JavaScript Object Notation (JSON)

JSON is a lightweight data-interchange format that is easy for
humans to read and write, and easy for machines to parse and generate.
It's widely used for **data exchange** in **web applications**, 
**APIs**, and **configuration files**. 

Syntax and Structure:

* **Data Types**: JSON supports several basic data types:
    * **Numbers**: Any numeric value, integer or floating-point. 
        
        _Examples:_ `123`, `10.5`

    * **Strings**: A sequence of zero or more Unicode characters,
        wrapped in double quotes. 
        
        _Example:_ `"Hello, world"`

    * **Booleans**: Either `true` or `false`.
    
    * **Null**: Represents a null value (null).

* **Arrays**: An ordered list of zero or more values, each 
    of which can be of any type. Arrays are enclosed in square
    brackets, and values are separated by commas.
        
    _Example:_ `["apple", "banana", "cherry"]`

* **Objects**: A collection of key-value pairs where the keys 
    are strings and the values can be any JSON data type. 
    Objects are denoted by curly braces with key-value pairs 
    separated by commas, and keys and values separated by a 
    colon.

    _Example:_ `{"name": "John", "age": 30}`

_Example:_ JSON document
```JSON
{
  "name": "Alice",
  "age": 25,
  "isStudent": false,
  "courses": ["Math", "Science", "Literature"],
  "address": {
    "street": "123 Maple St.",
    "city": "Anytown",
    "zip": "12345"
  },
  "phoneNumbers": null
}
```

This JSON object represents a person with several properties: 
a name, age, student status, a list of courses, a nested address 
object, and a null value for phone numbers.


## References


*Egon Teiniker, 2024, GPL v3.0*