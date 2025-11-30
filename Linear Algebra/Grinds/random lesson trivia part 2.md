# Part 2 Random Lesson Trivia

inconsistency:

- by column picture: vector b is not in the column space
- by row picture: it means that you have inconsistent equations ie a constant with no coefficients.

- white dot in the 4 space picture refers to the 0 vector

for RREF and finding the complete solution:
    - you can sub the variable with no pivots as 1, then work from there.

for linear regression, we are just getting the error between our actual b vs our predicted b for Ax.

---

## Week 10

ie given

$$
A = \begin{bmatrix}
1&1\\
0&1\\
0&0\\
\end{bmatrix}
$$

- it has rank 2

- Defining column space
  - state its containing space
    - its a subset of $\mathbb{R}^{3}$
    - has dimension 2 since it has 2 LI columns
    - Basis is:
    $$
    \left\{
        \begin{bmatrix}
        1\\
        0\\
        0
        \end{bmatrix},
        \begin{bmatrix}
        1\\
        1\\
        0
        \end{bmatrix}
    \right\}
    $$

- $b = \begin{bmatrix}1\\1\\1\end{bmatrix}$ is not in the column space of A, hence Ax=b will give us an inconsistent equation.

- However, we should still try to approximate the best solution for this system.
- we try to find a representation of b on the subspace where A resides, so we call it $\hat{b}$.

- we want to find a value for $\hat{b}$ that gives us an error value of $e = b - \hat{b}$ and e is orthogonal to the subspace of a.
  - so a suitable value is literally just $\hat{b} = \begin{bmatrix}0\\0\\1\end{bmatrix}$

---

- for 2 orthonormal vectors, if you try to do $A^TA$ it gives you an identity matrix $I_m$ (n is the number of columns)
  - anyway from here, basically only because your basis matrix is orthonormal, you can get the identtiy matrix and just reduce it again since it is its own inverse
  - from there the result is just $P = AA^T$

> [!tip] Why its the identity matrix
>
> - treat it like the left matrix is the column picture, the right matrix is the row picture
> - each element will effectively be:
>
$$
A = [a_1 \space a_2]\\
A^T = \begin{bmatrix}a_1 \\ a_2\end{bmatrix}\\

A^TA = \begin{bmatrix}a_1 \cdot a_1 & a_1 \cdot a_2 \\ a_2 \cdot a_1 & a_2 \cdot a_2\end{bmatrix}\\

$$

- the results of the two vectors dot producting each other give us 1 or 0.

---

## Week 11

Given a square matrix, it will have the same num of eigenvector-eigenvalue pairs as its dimension.

- Algebraic Multiplicity only really matters when you have 2 of the same root.
  - real, conjugate pairs
    - in that case, you'll have an eigenspace.
  - if AM is more than GM, then your matrix is not diagonalizable.
  - cuz you won't have enough eigenvectors to represent s.

- A matrix is diagonalizable if you have the same GM as AM.
  - because you won't find a nice number of eigenvalues to do $AS\Lambda S^{-1}$
  -
