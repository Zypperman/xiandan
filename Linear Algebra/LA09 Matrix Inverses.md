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

### Cool shortcuts

- GJE involves applying elemental matrices as EROs onto your augmented matrix.
 	- basically the same as doing E[A|I]
 	- In that case, the block-wise matrix multiplication makes sense and you can do:
		$$
		D \begin{bmatrix}
			B & |&C
		\end{bmatrix} =
		\begin{bmatrix}
			DB &|& DC
		\end{bmatrix}
		$$
		Since D,B and C $\in \mathbb{R}^{n\times n}$ and conveniently [B|C] $\in \mathbb{R}^{n\times 2n}$

  		- even easier to see if you do matrix multiplication normally, where in each element of the resulting matrix, you use a row of D and a column of either B or C, and the calculations never cross.
 	- Relating back to RREF:
		$$
		E \begin{bmatrix}
			A&|&I
		\end{bmatrix} =
		\begin{bmatrix}
			EA&|& EI
		\end{bmatrix} = ... =
		\begin{bmatrix}
			I&|& A^{-1}
		\end{bmatrix}\space\\
		\implies\\
		EA = I \implies E = A^{-1} \space\&\space
		E = M \implies M = A^{-1}
		$$
		which checks out.

## Alternate way of getting inverses: via cofactors

- Recall from calculating determinants that there is a recursive formula:
	$$
		\text{given }A = \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix},\\\space\\

		|A| = C_{1,1}+C_{1,2}+C_{1,3}\\\space\\

		= (-1)^{1+1} M_{1,1}+ (-1)^{1+2} M_{1,2}+ (-1)^{1+3} M_{1,3}\\\space\\

		= (-1)^{1+1}\begin{bmatrix}
			e&f\\h&i
		\end{bmatrix} + (-1)^{1+2}\begin{bmatrix}
			d&f\\g&i
		\end{bmatrix} + (-1)^{1+3}\begin{bmatrix}
			d&e\\g&h
		\end{bmatrix}
	$$

	1. The minor of an element in a matrix is the resultant matrix you get from covering the row and column it sits in, then making a matrix from it.
	2. Get the minors for each element in the first row. (marked $M_{1,n}$)
	3. A Cofactor is when you get the determinant of a minor, and you factor it by $(-1)^{i+j}$ where i and j are the coordinates of that element.
	4. sum the cofactors of the first row of your matrix.

- Now, there's another use for cofactors.

 	- The formula for getting a cofactor for a given element is:

		$$
		C_{i,j} = (-1)^{i+j}|M_{i,j}|
		$$

		Now, we just make an entire matrix of cofactors. we call it the <u>cofactor matrix</u>.

- From here, we transpose the cofactor matrix
 	- termed many things, like the original matrix's "Adjunct" / "clasical adjoint", and even the "adjugate" matrix (just words to know)
- The formula for the inverse matrix is thus:
	$$
	A^{-1} = \frac{1}{|A|}C^T
	$$
 	- but this is very resource-intensive to calculate.

### ultimate inverse calculation shortcut: via Cofactor for 2x2 matrices

- Just plug formula:
	$$
	\text{given }A = \begin{bmatrix} a & b \\ c &d \end{bmatrix}
	\\\space\\
	C^T = \begin{bmatrix}
		d&-c\\
		-b&a\\
	\end{bmatrix}
	\\\space\\

	A^{-1} = \frac{1}{ad-bc} C^T
	\\\space\\
	= \frac{1}{ad-bc}\begin{bmatrix}
		d&-c\\
		-b&a\\
	\end{bmatrix}

	$$
	Just remember to:
 	- Swap the main diagonal's elements around
 	- flip the sign of your anti-diagonal elements
 	- divide by original matrix's determinant.

## Left and Right inverses

- Actually, you can define inverses for rectangular matrices.
 	- so long as their determinants are not 0.

- For rectangular matrices, we are more concerned about the inverse properties of the small matrices we can form with them.

- For tall matrices:
 	- we can do $A^TA$ (so each element of the resultant matrix has a really long computation)
 	- $A^TA$ can be inverted ($(A^TA)^{-1}A^TA = I \implies (A^{-1}(A^T)^-1A^T)A = I$)
 	- We thus have $(A^TA)^{-1}A^T$ as a left inverse of A
- For wide matrices:
 	- we can do $AA^T$
 	- $AA^T(AA^T)^{-1} = I \implies A(A^T(AA^T)^{-1}) = I$
 	- Therefore wide matrices have right inverses.

> [!tip] how to remember
> wide = right inverse. Tall = left.  
> Put the inverse on that side, the transpose on the other side.
