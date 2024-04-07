# Java Generics

> Generics enable types (classes and interfaces) to be parameters when defining classes, 
> interfaces and methods. Much like the more familiar formal parameters used in method 
> declarations, type parameters provide a way for you to **reuse the same code with different inputs**. 
> The difference is that the inputs to formal parameters are values, while the inputs to 
> type parameters are types.

Code that uses generics has many **benefits** over non-generic code:

* **Stronger type checks at compile time**: A Java compiler applies strong type checking 
    to generic code and issues errors if the code violates type safety. Fixing compile-time 
    errors is easier than fixing runtime errors, which can be difficult to find.

* **Elimination of casts**:

    The following code snippet without generics requires casting:
    ```Java
    List list = new ArrayList();
    list.add("hello");
    String s = (String) list.get(0);
    ```

    When re-written to use generics, the code does not require casting:
    ```Java
    List<String> list = new ArrayList<String>();
    list.add("hello");
    String s = list.get(0);   // no cast !!!
    ```

* **Enabling programmers to implement generic algorithm**s:
    By using generics, programmers can implement generic algorithms that work 
    on collections of different types, can be customized, and are type safe 
    and easier to read.


## Generic Types 

> A generic type is a generic class or interface that is parameterized over types.

A generic class is defined with the following format:
```Java
class name<T1, T2, ..., Tn> 
{ 
    //...  
}
```

The **type parameter** section, delimited by angle brackets (`<` and `>`), follows 
the class name. It specifies the type parameters (also called type variables) 
`T1`, `T2`, ..., and `Tn`.

_Example_: Generic Tuple class
```Java
public final class Tuple<F,S>
{
    public GenericTuple(F a, S b)
    {
        if(a == null || b == null)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    private final F a;
    public F getFirstElement()
    {
        return a;
    }
    
    private final S b;
    public S getSecondElement()
    {
        return b;
    }
}
```

**A type variable can be any non-primitive type** we specify: any class type, 
any interface type, any array type, or even another type variable.

By convention, type parameter names are **single, uppercase letters**. 

This same technique can be applied to create **generic interfaces**.

To reference the generic class from within our code, we must perform 
a **generic type invocation**, which replaces `T` with some concrete value

_Example_: Using the generic Tuple class
```Java
    @Test
    public void testGetters()
    {
        Tuple<Integer,String> t = new Tuple<>(7, "Teini");
        
        Assert.assertEquals(Integer.valueOf(7), t.getFirstElement());
        Assert.assertEquals("Teini", t.getSecondElement());
    }
```

An invocation of a generic type is generally known as a **parameterized type**.

In Java SE 7 and later, we can replace the type arguments required to invoke 
the constructor of a generic class with an empty set of type arguments `<>` as 
long as the compiler can determine, or infer, the type arguments from the context. 
This pair of angle brackets, `<>`, is informally called the **diamond**.


### Raw Types

A raw type is the name of a generic class or interface **without any type arguments**. 

Raw types show up in **legacy code** because lots of API classes (such as the Collections 
classes) were not generic prior to JDK 5.0. 

When using raw types, we essentially get pre-generics behavior — a `Tuple` gives us Objects. 


### Type Erasure

Generics were introduced to the Java language to provide tighter type checks at 
compile time and to support generic programming. 

To implement generics, the **Java compiler applies type erasure** to:

* Replace all type parameters in generic types with their bounds or `Object` if the 
    type parameters are unbounded. The produced bytecode, therefore, contains only 
    ordinary classes, interfaces, and methods.
* Insert type casts if necessary to preserve type safety.
* Generate bridge methods to preserve polymorphism in extended generic types.

Type erasure ensures that no new classes are created for parameterized types; consequently,
generics incur **no runtime overhead**.


## Generic Methods

> Generic methods are methods that introduce their own type parameters. 

This is similar to declaring a generic type, but the **type parameter's scope 
is limited to the method** where it is declared. Static and non-static generic 
methods are allowed, as well as generic class constructors.

_Example:_ Generic method (inside of a regular class)
```Java
public class ListUtils
{    
    public static <T> List<T> asList(T... in)
    {
        List<T> out = new ArrayList<T>();        
        for(T t : in)
        {
            out.add(t);
        }        
        return out;
    }
    //...
}

The syntax for a generic method includes a list of type parameters, inside angle 
brackets, which appears before the method's return type. 

For static generic methods, the type parameter section must appear before the 
method's return type.

_Example:_ Using generic methods 
```Java
	@Test
	public void testStringArrayToList()
    {
        List<String> list = ListUtils.asList("one", "two", "three", "4");
        assertEquals("[one, two, three, 4]", list.toString());
    }
```
Generally, the explicitly type (`ListUtils.<String>asList()`) can be left out and 
the compiler will infer the type that is needed - known as **type inference**.
This allows us to invoke a generic method as an ordinary method, without specifying a 
type between angle brackets. 



## References

* [The Java™ Tutorials: Generic Types](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
* [Baeldung: The Basics of Java Generics](https://www.baeldung.com/java-generics)

*Egon Teiniker, 2024, GPL v3.0*
