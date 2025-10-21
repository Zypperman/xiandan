# Matrix Spaces

## For square matrices

### Full ranked square matries

- full rank matrix ie $\mathbb{R}^{3\times3}$ means:
  - its rank is 3
  - its column and row space dimension should also be 3
  - each should contain 3 vectors
  - Ax=b will have unique solutions.
    - cuz the equations are consistent and linearly independent.

- Basis for our spaces:
  - since by GJE it gives us the identity matrix, we can just use the identity matrix as a basis since its equivalent and easier (not always the case, only for full rank case.)
  - both $C(A) \text{ and } C(A^T)$ can use $I_n$ as their basis.
  - both $I_n$ and the real basis are roe and column equivalent to each other.

### TLDR

- for $A \in \mathbb{R}^{n \times n}$, rank(A)=r=n:
  - A has the column and row space with basis $I_n$
    - because $A \xrightarrow{RREF} I_n$

That means:

- <span style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{n}$</span>
- <span style="color:goldenrod">Null space $N(A) = \emptyset \text{ in } \mathbb{R}^{n}$</span>
- <span style="color:darkseagreen">left Null space $N(A^T) = \emptyset \text{ in } \mathbb{R}^{n}$</span>

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

- <s.. style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$, with dimension = r</s..\.;pan>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{n}$ with dimension = r</span>
- <span style="color:goldenrod">Null space $N(A) = \emptyset \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of C(A)
- <span style="color:darkseagreen">left Null space $N(A^T) = \emptyset \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of $C(A^T)$

---

## For Tall matrices

### Full ranked tall matrices

Given a matrix of $\mathbb{R}^{m\times n}, m \gt n$ (ie given $4\times3$)

- we can RREF it to an identity matrix of r and (m-r) zeros
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

- Full rank = all columns are linearly independent

- column space properties:
  - $C(A) \subset \mathbb{R}^m$ ie $\mathbb{R}^{4}$
  - $dim( C(A))= n = r$ ie. 3 (the 3 columns of A that are linearly independent)

- row space properties:
  - $C(A^T) = \mathbb{R}^n$ ie $\mathbb{R}^{3}$
  - dimension of $C(A^T)$ = r = 3 (the RREF pivot rows)

Ax=b will have:

- either 0 solutions or one solutions
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
- Basis for col space C(A) = all of A's columns
  - cuz all columns have pivots

- <span style="color:skyblue">Row space $C(A^T)$ = $\mathbb{R}^{n}$, with dimension = r</span>
- <span style="color:lightcoral">Col space $C(A)$ = $\mathbb{R}^{m}$ with dimension = n</span>
  - output space has m components, but we only have n independent vectors to represent in it.
- <span style="color:goldenrod">Null space $N(A) = \{\bold{0}\} \text{ in } \mathbb{R}^{n}$ with dimension = n-r</span>
  - right nullity of C(A)
  - only has the null vector.
- <span style="color:darkseagreen">left Null space $N(A^T) = \emptyset \subset \mathbb{R}^{n}$ with dimension = m-n</span>
  - right nullity of $C(A^T)$.

### 4 spaces for rank deficient tall matrix

- see square matrix case, same deal.

## Full Row rank

Given $A \in \mathbb{R}^{m \times n}$ where $m \lt n$:

- RREFs into:
    $$\
    A \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_n
    \oplus F_{m \times (n-m)}
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

## Computations of the 4 spaces


1. RREF the matrix first
2. Start crafting the column rows
2. match associated pivot columns in RREF(A) to A, thats the basis for your column space
3. 
4. 