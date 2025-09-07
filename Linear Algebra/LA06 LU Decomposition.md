# Lower Upper Decomposition (LU Decomp)

## What are Elementary Row Operations (ERO)s, exactly...?

- EROs are typically used for solving linear systems by reducing their row echelon forms, or simplifying the determinants of a matrix.
  - Involve operations like:
    - swapping rows ($r_1 \leftrightarrow r_2$)
    - scaling a row ($r_1 \leftarrow 2r_2$)
    - adding a multiple of a row to another ($r_1 \leftarrow r_1 - 2r_2$)

- But its actually possible to stack all the edits into a single matrix.
  - treat it like a linear combination of a matrix on the right.
  - This is termed the "Elementary Matrix", or the "Elementary operator".
  - Denoted with $E_i$, and applying onto A, we write it as $E_iA$, and as a matrix multiplication.
  - Row by Row, it'll look more like $E_kE_{k-1}...E_2E_1A=U$
    - each E is just a 
