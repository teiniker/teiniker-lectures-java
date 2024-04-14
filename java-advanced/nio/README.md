# Java New Input/Output (NIO)

Java NIO is a collection of Java programming language APIs that offer a more 
flexible and scalable approach to input/output operations compared to the 
standard Java IO APIs. 

Introduced in Java 1.4, NIO supports **non-blocking IO operations**, which allow 
a thread to request reading or writing data without necessarily blocking until 
the operation is complete. This makes Java NIO especially useful for applications 
that need to handle thousands of open connections simultaneously, which is typical 
in network servers or similar applications.

Java NIO consists of several core components, each designed to provide specific 
functionality around non-blocking, buffer-based interactions:

* **Buffers**: In NIO, data is read into a buffer, processed, and then written 
    back from the buffer. Buffers are essentially blocks of memory into which 
    data can be written, and from which data can be read. There are different 
    types of buffers depending on the data type 
    (e.g., `ByteBuffer`, `CharBuffer`, `IntBuffer`, etc.).

* **Channels**: Channels represent open connections to entities capable of 
    performing I/O operations, such as files, network sockets, and hardware devices. 
    Unlike streams, **channels support reading and writing asynchronously**. 
    Some of the key channels include `FileChannel` for file data, `SocketChannel` 
    for TCP, `ServerSocketChannel` for TCP servers, and `DatagramChannel` for UDP.    

* **Selectors**: Selectors allow a single thread to monitor multiple input channels 
    for events (like connection opened, data arrived, etc.). This is useful for servers 
    that handle lots of connections at once, reducing the need for multiple threads 
    to watch each connection individually, thus improving the system's scalability.    

One of the key advantages of NIO over traditional IO is its non-blocking capability:

* **Blocking IO**: In traditional IO, when a thread reads from or writes to a stream, 
    it blocks until there is some data to read, or the data is fully written. 
    This means no further work can be done until the read or write completes.    

* **Non-blocking IO**: In NIO, we can set channels to non-blocking mode. This means 
    a thread can request to read data from a channel, and if no data is available, 
    the thread can do something else instead of waiting. When data becomes available, 
    the thread can continue where it left off. This model is particularly efficient 
    for handling multiple connections simultaneously.    

Java NIO is a powerful alternative to traditional Java IO, particularly useful in 
scenarios requiring high scalability and efficient resource management. By allowing 
non-blocking operations, efficient buffer management, and the handling of multiple 
connections via selectors, NIO can significantly improve the performance of network 
applications and large file handling. 


## File I/O

The `java.nio.file` package and its related package, `java.nio.file.attribute`, 
provide comprehensive support for file I/O and for accessing the default file system.

A **file system** stores and organizes files on some form of media, generally one or more 
hard drives, in such a way that they can be easily retrieved. Most file systems in use 
today store the files in a tree (or hierarchical) structure.
Each directory can contain files and subdirectories, which in turn can contain files 
and subdirectories, and so on, potentially to an almost limitless depth.

A **file** is identified by its **path** through the file system, beginning from the root node.
* An **absolute path** always contains the root element and the complete directory 
    list required to locate the file. 
* A **relative path** needs to be combined with another path in order to access a file. 


### Path, Paths, and Files

In the context of Java's New I/O (NIO) framework, introduced in Java 7 as part of the NIO.2 update 
(`java.nio.file` package), three key components are `Path`, `Paths`, and `Files`. These classes 
and interfaces provide a more **comprehensive and flexible file system management** approach 
compared to the older `java.io.File` class. 

* [**Path Interface**](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/nio/file/Path.html):
    Path represents a **system-independent path to a file or directory** in the file system. Unlike 
    the File class, which mixes file path representation with file operations, Path is part of a 
    cleaner separation of concerns, **focusing only on the path abstraction**.

    * Paths can be absolute or relative.
    * Provides various utility methods to manipulate paths, such as `resolve()`, `normalize()`, 
        `relativize()`, and methods to convert between `Path` and `URI` or `File`.
    * Supports iterating over the components of a path, making it useful for more complex path 
        manipulation tasks.

* [**Paths Class**](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/nio/file/Paths.html):
    `Paths` is a final utility class that provides static methods to create `Path` objects. 
    It simplifies the creation of `Path` instances.
    * The most commonly used method is `Paths.get(String first, String... more)`, which converts 
        a system-dependent file path into a `Path` object. The method is a **varargs method**, 
        allowing concatenation of path segments in a single call.
    * It can also convert URIs to `Path` objects with `Paths.get(URI uri)`.    

* [**Files Class**](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/nio/file/Files.html):
    `Files` is another utility class filled with static methods designed for **file and directory operations**, 
    making use of `Path` objects. It does not represent data but instead provides a rich set of operations 
    for file manipulation.
    * File operations such as copy, move, delete, and file attribute management (e.g., checking, 
        setting, and viewing file attributes).
    * Directory operations like listing files in a directory (`newDirectoryStream`), creating directories 
        (`createDirectory`), and walking file trees (`walk`, `walkFileTree`).
    * File I/O operations for reading and writing files, which handle both binary and character 
        content through methods like `readAllBytes`, `readAllLines`, `write`, etc.
    * Advanced features such as checking file visibility, readability, comparability, and file 
        store manipulations.

`Path`, `Paths`, and `Files` provide a robust, flexible, and comprehensive toolset for handling file 
systems in Java, suited for modern I/O needs and capable of sophisticated path manipulations and file 
system interactions. 


## References
* [The Java™ Tutorials: File I/O (Featuring NIO.2)](https://docs.oracle.com/javase/tutorial/essential/io/fileio.html)

*Egon Teiniker, 2024, GPL v3.0*