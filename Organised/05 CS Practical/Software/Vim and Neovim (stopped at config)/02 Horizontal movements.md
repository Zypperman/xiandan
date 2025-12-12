# Horizontal movements

## Navigation with absolute references

From NORMAL mode you can move your cursor to:

- `0` / `|` - The first character start of the current line
- `$` - The last character of the current line
- `_` / `^` / `shift + 6` - The first non-whitespace character of the current line

These work with commands ie. `d$` means you're yeeting everything from the current cursor position to the last char of the current line.

> [!Important] Implicit vs explicit motions
>
> - [explained here](https://www.reddit.com/r/vim/comments/haq2t9/comment/fv4bahw/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button).
>
> TLDR:, the help description for all these shortcuts phrase it weirdly.
>
> - `0` and `|` are only superficially equivalent: `0` explicitly gets you to the first column of the current line while `|` does it implicitly, because you don't give it a count. Prefer explicit over implicit.
> - `^` and `_` are only superficially equivalent: `^` explicitly gets you to the first printable character of the current line while `_` does it implicitly, because you don't give it a count. Prefer explicit over implicit.

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

## jumping between words (repeated from 01 Basics)

- `w` - next word
- `W` - next word skipping special characters
- `e` - end of next word
    - `ge` - end of previous word
- `b` - beginning of previous word starting from current word

## Fast editing

- `r` to replace the character left of / under your cursor
    - `shift + r` to enter replace mode, continuously replaces with the next character you type
- `c <selection>` - delete whatever's selected and enter insert mode to fix it
    - `shift + C` or `c$` to edit everying till the end of the line
- `p` to paste after cursor from visual mode
    - `P` to paste before cursor
