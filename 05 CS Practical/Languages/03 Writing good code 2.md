# Writing Good Code 102

## 1. Constant folding

- All invariant parts of your code should either be:
    - A constant
    - Assigned to a variable and reused.
  
    Your compiler will only need to evaluate once. ideally, for-loops should not have invariant parts.

- Invariant &#8212; defined as when swapping out your code segment with a similar expression has no effect on the code.

## Static arrays / Matching Type to task / Understanding data structures

- man ke sure your type suits your task. 
    - ie if you need to store string-type tags for an item, if you know they are static for the forseeable future, store them as a set.
    - either way, even if sets are not a thing in your language, just find a suitable alternative like `map` in rust, that is suited for static storage and allows for an optimized search.
    - However, also consider the size of your array since smaller arrays are not worth the calculations for set search.

## Optimize for scale

- Don't use a for loop when a bulk process option exists.
    - ie SQL, for loop inserting is slower than batch insert because each individual insert will prompt servers to ping back that it was successful which isnt that important.

## Reduce the complexity of your operations.

- Consider the cost of your involved operations, and see if alternate paths achieve the same effect (ie sum(arr) * 12 vs a for loop multiplying each element by 12 adding to a cumsum, the former is preferred since its just 1 times op vs n times ops. just calculate complexity.)

## TLDR: Measure, implement, Measure again.

Because Apparently rule 1 is kinda fallacious since you'll never be sure what compiler you're on. "Instead, you want to treat the compiler as a black box and its optimizations as random and unpredictable. Assume nothing and measure everything."

Also, premature optimization is dumb. Just optimize as problems arise. Quoting Donald Knuth: 

> "We should forget about small efficiencies, say about 97% of the time: premature optimization is the root of all evil. Yet we should not pass up our opportunities in that critical 3%"

That 3% should come from measuring in totality, not while you write your code.



## Sources

- Kantan Coding
    - [The 3 Laws of Writing Performant Code](https://youtu.be/35ZpZCSH11Q?si=a0FZV_xo9S2I61tF)
    - [Most Useful Constructs Across Programming Languages](https://youtu.be/IyYSafvSjdE?si=Rc23WVv8pRcGKrB3)
