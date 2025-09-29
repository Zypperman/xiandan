# Orthogonality and Projections

## Orthogonality

- Basically, whether given 2 vectors, are they perpendicular to one another
  - If we're talking about orthogonal Bases, then the span of one is orthogonal to the span of the other if they are parallel.
  - In a more mathematical idea, the dot product of two vectors is 0 if they are orthogonal.
    - that is because we are saying that there is no way to project one vector onto the other, except if the vector is a null vector.
- Orthogonal = opposite of parallel vectors.

### Relations to dot product

- Euclidean Norm calculation
  - Typically, $||x|| = \sqrt{x^2_1+x^2_2 + ... + x^2_n} = \sqrt{x^Tx} = \sqrt{x\cdot x}$
  - Also, $||sx|| =|s| \sqrt{x^2_1+x^2_2 + ... + x^2_n} =|s| \space||x||$
    - this notion of vector magnitude / size was baked together with its scalar value.
- p-norm calculation
  - $||x||_p = (x^p_1+x^p_2+...+x^p_n)^\frac{1}{p}$
  - same scaling property exists
  - p = 1 &#8594; Manhattan / taxicab distance
  - p = 2 &#8594; Euclidean distance
  - p= $\infty$ &#8594; Max / infinity-norm to see the largest version of that value.

- also in the view that a scalar is a 1x1 matrix:
    $$a\cdot b = (a^Tb)^T = b^Ta$$

### Link to pythagoras

- conveniently if a and b are 2 orthogonal vectors, it can form a right-angled triangle together with a+b.
    -conveniently, using the euclidean norm on all of them gives us the pythagorean theorem:
    $$
    ||a||^2 + ||b||^2 = ||a+b||^2
    \\\space\\
    \text{This can be reduced to:}
    \\\space\\
    ||a||^2 + ||b||^2 = (a^T + b^T)(a+b)
    $$
    However, this is only seen true in 2D cases and is not rigorous. We should use a general vector to prove stuff instead of this, its only in this confined case where this is true.

---

## Projections

- The other way to think of dot products is given:
    $$a \cdot b = a^Tb = ||a||\space||b||\cos\theta
    \\\space\\
    \cos\theta = \frac{a^Tb}{||a|| \space ||b||}
    $$

  Focussing on "a", how much of "b" would I need to make "a".

  ![dot product visualistation](https://www.sciencing.com/sciencing/dot-product-vector-definition-formula-how-to-find-w-diagrams-examples-13720224/6601bde0daaa4a988117d444799e8fa9.png.jpg)

  - basically, scale down b to unit length
  - scale up b by $||a|| \cos \theta$
  - thats how much of b you need to make a.

  Hence thats why its ultimately said as "b projected on a".

### Relevant projection properties

actually, projection is relative. Just be aware of which you're projecting on. Based on our image:

- <span style="color:cyan">a is the "source vector" being manipulated ("the pen")</span>
- <span style="color:red">b is the "destination vector" that we are doing stuff on. ("the canvas")</span>

And, we are projecting <span style="color:cyan">a</span> onto <span style="color:red">b</span>.

In dot product, $a\cdot b$ doesn't mean much, but by speaking convention we are projecting a onto b.

- projection length (of <span style="color:red">b</span> onto <span style="color:cyan">a</span>)
  - basically the length of b as a basis vector of a
  - = $||b||cos\theta = \frac{a^Tb}{||a||}$
  - <span style="color:yellow">= "canvas vector magnitude" $\times \cos \theta$</span>
- projection vector (of <span style="color:red">b</span> onto <span style="color:cyan">a</span>)
  - basically the exact vector after using our "canvas vector" as a basis for our "pen vector" and scaling it.
  - = $a_{2||} = \frac{a}{||a||}x = \frac{a}{||a||}\frac{a^Tb}{||a||} = \frac{aa^T}{a^Ta}b$

    basically, $aa^t$ is a mapping and $a^Ta$ is just the squared magnitude.

    The matrix part can also be seen as a linear combination of $a^T$
    - That means that this matrix has a rank of 1.
  - = "$\frac{\text{mapping of canvas vector}}{\text{squared magnitude of canvas vector}} \space (\text{pen vector})$"

## getting the perpendicular part of the projection

- referring back to our projection vector:
  $$\frac{a}{||a||}\frac{a^Tb}{||a||}b$$

  realise that we can chunk the formula into 2 unit vectors, one of a, one of a-transpose (and we'll call the unit vector q):

  $$\frac{a}{||a||}\frac{a^Tb}{||a||}b = q (q^Tb) = (b^Tq)q$$

  $q^Tb$ gives us a scalar, so we can basically shift it around and realise that we are dealing with a scaled version of the unit vector.

  Anyway, we can just take this vector and do:

  $$\bot \text{vector} = b - (b^Tq)q$$

  That gives us the perpendicular part.

  ![visualising the parallel part](https://mathspace-production-media.mathspace.co/media/upload/images/001_Chapter_Entries/Vectors/vector-proj-1.png)

  kv is our $(b^Tq)q$, and u is our $b$. calculate by subtracting.
  - note: direction of the perpendicular vector is in the same rough direction as b, and definitely away from q.

---

## Why do we care about orthogonalization

### situation requirements

- we have a square, invertible matrix
- we want to use it as a basis matrix
- but each vector is kinda weird, all have diff lenghts

Goal:

- we want columns that are both:
  - unit length
  - orthogonal to each other

    This gives us an orthonormal basis that makes it easier for caclulations.
    why its cool, is because it doesn't affect the norm of your resultant vector.

Solution: The Gram-Schmidt Process

- We can rewrite our basis matrix as QR, 2 matrices
  - Q will be an orthonormal matrix
  - R is just some other matrix
  basically Q can now be used as said orthonormal basis.
  
Use Cases:

- when doing a mass change of bases over multiple iterations, you will need to repeat this change of basis process. But without an orthonormal basis, your vectors might be scaled to very large or small components.
  - basically it lets you make more numerically stable calculations so you don't end up with stack overflow or underflow (since you're doing $||sx|| = |s|\space ||x||$ and if $|s|$ is 1 its nice)

### How to Gram-Schmidt Process (GSP)

- basically, your result should look like a set of vectors that from left to right, its directions appear clockwise.
  - TLDR if you're in a rush, [use this](https://youtu.be/zHbfZWZJTGc?si=2f4T66o9wM2lXFJB).
    - this just turns them into orthogonal vectors, you still need to scale them to length 1.

![visualising GSP](https://www.researchgate.net/publication/298326988/figure/fig3/AS:447095531413507@1483607289896/Gram-Schmidt-orthogonalization-with-two-vectors.png)

1. visualise your basis matrix as n vectors with $\mathbb{R}^{n\times n}$
    $$A = \begin{bmatrix}
        a_1 & a_2 & a_3 & a_4
    \end{bmatrix}$$
    - obviously all column vectors need to be linearly independent, thats a condition of the basis matrix.

2. Normalize $a_1$:
    $$ {q_1} = \frac{a_1}{||a_1||}$$

3. Project the next vector ($a_2$) onto the first vector ($a_1$) to get the parallel part ($a_{2||}$)
    $$ {a_{2||}} = (a^T_2q_1)q_1$$

4. Get the perpendicular part of the second vector, $a_{2\bot}$

    $${a_{2\bot}} = a_2 - (a^T_2q_1)q_1 = = a_2 - a_{2||} = q_2$$

5. Project the 3rd vector $a_3$ onto $q_1$ and $q_2$

    $$a_{3||1} = (a^T_3q_1)q_1
    \\\space\\
    a_{3||2} = (a^T_2q_2)q_2
    $$
6. Get the part of $a_3$ thats perpendicular to the 2 vectors you just found
    $$
    a_{3\bot} = a_3 - \text{parts of a3 parallel to a1 an a2}
    \\\space\\
    = a_3 - \left(  (a^T_3q_1)q1 +(a^T_3q_2)q2  \right)
    $$
7. normalize $a_{3\bot}$ into $q_3$:
    $$q_3 = \frac{a_{3\bot}}{||a_{3\bot}||}$$

8. recursively repeat for the rest of the elements.

    - note for nth vector, step 6 is:
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

    that notation just means inner product, aka dot product.

    - remember that for the kth vector of the orthonormal basis, you will only use $v_k$, not $u_k$.
    - every other u vector found will show up in the calculation of $u_k$.

### Weaving in column picture of matrix multiplication

- now we are basically doing Elementary column operations (ECOs).
  - that means that our operations now appear on the right of the matrix (tjat we will refer to as AX).

> [!note] Recall how column picture works:
> Given AB:
> $$
    \text{given } A \in \mathbb{R}^{m\times 3}, B \in \mathbb{R}^{3\times 2}, AB \in \mathbb{R}^{m \times 2}
    \\\space\\
    A = \begin{bmatrix}
        |&|&|\\
        a_1&a_2&a_3\\
        |&|&|\\
    \end{bmatrix}
    B = \begin{bmatrix}
        c&d\\
        e&f\\
        g&h\\
    \end{bmatrix}
    \\\space\\
    \text{First column of AB}= c(a_1) + e (a_2)+g(a_3)
    \\\space\\
    \text{Second column of AB}= d(a_1) + f(a_2)+h(a_3)$$
>
> - so on so forth.
> - We are interested in figuring out what values of B will help us edit these values of A such that AB = X, which is our new matrix.

Thought process:

1. The GSP is basically like EROs for columns.
    - for RREF:
        $$EA = E_kE_{k-1}...E_2E_1A = U$$
      and to get the LU Decomposition form:
        $$A = E_1^{-1}E_2^{-1}...E_{k-1}^{-1}E_k^{-1}U = LU$$
    - for GSP:
        since the operations are column picture, I need to change B in AB such that:

        $$AX = X_kX_{k-1}...X_2X_1A = Q$$

        where basically X is an upper triangular matrix.
2. first column of X can be edited by doing:
    $$
    \text{given i need to scale it by k to make it unit length 1:}
    \\\space\\
    \text{First column of AB}= k(a_1) + 0(a_2)+0(a_3)
    \\\space\\
    \text{nothing happens in the other column, so all zeros.}
    \\\space\\
    \therefore X = \begin{bmatrix}
        k&|&0&|&0\\
        0&|&1&|&0\\
        0&|&0&|&1\\
    \end{bmatrix}
    $$

3. But this is mentally taxing, so lets just mark $X^{-1} = R$:
    $$
    R = X^{-1} \implies A = QX^{-1} = QR
    \\\space\\
    \therefore R = Q^{-1}A = Q^TA
    $$
    and Q^TA is actually easy to compute once you have Q.
    also its cuz Q is orthonormal, so that means $Q^{-1}=Q^T$
