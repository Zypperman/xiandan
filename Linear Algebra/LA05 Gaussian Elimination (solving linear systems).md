# Solving linear equations With Gaussian Elimination

## Linear equations and matrix notation

TLDR, matrices can be used to solve simultaneous linear equations (at a basic level).

- simultaneous equations should properly be referred to as "a system of equations".
- alternatively, you can also solve non-linear systems by subbing them out for linear terms (ie if you have a $sin(x)$ you can swap it for $a=sin(x)$, solve that then sub it back in).

---

### <span style="color:crimson">Note: inconsistent equations</span>

- if your equations have a contradiction, there will be no solution for your system. Always check before you solve.
- You can encounter different kinds of systems with:
  - no solutions (where a contradiction exists from the system being inconsisent)
  - infinite solutions (where a variable can take on infinitely many values and still work)

  - A unique solution, which will give you an answer.
    - The condition for reaching a unique solution

>[!note] Conditions for a unique solution
> Your system of equations must be:
>
> - <span style="color:cyan">Independent</span> &#8212; if an equation cannot be derived from the rest in its system, it is independent.
>   - if one equation is just the scaled version of another, so effectively your system has 1 less equation
>   - ie $\text{eqn1} = 5(\text{eqn2}) \implies \text{eqns are dependent}$
> - <span style="color:cyan">Consistent</span> &#8212; negatively defined, an inconsistent system is one with no solutions.
>   - ie. there are no two equations in your system that contradict and cannot be true at the same time.
>     - usually because the gradients of 2 equations are the same, so they're parallel (meaning 0/$\infty$ solutions) ie $x+y = 5, x+y=6$
>   - note, 2 lines being parallel is not the only condition to being inconsistent, its just 1 of many (see situation c).
>   - alternatvely, its possible that you have more equations than necessary, and unnecessary equations exist as linear combinations of the others. (ie. 3 eqns for 2 unknowns and $\text{eqn3} = 2(\text{eqn1}) + 4(\text{eqn2})$ )
>   - lastly, another case is if you have 3 lines and 2 constants, but there is no point where they all intersect, just points where at most 2 lines intersect (like in a triangle, see situation a).
>   ![example of inconsistence](https://s3-us-west-2.amazonaws.com/courses-images/wp-content/uploads/sites/121/2016/07/01222701/CNX_Precalc_Figure_09_02_007n2.jpg)
> - unrelated, but for situation a we can use linear regression to approximate a solution for that system.
>
> <span style="color:cyan">TLDR, if you have as many consistent and independent equations as unknowns, we can uniquely solve them.</span>
>
> - also, the number of independent equations (if your system is consistent) can never be greater than the number of unknowns.
>   - so if you only have 2 unknowns, you only need 2 equations.

#### How you can get infinite/no solutions

<span style="color:lime">**Graphically (on 2 axes, x and y), if you have 2 line-equations and they have the same gradient:**
</span>

- you won't have a solution if the 2 lines have the same gradient but different y-intercepts, because they're parallel and have no intersection.

- you will have infinite solutions because the lines are parallel and in the exact same place, so all points on one line equation will also be on the other equation.

<span style="color:cyan">**But in LA, we can see this after we convert them into RREF form:**
</span>

Once you turn your equation into a matrix (termed "converting it into row echelon form") and manipulate it abit, you might find that **two or more rows are <u>linearly dependent</u>**, and have the same span (equivalent to 2 lines having the same gradient).

This means they either directly intersect over each other and have infinite solutions, or are parallel to each other with no solution.

- And if theres a third line, hopefully it intersects with the parallel lines and still gives you infinite solutions).

---

## Converting a system into a matrix equation (Gaussian Elimination)

- covectors can be reordered as you like (since given the context, that means the order of equations in your matrix which shouldn't matter)
- you just turn your system into a matrix equation of $Ax=B$ where:
  - A is a matrix of coefficients in the system
    - number of cols in A = number of variables
    - number of rows = number of equations
    - elements of A = coefficients of the equation
  - x is a column vector of variables
    - has as many dimensions as variables involved
    - matches the number of columns in A
    - the order of variables here must also match the coefficients in A.
    - also can be seen as a linear combination of the basis vectors
  - B is a column vector of constants
    - elements are the constants for each corresponding equations

  so you end up with :
  - A &#8594; $\mathbb{R}^{<\text{no. of eqns}> \times \text{<no. of variables>}}$
  - x &#8594; $\mathbb{R}^{<\text{no. of variables}>\times 1}$
  - B &#8594; $\mathbb{R}^{<\text{no. of eqns}>\times 1}$

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

- Where you represent your system entirely with a matrix, and add the constants vector to the end of your coefficients matrix and add it as a new column, ie:

$$
x +y = 5 - (1) \\
x - y = 1 - (2) \\
$$

Now convert into the eqation with the form of $Ax=b$:

$$

\begin{pmatrix}
    1 & 1\\
    1 & -1
\end{pmatrix}x =
\begin{pmatrix}
    5 \\
    1
\end{pmatrix}
$$

Now write the augmented matrix and turn the equation into Row Echelon form :

$$
\begin{bmatrix}A|b\end{bmatrix} =

\begin{bmatrix}
    1 & 1 & | & 5\\
    1 & -1 & | & 1\\
\end{bmatrix}
$$

The line is just there to partition the constants from the coefficients and is just here for demonstration. You do not present it when writing your answer.

> [!tip] Terminology Note:
> Row Echelon Form &#8212; its what you call the augmented matrix of a system of linear equations.

## RREF and Gaussian elimination

Once you have it in REF form, you can start carrying out <u>Elementary Row Operations</u> to convert it into Reduced REF.

- This where you manipulate your augmented matrix with the following valid operations:
  - swapping rows
  - scaling rows
  - adding scalar multiples of entire rows to another row  
  
  And these operations do not have any effect on what the solution is.

- Once you have a single equation with 1 variable and constant, you use back susbtitution.
  - alternatively, you can just plug values back into the system once you  have enough information, you don't need to present it in the form of the augmented matrix's coefficient half being an identity matrix.

- As a pointer, try to get an upper triangular matrix on the coefficient side of the augmented matrix cuz then the equations are formatted for you when you back susbtitute.
  - ^ That means try to get all the elements below the main diagonal in your augmented matrix to be 0.
  - start with making any element in the first column 0, and work leftwwards to get rid of all the coefficients.
  - Also, once you have the RREF form of the matrix, the first elements on each row touching the 0s in the coefficient matrix part of the augmented matrix can be referred to as "pivots":

  $$
    \begin{pmatrix}
      5&2&11&3\\
      0&3&7&4\\
      0&0&1&9\\
      0&0&0&8\\
    \end{pmatrix}
  $$

  The pivots are 5, 3, 1 and 8.
  - Each row starts with a non-zero element strictly after the previous row's first non-zero element (first row has 4 elements, 2nd row has 3 elements and starts at 2,2... etc)
  - basically if the staircase of 0s is there, the elements touching it are your pivots.
  
  $$
  \begin{bmatrix}
    5&2&7&3\\
    0&0&6&4
  \end{bmatrix}
  $$

  - your pivots here are 5 and 6, and are each valid.

> [!tip] Lore: Echelons
>
> Echelons mean "stairs" in french so thats what you should make your matrix, a staircase of 0s.

Note that ultimately, these element row operations don't alter the matrix significantly because the magnitude of the determinant is still the same, and is symbolic to algebraically manipulating your equations.

>[!caution] REMEMBER TO ALWAYS SUB BACK IN YOUR RESULTS.
> Make sure your calcs are correct. You are not a calculator.

---

## Rank

- Defined from pivots (aka the "leading coefficient").
  - Pivots &#8212; the first element of every row touching the stair-case of 0s after your matrix is in RREF.
    - only if the row is full of 0s, then there is no pivot in that row.
    - The column with the pivot for a row is termed "the pivot column"

- **Rank** &#8212; The number of pivots a matrix has.

### Basic properties to note

- Check with respect to $w = min(m,n)$ for the rank of A in $\mathbb{R}^{m\times n}$:
  - A matrix rank cannot be more than $w$, cuz it exceeds the size of the matrix (quick example of $3 \times 5$ matrix)
  - if a matrix's rank = w, it is a <span style="color:cyan">Full-rank matrix</span>
  - if the rank < w, then it is <span style="color:crimson">rank-deficient</span> by $w-rank(A)$
    $$
    A = \begin{bmatrix}
      5&4&3\\
      0&4&3\\
      0&0&3\\
      0&0&0\\
      0&0&0\\
    \end{bmatrix},
    B = \begin{bmatrix}
      5&4&3&2&1\\
      0&0&3&2&1\\
      0&0&0&2&1\\
    \end{bmatrix}
    $$

    These is considered a full-ranked matrix, despite A having no pivots in rows 4 and 5, and B just looking weird.

---

### Interpreting results of RREF (ie with weird solutions, $\infin$ or none)

- ie for a matrix with  no solutions like $\begin{pmatrix}1&1&2\\0&0&1\end{pmatrix}$:
  - contradiction will reveal itself where the coefficient side is equal to some constant (which is symbolic to $0x+0y=3$ which makes no sense)
  - the system is termed <u>inconsistent</u>.
  - If a system is inconsistent, it means theres no solution (the equations involved do not graphically intersect at all).
  - "If we have a row in REF with all zeros on the LHS / coefficient matrix side, and a non-zero value on the RHS / constant side, the system is inconsistent and there is no solution."

- ie for a matrix with a unique solution like $\begin{pmatrix}1&0&2\\0&1&1\end{pmatrix}$:
  - number of pivots = number of variables, which is a good sign
  - But if there are less pivots than variables, gg you have $\infin$ solutions, ie:
      $$
      \begin{bmatrix}
        1&1&|&5
      \end{bmatrix}
      $$

      1 pivot but 2 variables therefore infinite sols.

  - Its also impossible to have more pivots than vars. Check your math.

As a tree of conditions, check $\begin{bmatrix}A|b\end{bmatrix}$:

1. Is there any row where I have 0s on the $A$ side and non-zeros on the $b$ side?  
(aka is there a $0=b_{ij}$ row)

    - yes = inconsistent system = no solutions
    - no  = consistent system = solutions exist

2. Does the number of pivots I have match the number of ranks in my REF?  
(aka is my rank = # vars)

    - yes = independent equations = unique sol
    - no  = dependent equations = inf sol
    - just don't be fooled by having more qns than variables.

---

## How rank relates to Solvability

- by default, if your matrix (given a square matrix post RREF) is rank-deficient, it default means that there's probably a 0 on your main diagonal, and if thats the case your determinant is probably 0.

## Back to Gaussian Elimination for Determinants

- its tough to compute by hand, easier for computers.

1. Find RREF of the square matrix first, turn it into an upper triangular matrix
2. if your lower triangle is full of 0s, it means your determinant will just be te product of the diagonals
3. remember to factor back in the scales and row exchanges you did cuz:
    - swapping rows flips the determinant sign
    - adding rows to other rows doesn't change the value

---

## Extra Back substitution stuff

- just look at the final RREF-ed matrix, ie:

$$
\begin{bmatrix}
  1&1&|&5\\
  0&-2&|&4
\end{bmatrix}
$$

Back substitution is just where we incude all the variables again so we can interpret that $0x -2y = 4$.

- once we compute that, we just sub it back into the other equations.

### For infinite solutions

Given we have an RREF where no row is 0 but rank < # vars (meaning $\infin$ solutions) ie:

$$
\begin{matrix}
  1&1&1&|&6\\
  0&0&-1&|&-3\\
\end{matrix}
$$

Procedure is to:

1. keep variables with no pivot associated to be free (ie y-var has no pivot so we say it can take on any value)

- we still back-susbtitute to calculate z, giving us $z=3$
- sub into row 1, and let y = t, you'll get $x + y = 3 = 6 \implies x=3-t$
- get the resultant vector $\begin{bmatrix}x\\y\\z\end{bmatrix} = \begin{bmatrix}3-t\\t\\3\end{bmatrix}$

- from there, figure out how to factor out t and make it a scalar:
  $$
  \begin{bmatrix}3-t\\t\\3\end{bmatrix}
  =
  \begin{bmatrix}3-1(t)\\0-1(t)\\3-0(t)\end{bmatrix}
  =
  \begin{bmatrix}3\\0\\3\end{bmatrix}+
  t\begin{bmatrix}-1\\1\\0\end{bmatrix}
  $$

  This gives a valid solution and implies that t can be any scalar.
  - Takes the form of $x = x_p + tx_s$  
      $x_p$ &#8212; termed the "particular solution", which is what x is when y (the free variable) = 0  
      $x_s$ &#8212; termed the "special solution", where any scaled version of it is a solution
        - also it happens to be the answer when Ax = 0.
          - so if all your constants are replaced with 0, it happens to be your solution.
      $t$ &#8212; a container scalar.  
      The whole thing is called the "complete solution", = Particular sol + special sol $\times$ Scalar

  In effect, you have a line of vectors as solutions.

  - Graphically, this represents a vector that is made of both the particular sol and any vector along the span of the special sol.
    - the complete solution can have as many free variables as needed.

> [!tip] Trivia: Homogeneous equations
> Its what you call the equations we work with in our system, and all the terms have the same order (ie all variables are of power 1 / degree 1 / $x^1$)  
> The associated special solution is also termed a homogeneous solution.
