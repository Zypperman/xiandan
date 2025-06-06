# Random Neovim and Vim Tips and Tricks

## General Self help ([source](https://vi.stackexchange.com/questions/36435/complete-list-of-all-vim-commands))

Full documentation can be accesseed for [Neovim](https://neo.vimhelp.org/) and [Vim](https://vimhelp.org/) here.

On your text-editor client, full documentation can be accessed at various levels with the `:help` function and a follow-up keyword. Alternatively, the documents for each command have been linked here.

- [`:help index`](https://vimhelp.org/index.txt.html) - pulls up the file with a list of all commands for each mode, with a tag and a short description. The lists are sorted on ASCII value.

- `:put =getcompletion('', 'command')` generates the full list of known commands at runtime (but only for command mode).

## Useful stuff (from personal experience)

- `=` - in VISUAL mode, formats your indentation for you
- `/` - in NORMAL mode, triggers a search, confirm with `enter` key