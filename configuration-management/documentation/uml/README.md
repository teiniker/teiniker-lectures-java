# Software Modeling 

Engineers build models to find out if their design will work.

This implies that **models must be testable**. If engineers can’t evaluate the model, 
the model has no value.

Engineers investigate designs with models when the **models are much cheaper** than 
the real thing they are building.


## Unified Modeling Language

> The **Unified Modeling Language (UML)** is a family of **graphical notations**, 
> that help in **describing and designing software systems**.

UML is an open standard, controlled by the **Object Management Group (OMG)**.

Note that programming languages are not at a high enough **level of abstraction** to 
facilitate discussions about design.

UML allows **different perspectives (diagrams)** to be defined on a software system. 
All diagrams together result in the model of a software system.


### UML Diagram Types

UML 2 describes 13 diagram types which can be classified in the following way:

* **Structure Diagrams**:
    * [Class Diagram](class-diagram/README.md)
    * [Object Diagram](object-diagram/README.md)
    * Component Diagram
    * Composite Structure Diagram
    * Deployment Diagram
    * [Package Diagram](package-diagram/README.md)

* **Behavior Diagrams**:
    * [Activity Diagram](activity-diagram/README.md)
    * Use Case Diagram
    * [State Diagram](state-machine-diagram/README.md)
    * Interaction Diagrams
    * [Sequence Diagram](sequence-diagram/README.md)
    * Communication Diagram
    * Interaction Overview Diagram
    * Timing Diagram


## Effective Use of UML

Can a UML diagram be tested? 
* **No!**
* There are no firm criteria for testing a UML diagram.
* We can look at it, evaluate it, and apply principles and patterns to it, 
    but the evaluation is still very subjective.

Is a UML diagram much cheaper to create than the software it represents? 
* **No!**
* UML diagrams are less expensive to draw than software is to write, 
    but not by a huge factor.
* There are times when it is easier to change source code than it is to 
    change a diagram.

Therefore, we can not simply use UML in the way classic engineers use blueprints 
and models.

When should we use UML?
* **Communicating with others**: UML is convenient for communicating design 
    concepts among software developers.
* **Road maps**: UML can be useful for creating road maps of large software 
    structures. Such diagrams capture the knowledge that all the developers 
    must keep in their heads in order to work effectively in the system.
* **What to keep and what to throw away**: Most of the UML diagrams should 
    be short-lived. Write them on a white board, or on scraps of paper.
    The real useful diagrams will keep showing up over and over again. 
    Keep only those whose long-term survival has lots of value.


## References

* Robert C. Martin. **UML for Java Programmers**. Prentice Hall, 2003
* Martin Fowler. **UML Distilled**. Addison-Wesley, 3rd Edition 2004

