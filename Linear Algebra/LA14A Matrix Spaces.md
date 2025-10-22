# Matrix Spaces

## For square matrices

### Full ranked square matries

- full rank matrix ie $\mathbb{R}^{3\times3}$ means:
  - its rank is 3
  - its column and row space should be all of $\mathbb{R}^{3}$
  - each should contain 3 vectors
  - Ax=b will have unique solutions.
    - cuz the equations are consistent and linearly independent.
    - always RREF-able into the identity matrix.

- Basis for our spaces:
  - since by GJE it gives us the identity matrix, we can just use the identity matrix as a basis since its equivalent and easier (not always the case, only for full rank case.)
  - both $C(A) \text{ and } C(A^T)$ can use $I_n$ as their basis.
  - both $I_n$ and the real basis are row and column equivalent to each other.

### TLDR

- for $A \in \mathbb{R}^{n \times n}$, rank(A)=r=n:
  - A has the column and row space with basis $I_n$
    - because $A \xrightarrow{RREF} I_n$

That means:

- <span style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{n}$</span>
- <span style="color:goldenrod">Null space $N(A) = \left\{ 0 \right\} \text{ in } \mathbb{R}^{n}$</span>
- <span style="color:darkseagreen">left Null space $N(A^T) = \left\{ 0 \right\} \text{ in } \mathbb{R}^{n}$</span>

> [!note]
> The null spaces are technically not empty since they contain the 0 vector.

#### For a rank-deficient square matrix

- where:

$$A \in \mathbb{R}^{n \times n} \quad \mathrm{rank}(A) = r < n$$

$$\
A \xrightarrow{\text{RREF}} \begin{bmatrix}
I_r \oplus F_{r \times (n-r)} \\
\mathbf{0}_{(n-r) \times n}
\end{bmatrix}
$$

- basically it row reduces to some form where you have a matrix of:
  - a way to divide the matrix into rows of 0s and those not
  - (n-r) rows with n 0s in them at the bottom
  - r rows that can be rearranged such that you have:
    - an identity matrix r
    - some other matrix representing the constants and free variables involved.
      - something like a representation of the special solution (see LA05).

Basis for:

- Row space $C(A^T)$ =
  - corresponding pivot rows in A from RREF(A)
  - pivot rows of RREF(A) straight up
- Col space $C(A)$ =
  - corresponding pivot columns in A from RREF(A)
  
That means:

- <span style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$, with dimension = r</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{n}$ with dimension = r</span>
- <span style="color:goldenrod">Null space $N(A) = \left\{ 0 \right\}  \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of C(A)
- <span style="color:darkseagreen">left Null space $N(A^T) = \left\{ 0 \right\}  \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of $C(A^T)$

---

## For Tall matrices

### Full ranked tall matrices (full column rank)

Given a matrix of $\mathbb{R}^{m\times n}, m \gt n$ (ie given $4\times3$)

- we can RREF it to an identity matrix of r and (m-r) rows of zeros at the bottom
- Input space / Containing space of row space $C(A^T)$ = $\mathbb{R}^{3}$ / $\mathbb{R}^{n}$ (number of columns)
- Output space / Containing space of column space $C(A)$ = $\mathbb{R}^{4}$ / $\mathbb{R}^{m}$ (number of rows)

> [!Tip] memory trick for input and output space size
>
> - recall Ax=b
> - if A is $m\times n$, that means x must be $n \times 1$
>   - so that means input space is $\mathbb{R}^{n}$, where x lives
>   - also that means b is $m \times 1$
>   - so that means output space is $\mathbb{R}^{m}$, where b lives.
> - Alternatively, $m \times n$, remember alphabet
>   - b m n x &#8594; therefore group b to m, x to n.
>     - b &#8594; C(A) &#8594; containing space has same dim as num of rows (m)
>     - x &#8594; $C(A^T)$ &#8594; containing space has same dim as num of cols (m)

- Full rank = all columns are linearly independent

- column space properties: (talk about its conaining space, dimension and basis)
  - $C(A) \subset \mathbb{R}^m$ ie $\mathbb{R}^{4}$
  - $dim( C(A))= n = r$ ie. 3 (the 3 columns of A that are linearly independent)

- row space properties:
  - $C(A^T) = \mathbb{R}^n$ ie $\mathbb{R}^{3}$
  - dimension of $C(A^T)$ = r = 3 (the RREF pivot rows)
  - aka it spans all of $\mathbb{R}^{n}$

Ax=b will have:

- either 0 solutions or one solution
- depending on whether b is in the column space or the left-null space.
  - if in column space, a unique solution exists
  - if b is the null vector, then x could either be from the null or row space, unsure
  - if b cannot be found due to inconsistent equations, then b is in the left null space.
  - However, cuz the matrix is full-ranked, no such thing as infinite solutions.
    - cuz the requirement is that there must be free variables, which is only possible if the matrix is rank-deficient (and we look at the non-pivot rows).

After RREF you will get:

- an identity matrix at the top
- rows of 0s at the bottom

and It'll look like:

$$\
A \xrightarrow{\text{RREF}} \begin{bmatrix}
I_n \\
\mathbf{0}_{(m-n) \times n}
\end{bmatrix}
$$

- a perfect identity matrix at the top
- rows of 0s after it.

### 4 spaces for full ranked tall matrix

That means:

- basis for row space $C(A^T) = I_n$
  - since you can RREF it to the identity matrix, and all rows are linearly independent
- Basis for col space C(A) = all of A's columns
  - cuz all columns have pivots

- <span style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$, with dimension = n</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{m}$ with dimension = n</span>
  - output space has m components, but we only have n independent vectors to represent in it.
- <span style="color:goldenrod">Null space $N(A) = \{\bold{0}\} \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of C(A)
  - only has the null vector.
- <span style="color:darkseagreen">left Null space $N(A^T) \subset \mathbb{R}^{m}$ with dimension = m-n</span>
  - cuz of rank-nulity theorem (dim of containing space = dim of content space + dim of associated null space)
  - its basis is just the free variable rows from RREFing $A^Ty=0$.

### 4 spaces for rank deficient tall matrix

Where:

$$A \in \mathbb{R}^{m \times n} \quad \mathrm{rank}(A) = r \lt n \lt m$$

$$
A \xrightarrow{\text{RREF}} \begin{bmatrix}
I_r \oplus F_{r \times (n-r)} \\
\mathbf{0}_{(n-r) \times n}
\end{bmatrix}
$$

- basically it row reduces to some form where you have a matrix of:
  - (n-r) rows of 0s at the bottom
  - r rows that can be rearranged such that you have:
    - an identity matrix r
    - some other matrix representing the constants and free variables involved.
      - something like a representation of the special solution (see LA05).

Basis for:

- Row space $C(A^T)$ =
  - corresponding pivot rows in A from RREF(A)
  - pivot rows of RREF(A) straight up
- Col space $C(A)$ =
  - corresponding pivot columns in A from RREF(A)
  
That means:

- <span style="color:skyblue">Row space $C(A^T) \subset \mathbb{R}^{n}$, with dimension = r</span>
- <span style="color:lightcoral">Col space $C(A) \subset \mathbb{R}^{m}$ with dimension = r</span>
- <span style="color:goldenrod">Null space $N(A) \subset \mathbb{R}^{n}$ with dimension = n-r</span>
- <span style="color:darkseagreen">left Null space $N(A^T) \subset \mathbb{R}^{m}$ with dimension = m-r</span>
  - right nullity of $C(A^T)$

## Full Row rank

Given $A \in \mathbb{R}^{m \times n}$ where $m \lt n$:

- RREFs into:
    $$\
    A \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_n
    \oplus F\}
    \end{bmatrix}
    $$

- Basis of column space can just be $I_m$

- Ax=b will always have solutions
  - because there is no row with only 0s, so no matter the coefficient you will have solutions
  - you will only have infinite solutions, because there are extra pivotless columns, or cuz x has n components aka variables,but A only has 3 equations describing the system, so one of them can take on any value.
    - alt explanation, by rank nullity theorem the equation has 4 variables but rank of 3, meaning theres 1 free variable that can lie in the null space.

That means:

- basis for row space $C(A^T)$ are pivot rows in A or RREF(A)
  - $C(A^T) \subset \mathbb{R}^{4}$
  - rank = dim = 3
- Basis for col space C(A) = Pivot columns of A, match with corresponding RREF pivot rows.

- <span style="color:skyblue">Row space $C(A^T) \subset \mathbb{R}^{n}$, with dimension = m</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{m}$ with dimension = m</span>
- <span style="color:goldenrod">Null space $N(A) \subset \mathbb{R}^{n}$ with dimension = n-m</span>
- <span style="color:darkseagreen">left Null space $N(A^T) = \emptyset \in \mathbb{R}^{m}$ with dimension = m-n</span>
  - right nullity of $C(A^T)$.

For rank defficient:

- <span style="color:skyblue">Row space $C(A^T) \subset \mathbb{R}^{n}$, with dimension = r</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{m}$ with dimension = r</span>
- <span style="color:goldenrod">Null space $N(A) \subset \mathbb{R}^{n}$ with dimension = n-r</span>
- <span style="color:darkseagreen">left Null space $N(A^T) = \emptyset \in \mathbb{R}^{m}$ with dimension = m-r</span>

---

## General formula for finding 4 space analysis of a matrix

0. remember positioning of your 4 spaces:
    - Cs on top, Ns below
    - Top right is col space C(A), treat A and $A^T$ as containers, and they should only touch by diagonals.

        |<span style="color:skyblue">$C(A^T)$</span>|<span style="color:lightcoral">$C(A)$</span>|
        |---|---|
        |<span style="color:goldenrod">$N(A)$</span>|<span style="color:darkseagreen">$N(A^T)$</span>|

1. Get the rank of the matrix
    - find the RREF of the matrix first
    - check if you can get a fully filled block as an identity matrix
2. define your input an output space as containing spaces first
    - Given $A \subset R^{m \times n}$:
      - Input containing space (num of components of x) = $\mathbb{R}^{n}$
        - matches the number of columns, n
      - Input containing space (num of components of b) = $\mathbb{R}^{m}$
        - matches the number of rows, m
3. define your row and column space
    - Look at RREF results, see how many pivots you have / your matrix rank
      - **Dimension** of your row and column space = how many pivots you have
        - has to be the same for both row and col space.
      - **Basis** of your row and column space
        - <span style="color:lightcoral">column space C(A)</span>: RREF, match pivot columns to original matrix columns
        - <span style="color:skyblue">row space $C(A^T)$</span>: RREF, straight up write down the pivot <u>rows</u> of RREF(A) or match, up to you
          - turn them around and write as column vectors.
        > [!caution] There are only 2 situations you can use the identity matrix as a basis:
        > - full rank square matrix for row space
        > - full rank tall  matrix for row space
        >
        > Easier to think that only full rank matrices + row space can fit this.
        - remember to write as a set.

4. define null and left null space
    - define their **containing spaces**
      - null space sits with row space in $\mathbb{R}^{n}$
      - left null space sits with col space in $\mathbb{R}^{m}$
    - define their **dimensions** with rank nullity theorem
      - dim(null space) = dim(containing input space) - dim(row space)
      - dim(left null space) = dim(containing output space) - dim(col space)
        $$dim(N(A)) = n - r \\
        dim(N(A^T)) = m - r$$
      - its possible to get 0, in that case the null space only contains the empty set.
        - we write $N(A) = \left\{0\right\} \in \mathbb{R}^{\text{containing space}}$
    - define their **basis**
      - null space basis, just get vectors of special solution from general solution
        - shortcut is that using $[A|0]$ still gives the same RREF(A).
        - for each free variable, set some container like "s" or something and back-substitute into row-eqn = 0
        - write pivot variables in terms of free variables and represent final vector in terms of the free variables
        - factor out the free variables as scalars using linearity
        - those are your special solution vectors, and the basis for your null space.
        - Example:

          $$
          A \xrightarrow{RREF}
          \begin{bmatrix}
          1&1&2&|&0\\
          0&0&0&|&0\\
          \end{bmatrix}
          \\\space\\
          \text {That means } x_2 \text{ and } x_3 \text{ are our free variables.}\\\space\\
          \text{find } N(A)_1 \text { by subbing } x_2 = 1, x_3 = 0 \text{ to get our first basis vector of } N(A)
          \\\space\\
          (1) x_1 + (1)(1) + (2)(0) = 0 \implies x_1 = -1
          \\\space\\
          \therefore N(A)_1 = \begin{bmatrix}
          -1\\
          1\\0
          \end{bmatrix}
          \\\space\\
          \text{find } N(A)_2 \text { by subbing } x_2 = 0, x_3 = 1 \text{ to get our second basis vector of } N(A)
          \\\space\\
          (1) x_1 + (1)(0) + (2)(1) = 0 \implies x_1 = -2
          \\\space\\
          \therefore N(A)_1 = \begin{bmatrix}
          -2\\
          0\\1
          \end{bmatrix}
          \\\space\\
          \therefore N(A) = \left\{\begin{bmatrix}
          -1\\
          1\\0
          \end{bmatrix},
            \begin{bmatrix}
          -2\\
          0\\1
          \end{bmatrix}
          \right\}
          $$  

      - left null space, compute $A^Ty = 0$ and get special solution vectors.

If asked about solutions of Ax=b, check:

- if full rank, its consistent, meaning cannot have no sols
- if rank is equal or less than dims in x
  - if rank = dim(x), unique sol
  - if rank < dim(x), infinite sol cuz you can have free variables.

---

## Computations of the 4 spaces

1. RREF the matrix first
2. Start crafting the column rows
2. match associated pivot columns in RREF(A) to A, thats the basis for your column space
3.
4.
