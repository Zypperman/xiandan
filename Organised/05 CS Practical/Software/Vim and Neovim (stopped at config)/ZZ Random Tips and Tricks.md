# Random Neovim and Vim Tips and Tricks

## General Self help ([source](https://vi.stackexchange.com/questions/36435/complete-list-of-all-vim-commands))

Full documentation can be accesseed for [Neovim](https://neo.vimhelp.org/) and [Vim](https://vimhelp.org/) here.

On your text-editor client, full documentation can be accessed at various levels with the `:help` function and a follow-up keyword. Alternatively, the documents for each command have been linked here.

- [`:help index`](https://vimhelp.org/index.txt.html) - pulls up the file with a list of all commands for each mode, with a tag and a short description. The lists are sorted on ASCII value.

- `:put =getcompletion('', 'command')` generates the full list of known commands at runtime (but only for command mode).

---

## Useful stuff (from personal experience)

- `=` - in VISUAL mode, formats your indentation for you
- `/` - in NORMAL mode, triggers a search, confirm with `enter` key

---

## Cursor-centering

`H`, `M` and `L` will move your cursor to the top, middle and bottom of the screen, respectively. Subsequently, you can hit `zz` to center the screen on the line your cursor is on.

`zb` and `zt` moves the screen on bottom and top respectively

---

## More movements

- `{` and `}` will get you to the beginning / end of the next paragraph
- `(` and `)` the same for sentences
- `^` and `$` the first, last character of line

---

## Chording `g`

other than `shift + g` and `gg`, `g` can chord into:

- `g_`: Jumps to the last non-blank character of the line.
- `gq` (followed by a motion, e.g., `gqip`): Formats text, such as a paragraph.
- `gd`: Goes to the local declaration of the variable under the cursor.
- `gD`: Goes to the global declaration of the variable under the cursor.
- `g;` and `g,`: Navigates through the change list (previous/next position where a change was made).
- `gx`: Opens the URL under the cursor.

---

## Command line stuff

- Vim already can read that `:<followup>` is a command
- `:r! <linux command>` - `r` for reading the input of something, `!` for telling vim to run a shell with some command (but you can just swap out `!` with a file) then write the linux command to have the output be read and inserted into vim.

    - i.e.  `:r! date`



## Random videos to consider

<https://youtu.be/RdyfT2dbt78?si=5pqsQvwRTtWv_xew>
