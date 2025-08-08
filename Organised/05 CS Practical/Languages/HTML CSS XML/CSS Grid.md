# CSS Grid layouts

Made after flexbox, typically used for static layout templates.

## initlaizing a Grid layouts

- just add `display:grid;` in your container.
- Pre-set templates are available. (ie app layout)

### table behaviour

- create columns with `grid-template-columns`. Space-separating values sets the width of each column of your table (ie the value `33% 33% 33%` sets 3 tables sized proportionately to the grid container's size, [docs here](https://developer.mozilla.org/en-US/docs/Web/CSS/grid-template-columns).)
    - same applies for `grid-template-rows`
    - `minmax(<min_val>,<max_val>)` also exists as a possible value to set the minimum and maximum sizes each container can take on along the column/row.
    - new unit known as `fr` can be used to proportion your items (ie. `1fr 2fr 4fr`), works like flexbox.
    - 

## Sources

- [Learndev | Learn CSS Grid Layouts the Easy Way](https://youtu.be/eHaZlFcGl6k?si=etRvzfTAHb6bV-09)
