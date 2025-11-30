# Kahoot Grinding

## Week 1

- for equations with multiple variables, you still test for linearity using 1 scalar i.e.:

  - $f(sx,sy,...sn) = s\space f(x,y,...,n)$ for homogenity
  - $f(x+x',y+y',...n+n') = f(x,y,...,n) + f(x',y',...,n')$ for additivity

    Think of it like each function as a vector, and each input is just a component.

---

## Week 2

- vectors with all components 0 still are in the containing space = the number of components they have (so if i have a vector of $\mathbb{R}^{n}$, setting all of my values to 0 doesn't change that)

- for a containing space of $\mathbb{R}^{n}$, if you already have n linearly independent vectors, you can't find another one that is independent of the other n.

- apparently a vector dot product is the same as a matrix product, because in a sense you just think of a matrix as a vector of covectors, and doing $a^Tb$ with 2 matching-shaped matrices is like doing block multiplication.

- for row picture and column picture ease of remembering:
  - alphabet, c comes before r, so columns on the left, rows on the right for AB = C
    - so A's columns are used to make C
      - each column of C is a linear combination of scalars from each corresponding row of B and the columns of A

    - so B's rows are used to make C
      - each row of C is made as a linear combination of scalars from each corresponding column of A ad the rows of B.

- dot product is commutative but not matrix multiplication.
  - $AB!=BA$ but $a\cdot b = b \cdot a$.

---

## Week 3

- For transpose-rules:
  - $A^T+B^T = (A+B)^T$
  - $AB^T = B^TA^T$
- diagonal matrix = only has elements along the diagonal
- determinant remains the same when you transpose a matrix
- cofactor sign depends on the row you're on, where $C_ij = (-1)^{i+j}M_ij$

- determinant of the inverse: $|A| = \frac{1}{|A^{-1}|}$
  - NO MINUS SIGN

---

## Week 4

"If we have as many equations as unknowns, we can solve them"

- just means that there is a unique solution.
- equations are independent if one cant be represented in terms of the other.
- consistent = no row where all 0s and 1 non-zero
- number of solutions = infinite if rank of coef matrix < number of rows
- PLANE EQUATION is ax+by+cz = d

- swapping rows may cause the determinant to flip signs
  - we leave that to the P matrix in PLU decomposition
  - so |P| usually is $\pm 1$
  - |L| is also usually = 1
  - so that means deteterminant of A is usually the same magnitude as |U|

---

## Week 5

- rank can be changed by editing the matrix so that ultimately its RREF will have more rows

- REF vs RREF / Gaussian Elimination vs Gauss-jordan / LU vs PLU decomp
  - for REF, the EROs used typically are:
    - swapping rows
    - adding a multiple of one row to another
    - NOT multiplying any row by a scalar
    - so standard LU Decomp can leave the matrix with diagonal elements that aren't just 1 or 0.
  - for RREF, then you also apply scaling as EROs.
    - That means the resulting U matrix will have diagonals with 0 or 1.
    - Your U matrix must also have these properties
      - all pivots values are 1
      - all non-diagonal values are 0 except the constant part of the matrix.
    - This state is termed the canonical form.

- Left inverse = right inverse only for invertible matrices. Basically the only valid inverse for a matrix is one where you end up with a gram matrix.
  - so make sure the resulting matrix is just sized to be the smaller side (ie it will be a square matrix with sides = smaller dim of your original matrix, and each element has to have a longer computation.)

---

## Week 6

- vector space and subspace are 2 different things, subspace means that the span doesn't cover the entire containing space.
- if a matrix is full ranked, that means that it spans its entire containing space, so the only way you can have Ax=0 is when x takes 0 of each vector.
- span of vectors can only work if they both are in the same containing spce, ie one in r2 one in r3 wont work
- you can have more variables than equations (thats what a wide matrix is) but it is only inconsistent if b cannot be represented by as a linear combination of A's columns.

---

## Week 7

