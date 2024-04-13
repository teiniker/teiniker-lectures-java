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

### Path Operations

The **Path** class is a programmatic representation of a path in the file system. A 
`Path` object contains the file name and directory list used to construct the path, 
and is used to examine, locate, and manipulate files.




### File Operations







*Egon Teiniker, 2024, GPL v3.0*