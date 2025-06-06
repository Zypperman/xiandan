# Pointers Crash Course

## Motivation

From Go, when we try to get user input entering the variable name as an argument, Go doesn't wait for user input like intended.

Thats because its exepecting a pointer.  

- quickfix is to modify our argument from a variable to its pointer:
    `fmt.Scan(userName)` &#8594; `fmt.Scan(&userName)`  
    (an `&` before the variable name)
    - Passing the variable name directly is like doing:  
        `fmt.Scan("")` &#8594; its pointing to nothing
    - But if you pass the variable containing the memory address:
        `fmt.Scan(0x7ffa....)` &#8594; Go knows where in memory to edit since you passed the memory address as an argument.

## Defining Pointers

When variables are created and assigned, their content is stored in at a specific memory address.

Pointers are variables who have a value equal to this memory address for that value.

![pointer diagram](https://media.geeksforgeeks.org/wp-content/uploads/pointers-in-c.png)

| variable name (in Go) | value | memory address |
| ----------- |-- | --|
| x | 10 | memory address where x's value is stored|
| &x | memory address where x's value is stored | memory address where x's memory address is stored as a value |

The memory address's value is termed a "hash".

## Go specific terminology

Pointers are considered <u>special variables</u>.

- Its more a concept more prominent in C and C++. Java and JS don't really want users to mess with it.
