# Git Setup


Git is a **distributed version control system** designed to handle everything from 
small to very large projects with speed and efficiency. It allows multiple developers 
to work on a shared codebase simultaneously, enabling them to track changes, revert 
to previous states, and branch off for experimental features without affecting the 
main project. 

Git's distributed nature means that every developer has a complete copy of the repository, 
including its history, enabling work even when offline and providing robust data integrity 
and backup capabilities.

## Install Git Client

Depending on the operating system you are using, you can easily install the Git client 
using the following instructions.

### Windowds

* Download [git for Windows](https://gitforwindows.org/)
* Run installer: `Git-2.44.0-64-bit.exe`

```
> git --version
git version 2.44.0.windows.1
```

## Linux

```
$ sudo apt install git 

$ git --version
git version 2.44.0

```

## Git Settings 
Before we start working with git, we need to make some settings. 
These settings have to be **made once** and then apply to **all repositories on the local machine**.

We need to configure our **name**, **email address** and **default editor** (eg: VS Code). 
In addition, we set the git client to insert the **line break** correctly, 
depending on the operating system.
```
	$ git config --global user.name "Homer Simpson"
	$ git config --global user.email "homer.simpson@powerplant.com"
	$ git config --global core.editor "code --wait"
	$ git config --global core.autocrlf input	// true for windows
```

All these settings are stored in a file called `.gitconfig` in the home directory and can 
be looked up there.
```
	$ cat .gitconfig
	[user]
		name = Homer Simpson
		email = homer.simpson@powerplant.com
	[pull]
		rebase = false
	[core]
		editor = code --wait
```

## References
* [YouTube: Git Tutorial for Beginners: Learn Git in 1 Hour](https://youtu.be/8JJ101D3knE)

*Egon Teiniker, 2024, GPL v3.0*

