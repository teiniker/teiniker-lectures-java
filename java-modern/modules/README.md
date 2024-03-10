# Java Platform Module System (JPMS)

Java 9 introduces a new level of abstraction above packages, known as the Java Platform 
Module System (JPMS).

**A Module is a group of closely related packages and resources along with a new module 
descriptor file. It's a “package of Java Packages” abstraction**.

The code is organized internally in packages which are used to determine what code is 
publicly accessible outside of the module.
With modules, we can also ship resources like images and XML files with the module that 
needs it.

There are four Types of Modules:

* **System Modules**: These are the modules included in the Java SE and JDK:  
    ```
    $ java --list-modules
    ```

* **Application Modules**: These modules are what we usually want to build when 
    we decide to use Modules. They are named and defined in the compiled `module-info.class` 
    file included in the assembled JAR.

* **Automatic Modules**: We can include unofficial modules by adding existing JAR files 
    to the module path. The name of the module will be derived from the name of the JAR. 
    Automatic modules will have full read access to every other module loaded by the path.

* **Unnamed Modules**: When a class or JAR is loaded onto the `CLASSPATH`, but not the module 
    path, it's automatically added to the unnamed module. It's a catch-all module to maintain 
    backward compatibility with previously-written Java code.

_Example_: Module **java.se** defines the [API of Java SE](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)

![Java SE Modules](figures/JavaSEModules.png)

Modules can be distributed one of two ways: 
* As a JAR file 
* As an _exploded_ compiled project

A multi-module project can be created by combining a main application and 
several library modules.

**There can only be one module per JAR file**.
When setting up a build file, we need to make sure to bundle each module in 
our project as a separate JAR.

