# Vectors and matrices

## Vectors

- In the context of physics and for visualisation, fundamentally defined to have 2 properties:
  - magnitude
  - direction

Vectors (solely in math context) are an ordered list of numbers.

- typically represented as columns. This representation is commonly referred to as a "column vector".
  - An astraction of this is that we interpret it as a column matrix of size 2x1.

> [!note] Terminology clarification
> Components and elements are interchangeable terms to mean the numbers in the ordered list.

### Linearity in vectors (repeated from LA01)

for a vector to be considered linear, we need to check that homogenity and additivity are maintaned (aka scaling and addition rule), so:

- $s\bold{x} = \begin{bmatrix}sx \\ sy\end{bmatrix}$
- $\bold{x} + \bold{x'} = \begin{bmatrix}x+x' \\ y+y'\end{bmatrix}$

### Vector element properties

- can be part of the group of numbers $\mathbb{C,R,Q,Z}$
  - representing the set of complex, real,rational and integer numbers respectively. The size of each set is descending (integers is the smallest)
  - certain operations will upgrade a vector to span over a larger set.
    - ie. a vector spanning over the field of integers can be multiplied by a fraction to now span over the field of rational numbers.

## Vector operations

### Closed operations

- means that the input is a vector, and an output is a vector.
  - formally, any operations performed on elements in a set will result in another member of the set if it is closed.

### Scalar multiplication ($s\bold{x} = \begin{pmatrix}sa\\sb\end{pmatrix}$)

- Where you multiply a vector by a scalar value.
  - Closed operation, because the resulting math object is still in the same set as the input.
    - "The set of vectors is closed under scalar multiplication"
  - multiply the scalar value element-wise.
  - Graphically, they do not change the euclidian direction of the vector.
  - the resultant vector is considered <u>collinear</u> with the original vector. \*\*
    - inaccurate to say direction will never change by scaling because scaling by a negative number forces flips the direction.
    - - coordinate space = space for considering vectors graphically
  - Note, all scalars multiplications must exist in the same set as the components of the vector (ie if vector has elements v where $v \in \mathbb{R}$ then the scalar multiplication can only be done with numbers in $\mathbb{R}$.)
    - zero/null vectors are also still valid vectors that are scaled by scalar value of 0.

### Vector addition ($\bold{x+y} = \begin{pmatrix} a_x\\b_x\end{pmatrix} +\begin{pmatrix}a_y\\b_y\end{pmatrix} = \begin{pmatrix} a_x+a_y\\b_x+b_y\end{pmatrix}$)

- closed operation. Add two vectors by adding element-wise.
  - vectors can only be added if they have the same number of dimensions.
  - commutative, so it doesn't matter which vector comes first in the addition
  - additive inverse &#8212; literally just scaling a vector by -1.
    - should give you the origin / null vector if you add the additive inverse of a vector to itself.
  - another way to visualise is "tip-to-tail" where you just connect the input vectors from tip to tail to get the final vector. (but this is a physics trick, not advisable to apply here)

$$
\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix}

+ (-1)\begin{pmatrix}
1 \\
2 \\
3
\end{pmatrix} =
\begin{pmatrix}
1-1 \\
2-2 \\
3-3
\end{pmatrix}
=
 \begin{pmatrix}
0 \\
0 \\
0
\end{pmatrix}
$$

### Order of operations

- try to resolve scalars with scalar multiplication before doing vector addition.
  - doing both at the same time is known as a linear combination.
    - also conidered a closed operation.

The set of 2D vectors is also considered an infinite set, and any vector can be represented by a linear combination of 2 other vectors.

### Spooky shit: promoting vectors to higher fields

- by right, you aren't mathematically allowed to mix vectors from different fields (recall $\mathbb{C} \subset \mathbb{R} \subset \mathbb{Q} \subset \mathbb{Z}$)
- However, you can by CS ideas "promote" your vector by representing it in that space (ie an integer-fielding vector's components can be represented as only having a real part, and we can operate from there).
- <span style="color:red">Do not do in exam.</span> same field interactions only for tests.

## Linear independence

- when a linear combination of 2 given vectors will give you all possible 2D vectors. (and can span the vector space they exist in)
  - one instance of linear dependence is if of the 2 vectors you use, one of them is the scalar multiple of another.
    - graphically, they exist on the same line so they can also only produce vectors that lie on the same line.
    - algebraically, it means any resultant vector of this linear combination, is literally also a scalar multiple of one of the input vectors.
    - <https://medium.com/swlh/how-to-understand-linear-independence-linear-algebra-8bab1d918509>

### Identifying linearly independent vectors

- Vectors are linearly dependent if:
  - one vector can be represented as a scaled version of the other &#8594; both vectors point the same direction &#8594; cannot represent vectors with other directions
  - one vector is just a linear combination of the other involved vectors, ie:
    $$
    \begin{pmatrix}
    1 \\
    1 \\
    \end{pmatrix},\begin{pmatrix}
    3 \\
    1 \\
    \end{pmatrix},\begin{pmatrix}
    5 \\
    3 \\
    \end{pmatrix}

    \text{ are linearly dependent cuz }

    (2)\begin{pmatrix}
    1 \\
    1 \\
    \end{pmatrix} + \begin{pmatrix}
    3 \\
    1 \\
    \end{pmatrix} = \begin{pmatrix}
    5 \\
    3 \\
    \end{pmatrix}
    $$

- example of linearly independent vectors is a set of basis vectors.
  - ie for 2d you can represent all vectors in that space with 2 vectors, 4 vectors min for 4D, n linearly independent vectors for n dimensions. (one for each dimension)
    - The set of n vectors is represented as $\mathbb{R}_n$. (ie for 2D its &#8594; $\mathbb{R}_2$)

### Linear dependence proof format

#### Formal test

$$\text{Let } x_1 \text{and } x_2 \text{be 2 vectors, and } s_1x_1+s_2x_2 = 0 \text{ be a linear combination of } x_1 \text{and } x_2. \\

\text{If we can find some non-zero value for }s_1 \text{and } s_2 \\ \text{ such that their linear combination results in a null vector, }\\
\text{Then } x_1 \text{and } x_2 \text{ are linearly dependent.}
$$
$$
\text{if }y = s_1\bold{x}_1 + s_2\bold{x}_2 = 0 \implies s_1=s_2=0,\\
 \text{then } x_1 \text{ and } x_2 \text{are linearly independent.}
$$

Conversely, for linearly independent vectors, all scalar values involved must be 0 for $s_1x_1+s2_x2=0$ to be true.

- sorta like how they cannot interfere with each other.
- logically speaking this checks whether your vectors lie in the same line, since if they do then you can only represent vectors on that line, and the check condition is to see if you can "delete" one vector by setting the other vector to a non-zero value.

---

#### Proof progression

ie prove that the following set of vectors is linearly independent.

$$
\gamma_1a,\gamma_2b,\gamma_3c
$$

1. assume they arent Linearly Independent
2. quote equation from the formal test with assumption (so $\gamma_1a+\gamma_2b+\gamma_3c=0$)
3. manipulate the equation to prove scalars or vectors don't work
    - either equate all scalars to 0 or say vectors have same direction
    - ie. (so $\gamma_1=\gamma_2=\gamma_3=0$)
4. format it back into known equation (ie an eqn where confirm that $\gamma_n$ equals 0 or something)
5. say assumption is wrong therefore new set is independent.

---

#### Tips for sanity checking proofs

- For 2D, you only need 2, so if given more, theyre useless, and <u>have</u> to be linear combinations.
  - in 2D ($\mathbb{R}_2$), every vector can be expressed as a linear combination of 2 linearly independent vectors.
  - that means if you're asked to do more and unless the given set of vectors are all scaled versions of each other, the set if vectors are definitely not linearly independent.

## Vector Operations II

### Vector Dot product / inner product / scalar product ($\bold{x_1}\cdot\bold{x_2} = \sum^n_{i=1}({x_{i1} \space x_{i2}}), \bold{x_1},\bold{x_2} \in \mathbb{R}^n$)

- between two vectors, multiply each component together and sum to get a scalar.

- not a closed operation since the resultant math object is not a vector.

- signifies how close in direction (spatially) they are, and is used to calculate document similarity (by embedding information about documents into them. See TF-IDF.)

- dot product is also distributive, meaning the dot product of v1 to v2, is the same as doing a dot product of v2 with the vectors used to make a linear combination resulting in v1.
  $$\text{given } z = av+bu,\\ z\cdot w = a(v\cdot w) + b(v \cdot w)  $$

#### Alternative interpretation of a dot product: Projection ($\bold{x_1}\cdot \bold{x_2} = \left|\left|x_1\right|\right|\left|\left|x_2\right|\right|cos\theta$)

![projection](https://o.quizlet.com/eKrelTlQbK5riqoWvRXjig.png)

- you can think of $a \cdot b$ as "to make the vector b in a linear combination with the unit vector of a, what should i scale it to"
  $$\left|\left|x_2\right|\right|cos\theta = \hat{x_1}\cdot \bold{x_2}$$
- In the diagram, we are projecting b onto a.
- the projection of $x_2$ in the direction of $x_1$ is a scalar value equal to $\left|\left|x_2\right|\right|cos\theta$.
  - also if the vectors are perpendicular, then their dot product should be 0 (because the angle between them is $90^ \circ$ and $\cos90^\circ = 0$)

### Norm of a vector ($\left|\left|x\right|\right| = \sqrt{x^2_1+x^2_2+...+x^2_n}$)

- the squares of the elements of x, summed up and squared in total.
- magnitude of the vector actually can be obtained by square-rooting the dot-product of itself (ie given $v$ as a vector, $\left|\left| v\right|\right| = \sqrt{v\cdot v} = \sqrt{\sum({\text{v's components}})^2}$).
- scaling a vector will cause its norm to scale by the same amount.
  $$\left|\left|sx\right|\right| = \left|s\right|\sqrt{x^2_1+x^2_2+...+x^2_n} = \left|s\right|\left|\left|x\right|\right|$$

### p-norm

- The above formula is for the euclidean norm, which is just p-norm where p = 2.
- The general definition of the p-norm IS
  $$\left|\left|x\right|\right|_p = \sqrt[p]{\sum^m_{i=1}\left|x_i\right|^p}$$

  - take every element, raise it to a p power, sum it all then root it by p.

- when p = 1, its called the Manhattan / City-block / Taxicab Norm
  - literally summing the magnitude of all your values.
  - lore is that city blocks are squares on the grid and you cant pass through them, so to get from one end of a vector to another you need to go along the lines. This is technically the shortest distance without crossing any squares in the euclidean grid.
- when p = $\infty$, its known as the max-norm.
  - its significant because it gives you the maximum value that x can adopt.

#### $\infty$-norm proof

- when p = $\infty$, we need to keep in mind $\max(x_i) =  x_m$
- we can then factor out $\left|x_m\right|^p \sum{\frac{\left|x_i\right|^p}{\left|x_m\right|^p}}$, and because we wrapped the whole thing in a square root of p, we can just straight up factor it out to get:
  $$ \left|\left|x\right|\right|_\infty = \left|x_m\right| \sqrt[p]{\sum \left|\frac{x_i}{x_m}\right|^p}$$
- the stuff inside the sum actually tends to 1 as p tends to infinity, and even $sqrt[p]{q}=1$ as p tends to $\infty$ so we end up with:
  $$ \left|\left|x\right|\right|_\infty = \left|x_m\right|$$

### Unit vectors ($\hat{\bold{x}} = \frac{\bold{x}}{\left|\left|\bold{x}\right|\right|}$)

Unit vector / normalized vector &#8212; a vector with magnitude 1 and in the same direction of the vector.

## Span and Vector space

Span &#8212; a set of all vectors that result from a linear combination of 2 known vectors.

- can refer to the entire space, i.e. with basis vectors like $\begin{pmatrix}1 \\0\end{pmatrix},\begin{pmatrix}0 \\1\end{pmatrix}$
- informally you can refer to it as the set of "possible vectors that you can make with a set of 2 vectors"
- if the two vectors are linearly independent they can span the entire space.
  - so if you have 2 vectors $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix},\begin{pmatrix}0 \\1 \\ 0\end{pmatrix}$, the span is only the x-y plane.
  - the span if you only have a vector of $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix}$ will be just the x axis (or whatever component is involved.)

Vector space &#8212; the set of all possible vectors that can exist in a set of dimensions.

- for n dimensions it is $\mathbb{R}^n$.
- the null vector / zero vector is considered a part of all vector spaces because it just represents the origin.

Spans can be the same set as a vector space, or a subset of it.

- here we discuss without caring about linear independence.
  - ie. span of $\begin{pmatrix}1 \\0\end{pmatrix},\begin{pmatrix}0 \\1\end{pmatrix}$ is equal to the vector space $\mathbb{R}^2$
  - however, the span of $\begin{pmatrix}1 \\1\end{pmatrix},\begin{pmatrix}2 \\2\end{pmatrix}$, they are linearly dependent so they cannot be used to represent the entire vector space. They can only represent a subspace of vector space $\mathbb{R}^2$.
- **The Dimension of a subspace = the number of linearly independent vectors in said subspace.**
  - However, note that you write it that (given the example of $\begin{pmatrix}1 \\0 \\ 0\end{pmatrix},\begin{pmatrix}0 \\0 \\ 1\end{pmatrix}$) the span of these two vectors is the xz plane in $\mathbb{R}^3$ and it has 2 dimensions.
  > [!caution]
  > IT IS NOT THE SAME AS $\mathbb{R}^2$.  
  > $\mathbb{R}^2$ is not a subset of $\mathbb{R}^3$.
  > you just say it as it is. Even if your span only has dimensions in X and Y plane, its not the same.
