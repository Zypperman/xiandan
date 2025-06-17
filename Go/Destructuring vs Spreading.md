# JS concept: Destructuring vs Spreading

Both just make your code cleaner when dealing with array-like structures ie. objects with mutliple attributes, arrays, etc.

## Destructuring

Where you take an existing array-like structure, declare as many variables as there are elements, and assign all of them by index.

```javascript
let array1 = [1, 2, 3, 4, 5]
let [ indexOne, indexTwo, indexThree, indexFour, indexFive ] = array1;

console.log(indexOne); // prints 1 in DOM
```

This also works for objects:

```javascript
let object = {
    name: "Nishant",
    age: 24, 
    salary: 200,
    height: '20 meters',
    weight: '70 KG'
}
let { name, salary, weight } = object; 
// using variables with names that correspond with 
// the object's existing attributes 

console.log(name); // prints the object's name 
```

This even works for function parameters:
```js
let object = {
    name: "Nishant",
    age: 24, 
    salary: 300,
    height: '20 meters',
    weight: '70 KG'
}

function printData({name, age, salary, height, weight}){
    console.log(name, age, salary, height, weight)
}

printData(object)
```

## Spreading

Operating by every iterable element than the iterable. Treat it like taking a sandwich, ignoring the bread and referring to whatever's inside.

ie combining lists:

```js
let array1 = [1, 2, 3, 4, 5]
let array2 = [6, 7, ...array1, 8, 9, 10]

console.log(array2);
// 6, 7, 1, 2, 3, 4, 5, 8, 9, 10
```

Object spreading:

```js
let object1 = {
    firstName: "Nishant",
    age: 24, 
    salary: 300,
}

let object2 = {
    lastName: "Kumar",
    height: '20 meters',
    weight: '70 KG'
}

let object3 = {...object1, ...object2}
console.log(object3);
```

However, note that this is only a shallow copy, so "if the values of the object properties themselves are objects (nested objects), only their references are copied, not the actual objects".

Syntactically cleaner, but only understood by js users.

## Sources

- [FreeCodeCamp](https://www.freecodecamp.org/news/javascript-destructuring-and-spread-operator-explained/)

- [Geeks4Geeks](https://www.geeksforgeeks.org/how-spread-operator-works-in-js/#:~:text=This%20operation%20is%20a%20shallow,copied%2C%20not%20the%20actual%20objects.)
<!--TODO: Move this article to JS-->