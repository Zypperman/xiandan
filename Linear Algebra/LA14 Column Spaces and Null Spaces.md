# Column Space

## $Ax=b$ in the column picture

Given:

$$ Ax = b \text{ where:}
\\\space\\
A \in \mathbb{R}^{m \times n}, x \in \mathbb{R}^{ n \times 1}, b \in \mathbb{R}^{m \times 1}
\\\space\\

Ax = b = x_1 \cdot C_{a1} + x_2 \cdot C_{a2} + ... + x_3 \cdot C_{an} = \sum^{n}_{i=1}x_ia_i
$$

We can interpret A as a basis matrix, and b is a linear combination of the columns of A as basis vectors, and the components of x as how much of each vector to use.

b will just be a vector written in terms of our usual orthonormal identity basis matrix, and we are to calculate A.

> [!note] Recap: Row picture
>
> - treat A and b as representations of lines in a coordinate space
> - but components can also represent otherwise ie z-component can just be $x^2$ or sum shit
> - then we just solve to see how these equations intersect.
> - solution will either be a unique point or an infinite set of points that are common to all lines and planes.
>
> However, this is the old way of looking at things, since we assume that they follow a coordinate space.
---
> [!note] Recap: Span
> given n vectors of m components, or given n $a_i \in \mathbb{R}^{m}$:
>
> - span of these vectors = All possible linear combinations of these n vectors.
>   - aka the set of all vectors z such that z is a linear combination of the n vectors.
> - also $0 \lt n \lt \infty$
> $$\left\{ \mathbf{z} \mid \mathbf{z} = \sum_{i=1}^{n} s_i \mathbf{a}_i \right\}$$
> - this also happens to be the practical definition of a subspace, which is basically all possible linear combinations of a set of basis vectors. (termed $C \subseteq \mathbb{R}^{m}$)
> - the subspace actually can be reduced to be defined only by the vectors that are linearly independent of each other. (so r linearly independent vectors can be used to represent the subspace, and act as the basis C.)
>   - r is the dimension of the subspace.
>   - r will never be more than the number of dimensions in the vector space it occupies ($r \leq m$ dimensions)
>   - r will also never be more than  the number of vectors in its span. ($r \leq n$ span-vectors )
>

### Defining Column Space

Given a span of vectors, made using a matrix A:

$$
A = [a_i] \in \mathbb{R}^{m\times n}
$$

We define a column space, termed "$C$", with A:

$$
C(A) = \left\{ \mathbf{z} \mid \mathbf{z} = \sum_{i=1}^{n} x_i \mathbf{a}_i \right\}
$$

Effectively, we can call it a subspace, since each vector in A has m components, meaning theres m dimensions in the vector space that the column space cannot fully represent with less than m vectors.

### Properly defining a column space

1. write in set notation the space it occupies ie $C(A) \subseteq \mathbb{R}^{m}$
2. write the dimension of $C(A)$
3. write the basis for C(A).
    - you only need to write out the linearly independent ones.
    - they'll be equivalent, and theres no value in adding in useless ones.
    - conveniently, the number of linearly independent columns you use will be the rank of the basis matrix.
    - dimension of the vectors will be m, but the dimension of the subspace will be the rank r.
    - A will be $\mathbb{R}^{m \times n}$, where:
        - m is the number of dimensions in the vector space
        - n is the number of dimensions in the subspace.
4. good basis can just be found by getting REF using gaussian elimination.
    - match the REF columns with pivots to the columns in your original matrix.
    - those columns will be linearly independent.

## Why even care about column space

Referencing Ax=b:

- fundamentally, we're just finding the components of x that will give us a linear combination of the columns of A to get B.
- However, if b is not in this column space, we will naturally not have a consistent set of equations and just have no solution.
  - TLDR, b is a member of the column space if you can find values of x to get b.
- Elementary column operations also don't change the column space C(A)
  - like even if you did GSP (the Gram-Schmidt process), the column space remains the same:
    $$A \xrightarrow{G-S} Q, \mathcal{C}(A) = \mathcal{C}(Q)$$

    its just that C(Q) consists of different vectors, but they still span the same subspace as C(A).
    - recap: GSP is that thing where you turn your basis matrix into one where all the basis vectors are orthogonal to each other.

---

## Computing the Column Space

General solution:

1. Do Gauss-Jordan Elimination to reduce your matrix to RREF
2. note the columns that have pivots, those are the basis vectors of your space.

### Special Cases

- Square matrix (so A $\mathbb{R}^{n \times n}$)
  - if its full ranked, the column space will just be over the entire vector subspace
  - all columns in RREF form of A have pivots so all columns are linearly independent
  - basically, A spans over the entire vector space anyway, just use $I_n$ as your A. Same shit.
- Tall matrix (so A $\mathbb{R}^{m \times n}, \text{ where }m \gt n$ ie 3x2)
  - best case, all columns involved are linearly independent
  - rank(A) < m cuz num of pivots def less than num of columns
  - effectively the span of this subspace is just a plane, from the 2 vectors, in a space of 3 dims.
  - basis vectors will just be the pivots in A.
- Wide matrix (so A $\mathbb{R}^{m \times n}, \text{ where }m \lt n$ ie 2x4)
  - rank(A) once again is either same or less than dim of vector space
  - total num of dims is just r = n
  - pivot columns are the min basis vectors u need
  - ultimately can swap out with $I_n$ since you only need n vectors for the column space.

- Rank deficient square matrix
  - you just have fewer columns to represent your subspace
  - take columns that have pivots as your basis matrix
  - you can only represent a plane as a subspace
  - p much same rules as a tall matrix.

---

## What if in Ax=b, b = 0

- we did this before when we considered the row view of Ax=b
  - in those cases, we treated it like all such systems of equations as homogenous.
- in the new case of linear combinations of A's columns, what does b being all 0s tell us?
    $$
    \sum^{n}_{i=1}x_ia_i=0
    $$

  - well, basically it means that the columns of a cannot be linearly independent (if x is not a null vector).
  - aka, theres a combination of vectors that can cancel out one or more others, and is unnecessary.

> [!tip] Null space
> This space where we can get combinations of A's vectors such that we get the null vector.
>
> - the set of vectors that x can be to give us the vector b is termed the "**solution set**".
> - the solution set when b is a null vector is known as the null space.
>
> $$N(A) = \{x | Ax = 0\}$$

### properties of a Null space

- for any 2 vectors in the null space, it implies that **any linear combination of these 2 vectors will also be in the null space.**
  - see the additivity rule of linearity for why this is the case (LA01).

    $$\text{If } x_1,x_2,...,x_n \in N(A) \implies \sum^{n}_{i=1}l_ix_i \in N(A) $$
    where l just is a scalar.
    hence, this further helps prove that the null space is considered a subspace.

### Null Space Properties

- this solution set has vectors in the space $\mathbb{R}^{n}$, where n is just the number of columns in A.
- It is a solution set.
- it is also a span where if vectors other than the null vector exist here for Ax=0, then $N(A) \subset \mathbb{R}^{n}$
  - alternatively, we can also describe it as:
    $$
    A\bar{x} = \bar{0}
    \\\space\\
    \begin{bmatrix}
    -&r_1^T&-\\
    -&r_2^T&-\\
    &...&\\
    -&r_3^T&-\\
    \end{bmatrix}\bar{x} = \begin{bmatrix}
    0\\
    0\\
    ...\\
    0\\
    \end{bmatrix}
    \\\space\\
    \text{where}
    \\\space\\
    r_n^T\bar{x}=0
    $$
    basically, x is orthogonal to every row of A if its in the null space. (given that it basically results in each component of the resultant vector becoming 0.)

    Another way of saying is this is that the span of all the rows of A, is orthogonal to the vectors in the null space.

    However, ultimately since we're mentioning this in the context of column space, lets just term this "the columns of A-transpose" and say that column space is orthogonal to the null space of A.

### Column space properties

- refer to this as the rows of A / columns of $A^T$
  - aka span of columns of $A^T$
  - aka $C(A^T)$
- dot product with any row of A with x is 0 for Ax=0
  - aka rows in A are orthogonal to x in the null space
- Since EROs don't change the span of the row space, the ECOs therefore don't change the span of the column space of $A^T$
  - we can effectively use that to find the basis of the row space or the column space of A-transpose.
  - by doing GJE and then picking out the columns that have pivots.

---

## Another view of row space

Ax = b

- basically A can be seen as a function that takes in x, and spits out b ($A:\mathbb{R}^{n}\mapsto \mathbb{R}^{m}$):
  - where $x \in \mathbb{R}^{n}$
  - where $b \in \mathbb{R}^{m}$

- vectors in the null space that solve Ax=$\bar{0}$ can be treated as $x\in N(A) \mapsto b = \bold{0}$
- vectors generalized as x in the row space aka columns of a $A^T$ are mapped to the column space of A, generalized as b. ($x \in C(A^T) \mapsto b \in C(A)$)
- <span style="color:lime">even more importantly, the null space (vectors of x where Ax=0) and the column space of $A^T$ (C(A^T)) are **orthogonal comlements**</span>
  - so we literally can say $C(A^T)^\bot = N(A)$  
        with these properties, we can also say that:
    - $C(A^T),N(A) \subseteq \mathbb{R}^{n}$
      - both subspaces are subsets of the vector space
    - $dim(C(A^T)) + dim(N*(A))=n$
      - the total number of dimensions in a vector space is just the sum of the dimensions in the null space and the sum of dimensions in the column space of A-transpose.
    - <span style="color:cyan">Cool new thing: Rank-nullity theorem</span>
      - the rank of the basis of a null space is known termed as a "nullity", just like how you'd use the word rank
      - but the rank of the column space of A transpose + the nullity of your null space = n.

> [!note] Random unrelated question
>
> what happens when you try to do $A(x_{\parallel} + x_{\perp})?$
>
> - Given that $x_{\parallel} \in C(A^T), x_{\perp} \in N(A)$
> - $A(x_{\parallel} + x_{\perp}) = Ax_{\parallel} + Ax_{\perp} = Ax_{\parallel}$
>   - thats cuz $Ax_{\perp}$ literally returns $\bold{0}$, so you can cancel it out.
>

### Calculating the basis of the null space (example + Walkthrough)

- just refer to Ax=b, set b to 0 and find all values of x that satisfy it. fit in free variables if you need to.
  $$\text{given }A =
  \begin{bmatrix}
  1&2&-1\\
  2&4&-2\\
  -1&-2&1\\
  \end{bmatrix}
  \\\space\\
  \text{ we can do RREF on the augmented matrix [A|0]:}
  \\\space\\
  [A|0] =
  \begin{bmatrix}
  1&2&-1&|&0\\
  2&4&-2&|&0\\
  -1&-2&1&|&0\\
  \end{bmatrix}
  \\\space\\
  \text{after RREF}
  \\\space\\
  =
  \begin{bmatrix}
  1&2&-1&|&0\\
  0&0&0&|&0\\
  0&0&0&|&0\\
  \end{bmatrix}
  $$

  This matrix leaves us with the columns of the row space being defined with 1 vector, $C(A) = \left\{\begin{pmatrix}1\\2\\ -1\\ \end{pmatrix}\right\}$
  - obtained from the first pivot of the RREF

  The Null space is obtained from the solution of this rref:

  - set $x_2=y$ and $x_3=z$ as free variables
  - back-substitution to get $x_1 = -2y+z$
  - get the solution set x as $x = \begin{bmatrix}-2y+z\\y\\ z\\ \end{bmatrix} = y\begin{bmatrix}-2\\1\\ 0\\ \end{bmatrix} + z\begin{bmatrix}1\\0\\ 1\\ \end{bmatrix}$
  - the two vectors constructed from the free variables form the span of the null space.
    - $N(A) = \left\{ \begin{bmatrix}-2\\1\\ 0\\ \end{bmatrix} + \begin{bmatrix}1\\0\\ 1\\ \end{bmatrix}\right\}$

### random properties

- **Rank-nullity theorem**: notice how the dimension for the null space is 2, and the dimension for the column space of $A^T$ is 1, giving us a dimension of 3 which is the number of components in each vector
- **subset**: notice how both sets are subsets of the vector space $\mathbb{R}^{n}$
- **effect of linearly combining vectors from the column and null space**: Doing $A(x_{\parallel}+A_{\perp})$ basically gives you $A(x_{\parallel})$ since the vector from the null space results in every component being 0.

---

## Left Null spaces (more Null spaces yay...)

- Spaces defined:
  - C(A) &#8212; Column space of A
    - a set of vectors from the linear combinations of the rows of A
  - $C(A^T)$ &#8212; Row space / column space of A-transpose
    - A set of vectors from the linear combinations of the rows of $A^T$
  - $N(A)$ &#8212; Null Space
    - Solution set of Ax=0s
  - <span style="color:lime">$N(A^T)$ &#8212; Left Null space</span>
    - Solution set of $A^Ty=0$
    - basically, how can i get a linear combo of the rows of A to get 0
