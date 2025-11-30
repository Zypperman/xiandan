# Random lesson Trivia

- ask about haskell program for binomial tree for option pricing

---

## Week 1

### Admin

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

### Notation issue

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

---

## Week 3

- following the rule that the determinant scales the same amt if you scale one row / col by a number, you can pull factors:

  $$
  \left|\begin{pmatrix}
  5 & -5 & 5 \\
  1 & 3 & 4 \\
  2 & 7 & 6
  \end{pmatrix}\right| = 5 \left|\begin{pmatrix}
  1 & -1 & 1 \\
  1 & 3 & 4 \\
  2 & 7 & 6
  \end{pmatrix}\right|$$
  here we factored our the first row by doing $R_1 \rightarrow 5R_4$

- try to find common sums when you have a matrix of mostly the same value of n (like the identity matrix).

- Qn 25: you can factor out each row and write that:

$$|-A| = (-1)^n |A|$$

so if n is even, its always 1, if its odd its always -1.

Traditional proof:

- define skew symmetric matrices, that their transpose is the negative version of themselves
  - therefore $A^T = -A$
- from properties of determinants, the transpose and the original will have the same determinant
  - $|A| = |A^T|$
- sub definition in
  - $|A| = |-A|$
- scaling A by s will cause the determinant to be scaled by $s^n$ (where n is the num of rows) so:
  - $|A| = (-1)^n|A|$
- see above, that means if n is odd you'll always have the negative version of your original determinant, QED.

### Determinant property

- you can only split 1 row or 1 col at a time.

- so for you cant do:

    $$
    \left|\begin{pmatrix}
      a +a' & b+b'  \\
      c+c' &  d+d'
      \end{pmatrix}\right| \neq

      \left|\begin{pmatrix}
      a & b  \\
      c & d
      \end{pmatrix}\right| + \left|\begin{pmatrix}
      a' & b'  \\
      c'&d'
      \end{pmatrix}\right|
    $$

but you split by row by row:

$$
\left|\begin{pmatrix}
a +a' & b+b'  \\
c+c' &  d+d'
\end{pmatrix}\right| =

\left|\begin{pmatrix}
a & b  \\
c+c' & d+d'
\end{pmatrix}\right| + \left|\begin{pmatrix}
a' & b'  \\
c+c' & d+d'  
\end{pmatrix}\right| \\
=
\left|\begin{pmatrix}
a & b  \\
c & d
\end{pmatrix}\right| + \left|\begin{pmatrix}
a & b  \\
c' & d'  
\end{pmatrix}\right| + \left|\begin{pmatrix}
a' & b'  \\
c & d
\end{pmatrix}\right| + \left|\begin{pmatrix}
a' & b'  \\
c' & d'  
\end{pmatrix}\right|

$$

---

## Week 4 (solving linear equations)

### Basic solutions overview

| | Equations | Solutions | Comments |
| :--- | :--- | :--- | :--- |
| 1 | $x+y=5 \\ x-y=1$ | $x=3, y=2$ | Unique solution |
| 2 | $x+y=5$ | $x=t \\ y=5-t$ | Infinite number of solutions, Only one equation |
| 3 | $x+y=5 \\ 2x+2y=10$ | $x=t \\ y=5-t$ | Infinite number of solutions, really, only one equation |
| 4 | $x+y=5 \\ x+y=6$ | - | No solutions, Inconsistent equations |
| 5 | $x+y=5 \\ x-y=1 \\ 3x-y=7$ | $x=3, y=2$ | Unique solution, really only two equations |
| 6 | $x+y=5 \\ x-y=1 \\ 3x-y=9$ | - | No solutions Inconsistent equations |  

### Basic dimensions overview

| Equations | A line ($\mathbb{R}^2$) | A plane ($\mathbb{R}^3$) | An subspace ($\mathbb{R}^n$) |
| :--- | :--- | :--- | :--- |
| **One equation** | A line, Infinite solutions | A plane, Infinite solutions | An subspace, Infinite solutions |
| **Two independent and consistent equations** | A point of intersection, Unique solution | A line of intersection, Infinite solution | An subspace, Infinite solutions |
| **3 independent and consistent equations** | Cannot happen | A point of intersection, Unique solution | An subspace, Infinite solutions |
| **independent and consistent equations** | Cannot happen | Cannot happen | A point of intersection, Unique solution |
| **Two independent but inconsistent equations** | Parallel lines, No solutions | Parallel planes, No solutions | Parallel subspaces, No solutions |
| **3 independent but inconsistent equations** | Lines that make, $\equiv, \neq, \Delta$ No solutions | Planes making $\equiv, \neq, \Delta$, in cross section, No solutions | Hard to visualize, No common intersection, No solutions |
| **independent but inconsistent equations** | Lines that make $\equiv, \neq, \Delta$, No solutions | Planes making $\equiv, \neq, \Delta$, in cross section, No solutions | Hard to visualize, No common intersection, No solutions |

---

## Week 4

you can RREF to get:

$$
\begin{bmatrix}
a&...&...&...&|&d\\
0&b&...&...&|&e\\
0&0&c&...&|&f\\
0&0&0&0&|&g\\
\end{bmatrix}
$$

- if g is 0 the system is consistent, otherwise its inconsistent
- REF form also already tells you how many variables there are from the pivots you have. if you have less pivots than numbers, you don't have enough variables. and your system is linearly independence is not realted, its just whether 1 row can be a multiple of another.

the rank of your REF can look like:

$$
\begin{bmatrix}
a&b&c&|&d\\
0&0&0&|&e\\
\end{bmatrix}
$$

the rank of the coefficient matrix is smaller than the rank of the augmented matrix. This scenario just means your system is inconsistent.

Checklist:

1. is rank of the augmented matrix the same as the coefficient matrix?

    - if yes, the system is consistent.
    - if no, the system is inconsistent.(additional rank on last row of Aug means 0 variables = constant, kinda not what we want)

2. is the rank equal to the number of variables?

    - if yes, the system has 1 unique sol
    - if less, the system has infinite sol

Singular matrices mean the determinant is 0

- if thats the case, it means after LU decomp your U determinant is 0

---

## Week 6

- intersection between 2 orthogonal subspaces, is the null vector.
- when proving subspaces:
  - check if you can formulate a sample vector
  - check whether scaling it doesn't give you a vector in the subspace
  - check whether addition doesn't give you a vector in the subspace

---

## Week 7

- notation stuff
  - $[x]_A$ &#8594; x written in the basis vectors of A
  - $\bar{x} = A[x]_A =$ columns of A * components of xA.
    - $\bar{x}$ is our vector in our identity basis
    - $A$ is just our new basis matrix
    - $[x]_A$ is our vector written in terms of the new basis A.
  - threfore $[x]_A = A^{-1}x$

### For tall matrices

- ie $\mathbb{R}^{3\times2}$
  - get the left inverse.
  $$
  \bar{x} = A[x]_A
  \\\space\\
  [x]_A = A^{-1}_{\text{Left}}\bar{x}
  
  \\\space\\
  
  [x]_A = (A^TA)^{-1}A^T\bar{x}
  $$

### Orthogonal matrices

- can either be square or tall, but minimally full-column ranked.

- no such thing as 2 vectors that do not intersect with each other since they all need to pass through the origin.

## Why you can't GSP a wide matrix

- because GSP is column dependent, you will have linearly dependent columns so you will get invalid columns at some point, and you can't move on with the process using invalid vectors (like linearly independent ones, they just straight up make no sense).
- number of angles of rotation = $\frac{n(n-1)}{2}$ where n is the number of dimensions in your vector space.

---

- Why categorize matrices as singular or non-singular
  - singular just means determinant is 0, and the hypervolume of that matrix is just 0.
  - If A is not singular, then any choice of b vector of constants will have a unique solution.
  - If A is singular, that means that there exists some vector b where there is no solution or infinite solutions.
  - dumb origin by leibniz where bro just cared whether the determinant was non-zero or not.
  - another way to view this is from the POV of functions.
    - 'singular' in the context of functions = they break at some point.
    - functions like $f(x) = \frac{1}{x}$ are considered singular because they
    
