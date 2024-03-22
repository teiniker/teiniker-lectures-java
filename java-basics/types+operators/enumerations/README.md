# Enumerations

Enumerations (enums) are a special data type that enable for **variables to be 
a set of predefined constants**. Enums are used when we know all possible values 
of a variable at compile time, such as days of the week, months of the year, 
directions (north, south, east, west), etc. 

Using enums can make our code more readable and safer by ensuring that **only valid 
values are assigned to variables**.


Enums are defined using the `enum` keyword.

_Example:_ Enum for days of the week
```Java
public enum Day 
{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```


Features of Enums:

* **Type-Safe**: Enums ensure that a variable can only contain valid values from the enumeration.
* **Own Methods**: You can define methods inside an enum. These methods can use the enum constants.
* **Implement Interfaces**: Enums can implement interfaces, allowing for flexible design.
* **No Inheritance**: Enums are implicitly `final`, so we cannot extend them.
* **Java.lang.Enum**: All enums implicitly extend the `java.lang.Enum` class, which means they 
    inherit some useful methods like: 
    * `ordinal()` to get the position of an enum constant 
    * `name()` to get the name of the enum constant
    * `values()` to get an array of all enum constants
* **Cannot Extend Other Classes**: Since enums extend `java.lang.Enum`, they cannot extend another class.
* **Enum Constructors**: We can define constructors in enums. Enum constructors are always either private 
    or package-private, ensuring enum constants are only defined within the enum itself.


_Example:_ Using enums in `switch` statements
```Java
Day day = Day.MONDAY;

switch (day) 
{
    case MONDAY:
        System.out.println("Mondays are bad.");
        break;
    case FRIDAY:
        System.out.println("Fridays are better.");
        break;
    default:
        System.out.println("Midweek days are so-so.");
        break;
}
```


## References

* [The Java™ Tutorials : Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

*Egon Teiniker, 2024, GPL v3.0*