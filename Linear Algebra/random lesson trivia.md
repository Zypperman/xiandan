ask about haskell program for binomial tree for option pricing

---

# Admin

- pop quizzes every lesson for the current week's topic
- assignments are in-class cuz gpt
- try textbook exercises for practice
  - solutions are usually released after class (by tues evening)

The other textbook is more advanced and in-depth with applications

- Coding the Matrix: Linear Algebra through Computer Science
- Strang's lectures &#8212; flipped examples

---

- practice with practice quiz, presented qns are a subset.  
- sagemath builds on some mojhitop alg for solving equations symbolically

## Notation issue

- for matrices, ordering is impotant for proper multiplication.
- however, putting one inverse matrix in front of the other is weird ie. $A^{-1}\bar{B}$
  - so we denote it as $A \backslash B$.  

- $f(x) = |x|^{\frac{1}{2}}$
  - not single valued because f(x) when subbing in x = some value, can result in f(x) taking on more than 1 value (ie when x = 4, f(x) is $\pm2$)

### Question general pointers

- for proving linearity
  - check if the string of numbers you have is a function or an equation
    - if equation, format such that expression = constant then handle expression
    - if function with similar terms (ie mapping, transformation), set y to one side and set left hand side of the equal sign as a function

- cool qn, given:

$$
    f \begin{bmatrix}
 3\\2
\end{bmatrix} =  \begin{bmatrix}
 5\\3

\end{bmatrix},
f \begin{bmatrix}
 1\\1
\end{bmatrix} =  \begin{bmatrix}
 0\\1

\end{bmatrix} \\

\text{find }f \begin{bmatrix}
 7\\4
\end{bmatrix}
$$

just:

1. equate the raw values

$$f \begin{bmatrix}
 7\\4
\end{bmatrix} = x\begin{bmatrix}
 3\\2
\end{bmatrix} + y \begin{bmatrix}
 7\\4
\end{bmatrix}
$$

---

## Week 2

- for C = AB, we are dealing with linear combinations of A using B
  - being framed as $A\bar{x}=\bar{b}$

- the moment you have a set of linearly indep vectors spanning a space, you automatically cannot find another linearly independent vectors.

- outer products only (for this course), exist for vectors. tensor products are out of scope.

- Row picture -> result is obtained via **collating rows from the linear combinations of rows in B with the columns in A**
- Col picture -> result is obtained via **collating columns from the linear combinations of columns in A with the rows in B**

- for proving Linear indep for (a-b), (a+c) and (b+c) (the answer is that they are linearly dependent):
  - either find a set of values, or declare that there are infinitely many solutions to match, other than all values being 0.

- vector dot product is distributive, ie if you constructed a vector using some Linearly indep vectors, and you dot product z, you can equivalently dot product the vectors used to make a linear combination.

- for expanding the equation $\left|\left|(\bar{a}+\bar{b})\right|\right|^2$:
  - we can factor it as $(a + b) \cdot (a-b) = a\cdot a + a \cdot b + b\cdot a + b \cdot b$ with all of them as vectors
  - we end up with $2(a\cdot b)$ that needs to be 0 for them to be equivalent.
