# I forgot my notebook Pt 1 (020925)

1. determinant of $A = \begin{bmatrix}
1 & a & a^2 \\
1 & b & b^2 \\
1 & c & c^2
\end{bmatrix}$

- 1st minor = $bc^2-b^2c$
- 2nd minor = $c^2-b^2$
- 3rd minor = $c-b$

- determinant of the whole thing:
    $|A| = 1(bc^2-b^2c) - a(c^2-b^2)+ a^2(c-b) \\
    = bc^2-b^2c - ac^2+ab^2 + ca^2-ba^2 \\
    = bc^2-b^2c - ac^2+ab^2 + ca^2-ba^2$

Option d is:

$$(a − b)(b − c)(c − a)\\
=(ab - b^2-ac+bc)(c-a)\\
=abc + a^2b-b^2c+ab^2-ac^2+a^2c+bc^2-abc \\
= bc^2-b^2c - ac^2+ab^2 + ca^2-ba^2
$$

$\therefore$ Ans is option D.

---

5. Which of the following determinants is equal to |A| for the following A?

a - no, because this screws with the main diagonal.

b - yes, follows the row/col flipping rule

c - yes, beause adding multiples of a row or a column doesn't affect the determinant.

d - are you high

---

If A and B are symmetric matrices, which of the following are symmetric?

a. AB − BA  
b. $A^2B^2$  
c. ABA  
d. ABAB  
e. $A^2 - B^2$  
f. $A^2 + B^2$

Answer:

General solution: just prove that the transpose of the result is the same as itself.

$$Z^T = Z$$

a - false cuz:

$$
LHS = (AB - BA)^T \\
    = (AB)^T - (BA)^T\\
    = B^TA^T - A^TB^T\\
    = BA - AB \\
    = -(AB - BA) \neq RHS
$$

b -

$$
LHS = (A^2B^2)^T \\
    = B^TB^TA^TA^T\\
    = B^TA^T - A^TB^T\\
    = BA - BA
$$

c -

---

1.  
