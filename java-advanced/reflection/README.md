# Java Reflection API 

The Reflection API provides a powerful set of tools that allows programmers to 
**inspect and manipulate the properties of classes, interfaces, fields, and methods at runtime**. 
This includes the ability to **invoke methods, and create new objects dynamically**. 

The Reflection API is particularly useful in scenarios where we need to interact 
with classes and objects in a flexible manner, without knowing their types at 
compile time.

Components of the Java Reflection API:

* **Class Inspection**: Using the Reflection API, we can obtain detailed information 
    about a class, such as its name, its package, its superclass, the interfaces 
    it implements, and all its methods and fields. This is done using the `Class` 
    object associated with the target class.

* **Creating Instances**: Reflection allows for the instantiation of objects at runtime
    using the `getDeclaredConstructor().newInstance()` method. This is useful in 
    scenarios where the class type might not be known until runtime.

* **Field Manipulation**: We can access and modify the values of fields of a class, 
    regardless of their visibility (private, protected, etc.). For instance, we can 
    read a private field or change its value, bypassing normal access controls.

* **Method Invocation**: The API enables us to invoke methods dynamically, regardless 
    of their access level. This can be done by fetching a specific method of a class 
    and using it to invoke with specific parameters on an object instance.

* **Array Handling**: Reflection provides methods to dynamically create and manipulate
    arrays.


Practical uses of Reflection:
* **Dynamic Configuration**: Reflection is useful in cases where code configurations 
    need to be dynamically adapted, such as instantiating classes or invoking methods
    specified in configuration files.

* **Serialization and Deserialization**: In serialization libraries, reflection is 
    often used to dynamically determine the structure of an object and serialize 
    or deserialize it accordingly.

* **Dependency Injection Frameworks**: Frameworks like Spring use reflection extensively 
    to inject dependencies in objects dynamically.


## Class Objects 

The `Class` object plays a central role in the Reflection API. It is an instance of 
the `java.lang.Class` class and represents the "class" of a type. This object holds 
**metadata about the class**, including its structure, methods, fields, constructors, 
and more. 

Essentially, a `Class` object serves as the **entry point for all reflection operations**
we can perform on a class or an interface.

_Example_: Retrieve the class object from an existing object.
```Java
	@Test
	public void testGetClass()
	{
		User u = new User(7,"teini", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201");	
		Class<?> c = u.getClass();
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
```

If an instance of an object is available, then the simplest way to get its `Class` 
object is to invoke `Object.getClass()`.


_Example_: Retrieve the class object from a type.
```Java
	@Test
	public void testClass()
	{
		Class<User> c = User.class;		
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
```

If the type is available but there is no instance then it is possible to obtain 
a `Class`object by appending `.class` to the name of the type. 

This is also the easiest way to obtain the Class for a primitive type. 


_Example_: Retrieve the class object from the classloader by name.
```Java
	@Test
	public void testForName() throws ClassNotFoundException
	{
		Class<?> c = Class.forName("org.se.lab.User");
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
```

If the fully-qualified name of a class is available, it is possible to 
get the corresponding `Class`object using the static method `Class.forName()`. 

The `Class.forName()` method tells the Java Virtual Machine (JVM) to 
load a given class into memory. This includes checking the classpath to 
locate the specified class and then loading it if it's not already loaded.

This cannot be used for primitive types.


## Constructor Objects 

The `Constructor` class is used to represent and manage the constructors 
of a class. This class is part of the `java.lang.reflect` package and provides 
methods to **dynamically create instances, inspect constructor modifiers, 
and handle constructor parameters**. The `Constructor` class allows for detailed 
interaction with the constructors of any class at runtime.

_Example_: Retrieve all `Constructor` objects from a given class.
```Java
	private Constructor<?>[] constructors;
	
	@Before
	public void setup()
	{
		Class<User> c = User.class;
		constructors = c.getDeclaredConstructors();		
		Assert.assertEquals(2,constructors.length);
	}
```

## Field Objects 

The `Field` class is a crucial component used to access and manipulate 
the fields of a class or an object at runtime. Part of the `java.lang.reflect` 
package, the Field class provides methods to **dynamically interact with the fields 
of a class**, regardless of their access modifiers (private, protected, etc.). 

This functionality is especially useful for situations where direct access 
to class internals is necessary, but not possible through traditional means 
due to encapsulation.

_Example_: Retrieve all `Field` objects from a given class.
```Java
	private Class<User> c;
	private Field[] fields;
	
	@Before
	public void setup()
	{
		c = User.class;
		fields = c.getDeclaredFields();		
		Assert.assertEquals(3,fields.length);
	}
```

_Example_: Retrieve a `Field` object from a given class by name.
```Java
	@Test
	public void testId() throws SecurityException, NoSuchFieldException
	{
		Field id = c.getDeclaredField("id");		
		Class<?> fieldType = id.getType();
		Assert.assertEquals("int", fieldType.getName());		
	}
```

_Example_: Set and get a value of a `Field` from a given object.
```Java
	@Test
	public void testIdSetterAndGetter() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		User user = new User(7, "teini", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201");		
		Field id = user.getClass().getDeclaredField("id");
		
        id.setInt(user, 17);
		Assert.assertEquals(17, user.getId());

		int i = id.getInt(user);
		Assert.assertEquals(17, i);
	}
```


## Method Objects

The Method class is a critical component used to represent and interact with 
the methods of a class at runtime. Part of the `java.lang.reflect` package, 
the `Method` class provides the means to **dynamically invoke methods on objects 
and classes, inspect method information like parameter types, return types, modifiers, and annotations**, regardless of their access level (public, private, etc.). 

This flexibility is essential for scenarios that require dynamic behavior and 
where methods need to be manipulated programmatically during runtime.

_Example_: Retrieve all `Method` objects from a given class.
```Java
	private Class<User> c;
	private Method[] methods;
	
	@Before
	public void setup()
	{
		c = User.class;
		methods = c.getDeclaredMethods();		
		Assert.assertEquals(7,methods.length);
	}
```

_Example_: Retrieve a `Method` objects from a given class by name.
```Java
	@Test
	public void testGetId() throws SecurityException, NoSuchMethodException
	{
		System.out.println(Arrays.toString(methods));
		Method m = c.getDeclaredMethod("getId");		
		Assert.assertEquals(Modifier.PUBLIC, m.getModifiers());
		Assert.assertEquals(int.class, m.getReturnType());		
	}
```


_Example_: Invoke a `Method` from a given object.
```Java
	@Test
	public void testInvokeToString() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		User user = new User(7, "teini", "ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201");
		Method m = user.getClass().getDeclaredMethod("toString");
		String s = (String)m.invoke(user);
		Assert.assertEquals("7,teini,ff69e6555c40008fb266006f18f719e4cff90900bc3f6f2bc83ef24c26791201", s);
	}
```


## References

* [YouTube: Java Reflection Explained](https://youtu.be/bhhMJSKNCQY?si=nWOjmLaedsvM2nNu)

* [The Java™ Tutorials: The Reflection API](https://docs.oracle.com/javase/tutorial/reflect/index.html)
* [Baeldung: Guide to Java Reflection](https://www.baeldung.com/java-reflection)

* Java API:
    * [Class Class<T>](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Class.html)
    * [Class Constructor<T>](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/reflect/Constructor.html)
    * [Class Field](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/reflect/Field.html)
    * [Class Method](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/reflect/Method.html)
    



*Egon Teiniker, 2024, GPL v3.0*