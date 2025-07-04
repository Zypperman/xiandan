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

Also just note that source code statements are ended with `;`, same as C and C++.

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
- This brings you to a page of packages with useful fleshed out classes like:
    - io
    - time
- Javadocs are structured as:
    - classes
    - enums
    - exceptions
- if unsure which package you need, just click "all classes" and search from there.
- each class also has a tab in its docs page called "USE" to see where it exists in other packages.
- By default, `java.lang` is already imported for you.

## Variable declaration

- `<type><var_name>`  ie `int x`.

## system IO

under the system package, theres modules like `Scanner` for receiving input and `Out` for printing to terminal.

### printing to terminal

- `System.out.print(<str>)` to print without new line
- `System.out.println(<str>)` to print with new line

both methods support string in-line construction ie `<str>` can be `"Integer: " + 10 + " Double: " + 3.14 + " Boolean: " + true`.

> [!tip]
> Netbeans set up tab autocompletion for `System.out.println(<str>)` mapping from `sout`.
> you can also configure a similar one in vscode, just google.

System.out.printf("pi = %.5f", Math.PI); // => pi = 3.14159

### Receiving user input

- use the `Scanner` class by importing it with `import java.util.Scanner;`
- create a scanner object with `Scanner scanner = new Scanner(System.in);`
    - `System.in` is entered as an argument because you need to tell the `Scanner` where its reading input from
    - vary receiving input types with the class methods starting with `.next<some_type>`
        - ie `.nextLine()` to receive an entire string typed by the user.

## Primitive types

prmitive types can be found on [Geeks4Geeks](https://www.w3schools.com/java/java_data_types.asp), and on learnxinyminutes its under Variable declaration.

### `String`

- concat with `<str1> + <str2>`
    - note that since the `+` operator is used for both concatenation and addition, programmed behaviour in java is that if you add an integer to a string, the integer is converted to a string and concatonated:

        ```Java
        String x = "10";
        int y = 20;
        String z = x + y;  // z will be 1020 (a String)
        ```

### Type conversions

Done with `int value = Integer.valueOf(scanner.nextLine());`

- this also works with `Double` and `Boolean`.
    - not for Bool conversion, case-insensitive version of the text "true" is converted to `True`, the rest default to being `Talse`.

<!--- multiplication maintains as an integer, only division always returns a double.-->

### stupid formatting thing that happens with division

Division operator works differently depending on the input types:

```java
int firstInt = 3
int secondInt = 2
// when output is formatted:

// 1. an integer
int intResult = firstInt / secondInt;
System.out.println(intResult); // returns 1

// 2. a double
double doubleResult = firstInt / secondInt;
System.out.println(result);
```

### <span style='color:red'> Advanced Type conversion (widening / narrowing conversions)</span>

- note that because each unit is differently sized, you need to consider that you are upsizing or downsizing said data (and you might compress data or have extra space for it)
    - more on [W3schools](https://www.w3schools.com/java/java_type_casting.asp).

- main point of this (other than the hierarchy of whether a datatype will be widened or narrowed) is just to note whether you will be losing data or not. if you are narrowing, just note that you need to tell your complier and write your code to represent it otherwise:

```Java

// Widening data types
int myInt = 9;
double myDouble = myInt; // Automatic casting: int to double
// no potential data loss
System.out.println(myInt);      // Outputs 9
System.out.println(myDouble);   // Outputs 9.0

// Narrowing data types

double myDouble = 9.78d;
int myInt = (int) myDouble; // Manual casting: double to int
// need to note data loss is possible, but tell the compiler its fine
System.out.println(myDouble);   // Outputs 9.78
System.out.println(myInt);      // Outputs 9
```


Here's a chart of the various sizes of data for reference:

![Data type coverage](https://cdn.ttgtmedia.com/rms/onlineImages/server_side-java_primitive_types-f.png)

## Loops

```Java
for (statement 1; statement 2; statement 3) {
  // code block to be executed
}

// example
for (int i = 0; i < 5; i++) {
  System.out.println(i);
  // note: runs 4 times, 
  // cuz i=5 on the 5th iteration and 
  // the break condition is checked only 
  // before loop runs, means it exits before loop 5 is run.
}
```

statement 1: initialize variable to be tracked
statement 2: define break condition based on variable to be tracked, only checked before the iteration is run.
statement 3: define change condition after each iteration of the loop.

## Sources

- IBM Developer &#8212; ["Overview of the Java API documentation and how to use it"](https://youtu.be/ULEOb8wLa_k?si=iBf3RzN2wcjt3WZc)
