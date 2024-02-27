# Building Java Projects 


## Project Layout 

Maven and Gradle both follow the convention over configuration principle and have 
similar default directory structures. 

* **src/main/java**: Application/Library source code
* **src/main/resources**: Application/Library resources (configuration files, etc.)
* **src/test/java**: Test source code
* **src/test/resources**: Test resources

* Maven uses an XML file **pom.xml** for build configuration.

* Maven uses the **target** directory as the default build folder. 
    This is where Maven stores all its outputs including compiled classes, 
    processed resources, and the final packaged artifact (e.g., JAR, WAR).

* Gradle uses a Groovy-based DSL (or Kotlin for Kotlin DSL) for configuration, 
    which is defined in a **build.gradle** (or **build.gradle.kts** for Kotlin DSL) file.

* Gradle uses the **build** directory as the default build folder. Similar to Maven's 
    `target`, Gradle's build directory contains compiled classes, processed resources, 
    and the final packaged artifacts.


## Maven 



## Gradle
