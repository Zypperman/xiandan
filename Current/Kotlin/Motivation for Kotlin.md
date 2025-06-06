# Why Kotlin

> [!warning]
> Learn java. A lot of things are taught there.

### TLDR, its Java but better

- functionally similar to java, source code is compiled into byte code
- syntax is more concise
- has better language features than Java
- interoperates with existing java code
- also compiles to native code and js
    - that means it can compile to multiplatform apps ノ(⌐■_■)ノ

## Language features

- Coroutines
    - better way for writing async code
    - does this by suspending selected processes

## Use cases

- Android apps
 (and considered the preferred dev environment over java for android)

## crash course / comparison with java

Java:

   ```java
   public static void main(String[] args){
        string startingstring = "Out with the old"
        System.out.println(startingstring);
   }
   ```

Kotlin:

   ```Kotlin
   fun main() {
        var hello = "In with the new"

   }
   ```

- fewer keywords needed for a main func
- variables are inferred autoamatically, but you can specify (extending from the example) ie `var hello: String = "In with the new"`
    - Variables also can't be null unless you specify it next to the type, ie `var hello: String? = "In with the new"`
    - line breaks are significant but like python, you can force semicolons as new lines
- statically typed, but checks are only done at compilation
- OOP:

    ```Kotlin
    class thing{
        //attribute
        val name = "Jeff"

        //method
        fun yo(){
            print(name)
        }

    }
    ```

    - It also does cool new shit that java doesn't have, like modify the behaviour of a class function without inheritance

        ```Kotlin
        fun thing.do(){
            // some code
        }
        ```

- functions are also first class objects
- data classes exist for faster type devleopment
    - less boilerplate code required ie. constructors, getters and setters ie:

        ```Kotlin
        data class thing(val name:String, val age:Int)
        ```

        Yup thats it no other code required thats a type right there!
- destructuring
    - a cool thing you can do where you assign multiple values from a class to multiple variables ie:

        ```Kotlin
        val steve = User("male", 75)
        val (steve_name, steve_age) = steve
        ```

Compilating the code is just a command `kotlinc hello.kt -include-runtime -d <exec>.jar`, which creates an executable named `<exec>.jar`.

# Sources

- Fireship's Kotlin in 100s