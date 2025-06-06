# Go Syntax Reference (and mainly how to transtion from python)

Because theres multiple ways of doing the same thing but keeping track is getting dizzy for me so I'll just write it down.

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

## concatonating strings

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

## Arrays and Slices

Arrays:

- Fixed size on declaration with syntax `var var_name [size]elem_type`
    - array elements should all have the same type
- array element-wise asssignment by index works with  <br>`array[index] = value`
- array length &#8594; `len(array)`

Slicing is how we handle dynamic array sizes.

- Use
    - considered an array abstraction
    - can also be used to define sub-arrays
    - index based and have size, but can be resized as needed
- Syntax
    - Declaration: `var var_name []elem_type{}` (don't declare a static size)
        - shorthand: `var_name := []elem_type{}`
        - n-dimensional arrays: `{var_name := [][]elem_type{}` (repeat as many square brackets as needed)
    - Adding elements: `append(arr,elem)`

## Loops

- Only For loops exist. No while, no do-while, for-each.
- Syntax:
    - `for {code block}` &#8594; functionally acts as your while loop.
        - exit program with `ctrl+c`.
        - actually works like `for(;;)` from C
    - `for index_var_name, element_var_name := range array_var_name` loops through an array.
        - range is a keyword that acts like `next()` in python, and just keeps serving the elements and their indexes in order.
        - works for maps as well but now its key and element.
            `for key_var_name, element_var_name := range maps_var_name`
        - if you don't need the index, you can just replace the variable name with `_`
            - termed a "Blank identifier" &#8212; Go recognises this as an explicitly unused variable that isn't used and will allocate accordingly.

- [Formal docs for reference.](https://go.dev/doc/effective_go#for)

## Maps

Functionally identical to dicts in python.

- Syntax
    - Declaration: `var var_name map[]elem_type{}` (don't declare a static size)
        - shorthand: `{var_name := []elem_type{}`
    - Adding elements: `append(arr,elem)`

## Structs (dipping your toes into OOP)

Structs sound like constructors, but aren't exactly the same. Both Bundle up data and are used for encapsulation, but constructors are for when you have more going on under the hood and you need to initialize other stuff too alongside the object.

- Also, constructors can be used for inheritance, but structs can't. Think of them like an array that can hold multiple different types of data.



## Misc stuff at runtime

- You cant make arrays with unknown sizes at runtime.
    - ie you cant cheese and do `var static_arr [int_var]type`
    - just use a slice.
    - Go's slice implementation is built with a hidden dynamically sized array (like Java's java.util.ArrayList.)


## Sources

-[learn x in y minutes](https://learnxinyminutes.com/go)
