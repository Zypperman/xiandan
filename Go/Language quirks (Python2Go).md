# Go Syntax Reference (and mainly how to transtion from python)

Because theres multiple ways of doing the same thing but keeping track is getting dizzy for me so I'll just write it down.

## Commenting and documentation conventions

```Go
// Single line comment
/* Multi-
 line comment */

 /* A build tag is a line comment starting with //go:build
  and can be executed by go build -tags="foo bar" command.
  Build tags are placed before the package clause near or at the top of the file
  followed by a blank line or other line comments. */
//go:build prod || dev || test
```

## Importing packages

- for multiple packages syntax is:

    ```Go
    import (
        "pack1"
        "pack2"
    )
    ```

## Variable Declaration

```Go

// 1. declare and assign in 2 separate lines
var x int // Variable declaration. Variables must be declared before use.
x = 3     // Variable assignment.

// 2. Declare and assign in 1 line
var x int, y int = 3,4

// 3. Shorthand declaration with type inference
y := 4
// note: doesn't work with constants, still need to declare type ie:
const z int

// 4. weird cool wacky shit
var (
    home   = os.Getenv("HOME")
    user   = os.Getenv("USER")
    gopath = os.Getenv("GOPATH")
)
```

>[!note] Term: Syntactic Sugar (in general programming)
> Used to refer to certain features in a language that do the same thing, but make the language easier to use.  
> An example of that is the shorthand declaration seen in point 3.

Quick Tips:

- shorthand declaration only works inside functions
    - var works both inside and outside a func
- Null types can only exist if you allow for it
    - `var x int?` &#8594; `?` token means you can allow for null values in this variable

## Variable Mutability

`const` for constants, `var` for variables.

## Types

Refer [to the Go Docs](https://www.w3schools.com/go/go_variables.php) for basic Go types.

Strings

- Strings in Go are encoded in UTF-8.
- `string` &#8212; rawstring but still considered a string, so you can include line breaks
- weird characters are stored under int32 with an prefix indicator to say its a UTF thing (termed a "[code point](https://developer.mozilla.org/en-US/docs/Glossary/Code_point)")
<!-- TODO: Check source -->

Numbers

- floats &#8212; defaults as float64, an IEEE-754 64-bit floating point number.
- also can take on complex numbers, formats as complex128, represented internally with two float64s.

Reference to Java typings:

Integers:

| Go | Java|
| ----------- |-- |
| int8 | byte |
| int16 | short |
| int32 | int |
| int64 | long |
| uint | not a Java type (I think) but represents only positive integers and 0 |

ie:

```Go
var x uint = 50
x = 1 // throws an error at compile-time / while writing code
```

Floats:

- float 32 and 64
- Complex64 and 128 represented by 2 float32s or float64s respectively

### numbers to strings

should refer to `fmt tips.md` article, but tldr use  
`fmt.Sprintf("%v",variableWithIntValue).`

- straight-conversion with String(variableWithIntValue) doesn't turn it into a string, it turns it into a rune.
    - Go will assume that your value is a unicode rune, so it'll turn it into a rune on type conversion.
        <!---TODO: Figure out why -->

## String Operations

### concatonating strings

2 ways under the the strings package:

1. Join function from the strings package to combine arrays of strings.

2. with `strings.Builder`
    - Quoting from [Setry](https://sentry.io/answers/concatenating-strings-in-go/):
        > If you wish to avoid the performance drawbacks of using fmt.Sprintf, you can use the `strings.Builder`.
        >
        > Although the `+` operator is faster than the `fmt.Sprintf` function, it isn’t the most efficient choice. Because strings are immutable in Go, every time `+` is called, Go allocates the entire resulting string to a new location in memory, which can waste time.  
        >
        >The Go `strings.Builder` minimizes memory copying, and has a nice API to boot.

        ```Go
        package main

        import "strings"

        func main() {
            address := []string{"1 Sample Apartments", "42 Example Avenue", "Model Country"}

            var b strings.Builder
            for index, value := range address {
                // Prepend with a comma and a space if it's not the first item.
                if index > 0 {
                    b.WriteString(", ")
                }

                b.WriteString(value)
            }

            print(b.String())
            // Prints "1 Sample Apartments, 42 Example Avenue, Model Country".
        }
        ```

## functions

```Go
/*
Functions can have parameters and (multiple!) return values.
Here `x`, `y` are the arguments and `sum`, `prod` is the signature (what's returned).
Note that `x` and `sum` receive the type `int`.
*/
func learnMultiple(x, y int) (sum, prod int) {
    return x + y, x * y // Return two values.
}
/*
also note that what is returned is implied by what was declared:
*/
func learnMultipleAlt(x, y int) (sum, prod int) {
    sum = x + y
    prod = x*y
    return
}
```

the `defer` keyword can be used to "deal with situations such as resources that must be released regardless of which path a function takes to return. The canonical examples are unlocking a mutex or closing a file."

- equivalent to doing `with open(filename) as f` in python, where the file reading mechanism doesn't need to be closed you don't need to remember to close it once you're done with it

### Function Closures

A closure is a function value that references variables from outside its body:

```Go
package main

import "fmt"

func adder() func(int) int {
 sum := 0
 return func(x int) int {
  sum += x
  return sum
 }
}

func main() {
 pos, neg := adder(), adder()
 for i := 0; i < 10; i++ {
  fmt.Println(
   pos(i),
   neg(-2*i),
  )
 }
}

```

- here, the function adder is a wrapper function that as a first class function, will store sum somewhere related to it thats can only be accessed when called as a function.
- The closure part of the function is the return statement which uses the `sum` which is outside the function scope when its called and used.
    - ie for each iteration, the `sum` variable's value doesn't reset to 0 after each loop.
- The function may access and assign to the referenced variables; in this sense the function is "bound" to the variables.

## Arrays and Slices

Arrays:

- Fixed size on declaration with syntax `var var_name [size]elem_type`
    - array elements should all have the same type
- array element-wise asssignment by index works with  <br>`array[index] = value`
- array length &#8594; `len(array)`

Slicing is how we handle dynamic array sizes.

- Uses
    - considered an array abstraction
    - can also be used to define sub-arrays
    - index based and have size, but can be resized as needed
- Syntax
    - Declaration: `var var_name []elem_type` (don't declare a static size)
        - shorthand: `var_name := []elem_type`
        - n-dimensional arrays: `{var_name := [][]elem_type` (repeat as many square brackets as needed)
    - Adding elements: `append(arr,elem)`

## Loops

- Only For loops exist. No while, no do-while, for-each.
- Syntax:

    ```Go
    // Like a C for
    for init; condition; post { }
    /*
    init -> the starting variable / condition to watch
    condition -> the condition for breaking the loop, loop stops if its false
    init -> any changes to the watched init variable/condition.
    */

    //example:
    for i := 0; i < 10; i++ {
    sum += i
    }

    // while-loop
    for condition { }

    // Like a C for(;;), loops forever
    for { } 
    // alt:
    for true { } 

    // loop throgh array
    for index_var_name, element_var_name := range array_var_name { }
    
    //loop through maps
    for key_var_name, element_var_name := range maps_var_nam

    ```

    - exit program / infinite loops with `ctrl+c`.
    - `range` is a keyword that acts like `next()` in python, and just keeps serving the elements and their indexes in order.
    - if you don't need the index, you can just replace the variable name with `_`
        - termed a "Blank identifier" &#8212; Go recognises this as an explicitly unused variable that isn't used and will allocate accordingly.  
    - if you don't need the value, loop can be modified into:  

        ```Go
        for key_or_index_var_name := range m {}
        ```

    - strings when treated as ranges where each character takes up 3 bytes per index position, but the characters are returned as elements.

    - `break` for exiting
    - `continue` for prompting the next iteration

- [Formal docs for reference.](https://go.dev/doc/effective_go#for)

## Control statements

Logic operatiors

- and &#8212; `&&`
- or &#8212; `||`
- operator docs found here ( [General Ops](https://go.dev/ref/spec#Arithmetic_operators) | [Arithmetic Ops](https://go.dev/ref/spec#Arithmetic_operators) )

- Syntax:

    - Go only has if-else statements, but no ternary operators.

        ```Go
        if <condition> {
        // some code
        } else {
        //contrary code
        }
        ```

        if code terminates within the block, then we don't need an else statement.

    - switch-case statements are written as functions:

        ```Go
        func switch_case_func(input_var in_type) out_type {
            // some code...
            switch {
                
            case condition_with_valid_input_var_1:
                code_block_1

            case condition_with_valid_input_var_2:
                code_block_2
            }
            // more code...
        }
        ```

### `fallthrough`

The keyword `fallthrough` allows us to execute the next case block without checking its condition. In other words, we can merge two case blocks by using the keyword fallthrough.

ie you have two blocks of code between 2 cases and the fallthrough keyword between them, if the first check is met, the second case's code block will run after the first block is done executing, even if case 2's condition isn't met.

Useful when its needed. (idk how to explain this its just niche and cool)

```Go
package main

import "fmt"

func main() {
    number := 2

    switch number {
    case 2:
        fmt.Println("Two")
        fallthrough
    case 3:
        fmt.Println("Three")
    }
}

// result:
// Two
// Three
```

Example use case:

```Go
func main() {
switch day := "Monday"; day {
case "Monday", "Tuesday", "Wednesday", "Thursday":
fmt.Println("Weekday")
fallthrough
case "Friday":
fmt.Println("Almost Weekend")
case "Saturday", "Sunday":
fmt.Println("Weekend")
}
}
```

Above code structured so that for mon to fri, both "weekday" and "almost weekend" get printed, Fri only prints "almost weekend".

## Maps

Functionally identical to dicts in python.

- Syntax
    - Declaration: `var var_name map[]elem_type{}` (don't declare a static size)
        - shorthand: `{var_name := []elem_type{}`
    - Adding elements: `append(arr,elem)`

## Goto (dangerous)

you can jump around to previous segments of your code with Goto statements, but just avoid in general cuz they suck.

## OOP related syntax

### Structs ([full docs here](https://go.dev/ref/spec#Struct_types))

Structs just bundle related data types and act as their own type.

- unlike python, arrays usually only contain 1 datatype, so this is how you let them take on more than 1 primitive type.

Since Go has no concept of classes, we use structs and methods to create them.

```Go

/* 
type keyword used for declaring new types
use caps for a Public type that you can use outside your module, lowercase for private type only used in your module
*/
type Employee struct {
    name string
    age,id int
    isRemote bool
}

// new struct
employee1 := Employee {
    name: "Alice",
    age: 24,
    id: 2,
    isRemote: true, 
}

// access struct data (proper term should be "fields")
fmt.Println("Employee name:",employee1.name)
```

(from docs)  
A field declared with a type but no explicit field name is called an embedded field. An embedded field must be specified as a type name T or as a pointer to a non-interface type name *T, and T itself may not be a pointer type or type parameter. The unqualified type name acts as the field name.
#### Anonymous Structs

At the cost of overhead for declaring your struct properly as a type, you define a quick one-time datatype. Good if you just need something quick for a function.

```Go
job1 :={
    title string
    salary float64
}{
    title: "SWE Dev"
    salary: 8000
}

// quickaccess
fmt.Println("job name:",job1.salary)

```

#### Struct Pointers

Used to add functionality for the data in a struct to be mutable:

```Go
package main

import "fmt"

type Vertex struct {
    X int 
    Y int
}

func main() {
    v := Vertex{1, 2}
    p := &v        
    p.X = 1e9      // Go understands you want to edit the struct declared in v, since you reference it..
    fmt.Println(v) // returns an edited version of v, {1000000000 2}
}

```

#### struct methods

we can create methods for our structs and call them like a method with `<struct>.<func>`:

```Go
func (param_var struct_type) funcname( param_var type) {

}

// example: struct method takes in the struct type -> value receiver
func (e Employee) updateName( newName string){
    e.name = newName
}
// example: struct method takes in the struct reference -> pointer receiver
func (e *Employee) updateName( newName string){

}
```

the content in the brackets between the `func` keyword and the function name is termed the receiver, and there are two kinds:

- if you pass in the struct itself, its termed a "value receiver"
    - the function makes a copy of the fields in the struct of the variable, and doesn't affect the variable.
- if you pass in a pointer to a struct, its termed "pointer receiver"
    - the function knows you want to edit aspects about the variable itself.
    - the function just recognises that you're not passing in the variable's value to work with, you want the work done to actually change the variable.

        ```Go
        // the same pointer receiver idea written as a normal function, taking in the variable as a parameter
            func Scale(v *Vertex, f float64) {
                v.X = v.X * f
                v.Y = v.Y * f
            }

            func main() {
                v := Vertex{3, 4}
                Scale(&v, 10)
                fmt.Println(Abs(v))
            }
        ```

    - Just note that if you write the function with a pointer receiver, even if the variable is a pointer, Go will still use the value instead of the pointer address. ([see slide 6 of Go docs](https://go.dev/tour/methods/6))

        ```Go
        var v Vertex
        v.Scale(5)  // applied on v
        p := &v
        p.Scale(10) // also applied on v
        ```

however, if you want changes to be made to the struct in the global scope, you need to pass a reference to the employee because this struct function takes in a copy of the struct and only works with its data at a local scope. Once we exit the function the updates we want to make wont be retained.

Hence:

- Value receivers usually return values. (like a static method)
- pointer receivers usually update objects. (like a class or instance method)
    - also more efficient in memory since instead of making a copy of the value to work with, you operate on the variable that alr has it stored. copying takes time.

Docs for struct methods can be found in the [tour of go](https://go.dev/tour/methods/1).

### Other OOP Related ideas with structs

- Composition &#8212; you can create structs and nest them in other structs (ie address struct in employee struct)
    - struct methods under the inner struct also work with the outer struct.
    - you can also label each struct field with tags.

### Interfaces

### Channels

## Misc stuff at runtime

- You cant make arrays with unknown sizes at runtime.
    - ie you cant cheese and do `var static_arr [int_var]type`
    - just use a slice.
    - Go's slice implementation is built with a hidden dynamically sized array (like Java's java.util.ArrayList.)

## Memory management

from learnxinyminutes:

```Go
// Go is fully garbage collected. It has pointers but no pointer arithmetic.
// You can make a mistake with a nil pointer, but not by incrementing a pointer.
// Unlike in C/Cpp taking and returning an address of a local variable is also safe.
func learnMemory() (p, q *int) {
 // Named return values p and q have type pointer to int.
 p = new(int) // Built-in function new allocates memory.
 // The allocated int slice is initialized to 0, p is no longer nil.
 s := make([]int, 20) // Allocate 20 ints as a single block of memory.
 s[3] = 7             // Assign one of them.
 r := -2              // Declare another local variable.
 return &s[3], &r     // & takes the address of an object.
}
```

## Sources

- [learn x in y minutes](https://learnxinyminutes.com/go)
- [dolthub: avoiding Go pitfalls CAA 2023](https://www.dolthub.com/blog/2023-08-16-go-pitfalls/)

- Structs in Go
    - [Flo Woelki](https://youtu.be/c8H0w4yBL10?si=5tqPHvVde-86yul0)
