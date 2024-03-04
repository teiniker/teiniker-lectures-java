# Rename Files in a Git Project

There are two ways to rename files in the working directory and in the repository. A two-step one in which the file in the working directory is first renamed or the direct command using the git mv.

## Rename files in the working directory

First we rename the file in the working directory.

```
$ mv README.md doc.md 
$ ll
-rw-r--r-- 1 student student   29 Mar  4 11:44 doc.md
drwxr-xr-x 3 student student 4096 Mar  4 11:04 src
drwxr-xr-x 3 student student 4096 Mar  4 11:06 target

$ git status
On branch master
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    README.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        doc.md
```

Renaming a file in the working directory causes git to delete a file with the old name 
and add a file with the new name. As soon as both files are in the staging area, git 
recognizes the renaming:

```
$ git add README.md doc.md

$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	renamed:    README.md -> doc.md
```

A `git commit` completes this operation:
```
$ git commit -m "Renamed documentation file."
[master 01b38a6] Renamed documentation file.
 1 file changed, 0 insertions(+), 0 deletions(-)
 rename README.md => doc.md (100%)
```

## Rename files using git

There is also a direct way that renames files in both the working directory and the repository:
```
$ git mv README.md doc.md 

$ ll
-rw-r--r-- 1 student student   29 Mar  4 11:44 doc.md
drwxr-xr-x 3 student student 4096 Mar  4 11:04 src
drwxr-xr-x 3 student student 4096 Mar  4 11:06 target

$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        renamed:    README.md -> doc.md
```

Again, `git commit` completes the operation:
```
$ git commit -m "Renamed documentation file."
[master 01b38a6] Renamed documentation file.
 1 file changed, 0 insertions(+), 0 deletions(-)
 rename README.md => doc.md (100%)
```

## References
* [Pro Git Book](https://git-scm.com/book/en/v2)

*Egon Teiniker, 2024, GPL v3.0*
