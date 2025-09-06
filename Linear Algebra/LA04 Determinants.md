# Determinants

Abstractly, it hold as much info about a matrix as possible.

- Can be described as a function of the elements of a matrix.

### 2x2 determinant formula

![2x2 det formula](https://graphicmaths.com/img/pure/matrices/determinants/det-2-2.png)

## Determinant properties (intro)

- Only defined for a square matrix (so $A \in \mathbb{R}^{m \times m}$)
- denoted by $det(\bold{A}),\Delta \text{ or }|\bold{A}|$
- As a function, we write it as $|\bold{A}|= f(a_{ij})$

## Determinant POV with matrices as a transformaton ($det(A) = 0 \implies$ no unique solution )

Given $Ax = b$, you can treat A as a function mapping vectors that you slot into x to vectors you slot into b.

- if you treat it like a mapping where for $A \in \mathbb{R}^{m \times n}$, A becomes a function that maps vectors with the same num of cols to ones with the same num of rows:
    $$A : \mathbb{R}^n \mapsto \mathbb{R}^m$$

    and with this:

    $$Ax = b$$

    we can technically say "A transformed vector x into vector b", and

    $$x = A^{-1}b$$

    is like undoing the transformation of b into x, and we can write that:

    $$A^{-1} : \mathbb{R}^m \mapsto \mathbb{R}^n$$

- Anyway, if $\Delta = 0$ that means the matrix has no inverse, and the mapping done by A is irreversible.
  - that also means that A is a singular, non-invertible matrix.
  - conversely, if $\Delta \neq 0$, $A^{-1}$ exists and b can be reversed into x.
    - more specifically, there is no single solution, it could be that theres no solution or infinite solutions.
    - <span style="color:cyan">Checking for the existence of a non-zero determinant is the necessary and sufficient condition for unique solutions (by Manoj)</span>
      - the determinant is informative of the solvabiity of the system of linear equations it represents.

## Determinant POV with geometric ideas (legit some cool shit)

- recall how we could interpret the column picture of matrix multiplication:
    ![col picture of matrix multiplication](data:image/png;base64,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)

  - basically give $AB = C$ you partition C into columns, and get these columns by calculating the linear combination of each column in A with the elements of B.
    - for a quick refresher, row picture is when you partition c into rows, and get these rows by calculating the linear combination of each row of B with the elements of A.

- With the following calculations:
    $$

A \begin{pmatrix} 0 \\ 1 \end{pmatrix} = \begin{pmatrix} a & c \\ b & d \end{pmatrix} \begin{pmatrix} 0 \\ 1 \end{pmatrix} =0\begin{pmatrix} a \\ b \end{pmatrix} + 1\begin{pmatrix} c \\ d \end{pmatrix} = \begin{pmatrix} c \\ d \end{pmatrix} \text{(for y-part)}
\\
\space
\\
A \begin{pmatrix} 1 \\ 0 \end{pmatrix} = \begin{pmatrix} a & c \\ b & d \end{pmatrix} \begin{pmatrix} 1\\ 0 \end{pmatrix} = 1\begin{pmatrix} a \\ b \end{pmatrix} + 0\begin{pmatrix} c \\ d \end{pmatrix} = \begin{pmatrix} a\\b \end{pmatrix} \text{(for x-part)}
    $$

    We notice that for a 2x2 matrix A with the column picture, if we just use the basis vectors for each dimension of $\mathbb{R}^2$, we can see that the A maps the unit vector for the y-axis to a new vector (c,d) and the unit vector for the x axis to a new vector (a,b).

    Since we can also represent any vector as a linear combination of these 2 unit vectors, we can interpret it that this matrix is transforming our vector by "updating the vectors making up our input vector."

    With the example $z=\begin{pmatrix}4\\2\end{pmatrix}$:

    $$
    Az = \begin{pmatrix}
    a &b  \\
    c & d
    \end{pmatrix}(4\begin{pmatrix}
    1\\0
    \end{pmatrix}+2\begin{pmatrix}
    0\\1
    \end{pmatrix})=  \begin{pmatrix}
    a &b  \\
    c & d
    \end{pmatrix}(4\hat{x}+2\hat{y})
    
    $$
    and because matrix multiplication is distributive (meaning A(bX+cY) = A(bX) + A(cY) where b and c are scalars and A,X,Y are matrices):
    $$
    \begin{pmatrix}
    a &c  \\
    b& d
    \end{pmatrix}(4\hat{x}+2\hat{y}) = 4A\begin{pmatrix} 1 \\ 0 \end{pmatrix} + 2A\begin{pmatrix}0\\1\end{pmatrix} \\
    = 4\begin{pmatrix} a \\ b \end{pmatrix} + 2 \begin{pmatrix} c \\ d \end{pmatrix} 
    $$

    TLDR, A is a mapping that swaps out the vectors you get from partitioning the identity matrix (termed "basis vectors") to the vectors you get from partitioning the columns of A.

- The geometric part comes in when you actually visualise how area of the square formed by the basis vectors change after applying the matrix:
    ![parallelogram formula](https://i.sstatic.net/RJFQ3.png)

    TLDR, after processing the formula of a parallelogram, you end up with the determinant formula for a 2x2 matrix.
  - If the determinant ends up being negative, thats just because the vectors forming the parallelogram are now crossed.
    - by normal assumption, we assume that when we scale the x and y vectors, they wont cross. In this situation, they do, so the area they give us is valid but now negative-signed.
  - Thats also why underhandedly, if the area of the rectangle is 0 it means that the basis vectors were transformed to be on the same span, that means you can't have unique solutions anymore (cuz that would mean that the columns of the partitioned matrix are linearly dependent).

- Ultimately, determinants for matrices in higher dimensions just look at the measure of space occupied in higher dimensions and formula for them is obtained via
  - getting the identity matrix and transforming it with a matrix of choice
  - finding how much space it has in its confines (ie for 2d, check area, for 3d check volume of parallelopiped, 4d its the hypervolume of a hypercube etc)
  - find the associated formula and simplify it.

## Recursive formula for the 3x3 determinant using 2x2 determinant formula

- iykyk but it looks like the cross product of the bottom two row matrices.

![recursive det formula for 3x3](https://www.sharetechnote.com/image/EngMath_Matrix_Det_3x3_05.png)

- memory trick:
    1. alternate rows, first term is +, second is -, third is +
    2. Go from left to right columns
    3. keep the topmost value of each column in mind
    4. focus on the bottom 2x3 half of the matrix (termed bottom part)
    5. ignore the values in the same column topmost value in the bottom part (termed a submatrix)
    6. find the determinant of the remaining values (termed the minor, denoted wit $M_{ij}$ where i and j are rows and columns respectively)
        - the minor with a sign is a cofactor.
        - conveniently, the sign has a formula $C_{ij} = (-1) ^ {i+j}M_{ij}$
    7. repeat for the rest of the values.

- Final Formula (read the memory trick first):
    $$|A| = \sum_{j=1}^{n} (-1)^{(i+j)} a_{ij}M_{ij} = \sum_{j=1}^{n} a_{ij}C_{ij}$$

    Termed the laplace expansion of the determinant.
    Works for n-sized matrices.

## Determinant Properties (intermediate)

- The Identity matrix has a determinant of 1 ($|\bold{I}| = 1$)
- Swapping rows or columns will flip the determinant's sign.
- multiplying either a row or a column by a factor will scale the determinant by that factor.
  - think of it like making 1 side bigger to expand the space it occupies.
  - also theres a proof where you can do:

    $$
    \begin{vmatrix}
    a+a' & c+c' \\
    b & d
    \end{vmatrix}
    =
    \begin{vmatrix}
    a & c \\
    b & d
    \end{vmatrix}
    +
    \begin{vmatrix}
    a' & c' \\
    b & d
    \end{vmatrix}
    $$
    - Also by coincidence, equating one row to 0s makes the determinant 0.
    - The proof also extends to columns if you transpose the matrix first, then transpose it back.
- if you add a multiple of a row/column to another row/column, the determinant remains unchanged.
- if two rows/columns are equal, then your determinant is 0.
- the determinant of a triangular matrix is just a product of the diagonal elements.
  - same applies for if its a diagonal matrix.
- if the determinant is 0, then the matrix is singular
  - if the determinant is not zero, it is invertible (it has an inverse).
- the product of the determinant of AB is the same as the product of the component matrices' determinants &#8594; $|AB| = |A||B|$
  - and because of this, the inverse's determinant is just 1 / the original's determinant cuz $A A^{-1} = I$
- The determinant of the transposed matrix is the same as the original.

## Shortcuts for calculating the Determinant

- Try to get as many 0s in your matrix (or in a single row / column) as possible by:
  - using row manipulations (since remember that shifting around rows doesn't change the detemrinant) and converting it into an RREF Form (see [LA05](LA05%20Gaussian%20Elimination%20(solving%20linear%20systems).md))
  - using relevant determinant properties

### Format for using these shortcuts

1. <span style="color:cyan">Write down clearly that we are trying to find the determinant given a matrix:</span>

  $$
  |A| = \begin{vmatrix}
  1 &2  &3  \\
  4 &5  &6  \\
  7 &8  &9
  \end{vmatrix}
  $$

- important because if you write this as a matrix, factoring out scalars means you're factoring them out from all elements of a matrix.
- Here, we are only factoring out rows from the determinant, despite using the same notation:

  $$\begin{vmatrix}
  2 & 2  \\
  3 & 6
  \end{vmatrix} = 2 \begin{vmatrix}
  1 & 1  \\
  3 & 6
  \end{vmatrix}$$

  This is Ok because factoring out 1 row doesn't change the determinant

  $$\begin{pmatrix}
  2 & 2  \\
  3 & 6
  \end{pmatrix} \neq 2 \begin{pmatrix}
  1 & 1  \\
  3 & 6
  \end{pmatrix}\\
  = 2 \begin{pmatrix}
  1 & 1  \\
  \frac{3}{2} & 3
  \end{pmatrix}
  $$

  This is not ok, factoring 1 row is not allowed, only if you factor from all the elements, then the notation makes sense.

2.
