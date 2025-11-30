# Lower Upper Decomposition (LU Decomp)

## What are Elementary Row Operations (ERO)s, exactly...?

- EROs are typically used for solving linear systems by reducing their row echelon forms, or simplifying the determinants of a matrix.
  - Involve operations like:
    - swapping rows ($r_1 \leftrightarrow r_2$)
    - scaling a row ($r_1 \leftarrow 2r_2$)
    - adding a multiple of a row to another ($r_1 \leftarrow r_1 - 2r_2$)

- But its actually possible to treat each ERO as its own matrix, and stack all the edits into a single matrix.
  - treat it like a linear combination of a matrix on the right.
  - This is termed the "Elementary Matrix", or the "Elementary Operator".
  - Denoted with $E_i$, and applying onto A, we write it as $E_iA$, and as a matrix multiplication for all the manipulations we've done.
  - Row by Row, it'll look more like $E_kE_{k-1}...E_2E_1A=U$
    - each E is a single ERO, that we can eventually compress into 1 matrix.
    - Eventually, we'll get a reduced matrix thats an Upper Triangular matrix (with 0s below the main diagonal) that we call U.
      - FYI this U forms the "Upper" namesake of LU Decomp.

## Example to note: $r2 \leftarrow r1 - r2$

Given the augmented matrix for 2 equations:

$$
\begin{bmatrix}
    1&1&|&5\\
    1&1-&|&1
\end{bmatrix}
$$

To perform the operation $r2 \leftarrow r1 - r2$, we look to format it using the row picture of matrix multiplication:

$$
E_1A = \begin{bmatrix}

    -&p&-\\
    -&q&-\\
\end{bmatrix}
\begin{bmatrix}
    -&a_1&-\\
    -&a_2&-
\end{bmatrix}\\
=

\begin{bmatrix}
    p1&p2\\
    q1&q2\\
\end{bmatrix}
\begin{bmatrix}
    -&a_1&-\\
    -&a_2&-
\end{bmatrix}

\\=
\begin{bmatrix}
    p1(a_1)+p2(a_2)\\
    q1(a_1)+q2(a_2)
\end{bmatrix}

$$

- for the first row to not be edited, we need it to be $1(a_1) + 0(a_2)$, so the first covector in E is $[1\space 0]$
- for the second row operation to be performed, we need it to be $-1(a_1) + 1(a_2)$, so the second covector in E is $[-1\space 1]$

This gives us $E = \begin{bmatrix}
    1&0\\
    -1&1\\
\end{bmatrix}$.

### General shortcuts

Think of E as covectors, and E is usually a square matrix with the same number of dimensions as rows in A (cuz y'know, $E_kA$, so $A \in \mathbb{R}^{m\times n} \implies E \in \mathbb{R}^{m\times m}$):

$$
\begin{bmatrix}
    - & \hat{e_1} & -\\
    - & \hat{e_2} & -\\
    &...&\\
    - & \hat{e_m} & -\\
\end{bmatrix}
$$

And the elements of each covector deal with each corresponding row. So for the kth row of the resultant matrix U:
$$
\hat{e_k} =

\begin{bmatrix}
e_1 & e_2 & ... & e_m
\end{bmatrix}
\\
\space\\
\text{that means for Row k in Matrix U:}
\\
\space\\
r_k = e_1 (a_1)+ e_2(a_2) + ... + e_m(a_m)
$$

<span style="color:cyan">For retaining a row:</span>

just use a row from the identity matrix. a 1 at the row where it's at, 0 everywhere else.

<span style="color:cyan">For swapping rows (ie $r4 \leftarrow r7$):</span>

$$
\hat{e_4} = \begin{bmatrix}
    0&0&0&0&0&0&1&0&...&0
\end{bmatrix}
\\
\space\\
\hat{e_7} = \begin{bmatrix}
    0&0&0&1&0&0&0&0&...&0
\end{bmatrix}
$$

we make the 7th row have a 1 in the 4th column, and nowhere else, and vice versa for the 5th row of E.

<span style="color:cyan">For scaling a row (ie $r4 \leftarrow 4r4$):</span>

$$
\hat{e_4} = \begin{bmatrix}
    0&0&0&4
\end{bmatrix}
$$

same as the identity matrix row, but replace 1 with the scaling factor.

<span style="color:cyan">For adding a multiple of a row (ie $r4 \leftarrow r4 - 3r_1$):</span>

$$
\hat{e_4} = \begin{bmatrix}
    -3&0&0&1
\end{bmatrix}
$$

add the coefficient for the row you want added, and maintain the original row to be 1.

- put a 1 in column 4 to indicate that row 4 is to be added
- put a 3 in column 1 to indicate that i also want 3 of row 1 to be subtracted.
- use negative coefficients for subtraction.

#### The easiest way to view it

Treat it like $r_4 \leftarrow -3r_1 + 0r_2+0r_3 + 1(r_4)$, and take its coefficients. Same for the other rows.

## Generalizing the Elementary matrix

Each elementary matrix representing an operating matrix is just slightly different at the affected rows, and have covectors that match those in their corresponding identity matrix, ie for $r_3 \leftrightarrow r_2$ and I:

$$
E =
\begin{bmatrix}
    1&0&0\\
    0&0&1\\
    0&1&0\\
\end{bmatrix},
I =
\begin{bmatrix}
    1&0&0\\
    0&1&0\\
    0&0&1\\
\end{bmatrix}
$$

- They will do the same thing for every matrix inputted / on their left
- E is said to be different from I by <u>1 row operation</u>
- If E swaps rows, the determinant's sign flips
- If E turns 1 row into a linear combination of the original covector,the determinant is unchanged.
- since E can be modified from I, $|I| \implies |E| = \pm 1$ in those cases.
  - exception being the scaling case, where for that case $|E| = a|I|$.

## Elementary Matrix Inverse (preamble)

The inverse of a matrix is just the reverse mapping.

- For E, $E^{-1}$ does the opposite of what E does.
- basically, $Ax=b \implies A^{-1}b = x$, and A undoes what was done to b, giving back x.

<span style="color:cyan">Elementary inverses</span>

- Swap-row-matrix
  - The inverse of $E =\begin{bmatrix}1&0&0\\0&0&1\\0&1&0\\\end{bmatrix}$ is itself.
  - known as an involutory matrix, where A matrix is its own inverse.
  - Also cool that for involutory matrices, $E^2 = I$.
  -

- scale-row-matrix
  - The inverse of $E =\begin{bmatrix}1&0&0\\0&4&0\\0&0&1\\\end{bmatrix}$ is one where $r_2 \leftarrow \frac{1}{4}r_2$, so $E^{-1} =\begin{bmatrix}1&0&0\\0&\frac{1}{4}&0\\0&0&1\\\end{bmatrix}$

- add-row-matrix
  - The inverse of $E =\begin{bmatrix}1&0&0\\0&1&0\\-3&0&1\\\end{bmatrix}$ is one where instead of  
  $r_3 \leftarrow -3r_1+r_3$, its  
  $r_3 \leftarrow 3r_1 + r_3$,  

  so $E^{-1} =\begin{bmatrix}1&0&0\\0&1&0\\3&0&1\\\end{bmatrix}$

  The inverse is just to take all the edits, and flip their signs.

### Elemental matrix properties

for RREF where $EA = E_1E_2...E_kA = U$:

- Elementary matrices for one-shot gaussian elimination is usually a lower triangular matrix (so 0s for all elements above the main diagonal)
- RREF usually only involves the "add-row-matrix" from above.
- The product is also usually a lower triangular matrix (referring to E in $E = E_1E_2...E_k$ over k operations)
- The inverse is also usually a lower triangular matrix

## LU Decomposition Actual start

Ultimately, the coolest thing is that:

$$EA = U
\\\space\\
\therefore A = E^-1U = LU
$$

$E^-1$ is termed a lower triangular matrix "L", thus giving the "Lower" namesake of LU Decomp.

Also, this means that we can represent any matrix as 2 matrices:

- A lower triangular matrix representing all the transformations done onto U that, done in reverse, give us A
- An upper triangular matrix for getting solutions to Ax=b via back substitution.

### properties of the L and U matrix

- Since L is composed of only add-row-matrices, it means that $|E| = |L| = 1$
  - proof: the determinant is just obtained from the diagonal since its a lower triangular, meaning only the first minor matters, and the first minor's determinant is recursively obtained as the product of the main diagonal. Since the main diagonal only has 1s, its determinant is 1. (but this is only true if the EROs used are not swap-row EROs.)

- Since $|L|=1$, that means you can just use U to find the determinant of A since $|U| = |A|$
  - Once again, its just the product of the diagonal elements since its an upper triangular matrix.
  - also, if U is rank-deficient, then $|A|=0$. Easier to distinguish in this form.

## General LU Decomp steps

1. Look at A, try and figure out how to RREF it / turn it into an upper triangular matrix
    - try to get rid of elements to form the triangle of 0
    - start from the top of the stairs, clear column by column from left to right
    - ie given $I=\begin{bmatrix}a&b&c\\d&e&f\\ g&h&i\\ \end{bmatrix}$, aim to turn d,g and h into 0s in that order.
2. stop for each column completed write down E_i based on the EROs done
3. repeat for each column until you end up with U
4. multiply all the $E^{-1}_i$ for each column in order (so $E^{-1}_1E^{-1}_2...E^{-1}_k$) to get L.

L is calculated as $E^{-1}_1E^{-1}_2...E^{-1}_k$ because:

$$
\text{operate on column 1:}\\
E_1A=W \text{ get temporary result matrix w}\\
\text{operate on column 2:}\\
E_2W=Q \text{ get temporary result matrix Q}\\
\text{Hence:}\\
EA = E_kE_{k-1}...E_2E_1A = U\\
E_{k-1}...E_2E_1A = E_k^{-1}U\\
E_{k-2}...E_2E_1A = E_{k-2}^{-1}E_k^{-1}U\\
...\\
E_1A = E_2^{-1}...E_{k-2}^{-1}E_{k-1}^{-1}E_k^{-1}U\\
A = E_1^{-1}E_2^{-1}...E_{k-2}^{-1}E_{k-1}^{-1}E_k^{-1}U
$$

Each E for each column operates one at a time, so we also have to inverse it one by one.

## Permutation Matrices

- its what we refer to the swap-row-matrices, if they're involved. Best case is if they're just identity matrices, meaning no swaps required.
- Denoted with "P".
- depending on the swaps done, $|P| = \pm 1$

We can rewrite A into $A = PLU$.

- In this case, $|A| = |P||U| = \pm |U|$.

## Using LU Decomp with RREF

- remember to apply all EROs to the whole augment matrix, so even the coefficients feel the effect of add-row transformations.

- for infinite sol cases (ie rank < # vars>) the free variable is just the column with no pivots.
