# ICE mistakes

## Week 01

Q2. Which of the following is not a function?  
(a) $f(\boldsymbol{x}) = \lVert \boldsymbol{x} \rVert$  
(b) $f(\boldsymbol{x}) = \lVert \boldsymbol{x} \rVert^2$  
(c) $f(\boldsymbol{x}) = |\boldsymbol{x}|^{\frac{1}{2}}$  
(d) $f(\boldsymbol{x}) = |\boldsymbol{x}|^{\frac{1}{3}}$  

Answer:

(c) Since $|\boldsymbol{x}|^{\frac{1}{2}} = \pm \sqrt{\boldsymbol{x}}$, it is not single valued, and therefore not a function by our definition.

we interpret that $f(x) = \sqrt{x}$ just refers to the square roots of x as in $f(x) = \pm\sqrt{x}$, instead of what it actually means, which is the principle square root of x (referring to only the + version).

---

## Week 02

- you can do this weird thing where $(A+B)^2 = A^2 + AB + BA + B^2$, so long as:
  - A and B are square matrices so the shapes work for m.multiplication
  - AB = BA.
  - conversely, $(A-B)^2 = A^2 - 2AB = B^2$

- if a set of vectors are linearly independent, then theres no way to sum them such that you get the null vector.
  - Proper proof format:
    1. try to, where possible, assume the new set of vectors are not LI
    2. That means you can scale and summing them somehow to gives you 0.
    3. reformat in terms of original L.I. vectors
    4. cuz the only way the old L.I. vectors can give you the null vector is if their scaling coefficients are 0, equate the terms to 0
    5. solve with RREF to see if you get a unique solution of 0
        - if yes, congrats its your new set of vectors is LI.
        - if not, likely you'll have infinite solutions.
          - sub in free variables where necessary, represent answer in parametric vector form.
        - Not likely that you will have an inconsistent system, cuz the equation is a homogeneous one, so you won't get a situation where all coefficients are 0 and your constant is non-zero.

- euclidian norm / 2-norm = $||v||$ = $\sqrt{v \cdot v}$ = $\sqrt{ \sum_{i=1}^nv_i^2}$
- dot product is distributive.
  - $\text{given } z = av+bu,\\ z\cdot w = a(v\cdot w) + b(v \cdot w)$
  - because of that:
    $$
    p = ax+by,\\
    q = cw+dz,\\
     p\cdot q = (ax+by)\cdot(cw+dz)
     \\
     = (ax+by)\cdot (cw) + (ax+by)\cdot(dz)
     \\
     = (ax\cdot cw) + (by\cdot cw) + (ax\cdot dz) + (by \cdot dz)
    $$

- for finding a range of values for some unknown in a span of vectors to be LI or not:
  - throw into [A|0] format and RREF
  - to be LI, make sure that the result ensures that input vector x must be 0
    - ALL components must be 0

  - to not be LI, find a non-zero vector xthat gives you 0
    - min 1 component must never be 0.

- try to see if theres an identity matrix somewhere, where possible.
- if 2 vectors are parallel, you can represent one as a scaled version of the other.

---

## Week 3

- symmetric matrices can multiply and match shapes, but that doesn't mean that $BA = AB$.
- you can tell if a matrix has linearly dependent rows by checking if theyre signular (smack into a matrix then check if determinant = 0)
  - also if you want to check for a set of vectors, just throw them into a matrix.
   the determinant-product rule $|AB| = |A|\space |B|$ works for $|A^n|$ as well to give you $|A|^n$.

- symmetric property can be messed with: $ C = A + A^T$ and $C = A - A^T$ to get symmetric and skew-symmetric matrices respectively.

- linearity in each row / column property:

  - $$\begin{vmatrix} a_{11} & a_{12} & a_{13} \\ b_{21} + c_{21} & b_{22} + c_{22} & b_{23} + c_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix}

     = \begin{vmatrix} a_{11} & a_{12} & a_{13} \\ b_{21} & b_{22} & b_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix} + \begin{vmatrix} a_{11} & a_{12} & a_{13} \\ c_{21} & c_{22} & c_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix}$$
  - also can mess wit the fact that swapping rows flips the determinant's sign, and scaling a row scales the determinant by the same factor.

- proof for upper or lower triangular matrix is just laplace expansion:
  - I get the first minor, and the rest are 0
  - I get the determinant for my minor, and then i only get the first diagonal element at 11, the rest are 0
  - gg ez times all together.

- for abstract matrices, make sure to try to get either an upper or lower tringular matrix so its easier to calc its determinant.
  - try to push all operations to the first row so that a scalar can be factored out from that row (ie a full row of n)
  - then use that simplified row be used to make the rest of the matrix easier to work with
  - aim for a triangular matrix from there.

- Minors and cofactors
  - minors = raw determinant of the submatrix
    - cover that row and element, then use the remaining square to make a matrix and get that determinant
  - cofactor = minor times that row's order, by $(-1)^{i+j}$

- literally just remember if determinant non-zero, its not signular. its full ranked.
  - if they ask you to prove with a matrix with blank values:
    - if they want you to prove that it is invertible = det not 0 = find values for 0, then say those are impossible.

- determinant for a skew symmetric matrix
  - $|A| = |-A^T|$
  - but because $|A| = |A^T|$, $|A| = |-A|$
  - you can either from here say that $|A * (-I)| = |A| * |-I| = |A| * -1$
    - then -I is only negative if it has odd number of elements.
  - or say that if you scale all the rows by s, you get $s^n|A|$
    - and doing |-A| is like scaling all rows by -1 so its $(-1)^n|A|$
    - so you will end up with $|A| = -|A|$, which is only true if $|A|=0$

---

## Week 4

- homogeneous equations are an exception where a system can never be inconsistent
  - cuz there wont be a case where all coefficients are 0 and b is non-zero.
  - even if A is singular.

- For any A, if you establish already that theres a unique solution, it means the coefficient matrix is already full ranked.
  - means its impossible to find a vector for infinite solutions.
  
---

## Week 10

- for the projection matrix, you can either be rank deficient (project onto a line) or full ranked and might as well be the identity matrix, or some orthonormal variant.
  - that means your determinant will always be either 0 or 1.

- Projection matrix stuff: (tldr remember $P = A(A^TA)^{-1}A^T$)
  - Tall, full rank matrix -- means your projection matrix will be super big -- each side = number of rows , which is larger
  - Wide, full-rank matrix -- means your projection matrix will be smaller -- each side = number of rows, which is smaller
    - usually can be reduced to I.

---

## Week 11

- if a matrix is orthonormal, its transpose is equal to its inverse.
- always try to mess with the dot product definition and 2 norm definition.
- 1-norm is sum of the magnitude of all components.
- real symmetric matrices have conjugate paired eigenvalues.
- if a matrix is linearly dependent, it is automatically singular meaning its determinant is 0.

---

## Week 13

- the max number of linearly independent eigenvectors a matrix can have is just the number of columns it has.
  - if they don't have to be linearly independent, technically you can have infinitely many, all spurring from the onelinearly independent one, then you just scale the eigenvalue accordingly.

> [!tip] Core result in linear Algebra
> $$\mathbf{1} \le \text{Geometric Multiplicity}(\lambda) \le \text{Algebraic Multiplicity}(\lambda) \le \mathbf{n}$$

- get GM of a matrix by finding the rank of the null space of $(A-\lambda I)$
  - get the rank of $(A-\lambda I)$ (also note that this matrix is supposed to be singular, meaning its determinant is 0)
  - apply rank nullity theorem, so its GM = containing space - column space rank

---

## Important properties to remember for proving

- always remember linear independence definition
  - the scalars used to scale each vector and sum to get the null vector can only be 0.

- Determinant stuff
  - $|I| = 1$
  - determinant of the inverse: $|A^{-1}| = \frac{1}{|A|}$. NO NEGATIVE SIGN.
  - determinant of the transpose is the same as the original
    - $|A^T| = |A|$
  - each row swap flips the sign of the determinant
  - scaling a row  or column causes the determinant to be scaled by the same factor
    - if $B = r_n \leftarrow x\space r_n, |B| = x|A|$
  - adding one row to another doesn't change the determinant.
  - if A has any row / column of all 0s, $|A| = 0$
  - if A has two of the same column / row, $|A| = 0$
  - if A is rank-deficient, $|A|=0$
  - for triangular matrices, the determinant is just the product of the diagonal.
  - $|AB| = |A|\space |B|$
  - quick math, $|A|$ for A $\in \mathbb{R}^{2 \times 2}$ is $ad- bc$.
  - cool thing: A determinant can be split into a sum of two determinants if one row (or column) is expressed as a sum of two numbers. This is referred to as the **linearity in each row or column**.
    - if a row (or column) of a matrix $\mathbf{A}$ is the sum of two row vectors (or column vectors), say $\mathbf{r}' + \mathbf{r}''$, then the determinant of $\mathbf{A}$ can be split into the sum of the determinants of two matrices ($\mathbf{B}$ and $\mathbf{C}$) where:

    1. Matrix $\mathbf{B}$ is identical to $\mathbf{A}$ except the row in question is replaced by $\mathbf{r}'$.
    2. Matrix $\mathbf{C}$ is identical to $\mathbf{A}$ except the row in question is replaced by $\mathbf{r}''$.

    i.e.:
    Let $\mathbf{A}$ be a $3 \times 3$ matrix where the second row is a sum of two row vectors:

    $$\mathbf{A} = \begin{vmatrix} a_{11} & a_{12} & a_{13} \\ b_{21} + c_{21} & b_{22} + c_{22} & b_{23} + c_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix}$$

    The property states that:

    $$\det(\mathbf{A}) = \begin{vmatrix} a_{11} & a_{12} & a_{13} \\ b_{21} & b_{22} & b_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix} + \begin{vmatrix} a_{11} & a_{12} & a_{13} \\ c_{21} & c_{22} & c_{23} \\ a_{31} & a_{32} & a_{33} \end{vmatrix}$$

    This holds true for any row or any column.

  - quick thing, $|A| = |P||L||U|$ (if $A = BC, |A| = |B||C|$)
    - This is also why RREF works, and you end up with the 3 matrices PLU, where:
    - $|P| = \pm 1$ depending on the number of row swaps were performed,
    - $|L| = 1$ because this only involves adding multiples of one row to another, which won't change the determinant
    - $|U| = |A|$.
      - also conveniently because this is an upper triangular matrix, the determinant is just the product of the diagonal elements.
      - DO NOT CONFUSE WITH CANONICAL FORM. The diagonal can have multiples.
    - For GJE when you get the canonical form of the matrix, you will get:
      - the canonical matrix's determinant will be 1 cuz you expect the pivots to be 1
        - if the matrix was singular then your determinant will be 0, and you have a 0 row.
        -also that means the squished matrix from $EA=R$ where R is the canonical solution, E will just be A's left-inverse, and if its a square, it will have a determinant = $\frac{1}{|A|}$.

- Transpose stuff
  - product rule: $(AB)^T = B^TA^T$
  - summing thing: $(A+B)^T = A^T+B^T$
  - scaling thing: $(sA)^T = s\space A^T$

- inverses

- orthonormal matrices
  - the transpose is the same as its inverse, $A^{-1} = A^T$. Shortcut.
  - often seen for GSP after you normalized your columns.

- Invertible matrices
  - MUST BE A SQUARE or else they can only have a left or right inverse
    - how to tell, the inverse part is either on the left or right of the original matrix to get the identity matirix
      - only applicable for full ranked rectangle matrices
      - tldr, you need to format it such that I take the shape of a small square identity matrix
      - $A_{left}^{-1}A=I$ is for tall matrices
      - $AA_{right}^{-1}=I$ is for wide matrices
  - are non-singular
  - have non-zero determinant
  - create non-zero area when treating their columns as vectors
  - IF NOT FULL RANK, DET = 0.

- Projection and projection matrices
  - plane equation is $ax + by + cz = d$
    - this span is a plane, so it means you need 2 linearly independent vectors to make it as your basis
    - that also means the basis has rank 2
    - that also means your P matrix also has rank 2
  - determinant of P is always either 0 or 1
    - either its rank deficient, meaning it is signular
      - IF NOT FULL RANK, DET = 0
      - Else, DET = |I| = 1
        - cuz it has as many L.I. columns as the containing space, no change will result from projecting it onto this space, so it effetively has the same effect as the identity matrix (since it also gets normalized by the scaling factor  $(a^Ta)$ )
  - if you're projecting onto an entire containing space of $\mathbb{R}^{n}$, just use $I_n$.

  - SYMMETRIC Inverse refers to P, which by all technicality is a symmetic matrix, has a proper inverse
    - NOT ALWAYS THE CASE.
    - P is not invertible unless $P=I$ although $P^2 = P$.
      - just because it is idempotent (multiplying the matrix by itself it doesn't change it) DOESNT MEAN IT CAN BE INVERTED.
      - it also just so happens that the matrix will be full-ranked if its invertible, so that means you can just use your identity matrix to represent it.
      -

- So long as your matrix represents

- Eigenvalues and Eigenvectors
  - AM and GM are terms relating to a specific EIGENVALUE.
    - Algebraic multiplicity -- how many times a value shows up as a root in the characteristic polynomial
    - Geometric Multiplicity -- after subbing in an eigenvalue into $(A-\lambda I)v=0$, refers to the number of $v$s you get.

- Diagonalization
  - you need n distinct eigenvectors -- n = the dim of your matrix -- to do diagonalization.
  - always check based on how many free variables you have.
  - if your AM is the rank of the matrix, odds are its not likely your matrix has enough GM.

- Special matrices
  - Symmetric matrices &#8594; original = transpose (A = A^T)
    - are square matrices
    - apparently B is symmetric if $B = A + A^T$
    - also always has real eigenvalues
      - positive definite, so if one eigenvalue is positive, all are positive
    - also always has a full set of orthogonal eigenvectors
    - also its diagonalizable, and you can do A = QNQ^T
    - just because 2 matrices are symmetric, doesn't mean their multiplication is commutative ie $AB \neq BA$ even if A and B are symmetric.
  - skew-symmetric &#8594; original = - transpose (A = -A^T)
    - are square matrices too
    - apparently skew symmetric if $B = A + A^T-D
  - invertible matrices
    - have non-zero determinant
  - triangular ( L for lower, U for upper )
    - product of diagonal is the determinant
  - Gram matrix (A^TA or A^AT)
    - A^TA for when the columns are the span
      - but in most cases, refer to this as the correct def since usually we talk about the tall matrix case, like with linear regression.
    - AA^T for when the rows are the span
    - both are symmetric.
  - Projection Matrix
    - Idempotent: P^2 = P, but that doesn't mean its invertible.
    - eigenvalues of P are either 0 or 1.
    - I-P is considered the complementary projection space
    - Trace(P) = Rank(P)
    - remember formula, $P = aa^T (a^Ta)^{-1}$
      - and for an entire matrix, $P = A(A^TA)^{-1}A^T$
        - to project b onto A's column space,multiply both sides by the transpose to get $A^TAx = A^Tb$
          - approximate solution $\hat{x} = (A^TA)^{-1}A^Tb$
          - projected vector is $\hat{b} = A\hat{x} = (A^TA)^{-1}A^Tb$

  - orthonormal matrices
    - each column is length 1
    - each column is orthogonal to the rest, so dot product is 0
    - can be represented as a sum of rank-one P matrices, scaled by corresponding eigenvalues.

---

## Processes that they'll test

- Finding eigenvalues for a matrix

  - from <span style="color:lightcoral">$Av = \lambda v$ &#8594; $Av - \lambda v=0$ &#8594; $Av - (\lambda I)v=0$ &#8594; since ($A-\lambda I$)'s columns are linearly independent and the equation = 0, that means the determinant = 0 </span> , do $|A - \lambda I |= 0$
  - calculate the determinant in terms of $\lambda$ then find roots
  - sub roots into $A-\lambda I = 0$ then do RREF
  - get the special solution, thats your eigenvector.

- Handling Free variables in REF / RREF
  - sub some dummy name for the free variables $ie \space x_3 = t$
  - write all other defined variables in terms of the free variables
  - you can write all in 1 vector from here, then factor out these dummy names.

> [!tip] Example RREF with 2 free variables

$$
[A|b] \xrightarrow{RREF} \begin{bmatrix}
1&0&3&-1&-3\\
0&1&2&-1&-2\\
0&0&0&0&0\\
\end{bmatrix}
$$

1. we can see that there are only 2 pivots and 4 variables, w x y z.
2. back-sub in y and z, in our complete solution it'll just be there.
3. after back substitution we get:

$$
w + 3y -z = -3 - (1)
x + 2y -z = -2 - (2)

\\\space\\
... \text{some simplifications later}...
\\\space\\

w = -3 -3y + z
x = -2 - 2y + z

$$

4. So our final complete solution looks like:

$$\bold{x} = \begin{pmatrix}
-3 -3y + z\\
-2 - 2y + z\\
y\\
z\\
\end{pmatrix} = \begin{pmatrix}
-3 -3y + z\\-2 - 2y + z\\0 + 1y + 0z\\0 + 0y + 1z\\\end{pmatrix}
\\\space\\
=   \begin{pmatrix}-3\\-2\\0\\0\\\end{pmatrix}
+ y \begin{pmatrix}-3\\-2\\1\\0\\\end{pmatrix}
+ z \begin{pmatrix} 1\\ 1\\0\\1\\\end{pmatrix}
$$

- the part without free variables is the particular solution, the part with the free variables are the special solution.

- How to do PLU decomposition / Gaussian elimination
  - remember row picture, where rows of C are made from the rows of A as a linear combination of the components from each row from B
  - start with an identity matrix row for each row operation
  - so if no change to that row:
    - no change to the E row
  - if one row minus another
    - set that row to + a coefficient of that row
  - if its just two rows swapped like with permutations (only do during P matrix)
  -

  - remember proof:
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

- Doing GSP
  - Its just:
  $$
    \text{nth column vector of orthonormal basis, }u_n:
    \\\space\\
    \text{if n = 1}
    \\\space\\

    u_1 = V_1
    \\\space\\
    \text{else:}
    \\\space\\
    u_n = V_n - \frac{V_n\cdot u_1}{u_1\cdot u_1}u_1 - \frac{V_n\cdot u_2}{u_2\cdot u_2}u_2 -... - \frac{V_n\cdot u_{n-1}}{u_{n-1}\cdot u_{n-1}}u_{n-1}
    \\\space\\
    u_k = V_k - \sum^{k-1}_{i=1} \frac{\braket{V_k,u_i}}{|u_i|^2}u_i
    \\\space\\
    = V_k - \sum^{k-1}_{i=1} \frac{V_k\cdot u_i}{u_i \cdot u_i}u_i
  $$
  - THEN remember to nromalize each column.
