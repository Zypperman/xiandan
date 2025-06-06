# Typical Go workflow

## Formalising your project

> [!note] Clarifying Concept: Modules > Packages > Scripts
> A Module contains packages.  
> A package contains scripts.

Any new project you develop should be considered a module, so it needs:

- a "main" file for running your program
- a "mod" file, that Go will check to make sure all prerequisites are there before running your program

### Physical Steps

1. Create a new folder representing your project
2. Open this folder in your Command Line (ie for windows, you can go command prompt or Powershell)
3. Turn your project folder into a module by doing `go mod init <folder_name>`
    - This generates a file, `go.mod`. This is a module.

4. create a `main.go` file for running your project.

Ultimately, your file structure should look like:

```txt
.
└── project_folder/
    ├── go.mod
    └── main.go
```

### What `go.mod` is exactly

- go.mod is a file that keeps a note of all the modules and packages your program uses (a process is termed "dependency tracking"), and makes sure what the scripts in the program use is already installed.
- The CLI command `go mod init <modl_name>` just creates a boilerplate `go.mod` file that names your module as `<modl_name>` and declares the version of Go your project uses. The `go.mod` file will look like:

    ```Go
    module modl_name

    go 1.17
    ```

## First program

Each program starts with 2 things:

1. Importing packages
2. Defining an Entry point

### 1. Importing packages

Just like C, if you didnt write it yourself, you need to get the code to do it from elsewhere, even for basic stuff like printing to console. That means to do stuff, you need to import a package and use what other people have written, or write it yourself (and turn your project folder into its own package.)

### Physical steps for 1

Your project is considered a module, and each file is a package. for developing apps, you will be making 1 package the core one and indicate that its an executable (and not just another file)

To establish the main package, declare it on your first line that you are importing packages at the start of each file:

```Go
package main

// the rest of your code goes here
```

after that, import what packages you need and format its name as a string, ie the `fmt` package thats part of Go's standard library:

```Go
package main

import "fmt"
```

> [!tip] standard library paackage Documentation
> VS code provides them as links that you can click from the editor.  
> Just hover over the import string and `ctrl+click` the hyperlink.


### 2. Defining an entry point

Marks where in your script your code actually begins. The Go language looks for the function named after the keyword `main` to figure out where your program scripts are supposed to start running.

- There should also only be 1 function named main in the entire project folder, because your program should only have 1 entry point.

### Physical steps for 2

Declare a function named `main`.

```Go
package main

import "fmt"

func main() {
    // actual code to be executed goes here.
}
```

from here, to use packages, its just like OOP where you format calls as `<package_name>.<function>`.

```Go
package main

import "fmt"

func main() {
    fmt.Println("Hello World")
}
```

## Running your program

1. First, it needs to be compiled, done with the CLI command `go run <file_name>`


## Where to find packages

- At <https://pkg.go.dev/>

## Sources

- [Getting started with Go | Go Docs](https://go.dev/doc/tutorial/getting-started#code)