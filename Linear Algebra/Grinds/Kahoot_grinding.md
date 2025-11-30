# Kahoot Grinding

Started from Kahoot > lesson content > ICE > ICA > Mock.

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

All basis matrices should only have linearly independent columns, hence they all must have full rank.

- QR decomposition legit is just the Gram-schmidt process:
  - fix the first column vector and normalize it first
  - for each subsequent vector, do $u_k = V_k - \sum^{k-1}_{i=1} \frac{V_k\cdot u_i}{u_i \cdot u_i}u_i$
  - Afterwards make sure each column is normalized to get Q
  - Get R by formula $R = Q^TA$
    - its just a proven thing, because:
      - $A = QR$ Anyway
      - $Q^T = Q^-1$
        - proof is that both $Q^TQ = Q^{-1}Q = I$, since if you do an element-wise multiplication for $Q^TQ$, you realise that only the diagonals will give you 1 while the rest of the elements give you 0.
  - Alt way to get R:
    $$
    A = \left[ \mathbf{a}_1 \mid \mathbf{a}_2 \mid \cdots \mid \mathbf{a}_n \right] = \left[ \mathbf{e}_1 \mid \mathbf{e}_2 \mid \cdots \mid \mathbf{e}_n \right]
    \begin{bmatrix}
    \mathbf{a}_1 \cdot \mathbf{e}_1 & \mathbf{a}_2 \cdot \mathbf{e}_1 & \cdots & \mathbf{a}_n \cdot \mathbf{e}_1 \\
    0 & \mathbf{a}_2 \cdot \mathbf{e}_2 & \cdots & \mathbf{a}_n \cdot \mathbf{e}_2 \\
    \vdots & \vdots & \ddots & \vdots \\
    0 & 0 & \cdots & \mathbf{a}_n \cdot \mathbf{e}_n
    \end{bmatrix}
    = QR.
    $$
    not advisable, error prone.

- rotation matrix angle formula:
  - principle is that you need a matrix for a rotation between 2 axes.
  - so for 2D, you only need 1
  - for 3d you need 1 for x-y, y-z and x-z = 3 matrices
  - for 4d you need one for w-x,w-y,w-z, x-y, y-z and x-z
  - effectively, the number of matrices = how many ways to pick 2 axes.
    - for this it becomes $_nC_2 = \begin{pmatrix}n\\2\end{pmatrix} = \frac{n(n-1)}{2}$

---

## Week 9 content

- span just means that any vector that can be made using the basis is under that span, and can have infinitely many elements.
- if Ax=b has infinite solutions:
  - Column space of A contains vector b
  - system is consistent and solvable so long as b is in A's column space
  - Because solutions can be infinite, it means you don't have enough pivots / variables as equations, so that means your matrix is rank-deficient
    - that means your matrix null space will have non-trivial solutions.
    - as per rank nullity theorem, your null space rank will just be number of columns in A - rank(A)
- Good basis for column space A is legit just its pivot columns
- for its row space can be its REF-ed pivot rows or its pivot rows in general
- null space basis is

### Spaces defined

- For the 4 spaces:
  - <span style="color:red">C(A) &#8212; Column space of A</span>
    - a set of vectors from the linear combinations of the rows of A
    - Column space basis is made using original matrices' columns corresponding to pivot columns from RREF
  - <span style="color:cyan">$C(A^T)$ &#8212; Row space / column space of A-transpose</span>
    - A set of vectors from the linear combinations of the rows of $A^T$
    - Row space basis is made using either:
      - original matrices' rows corresponding to pivot columns from RREF
      - or the RREF pivot rows themselves. (canonical form)
      - or the REF pivot rows themselves.
  - <span style="color:yellow">$N(A)$ &#8212; Null Space</span>
    - Solution set of Ax=0
  - <span style="color:lime">$N(A^T)$ &#8212; Left Null space</span>
    - Solution set of $A^Ty=0$
    - basically, how can i get a linear combo of the rows of A to get 0
    - named so because $A^Ty = 0$ is the same as $y^TA = 0$ and we're basically finding a linear combination of rows from A to get the 0 vector.

- x can be in one of 3 spaces:
  - the row space of A that gives you some b
  - the null space of A that gives b=0 through A
  - be a linear combination of the two where it'll still give you some b.

- for A in $\mathbb{R}^{m \times n}$:
  - domain refers to number of rows, n
  - codomain refers to the number of columns, m.
  -

---

## Week 10

- projecting b onto q means q is the canvas vector
  - that means you use q to make the projection matrix.
  - Projection matrices are symmetric, rank one and square.

- projection matrices can't be inverted cuz:
  - projection destroys information about the original vector
  - multiple vectors can have the same projection
  - projecting b gives us b-hat which is in the column space of the projection matrix.

- error from projecting onto the subspace is just e = b - b_hat. points in the same region as b, and is orthogonal to our projection space.
- $P^n = P$ cuz projecting a matrix onto itself gives you the same thing.
  - however, that doesn't mean it has an inverse cuz it has determinant 0 and is singular.

---

## Week 11

- A needs to be a square matrix to have eigenvalues
- any real square matrix may not even have real eigenvalues
  - but it will always have conjugate pairs.

Basic eigenvalue properties:

- sum of eigenvalues is the trace / sum of diagonal elements
- product of eigenvalues is the determinant
- Full rank matrix will only have non-zero eigenvalues
- only if a matrix is singular will you have eigenvalues of 0
- For Real symmetric matrices, you will have all real eigenvalues and a full set of eigenvectors.
- The eigenvalues of a real, antisymmetric matrix ($A^T=−A$) are purely imaginary

>[!caution] EIGENVECTORS
>
> - there is no such thing as the eigenvector of your matrix being a null vector.

- matrix interactions with $\alpha$ (using A)
  - $\alpha A$ causes all eigenvalues to to scale the same amount
  - $A + \alpha I$ causes all eigenvalues to become $\lambda_i+\alpha$
  - the inverse will have the same eigenvectors, but eigenvalues will be $\frac{1}{\lambda_i}$
  - and for $A^n$, the eigenvalues also just take on the same indices so $\lambda_i^k$

- **Diagonalizability**
  - Algebraic multiplicity (AM) = number of times an eigenvalue occurs (so if all your roots are unique, all eigenvalues have AM = 1, if you have a conjugate pair, then AM = 2)
  - Geometric Multiplicity (GM) = number of eigenvalues correspondng to an eigenvalue.
  
  TLDR, there must be enough eigenvalues to produce enough eigenvectors.

i.e. for

$$
A = \begin{bmatrix}
2&0&-2\\
0&3&0\\
0&0&3\\
\end{bmatrix}
$$

- we can see A has 2 eigenvalues, 2 and 3, that we will label $e_1$ and $e_2$
  - $e_1$ has
    - an AM of 1 since the characteristic polynomial gives us 1 root with that value
    - a  GM of 1 when we sub in 2 into $A-\lambda I$

  - $e_2$ has
    - an AM of 2 since 2 roots have that value
    - a  GM of

---

## Week 12

- speedrun finding an inverse using Gauss-jordan elim for [A|I] -> [I|A^-1].
  - alternatively can use Cramer's rule.
- a matrix is diagonalizable if AM > GM.
- QR Algorithm can be used to find eigenvalues by setting Q as the eigenvalues and R is just a diagonal matrix.

---

## Week 13

- as
-

---

## Important Properties of matrices
