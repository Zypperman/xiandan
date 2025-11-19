# Vertical Movements

> [!note] Quick recap
>
> - `k` and `j` to jump up and down respectively.
> - chord with `<num><dir>` to go up and down that many lines.
> - chord as `<command><num><dir>` to apply command to all of that selected.

- Paragraph Navigation
    - A paragraph is just a contiguous body of non-whitespace
    - jump up and down between paras with `{` and `}` resepectively
        - `{` always puts you before a paragraph
        - `}` always puts you at the end of a paragraph
        - single presses just bring you to the adjacent one in the direction pressed.
        - sucks because it default skips blocks of text ie entire functions

- Page-style Navigation
    - `Ctrl + u` for moving 1 screen up
    - `Ctrl + d` for moving 1 screen down
    - `zz` to center your cursor to the middle of the page.
        - alternatively write a remap function to automatically always chord zz after any page jump.
    - `Ctrl + f` and `Ctrl + b` apparently does the same thing

- Jump to start and end of file
    - `shift + g` to go to the end of your file.
    - `gg` to go to the start of your file.
        - alternatively, `Ctrl+Home` still works.
        - more often for when you want to edit imports.

- Jump to a specific line number
    - from normal mode, do `:<line_num>`
    - `(` and `)` the same for sentences
    - `^` and `$` the first, last character of line

- Jump to a specific search term
    - `/` to trigger search from normal mode to find a term in the script of your current window
    - `n` goes to the next result, `shift+n` goes backwards.
    - `?` triggers a reverse search, and the navigation buttons flip.
    - If you have a super weird word to search:
        - `*` automtically grabs that term and does a `/`-search
        - `#` does the same but a `?`-search
