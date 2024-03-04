# API Documentation

A larger software system will be decomposed into smaller sub-systems.
In the same way we hide information within objects by using private fields and 
methods we can also hide implementation classed within packages:

```
org.se.lab
	Stack		// public interface 		(API)
	StackImpl	// package-private class 	(implementation)
	Node		// package-private class 	(implementation)	
```

We can change the whole implementation of a subsystem as long as we don't touch 
the public API.

From a client's perspective, the API documentation defines the contract between 
the subsystem and itself. 
As a rule of thumb: It should be possible to implement proper JUnit tests for a 
subsystem based on its API documentation. 


_Example_: Generate JavaDoc from a given source code

```
$ javadoc -d doc src/main/java/org/se/lab/*

URL: doc/org/se/lab/package-summary.html
```


## References
* [Javadoc Tool](http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html)

*Egon Teiniker, 2024, GPL v3.0*