# Tagging Commits in a Local Repository

A tag is used to label and mark a specific commit in the history.
It is usually used to mark release points.
Although a tag may appear similar to branch, a tag however does not change.
It points directly to a specific commit in the history.

## Use an Existing Repository

```
$ cd sandbox/Java-Project

$ git log --pretty=oneline
5c910b97a85c966d0431ccb483f58694b1b5da81 (HEAD -> master) Changed documentation.
bd6cbfc6975debdf782a36c04f0286fb490f82b3 Changed syaHelloTo() method.
7ce04a51fd2d981ed3522703a1c67fd0445c20cd Initial import.```


## Creating Tags

First, we tag the current version of our project: *version-1.0.0*

```
$ git tag -a version-1.0.0 -m "A first working version of this project."

$ git tag
version-1.0.0
```

Make some modifications, commit them and tag the new commit.

``` 
$ code src/main/java/org/se/lab/Hello.java
Do some modifications...

$ git commit -a -m "Added some comments."

$ git tag version-2.0.0

$ git tag
version-1.0.0
version-2.0.0
```
We use tags to identify special points in the course of a project.


## Checkout Tags

The cool thing about tags is that we can reconstruct the state of the 
project for a given tag at any time.

```
$ git checkout tags/version-1.0.0

$ code src/main/java/org/se/lab/Hello.java
You will see the old version of this file.
```

```
$ git checkout tags/version-2.0.0

$ code src/main/java/org/se/lab/Hello.java 
You will see the new version of this file again.
```


## Tag an Older Commit

We can also tag commits after we have moved past them.

```
$ git log --pretty=oneline
5c910b97a85c966d0431ccb483f58694b1b5da81 (HEAD -> master) Changed documentation.
bd6cbfc6975debdf782a36c04f0286fb490f82b3 Changed syaHelloTo() method.
7ce04a51fd2d981ed3522703a1c67fd0445c20cd Initial import.
$ git tag -a version-Initial 7ce04a51fd2d981ed3522703a1c67fd0445c20cd -m "First version."

$ git tag
version-1.0.0
version-2.0.0
version-Initial
```

```
$ git checkout tags/version-Initial

$ code src/main/java/org/se/lab/Hello.java
You will see the first version of this project.
```
 
 
## Go Back to the Master Branch

```
$ git checkout master
Switched to branch 'master'

$ git status
On branch master
nothing to commit, working directory clean
```

## References
* [Pro Git Book](https://git-scm.com/book/en/v2)

*Egon Teiniker, 2024, GPL v3.0*
