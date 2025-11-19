# Horizontal movements

## Navigation with absolute references

From NORMAL mode you can move your cursor to:

- `_` - The first non-whitespace character of the current line
- `$` - The last character of the current line
- `0` - The first character start of the current line

These work with commands ie. `d$` means you're yeeting everything from the current cursor position to the last char of the current line.

## Moving to specific characters with "micro-search"

Micro-search is just what I call finding a specific character in a line and jumping to it.

- `f <char>` - "Find", moves cursor to first instance of specified character. cursor sits on top of the character.
- `t <char>` - "Till", moves cursor to <u>right BEFORE</u> the first instance of the specified character (so if you're moving left, )

Once you "have a search term loaded", you can "scroll" through results with:

- `;` - "Next", moves cursor to next instance of specified char, respecting position specified (`f` or `t`)
- `,` - "Previous", moves cursor back.

Also note that this "search result" maintains until `f` / `t` / `F` / `T` is used again, so you can actually move to other lines and press it for to search for that line.

### Backwards Micro-search

- `shift+f <char>` / `shift+t <char>` - micro-search, but in the reverse direction. same behaviour persists, but its abit annoying to use. I'd personally do the above and just press `,` once.

## Combo-ing micro-search with operations

You can treat these like motions and use them with operations to select sections you want to apply them to.

- even applies with the count, where you can do `d2f(` &#8594; delete everything until the second instance of `(` inclusive.

### Entering INSERT Mode II

- `shift+i` - Enters insert mode but your cursor will be at the start of the line
- `shift+a` - Enters insert mode but your cursor will be at the end of the line

#### Working in blocks

- `o` - creates a new line below and enters insert mode on that line
- `shift+o` - creates a new line above and enters insert mode on that line
