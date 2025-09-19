# Random Js Tips

## DOM stuff

- you can right click elements > click "break on..." > click "attribute modifications"
    - that forces your code to stop right when an attribute is being modified, and sends you straight to your "source" panel.
    - other kinds of changes will also apply.

### `console.<thing>`, where thing is

- log &#8212; for printing content in the DOM
    - accepts the format of `console.log(<string_template_with_%S>,<str_to_interpolate>)`, where in the first string, you can add `%s` and subsequent strings will be subbed in. (even if it isn't with the backticks approved delimiter.)
    - adding `%c`to the start of some text, then having the second arg be some style attributes ie `font-size:50px;`, the text will render.
    - printing the variable with a querySelector object picked up (ie. `p = document.querySelector('p)` returns the actual element picked up, or an array of selected elements)

- warn &#8212; just highlights the one argument you pass in as a warning alert.

- error &#8212; same as console.warn but renders as an error alert.

- info &#8212;  same as console.warn but renders as an info alert.

- assert &#8212; has params (statement, flag_str) some logic statement (ie. `1===1`), that if false, will raise an error named "Assertion" with the phrase `failed: <flag_str>`.

- clear &#8212; clears out the DOM log (analogous to ctrl+L with your terminal)

- dir &#8212; gives a full set of all the attributes that the element could have.

- group and groupEnd &#8212; use it to group statements, and add a label to that group.

- count &#8212; just provides a counter with the number of times a string was printed in the format of `input_string: n`

- time and timeEnd &#8212; start and ends a timer

- table &#8212; displays array-like objects in a table.

---

## Importing packages... or require???

- require is native to Node.js, and you basically use it for your backend.
- import is technically more resource-efficient since it lets you decide what parts of a package to import as opposed to the entire thing.
    - also it is an asynchronous process while `require` is a synchronous one so there will be improvements to latency.

- [Just read this, the comments are pretty good.](https://stackoverflow.com/questions/46677752/the-difference-between-requirex-and-import-x)

## Sources

- [Wes Bos | Chrome dev tool tricks](https://youtu.be/xkzDaKwinA8?si=yzvkN1Ea_cw4XBzo)
