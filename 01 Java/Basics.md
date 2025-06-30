# Basics (Java)

## Commenting

```Java
// Single-line comments start with //

/*
Multi-line comments look like this.
*/

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

## Orientation

1. name your first program and create a class in it with the same name:

    ```java
    /*file named foobar.java*/

    class foobar{
        public{

        }
    }
    
    ```

2. The program class checks for a main method to run:

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

## Sources

- IBM Developer &#8212; ["Overview of the Java API documentation and how to use it"](https://youtu.be/ULEOb8wLa_k?si=iBf3RzN2wcjt3WZc)
