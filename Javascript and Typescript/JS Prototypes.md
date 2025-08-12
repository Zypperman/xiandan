# JS prototypes

The `prototype` type basically refers to a suite of methods that most objects will have, but may not be defined for.

- ie. when you call certain undefined methods on certain objects like `test.toString() : string`, it doesn't give an error but returns some weird thing like `'[object Object]'`
    - This method was derived from an object inheriting from the prototype class.
    - prototype will refer to either the parent object's methods, or to the suite of methods stored under `Object.prototype`.

ie:

``` js
const parent {
    species : 'Homo sapiens'
    breathe : () => console.log("breathe once")
}

const child = Object.create(parent)

console.log(child) // prints:
//{}
//[[Prototype]]:Object
//    > breathe : () => console.log("breathe once")
//      species : 'Homo sapiens'
//    > [[Prototype]]:Object

// *properties are inherited.
```

Think of it as a manual blueprint that emulates inheritance.

- Anyway, if a method's behaviour is not defined with the current object, Js's engine will keep referring to the parent class's defined behaviour until we reach `Object.prototype`, where we just return `[object Object]`.

- Only if the method defined is of a custom name (not belonging to any known class) then it'll return null.

## Sources

- [What is Prototype in JavaScript? | CodeSketched](https://youtu.be/wFFTpe-zTFs?si=J1-GWrBMvvfVm5m8)
