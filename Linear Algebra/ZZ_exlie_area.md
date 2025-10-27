# exile area


---

TODO: add intuition for least squares minimization

## Least Squares minimization intuition
<!-- This took me so much fucking time wth -->

- Recall that given an inconsistent equation of Ax=b, where we can't find any good x to fit this equation.
  - this is just because b is not in the column space of A, so it makes it impossible to express b as a linear combination of A's columns.

- However, intuitively if b cannot give us a good solution, we can opt to just project b onto the column space of A and use this makeshift b, termed $\hat{b}$, and then just do $RREF(\begin{bmatrix}A|\hat{b}\end{bmatrix})$ to get a unique value for x.
  - so $A\hat{x} = \hat{b}$ would be a valid equation.
  - and we had to project our vector b into subspace of A to get $\hat{b}$, so we inevitably have some error equal to:
  - $\epsilon = b - \hat{b}$
    - and we care more about the length of this vector magnitude of this error, measured by taking its euclidean norm $||\epsilon||$.

### Ok lets reverse engineer from here

![OLS error](https://www.honeybadger.io/images/blog/posts/ruby-linear-regression/leastsquares.png)

With respect to ordinary linear regression, our model is represented by the equation:

$$
y = \sum_{i=0}^n a_ix^i + \epsilon
$$

where:

- we have n linearly independent features, ie:
  - constant 1 is associated with $x^1$ aka m in y = mx+c
  - constant 2 is associated with $x^2$
  - constant 0 is associated with $x^0$ aka its your y-intercept / c
- we have n matching coefficients for each feature
- y is the value we want to prediction
- $\epsilon$ is the irreducible error for our model.
  - we work on the assumption that our predictions will not always be the same as our observation, and that there will always be some error associated with each prediction we make.

we use mean square error from the y vector to quantify our error, which is just the difference between all predictions and their corresponding actual values, squared and averaged:
  
$$
MSE = \frac{1}{n}\space\sum_i^n(y-\hat{y})^2
$$

We also define error in this simple situation primitively as the distance in the y axes between an observation and its prediction by the model, which is just:

$$
\text{For 1 observation:}
\\\space\\
e = y - \hat{y}
\\\space\\
\text{For n observations as a vector:}
\\\space\\
e = b - \hat{b}
$$

if we drop the fraction part of this error function, we realise that we can represent it as a dot product of e with itself:

$$
MSE = \left(\frac{1}{n}\right)\space\sum_i^n(e)^2 = \left(\frac{1}{n}\right)\left(||e||\right)= \left(\frac{1}{n}\right)\left(e\cdot e\right)
\\\space\\
\implies Error = e \cdot e = e^Te
$$

anyway, since
---