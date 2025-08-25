# Matrices

- A table of numbers with rows and columns, where all the numbers are of the same type.
  - dimensions of the table take on the format \<rows\>x\<columns\>
  - the subspace we adopt for this is known as $\mathbb{R}^{\text{rows} \times \text{cols}}$
  - numbers that elements can take on are integers, rational nums, real, complex nums
    - order of sets is $\mathbb{Z} \subset \mathbb{Q} \subset \mathbb{R} \subset \mathbb{C}$. Q refers to rational nums.
  - the numbers also don't necessarily need to represent the same physical quantity.
  - terminology for alluding to the set of numbers that the elements of the matrix are composed of is "over the field" &#8212; ie "this matrix exists over the field of real numbers."

- vectors are usually known as 1D matrices with size n x 1 (where n is the number of dimensions that they occupy.)
  - note, rows of numbers are not vectors, they are called covectors. sometimes its just easier for presentation with in-line text, but frankly its wrong and usually justified earlier on in textbooks.

## Matrix operations

### matrix dot product

- Same as vectors, just multiply each element by the scalar value.
- Considered a closed operations since they result in a matrix, which is part of the input's set.

### Matrix multiplication

- First, make sure that the order of matrices allow for the operation.
  - given $A \times B$, the number of columns in A must match the number of rows in B.
  - resulting matrix will have dimensions of A's rows and B's columns.
  - TLDR, $A_{m\times n} \times B_{p\times q} = C_{m\times q} \text{where } n=p$

- **Doing it intuitively**
  - put the first matrix to the left, the second matrix on top
  - dot product for each vector and covector along each element.
  - check quickly by just looking if the length along the first matrix and the width of the second.  
    ![A on the side, B on the top](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRl-FekHGJ2ZpCrIyZrKYWJ_jk-Vhozu1eyfw&s)

#### Common properties

- scaling and addition are:
  - commutative (order doesnt matter)
  - associative (can be grouped with brackets and still return the same result)
  - distributive ($A(B+C) = AB + AC$ is valid, you can pull out factors.)

- For Matrix multiplication:
  - it is <u>not</u> commutative.
    - Given $A \times B$, the number of columns in A must match the number of rows in B, and you can't always do $AB=BA$.
  - it is associative.
    - $(AB)C = A(BC)$.
  - Also, $\text{given }AB = AC, B \neq C$
    - counter-example is if A is a null matrix.

### Matrix Transpose

Take the matrix, draw a line from the top left to the bottom right. Flip your matrix accordingly.

- transposing a matrix twice gives you the original matrix.
- transposing the inputs before adding them is the same as adding first then transposing
- scalar multiplication with transposing is commutative (same result regardless of whether you transpose before or after)
- matrix multiplication before and after transpose is the same if done together.

#### Product rule

- basically, to get $(AB)^T$, you flip the matrices and transpose both.
  - so $(AB)^T = B^TA^T$

## Types of matrices

### Square matrices

- same number of rows and columns.
- transposing a matrix then multiplying it by itself results in a square matrix.

### Symmetrical matrices

- check whether $(B^TB)^T = (B^T)B$
  - proof for this is just the commutative transpose rule where $(AB)^T = B^TA^T$, sub B for itself and A its transpose

### Diagonal matrices

Diagonal &#8212; a matrix that has non-zero elements along the main diagonal (which is the top left to bottom right line), and 0 everywhere else.

- note, all matrices have a main diagonal, this is not exclusive to square matrices.
  - It just ends where the rows end, and defined as elements where both the indices of the row and column are the same.
- it is considered symmetric.

### Identity matrices

- a square diagonalized matrix with only 1 in its main diagonal.
- returns the same matrix when multiplied by this identity matrix.

### Triangular matrices

- When you have a matrix, populate its main diagonal, and either the elements above or below the diagonal <u>are all zero</u>.(named lower and upper triangular matrices respectively).
- Anyway, Diagonal matrices are both upper and loewr triangular matrices.

---

## Visualising Matrix multiplication with other techniques

### dot product picture (if you only need 1 element)

- where each element in the matrix is seen as a dot product for its corresponding row and col in A and B, so
  $$
  M_{i,j} = (\text{row A})_i \cdot (\text{col B})_j
          = (row_{Ai})^T\cdot(col_{Bj})
  $$

### Column picture matrix multiplication

- Basically some rule that:

    *" If A and B are two matrices and their product is AB, the columns of AB = linear combinations of A."*

- In practice, this looks like (given the matrix multiplication of $\begin{bmatrix}
1 & 2 \\
2 & 4 \\
3 & 2
\end{bmatrix} \times \begin{bmatrix}
1 & 1 \\
2 & -1
\end{bmatrix}$):
  - take each element in the first column of numbers in the second matrix, view them as scalars
  - take the columns in the first matrix as vectors
  - the first column will look like:
        $$\sum^{\text{columns}}{\sum^{\text{rows}}{\text{scalar B}_{\text{row},\text{column}}\cdot\text{vector A}_{\text{column}}}}$$
  - ie. to get the first column of AB, we just do:
    $$(1)\begin{bmatrix}1 \\
    2 \\
    3
    \end{bmatrix} + (2)\begin{bmatrix}
    2 \\
    4\\2
    \end{bmatrix} = \begin{bmatrix}
    (1)(1)+2(2)\\
    (1)(2)+2(4)\\
    (1)(3)+2(2)\\
    \end{bmatrix} = \begin{bmatrix}
    5\\
    10\\
    7\\
    \end{bmatrix}$$

and this gives us the first column of AB. Rinse and repeat for the rest of the columns of B.

$$
(1)\begin{bmatrix}1 \\
    2 \\
    3
    \end{bmatrix} + (-1)\begin{bmatrix}
    2 \\
    4\\2
    \end{bmatrix} = \begin{bmatrix}
    2\\
    4\\2
    \end{bmatrix} = \begin{bmatrix}
    (1)(1)+(-1)(2)\\
    (1)(2)+(-1)(4)\\
    (1)(3)+(-1)(2)\\
    \end{bmatrix} = \begin{bmatrix}
    -1\\
    -2\\
    1\\
    \end{bmatrix}
$$

concat the columns together to give:

$$
AB = \begin{bmatrix}
    5&-1\\
    10&-2\\
    7&1
    \end{bmatrix}
$$

### Row picture of matrix multiplication

Same idea, different format. Now, we use the scalars from the first matrix, and covectors from the second, and do a linear combination to get each covector:

$$\sum^{\text{rows}}{\sum^{\text{columns}}{\text{scalar A}_{\text{row},\text{column}}\cdot\text{covector B}_{\text{column}}}}$$

# Matrix properties

## Determinants

- important in gaussian elimination.
  - indicates linear independence and other related properties
  - calculating determinants is also complex outside of 2x2 square matrices
- typically denoted as $det(A)$, $\Delta A$ or $\left|  A\right|$.
  - it is always a scalar real value.
  - it only exists for square matrices.

### Determinant of a Square 2x2 Matrix

$$
\text{Given } A = \begin{pmatrix}
a & b \\
c & d
\end{pmatrix},\\
\left|  A\right| = ad - bc
$$

- calculate product of main diagonal ad
- calculate product of other diagonal bc
- subtract main from anti.

### Determinant of the same matrix, transposed

$$
\text{Given } A = \begin{pmatrix}
a & b \\
c & d
\end{pmatrix},\\
\left|  A^T\right| = ad - bc
$$

- calculations should not be affected.

### What Determinants tell us

- if $\left|  A\right|=0$, the Matrix is singular.
  - that means the matrix has no inverse.

### How determinants change with your matrix

- If you swap any 2 rows/columns in $A$, the new determinant is just $\left|  A\right| \times -1$.
  - ie. row A with row B, col 1 with col 2
    - not row A with col B like a transpose.
  - if you swap twice, you get back the original determinant.

---

## Matrix inverse

If B is the inverse of A, where $AB=I$.

- denoted as $A^{-1}$
- $AA^{-1} = A^{-1}A = I$.

### Caclulating inverse for a 2x2 matrix

1. Get the find the determinant of the matrix, keep the value of its reciprocal
2. elements along the main diagonal are swapped
3. non-diagonal elements are just $\times -1$
4. multiply this new matrix by the reciprocal from step 1

    $$
    A^{-1} = \frac{1}{\left|  A\right|}  \begin{pmatrix}
    d & -b \\
    -c & a
    \end{pmatrix}
    $$

### Solving equations with inverses

1. Convert your system of equations into the $Ax=b$ form
2. calculate the inverse of your coefficient matrix, $A^{-1}$
3. multiply both sides of your matrix by this inverse (add to the front)
4. essentially just compute $A^{-1}b$ to get vector $x$
5. associate values with each dimension of vector $x$.
