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

### Scalar multiplication

- commutative closed operation where you just multiply all elements in the matrix by the scalar used.

$$ 4\bold{A} = 4\begin{pmatrix}
1 & 2 \\
3 & 4
\end{pmatrix} = \begin{pmatrix}
4 & 8 \\
12 & 16
\end{pmatrix} $$
- They are also associative since you can group the operands in any manner.
- They are also distributive since you can do $s(A+B) = sA + sB$

### Matrix addition

- commutative closed operation where you just add two matrices of the same size element-wise.
- They are also associative since you can group the operands in any manner.
- They are also distributive since you can do $s(A+B) = sA + sB$

### Matrix dot product

- Same as vectors, just multiply each element by the scalar value.
- Considered a closed operations since they result in a matrix, which is part of the input's set.

### Matrix multiplication

- First, make sure that the order of matrices allow for the operation.
  - given $A \times B$, the number of columns in A must match the number of rows in B.
  - resulting matrix will have dimensions of A's rows and B's columns.
  - TLDR, $A_{m\times n} \times B_{p\times q} = C_{m\times q} \text{where } n=p$
    - This is known as the **conformance requirement**.

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

## More ways to visualise Matrix multiplication (given $A \times B$)

### Column view

- Treat A as a covector of vectors (ie if A is $3\times4$, it is a covector made of 4 vectors in $\mathbb{R}^3$)
  - if B is just a single vector ie of size $4\times1$, then you can effectively do a calculation like a linear combination:
    $$A \times B = \begin{pmatrix}
    |&|&|&|\\
    C_1&C_2&C_3&C_4\\
    |&|&|&|\\

    \end{pmatrix} \times \begin{pmatrix}s_1\\s_2\\s_3\\s_4\end{pmatrix} \\
    = s_1(C_1)+s_2(C_2)+s_3(C_3)+s_4(C_4), \text{where } C_n \in \mathbb{R}^3$$
    - as usual, always double-check that your resultant matrix size makes sense. This should give us a matrix of shape $3 \times 1$.
  - if B is a matrix ie. of size $4\times2$ (or more):
    - first partition B into vectors
    - do the first trick with the first vector of B, and continue rightwards
    - then just concatonate (not add) the elements together.
    $$A \times B = \begin{pmatrix}C_1&C_2&C_3&C_4\end{pmatrix} \times

    \begin{pmatrix}
|&&|\\
S&|&W\\
|&&|\\
    \end{pmatrix}

    \\=

    \begin{pmatrix}C_1&C_2&C_3&C_4\end{pmatrix} \times

    \begin{bmatrix}\begin{pmatrix}
    s_1\\
    s_2\\
    s_3\\
    s_4\\
    \end{pmatrix} & | & \begin{pmatrix}
    w_1\\
    w_2\\
    w_3\\
    w_4\\
    \end{pmatrix}\end{bmatrix}
    \\=
    \begin{pmatrix}s_1(C_1)+s_2(C_2)+s_3(C_3)+s_4(C_4) &|& w_1(C_1)+w_2(C_2)+w_3(C_3)+w_4(C_4)\end{pmatrix}$$

### Row view

- Given $A^TB$ where A is a $4 \times 1$ vector and B is $4 \times 2$, we can treat it like we are doing a linear combination of the covectors in B:
  $$ \text{ie. given } A^T = \begin{pmatrix}
    1 & 2 & 3 & 4
    \end{pmatrix} , B = \begin{pmatrix}
    4 & 6 \\ 5 & 7 \\
    8 & 9 \\ 1 & 2
    \end{pmatrix}=

    \begin{pmatrix}
    - & R_{B1} & -\\
    - & R_{B2} & -\\
    - & R_{B3} & -\\
    - & R_{B4} & -\\
    \end{pmatrix}

  $$
  we expect the answer to have size $1 \times 2$ and do:
  $$A^TB = 1R_{B1} + 2R_{B2} +3R_{B3} 4R_{B4} \\=
  1 \begin{pmatrix}
4 & 6
\end{pmatrix} + 2 \begin{pmatrix}
5 & 7
\end{pmatrix} + 3 \begin{pmatrix}
8 & 9
\end{pmatrix} + 4 \begin{pmatrix}
1 & 2
\end{pmatrix} \\ = \begin{pmatrix}
42 & 55
\end{pmatrix}$$
multiplying on the left is the same as taking linear combos of the rows of the second matrix.
- if A is more than just a covector (ie a matrix of $2\times 4$) then the same partitioning rule applies, just do for each row:

  $$ A = \begin{pmatrix}
          \frac{\begin{matrix}- & P &-\end{matrix}}
          {\begin{matrix}- & Q&-\end{matrix}}
          \end{pmatrix}
      = \begin{pmatrix}
          \frac{\begin{matrix}p_1 & p_2 & p_3 & p_4\end{matrix}}
               {\begin{matrix}q_1 & q_2 & q_3 & q_4\end{matrix}}
          \end{pmatrix}

    , B = \begin{pmatrix}
    4 & 6 \\ 5 & 7 \\
    8 & 9 \\ 1 & 2
    \end{pmatrix}=

    \begin{pmatrix}
    - & R_{B1} & -\\
    - & R_{B2} & -\\
    - & R_{B3} & -\\
    - & R_{B4} & -\\
    \end{pmatrix}
    \\
    \\
    AB = \begin{pmatrix}
          \frac{\begin{matrix}p_1(R_{B1})+p_2(R_{B2}) +p_3(R_{B3}) + p_4(R_{B4})\end{matrix}}
               {\begin{matrix}q_1(R_{B1})+q_2(R_{B2}) +q_3(R_{B3}) + q_4(R_{B4})\end{matrix}}
          \end{pmatrix}
  $$

### Block-wise multiplication

- technically if you're able to partition a matrix into nice blocks, then you can do multiplication block by block
  - ie given $A \in R^{n\times n}$ and $B \in R^{n\times 2n}$, its valid to do:
    $$ AB = A \begin{pmatrix} B_1 | B_2\end{pmatrix} = \begin{pmatrix} AB_1 | AB_2\end{pmatrix}$$
    from there you just work with the partitioned matrices and replace the results with their original positions.

- from there you can also treat A as a vector of covectors, while A is a covector of column vectors, and just operate from there (effectively giving us the normal way of interpreting matrix multiplication.)
  - basically you can do this:
    $$
    B = \begin{bmatrix}b_1 & | & b_2 & | & ... & | & b_n\end{bmatrix}

    $$
    where you can view B as a covector of vectors with size $k\times1$ and given A with size $m \times k$ and B with size $k \times n$:

    $$
    AB = \begin{bmatrix}Ab & | & Ab_2 & | & ... & | & Ab_n\end{bmatrix}
    $$

    And each $Ab_n$ becomes a vector that's of size $m\times1$.

    you can also view A as a vector of covectors:

    $$
    A =
    \begin{pmatrix}
    - & R_{A1} & -\\
    - & R_{A2} & -\\
     & ... & \\
    - & R_{An} & -\\
    \end{pmatrix}
    $$

    which ultimately boils down to the default way of doing matrix multiplication as the dot product of 2 partitioned vectors.

### Alternative interpretation ( messy view \*\*)

- recall that dot product multiplication between 2 vectors can be viewed as a matrix multiplication, where for it to be a valid operation, we transpose the left operand vector to get a $1\times1$ matrix:
  $$
    A \cdot B = A^TB = \begin{pmatrix}a_x&a_y\end{pmatrix} \begin{pmatrix}b_x\\b_y\end{pmatrix} = a_x b_x + a_y b_y = x,\text{ where }x \in \mathbb{R}^{1\times1}
  $$
  However, we can generalize this and view A as a covector of vectors, ie when A is a matrix in the field of $\mathbb{R}^{m\times2}$:
  $$
    AB = \begin{pmatrix}|&|\\\hat{a_x}&\hat{a_y}\\|&|\end{pmatrix} \begin{pmatrix}b_x\\b_y\end{pmatrix} = \hat{a_x} b_x + \hat{a_y} b_y = x,\text{ where }x \in \mathbb{R}^{m\times1}
  $$
  
  TLDR, so long as we can fit our partitioned vectors into this "linear-combination format" of matrix nicely (ie axbx is a valid matrix multiplication), we will have results that match and thus find shortcuts for getting our results by computing parts of a matrix at a time.

  For instance, for the above example of $\hat{a_x} b_x + \hat{a_y} b_y$, so long as $\hat{a_x} b_x$ is a valid computation, then this can hold (and in this case, it does since $\hat{a_x} \in \mathbb{R}^{m\times1}, b_x \in \mathbb{R}^{1\times1}$) so it works out.

  Given any 2 matrices, A and B of arbitrary size mxn and nxk, you can expect to have a resultant shape of m x k but you can also partition your matrix into weird blocks, like:

  $$
  AB =
  \begin{pmatrix}
  A_{11}&A_{12}\\
  A_{21}&A_{32}\\
  A_{31}&A_{32}\\
  \end{pmatrix}
  \begin{pmatrix}
  B_{11}\\
  B_{21}
  \end{pmatrix} =

  \begin{pmatrix}
  A_{11}B_{11} + A_{12}B_{21}\\
  A_{21}B_{11} + A_{22}B_{21}\\
  A_{31}B_{11} + A_{32}B_{21}\\
  \end{pmatrix}  

  $$
  
  so long as:
  - From a macro view, their shapes conform (where ignoring that we're dealing with partitioned matrices and instead thinking of them as elements), the matrix sizes conform for matrix multiplication (so 3x2 and 2x1 match to give some weird object with size 3x1)

  - their dot products can conform to the proposed shape (ie dot product between two math objects make sense)
    - ultimately this sorta forms a recursive formula for matrix multiplication

- Most importantly, it really explains how $Ax=b$ works, where you're taking x, made out of the basis vectors, and swapping these basis vectors out for the vectors that the matrix maps to:

  $$
    Ax = b\\
    \begin{pmatrix}
    |&|\\
    p&q\\
    |&|\\
    \end{pmatrix}\begin{pmatrix}
    x1\\
    x2\\
    \end{pmatrix} =\begin{pmatrix}
    px1+qx2\\
    \end{pmatrix}
  $$

  - you can also think of x as a linear combination of x = ax+by where x and y are the basis matrices, and we swap them out for p and q.
  - Row picture is just the transpose case of this calculation where $y^TA^T = b$.

    $$
    y^TA^T = b\\
    \begin{pmatrix}
    y1&y2
    \end{pmatrix}

    \begin{pmatrix}
    -&p&-\\
    -&q&-\\
    \end{pmatrix} =\begin{pmatrix}
    y1p+y2q\\
    \end{pmatrix}= b
  $$

### Time-complexity of Matrix multiplication

- The setting is with 2 matrices sized $A \in \mathbb{R}^{m\times k}$ and $B \in \mathbb{R}^{k\times n}$
- if you were to calculate each element manually and each addition and multiplication is 1 operation, you'd need:
  - k multiplications and (k-1) additions per element
  - element wise calculation over mn elements
  giving us $mn(2k-1) \implies O(mnk)$, and if we deal with square matrices, its $O(n^3)$.
- The current best algorithm is the Coppersmith–Winograd algorithm with complexity of $O(n^{2.373})$.

## Matrix Transpose

Take the matrix, draw a line from the top left to the bottom right. Flip your matrix accordingly.

- each element's row and column swaps (so $a_{ij}$ becomes $a_{ji}$)

> [!tip] Terminology
> we don't refer to covectors for now, we just call row vectors transposed vectors.

### Cool properties

- transposing a matrix twice gives you the original matrix.
  $$(A^T)^T  = A$$
- transposing the inputs before adding them is the same as adding first then transposing
  $$(A+B)^T  = A^T+B^T$$
- scalar multiplication with transposing is commutative (same result regardless of whether you transpose before or after)
  $$(sA)^T = sA^T$$
  - wayward logic behind this is that a scalar is its own transpose (swapping the element at 1,1 with itself)
- matrix multiplication before and after transpose is the same if done together.
- given x, a vector of size n in the field of real numbers:
    $$ \text{if } x \in \mathbb{R}^n \implies x^T \in \mathbb{R}^{1 \times n}$$
- also given the shape of matrices resulting from matrix multiplication:
    $$  x x^T \in \mathbb{R}, \text{ but } x^Tx \in \mathbb{R}^{n \times n}$$

- the dot product of 2 vectors is technically the same as the matrix multiplication of one vector's inverse and the other:
    $$ a \cdot b = a^T b = b^T a$$

### Product rule

- To get $(AB)^T$, you flip the matrices and transpose both.
  - so $(AB)^T = B^TA^T$
  - This is because transposing them flips m x k into k x m and vice versa, so you need to flip the matrix order to adhere to the conformance requirement.
  $$ A \in \mathbb{R}^{m \times k},  B \in \mathbb{R}^{k \times n} \Rightarrow AB \in \mathbb{R}^{m \times n}$$
  $$ (AB)^T \in \mathbb{R}^{n \times m}$$
  $$ A^T \in \mathbb{R}^{k \times m},  B \in \mathbb{R}^{n \times k} \Rightarrow B^TA^T \in \mathbb{R}^{m \times n}$$

  also the math works out don't worry about it.

- also scales such tht $(ABCD)^T = D^TC^TB^TA^T$

## Types of matrices / Special Matrices

### Square matrices

- same number of rows and columns.
- transposing a matrix then multiplying it by itself results in a square matrix.
  - given A of size m x n, $A^TA$ gives a matrix of size nxn.
  - $AA^T$ gives a matrix of size mxm.

### Symmetrical matrices

- the transpose of this matrix is identical to itself. (symmetry about the main diagonal.)
  - main diagonal &#8212; the line formed by elements where row num = col num (ie elems 1,1 , 2,2 , 3,3 ... form the main diagonal)
- check whether $(B^TB)^T = (B^T)B$
  - proof for this is just the commutative transpose rule where $(AB)^T = B^TA^T$, sub B for itself and A its transpose
- because the rows and columns need to match for this to hold, all symmetric matrices need to be square matrices.

#### Skew-symmetric matrices / Antisymmetric matrices

- when your transpose is negative, such that $A = -A^T \Rightarrow A$
  - this implies that for all elements, $a_{ij} = -a_{ji}$

  ![an example of a antisymmetric matrix ](https://i.sstatic.net/XKGeD.png)

  - usually possible if your main diagonal is made of 0s, and the bottom triangle is a negative reflection of the top triangle.

#### weird thing about symmetry

- Given a square matrix $A \in \mathbb{R}^{n \times n}$:
  - $A + A^T$ gives a symmetric matrix
  - $A - A^T$ gives an anti-symmetric matrix
    - Provable since transposing operands is the same before and after.
    - $(A - A^T)^T = A^T - A = - (A - A^T)$ so transposing it gives us its negative, QED.

#### Cool thing about Gram Matrices

- The square matrix represented by A^TA is known as a Gram Matrix.
  - it is symmetric since transposing it returns itself:
    $$ (A^TA)^T = A^T(A^T)^T = A^T A$$
    (remember that we use product rule and flip the operands)
  - Fyi AA^T is also symmetric.
  - To note, if matrix A has more rows than columns, the gram matrix should be smaller.

- Core purpose of the Gram matrix is as a measure of covariance
  - known as a covariance matrix (how does data along 1 row dim vary with another col dim)
  - but this only applies if your matrix is a zero-centered data matrix
    - zero-centered &#8212; average each column and subtract from each element.

- Application: computing style loss as a loss function for style transfer models ( [simplified](https://www.youtube.com/watch?v=Elxnzxk-AUk&ab_channel=DevelopersHutt) | [technical](https://d2l.ai/chapter_computer-vision/neural-style.html) )

### Diagonal matrices

Diagonal &#8212; a matrix that has non-zero elements along the main diagonal (which is the top left to bottom right line), and <u>0 everywhere else</u>.

- note, all matrices have a main diagonal, this is not exclusive to square matrices.
  - It just ends where the rows end, and defined as elements where both the indices of the row and column are the same.
- it is considered symmetric. Anti-symmetric matrices are definitely not diagonal matrices.
- a zero matrix technically is a diagonal matrix, cuz the requirement is just that non-diagonal elements be 0, the main diagonal can be 0 as well.
  $$ A = [a_{ij}] \in \mathbb{R}^{m \times n}, a_{i,j} = 0 \space \forall i \neq j$$

### Identity matrices

- a square diagonalized matrix with only 1 in its main diagonal, and 0 everywhere else.
  - denoted $I_n$ for size $\mathbb{R}^{n \times n}$
- returns the same matrix when multiplied by this identity matrix. ($AI = IA = A$)
- each column of this matrix is a unit vector, that specifies a direction in the space that they represent.
- basically, you can do:
  $$
  I_3 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix}
  \quad \hat{i} = \begin{bmatrix} 1 \\ 0 \\ 0 \end{bmatrix}
  \quad \hat{j} = \begin{bmatrix} 0 \\ 1 \\ 0 \end{bmatrix}
  \quad \hat{k} = \begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix}
  \quad \boldsymbol{x} = \begin{bmatrix} x \\ y \\ z \end{bmatrix} = x\hat{i} + y\hat{j} + z\hat{k}
  $$
  where each column represents a single unit vector, and you can represent any vector as a linear combo of the unit vectors.
  - all vectors are unit length 1
  - all vectors are orthonormal/perpendicular to each other
  - dot product for any 2 of these vectors is 0 (they live entirely on diff planes, also cuz they're orthonormal)
  - the set of these vectors is called an **orthonormal basis vectors**.
    - The term orthonormal is preferred because abstractly outside of geometric context being perpendicular has no meaning. only the dot product being 0 implies that theyre perpendicular.

#### abstractly what the identity matrix means (skippable, optional ramble)

- vectors actually do not necessarily have geometric meaning in math, theyr're just objects with some definitions:
  - can be factored by a scalar value to give another object of the same type
  - add together to give another object of the same type
  - have a defined dot product
- circles back to group theory where you need to have an identity element to be considered a group (among other conditions).

### Triangular matrices

- When you have a matrix, and either the elements above or below the main diagonal <u>are all zero</u>.
  - Upper Triangular matrix - bottom-left triangle is 0

    $$
    \begin{pmatrix}
    a_{11} & a_{12} & a_{13} & a_{14} \\
    0 & a_{22} & a_{23} & a_{24} \\
    0 & 0 & a_{33} & a_{34} \\
    0 & 0 & 0 & a_{44}
    \end{pmatrix}
    $$

  - Lower Triangular matrix - top right triangle is 0

    $$
    L = \begin{pmatrix}
    l_{11} & 0 & 0 & 0 \\
    l_{21} & l_{22} & 0 & 0 \\
    l_{31} & l_{32} & l_{33} & 0 \\
    l_{41} & l_{42} & l_{43} & l_{44}
    \end{pmatrix}
    $$

- denoted (for upper triangular) $\bold{U} = \begin{pmatrix}u_{ij}\end{pmatrix} \in \mathbb{R}^{m \times n} \text{ if } u_{ij}=0 \text{ for } i>j$
  - if the row index is larger than the col index for an element, it is 0.
  - Lower triangular is just denoted by $\bold{L}$.
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

- Inverses are only defined for square matrices.
- denoted as $A^{-1}$
- $AA^{-1} = A^{-1}A = I$.

### significance of inverses

- good for manipulating Ax=b
  - you can directly find x by doing $x = \frac{b}{A} = A^{-1}b$
    - logic is that you multiply the left side of both equations with $A^{-1}$ so:
    $$A\bar{x} = \bar{b}$$
    $$A^{-1}A\bar{x} = A^{-1}\bar{b}$$
    because $AA^{-1} = A^{-1}A = I$,
    $$\bold{I}\bar{x} = A^{-1}\bar{b}$$
    $$\bar{x} = A^{-1}\bar{b}$$

    but because matrix multiplication is not commutative, the $A^{-1}$ needs to be on the right, so we write it as:

    $$\bar{x} = A\backslash \bar{b}$$
  But note this notation doesn't work if:
  - A = 0
  - A is not a square matrix
  - A doesn't have an inverse (it is singular)

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

## Singular Matrices
