# Vector spaces and handling Basis

## Preface (defining them as $V$)

- see LA02 where we defined vector spaces as:
  - sets of all possible vectors
  - each vector has a given number of components.
  - also needs to satisfy the property of closure for the following operations:

    - vector addition
    - vector scaling
    - linear combination
  
    where the result will still be a vector in that set.

> [!tip] Vector space vs coordinate space
>
> - Coordinate spaces are a superset of a vector spaces because they can contain more than just vectors
>   - ie. lines, linear equations, curves etc, all math objects that exist outside of a vector space.
> - We've been using a coordinate space to visualise these vectors because its easier to make sense with.

### Extending this definition

- Vector spaces also can refer to:
  - coordinate spaces in n dimensions (so sets of n dimensional vectors)
  - sets of matrices, where you can think of them as vectors made of covectors
  - sets of vectors where elements belong in another set ie $\mathbb{C}$
  - functions as elements of that space
    - i.e. functions that range from 0 to 1, and have operations that give you back functions in the same range
    - this specifically forms the idea behind fourier transformations.

- So long as fundamentally, you are talking about:
  - a set of possible math objects

## Vector Subspaces ($s$)

- a subset of a vector space ($V \supseteq  s$) where:
  - the same criteria holds that scalar multiplication and vector addition among elements of the space are closed operations
  - <span style="color:lime">contains the zero vector ($\bold{0} \in s$)</span>
- Examples include:
  - a set of vectors that all have the same span (so $\mathbb{R}$ in $\mathbb{R}^2$)
  - a set of vectors that all have the same span (so $\mathbb{R}^2$ in $\mathbb{R}^3$)

## Repressenting our spaces with Basis and Basis vectors

- Basis: The minimum set of vectors to span a space / subspace.
  - ie the basis of a vector space $\mathbb{R}^3$ needs to be represented by min 3 vectors.
- The objective being that we want to find the least number of vectors to represent any vector in our space, using a linear combination of our basis.

### Requirements for making a Basis

- A <u>set</u> of vectors that:
  - span the space or subspace
  - are <u>linearly independent</u>
    - an easy way to tell is to see whether among all vectors, is there a vector in your chosen basis with a non-zero component to represent that component:
    $$
    x_1 = \begin{pmatrix}
      1\\2\\0
    \end{pmatrix}
    x_2 = \begin{pmatrix}
      3\\1\\0
    \end{pmatrix}
    x_3 = \begin{pmatrix}
      0\\0\\ 1
    \end{pmatrix}
    $$
    All 3 components have at least 1 vector that can be used to represent them. if all 3 vectors had 0s for the last component, they can only span $\mathbb{R}^2$.

- doesn't need to be a specific set.
- Additionally, if:
  - each vector has a unit length of 1
  - each vector is perpendicular / orthogonal to each other
    - basically their dot products are 0.
  we call them unit vectors.

### Orthogonality

- Basically how we say that 2 vectors are perpendicular to each other, but we extend this to refer to being perpendicular in spaces with more than 2 dimensions.
- also makes no sense to say that 2 functions are perpendicular to each other, its better if we say they're orthogonal. (see [article in relation to fourier transforms](https://math.stackexchange.com/questions/1358485/what-does-it-mean-when-two-functions-are-orthogonal-why-is-it-important))
- To extend this definition, if every vector in one subspace is orthogonal to those in another subspace, we can say the two spaces are orthogonal to each other.
  - if 2 planes are not orthogonal to each other, they will share a line in 3d.
  - also if this criteria is met, the subspaces are termed "orthogonal complements" of each other, and any vector in one will be orthogonal to the other.
    - also, the sum of their dimensions in each subspace will equal the dimension of the vector space.

> [!note]
> TLDR, for a vector space of $\mathbb{R}^{n}$ your basis needs n vectors.  
> For a vector space of matrices, the dimension is $m \times n$ and you need $m \times n$ vectors to represent it (1 for each element)
>
### Dimension

- refers to how many basis vectors are needed to represent a vector space/subspace.
  - termed in set theory as the "cardinality" of the basis set.
  - you can form the basis of a vector space with different sets of vectors, but ultimately they will all be made of the same number of vectors as the number of dimensions in that space.
    - number of dimensions is considered an immutable property.
  - In vector spaces, it just so happens that the number of dimensions is the same as the number of components.
    - <span style="color:red">However</span> this is not the case for vector subspaces. See above example, if the last component was all 0s the dimension is 1 more than the subspace. It just has a component that cannot be represented by the basis vectors.

Math terminology:

- $\mathbb{R}^n$ has:
  - a dimension of n
  - n linearly independent vectors that span it to form its basis
  - each vector $v \in \mathbb{R}^n$ has n components.
  - for a vector space of functions, since each function can take on infinite numbers it has infinite dimensions.

## Basis matrix

- Where you just concatonate all your basis vectors and form a matrix.
  - ie for $\mathbb{R}^3$:
      $$
      \hat{i} = \begin{pmatrix}
        1\\0\\0
      \end{pmatrix},
      \hat{j} = \begin{pmatrix}
        0\\1\\0
      \end{pmatrix},
      \hat{k} = \begin{pmatrix}
        0\\0\\1
      \end{pmatrix}
      \\\space\\
      I_3 = \begin{bmatrix}
      1&0&0\\
      0&1&0\\
      1&0&1\\
      \end{bmatrix}
      $$

      with this, we can form any vector in $x = a\hat{i} + b\hat{j} + c\hat{k}$.

## The Geometry of Linear equations

Referencing our system of linear equations Ax = b:

- Row picture thinking in coordinate space
  - Traditionally, we are encoding our system of equations with each row being 1 equation.
  - the intersection of shapes from our rows of equations form our solutions (if any).
- Column Picture thinking in vector space
  - now, we are thinking of how we can get b using the column vectors of A.
    - recap that the column picture of matrix multiplication:
      $$
      \text{given } AB = C \text{ where } A \in \mathbb{R}^{3\times2} \text{ and } B \in \mathbb{R}^{2 \times 1}
      \\
      \text{ with } \\
      A \begin{bmatrix}
      a&b\\
      c&d\\
      e&f\\
      \end{bmatrix}= \begin{bmatrix}
        |&|\\
        x&y\\
        |&|\\
      \end{bmatrix} \text{ and } B= \begin{bmatrix}
      g\\
      h\\
      \end{bmatrix}\\
      \space\\
      C = g \hat{x} + h\hat{y}
      $$

      we take the columns of A and do a "dot product" with the corresponding scalars in b, then do a linear combnation.

      Same here, now we are just finding what the ideal components x should take on to make it happen.

So the modified approach is:

- My system of equation takes the same form as before in Ax=b, with A as the coefficients and b as the constants
- now i treat A as my basis matrix and see if we can get a solution using x's components with A's columns to get b:
  $$
  Ax = b\\
  \begin{bmatrix}
    a&b\\
    c&d
  \end{bmatrix}\begin{bmatrix}
    x\\
    y
  \end{bmatrix} =
  \begin{bmatrix}
    m\\
    n
  \end{bmatrix}
  \\\space\\
  \text{find values of x and y such that }
  \\\space\\

  x  \begin{bmatrix}
    a\\
    c
  \end{bmatrix}
  +y
    \begin{bmatrix}
    b\\
    d
  \end{bmatrix} =   \begin{bmatrix}
    m\\
    n
  \end{bmatrix}
  $$

On the coordinate space, this looks like:

![geometry of solving via the column picture](https://hadrienj.github.io/assets/images/ch09_system_of_linear_equations/ch09_column_picture_linear_combination.png)

1. A is made of the red and blue vectors as column vectors
2. b is the green vector
3. we want to find a combination of the red and blue vectors that will give us the green vector
    - draw a line parallel to the red vector at the arrowhead of the green vector
    - scale the blue vector to touch the line
    - scale the red vector such that it forms a nice triangle.
    - each vector component of x will just be
      $$
      x_n = \frac{\pm \text{ Length of a'}_n }{\text{Length of a}_n}
      $$
      so take each column, divide to get length 1, then scale to fit the green vector with the rest of the columns in A.
4. Depending on the solution type:
    ![solution types](https://hadrienj.github.io/assets/images/ch09_system_of_linear_equations/ch09_solutions_systems_equations.png)
    1. For inconsistent equations with no solution:
        ![no solutions](https://hadrienj.github.io/assets/images/ch09_system_of_linear_equations/ch09_column_picture_no_solution.png)
        - both red and blue vectors have the same span, but do not share it with the green resultant vector b.
        - That means that there is no combination that the red and blue vectors can add to give the green vector.

    2. For infinite solutions:
        ![nf solutions](https://hadrienj.github.io/assets/images/ch09_system_of_linear_equations/ch09_column_picture_infinite_solutions.png)
        - one or more of the vectors share the same span with the green resultant vector b.
        - technically, only one of the vectors is needed so you will get some weird representation. The other can kinda not be needed and set to 0.

---

## Basis in depth

- Recap that we basically refer to a basis as a set of linearly independent vectors that span our vector space/subspace.
  - to note it in math, we can say this:
    $$
    \text{for } a_i \in \mathbb{R}^{n}, A = [a_i] \in \mathbb{R}^{\times n}
    $$
    where A is our basis matrix, which has all n of our basis vectors concatonated together. each basis vector is denoted by $a_i$.
    - for vector spaces made of matrices, A will be a 3d matrix / type of tensor, and each $a_i$ is 1 matrix.

- With this basis, we can describe any new vector as:
  $$
  x \in \mathbb{R}^{n} \implies \sum^{n}_{i=1} x_{i|A}a_i = pa_1+qa_2+...+ra_n
  $$

  - $x_{i|A}$ are the scalar of the vector x, and a_i is just each basis vector. The components mentioned are also considered unique for any vector.
  - TLDR its saying that we can represent any vector as a linear combination of the basis vectors in that space.

### Ideal basis: the Identity matrix

- technically, the identity matrix it the best kind of matrix we can get.
  - each column is 1 basis vector
  - each column has a unit length of 1, meaning we can just directly use the same component as the vector we want to represent.
  $$
  \text{given } I_3 = \begin{bmatrix}
  1&0&0\\
  0&1&0\\
  0&0&1\\
  \end{bmatrix},\text{ we can say} \\
  \space\\
  \text{for } x = \begin{bmatrix}
  4\\
  7\\
  5\\
  \end{bmatrix} = Ix = \begin{bmatrix}
  1&0&0\\
  0&1&0\\
  0&0&1\\
  \end{bmatrix}\begin{bmatrix}
  4\\
  7\\
  5\\
  \end{bmatrix} = 4 \begin{bmatrix}
  1\\
  0\\
  0\\
  \end{bmatrix} +  7 \begin{bmatrix}
  0\\
  1\\
  0\\
  \end{bmatrix} +  5 \begin{bmatrix}
  0\\
  0\\
  1\\
  \end{bmatrix} = 4\hat{i} + 7\hat{j} + 5\hat{k}
  $$

We can further add the orthonormal condition and say:

$$
q_i^T q_j = \begin{cases}
    1 & \text{if } i = j \\
    0 & \text{if } i \neq j
\end{cases}
$$

- this just says that if i dot product 2 basis vectors, they will give me 0 meaning they are orthogonal to each other.
- if i dot product the same basis vector, they will give me the value 1 meaning that it not only has the same direction and span, it also as a magnitude of 1.

- FYI, orthonormal = orthogonal + each have length of 1 unit.
For more lore, see what the [kronecker delta](https://en.wikipedia.org/wiki/Kronecker_delta) is with tensors.

<span style="color:yellow">If your basis matrix is made with orthonormal vectors, it is termed a "orthogonal / orthonormal matrix".</span>

### random properties of an orthonormal matrix

- the matrix inverse is the same as its transpose
  - cuz conveniently $Q^TQ = QQ^T = I$
  - this also basically forms the test for orthogonality in a matrix. "If its matrix is the same as its transpose, the matrix is orthogonal."
- orthonormal matrices perserve the norm when getting the magnitude of a matrix.
  - $||Qx|| = ||x||$
  - cuz $||Qx||^2 = (Qx)^TQx = x^TQ^TQx = x^t(I)x = x^tx = ||x||^2$

## Uses of change of basis

- For handling different perspectives in games with 3d graphics
  - objects are fixed in 3d world, but each player views it differently
- for manipulating 3d objects
- for doing PCA in ML

### Change of basis Mechanics

- For a given situation, we have 1 single vector.
- We currently write this vector in terms of our unit orthonormal vectors.
- we want to find for another set of basis vectors, if we can get the same thing.
  $$
  b = \begin{pmatrix}
    5\\3
  \end{pmatrix}
   = 5\begin{pmatrix}
    1\\0
   \end{pmatrix}+3\begin{pmatrix}
    0\\1
   \end{pmatrix} = 5\hat{x}+3\hat{y}
   \\\space\\
   \text{now, given our new basis:}\\\space\\
   A = \begin{bmatrix}
   4&3\\
   2&7\\
   \end{bmatrix}\\\space\\
   \text{we want to represent b with our new basis such that:}
   \\\space\\
   m\begin{pmatrix}
    4\\2
   \end{pmatrix}+n\begin{pmatrix}
    3\\7
   \end{pmatrix} = 5\begin{pmatrix}
    1\\0
   \end{pmatrix}+3\begin{pmatrix}
    0\\1
   \end{pmatrix}\\\space\\

   \text{And we can basically abstract this to a matrix multiplication where}
   \\\space\\
   Ax = \begin{bmatrix}
   4&3\\
   2&7\\
   \end{bmatrix}\begin{bmatrix}
   m\\
   n\\
   \end{bmatrix}
   = \begin{bmatrix}
   5\\
   3\\
   \end{bmatrix}
   =b
  $$
  this basis can be seen as the new coordinates of our player, and we're trying to figure out where on the screen to project our object.
  - in a more abstract form:
  $$
  x = \sum_{i=1}^{n} x_{i|A}\space a_i = A[c]_A \implies \text{Similar to } Ax = b
  \\\space\\
  A[c]_A = I[x]_I = x \implies [c]_{A} = A^{-1}x
  $$

  the second line is just saying that "I want to find the components of c to construct x using the column vectors in A, and I know that it is equal to the way x is currently written, which uses an orthonormal basis."

- Conveniently, since A is made of n linearly independent column vectors, it is considered full rank and invertible. so we will always have a solution.

For a subspace, you only need as many components as the dimension of the subspace.