# Projection II

## Recap

- Gram-Schmidt Process (GSP) &#8212; where you turn your basis into an orthonormal one by just isolating one and slowly working on the rest

Projection fundamentally is finding "how to best represent b in terms of a / in the subspace confined by a"

- by treating a as a subspace with 1 dimension (aka confined as a line)

![projection](https://i.sstatic.net/IxJddNWk.jpg)

basically, given the context of b projecting onto a, we have to talk about b in terms of a.

- we term this as $\hat{b}$.
- it is also what we consider to be the closest vector to b in the subspace of a.
  - "b is too complex for our subspace, this is what we got"
  - "$\hat{b}$ is our best approximation of b in the subspace of a".
- any other vector along a will not be able to represent b in a's subspace as well as $\hat{b}$, because of how we quanify error.

### Error vector between a and b

We quantify error as a vector, being $e = ||b - p||$. The only way to minimise the length of the error, is if e is perpendicular to a's subspace and touches b's arrorhead.

- defined above, basically $e = b - \hat{b} = b - pa$, where:
  - e = error vector
  - b = pen vector
  - a = paper vector
  - p = projection length of b onto a
  - can think of e as if we flipped $\hat{b}$ and drew a vector tip-to-tail.
- the error vector is also supposed to be orthogonal to a, so:
  - $e\cdot a = 0 \implies a^Te = 0 \implies a^T(b - \hat{b})=0$
- and subbing in $\hat{b} = pa$:
  - $a^T(b - pa)=0$

Remember that ultimately, p is a scalar value, and if we manipulate to put p on one side, we see that it basically gives us the projection operator.

Also, if we treat p as $\hat{x}$, we can see that we sorta fit the form Ax=b:

$$
a^T(b - a\hat{x})=0
$$

## Proofs to get to the Projection Matrix

To get $\hat{b}$ from $b \cdot a$:

- see LA12, recall pen and canvas analogy
  - just remember "pen vector draws a dot onto paper vector"
    - pen vector - b, the vector we want to draw with
    - paper vector - a, the subspace we're drawing b on
    - dot product - just how we draw.

- the direction of projection remains the same as a, we just need to know the projection length of b onto a, which is just:

$$
b\cdot a = b^Ta = ||a||\space||b||\space \cos\theta
\\\space\\
\implies \text{projection length p }
 = ||b|| \space \cos\theta = \frac{b^Ta}{||a||}
\\\space\\
\implies \hat{b} = pa = \frac{b^Ta}{||a||}a
\\\space\\
\text{but because the dot product gives a scalar, } a\cdot b = b \cdot a = b^Ta=a^Tb,
\\\space\\
\implies \hat{b} = pa = \frac{a^Tb}{||a||} a = \frac{a^Ta}{a \cdot a}b
$$

basically, by:

1. taking the definition of a projection of b onto the subspace of a and stealin the idea that its just b in a's direction
2. stealing the definition of projection length in terms of a dot product
3. flipping it around so we represent the projection vector in terms of the original vector (aka $\hat{b}$ in terms of b's direction)

<u>We have created a matrix that will project onto b onto a giving us $\hat{b}$</u>.

## The Projection Matrix

basically ignoring the constant $\frac{1}{a\cdot a}$, $aa^T$ gives us a rank-1 matrix:

$$
\text{Given } a = \begin{bmatrix}
    x\\y\\z
\end{bmatrix},
\\\space\\
P = \frac{aa^T}{a \cdot a}
\\\space\\
\\= \frac{1}{x^2 + y^2 + z^2}
\begin{pmatrix}
    x^2 & xy & xz \\
    yx & y^2 & yz \\
    zx & zy & z^2
\end{pmatrix}
$$

ultimately if we RREF it, there will only be 1 pivot.

### Projection matrix properties

- Its symmetric
  - $P^T = P$
  - $(aa^T)^T = (a^T)^T (a)^T = aa^T$
    - see product rule for transposes.

- Projecting a vetor twice is the same as doing it once.
  - semantically, you're projecting a vector onto a plane that's alr on the plane, so doing it twice should give you the same vector.
    - ie $Pb$ is already along $a$'s subspace
  - Effectively, $P^2 = P$.
    - proof:
      $$
      P^2 = \frac{aa^T}{a^Ta} \frac{aa^T}{a^Ta} = \frac{a(a^Ta)a^T}{a^Ta(a^Ta)} = \frac{aa^T}{a^Ta} = P
      $$
  - HOWEVER, P is not idempotent.
    - Primitively,it makes sense that you can put $P^{-1}$ on the left of both sides of the equation $P^2=P$ to give $P=I$.
    - However, note that P is rank deficient so it does not have an inverse.
- P is also basically destroying information about b.
  - to project, means to get rid of any "information" about b that can't fit into the subspace of a.
- input of P also scales with output of P.
  - if b is doubled, $\hat{b}$ will also be doubled.
  - vector a's role in P basically only defines the direction to shift b into.
  - projected magnitude of b into $\hat{b}$ should therefore still be the same.
  - also feeding P with $2a$ also still gives P.

- P is also not invertible / has no inverse
  - P's sole purpose is to get an approximation of b in a's subspace.
  - effectively, it removes information irreversibly, meaning there is no backward mapping after you pass a vector through a projection matrix.
  - also makes sense cuz it basically strips the unnecessary components to represent a vector in its subspace.
  - another way of thinking about it is that there is only 1 way to project b onto a giving us $\hat{b}$, but many other vectors that $\hat{b}$ could have come from.
- P is ultimately still linear.
  - any matrix multiplying a vector is always a linear operation.
  - fundamental property of all matrices is that they are linear ops.
    - to differentiate between permutation and projection matrices, can just do the test for homogenity and addtivity to assert that it is linear.

### 4 space analysis of the Projection Matrix

Given $P^{n\times n}$:

- Column space C(P)
  - space that $\hat{b}$ inhabits is $\mathbb{R}^{n}$
  - dimension is 1 (cuz its a rank-1 matrix)
  - basis is formed by a
    - basically $C(P) = sa$, and it consists of scalar multiples of a.

- Row space $C(P^T)$
  - space that b inhabits is the same, $\mathbb{R}^{n}$
  - dimension is 1 again (same as col space),
  - basis formed by a.

we can treat b as a linear combination of vector a + some other vector in N(P), and effectively we're projecting it into the column space of A. the null space vector part just gets deleted by the permutation matrix, leaving us with $\hat{b}$.

- Null space $N(A)$
  - basically n-1.

> [!tip]
>
> - if you know a matrix is rank 1, then you basically only need to store the linearly independent column and the rest of the row's scalars.

---

## Projections to a subspace

- what if we want to project to a subspace of more than 1 vector???

- 1D case (b projection onto a)
  - your basis is just 1 vector, a
  - projection onto vector a = projecting onto subspace with basis $S = \{sa\}, a \subset \mathbb{R}^{n}$
- r-dimensional case
  - just specify more vectors in your basis (with r linearly independent basis vectors).
    - don't need to be orthogonal or unit length.
  -

### intro to linear regression with LA

- Context is Data science, where each row is a new observation where n features give us 1 output.
  - the matrix can take the form $Ax = b$ where:
    - A are the rows of observations with values over n features
    - x is just the linear regression model's line's features
      - the $\beta$s in $y = mx^1 + cx^0 \implies m\beta_1+c\beta_0 = y$ as the components of x.
      - what we want to find to get the best linear model, and can give us the best results given what we've observed.
    - b is rows of observation

  - this matrix will most likely be inconsistent
    - basically RREF([A|b]) will give us something sus
    - we'll in the best case get a lot of 0s on the A side, but have constants for the associated rows of b, making the equations inconsistent.
    - HOWEVER, ignoring the inconsistent equations is not viable because they are still significant and true observations.
    - TLDR:
      - $b \notin C(A)$
      - $RREF(A) \implies m-n rows \text{ of } o^Tx = b_j \neq 0$ which is inconsistent and therefore wrong.
- Solution: find $\hat{b}$ which is the best approximation of b that is in the column space of C(A).
  - TLDR:
    - find $\hat{b} \in C(A)$
      - by projecting b onto C(A) with $\hat{b} = Pb$
    - then solve for $\hat{x}$ using $A\hat{x}=\hat{b}$

- context example: 2 features with 3 observations in $\mathbb{R}^{3}$

    ![image of projection in linear regression](https://www.researchgate.net/publication/220103928/figure/fig2/AS:349421448515593@1460319973418/Example-of-a-projection-of-a-matrix-3-2-on-the-column-space.png)
  
  - We functionally work with:
    - Q &#8212; as a matrix in $\mathbb{R}^{3 \times 2}$
    - p &#8212; as a column vector of $\mathbb{R}^{3}$
    - x &#8212; as a vector representing the coefficients of our model.
    - And we assume that the columns of Q are linearly indepedndent.

  1. We can think of x as the coefficients of our model, where we can use its components to create linear combinations of Q's columns that will give us p.
  
  2. However, this is likely not possible because p is unlikely to be in the column space of Q, due to the nature of our problem.
      - since we are doing linear regression, we expect that there should be some irreducible error to our observations, hence its extremely unlikely that all our collected observations will coincidentally fall exactly onto our proposed model.
  
  3. However, even if we can't get p, we can get the best approximation of p, termed $\hat{p}$, by projecting p onto the column space of Q.
      - with this, we also accept that there will be an error to our model that is irreducible, which is to be expected.
      - We quantify this error to be $e = p - \hat{p}$, but really we are only concerned about the length of the error vector.
  4. Hence, with $\hat{p}$, we can then calculate the unique solution for an approximation of the coefficients of a model to fit our collected observations, by solving for $Q\hat{x} = \hat{p}$.
  
  5. We perform RREF on the matrix, and hopefully find a full-ranked matrix, and the components of x will then give us the coefficients of the model.
      - basically, the components of $\hat{x}$ will just give us for each row / observation in Q, an approximation in the component $\hat{p}$.
      - x will have 2 components in this example as:
      $$
      x = \begin{bmatrix}
      \beta_1\\
      \beta_2\\
      \end{bmatrix}
      \\\space\\
      \text{such that }
      \\\space\\
      q_{i1}\beta_1 + q_{i2}\beta_2 = \hat{p}_i
      \\\space\\
      \text{for all i}
      $$

      and $\hat{p}_i$ will just be an approximation of what p should have been, based on the observations.

  - Alternatively, instead of step 5 we can just project p onto our basis vectors in Q, then sum them up to get $\hat{p}$. <span style="color:lightcoral">However, this only works if the basis vectors are orthogonal to each other.</span>

---

### Solving for $\hat{x}$ / proving the linear regression formula

With respect to the error vector:

- it is orthogonal to the column space of Q.
- thats enough to say that its in the left null space.
  - $e \perp C(A) , C(A)^\perp = N(A^T) \implies e \in N(A^T)$.
- With that, we can say that:
  - by definition of the left null space:
  - $A^Ty = 0 \implies A^Te=0$
  -
- sub in the definition of e:
  - $e = b - \hat{b} = b - A\hat{x}$
    - from the definition (see image) where $\hat{p} = Q\hat{x}$
    - refers to how the projection is just a linear combination of the basis vectors of Q, our observations aka our column space's basis
  - $A^Te=0 \implies A^T(b - A\hat{x})=0$
- Expand this definition:
  - $A^T(b - A\hat{x})=0 \implies A^Tb - A^TA\hat{x}=0$
  - TLDR, we get $A^Tb = A^TA\hat{x}$.

> [!note] TLDR: How to approximate solutions or linear systems
>
> if Ax=b gives an inconsistent equation, just add a transpose on the left of > both sides of the equation.
>
> $$Ax = b $$
>
> if equation is inconsistent, no solution. But...
>
> $$A^TAx = A^Tb$$
>
> This gives us solutions! (because $A^Tb$ lowkey is just b projected onto A as a subspace.)
>
> - This is also technically termed "least square minimization".
>   - reminiscent of mean squared error, where we do $\sqrt{a_i^2}$ aka the 2-norm.
>     - except here we refer to the error vector, where the deviation
>   - play with it [in this demonstration](https://textbooks.math.gatech.edu/ila/least-squares.html).

But remember our goal is to get the approximate answer $\hat{b}$. So we:

- rearrange to put $\hat{x}$ on one side
  - $\hat{x} = \left( A^TA\right)^{-1}A^Tb$
- remember to sub this into $\hat{b} = A\hat{x}$
  - $\implies \hat{b} = A\hat{x} = A\left( A^TA\right)^{-1}A^Tb$

And this format looks a lot like a projection matrix, but weird.

$$
\text{Linear regression output:}
\\\space\\
\hat{b} = A\hat{x} = A\left( A^TA\right)^{-1}A^Tb
\\\space\\
\text{Projection Matrix:}
\\\space\\
P = \frac{aa^T}{a^Ta} = a(a^Ta)^{-1}a^T
$$

The denominator is a scalar anyway so we can just reorder it wherever we want.

> [!warning] Manoj's Brain Teasers
>
> Question: Why cant i just do :  
> $A^T A \widehat{x} = A^T b \Rightarrow A^T \widehat{b} = A^T b \Rightarrow \widehat{b} = b?$
>
> Answer: you can't drop the A^T part because it only holds true if you can apply $(A^T)^{-1}$ on both sides to eliminate it. It only works if A^T is invertible, which may not always be the case, so its an invalid operation.

## The Gram Matrix

Spoiler, A^TA is the Gram Matrix.

- usually meant for getting the essential features of a tall matrix.

### Gram Matrix Properties

- has the same rank as the original matrix
- square matrix, follows, the number of columns
- symmetric, $(A^TA)^T = A^TA$

## The Projection Matrix for a subspace

- $P = A(A^TA)^{-1}A^T$
- same rules apply as before, it is :
  - idempotent, aka $P^n = P$,
  - not equal to its inverse, aka $P \neq P^{-1}$, only true if the matrix is square and full ranked (aka $P^{-1}$ must exist).
  - it is symmetric, aka $P^T = P$
    - alt proof for symmetry can be that since $Pa = a$
      - also remember that $a^Tb = a^T\hat{b} = a^TPb$
        - both b and $\hat{b}$ have the same projection length
      - that means $a^TP^T = a^T \implies a^Tb = a^TP^Tb = a^TPb$
    Therefore $P = P^T$.
    - alt proof can also literally just be from trying to transpose it, it gives you back the same thing.

- Alt name: hat-matrices (H)
  - because they turn vectors into their hat versions (projected onto a subspace)
- Another alternate projection matrix:
  - technically since our error vector is $e = b - \hat{b}$
  - we can do $e = Ib - Pb = (I-P)b$
  - and thus, we can call this new matrix $P_2 = (I-P)$.
  - This projection operator projects any given into the <span style="color:darkseagreen">left null space, $N(A^T)$</span>.
    - dimension of this subspace is based on rank-nullity theorem, where its just the difference between the number of dimensions of $C(A^T)$ and A. it also happens to be the orthogonal complement of $C(A^T)$.

---
