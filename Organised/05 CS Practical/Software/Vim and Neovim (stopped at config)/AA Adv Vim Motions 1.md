# Advanced Vim Motions 1

## Running terminal commands in nvim

- `:!<cli_command>` &#8212; sends commands to your terminal to execute, so you can do `:!ls` to list files from your current directory.
    > [!Caution] Stupid configuration thing for windows Powershell
    > - if you're unfortunately on windows, doing `:!ls` may not work. If thats the case,

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
        - same with `vwd` or vwx` for deleting words.
    - however this gets rid of your paste content from your buffer, so just use whatever primagen did.

> [!note]
> any command with position selecting `iw` or `i shift w` is amazing, general command that reduces cognitive load.

## coding utils

- `gc` after selecting some text comments it out
- `:set ic` to temporarily ignore case when micro-searching for stuff
- random other search-related things you can set with syntax `:set args**`:
    - `:set hlsearch` - highlights your content
    - `:set is` - displays real-time results as you type
    - prepend args with `no` to turn them off and `inv` to invert their value
        - `:set noic` and `:set nohlsearch` turns the two features off.
        - i.e. `:set invic` just inverts whatever it currently is

- `ctrl + d` from insert mode de-indents your code block

- vw is just a quick way to select the entire word your cursor is on (like double-click on GUIs)

## Handling windows

### spawning windows

- `:sp <file_name>` - spawns window horizontally, opening specified file
- `:vs <file_name>` - spawns window vertically, opening specified file

Alone, they just create 2 windows of the same file.

### managing windows

- start all window-handling commands with `ctrl + w`
- use `hjkl` keys from there to hop windows
    - alternatively if theres only 2 just do `ctrl + w` twice
- `ctrl + w` &#8594; `c` kills the active window

### resizing windows

- `ctrl+w` then `+`  - increase height of current split  
- `ctrl+w` then `-`  - decrease height of current split  
- `ctrl+w` then `>`  - increase width of current split  
- `ctrl+w` then `<`  - decrease width of current split
- `ctrl+w` then `=`  - make all splits equal size

---

## Important shortcuts for coding specifically

### Toggling commenting

Toggles commenting/uncommenting for (woth commentary.vim):

- `gc` -  a single line
    - actually works like a command that can be chained with motions now ie `gc4j`
- `gcip` - the current paragraph
- `gcc` - the current line
- `gc` - a selected block in Visual mode, enter with `ctrl + v`
    - introduced after 0.9.0

### Indenting

Indent:

- `>G` - the current line and all subsequent lines until the end of the file
- `>` - the current line to the right
- `>>` - the current line to the right by one shiftwidth
- `<<` - Unindents the current line to the left by one shiftwidth
- `>` (in **Visual mode**) - Indents the visually selected block one level to the right
- `<` (in **Visual mode**) - Unindents the visually selected block one level to the left
- `=aB` - Auto-indent the code block defined by a pair of curly brackets
    - (useful in `C`, `Java`, `JavaScript`, etc.).

### Navigation

- `%` - Jumps to the matching parenthesis, bracket, or brace
- `*` - Searches forward for the word under the cursor.
- `#` - Searches backward for the word under the cursor.

### Commands

- `:so %` - **Rereads** and executes the current file as a **Vim script** (useful for reloading changes to `.vimrc` or other configuration files)
- `:make` - Runs the **`make`** command or the command defined by the **`makeprg`** option, collecting errors in the **quickfix list**
- `:cn` - Jumps to the **next error** in the quickfix list after using `:make`
- `:cp` - Jumps to the **previous error** in the quickfix list
- `:copen` - **Opens** the quickfix window to view the list of errors
- `:grep 'pattern' **` - Searches for `'pattern'`** in files (using **`grep`** or **`vimgrep`**) and populates the quickfix list
