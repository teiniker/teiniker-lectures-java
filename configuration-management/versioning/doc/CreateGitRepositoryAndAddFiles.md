# Create a Local Git Repository and Add Files

In this example we create a local Git repository and save a C 
project in it.

## Create a simple C project

```
$ mkdir -p sandbox/Java-Project
$ cd sandbox/Java-Project
```

First, we implement a simple Java file called "Hello.java":
```
$ mkdir src/main/java/org/se/lab
$ code src/main/java/org/se/lab/Hello.java
```

```Java
package org.se.lab;

public class Hello
{
    public int sayHelloTo(String name)
    {
        String msg = "Hello " + name + "!";
        int result = msg.length();
        System.out.println(msg);
        return result;
    }
}
```

Also, let's create a `README.md` file:
```
# README

This is just a simple markdown file which will be:
* created
* committed 
* and finally removed
```

We compile the Java file into an execuable:
```
$ javac -d target/classes src/main/java/org/se/lab/Hello.java 

$ tree
├── src
│   └── main
│       └── java
│           └── org
│               └── se
│                   └── lab
│                       └── Hello.java
└── target
    └── classes
        └── org
            └── se
                └── lab
                    └── Hello.class
```

Well done. Now we have a very simple Java project which we can put into a
Git repository.


## Create a Git repository

We create the Git repository within our Java project directory: 
```
$ git init
Initialized empty Git repository in sandbox/Java-Project/.git/

$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        src/
        target/

nothing added to commit but untracked files present (use "git add" to track)
```
	
## Add the Java files to the repository

We have to tell Git which files should not be managed by providing a
**.gitignore** file:
```
$ code .gitignore
# Files ignored by Git:
/target/
```


```
$ git add .gitignore 
$ git add src/main/java/org/se/lab/Hello.java README.md 

$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   .gitignore
        new file:   src/main/java/org/se/lab/Hello.java
```


Finally, we commit all files which are in the staging area:
```
$ git commit -m "Initial import."
[master (root-commit) 7ce04a5] Initial import.
 2 files changed, 13 insertions(+)
 create mode 100644 .gitignore
 create mode 100644 src/main/java/org/se/lab/Hello.java

$ git status
On branch master
nothing to commit, working tree clean
```

## References
* [Pro Git Book](https://git-scm.com/book/en/v2)

*Egon Teiniker, 2024, GPL v3.0*
