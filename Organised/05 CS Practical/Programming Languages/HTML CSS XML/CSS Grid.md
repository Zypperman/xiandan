# CSS Grid layouts

Made after flexbox, typically used for static layout templates.

## initlaizing a Grid layouts

- just add `display:grid;` in your container.
- Pre-set templates are available. (ie app layout)

### table behaviour

- create columns with `grid-template-columns`. Space-separating values sets the width of each column of your table (ie the value `33% 33% 33%` sets 3 tables sized proportionately to the grid container's size, [docs here](https://developer.mozilla.org/en-US/docs/Web/CSS/grid-template-columns).)
    - same applies for `grid-template-rows`.
    - `minmax(<min_val>,<max_val>)` also exists as a possible value to set the minimum and maximum sizes each container can take on along the column/row.
    - new unit known as `fr` can be used to proportion your items (ie. `1fr 2fr 4fr`), works like flexbox, and is easier than defining percentages.
    - the absolute size attributes like `height` and `width` can be set as percentages to indicate how much of the browser window they occupy.
    - `repeat (n_elems, size_unit)` also can be used to define n rows or columns of x size at one go.

### Defining the gaps in a row

`grid-row-gap` defines the spaces between your rows. Conversely the same for columns with `grid-column-gap`.

## Arranging content

- `justify-content`, `justify-items` etc work here as well.
- `align-content` exists here to organise along the x axis.

### deciding the span of objects

- use `grid-column-start` and `grid-column-end` to mark where your rows should span.
- to span the entire row, have it set to n+1 where n is the number of columns (because css treats the left edge as 1 and the right edge as n+1).
    - same effect but different axis can be done with `grid-row-start` and `grid-row-end`.

Its also possible to just declare them with shorthand syntax:

- `grid-row: <start_handle> / <end_handle>;`
- `grid-column: <start_handle> / <end_handle>;`

Grid area can also be defined together under ``grid-area: <start_row_handle> / <start_col_handle> / <end_row_handle> / <end_col_handle>;``

## Grid Template areas

Make a template with `grid-template-areas`.

- set up the container like a table with unique names in the order you need them.
    - ie. with

        ```css
        grid-template-areas:
        "a b ."
        "a c d";
        ```

        This layout shows a 2x3 table, where the first 2x1 cell is referenced with the name 'a'.

    - each single string is a row, and each space-separated name is a column.
    - names are used to identify the relevant cells, and are initalized here (they don't originally need to refer to anything).
- after the template is made, assign each element to a container name:

    ```css
    #header{
        grid-area:a;
    }
    ```

    that means the element `<div id='header'>` will be recognised as the grid area with the section name 'a'.

## Sources

- [Learndev | Learn CSS Grid Layouts the Easy Way](https://youtu.be/eHaZlFcGl6k?si=etRvzfTAHb6bV-09)
