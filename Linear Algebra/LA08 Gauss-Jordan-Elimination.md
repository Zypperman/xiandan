# Gauss-Jordan elimination

Refer back to LA05, where we solved equations by turning them into ones that can be back-substituted.
Now instead of just the usual EROs, back-substitution is also included as an ERO with its own elementary matrix.

This inclusion makes Gauss-Jordan elimination.

So just do the EROs until you end up with a strictly diagonal matrix, which usually looks like:

- making all the pivots equal to 1
- subtracting the lower rows from top rows to make all elements above the main diagonal 0
- you're left with an identity matrix in the coefficient part of your augmented matrix and some constants, ie:

$$
\begin{bmatrix}
1&0&0&|&a\\
0&1&0&|&b\\
1&0&1&|&c\\
\end{bmatrix}
$$

Example case after getting U:

$$
U =
\begin{bmatrix}
1&1&|&5\\
0&-2&|&-4\\
\end{bmatrix}

\underrightarrow{r_2\leftarrow -\frac{1}{2}r_2}

\begin{bmatrix}
1&1&|&5\\
0&1&|&2\\
\end{bmatrix} \\
\space\\
U =
\begin{bmatrix}
1&1&|&5\\
0&1&|&2\\
\end{bmatrix}

\underrightarrow{r_1\leftarrow r_1-r_2}

\begin{bmatrix}
1&0&|&3\\
0&1&|&2\\
\end{bmatrix} \\
$$

the elemental matrices to get here are:

$$
E_1 = \begin{bmatrix}
    1&0\\
    0&-0.5
\end{bmatrix},
E_1^{-1} = \begin{bmatrix}
    1&0\\
    0&-2
\end{bmatrix},
$$
$$
E_2 = \begin{bmatrix}
    1&-1\\
    0&1
\end{bmatrix},
E_1^{-1} = \begin{bmatrix}
    1&1\\
    0&1
\end{bmatrix},
$$

The Augmented matrix just looks like:

$$
U = [A|b] = [I|b]
= \begin{bmatrix}
1&0&|&3\\
0&1&|&2\\
\end{bmatrix}\\
\implies\\
Ax=b\\
\begin{bmatrix}
1&0\\
0&1
\end{bmatrix}
\begin{bmatrix}
x\\y
\end{bmatrix}
=
\begin{bmatrix}
2\\3
\end{bmatrix}

$$

## Terminology: REF vs RREF

- REF (row echelon form) is just the upper triangular matrix you get after doing gaussian elimination:
    $$
    \begin{bmatrix}
        a&b&c&|&d\\
        0&e&f&|&g\\
        0&0&h&|&j
    \end{bmatrix}
    $$

  - This form has 0s at the bottom of the matrix
  - pivots are just the first elements touching each row of 0s in the staircase
  - REF is actually not unique, there's many ways to get here (makes sense because you can have multiple linear systems virtually do the same thing to get the solution, usually the difference arises when you swap rows before starting)
    - really depends on the operations you do here.
****
- but only after doing the jordan part (the full process is termed "Gaussian Jordan"), then we get the reduced row echelon form.
    $$
    \begin{bmatrix}
        1&0&0&|&d\\
        0&1&0&|&g\\
        0&0&1&|&j
    \end{bmatrix}
    $$
  - All pivots are now scaled properly so no further manipulation required
  - each pivot column only has 1 entry, termed the "unit pivot"
  - RREF is unique, and is often also termed "the canonical form".

$$

[A|b] \space \underrightarrow{\text{RREF}}
\begin{bmatrix}
1 & 0 & 0 & | & 1 \\
0 & 1 & 0 & | & 2 \\
0 & 0 & 1 & | & 3
\end{bmatrix}
\Rightarrow
\begin{bmatrix}
1 & 0 & 0 \\
0 & 1 & 0 \\
0 & 0 & 1
\end{bmatrix}
\begin{bmatrix}
x \\
y \\
z
\end{bmatrix}
=
\begin{bmatrix}
1 \\
2 \\
3
\end{bmatrix}

$$