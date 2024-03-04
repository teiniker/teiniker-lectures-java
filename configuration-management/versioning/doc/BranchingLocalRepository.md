# Branching and Merging in a Local Repository


## Use an existing repository

```
$ cd sandbox/Java-Project

$ git log --pretty=oneline
5c910b97a85c966d0431ccb483f58694b1b5da81 (HEAD -> master) Changed documentation.
bd6cbfc6975debdf782a36c04f0286fb490f82b3 Changed syaHelloTo() method.
7ce04a51fd2d981ed3522703a1c67fd0445c20cd Initial import.
```


## Create a new feature in a separate branch

You can implement a new functionality in your own branch so as not to 
destroy the existing project in the master branch.

```
$ git branch new-feature

$ git branch
* master
  new-feature

$ git checkout new-feature
Switched to branch 'new-feature'

$ git branch
  master
* new-feature
```

## Implement the new feature

In our new branch we are implementing a new function *sayWelcome(String name)*.

```
$ code src/main/java/org/se/lab/Hello.java 

    public int sayWelcomeTo(String name)
    {
        String msg = "Welcome " + name + "!";
        int result = msg.length();
        System.out.println(msg);
        return result;
    }
```

```
$ git status 
Auf Branch new-feature
Änderungen, die nicht zum Commit vorgemerkt sind:
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   src/main/java/org/se/lab/Hello.java
```

We commit these changes to the local repository.
```
$ git commit -a -m "Added new function."
[new-feature 7beb16c] Added new function.
 2 files changed, 7 insertions(+), 4 deletions(-)
 delete mode 100644 README.md
 ```


## Go back to the master branch and merge changes from new-feature branch

After we have implemented and tested all new functionalities, we can 
transfer them to the master branch.

```
$ git checkout master
Switched to branch 'master'
* master
new-feature

$ git merge new-feature
Updating 5c910b9..7beb16c
Fast-forward
 src/main/java/org/se/lab/Hello.java | 8 +++++++-
 1 file changed, 7 insertions(+)
 ```

```
$ code src/main/java/org/se/lab/Hello.java 
You will see the new method in this file of the master branch.
```

So we have integrated the new feature into the master branch.


## Remove the new-feature branch

At the end we can delete the developer branch, because it is no longer 
needed.

```
$ git branch
* master
  new-feature

$ git branch -d new-feature
Deleted branch new-feature (was 7beb16c).

$ git branch
* master
```

## References
* [Pro Git Book](https://git-scm.com/book/en/v2)

*Egon Teiniker, 2024, GPL v3.0*
