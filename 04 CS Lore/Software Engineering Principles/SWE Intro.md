# SWE Exposition and Configs

Taken from <https://nus-cs2030s.github.io/2021-s2/00-overview.html>.

## Transitioning from solving small problems into the SWE mentality

write with the following in mind:

1. Maintainability (long term simple code v short term slipshot solution)
2. Scalability (solutions can be improved easily)
3. Transparency (with design patterns, implementations etc)

All have continuity in mind, which is important since ultimately humans are involved. Hence, on top of resource-efficiency, you need to consider how make your project easy for adoption and maintenance by other people, and the chance of bugs is basically 0.

Tangible changes include:

- From solving a single problem to a multidimensional one
- From dealing with 1 component to dealing with multiple components (ie Frontend and Backend, DBs and UIs)
- from single use variables to increasingly codependent variables
- From coding with self-assigned conventions to convention that are more transparent (no single-letter variables).
- from single states to codependent states

## SWE principles (broadly)

- 4 OOP principles:
    - Encapsulation
    - Inheritance
    - Polymorphism
    - Abstraction
- SOLID
    - L - Liskov's Substitution principle
- Tell-Don't-Ask
- Composition over Inheritance
- closure
    - passing functions into their implementation
    - hints towards what a monad is: "A computational structure that allows objects to be composed and manipulated in a succinct and powerful way."

### SWE conventions

- comment code like a message for others (or your future self) so that relationships and states are easier to understand &#8594; easier time fixing and improving.
- code by convention to make it more readable

#### Functions

- break down your functions so that each perform simple, specific tasks. 
  
    Doing so helps with:
    - analysing resource complexity for speedy improvements.
    - analysing interactions for speedy debugging.
    - reusability of components for speedy understanding and scaling.

#### The abstraction principle

> "Each significant piece of functionality in a program should be implemented in just one place in the source code. Where similar functions are carried out by distinct pieces of code, it is generally beneficial to combine them into one by abstracting out the varying parts."

TLDR, write to achieve minimal repetition. There should be no intersection in the individual functionality of your functions. (Either they do something on their own, or theyre made of more helper functions with abit more code.)

This also applies to:
    - Types &#8594; parameterized types or subtypes
    - sub-computation, between helper and first-class functions.

## The Abstraction Barriers (dividing role responsibilities)

Refers to how you should separate your code. It should basically either:

- use other functions (Client role)
- be used to make 1 function (Implementer role)

As an implementer, the functions you make should be black-boxed.

- Clients don't need to know what goes on inside.
- CLients should know what goes in and out through <u>exposed parameters</u> and <u>return values</u> respectively.

This is done at multiple levels with practices like:

- Functional programming
- encapsulating objects
- access modifiers (so some functions cant access certain parts of code)

### Evaluation

| Benefits | Drawbacks |
| ----------- |----------- |
| reduces code complexity | reduces flexibility as you scale |
| Cleanly splits roles|client now needs to ask implementer to change where required, difficult to maneuver|

### Handling types

- Important the moment you allow other people to change code behaviour without changes to existing code.
- Mostly involves dealing with your language's type system, and is when concepts like subtyping and the Liskov substitution principle becomes important to prevent bugs.
- Typing also helps assert predictable behaviour in your code. Most prominent show of this is with [negative-space typing](https://youtu.be/jc_6ZkkOUpQ?si=mP8nnDyjS1rnEJ2n).

### Asserting predictable behaviour

- Assert with the following practices:
    - functions shouldn't modify variables outside its scope (termed "pure functions")
    - Don't modify objects after they are created ( concept is termed "immutability") and you update them by destroying and creating a new one in its place 
    - 











# Videos to consider watching

- CodeAesthetic 
    - [Abstraction can make your code worse](https://youtu.be/rQlMtztiAoA?si=AvShXt40_S-KFuUG)


