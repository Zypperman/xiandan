# Examples of solving linear systems

Solve:

$$
x +y = 5 - (1) \\
x - y = 1 - (2) \\
$$

1. Convert into the eqation with the form of Ax=b:

$$

\begin{pmatrix}
    1 & 1\\
    1 & -1
\end{pmatrix}x =
\begin{pmatrix}
    5 \\
    1
\end{pmatrix}
$$

2. Convert the equation into Row Echelon form :

$$
\begin{pmatrix}
    1 & 1 & | & 5\\
    1 & -1 & | & 1\\
\end{pmatrix}
$$

3. do row operations like scaling, or 1 row + the other

$$
r1 \gets r1 + r2 \\
\space \\
\begin{pmatrix}
    2 & 0 & | & 6\\
    1 & -1 & | & 1\\
\end{pmatrix}\\
\space \\

r1 \gets 0.5(r1) \\
\space \\
\begin{pmatrix}
    1 & 0 & | & 3\\
    1 & -1 & | & 1\\
\end{pmatrix}\\
\space \\

r2 \gets r2-r1 \\
\space \\
\begin{pmatrix}
    1 & 0 & | & 2\\
    0 & -1 & | & -2\\
\end{pmatrix}\\
\space \\

r2 \gets -(r2) \\
\space \\
\begin{pmatrix}
    1 & 0 & | & 2\\
    0 & 1 & | & 2\\
\end{pmatrix}\\
\space \\

\therefore x =3, y = 2
$$

---

