# Java Collections

> A collection is simply an object that groups multiple elements into a single unit. 
> Collections are used to store, retrieve, manipulate, and communicate aggregate data. 

A **collections framework** is a unified architecture for representing and manipulating 
collections. All collections frameworks contain the following:

* **Interfaces**: These are abstract data types that represent collections. Interfaces 
    allow collections to be manipulated independently of the details of their representation. 
    In object-oriented languages, interfaces generally form a hierarchy.

* **Implementations**: These are the concrete implementations of the collection interfaces. 
    In essence, they are reusable data structures.

## Interfaces

The core collection interfaces encapsulate different types of collections.
These interfaces allow collections to be manipulated independently of the details of their representation.

![Collections Interfaces](figures/Collections-Interfaces.gif)

A `Set` is a special kind of `Collection`, a `SortedSet` is a special kind of `Set`, and so forth. 
Note also that the hierarchy consists of two distinct trees — a `Map` is not a true `Collection`.

Note that all the core **collection interfaces are generic**. 

The following list describes the core collection interfaces:

* [**Collection**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html): 
    The root of the collection hierarchy. A collection represents a group of objects 
    known as its elements. The Collection interface is the least common denominator that all collections 
    implement and is used to pass collections around and to manipulate them when maximum generality is 
    desired. Some types of collections allow duplicate elements, and others do not. 
    Some are ordered and others are unordered. **The Java platform doesn't provide any direct implementations** 
    of this interface but provides implementations of more specific subinterfaces, such as Set and List. 
    
* [**Set**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html): 
    A collection that **cannot contain duplicate elements**. This interface models the mathematical set 
    abstraction and is used to represent sets, such as the cards comprising a poker hand, the courses 
    making up a student's schedule, or the processes running on a machine. 

* [**List**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/List.html): 
    An ordered collection (sometimes called a **sequence**). Lists can contain duplicate elements. 
    The user of a List generally has precise control over where in the list each element is inserted and 
    can **access elements by their integer index** (zero-based). 

* [**Queue**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html): 
    A collection used to hold multiple elements prior to processing. Besides basic Collection operations, 
    a Queue provides additional insertion, extraction, and inspection operations.
    Queues typically, but do not necessarily, order elements in a **FIFO (first-in, first-out)** manner. 
    Among the exceptions are priority queues, which order elements according to a supplied comparator 
    or the elements' natural ordering. Whatever the ordering used, the head of the queue is the element 
    that would be removed by a call to remove or poll. In a FIFO queue, all new elements are inserted at 
    the tail of the queue. Other kinds of queues may use different placement rules. 
    Every Queue implementation must specify its ordering properties. 

* [**Deque**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html): 
    A collection used to hold multiple elements prior to processing. Besides basic Collection operations, 
    a Deque provides additional insertion, extraction, and inspection operations.
    Deques can be used both as **FIFO (first-in, first-out) and LIFO (last-in, first-out)**. 
    In a deque all new elements can be inserted, retrieved and removed at both ends. 

* [**Map**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html): 
    An object that **maps keys to values**. A Map **cannot contain duplicate keys**; each key can map to at
    most one value. If you've used Hashtable, you're already familiar with the basics of Map. 

The last two core collection interfaces are merely sorted versions of Set and Map:

* [**SortedSet**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/SortedSet.html): 
    A Set that maintains its **elements in ascending order**. Several additional operations are provided 
    to take advantage of the ordering. Sorted sets are used for naturally ordered sets, such as word lists
     and membership rolls. 

* [**SortedMap**](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/SortedMap.html): 
    A Map that maintains its **mappings in ascending key order**. This is the Map analog 
    of SortedSet. Sorted maps are used for naturally ordered collections of key/value pairs, such as 
    dictionaries and telephone directories. 

## Implementations

Implementations are the **data objects used to store collections**, which implement the interfaces described 
in the Interfaces section.

The Java Collections Framework provides several **general-purpose implementations** of the `Set`, `List`, and `Map` interfaces.

Each of the general-purpose implementations provides all optional operations contained in 
its interface. **All permit null elements, keys, and values**. 
**None are synchronized (thread-safe)**. **All have fail-fast iterators**, which detect 
illegal concurrent modification during iteration and fail quickly and cleanly rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future. 
**All are Serializable** and **all support a public clone method**.

* There are three general-purpose **Set implementations**: **HashSet**, **TreeSet**, and **LinkedHashSet**.

    `HashSet` is much faster than `TreeSet` (constant-time versus log-time for most operations)
    but offers no ordering guarantees. If you need to use the operations in the `SortedSet` interface, or if value-ordered iteration is required, use `TreeSet`; otherwise, use `HashSet`. It's a fair bet that you'll end up using `HashSet` most of the time.

    `LinkedHashSet` is in some sense intermediate between `HashSet` and `TreeSet`. 
    Implemented as a hash table with a linked list running through it, it provides insertion-ordered iteration (least recently inserted to most recently) and runs 
    nearly as fast as `HashSet`. 

* There are two general-purpose **List implementations**: **ArrayList** and **LinkedList**.

    Most of the time, we will probably use `ArrayList`, which offers constant-time positional
    access and is just plain fast. It does not have to allocate a node object for each element
    in the `List`, and it can take advantage of `System.arraycopy` when it has to move multiple
    elements at the same time.
    `ArrayList` has one tuning parameter — the initial capacity, which refers to the number 
    of elements the `ArrayList` can hold before it has to grow.

    If you frequently add elements to the beginning of the `List` or iterate over the `List` 
    to delete elements from its interior, you should consider using `LinkedList`. These operations require constant-time in a `LinkedList` and linear-time in an `ArrayList`. 
    But we pay a big price in performance. Positional access requires linear-time in a
    `LinkedList` and constant-time in an ArrayList.     

*  General-Purpose **Queue Implementations** are: **LinkedList** implements the `Queue` interface, 
    providing first in, first out (FIFO) queue operations for add, poll, and so on.

    The **PriorityQueue** class is a priority queue based on the heap data structure. This queue orders 
    elements according to the order specified at construction time, which can be the elements' natural 
    ordering or the ordering imposed by an explicit `Comparator`.

* The general-purpose **Deque implementations** include **LinkedList** and **ArrayDeque** classes. 

    The `Deque` interface supports insertion, removal and retrieval of elements at both ends. 
    
    The `ArrayDeque` class is the resizeable array implementation of the `Deque` interface, 
    whereas the `LinkedList` class is the list implementation.

* The three general-purpose **Map implementations** are: **HashMap**, **TreeMap** and
    **LinkedHashMap**. 

    If we need `SortedMap` operations or key-ordered Collection-view iteration, use `TreeMap`;
    if we want maximum speed and don't care about iteration order, use `HashMap`; if you want near-HashMap performance and insertion-order iteration, use `LinkedHashMap`. 
    In this respect, the situation for `Map` is analogous to `Set`.


In summary, the Java Collections Framework provides several **general-purpose implementations of the core interfaces**:

* For the **Set** interface, **HashSet** is the most commonly used implementation.
* For the **List** interface, **ArrayList** is the most commonly used implementation.
* For the **Map** interface, **HashMap** is the most commonly used implementation.
* For the **Queue** interface, **LinkedList** is the most commonly used implementation.
* For the **Deque** interface, **ArrayDeque** is the most commonly used implementation.

Each of the general-purpose implementations provides all optional operations contained in its interface.


## References
* [The Java™ Tutorials: Collections](https://docs.oracle.com/javase/tutorial/collections/)

* [Baeldung: Java Collections](https://www.baeldung.com/java-collections)
* [Baeldung: Choosing the Right Java Collection](https://www.baeldung.com/java-choose-list-set-queue-map)

* Maurice Naftalin, Philip Wadler. **Java Generics and Collections**. O‘Reilly, 2006.

*Egon Teiniker, 2024, GPL v3.0*