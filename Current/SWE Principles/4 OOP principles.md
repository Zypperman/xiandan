# The 4 OOP Principles (in layman terms)

Basic rules to follow when making objects to make SWE simpler and more efficient. Refernce the coding role Client-Implementer parardigm. Coders should either:

- use other functions and objects  
    (Client role)
- be the ones making other functions and objects  
    (Implementer role)

## Encapsulation &#8212; "Black-boxing in practice"

How your objects work should be a black box, and be isolated from the client role.

- Objects should:
    - Hide how they work and their state with a black box (by keeping it private)
    - Only show data thats needed for interacting with other objects
    - Not allow anything to edit or access whats in the black box
    - only interact via public functions or methods

- Practice this by:
    - forcing methods to control attributes (ie with getters and setters)

### Purpose

Isolating an object's internal workings can:

- Ensure program security
- Help control object state changes
- Minimise human error,
- make code more maintainable and understandable

## Abstraction &#8212; "Black-boxing in theory"

Your objects should focus only the essential details of what they represent.

- Clients should not be concerned with the level
- If a function has no effect or basically does nothing, then don't implement it.
- The level of control we implement here is termed the "abstraction barrier".
    - the 2 roles help establish who should be able to see what:
        - if you're just using the func, you shouldnt know how it works
        - if you're writing the func, you shouldnt let users mess with your logic.

Enforce it with:

- Interfaces
- Abstract classes

> [!warning] Excessive abstraction
> Abstraction should simplify our understanding, but do it reasonably.
>
### Purpose

- Makes code more readable (less rubbish)

## Inheritance &#8212; "adding to what you've already made"

Structure your code to allow other implementers to extend from existing classes.

- Enable them to:
    - override existing parent classes
    - add to existing parent classes

### Purpose

- makes it easier to scale your codebase
- reduces code repetition
- reduces complexity

## Polymorphism "Different objects don't need different names for the same action"

Complements inheritance, where you should reuse the functionality and names from a functions from a parent class.

- You can add to functions from parent classes, but if they functionally do the same thing previously, dont rename it. (ie. animal.name and bird.name should work, don't try to rewrite the same thing.)

### Purpose

- Makes code more readable and modular
- Devs don't need to repeat code as often
    - although they should if its simple enough

## Misc terms

- Composition over Inheritance
    - Composition &#8594; a design pattern where you design around objects being made from smaller objects.
        - Distinguishable with the "has-a" and "is-a" model:
            - Composition is when we use "has-a" to describe a relationship  

                ie. "This car <u>has a</u> door" &#8594; the door is a component to the car class
            - Inheritance is when we use "is-a" to describe a relationship  
                ie. "This car <u>is a</u> vehicle" &#8594; the car is an object child class  is a component to the car class

    - Preferred in situations where you have many sibling classes that have different functions, and just adding stuff from a parent class isnt enough for that class.
    - In reality, most instances of inheritance will eventually become composition instances.
    -

Coupling &#8212; a measure of how 2 connected elements are to each other
    - ie. if 1 class's attributes change, are other classes affected? (those are considered coupled classes)

Association &#8212; the nature of connections between 2 classes

- Reminiscent of crowfoot notation in Entity Diagrams.
- Association Types:
    - one-to-one &#8212; ie. 1 school to 1 principal
    - one-to-many &#8212; ie. 1 teacher to many students
    - many-to-many &#8212; ie. many students to many university modules

## Sources

- Softserve: ["What is Object-Oriented Programming (oop)? Explaining four major principles"](https://career.softserveinc.com/en-us/stories/what-is-object-oriented-programming-oop-explaining-four-major-principles#:~:text=OOP%20allows%20objects%20to%20interact,inheritance%2C%20polymorphism%2C%20and%20abstraction.)
- Wikipedia
    - [Composition over inheritance](https://en.wikipedia.org/wiki/Composition_over_inheritance)
- reddit
    - [Composition over Inheritance?](https://www.reddit.com/r/AskProgramming/comments/lv7m7a/i_still_dont_understand_the_prefer_composition/)
