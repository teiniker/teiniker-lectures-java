# Generic Pitfalls 

In the context of Java Generics, there are several common pitfalls 
that can arise related to instantiation, overloading, and inheritance. 

Understanding these pitfalls can help in designing and implementing 
more robust generic types and methods.


## Instantiation of Generic Types

We cannot directly instantiate generic types due to type erasure. 
**Type erasure** is a process where the Java compiler removes all 
generic type information during compilation. This means that the 
runtime type of generic parameters is not directly available, and 
hence, you cannot instantiate generic types directly.

```Java
	public static <E> E createElement()
	{
		E e = new E();  // Compile-time error!!
		return e;
	}
```

_Workaround_: To work around this limitation, we can pass a 
`Class<T>` object to our generic class and use it to instantiate 
objects.
```Java
	public static <E> E createElement(Class<E> elementType)
	{
		try
		{
			E element = elementType.getDeclaredConstructor().newInstance();
			return element;
		}
		catch(NoSuchMethodException | InvocationTargetException
			  | InstantiationException | IllegalAccessException e)
		{
			throw new IllegalArgumentException("Can't create new instance!", e);
		}
	}
```

##  Overloading on Generic Methods

Overloading methods in Java that differ only by generic type can 
lead to confusing results because of type erasure.

_Example_: 
```Java
    public void print(Set<String> strings) 
    {
        System.out.println("Set of Strings");
    }

    public void print(Set<Integer> integers) 
    {
        System.out.println("Set of Integers");
    }
```

This code will not compile because the methods `print(Set<String>)` 
and `print(Set<Integer>)` have the same erasure (both are seen as 
`print(Set)` by the compiler) and hence are considered to be the 
same method.

_Avoidance_: To avoid this issue, method signatures must differ in 
more than just the generic type. Parameters must have different 
non-generic types, or the methods must have different numbers of 
parameters.


## References

* Maurice Naftalin, Philip Wadler. **Java Generics and Collections**. O′Reilly, 2006

*Egon Teiniker, 2024, GPL v3.0*