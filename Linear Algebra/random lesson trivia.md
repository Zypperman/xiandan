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
