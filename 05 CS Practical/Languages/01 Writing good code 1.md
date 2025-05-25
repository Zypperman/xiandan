# Writing Good Code 101

## 1. Don't nest more than 3 layers

- Nesting conditions makes code hard to read since you need to keep it all in your head, so core logic will be difficult to expand on.
- **General solution: handle alternate routes first.**

### Solution 1: Inversion / Guard Clauses

- if there is less logic for the alternate route of a condition than the current route, invert the condition and handle the alternate route first.
    - ie. if you need to check for user authentication and authorization, if authentication failure involves less code, make a block to handle failed authentication behaviour first.
  
Before:

```python
if is_authenticated:
    if is_authorized:
        print("come in")
    else:
        print("not authorized")
else:
    print("not real user")
```
  
After:

```python
if not is_authenticated:
    print("not real user")

if not is_authorized: 
    print("not authorized")

print("come in")    
```

This allows developers to have less conditions to worry about and ignore.

## 2. Merge related if-statements

- Sometimes granularity is not really required.
- If two logic blocks are functionally the same condition, just merge them.

Before:

```python
if not is_authenticated:
    print("not real user")

if not is_authorized: 
    print("not authorized")

print("come in")    
```
  
After:

```python
if (not is_authenticated) or (not is_authorized):
    print("not real user")

print("come in")
```

This decreases repetition at the cost of functionality. Decide if this is worthwhile by checking if the two functions are really that different.

## 3: Abstraction

- Improve readability by abstracting logic that isnt relevant into helper functions.
    - Cons:
        - The logic in each helper should be near intuitive.
        - Consideration before abstracting: Developers need to keep the abstracted logic in their head if it isn't, and time will be wasted re-reading helper func documentation.
    - Pros:
        - Refactoring will be extremely easy since code isnt repeated, you can just modify 1 helper function used everywhere instead of multiple blocks that are used everywhere
        -

## 4. Variables should be named meaningfully

Self explanatory.
  
Some Conventions to follow for transparency:

- no single-letter vaariables
- avoid abbreviations, even if you document what they map to.
- no types in your named (see hungarian notation, don't do it)
- label variables with units, or use static typing to abstract it from the variable.
- add types to your types (again, hungarian notation, dont do it.)
- dont use "base" or "abstract" in your parent classes. Instead, rename your child classes.
- The "Utils" class is a sacred space. Do not just throw in helper functions as you make them. Consider if they are more appropriate to be placed under their own type or module.

## 5. Write good unit tests

1. make sure your code follows rules 1 to 4 above (ie modularize your code)
2. Write tests as functions that are named as the tests themselves ie. `TestIsBlankStringShouldReturnTrueWhenBlank`
   - the tests should document themselves, and be your objective truth (test fail = rewrite, no questions asked.)

    >[!warning] Integration tests ≠ unit tests.
    >
    > - Integration tests check for whether a function <u>breaks other parts of your code.</u> (ie database connections)
    > - Unit Tests check for whether a function breaks <u>on its own.</u> (ie unexpected inputs that break your logic)
    >  
    > Integration Tests are expensive at scale, so avoid them.

3. **Always remember to do regression testing**
    - Regression (in SWE Context) &#8212; A change that breaks code that has already been tested.
    - Regression testing &#8212; A test that checks for regressions.

## Useful Constructs

### First Class functions

A function that you can treat like an object.

- They can be:
    - assigned to variables
    - passed as arguments
    - returned from other functions

Technically speaking, we are asserting that the implemented form of the  abstract idea of the function  the function's implementation as w

in Javascript:

- Counterpart: Lambdas
    - Functions that do not have a name, typically used for convenience ie. python &#8594; `lambda x: 2x` to return 2 times the input

## Sources

- [Kantan Coding](https://www.youtube.com/@kantancoding)
    - ["The 3 Laws of Writing Readable Code"](https://youtu.be/-AzSRHiV9Cc?si=wqGkZDYRm8szBAJf)
    - ["The 3 Laws of Writing Bug Free Code"](https://youtu.be/-AzSRHiV9Cc?si=wqGkZDYRm8szBAJf)
- CodeAesthetic
    - [Naming Things in Code](https://youtu.be/-J3wNP6u5YU?si=G0FyYg6O9J7D5MXe)
