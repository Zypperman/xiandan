# Basics (Java)

## Commenting and imports

```Java
// Single-line comments start with //

/*
Multi-line comments look like this.
*/
```

### JavaDocs

```Java
/**
 * JavaDoc comments look like this. Used to describe the Class or various
 * attributes of a Class.
 * Main attributes:
 *
 * @author         Name (and contact information such as email) of author(s).
 * @version     Current version of the program.
 * @since        When this part of the program was first added.
 * @param         For describing the different parameters for a method.
 * @return        For describing what the method returns.
 * @deprecated  For showing the code is outdated or shouldn't be used.
 * @see         Links to another part of documentation.
*/
```

### Package import declaration

find base packages on the [Oracle Java SE overview page of the docs](https://docs.oracle.com/en/java/javase/11/docs/api/).

```Java
// Import ArrayList class inside of the java.util package
import java.util.ArrayList;
// Import all classes inside of java.security package
import java.security.*;
// Java to illustrate calling of static members and methods without calling classname
import static java.lang.Math.*;
import static java.lang.System.*;
```

## Orientation (boilerplates)

- 1 big Class per file, name your first program and create a class in it with the same name:

    ```java
    /*file named foobar.java*/

    class foobar{
        public static void main(String[] args){

        }
    }
    
    ```

- The program class checks for a main method to run:

   ```java
   public static void main(String[] args){
        System.out.println("Hello World");
   }
   ```

    - Breakdown of what all those keywords mean: [G4G](https://www.geeksforgeeks.org/java-main-method-public-static-void-main-string-args/)

## Exploring documentation

- just refer to oracle, make sure to check SE, not JDK.
    - SE &#8212; Standard Edition
    - the JDK documentation is what you need for documentation for improving the language. the SE documentation is what developers use for apps.
- most of what beginners need can be found in the java.base module.
    <div><img src='..\..\source\Java\videoframe_79167.png' alt="bruh skelly"></div>
- This brings you to a page of packages with useful fleshed out classes like:
    - io
    - time
- Javadocs are structured as:
    - classes
    - enums
    - exceptions
- if unsure which package you need, just click "all classes" and search from there.
- each class also has a tab in its docs page called "USE" to see where it exists in other packages.

## variable declaration

## printing to terminal

- `System.out.println(<str_arg>);` &#8212; prints str_arg in the terminal.

## Sources

- IBM Developer &#8212; ["Overview of the Java API documentation and how to use it"](https://youtu.be/ULEOb8wLa_k?si=iBf3RzN2wcjt3WZc)
