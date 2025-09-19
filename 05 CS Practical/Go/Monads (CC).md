# Monads Crash Course

> [!Note] Wow this is a horribly explained concept
> Ok so most sources out there really suck at explaining this. I hope this gets refined and polished in the future, but for now I'll try explaining it as best as I can.
>
> [!tip] TLDR:
>Its a way to organise your code so if you need some block of code to be legible, you don't physically repeat the check, you put your variable in a container and functions operate on that container, and the check is done automatically in the container before each new function is applied.
>
> Ultimately, instead of writing the check function multiple times, the container runs it for you so you only write the check function once, at the cost of abstracting more.
>
> This makes your code cleaner and easier to maintain, ie if you now wanna add debugging to that variable, you don't need to adjust every function handling it, you only add it to the container class.

## Thinking about everything as a type

We are used to primitive datatypes like:

- ints
- strings
- floats
- arrays

In category theory, we consider these types as objects, and with Object-oriented programming, we can define our own types with classes, ie in javascript:

```js
class Person {
    // Person Constructor
    constructor(name, age) {
        // Person attributes
        this.name = name;
        this.age = age;
    }

    // misc method that objects of this type can perform
    greet() {
        console.log(`Hello, my name is ${this.name}`);
    }
}

const person = new Person("Alice", 25);
```

Here, we can see that if we think of the class `Person` as a type, defined using 2 other types:

- The person's name as a `string`
- Their age as an `int`.

Similarly, We can also think of functions themselves having types, defined using 2 other types: their input and output.

- A basic addition operator as a function (`add(a,b)`)
    - takes in an `int` (in this case, 2 of them)
    - produces another `int`

> [!note] Hidden criteria for these types: (Pure functions)
> Before you can say "oh this function is of this type", you need to make sure that :
>
> 1. every input will result in a predictable output for that function
> 2. They don't have side effects
>    1. ie. io functions aren't pure functions because they have effects that cant be seen in the output, its just seen on the terminal before its removed. This is a criteria because functional programming needs to be stateless, side effects, even expected ones, will lead to unexpected behaviour.
>
> - ie add(5,2) will always give you 7 is a Pure function.

However, grouping these functions and calling them types can get kinda confusing, so lets call them **"type signatures" &#8212; a more general term for the type of a value or a function.** Additionally, these mappings from 1 type to another is termed a "morphism" (and you can use this and "functions" interchangeably). A good example of a morphism is:

- Type casting : `int('1') = 1` ( str->int )
- addition : `add(2,2) = 4` ( (int,int) -> int )
    - This is slightly inaccurate because its better to frame our thinking where function calls only accept 1 value.
    - An example of a morphism that maps an element to itself, termed an "endomorphism" &#8212; "endo-" being latin for "within"

We can denote type signatures with `(input_type**->output_type**)`.
> [!tip] Quick aside to introduce Functional programming ("FP")
> <!--<details>-->
> Functional programming is a concept often mentioned with Monads, and basically refers to a programming idea where we aim to be super strict with our functions to act like in math, and on a given value, we want to get the result from applying a series of consecutive computations by chaining them, ending up with a block of code you can consider to be "stateless" (because it can run all the way to completion and produce a value without any side effects.)
>
> - Interview Qn tip, FP is considered a declarative programming paradigm.
>     - Declarative &#8212; when your code focuses on "what should x do"
>         - more human friendly since we abstract all the work to the implementer role
>         - like doing a list comprehension in python to get each element to 2 times their current value
>         - usually more conputationally expensive because you have to design with a lot of overhead in mind, and this is where monads come in.
>         - Preferred when each function's logic is complex.
>     - Imperative &#8212; when your code focuses on "how to do x"
>         - like using a for loop to do get twice the array value above
>             - realistically, all declarative paradigms have an imperative implementation.
>

Type signatures are important because they help us establish type safety, but also because they help us figure out how we should structure our code (seen later) in Functional Programming.

Functional programming aims to, on a single value, apply multiple functions like pipes in a pipeline to get our desired value, so figuring out how to connect these pipes is important.

However, this implementation has a side effect, we just need something that can let us chain functions and not interrupt this chaining (whether any of these function results in an error is irrelevant).  

We can solve this by first treating our variable as an element in a container object from a class we create named `handler`, and have a wrapper instance method under it to handle implementing our base function on the elements in this container:

```Js
class handler(value) {
    this.value = value;

    // FlatMap operation
    bind(fn) {
    value = fn(this.value);  
    return handler(value);
    }
}
```

This way, we can work with our values with the following steps:

1. create a variable with a value in mind, and put into our container
2. chain our commands on the container using the bind method (`container_var.bind(func)`)
3. the handler will prepare the values for us and return an instance of itself with the new value.

The container instance is termed a "Functor", while the `bind` method is termed the "flatmap" operation, which maps the input value that the container accepts to another value.

The flatmap operation is what defines our functor, and it ensures that all behaviour is mapped from 1 function to the next (even null values).

- what happens when your function accepts a null value is also considered part of its behaviour, and if not defined, will be set to something acceptable like null (and you force the function not to throw an error because of its input)
- These mappings must also follow the same structure, meaning that for all paths involving the functor, each set of objects should only be able to use 1 mapping (ie theres only 1 way to change my variable's value from a to c, its through a -> b -> e -> c in this function)

---

### Morphism vs Functors

Just to reiterate: the term morphism is just a fancy way of saying mapping. in context:

- A morphism between objects is a function, and their type signature involves primitive types
- A morphism bewteen categories is a functor, and they can have a type in ther type signature be another type signature (ie function1 has type signature `int -> str`, functor1 has type sigature `((int->str),int) -> str`).

### Generalizing the flatmap function

flatmap actually makes more sense as a term if you treat the container we've been discussing as an array of 1 element. we need to map it to another element, and that mapping is given to us by the function we pass on it. Flatmap will apply the function element-wise into the array, ie transform `[1,2,3]` using `((x) => 2x)` into `[2,4,6]`. You also basically expand on this logic to make sure that every type that you handle, after passing through a function, will return a value of a type in your type system.

Simply put, if you start with `handler('2')`, do handler.bind((x)=>2x), whatever is returned must be an int or a string (assuming thats the only two types your programming languages have.)

---

Now, funny thing about these endofuctors, we can now throw a bunch of them together and consider it a category. They first need to fit these conditions:

- All mappings between functions need to return an object thats also in the category (condition termed "totality")
    - We already meet this because all functors, after dealing with the bind func, return themselves and the value inside the functor will be updated but not the container type, so the object maps back to itself
- When you apply more than 1 functions on the functor, the order doesnt matter (condition termed "Associativity")
    - This is more your job as a programmer, but ideally you need to implement the functor such that operations can do this.
- whatever thats returned after a bind operation, even if the bind operation is literally an identity operation (`(x)=>x`) you still get yourself back as a type (condition termed "Identity")
    - This is more your job as a programmer, but ideally you need to implement the functor such that operations can do this.

Ultimately, making a container that has these conditions is what a monad is. The phrase "A monad is a monoid in te category of endofuctors can be thus broken down into":

- a container function that can always returns a usable version of itself
- enables you to handle functions consecutively
- fits the 3 criteria above.

Physical steps to ensure this include:

- figuring out how to deal with arrays (list monads)
    - we can take inspiration from list comprehension in python
- make sure all behaviour always returns the container object with a value
    - this ensures totality
    - its also what we know as the maybe monad, where the container's value can result in a null value but we still need to return it as an instance of the container
- make sure binding 2 functions results in the same type
- implied here, but the identity part is just the box's value representing the actual type in question.

## Use cases

- Cleaner code
    - instead of writing multiple functions to handle what goes on between functions, you just write one function that handles a container that all the other functions act on.
- When you want a block to run continuously despite the result, and error handle after its entirely run
    - this is basically how promises in js work.

## Sources

The proper intro phrase should be "A monad in X is a monoid in the category of endofuctors in X".

> [!Caution] WATCH THIS FIRST
>
> - A Byte of code
>     - ["A monad is a monoid in the category of endofunctors. Whats the problem? #SoMe2"](https://youtu.be/ENo_B8CZNRQ?si=QmpmlTY_vEdT9K18)  
>         - annoying title aside, the terms can basically be translated as:
>             - object &#8594; types
>             - mapping objects to one another in a category (morphisms) &#8594; functions, with type signatures based on their inputs and outputs
>                 - `str('1')= 1`, has type signature of `str -> int`, and this function instance maps 1 and 2 to 3.
>             - example of endomorphisms within the category &#8594; `(1**2) = 1`  
>                 - where the function maps the variable's value to itself
>             - categories themselves &#8594; functions
>             - functors &#8594; functions that wrap other functions
>             - endofunctors &#8594; a function wrapper that
> - goes into the math concept first before the programming idea.  
> - Very important because it introduces functional programming before we start yapping about code.

- Category theory in general
    - Bartosz Milewski's "Category Theory For Programmers" ([Github](https://github.com/hmemcpy/milewski-ctfp-pdf?tab=readme-ov-file))
        - go to releases, download pdf, should be free.

- Stephen Edwards
    - ["Haskell: Monads. A 5-minute introduction"](https://youtu.be/_Gk_lwhJMzk?si=nglddjfsSI6uH64S)
- Medium
    - [Kristof Slechten, *"A gentle introuction into monads"*](https://kristofsl.medium.com/a-gentle-introduction-to-monads-bc583d41d95) (ok admittedly this person grandstands abit but the explanation is good)

- A Byte of code
    - ["A monad is a monoid in the category of endofunctors. Whats the problem? #SoMe2"](https://youtu.be/ENo_B8CZNRQ?si=QmpmlTY_vEdT9K18)
        - watch before everything, this is the mathematical concept for monads and it makes a lot more sense than the programming pattern. we're basically mimicing this in code.
        - the intro is a good analogy for what FP is
    - ["What is a monad? (Design Pattern)"](https://youtu.be/VgA4wCaxp-Q?si=fJX7jniK3h3v5dpU)  
        - highly recommended because in the time it takes you to read this article, you are legit better off learning visually what monads are.
        - However, note the pinned comment that its a functor and not a monad. Monads are when you add functionality to the bind function.
- Studying with Alex
    - ["The Absolute Best Intro to Monads For Software Engineers"](https://youtu.be/C2w45qRc3aU?si=CwfedLJDsrUcSr8l)

- Coding with Yalco
    - ["Monad is actually easy."](https://youtu.be/8hYUthfmSRM?si=nfEVkfbpRd5WKK2L) &#8212; Goated video.

- James Coglan
    - ["the best introduction to monads I’ve ever read"](https://blog.jcoglan.com/2011/03/05/translation-from-haskell-to-javascript-of-selected-portions-of-the-best-introduction-to-monads-ive-ever-read/#)

- Math Stackexchange
    - ["Whats the difference between Type Casting and Functors"](https://math.stackexchange.com/a/113738)
        - what Functors add that makes them more than morphisms (like Type casting)
        - also discusses monads
- Juanbelieni (Medium)
    - ["Functors in programming"](https://dev.to/juanbelieni/functors-in-programming-1mag)
        - categories similar to type systems in programming, and since all functors just map types from the type system back the same type system, all functors are by default endofunctors.

- [Maybe monad implementation in JS](https://jrsinclair.com/articles/2016/marvellously-mysterious-javascript-maybe-monad/)
