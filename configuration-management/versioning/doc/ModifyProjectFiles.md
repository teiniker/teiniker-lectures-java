# Modify Files in a Repository

In this example we modify files in a project that is versioned with Git.

## Modify a file and undo changes 

We start by modifying a file from the versioned project.
```
$ code src/main/java/org/se/lab/Hello.java
```
We make some modifications...

```Java
   public int sayHelloTo(String name)
    {
        String msg = "Welcome " + name + "!";
        int result = msg.length();
        System.out.println(msg);
        return result;
    }
```

Always, we can use *git status* to find files which have been changed.
```
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   src/main/java/org/se/lab/Hello.java

$ git status -s
 M src/main/java/org/se/lab/Hello.java
```

Also, we can compare the content of files to the version stored in the
Git repository:

```
$ git diff src/main/java/org/se/lab/Hello.java
diff --git a/src/main/java/org/se/lab/Hello.java b/src/main/java/org/se/lab/Hello.java
index 5c5f288..69db5e8 100644
--- a/src/main/java/org/se/lab/Hello.java
+++ b/src/main/java/org/se/lab/Hello.java
@@ -4,9 +4,11 @@ public class Hello
 {
     public int sayHelloTo(String name)
     {
-        String msg = "Hello " + name + "!";
+        String msg = "Welcome " + name + "!";
         int result = msg.length();
         System.out.println(msg);
         return result;
     }
 }
```

If we made some mistakes, we can easily **go back to the version stored 
in the repository**.
```
$ git src/main/java/org/se/lab/Hello.java

$ git status
On branch master
nothing to commit, working directory clean
```

Note that these features, making a diff or even going back to the 
version we committed into the repostory is a huge benefit for developers.


## Modify a file and commit changes 

On the other hand, most changes we make to files are saved in the Git 
repository.

Again, we modify a file from the versioned project.
```
$ code src/main/java/org/se/lab/Hello.java
```

```Java
   public int sayHelloTo(String name)
    {
        String msg = "Welcome " + name + "!";
        int result = msg.length();
        System.out.println(msg);
        return result;
    }
```
```
$ git status -s
 M src/main/java/org/se/lab/Hello.java
```

In order to transfer all changes to the project files to the repository, 
they must be committed.
```
$ git commit -a -m "Changed syaHelloTo() method."
[master e49dba4] Changed syaHelloTo() method.
 1 file changed, 3 insertions(+), 1 deletion(-)

$ git status
On branch master
nothing to commit, working directory clean
```

## Review all commits

We can print the **history of all commits** in the repository:

```
$ git log
commit e49dba43e889b0f4667be945d18a5a171d7f1464 (HEAD -> master)
Author: teiniker <egon.teiniker@fh-joanneum.at>
Date:   Mon Mar 4 11:41:27 2024 +0100

    Changed syaHelloTo() method.

commit 7ce04a51fd2d981ed3522703a1c67fd0445c20cd
Author: teiniker <egon.teiniker@fh-joanneum.at>
Date:   Mon Mar 4 11:11:35 2024 +0100

    Initial import.
```

We can also use a **single line log format**.
```    
$ git log --oneline
e49dba4 (HEAD -> master) Changed syaHelloTo() method.
7ce04a5 Initial import.
```

## References
* [Pro Git Book](https://git-scm.com/book/en/v2)

*Egon Teiniker, 2024, GPL v3.0*
