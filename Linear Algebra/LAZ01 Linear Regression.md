# LA Application 01: Linear Regression

Prerequisite: LA015 Projection II. It basically explains a lot of what we cover here.

---

## Context

We have a set of 5 data points collected over 2 input variables, $x$ and $x_2$, that gave us a response variable y:

  |  $x_1$  |  $x_2$  |  y  |
  | --- | --- | --- |
  |  2  |  1  |  9.7  |
  |  5  |  3  |  28.2  |
  |  1.5  |  0.5  |  6.6  |
  |  8 |  2.5  |  3.2  |
  |  4  |  4  |  28.5  |

The actual equation here is $3x_1+4x_2 = y$, but we've introduced some noise to make it more realistic.

## Transforming our equation

Assuming the data is linear and the error among all data points, $\epsilon$, follow a gaussian distribution (error referring to how we quantify it in terms of euclidean distance between the prediction and our actual response variable), we can say that it follows an equation:

$$
ax_1 + bx_2 + cx_0 + \epsilon = y
\\\space\\
error = ||y - \hat{y}|| = \sqrt{y^2 - \hat{y}^2}
$$

Actually, its possible to ignore some of the observations to get a model which has a better fit and smaller error. However, its not recommended since all data is significant, hence ideally want the model to be able to account for all data observed.

![removing the first point with the highest error will give us a better model, but ultimately have a lot of predicting power since it will be extremely wrong for observations that look like the first point.](https://www.researchgate.net/publication/381857634/figure/fig1/AS:11431281257626828@1719839742106/Linear-regression-model.png)

In this case, we can remove the first data-point which is furthest from the model to improve our accuracy, but it doesn't make sense to do so since that means it will not be able to predict instances that are similar to the leftmost point.

Ultimately, we should find some values of a and b to fit all the observations we've seen.

### Idea: Turn this equation into a matrix equation

Instead of thinking of it in the statistics way:

*"I need to find <span style="color:skyblue">model coefficients</span> that give me as little error as possible when i sub in the <span style="color:darkseagreen">input variables</span> to get a <span style="color:lightcoral">response variable</span>"*

$$
\text{find a,b,c where}
\\\space\\
ax_1 + bx_2 + c +\epsilon = y
\\\space\\
\text{and } \epsilon \text{ is a minimum.}
\\\space\\
\text{by focussing on }x_1 \text{ and } x_2 \text{ to get a,b and c}.
$$

And we just focus on finding equations revolving around x_1, x_2 and y to get our coefficients in terms of those values, and our line fit is calculated as the R-value;

Think of it as:

*"I need to find <span style="color:skyblue">values</span> that can fit the all my observations as <span style="color:darkorchid">linear equations</span> with my <span style="color:skyblue">observations as coefficients</span> to get my <span style="color:lightcoral">response value</span>*"

 I treat each observation as its own equation:

$$
\text{i.e. for each row of our data:}
\\\space\\
r_1 \rightarrow a(2) + b(1) + c + \epsilon = 9.7
\\\space\\
r_2 \rightarrow a(5) + b(3) + c + \epsilon = 28.2
$$

and with n rows, I can look at it like a matrix equation:

$$
\begin{bmatrix}
2&1&1\\
5&3&1\\
...&...&...\\
...&...&...\\
...&...&...\\
\end{bmatrix}
\begin{bmatrix}
a\\
b\\
c
\end{bmatrix} =
\begin{bmatrix}
9.7\\
28.2\\
...\\
...\\
...
\end{bmatrix}
$$

That fits the form Ax = y Where:

- $A \in \mathbb{R}^{m \times n}$ with m observations and n variables in its equation
- $x \in \mathbb{R}^{n}$ with n variables that we need to fit, representing the coefficients of our model
- $y \in \mathbb{R}^{m}$ where we have m responses we need to match.

and so all we need to do is find a unique solution for x.

> [!caution] Why don't we add in epsilon to A
>
> - its cuz we cannot assume it to be linear.
> - it follows a non-linear trend, so putting it with our linear data will mess up the equation.
> - plus, its values are all unknown and its just something we acknowledge as imprecision due to our instruments and overall experimental set-up.

---

However, Ax=b is usually inconsistent.

- you'll probably get a full ranked matrix but a row of 0s
- you'll most likely have a non-zero b, thus giving you an inconsistent equation.
- in terms of the 4 spaces, you realise that b is basically just not in A's column space.

Hence, let us just approximate a solution using $A\hat{x} = \hat{b}$, which we can get by multiplying $A^T$ to the left of both sides:

$$
A^TA\hat{x} = A^Tb
\\\space\\
\therefore \hat{x} = (A^TA)^{-1}A^Tb
$$

<span style="color:Lime">
Hence, this gives us the best approximate coefficients for the model:

$$

\hat{x} = \begin{bmatrix}
  \hat{a}\\
  \hat{b}\\
  \hat{c}\\
\end{bmatrix}
\\\space\\
\text{where}
\\\space\\
ax_1 + bx_2 + cx_0 + \epsilon = y
$$
</span>

However, continuing on this, we still want to find what our predictions are with these coefficients. We also ideally shouldn't use $\hat{x}$
because of the error from rounding off (or literally from type conversion) so lets just straight up find $\hat{b}$ by subbing in $\hat{x}$ into $A\hat{x}=\hat{b}$:

$$
A\hat{x} = \hat{b}
\\\space\\
\therefore A(A^TA)^{-1}A^Tb = \hat{b}
$$

And if we want to calculate the error for each measurement, we can just do $e = b - \hat{b}$ and take its magnitude to get $R^2$.

### Back to the system of equations view

- recall the POV of linear systems when Ax=b is inconsistent:

  ![image of inconsistent equations](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/3_equations_-1.JPG/250px-3_equations_-1.JPG)

- initially we guessed that the best approximate solution for this set of equations will just be a unique point in the center of the triangle bound by the 3 lines.

- now we can literally just do $\hat{x} = (A^TA)^-1A^Tb$ to get this answer.
  - centroid of this shape here actually just the mean of the point coordinates along each axis.

## Clarifying terminology

Given $Ax=b$ into $X\beta=y$:

- for matrix X representing your data ($\mathbb{R}^{m \times (n+1)}$)
  - the rows are observations, ie the properties recorded for 1 instance
  - the columns are features, ie the specific property we are recording for 1 instance.

  - overall it is also termed the "design matrix"
    - it measures independent variables
    - has n+1 columns, for n features / independent variables + 1 bias term (which is basically 1 col of 1s)
    - we have m observations.

- $\beta$ is the coefficient vector, $\mathbb{R}^{n+1}$
  - containing all the coefficients of our model.
  - best possible values are $\hat{\beta} =(XX^T)^{-1}X^Ty$.
  - once we have this, we basically have our ideal model which gives us the least error possible.
  - hence, we can use its coefficients to infer any possible values of x.
    - given a new observation of n+1 values as a vector x, we can just do:
      $$
        \hat{y} = ax_1+bx_2+c(1)
        \\\space\\
        = x \cdot \hat{\beta} = \hat{\beta} \cdot x = \hat{\beta}\space^T x
        \\\space\\
        = \begin{bmatrix}
          \hat{a}&
          \hat{b}&
          \hat{c}
        \end{bmatrix}
        \begin{bmatrix}
          p\\
          q\\
          1
        \end{bmatrix}
      $$

      where p and q are all actual values from the observation x corresponding to $x_1$ and $x_2$ and we're subbing them in, and the last term is just to factor in the bias term and is by default set to 1.

      This gives us the predicted value of our model, y.

- y is the vector of measured response / dependent variables, $\mathbb{R}^{m}$
  - best version of $\beta$ gives us $\hat{y}$.

## TLDR, this is the faster way of doing Linear regression
