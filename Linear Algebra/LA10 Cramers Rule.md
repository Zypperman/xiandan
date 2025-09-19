# Cramer's Rule

- Basically, theres a shortcut to solve equations using determinants, but its quite useless.

For any given system of equations described by Ax=b:

1. First, get the determinant of A.
2. Mark each element of x with a number.
3. For element 1 of x, swap out column 1 of x with vector b's values and calculate the determinant of that matrix.
4. divide by the original determinant, thats your the first element of x.
5. repeat for all elements.

Formula:

$$
x_j = \frac{det(A_j)}{det(A)} = \frac{|A_j|}{|A|}
$$

where j is the element we are calculating in x, and the column of values to replace with b.

## conditions for Cramer's rule

- det(A) $\neq$ 0, cuz your denominator can't be 0.
  - you can't use a singular matrix. you need to have unique solutions or basically have a full-ranked coefficient matrix.

- the coefficient matrix must be:
  - a square matrix
  - a full-ranked matrix

TLDR you need to make sure you are dealing with a system that has unique solutions.

Quite useless, hard to do, also kinda sucks if you have a large coefficient matrix with many variables.

- It is also <u> numerically unstable</u> because you need to compute determinants recursively for large matrices, and the floating point precision errors add up (and the same applies for calculating inverses).

## When Cramer's rule shines

- its just a super niche shortcut where if you see that your coefficient matrix already has b inside it, then you can quickly compute that specific element in x to be 1.
- It also is just used because its cleaner to write for proofs if you need the solution for only 1 element of x.

## Transitioning from Coordinate spaces to vector spaces

- Solving for equations algebraically only comes from the geometrical intuition that we have for solving systems in coordinate space.
  - ie you can treat it as sets of valid vectors, not really that complex, just there to set down the rules
- matrices can also be used to describe vector spaces, and show us what they mean.
  - ie state spaces in puzzle games (traverse a graph in a vector space where each node/vertice is the state of the puzzle, and each connection/edge is a move we make)
