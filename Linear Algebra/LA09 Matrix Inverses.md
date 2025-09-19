# Matrix Inverses

- Only exist for square matrices
- A matrix when multiplied with its inverse should give you an identity matrix:

	$$
	AA^{-1} = A^{-1}A = I
	$$

 	- effectively gave us the idea of how to derive  
	 $x$ from $Ax=b$ ($Ax = b \rightarrow x = A^{-1}b$)

- not all square matrices are invertible, ie:
 	- null matrices
 	- you have a determinant of 0
  		- singular matrices
  		- non-degenerate matrices
		
## Conditions be invertible

- Determinant just cannot be 0.
 	- if they're singular aka det(A) = 0 you can't invert them.

- Not a condition, but the REF form will be full-ranked

- ideally the system described by Ax = b has a unique solution

> [!tip] Terminology: linear automorphism
> Its when your matrix A has a one-to-one, onto mapping from one space to the same space.
>
> - it is a transformation from one space to the same space, and any vector that you multiply this with gives you a different vector.

## Properties of an Inverse

- Basic one, but $A^{-1}A = I$

**Scaling a Matrix**

- if s is a scalar, $(sA)^{-1} = s^{-1}A^{-1}$
 	- prove by trying to get the identity matrix from it.
 	- $(sA)s^{-1}A^{-1} = I$

**Product Rule**

- if s is a scalar, $(AB)^{-1} = B^{-1}A^{-1}$
 	- prove by trying to get the identity matrix from it.
 	- you can multiply the 2 Bs together to get I, then the 2 As.

- Involutory matrices: Matrices that are their own inverse.

- Determinants of an inverse is equal to the reciprocal of the original's determinant:
	$$
	|A^{-1}| = \frac{1}{|A|}
	$$

## How to get Inverses (with GJE)

- recall to get the solutions for Ax=b, i create the augmented matrix [A|b].
 	- random thing, we say that "matrix A is augmented by b"
- In this situation, we augment matrix A by I and get the RREF of this matrix:
	$$
	\begin{bmatrix}
		A|I
	\end{bmatrix}

	\xrightarrow{RREF}

	\begin{bmatrix}
		I|A^-1
	\end{bmatrix}
	$$

This is considered the most efficient way to compute the inverse.
