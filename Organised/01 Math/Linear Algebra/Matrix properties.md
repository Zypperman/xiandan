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

- denoted as $A^{-1}$
- $AA^{-1} = A^{-1}A = I$.

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
