# Common constructs for most languages

## First Class functions

A function that you can treat like a variable.

- They can be:
    - assigned to variables
    - passed as arguments
    - returned from other functions

Technically speaking, we are asserting that the abstract idea of the function is the same as what we have implemented. This is termed as the broad concept of <u>reification</u>.

### Nth Class citizens

- First Class functions get their name from how theyre used to analogise the operations that they support.
    - Functions that support "all operations generally available to all entities" are first class citizens.
    - The 3 points above basically encompass what first class citizens do, plus one last one where they must be able to test for equality.
- There are second and third class definitions but theyre not really very relevant.

### Counterpart: anonymous functions

- Functions that do not have a name, typically used for convenience
    - ie. python &#8594; `lambda x: 2x` to return 2 times the input












## Sources

- [Kantan Coding](https://www.youtube.com/@kantancoding)
    - [Most Useful Constructs Across Programming Languages](https://youtu.be/IyYSafvSjdE?si=Rc23WVv8pRcGKrB3)
- Wikipedia
    - [First-class citizen](https://en.wikipedia.org/wiki/First-class_citizen)
