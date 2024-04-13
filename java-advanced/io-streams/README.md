# Java I/O Streams 

> An I/O Stream represents an input source or an output destination. 
> A stream can represent many different kinds of sources and
> destinations, including disk files, devices, other programs, and 
> memory arrays.

All streams present the same simple model to programs that use them: 
**A stream is a sequence of data**: 
* A program uses an **input stream** to read data from a source, one item at a time. 
* A program uses an **output stream** to write data to a destination, one item at time.

The **data source** and **data destination** can be anything that holds, generates, 
or consumes data. Obviously this includes **disk files**, but can also be a 
**peripheral device**, a **network socket**, or an **array**.


## Byte Streams

Programs use byte streams to perform input and output of **8-bit bytes**. 
All byte stream classes are derived from `InputStream` and `OutputStream`.

_Example_: Binary file copy using: `FileInputStream` and `FileOutputStream`. 
```Java
public void copy(String sourceFile, String destFile)
{
    try (FileInputStream in = new FileInputStream(sourceFile);
         FileOutputStream out = new FileOutputStream(destFile))
    {
        int c;
        while ((c = in.read()) != -1)
        {
            out.write(c);
        }
    }
    catch (IOException e)
    {
        throw new ServiceException("Can't copy file!",e);
    }
}
```

This example **copies a file from one location to another**.

The process involves:
* Opening a `FileInputStream` for the source file (the file you want to copy).
* Opening a `FileOutputStream` for the destination file (the location where you want the copy to be).
* Reading bytes from the `FileInputStream` and writing those bytes to the `FileOutputStream`.
* Closing both streams to release the resources.

The `FileInputStream` and `FileOutputStream` are declared and instantiated within 
the **try-with-resources** statement. This ensures that each of these resources is 
closed as soon as the try block is exited, whether the exit is due to successful 
completion or because of an exception.


## Character Streams

The Java platform stores character values using **Unicode** conventions. Character stream 
I/O automatically translates this internal format to and from the local character set.

I/O with character streams is no more complicated than I/O with byte streams. 

All character stream classes are derived from `Reader` and `Writer`. As with byte streams, 
there are character stream classes that specialize in file I/O: **FileReader** and **FileWriter**.

_Example_: Text file copy using `FileReader` and `FileWriter`.
```Java
	public void textFileCopy(String sourceFile, String destFile)
	{
		try (FileReader in = new FileReader(sourceFile);
			 FileWriter out = new FileWriter(destFile))
		{
			int c;
			while ((c = in.read()) != -1)
			{
				out.write(c);
			}
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy text file!",e);
		}
	}
```

Character streams are often "wrappers" for byte streams. 
The character stream uses the byte stream to perform the physical I/O, while the character stream handles 
translation between characters and bytes. `FileReader`, for example, uses `FileInputStream`, while
`FileWriter` uses `FileOutputStream`.

## Line-Oriented I/O

Character I/O usually occurs in bigger units than single characters. 
One common unit is the line: **a string of characters with a line terminator at the end**. 
A line terminator can be a carriage-return/line-feed sequence `"\r\n"`, a single carriage-return `"\r"`, 
or a single line-feed `"\n"`.

_Example_: Text file copy line by line using `BufferedReader` and `PrintWriter`.
```Java
	public void textFileCopyLineByLine(String sourceFile, String destFile)
	{
		try (BufferedReader in = new BufferedReader(new FileReader(sourceFile));
			 PrintWriter  out = new PrintWriter(new FileWriter(destFile)))
		{
			String line;
			while ((line = in.readLine()) != null)
			{
				out.println(line);
			}
		}
		catch (IOException e)
		{
			throw new ServiceException("Can't copy text file!",e);
		}
	}
```

Invoking `readLine()` returns a line of text with the line.

### Buffered Streams 

The Java platform implements buffered I/O streams: 
* **Buffered input streams** read data from a memory area known as a buffer; the native input API is called only 
    when the buffer is empty.
* **Buffered output streams** write data to a buffer, and the native output API is called only when the buffer is full.

A program can convert an unbuffered stream into a buffered stream using the **wrapping** idiom, where 
**the unbuffered stream object is passed to the constructor for a buffered stream class**. 

Here's how we might modify the constructor invocations to use buffered I/O:
```Java
	inputStream = new BufferedReader(new FileReader(sourceFile));
	outputStream = new BufferedWriter(new FileWriter(destFile));
```

There are four buffered stream classes used to wrap unbuffered streams: `BufferedInputStream` and 
`BufferedOutputStream` create buffered byte streams, while `BufferedReader` and `BufferedWriter` 
create buffered character streams.

It often makes sense to write out a buffer at critical points, without waiting for it to fill. 
This is known as **flushing the buffer**.

To flush a stream manually, invoke its `flush()` method. The `flush()` method is valid on any output 
stream, but has no effect unless the stream is buffered.

### Formatting

Stream objects that implement formatting are instances of either `PrintWriter`, a character stream 
class, or `PrintStream`, a byte stream class.

We commonly use: `System.out` and `System.err`

When we need to create a formatted output stream, we instantiate `PrintWriter`, not `PrintStream`s.

Like all byte and character stream objects, instances of `PrintStream` and `PrintWriter` implement 
a standard set of write methods for simple byte and character output. In addition, both `PrintStream` 
and `PrintWriter` implement the same set of methods for converting internal data into formatted output:

* `print()` and `println()` format individual values in a standard way.
* `format()` formats almost any number of values based on a format string, with many options 
	for precise formatting.

_Example_: `format()` method
```Java
	System.out.format("Data: %03d,%4.2f,\"%s\"", i, pi, name);
```

The `format()` method formats multiple arguments based on a **format string**. The format string 
consists of static text embedded with format specifiers; except for the format specifiers, the 
format string is output unchanged.



## References

* [The Java™ Tutorials: I/O Streams](https://docs.oracle.com/javase/tutorial/essential/io/streams.html)

* [Java API: Class FileInputStream](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/FileInputStream.html)
* [Java API: Class FileOutoutStream](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/FileOutputStream.html)

* [Java API: FileReader](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/FileReader.html)
* [Java API: FileWriter](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/FileWriter.html)
* [Java API: BufferedReader](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/BufferedReader.html)
* [Java API: PrintWriter](https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/io/PrintWriter.html)

*Egon Teiniker, 2024, GPL v3.0*