# Advanced Vim Motions 1

## Jumping around text-object commands

Example task: replace `new_fn`'s type with `bar`

``` js

function foo (blaz: {oddly:"long" | "type", but:"hey" | "this" "is" | number}) {
    // ...
}

function new_fn (bar: number) {
    // ...
}
```

The usual way:

- jump to `{` with `f{`
- enter visual mode for highlighting with `v`
- jump to `|` with `f}`
- yank it with `y`
- go down to new_fn with `/new_fn`
- jump to number by doing `fn` &#8594; spam `;`
- highlight `number` with `vw`
- paste with `p`

The cool way:

- if your cursor is already between a set of brackets / braces, and you wanna select it, do `vi{` or `va{` to highlight everything
    - `vi{` - selects everything inside the braces
    - `va{` - selects everything INCLUDING the braces
    - and even faster if we just wanna copy, do `ya{` or `yi{`

- to quickly highlight a word your cursor is on its `viw`
    - bread and butter command, always selects the word.
    - basically your double-click.
    - `vi shift w` is to select all text until whitespaces
    - and then end with a paste.
    - however this gets rid of your paste content from your buffer, so just use whatever primagen did.

> [!note]
> any command with position selecting `iw` or `i shift w` is amazing, general command that reduces cognitive load.

