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

TLDR, C(A) is a subspace of dimension r.

- there are r independent columns in A that can be used to form the basis of C(A).
- C(A) basically is the set of all linear combinations of the columns of A, and is considered a span.
- C(A) also has to contain the zero vector.

### Properly defining a column space

1. write in set notation the space it occupies ie $C(A) \subseteq \mathbb{R}^{m}$
2. write the dimension of $C(A)$ (aka the rank of A)
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

1. Do Gauss-Jordan Elimination to reduce your matrix to REF
2. note the columns that have pivots, those are the basis vectors of your space.

- the columns corresponding to the pivot columns in ur REF matrix is the span of your column matrix.

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
    - $dim(C(A^T)) + dim(N(A))=n$
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

## Left Null spaces (4 spaces total)

You will understand this picture after you read all this.

![diagramatic breakdown of the 4 spaces](https://www.cs.utexas.edu/~flame/laff/alaff/images/Chapter04/FundamentalSpaces.png)

### Spaces defined

- <span style="color:red">C(A) &#8212; Column space of A</span>
  - a set of vectors from the linear combinations of the rows of A
  - Column space basis is made using original matrices' columns corresponding to pivot columns from RREF
- <span style="color:cyan">$C(A^T)$ &#8212; Row space / column space of A-transpose</span>
  - A set of vectors from the linear combinations of the rows of $A^T$
  - Row space basis is made using either:
    - original matrices' rows corresponding to pivot columns from RREF
    - or the RREF pivot rows themselves.
- <span style="color:yellow">$N(A)$ &#8212; Null Space</span>
  - Solution set of Ax=0
- <span style="color:lime">$N(A^T)$ &#8212; Left Null space</span>
  - Solution set of $A^Ty=0$
  - basically, how can i get a linear combo of the rows of A to get 0
  - named so because $A^Ty = 0$ is the same as $y^TA = 0$ and we're basically finding a linear combination of rows from A to get the 0 vector.

## Mapping spaces

Referencing Ax=b, where $A \in \mathbb{R}^{m\times n}$, $x \mapsto b$ and essentially $A : \mathbb{R}^n \mapsto \mathbb{R}^m$

- for x (the input vector, where $x \in \mathbb{R}^{n}$):
  - if x is in the null space, $x \mapsto 0$
    - and this 0 will belong to the column space $C(A)$ which has dimension $\mathbb{R}^{m}$
    - and be the orthogonal complement to $C(A)$
  - if x is <span style="color:red">not</span> in the null space, it maps to a non-zero vector in the column space $C(A)$ which has dimension $\mathbb{R}^{m}$

    In math notation, it looks like:

  - if $x \in N(A), x\mapsto 0 \in C(A)$
  - if $x \notin N(A), x\mapsto b \in C(A)$

    and since any vectors in the null space maps to the 0 vector, a known result (proven above) is that given:
    $$x_{\parallel} \in C(A^T)$$
    $$x_{\perp} \in N(A)$$
    $$A(x_\parallel + x_\perp) = Ax_\parallel$$

    in english, given:
  - a vector marked parallel that it belongs to the row space
  - a vector marked perpendicular that belongs to the null space
  - adding the 2 vectors then multiplying it by A <u>is the same</u> as just using the vector marked parallel.
  - The only exeption to this is the null vector, which is present in both sets as a requirement.

  - In any case, there are no vectors that are not in either N(A) or $C(A^T)$.
    - basically, $\{x | x \in N(A), x\notin N(A) \} = \emptyset$.
    - TLDR, there is no vector $\mathbb{R}^{n}$ that can map to any vectors in the left null space.
      - $\emptyset \mapsto N(A^T)$

---

### The 4 spaces diagram

For A where rank(A)=r:

<div style="color:lightcoral">

- column space C(A) has dim = r
- column space is termed the "Image" / "Range", alluding a result of some input from the left hand side, x
  - think of A as a mirror and x as an object, b is therefore an image.
  - note, range $\neq$ codomain.
    - codomain is the whole space of b
    - range is all the non-zero b that can exist as a result of Ax.

> [!tip]
> If  b is in the column space, that means there is an x that is its input / a linear combination for it.
> TLDR, <u>C(A) is a subspace of dimension r in $\mathbb{R}^{m}$.</u>

</div>
  
<div style="color:goldenrod">

- Null space N(A) has dim = n-r (right-nullity)
  - cuz r pivots in C(A) = n-r free variables.
  - basis for N(A) = vectors for forming special solutions when you solve A with GJE
  - In any case, its containing space is the input space $\mathbb{R}^{n}$
- all vectors in it map to the zero vector in C(A)
    $$Ax \mapsto 0, \space A0 \mapsto 0$$

- Null space is termed the "Kernel"
  - Kernel's word origin comes from "cyrnel" meaning seed, abstracting to mean core in a homorphism.
  - in Math context, think of it that the 0 vector basically represents the center of all spaces (ie your normal graphs have an origin of 0)
    - in LA context, it basically means the vectors in one space, given A, will map to the "center" of our column space.

- TLDR, N(A) is a subspace of $\mathbb{R}^{n}$ of dimension n-r.

</div>

> [!note] Expanding the definition of Kernels with homorphisms in Group Theory
>
> - lets have the context of 2 groups, G and H, and we have a function f that maps elements of G to elements of H.
> - lets also have it that $f(ab) = f(a)f(b)$ (linearity assumption, see LA01)
> - f's kernel is referred to as the elements of g that f will map to the identity element of H.
> - adding the context of linear algebra, we can treat:
>   - the identity element as the null vector since it has basically the same properties
>   - G and H to be the Row and Column spaces ($C(A^T)$) and $C(A)$ respectively
>   - N(A) basically fits the definition of a kernel.
>   - $N(A^T)$ also basically fits the definition of a cokernel.
>
> If blur, watch [video](https://youtu.be/j8SQDZ96LVs?si=XOZLVa0ODaDoVovF).

<div style="color:skyblue">

- row space $C(A^T)$ has dim = r
  - same as column space dimensions = number of pivots in A's REF form
  - rows of A = columns of $A^T$
  - independent rows of A are the matched to the corresponding rows of the original A.
    - that is to say $C(A^T) = C(U^T)$, given $A \xrightarrow{RREF}U$
- all vectors in it map to a non-zero vector in C(A)
    $$Ax \mapsto b, \space b \neq 0 \text{ unless } x=0$$

- row space is termed the "coimage".
  - note, coimage $\neq$ domain.
    - coimage just refers to all vectors in $C(A^T)$
    - domain refers to all vectors in input space.

- TLDR $C(A^T)$ is also a subspace of dimension r, with a containing space of $\mathbb{R}^{n}$.

</div>

> [!TIP] space consisting of the null and row space
>
> - note that since:
>   - row space dim = r
>   - null space dim = n-r
>
>   Its technically correct to say that they span $\mathbb{R}^{n}$.
> - However, since they are not orthogonal complements, it means there are vectors that aren't in either of these spaces.
> - but luckily it just means that these vectors are just linear combinations of vectors in our two spaces.
> - apply proof that $A(x_\parallel + x_\perp) = Ax_\parallel \mapsto b$ and basically it still maps to the column space.

<div style="color:darkseagreen">

- Left Null space $N(A^T)$ has dim = m-r
  - termed "right nullity" of $C(A^T)$.

- no vectors from the input space $\mathbb{R}^{n}$ are mapped to it via A.
  - basically when
  $$A^Ty = \bold{0}_{n \times 1} \space (y^TA = 0^T)$$
    - left Null space A = right null space of $A^T$, so we just denote as $N(A^T)$.

- left null space is termed the "cokernel"
  - reason being that it maps values from the output space to the center of the row space, which already only points to itself, so you can't make those vectors.

- TLDR, $N(A^T)$ is a subspace of $\mathbb{R}^{m}$ of dimension m-r.
  - all of y fits in $\mathbb{R}^{m}$.

</div>

### Mappings wrt to domain containing spaces

referring to how we are mapping spaces with $A:\mathbb{R}^{n} \mapsto \mathbb{R}^{m}$

- talking about $\mathbb{R}^{n}$ and $\mathbb{R}^{m}$ respectively

$\mathbb{R}^{n}$ &#8212; termed the "domain"

- informally known as the "input space".
- consist of linear combinations of columns in $C(A^T)$ and N(A)

$\mathbb{R}^{m}$ &#8212; termed the "Codomain"

- informally known as the "output space".
- is the "containing space" of C(A)
- consist of linear combinations of columns in C(A) and $N(A^T)$

### Null space and row space ($N(A) \text{ and } C(A^T)$)

- both are subspaces of $\mathbb{R}^{n}$, the input space
  - $C(A^T), N(A) \in \mathbb{R}^{n}$
- the sum of their dimensions gives the dimensions in their containing space
  - $dim\left( C(A^T) \right)+ dim\left( N(A) \right) = r + n - r = n = dim(\mathbb{R}^n)$
  - rank + right nullity = n
- all vectors in the column space are orthogonal to all in the null space.
  - hence, they are orthogonal complements.
  - $x_\parallel \in C(A^T) \space \& \space x_\perp \in N(A)\space , \space x_\parallel^Tx_\perp = 0$
  - proof that they are complements is basically that "if one is in the null space,since their dot product is 0, the other has to be in the column space" and vice versa.
  - if $x_\parallel^Tx_\perp = 0, x_\parallel \in C(A^T) \implies x_\perp \in N(A)$
  - if $x_\parallel^Tx_\perp = 0, x_\perp \in N(A) \implies x_\parallel \in C(A^T)$

- because of this complement nature, all vectors in the input space either:
  - are in N(A) and map to the 0 vector on RHS
  - are in $C(A^T)$ and map to b in C(A) on the RHS.

- adding a vector from the null space to one from the column space is negligible, produces the same result on the column space.

> [!caution] NOTE: MOST OF THE INPUT SPACE IS NOT IN THE ROW OR NULL SPACE.
>
> - example: for $\mathbb{R}^{3}$, $C(A^T)$ = x-y plane, N(A) = Z axis
> - I can have vectors that are part of both. (basically have 3 non-zero components in them)
> - in $\mathbb{R}^{n}$ but not the two spaces cuz they're linear combinations of them.
> - THESE ARE NOT IN $C(A^T)$ NOR N(A)
> - TLDR, $C(A) \cup N(A) \neq \mathbb{R}^{n}$.
>

---

### Calulating left null space

- just work with $A^T$
- find null space by equating it to $A^Ty=0$
  - declare set, nullity and basis.
