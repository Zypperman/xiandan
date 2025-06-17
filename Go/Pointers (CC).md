# Pointers Crash Course

## Motivation

From Go, when we try to get user input entering the variable name as an argument, Go doesn't wait for user input like intended.

Thats because its expecting a pointer.  

- quickfix is to modify our argument from a variable to its pointer:
    `fmt.Scan(userName)` &#8594; `fmt.Scan(&userName)`  
    (an `&` before the variable name)
    - Passing the variable name directly is like doing:  
        `fmt.Scan("")` &#8594; its pointing to nothing
    - But if you pass the variable containing the memory address:
        `fmt.Scan(0x7ffa....)` &#8594; Go knows where in memory to edit since you passed the memory address as an argument.

## Defining Pointers

When variables are created and assigned, their content is stored in at a specific memory address, like a table, and your program just allocates values to a specific memory address when variables are assigned.  

Think of it as a key value pair, for `x = 1`:

- the actual value as the value (1)
- the memory address as the key to find the value (some address for x)

Pointers, are variables who have a value equal to this memory address for that value, and now ie `y = &x`:

- the memory address of another value is the value (some address for x)
- the memory address of our new variable is they key (some address for y)

![pointer diagram](https://media.geeksforgeeks.org/wp-content/uploads/pointers-in-c.png)

| variable name (in Go) | value | memory address |
| ----------- |-- | --|
| x | 10 | memory address where x's value is stored|
| &x | memory address where x's value is stored | memory address where x's memory address is stored as a value |

The memory address's value is termed a "hash".

## Go specific terminology

Pointers are considered <u>special variables</u>.

- Its more a concept more prominent in C and C++. Java and JS don't really want users to mess with it.

> [!note] C vs Go syntax
> For C:
>
> - refer to a variable as a pointer using an asterisk (`x` &#8594; `*x`)
> - refer to the memory address of another variable using `&` (`&x`)
>
>```C
>int myAge = 43; // an int variable
>int* ptr1 = &myAge;  // A pointer variable, with the name ptr, that stores the address >of myAge
>int *ptr2 = &myAge; // functionally the same syntax, this is preferred
>
>// also note that the pointer's type must be the same as the pointer.
>
>// Output the value of myAge (43)
>printf("%d\n", myAge); // termed dereferencing / indirecting
>
>// Output the memory address of myAge (0x7ffe5367e044)
>printf("%p\n", &myAge);
>
>// Output the memory address of myAge with the pointer (0x7ffe5367e044)
>printf("%p\n", ptr);
>```
>
>For Go, related pointer syntax is just:
>
>```Go
>var p *int // p is a pointer for an integer variable, zero-value is nil.
>var i int
>
>i = 42
>p = &x // example assignment
>
>fmt.Println(*p) // read i through the pointer p, automatically dereferenced
>*p = 21         // set i through the pointer p -> "whatever p points to, mutate it"
>fmt.Println(i)  // see the new value of i, updated to 21
>```

## Pointers and arrays

- random thing, memory addresses in a block are each 4 bytes per slot, seen via this piece of code:

```C
int myNumbers[4] = {25, 50, 75, 100};
int i;

for (i = 0; i < 4; i++) {
  printf("%p\n", &myNumbers[i]);
}

/*
0x7ffe70f9d8f0
0x7ffe70f9d8f4
0x7ffe70f9d8f8
0x7ffe70f9d8fc
note how each increments by 4 on a hexadecimal scale (which goes 
from 0 to 16, where 10 to 16 are represented by letters a through f)
but note this is only for the integer type. Varies with other types.
*/
```

- also, the name of an array, is actually a pointer to the first element of the array in C, so you can literally just do:
    - `*arr_var` and get the value of `arr_var[0]`
    - `*(arr_var+n)` and get a value of `arr_var[n-1]`
    - working with pointers like this makes more sense if your arrays are huge.

```C
int myNumbers[4] = {25, 50, 75, 100};

// Get the memory address of the myNumbers array
printf("%p\n", myNumbers);

// Get the memory address of the first array element
printf("%p\n", &myNumbers[0]);

// Get the value of the first element in myNumbers
printf("%d", *myNumbers); // prints 25

// Get the value of the third element in myNumbers
printf("%d", *(myNumbers + 2));

/*prints:
0x7ffe70f9d8f0
0x7ffe70f9d8f0
*/
```

### Interpreting declarations together with pointers

how to read `int (*(*x)[])()`:

1. start reading from the identifier out
2. favor [ ] and ( ) over *
    - [] refers to arrays
    - () refers to the contents
    - - just marks the whole thing as a pointer

- Following rule #1, we start at x
    - `x`
- The identifier x is alone in parentheses with an asterisk, so it is [§1] a pointer
    - `*x`
- Outside of the parentheses, we follow rule #2, so it is [§2] an array
    - `(*x)[]`
- We're left with an asterisk inside the parentheses, so [§3] pointers
    - `*(*x)[ ]`
- Outside of the parentheses, rule #2 applies so [§4] function
    - `(*(*x)[ ])( )`
- The functions return [§5] int
putting §1, §2, §3, §4 and §5 together:  
        x is (§1) a pointer to (§2) an array of (§3) pointers to (§4) functions that return (§5) an integer

Once you got the hang of it, you can rewrite the example like:  
`* [] * () ->  int`  
And stitch things together in a way that makes sense. "->" means "returns" and it's optional/redundant (anything immediately after parentheses in this notation is a return anyway)

Take the example of:  
`[] ** (*char,* (*char) ->* int) -> [ ] *(* *char,* ( ) -> *char) ->* int`

Array of pointers to a pointer to a function that takes (a pointer to a character and a pointer to a function that takes (a pointer to a character) and returns a pointer to an integer) and returns an array of pointers to a function that takes (a pointer to a pointer to a character and a pointer to a function that returns a pointer to a character) and returns a pointer to an integer

It looks insane, but it's not that difficult to wrap your head around if you're writing it following those two simple rules.

### Function pointers

they store the address of a function and treat it like a first class citizen.
example: `void (*x)(char*)`

so to assign this function to anything, we need to declare the type of the variable thats meant to store it, formatting as:

`return_type (*pointer_name)(parameter_types);`

and we initialize this variable by referencing the function with `&func_name`.

- just note that the return type has to be something, but the parameter types can be empty (meaning this function we assigned as a variable just doesnt take in aything)

### Quick tangent: string declaration, `char *s` vs `char s[]`

from [stack overflow](https://stackoverflow.com/a/1704433):

`char *s = "Hello world";`

will place "Hello world" in the read-only parts of the memory, and making s a pointer to that makes any writing operation on this memory illegal.

While doing:

`char s[] = "Hello world";`

puts the literal string in read-only memory and copies the string to newly allocated memory on the stack. Thus making

`s[0] = 'J';`

legal.

---

*x() is a very short declaration method that equates to x being a function that returns a pointer.

so to declare in short form:

- x[] -> is an array
    - x[n] -> is an array of length n
- type_name x() -> is a function
- adding `*` before:
    - a variable name makes it a pointer
    - an array like `*x[]` makes it an array of pointers
    - an array like `*(x[])` makes it a pointer to an array
    - `*(x)()` means its a pointer to a function
- adding `*` behind:
    - a type makes that variable a pointer that can take that type (ie. `char* x`)


## Other sources

- <https://youtu.be/DTxHyVn0ODg?si=a3dEqo0PCFUue2BA>
- <https://youtu.be/2ybLD6_2gKM?si=O5wL8t6g1iV9nEuV>
- <https://youtu.be/3WsEDZRif6U?si=oUaooMYSJtz7HfT7>

- Weak pointers: <https://youtu.be/4E4IPB5cstw?si=Hu5xY_pyCPHdopeK>