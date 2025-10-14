# Rotation Matrices

- After trying out a change of basis with some orthgonal matrices, you realise that the norm of the vectors don't change.

- That means you can
  - rotate / reflect input vectors
  - swap components (just like in permutation matrices)
    - cuz the matrices that did that are symmetric, since $Q^T = Q^{-1}$

- Hence, from this we get a subclass of basis matrices called rotation matrices.

## Rotation Matrix properties

### Use Cases

- rotating points in space has these properties:
  - doesn't affect their magnitude or distance
  - even the distance between 2 vectors doesn't change.
  - this alludes that there is another dimension!
    - predicted by Einstein
    - defined as the [Minkowski Space](https://en.wikipedia.org/wiki/Minkowski_space), which has its own LA rules.
    - invariance also exists there known as the [Lorentz Invariance](https://physics.stackexchange.com/questions/110547/lorentz-invariance) &#8212; a quantity that is unchanged with a lorentz transformation
      - tldr, its representative of "the space-time distance between two events" &#8212; so not just distance, but time as well.
        - that quantity of both space and time stays constant.
        - its also opens the floodgates for ideas like special relativity, time dillation, twin paradoxes and space contractions.
        - all come about due to this invariance.
    - since its a rotation, its technically an orthogonal matrix responsible for the rotating motion
  - However, all these ideas on special relativity assume that it is linear.
    - There are conjectures that space-time is not linear, but all our math is based on the assumption that it is so thats why all our calculations and experiments can't disprove it.

- Quantum computing
  - cuz its technically a logical operator to rotate your qubit by a set number of degrees.
  - its also important for putting your qubit into a superposition. (see the [hadamard gate](https://www.quantum-inspire.com/kbase/hadamard/), which basically just rotates your 2 basis states of $\ket{0}$ and $\ket{1}$ into an unknowable state, by rotating your qubits 90º around the Y-axis, then 180º around the X-axis.)

---

### Basics

- for a vector space of $\mathbb{R}^{n}$, we need (n-1) angles to represent a rotation.
  - for $\mathbb{R}^{2}$ we only need 1 matrix for an angle $\theta$, and we call it $Q_{\theta}$
    - traditionally, it rotates clockwise.
  - The matrix inverse of this rotation is called $Q_{-\theta}$
    - basically rotates in the opposite direction

- for a vector space of $\mathbb{R}^{3}$, we need to define 3 angles for a rotation matrix, termed:
  - Pitch (Y axis)
  - Yaw (Z Axis)
  - Roll (X axis)

<span style="color:cyan">For a vector space of $\mathbb{R}^{n}$, we need $\frac{(n)(n-1)}{2}$ matrices.</span>

- for 2 axes, we need 1
- for 3 axes, we need 3
- for 4 axes, we need 6

  This is just because each planar rotation requires that we move from 1 axes to another new axes, so for 3, its x&#8594;y, x&#8594;z, then we're left with y&#8594;z.  
  
  For 4 dims, its w &#8594; (x,y,z) which is 3 rotations, adding the ones from 3 dims, thats a total of 6 rotation matrices, and so on.

  Basically, we derive this from the fundamental definition of a planar rotation, being rotating from 1 axes to another (ie the base case of literally me rotating my vector from the x axis to the y axis by $90\degree$.F)

### Defining the rotation matrix

![rotation matrix reference](https://i.sstatic.net/5vaf9.png)
![another image for reference](https://scipython.com/media/images/rotation-matrix-figure.width-700.png)

1. define that what we want to do, is that given the 2 vectors that represent our orthonormal basis (ie $I_2$), and rotate clockwise by $\theta$.
2. to rotate these vectors, we shift them along the unit circle first.
3. for the unit vector representing the x axis, we note that:

    - moving leftwards by the angle amount changes the x component from 1 to $\cos\theta$  
    (or basically decreases it from 1)
    - moving upwards by the angle amount changes the y component from 0 to $\sin\theta$  
    (and basically increases it from 0)
  
    So we just note that to update the basis vector for the x direction, we rotate the matrix by doing
    $$x = \begin{bmatrix}\cos\theta\\\sin\theta \end{bmatrix}$$

4. Same deal with the y basis vector, where:

    - moving leftwards by the angle amount changes the x component from 0 to $\cos\theta$  
    (or basically decreases it from 1)
    - moving upwards by the angle amount changes the y component from 1 to $- \sin\theta$  
    (and basically increases it in the opp direction from 0)
  
    So we just note that to update the basis vector for the x direction, we rotate the matrix by doing
    $$y = \begin{bmatrix}-\sin\theta\\\cos\theta \end{bmatrix}$$

5. Hence, we can surmise that with the original orthonormal basis vectors of
    $$I_2 = \begin{bmatrix}1&0\\0&1\end{bmatrix}$$
    to rotate our vectors **anti-clockwise**, we apply the rotation matrix:
    $$Q_\theta = \begin{bmatrix}\cos\theta&-\sin\theta\\\sin\theta&\cos\theta\end{bmatrix}$$

and to rotate the other direction (clockwise), sub $\theta = -\theta$

  $$Q_{-\theta} = \begin{bmatrix}\cos(-\theta)&-\sin(-\theta)\\\sin(-\theta)&\cos(-\theta)\end{bmatrix}
  \\\space\\
  = \begin{bmatrix}\cos(\theta)&\sin(\theta)\\-\sin(\theta)&\cos(\theta)\end{bmatrix}
  \\\space\\
  = Q_\theta^{-1}
  \\\space\\
  = Q_\theta^{T}
  $$

  so funny thing, the inverse is the transpose.

> [!note] Quick recap: inverse of a 2x2 matrix
>
> 1. swap the diagonal elements (a,d)
> 2. flip the sign of the non-diagonal ones (b, c)
> 3. divide by determinant.
>
> in this case, it matches perfectly cuz since $\frac{1}{|Q_\theta|} =\frac{1}{\cos^2\theta + \sin^2\theta}=1$
