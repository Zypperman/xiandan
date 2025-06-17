# Why Java?

TLDR: its the first stable language that can run on anything.

## Motivation / Favorable language properties

- Statically typed - declared vars can't change type
- OOP-friendly - good for SWE and flexibility
- Functional-programming suited - input and outputs are predictable
- Typing system - strong control of behaviour, and creation of custom types with classes and interfaces.
- Compiles to byte code instead of machine code (like C or C++)
    - That means it can **run on any OS without recompiling**
    - Because it all runs on the Java Virtual Machine (benefit of virtualization)
        - as long as you have the Java Runtime Environment, with other libraries, you can run your software.
    - This also makes it more developer friendly since you dont need to write the same thing for diff machines cuz if it works on the VM, it works everywhere.
- Its both a compiled and interpreted language.
    - Compiled &#8594; your human-interpretable code (termed "source language") is converted to optimized code that your processor will execute (termed "object language").
        - This means the program runs faster but at the cost of being platform dependent and needing to compile it to test or run it while developing it.
    - Interpreted &#8594; program is executed line by line, relies on Just-in-time (JIT) compilation to work faster.
    - Its both because theres a compilation step from source into byte code, and the VM is considered an interpreter.

### High-level features

- Garbage collection
- Runtime type checking as a safety feature
    - useful for when you work with untrusted sources ie. external APIs and you don't want your code to break from introducing data from it.
    - Its not something you can check while writing your script, you literally need to take a leap of faith and run your code to check whether the api gives you data in the format you expect.
    - Data is checked to make sure it matches the types in your code.
- Reflection
    - the programs you write have ways to access and manipulate class information about themselves, as part of inbuilt functionality (ie you can list and display the names of all the members in a class, class methods, class methods, attributes etc)
    - ie python you can access class data.

## Where you're probably gonna use it

- for developing enterprise web apps from scratch
    - Using the spring framework (ie spring boot which comes with libraries that help with starting and managing projects)
- for Big data pipelines
    - ie. using Hadoop which provides software utilites for reliable, scalable, distributable computing
- Android Apps
