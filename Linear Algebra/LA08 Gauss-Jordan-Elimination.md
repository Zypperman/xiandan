# Gauss-Jordan elimination

Refer back to LA05, where we solved equations by turning them into ones that can be back-substituted. ($REF([A|b]) = LU$, where U is an upper triangular matrix and L is a matrix representing all EROs to get U, and is a lower triangular matrix.)

- Refresher content, but U also gives us the rank/ number of pivots of A and its determinant.

Now instead of just the usual EROs to get L, back-substitution is also included as an ERO with its own elementary matrix.

This inclusion makes Gauss-Jordan elimination, and the result is known as the reduced row echelon form. (where $\begin{bmatrix}A|b\end{bmatrix}\underrightarrow{RREF}\begin{bmatrix}I|b'\end{bmatrix}$)

## Process

From the gaussian elimination process:

1. write your system of equations in the form of Ax=b
2. create the augmented matrix, W = [A|b]
3. Apply EROs which can either be:
    - swapping of 2 rows (i.e. $r_1 \leftarrow r_3, r_3 \leftarrow r_1$, but more often seen in your permutation matrix)
    - adding a multiple of 1 row to another row ($r_1 \leftarrow r_1 - 4r_3$)
    - multiplying a row by a scalar (i.e. $r_1 \leftarrow 4r_1$, )

    With the goal in mind to eliminate the 0s below the main diagonal of your matrix (ie for col 1, I want to make everything under $w_{(1,1)}$ 0). Work on each column from left to right, and work downwards for each row in the column
4. The result of this should be the matrix U.
5. write down the row operations for formatting each column, and turn each set into a matrix $E_n$ where n is each row
6. Get the inverse of each $E_n$
7. Get L by doing $L = E_1^{-1}E_2^{-1}...E_k^{-1}$ for all columns of the augmented matrix that form the coefficient matrix (aka k = number of columns in A)

### New steps (The Jordan part of GJE)

4. Perform EROs on $U$ until you end up with a strictly diagonal matrix, which usually looks like:

    - making all the pivots equal to 1
    - subtracting from the top rows using the lower rows to make all elements above the main diagonal 0
    - you're left with an identity matrix in the coefficient part of your augmented matrix and some constants, ie:

    $$
    \begin{bmatrix}
    1&0&0&|&a\\
    0&1&0&|&b\\
    1&0&1&|&c\\
    \end{bmatrix}
    $$

    Example case after getting U:

    $$
    U =
    \begin{bmatrix}
    1&1&|&5\\
    0&-2&|&-4\\
    \end{bmatrix}

    \underrightarrow{r_2\leftarrow -\frac{1}{2}r_2}

    \begin{bmatrix}
    1&1&|&5\\
    0&1&|&2\\
    \end{bmatrix} \\
    \space\\
    U =
    \begin{bmatrix}
    1&1&|&5\\
    0&1&|&2\\
    \end{bmatrix}

    \underrightarrow{r_1\leftarrow r_1-r_2}

    \begin{bmatrix}
    1&0&|&3\\
    0&1&|&2\\
    \end{bmatrix} \\
    $$

    the elemental matrices to get here are:

    $$
    E_1 = \begin{bmatrix}
        1&0\\
        0&-\frac{1}{2}
    \end{bmatrix},
    E_1^{-1} = \begin{bmatrix}
        1&0\\
        0&-2
    \end{bmatrix},
    $$
    $$
    E_2 = \begin{bmatrix}
        1&-1\\
        0&1
    \end{bmatrix},
    E_1^{-1} = \begin{bmatrix}
        1&1\\
        0&1
    \end{bmatrix},
    $$

The Augmented matrix now looks like:

$$
U = [A|b] = [I|b]
= \begin{bmatrix}
1&0&|&3\\
0&1&|&2\\
\end{bmatrix}\\
\implies\\
Ax=b\\
\begin{bmatrix}
1&0\\
0&1
\end{bmatrix}
\begin{bmatrix}
x\\y
\end{bmatrix}
=
\begin{bmatrix}
2\\3
\end{bmatrix}
$$

And you can equate each known variable directly. (ie here, x=2, y=3)

## Terminology: REF vs RREF

- REF (row echelon form) is just the upper triangular matrix you get after doing gaussian elimination, aka $U$:
    $$ U =
    \begin{bmatrix}
        a&b&c&|&d\\
        0&e&f&|&g\\
        0&0&h&|&j
    \end{bmatrix}
    $$

  - This form has 0s at the bottom of the matrix
  - pivots are just the first elements touching each row of 0s in the staircase
  - REF is actually not unique, there's many ways to get here (makes sense because you can have multiple linear systems virtually do the same thing to get the solution, usually the difference arises when you swap rows before starting)
    - really depends on the operations you do here.

---

- but only after doing the jordan part (the full process is termed "Gaussian Jordan"), then we get the reduced row echelon form (RREF).
    $$
    \begin{bmatrix}
        A|b
    \end{bmatrix} \underrightarrow{RREF}
    \begin{bmatrix}
        I|b'
    \end{bmatrix}
    \\\space\\
    \text{where}
    \\\space\\
    \begin{bmatrix}
        I|b'
    \end{bmatrix} =
    \begin{bmatrix}
        1&0&0&|&d\\
        0&1&0&|&g\\
        0&0&1&|&j
    \end{bmatrix}
    $$
  - Has the same properties as REF
  - All pivots are now scaled properly so no further manipulation required
  - each pivot column only has 1 entry, termed the "unit pivot"
  - RREF is unique, and is often also termed "the canonical form".
    - because its possible that an augmented matrix can have multiple valid REFs, but there can only be 1 RREF. It is unique.

$$

[A|b] \space \underrightarrow{\text{RREF}}
\begin{bmatrix}
1 & 0 & 0 & | & 1 \\
0 & 1 & 0 & | & 2 \\
0 & 0 & 1 & | & 3
\end{bmatrix}
\Rightarrow
\begin{bmatrix}
1 & 0 & 0 \\
0 & 1 & 0 \\
0 & 0 & 1
\end{bmatrix}
\begin{bmatrix}
x \\
y \\
z
\end{bmatrix}
=
\begin{bmatrix}
1 \\
2 \\
3
\end{bmatrix}
$$

## RREF properties II

- if your RREF form results in an identity matrix on the coefficient part of the augmented matrix  it means that:
  - you have a unique solution
    - cuz when you turn it into the form:

        $$
        [A|b] \space \underrightarrow{\text{RREF}}
        \begin{bmatrix}
        1 & 0 & 0 & | & g \\
        0 & 1 & 0 & | & h \\
        0 & 0 & 1 & | & i
        \end{bmatrix}
        \Rightarrow
        \begin{bmatrix}
        1 & 0 & 0 \\
        0 & 1 & 0 \\
        0 & 0 & 1
        \end{bmatrix}
        \begin{bmatrix}
        x \\
        y \\
        z
        \end{bmatrix}
        =
        \begin{bmatrix}
        g \\
        h \\
        i
        \end{bmatrix}\\
        \space
        \\
        [A|b]\underrightarrow{\text{RREF}}[I|b']\implies \text{ x=b' is your solution}
        $$

        Its like saying ie. for row 1, when you perform the row picture of matrix multiplication, $1(x)+0(y)+0(z) = g \implies x=g$

  - all non-singular invertible matrices can be row-reduced to the identity matrix.
    - This is termed "row equivalence"
    - They are also considered column equivalent since they are invertible.

## Rank in relation to RREF

- For Square matrices (ie. $A \in \mathbb{R}^{n\times n}$):
  - Condition:
    - matrix must be invertible (must have a valid $A^{-1}$)
    - matrix must be non-singular (aka have a non-zero determinant)
    - The square matrix is full ranked (so rank(A) = r = n)
    - all of its rows are linearly independent
  - Result:
    - All its pivots can be turned into unit pivots (aka &#8594; 1)
    - you can row reduce it to an identity matrix of the same size.  
        $A\space \underrightarrow{RREF} \space I_n$

- For rank-deficient matrices (ie $B \in \mathbb{R}^{n\times n}$)
  - Condition:
    - The square matrix is rank-deficient (so rank(A) = r < n)
    - you have r linearly independent rows
  - Result:
    - you'll get an identity matrix $I_r$, sized based on the number of independent rows
    - bottom few (n-r) rows will be 0s
    - some columns won't have pivots, corresponding variables are termed free variables.
    $$
    B \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_r \oplus F_{r \times (n-r)} \\
    \hline
    \mathbf{0}_{(n-r) \times n}
    \end{bmatrix}
    $$

    looks complicated, but i.e. for a rank 2 4x4 matrix, W:
    $$
    W =
    \begin{bmatrix}
    1&2&-1&4\\
    2&4&-2&8\\
    3&6&0&9
    \end{bmatrix}
    $$

    We can tell that row 1 is a multiple of row 2 so there's only 2 linearly independent rows here. RREF-ing this gives us:

    $$
    W \underrightarrow{RREF}
    \begin{bmatrix}
    1&2&0&3\\
    0&0&1&-1\\
    0&0&0&0
    \end{bmatrix}
    $$

    we can partition the first 2 rows as 1 block:

    $$
    \begin{bmatrix}
    1&2&0&3\\
    0&0&1&-1\\
    -&-&-&-\\
    0&0&0&0
    \end{bmatrix}
    $$

    and swap columns 2 and 3 to get:

    $$
    \begin{bmatrix}
    \begin{matrix}
        \begin{bmatrix}
        1&0\\
        0&1
        \end{bmatrix}
        \begin{bmatrix}
        2&3\\
        0&-1
        \end{bmatrix}
    \end{matrix}\\\\
    \hline\\
    \begin{bmatrix}
    0&0&0&0
    \end{bmatrix}
    \end{bmatrix}
    $$

    the $\oplus$ notation just means that the top 2 rows is just some combination of columns that can be broken into 2 parts:

    - an identity matrix denoting the unknowns
    - some other matrix representing the constants and free variables involved.
      - something like a representation of the special solution (see LA05).

- For Tall matrices (ie. $C \in \mathbb{R}^{m\times n}$):
  - conditions:
    - the matrix is full-ranked, so all columns are linearly independent
    - aka rank(A) = r = n < m
  - result:
    - all columns will have a pivot scalable to 1
    - bottom m-r rows become 0s
    $$
    [C|b] \space \underrightarrow{RREF}\begin{bmatrix}
        I_n\\
        0_{(m-n)\times n}
    \end{bmatrix}

    =
    \begin{bmatrix}
    1&0&0&|&a\\
    0&1&0&|&b\\
    1&0&1&|&c\\
    0&0&0&|&0\\
    0&0&0&|&0\\
    &...&&|&0\\
    0&0&0&|&0\\
    \end{bmatrix}

    $$

- For Tall matrices that are rank deficient, the same idea applies that you will have rows in your rref where some free variable columns are mixed in:
    $$
    B \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_r \oplus F_{r \times (n-r)} \\
    \hline
    \mathbf{0}_{(m-r) \times n}
    \end{bmatrix}
    \\\text{so:}
    \\
        =
    \begin{bmatrix}
    1&0&1&|&a\\
    0&1&0&|&b\\
    0&0&0&|&0\\
    0&0&0&|&0\\
    0&0&0&|&0\\
    &...&&|&0\\
    0&0&0&|&0\\
    \end{bmatrix}
    $$

- For Wide matrices (ie. $D \in \mathbb{R}^{n\times m}$):
  - if its full rank, you get an identity matrix, but you will definitely have some free variable columns mixed in.
    $$
            D \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_r \oplus F_{r \times (n-r)} \\
    \end{bmatrix}\\\space
    \\\text{so:}\\\space\\

    W \xrightarrow{\text{RREF}}

    \begin{bmatrix}
    1&2&0&|&3\\
    0&0&1&|&3\\
    \end{bmatrix}
    $$
  - otherwise, you'll have rows of 0s at the bottom of the matrix:
    $$
            D \xrightarrow{\text{RREF}} \begin{bmatrix}
    I_r \oplus F_{r \times (n-r)} \\
    \end{bmatrix}\\\space
    \\\text{so:}\\\space\\

    W \xrightarrow{\text{RREF}}

    \begin{bmatrix}
    1&2&0&|&3\\
    0&0&1&|&3\\
    0&0&0&|&0\\
    \end{bmatrix}
    $$

## TLDR

Full ranked matrix:

- square/tall matrix &#8594; can reduce to Identity matrix on top, with 0s below
- wide matrix &#8594; can reduce but might not get an identity matrix

Rank-deficient matrix:

- you may not get a nice separation.

EROs can be turned into matrices.

- can be used to swap around all the rows to form the identity matrix of your RREF form
- its also why row rank = column rank.
