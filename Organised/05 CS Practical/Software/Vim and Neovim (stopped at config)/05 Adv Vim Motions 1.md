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

- 