# Matrix Rank in Depth

- recall that rank = number of pivots after converting a matrix to REF form.
  - full rows of 0s do not have pivots
    - this only happens if 1 row is a multiple of another row.
  - so if you REF and get a matrix that has a row of 0s, it is rank-deficient.
- Another perspective is that <span style="color:cyan">rank refers to the number of linearly independent rows in a matrix</span>.
- Also applies to columns, so we refer to it as:
  - row-rank: number of LI rows
  - column-rank: number of LI columns.
  - Both ultimately are provable to be one and the same rank.

> [!tip] Random connection to Data science
>
> Data matrices (a matrix representing all your data) often is seen to basically be a few columns with a lot of rows, and be rectangular.  
> Their rank can only be as big as the number of columns they have.

## Rank Mechanics

For any 2 matrices of the same size:

- rank(A+B) $\leq$ Rank(A) + Rank(B)
  - also you can see a rank r matrix as a sum of r rank-one matrices.

> [!tip] Random connection to Computer storage
> If you have a data matrix and know its rank is 1
>
> - That means it only has 1 linearly independent row, all other rows are multiples of it
> - That means to store its data, you can compress it to instead of storing all 100x100 = 10k pieces of data, you just need to store 1 row and 99 scalars, reducing the size of your data by 98%.
> - Even then, if your rank is a small number, you can still save a lot of space storing only the scalars of the excess rows.

- rank($A^TA$) =  rank($AA^T$) = rank(A) = rank(A^T).
  - note that A^TA is the gram matrix (and for data matrices, is also known as the covariance matrix).

- Only the null matrix has rank 0.
  - an interpretation of this is that for a set of basis vectors, it depends on all of them with coefficients 0 to get itself. Nothing in it is independent.
  - technically, a null vector is perpendicular to any vector by definition, since its dot product is always 0.
  - treating the matrix as a set of rows and with set theory, rank is the cardinality of the set of linearly independent rows in a matrix. With the null matrix, it only has 1 null covector / null row, which is the same as saying it has no members (since it doesn't contribute to the count / size of the set).

- rank(AB) $\leq$ rank(A)rank(B)
  - also if B is a full ranked matrix, rank(AB) = rank(A)
  - cuz of the column picture of multiplication.

- Wide matrices usually have infinite solutions, tall matrices usually have too many equations.

- Matrices can be rank-deficient by n-r (smaller side of rows/cols - current rank)


