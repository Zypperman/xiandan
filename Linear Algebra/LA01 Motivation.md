# Motivation for Linear Algebra

## Uses and applications

- Ultimately, LA is just a better and syntactic way of presenting information.
- Data is often presented as a huge matrix, so LA can help develop methods to make sense of it.
  - Linear Regression's equation from statistics can be reduced into an even simpler vector equation using LA
  - Even Google's primary mechanism relies on SVDs, which to compute, deals with eigenvectors and eigenvalues, which are core concepts in LA.
- Also has contextual relevance in areas like ML AI and various other theories to simplify the presentation and method of computations involved, ie Group Theory and Graph theory.

### Cool examples

- Google's PageRank algorithm
  - basically treating the entire network of pages as a directed graph, and calculating the eigenvectors for specific pages with the traffic as coefficients.
- Primer for tensors in quantum mechanics and understanding the hilbert space (an infinite-dimensioned space where all the states your quantum systems can exist in)
- Rotation matrices with special relativity (ie the gravity net thing)
- Electrical engineering with Kirchov's laws, for predicting the level of current at each point in a wire
- Signal manipulation with fourier, laplace and fast fourier Transformations to decompose them into equations that are simpler to understand
- control system theory

### Defining Mathematical objects

Expressions &#8212; any combination of variables.

- whatever you can put on the right side of a function.
- ie. x, sinx, $ax^2+bx+c$
- Even matrix equations count, ie. $\bold{Ax}$
  - also random tip, bolded and italicised variables mean that theyre LA related, ie theyre containers of matrices or vectors.

Functions &#8212; expressions that are defined with a name

- ie. $f(x) = ax$
- Also, it must also fit the criteria of being <u>single-valued</u>
  - every x-value must map to only 1 y value along the acceptable domain of values
  - ie. $f(x)=\sqrt{x}$ is technically not a function because although it is a one to one function, it is not defined for any input values that are less than 0 (so if $Domain_x = \mathbb{R}^+$ )
  - <span style="color:red"> NOTE: functions in this context span over a domain of all real numbers</span>
    - so $f: \mathbb{R} \mapsto \mathbb{R}, x \in \mathbb{R}$
    - "f is a function that maps any number in the set of real numbers, R, to the same set of real numbers R,"

Equations &#8212; when you set two expressions to be equal to each other, or just an assignment

- Between expressions (ie $ax = 0$)
  - Important premise: expression 1 is equal to expression 2, as a statement of truth. This may not always be the case, its just an assumption (see equations with no solution / infinite solutions)
  - typical form is $equation = constant$.
- Between a function name and an expression (ie. f(x) = x)
  - just assignment.

Transformation &#8212; a mapping of one mathematical entity (ie a number/vector/matrix) to another entity.

- A more abstract way of looking at functions.
  - ie. $y = f(x)$, x and y are real numbers, but f(x) is the black box itself.
- in LA, the terms mapping, function and transformation are synonymous
- Once again, make sure that all transformations are also single-valued (since in general most of them are formatted as functions ie. $y = \sin^{-1}(x)$ cuz it doesnt extend beyond a domain of 1 and -1)

## Linearity

- A way to classify objects in math. (Linear or Non-linear)
  - math objects referring to things like Expressions / Functions / Variables / Transformations / Mappings

### <span style="color:cyan">Conditions for Linearity (in expressions) [IMPORTANT]</span>

There are 2 conditions for an expression to be linear:

1. Homogenity &#8212; scaling the input will scale the output by the same amount.
2. Additivity &#8212; sum of inputs should produce sum of outputs.

#### 1. Homogenity

Scaling the input of an expression scales the whole expression by the same factor.

$$f(sx) = sf(x), \forall s, x \in \mathbb{R}$$

Tldr, just some scalar value applied to the input x, can be factored out such that its the same as applying the scaled value on the entire expression.

Proof format:

- Proof if True:
  $$
  \text{Proof if True:} \\
  \text{let } f(x) = 5x \\
  f(2x) = 5(2x) \\
  = 2(5x) \\
  = 2f(x) \\

  \therefore f(sx) = s \cdot f(x) \implies H. \\
    \text{f(x) is homogeneous.}

  \\
  $$
- Proof if False:
    $$
    \text{Proof if False:} \\
    \text{let } f(x) = x^2 \\
    f(2x) = (2x)^2 \\
    = 4x^2 \\
    = 4f(x) \neq 2f(x) \\

    \therefore f(sx) \neq s \cdot f(x) \\
    \text{f(x) is not homogeneous.}

    $$

##### Proof Tips / properties

- check if $f(0x) = 0$. Its just an easy way to test by intuition if something is not homogeneous. <span style="color:red">However, proving this does not mean that the equation is conversely homogeneous. Sub in non-zero values like 2.</span> To avoid confusion:

  - To test if something is homogeneous, use a non-zero value.
  - To test if something is not homogeneous, use zero first, then use other values to contradict each side. Once a value is disproven, the expression is non-linear.

- apparently y=mx+c is not linear, because $f(0) = c$.
- $0f(x)$ should $=0$
- negative input ie. $f(-x)$ should change the sign of the output ($-f(x)$)
- scaling input also scales the output ($f(sx) = sf(x)$)
- sum of inputs is equal to the sum of outputs ($f(x+x')=f(x)+f(x')$)
- if it goes through the origin, thats a good indication that it could be linear.
- check if any implied knowledge is present ie. $\sqrt(x)$ is implied that x is a positive real value

- $f(x) = ||x||$ where x is a vector is also not linear, because scaling it by a negative number can't give you a negative output (ie if your vector values are flipped from (3,4) to (-3,-4) the output of its magnitude as a function cannot change to a negative value so its not linear).
- all odd roots are functions, but not all even functions are functions.

#### 2. Additivity

Adding two variables as an input has the same effect as adding two functions with each subbed into the variable.

$$f(x + x') = f(x) + f(x'), \forall x, x' \in \mathbb{R}$$

"The output of the expression / function for the sum of two inputs is the same as the sum of the corresponding outputs."

Proof format:

$$
\text{let } f(x) = 5x \\
f(x + x') = 5(x + x') \\
= 5(x) + 5(x') \\
= f(x) + f(x') \\

\therefore f(x+x') = f(x) + f(x') \\
\text{f(x) is homogeneous.}

$$

### Linearity in Functions

- So long as the expression is linear, the function name assigned on the other side will also be considered linear.

## Why is $y=mx+c$ not linear?

Because:

1. By testing definitions, we see that:
    $$ f(sx) = m(sx) + c$$
    it cannot be turned into a form that fits $f(sx) = s(fx)$
    $$f(0) = m(0) + c = c$$
    it can't even give us $f(0x) = 0 \cdot f(x) = 0$

    so by default, it fails the homogenity test and its not linear.

2. By heuristic, its representation is misleading.

    When we represent $f(x)=mx+c$ as expression = constant:

    $$ y = mx + c \rightarrow -mx + y = c \rightarrow f(x,y)=c$$

    This is not an expression that is linear given the two variables.

## Abstracting the definition for linearity (to 2 variables)

Now for an expression involving more than 1 variable to be linear, we rewrite the two criteria:

1. Homogenity &#8212; <u>scaling all input variables scales the output by the same factor</u>

    $$f(sx,sy) = s \cdot f(x,y) \space \forall s,x,y \in \mathbb{R}$$

2. Additivity &#8212; <u>adding all input variables has the same effect as adding all their outputs</u>

    $$f(x+x',y+y') = f(x,y) + f(x', y') \space \forall s,x,y \in \mathbb{R}$$

Applying this test to $y=mx+c$:

1. Homogenity test is satisfied:
    $$
    f(sx,sy) = -m(sx) + (sy) \\
    = s\space(-mx + y) \\
    = s\cdot f(x,y)
    $$
2. Additivity is also satisfied:

    $$
    f(x+x',y+y') = -m(x+x') + (y+y') \\
    = (-mx+y) + (-mx'+y') \\
    = f(x,y) + f(x',y')
    $$

**That makes y=mx+c linear in 2 dimensions, not 1 dimension.** So it matters how many dimensions you are claiming that an expression is linear in.

- y = mx + c is not linear in 1 variable, but it is in 2.
- only ax is linear in 1 var.
- by right, the only linear equation in 1 var should ax=b or $f(x) = a$.

### Linearity in vectors

vectors are just ordered lists of numbers, but for a vector to be considered linear, we need to check that homogenity and additivity are maintaned (aka scaling and addition rule), so:

- Homogenity &#8212; $s\bold{x} = \begin{bmatrix}sx \\ sy\end{bmatrix}$
  - scaling the input vector scales the output of the function by the same amount
  $$ f(sx) = sf(x) \forall s \in \mathbb{R},x \in \mathbb{R}^n $$
- Additivity &#8212; $\bold{x} + \bold{x'} = \begin{bmatrix}x+x' \\ y+y'\end{bmatrix}$
  - adding two input vectors is the same as the sum of the outputs
    $$ f(x+x')=f(x) + f(x') \forall x,x' \in \mathbb{R}^n $$

n in $\mathbb{R}^n$ can refer to any number of dimensions.

## Writing y = mx + c in vector form

- refer to LA02 for matrix rules first, but basically from $-mx + y = c$ :

$$
\begin{bmatrix}
-m & 1

\end{bmatrix}

\begin{bmatrix}
x \\ y

\end{bmatrix} = [-mx+y] \\

-mx+y = c \equiv ax = b
$$

where we take a row of numbers aka the covector, and do a dot product with the vector of our variables, to obtain a constant.

- note, $\equiv$ means "equivalent in representation to" or "congruent to", depending on the context.

You can also stack multiple equations into a single vector form by stacking the coefficient covectors (ie for 3 equations):

$$
\begin{bmatrix}
-m1 & a1\\
-m2 & a2\\
-m3 & a3\\

\end{bmatrix}

\begin{bmatrix}
x \\ y

\end{bmatrix} =

\begin{bmatrix}
-m1 (x) + a1(y)\\
-m2 (x) + a2(y)\\
-m3 (x) + a3(y)\\\end{bmatrix} \\

ax = b \\

\text{where } a \in \mathbb{R}^{3\times2}, x \in \mathbb{R}^2 \text{ and } b \in \mathbb{R}^3
$$

- note here for presentation, if you're stacking equations, indicate so by defining the size of a and b as (num of eqns x num of vector dims) and (number of constants) respectively.

- It can also be said that A is a transformation / mapping for vectors in $\mathbb{R}^2$ to $\mathbb{R}^3$.
  - formally, the notation describing "A as a mapping of vectors from x to b" is $A \in \mathbb{R}^{m\times n}, A : \mathbb{R}^m \mapsto \mathbb{R}^n$ but only if A represents a system of linear equations.

>[!note]
> Ultimately, matrices represent a linear transformation between vector spaces, where number of rows matches the input vector, and the number of columns matches the output vector.
