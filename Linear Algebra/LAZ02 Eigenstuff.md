# EigenStuff

Prerequisite: LA14 and LA14A, the 4 Spaces of a matrix

---

## Context

- For A  $\mathbb{R}^{m \times n}$, it implies that $A: \mathbb{R}^{n} \mapsto \mathbb{R}^{m}$
  - taking Ax=b, it maps x to b, where:
    - x has the same number of components as A's columns (n)
    - b has the same number of components as A's rows (m)

  - With different matrix sizes:
    - tall and wide matrices are mapping vectors to different dimensions
    - square matrices just map vector spaces to themselves
      - Although technically its 2 different $\mathbb{R}^{n}$s with slightly different properties.
        - Examples of square matrices include:
          - Permutation matrices, that swap rows or columns in a vector
          - Projection matrices, that give you the closest approximation of a vector given a subspace
          - Shear matrices, that return a vector with 1 element changed proportional to another.
            - TLDR, it "warps" the representation of a vector by taking the basis it is sitting in, and "squashing" it.
        - Rotation matrices, where I just give you the vector rotated by some amount in the same space, but the magnitude is the same
          - (norm invariant)

        Ultimately, all these mappings can be categorized as automorphisms.

### Eigen vectors

- Basically, for a given matrix, there are some vectors that will remain unchanged even after we multiply them to a matrix.
  - Its acceptable for them to change in size, but completely remain unchanged in direction.

$$
Av = \lambda v
\\\space\\
\text{where}
\\\space\\
A \in \mathbb{R}^{m \times n}, v \in \mathbb{R}^{n}, \lambda \in \mathbb{R}, s \neq 0.
$$

- vector $v$ is termed an "eigenvector"
- scalar $\lambda$ is termed our associated eigenvector's "eigenvalue".

### Formal Definition of Eigenvectors and Eigenvalues

$$
\text{For A} \in \mathbb{R}^{\times n}, s \in \mathbb{R}^{n} \text{is an eigenvector with eigenvalue }\lambda \in \mathbb{R}^{n}\text{ if :}
\\\space\\
s \neq 0 \text{ (s is not a zero-vector)}
\\\space\\ and
\\\space\\
As = \lambda s
$$

Given another scalar $r \in \mathbb{R}$, $rs$ will also be an eigenvector with the same eigenvalue $\lambda$.

$$
A(rs) = r(As) = r(\lambda s) = \lambda (rs)
$$

> [!caution] Eigen stuff ranges
>
> - eigenvectors cannot be the 0 vector.
> - but eigenvalues can be 0.
> - s and $\lambda$ may be complex (see rotation matrices)

### Example 1: Permutation matrix

- Given:

$$
A = \begin{bmatrix}0&1\\
1&0\\
\end{bmatrix}
\\\space\\
Av = sv
\\\space\\
\begin{bmatrix}0&1\\
1&0\\
\end{bmatrix}\begin{bmatrix}
x\\
y\\
\end{bmatrix} = \lambda \begin{bmatrix}
y\\
x
\end{bmatrix}
\\\space\\
\therefore \text{by back-substitution,}
\\\space\\
x = \lambda y
\\\space\\
y = \lambda x
\\\space\\
\therefore x = \lambda x

$$

So any values of x and y that fits the above equation can fit this.

- Hence the vector $v = \begin{bmatrix}1\\1\end{bmatrix}$ is an eigenvector, and its associated $\lambda = 1$
- another eigenvector is $v = \begin{bmatrix}1\\-1\end{bmatrix}$, and its associated $\lambda = -1$

### Example 2: Projection Matrix

i.e.2: For a projection matrix $\begin{bmatrix}1&0&0\\0&1&0\\ 0&0&0\\ \end{bmatrix}$, we have 2 quickly inferred eigenvalue-eigenvector pairs:

- $\lambda = 1, s = \begin{bmatrix}
    x\\y\\0
\end{bmatrix}$, for any value of x and y
- $\lambda = 0, s = \begin{bmatrix}
    0\\0\\z
\end{bmatrix}$, for any value of z.

> [!caution] Eigen stuff ranges
>
> - eigenvectors cannot be the 0 vector.
> - but eigenvalues can be 0.

FYI, this is a matrix projecting values to the x-y plane in R3.

### Example 3: Shear matrices

- the example where the entire space gets turned from unit squares to other shapes like parallelograms:
    <br>
    <br>
    <img src="https://15462.courses.cs.cmu.edu/fall2019content/lectures/06_transformations/images/slide_028.jpg" width = 350px>

  - What happens is that given a vector in the containing space $\mathbb{R}^{n}$ with a basis of $I_n$, I take each basis vector, and i modify its zero-components.
  - ie $\begin{bmatrix}1&0\\0&1\end{bmatrix} \rightarrow \begin{bmatrix}1&t\\s&1\end{bmatrix}$
  - so given $v = \begin{bmatrix}
    5\\2
  \end{bmatrix} = 5\begin{bmatrix}
    1\\0
  \end{bmatrix} + 2 \begin{bmatrix}
    0\\1
  \end{bmatrix} = 5\bar{x} + 2\bar{y}$, I cut-and-paste these unit vectors and establish a new basis just like that:

  $$
  \text{new }v = 5\begin{bmatrix}
    1\\s
  \end{bmatrix} + 2 \begin{bmatrix}
    t\\1
  \end{bmatrix} = \begin{bmatrix}
    5+2t\\5s+2
  \end{bmatrix}
  $$

  The Basis is also proportionally transformed and so does the vector space.

  ![shear effect on vector space](https://blog.kakaocdn.net/dn/ddYEfG/btq33aeH6k6/Wf9lZ6Ht3TJvgyLjtCEHq1/img.gif)

  And tldr, this transformation is performed by the shear matrix.

- The proper way to say this is that:

    > "each component of the new matrix is influenced by other components from the original matrix"
  
- Eigenvectors basically remain unchanged despite the shear.

### Example 4: Rotation matrices

ie for a 2d case, $Q_\theta = \begin{bmatrix}\cos\theta&-\sin\theta\\\sin\theta&\cos\theta\\ \end{bmatrix}$

This has no eigenvectors in the real space, you need components in the complex space for eigen-pairs to exist. ($v \in \mathbb{C}^{n}$)

### Sub-Application of Eigen Analysis: Matrix Calculus

- in matrix calculus:
  $$
  \frac{d}{dx}e^{ax} = ae^{ax} \implies e^{ax} \text{ is an eigenvector with eigenvalue a}
  $$
  $$
  \frac{d^2}{dx^2}\sin{x} = -\sin{x} \implies \sin{x} \text{ is an eigenvector with eigenvalue -1}
  $$

## Computing Eigenstuff

### Getting the Eigenvalue (easier)

To get v, we just manipulate its definition:

$$
Av = \lambda v
\\\space\\
Av-\lambda v = 0
\\\space\\
(A - \lambda I)v=0
$$

We do this stem because we can think of the eigenvalue and its eigenvector as:

$$
\lambda v = \lambda v_i \text{ where }v_i \text{ is all of v's components}
\\\space\\
= \lambda (\bar{x}+\bar{y}+\bar{z}+...) +  (v_x\bar{x} + v_y\bar{y} + v_z\bar{z} + ...)
\\\space\\
=\lambda I_n\space s
$$

However, with $(A - \lambda I)v=0$, that means that the matrix $(A - \lambda I)$ multiplied by a non-zero vector gives us a zero vector, aka it has to be singular.

- the columns of $(A-\lambda I)$ are linearly dependent.
- That means the determinant of $(A-\lambda I)$ = 0
- Without s, determinant of this matrix becomes a scalar
- and that means we can sub in A directly and use the determinant formula in terms of 0:
  - for the context of A in $\mathbb{R}^{2\times2}$:
    $$
    det \left( \begin{bmatrix}
    a-\lambda&b-\lambda\\
    c-\lambda&d-\lambda\\
    \end{bmatrix}
    \right) = 0
    \\\space\\
    \therefore (a-\lambda)(d-\lambda) + (c-\lambda)(b-\lambda)=0
    $$

    <span style="color:lime">and from here we just solve for $\lambda$ as a polymonial.</span>

    - This polynomial is termed a "characteristic polynomial" for eigenvalues.
    - Lore: "eigen" means characteristic in german.
    - also every now and then termed the "eigen-polynomial".

### Getting the eigenvector

- sub in the values of $\lambda$ found from your characteristic-polymonial into $(A-\lambda I) = W$
  - we just name this matrix W for simplicity
- after getting the matrix, since $Wv = 0$ just do $RREF\left( \begin{bmatrix}
    W|0
\end{bmatrix}\right)$ to get the components of the eigenvector associated with the eigenvalue.

## Special Cases

- For a square matrix in $\mathbb{R}^{2}$:
  - usually theres 2 eigenvectors, $v_1$ and $v_2$
  - they're usually perpendicular to each other so $v_1 \perp v_2 \implies v_1\cdot v_2 = 0$

> [!note] Cool property of eigenvectors in R2
>
> - All real symmetric matrices have a full set of orthogonal eigenvectors.

- For projection matrices:
    $$
    \mathbf{A} = \begin{bmatrix}
    1 & 0 & 0 \\
    0 & 1 & 0 \\
    0 & 0 & 0
    \end{bmatrix}
    \\\space\\
    |\mathbf{A} - \lambda \mathbf{I}| = \begin{vmatrix}
    1 - \lambda & 0 & 0 \\
    0 & 1 - \lambda & 0 \\
    0 & 0 & -\lambda
    \end{vmatrix} = \lambda(1 - \lambda)^2 = 0
    \\\space\\
    \Rightarrow \lambda = 0, 1, 1
    $$

  - since this polynomial has 3 roots (since its highest degree is 3) + 2 of the roots are the same, the root 1 has an algebraic multiplicity of 2.
    - algebraic multiplicity: how many roots are the same.
  - when $\lambda = 0$:
    - v will be $\begin{bmatrix}
        0\\0\\1
      \end{bmatrix}$
  - **But when $\lambda = 1$**:
    - $w = \begin{bmatrix}
      0&0&0\\
      0&0&0\\
      0&0&-1\\
      \end{bmatrix}, s_2 = \begin{bmatrix}t_1\\t_2\\0\end{bmatrix}$

    - A wide range of vectors can fit this criteria, so lets call it an eigenspace where $t_i$ are scalars for $\lambda=1$.
      - describe it with an orthogonal basis, which you can do by factoring out $t_i$ as consants to get
      $$
      \begin{bmatrix}
      1&0\\
      0&1\\
      0&0\\
      \end{bmatrix}
      $$

    > [!tip] Eigenspace details
    > dimension of an eigenspace = algebraic multiplicity for the given $\lambda$
    > - Algebraic Multiplicity, in this case, = Geometric Multiplicity
    >   - see shear matrices for counterexample

    - Also since we're dealing with real, symmetric matrices, it implies that we will have a full set of orthogonal eigenvectors.

- For shear matrices
  - possible to have A.M. of 2 but only 1 eignvector.
    - cuz its eigenvector space is just a line / 1D, aka its geometric multiplicity (GM) = 1.
    - Hence, A.M. $\neq$ G.M.

- For Rotation matrices (in $\mathbb{R}^{2}$)
  - eigenvalue gives you a complex number usually
    - ie. $\lambda = \pm i, i \notin \mathbb{R} \text{, but} \in \mathbb{C}$
    - Opposite to the real, symmetric case, real, antisymmetric / skew matrices have only imaginary eigenvectors and eigenvalues.

---

## Eigenvalue and Eigenvector Properties

- sum of eigenvalues = Trace / sum of the diagonal elements of your matrix.
    $$
    \
    $$