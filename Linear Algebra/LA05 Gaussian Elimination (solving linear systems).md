# Solving linear equations With Gaussian Elimination

## Linear equations and matrix notation

### inconsistent equations

- if your equations have a contradiction, there will be no solution for your system. Always check before you solve.
- You can encounter different kinds of systems with:
  - no solutions (where a contradiction exists from the system being inconsisent)
  - infinite solutions (where a variable can take on infinitely many values and still work)
    - an example being two equations that are just scaled versions of each other
      - aka if you convert to rref form, the covectors are <u>linearly dependent</u>
- A unique solution.

### Converting a system into a matrix equation

- covectors can be reordered as you like (since given the context, that means the order of equations in your matrix which shouldn't matter)
- you just turn your system into a matrix equation of $Ax=B$ where:
  - A is a matrix of coefficients in the system
    - number of cols in A = number of variables
    - number of rows = number of equations
      - It's ok if you don't have enough equations, solving comes later
    - elements of A = coefficients of the equation
  - x is a column vector of variables
    - has as many dimensions as variables involved
    - matches the number of columns in A
    - the order of variables here must also match the coefficients in A.
  - B is a column vector of constants
    - elements are the constants for each corresponding equations

  so you end up with :
  - A &#8594; \<no. of eqns\> x \<no. of variables\>
  - x &#8594; \<no. of variables\> x 1
  - A &#8594; \<no. of variables\> x 1

### Your goal

- To get a unique solution, A needs to be turned into an identity matrix so you end up with:
    $$
    Ix = B \\

    \begin{pmatrix}
    1 & 0 \\
    0 & 1
    \end{pmatrix} \begin{pmatrix}
    x\\y
    \end{pmatrix} =\begin{pmatrix}
    m\\n
    \end{pmatrix} \\
    \therefore x=m,y=n
    $$

## Augmented matrices

- Where you represent your system entirely with a matrix, and add the constants vector to the end of your coefficients matrix and add it as a new column.

## RREF and Gaussian elimination

- where you manipulate your augmented matrix with the following valid operations:
  - swapping rows
  - scaling rows
  - adding scalar multiples of entire rows to another row
- Once you have a single equation with 1 variable and constant, you use back susbtitution.
  - alternatively, you can just plug values back into the system once you  have enough information, you don't need to present it in the form of the augmented matrix's coefficient half being an identity matrix.

- As a pointer, try to get an upper triangular matrix on the coefficient side of the augmented matrix cuz then the equations are formatted for you when you back susbtitute
  - start with the first column and work leftwwards to get rid of all the coefficients.

### RREF in the case of weird solutions ($\infin$ or none)

- ie for infinite solutions like $\begin{pmatrix}1&1&2\\0&0&1\end{pmatrix}$
  - contradiction will reveal itself where one side isn't equal to another
  - the system is termed <u>inconsistent</u>.
  - If a system is inconsistent, it means theres no solution (the equations involved do not graphically intersect at all).
  - "If we have a row in REF with all zeros on the LHS / coefficient matrix side, and a non-zero value on the RHS / constant side, the system is inconsistent and there is no solution."

