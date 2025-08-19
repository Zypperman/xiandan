# Vectors and matrices

## Vectors

- fundamentally defined to have 2 properties:
  - magnitude
  - direction

But this is a physics definition.

Vectors (solely in math contenxt) are an ordered list of numbers.

- typically represented as columns. This representation is commonly referred to as a "column vector".

> [!note] Terminology clarification
> Components and elements are interchangeable terms to mean the numbers in the ordered list.

### Linearity in vectors (repeated from LA01)

for a vector to be considered linear, we need to check that homogenity and additivity are maintaned (aka scaling and addition rule), so:

- $s\bold{x} = \begin{bmatrix}sx \\ sy\end{bmatrix}$
- $\bold{x} + \bold{x'} = \begin{bmatrix}x+x' \\ y+y'\end{bmatrix}$

### Vector operations

#### Closed operations

- means that the input is a vector, and an output is a vector.
  - formally, any operations performed on elements in a set will result in another member of the set if it is closed.

#### Scalar multiplication

- Where you multiply a vector by a scalar value. Closed operation.
  - multiply the scalar value element-wise.
  - Graphically, they do not change the euclidian direction of the vector.
  - the resultant vector is considered <u>collinear</u> with the original vector. \*\*

#### Vector addition

- closed operation. Add two vectors by adding element-wise.
  - vectors can only be added if they have the same number of dimensions.
  - additive inverse &#8212; literally just scaling a vector by -1.
    - should give you the origin / null vector if you add the additive inverse of a vector to itself.
  - another way to visualise is "tip-to-tail" where you just connect the input vectors from tip to tail to get the final vector.

$$
\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix}

+ (-1)\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix} =
\begin{pmatrix}
1-1 \\
2-2 \\
3-3
\end{pmatrix}
=
 \begin{pmatrix}
0 \\
0 \\
0
\end{pmatrix}
$$

### Order of operations

- try to resolve scalars with scalar multiplication before doing vector addition.
  - doing both at the same time is known as a linear combination.
    - also conidered a closed operation.

The set of 2D vectors is also considered an infinite set, and any vector can be represented by a linear combination of 2 other vectors.

## Linear independence

- when your linear combination will give you all possible 2D vectors.
  - one instance of linear dependence is if of the 2 vectors you use, one of them is the scalar multiple of another.
    - graphically, they exist on the same line so they can also only produce vectors that lie on the same line.
    - algebraically, it means any resultant vector of this linear combination, is literally also a scalar multiple of one of the input vectors.
    - <https://medium.com/swlh/how-to-understand-linear-independence-linear-algebra-8bab1d918509>

### Identifying linearly independent vectors

- Vectors are linearly dependent if:
  - one vector can be represented as a scaled version of the other &#8594; both vectors point the same direction &#8594; cannot represent vectors with other directions
  - one vector is just a linear combination of the other involved vectors, ie:
    $$
    \begin{pmatrix}
    1 \\
    1 \\
    \end{pmatrix},\begin{pmatrix}
    3 \\
    1 \\
    \end{pmatrix},\begin{pmatrix}
    5 \\
    3 \\
    \end{pmatrix}

    \text{ are linearly dependent cuz }

    (2)\begin{pmatrix}
    1 \\
    1 \\
    \end{pmatrix} + \begin{pmatrix}
    3 \\
    1 \\
    \end{pmatrix} = \begin{pmatrix}
    5 \\
    3 \\
    \end{pmatrix}
    $$

- example of linearly independent vectors is a set of basis vectors.
  - ie for 2d you can represent all vectors in that space with 2 vectors, 4 vectors min for 4D, n linearly independent vectors for n dimensions. (one for each dimension)
    - The set of n vectors is represented as $\mathbb{R}_n$. (ie for 2D its &#8594; $\mathbb{R}_2$)

### Linear dependence proof format

#### Formal test

$$\text{Let } x_1 \text{and } x_2 \text{be 2 vectors, and } s_1x_1+s_2x_2 = 0 \text{ be a linear combination of } x_1 \text{and } x_2. \\

\text{If we can find some non-zero value for }s_1 \text{and } s_2 \\ \text{ such that their linear combination results in a null vector, }\\
\text{Then } x_1 \text{and } x_2 \text{ are linearly dependent.}$$

Conversely, for linearly independent vectors, all scalar values involved must be 0 for $s_1x_1+s2_x2=0$ to be true.
    - sorta like how they cannot interfere with each other.

---

#### Proof progression

ie prove that the following set of vectors is linearly independent.

$$
\gamma_1a,\gamma_2b,\gamma_3c
$$

1. assume they arent Linearly Independent
2. quote equation from the formal test with assumption (so $\gamma_1a+\gamma_2b+\gamma_3c=0$)
3. manipulate the equation to prove scalars or vectors don't work
    - either equate all scalars to 0 or say vectors have same direction
    - ie. (so $\gamma_1=\gamma_2=\gamma_3=0$)
4. format it back into known equation (ie an eqn where confirm that $\gamma_n$ equals 0 or something)
5. say assumption is wrong therefore new set is independent.

---

#### Tips for sanity checking proofs

- For 2D, you only need 2, so if given more, theyre useless, and <u>have</u> to be linear combinations.
  - in 2D ($\mathbb{R}_2$), every vector can be expressed as a linear combination of 2 linearly independent vectors.
  - that means if you're asked to do more and unless the given set of vectors are all scaled versions of each other, the set if vectors are definitely not linearly independent.

## Span and Vector space

Span &#8212; a set of all vectors that result from a linear combination of 2 known vectors.

- can refer to the entire space, i.e. with basis vectors like $\begin{pmatrix}1 \\0\end{pmatrix},\begin{pmatrix}0 \\1\end{pmatrix}$
- informally you can refer to it as the set of "possible vectors that you can make with a set of 2 vectors"
- if the two vectors are linearly independent they can span the entire space.
    - so if you have 2 vectors $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix},\begin{pmatrix}0 \\1 \\ 0\end{pmatrix}$, the span is only the x-y plane.
    - the span if you only have a vector of $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix}$ will be just the x axis (or whatever component is involved.)

Vector space &#8212; the set of all possible vectors that can exist in a set of dimensions.
- for n dimensions it is $\mathbb{R}^n$.
- the null vector / zero vector is considered a part of all vector spaces because it just represents the origin.

Spans can be the same set as a vector space, or a subset of it.
- here we discuss without caring about linear independence.
    - ie. span of $\begin{pmatrix}1 \\0\end{pmatrix},\begin{pmatrix}0 \\1\end{pmatrix}$ is equal to the vector space $\mathbb{R}^2$
    - however, the span of $\begin{pmatrix}1 \\1\end{pmatrix},\begin{pmatrix}2 \\2\end{pmatrix}$, they are linearly dependent so they cannot be used to represent the entire vector space. They can only represent a subspace of vector space $\mathbb{R}^2$.
- **The Dimension of a subspace = the number of linearly independent vectors in said subspace.**
    - However, note that you write it that (given the example of $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix},\begin{pmatrix}0 \\0 \\ 1\end{pmatrix}$) the span of these two vectors is the xz plane in $\mathbb{R}^3$ and it has 2 dimensions.
        > [!caution]
        > IT IS NOT THE SAME AS $\mathbb{R}^2$.  
        > $\mathbb{R}^2$ is not a subset of $\mathbb{R}^3$.
        > you just say it as it is. Even if your span only has dimensions in X and Y plane, its not the same.

### Vector Operations II

Dot product &#8212; between two vectors, multiply each component together and sum to get a scalar.
- signifies how close in direction (spatially) they are, and is used to calculate document similarity (by embedding information about documents into them. See TF-IDF.)

Norm &#8212; magnitude of the vector actually can be obtained by square-rooting the dot-product of itself (ie given $v$ as a vector, $\left|\left| v\right|\right| = \sqrt{v\cdot v} = \sqrt{\sum({\text{v's components}})^2}$).

Unit vector / normalized vector &#8212; a vector with magnitude 1 and in the same direction of the vector, where $\hat{x} = \frac{x}{\left|\left| x\right|\right|}$.

## Matrices

- A table of numbers with rows and columns, where all the numbers are of the same type.
    - dimensions of the table take on the format \<rows\>x\<columns\>
    - the subspace we adopt for this is known as $\mathbb{R}^{\text{rows} \times \text{cols}}$
    - numbers like integers, rational nums, real, complex nums effect
      - order of sets is $\mathbb{Z} \subset \mathbb{Q} \subset \mathbb{R} \subset \mathbb{C}$. Q refers to rational nums.
    - random trivia, notation can be written with sagemath software.
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

---

## Sources

- (Unofficially) SMU Linear Algebra Refresher workshop
