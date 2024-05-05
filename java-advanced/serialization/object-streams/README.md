# Java Serialization

Object serialization is the process of converting an object into a sequence 
of bytes that can be easily stored or transmitted across a network, and later
reconstructed back into an object. This enables you to save the state of an 
object and recreate it later, possibly on a different JVM (Java Virtual Machine)
or even on a different machine altogether.

Serialization is particularly useful in scenarios like:

* **Data Persistence**: Saving the state of an object to a file so that 
    it can be retrieved later.
* **Network Communication**: Transmitting objects across a network.
* **Caching**: Storing objects in memory for later use.


## Serializable Interface

To serialize an object in Java, the class must implement the `Serializable`
interface. This interface acts as a marker, indicating that the objects of 
this class can be serialized. 

The Java runtime system uses **reflection** to examine the class at runtime 
and automatically performs the serialization process.

_Example_: Serializable class
```Java
    public class Product 
        implements Serializable
    {
        private static final long serialVersionUID = 1L;

        // ...
    }
```

## Serialization and Deserialization of Objects

The `ObjectOutputStream` then goes through the object's state. It serializes 
each field of the object one by one. For each field, it writes the field's name, 
type, and value to the stream. If the field is itself an object, it recursively 
serializes that object.

If the object graph (the network of objects reachable from the object being 
serialized) contains duplicate references to the same object, the `ObjectOutputStream` 
maintains consistency by serializing each object only once. It uses a technique called 
**object sharing** or **object reference preservation** to ensure that multiple 
references to the same object are preserved during deserialization.

Once a class is marked as `Serializable`, we can use Java's built-in 
serialization mechanisms to serialize and deserialize objects:

_Example_: Serialize an object into a byte array
```Java
    public byte[] serializeProduct(String filename, Product product) 
        throws IOException
    {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(product);
        oos.close();

        return bout.toByteArray();
    }
```

This method serializeProduct takes a filename and a Product object as input and returns a byte array containing the serialized form of the Product. Let's break down the method step by step:

* `ByteArrayOutputStream bout = new ByteArrayOutputStream()`: This creates a new
    `ByteArrayOutputStream` object called `bout`. This class implements an output 
    stream in which the data is written into a byte array. This byte array grows 
    automatically as data is written to it.
* `ObjectOutputStream oos = new ObjectOutputStream(bout)`: This creates a new 
    `ObjectOutputStream` object called oos that writes to the `ByteArrayOutputStream` 
    bout. `ObjectOutputStream` is used to serialize Java objects. 
    By passing `bout` to its constructor, it's set up to write the serialized object 
    into the byte array held by `bout`.
* `oos.writeObject(product)`: This writes the product object to the `ObjectOutputStream`. 
    Since product is an instance of a `Product` class (presumably marked as `Serializable`), 
    it can be serialized. The `writeObject()` method serializes the product and writes it 
    to the underlying byte array.
* `oos.close()`: This closes the `ObjectOutputStream`. This step is important to release 
    any resources held by the stream.
* `return bout.toByteArray()`: This returns the byte array containing the serialized form 
    of the `Product`. `toByteArray()` method of `ByteArrayOutputStream` returns the byte 
    array that was accumulated in the stream.


_Example_: Deserialize an object from a byte array
```Java
    public Product deserializeProduct(byte[] bytes) 
        throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bin);
        Product product = (Product) ois.readObject();
        ois.close();
        return product;
    }
```

* `ByteArrayInputStream bin = new ByteArrayInputStream(bytes)`: This creates a new
    `ByteArrayInputStream` object called bin, which reads data from the specified 
    byte array bytes. It's initialized with the byte array that contains the serialized 
    form of the `Product`.
* `ObjectInputStream ois = new ObjectInputStream(bin)`: This creates a new 
    `ObjectInputStream` object called `ois` that reads from the `ByteArrayInputStream` 
    bin. `ObjectInputStream` is used to deserialize Java objects. 
    By passing `bin` to its constructor, it's set up to read the serialized object from 
    the byte array held by bin.
* `Product product = (Product) ois.readObject()`: This reads the serialized object from 
    the `ObjectInputStream` `ois` and casts it to a `Product` object. The `readObject` 
    method reads the next object from the input stream and deserializes it.
* `ois.close()`: This closes the `ObjectInputStream`. As with the serialization process, 
    it's important to release any resources held by the stream.
* `return product`: This returns the deserialized `Product` object.


## Customize the Serialization and Deserialization

We can customize the serialization process by **providing custom logic for serializing 
and deserializing** objects. This customization can be achieved by implementing 
**special methods in our class** or by using special fields.

Here are the main ways to customize serialization in Java:

We can customize the serialization process by implementing the following two methods:
* `private void writeObject(ObjectOutputStream out) throws IOException`: This method 
    allows us to define custom serialization logic. It will be called automatically 
    by the serialization mechanism when your object is being serialized. 

    Inside this method, we can write custom serialization code to specify how our 
    object's state should be serialized.

* **private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException**: 
    This method allows us to define custom deserialization logic. It will be called 
    automatically by the deserialization mechanism when our object is being deserialized. 
    
    Inside this method, we can read the serialized state of your object and initialize 
    its fields accordingly.

* **Using transient Keyword**: We can prevent certain fields from being serialized 
    by marking them as transient. Transient fields are not included in the default 
    serialization process.

_Example:_ Customize object serialization
```Java
    private void writeObject(ObjectOutputStream out)
        throws IOException
    {
        //...
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        //...
        in.defaultReadObject();
    }
```

By using these techniques, we can customize the serialization process in Java 
to meet our specific requirements, such as handling special cases, ensuring 
compatibility between different versions of your class, or improving performance.

## References
* [Java™ Tutorials: Serializable Objects](https://docs.oracle.com/javase%2Ftutorial%2F/jndi/objects/serial.html)
* [Introduction to Java Serialization](https://www.baeldung.com/java-serialization)

*Egon Teiniker, 2024, GPL v3.0*