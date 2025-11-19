# ICA2 Practice Mistakes

## Extas-2

Qn 4:

- Find null space by doing Ax = 0 and finding x
  - sub blank values for non-pivot rows for the complete solution
- null space is for the input space
- left null space is for the output space.
- row space, you can just take pivot rows of rref(A).

Qn5:

- projection matrix, remember the scalar factor is $\frac{1}{a^Ta}$

Qn6:

- Basis of a null space:
  - find RREF( [A|0] )
  - back substitute to get your equations
  - you get 1 basis vector for each free var. associated basis vector for each variable is found by setting the corresponding one to 1, and the rest to 0.

Qn8:

- Gimmick Qn
- realise that the null space is the orthogonal complement of the row space in the input space, so just find a complete solution and solve for free variables
- same deal for the col space

## Solving for basis of a null space

- get RREF of [A | 0]
- get equations
- write out Ax, and the components of x
- note that components with no pivot for their column is a free variable
- for each basis vector corresponding to each free variable, sub the free variable itself = 1, the rest = 0
