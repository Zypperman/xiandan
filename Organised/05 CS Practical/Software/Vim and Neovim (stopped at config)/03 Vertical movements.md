# Vertical Movements

> [!note] Quick recap
>
> - `k` and `j` to jump up and down respectively.
> - chord with `<num><dir>` to go up and down that many lines.
> - chord as `<command><num><dir>` to apply command to all of that selected.

- where are you in your file?
    - hold down `ctrl + g` to see at vim's command line (the portion where you can see when you type ":" to write commands) the filename of your currnt file and position. It'll also tell you a percentage to indicate where you're currently at (i.e. 50% = your cursor is at the halfway mark of the doc)

- Paragraph Navigation
    - A paragraph is just a contiguous body of non-whitespace
    - jump up and down between paras with `{` and `}` resepectively
        - `{` always puts you before a paragraph
        - `}` always puts you at the end of a paragraph
        - single presses just bring you to the adjacent one in the direction pressed.
        - sucks because it default skips blocks of text ie entire functions
    - jump up and down between sentences with `(` and `)` resepectively

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

- to jump based on cursor-jump-history:
    - `ctrl + o` for previous jump
    - `ctrl + i` for next jump

- Jump to a specific line number
    - from normal mode, do `:<line_num>` or `<line_num>G`
    - `(` and `)` the same for sentences
    - `^` and `$` the first, last character of line

- Jump to a specific search term
    - `/` to trigger search from normal mode to find a term in the script of your current window
    - `n` goes to the next result, `shift+n` goes backwards.
    - `?` triggers a reverse search, and the navigation buttons flip.
    - If you have a super weird word to search:
        - `*` automtically grabs that term and does a `/`-search
        - `#` does the same but a `?`-search
    - `%` - for a pair of brackets, find the corresponding bracket.
        - doesn't matter square round or curly.
        - the only issue is when you deal with nested brackets, then it gets abit messy.

- find and replace word
    - do with `:s/<old_word>/<new_word>/` to find and replace for the sentence you're on. Works only o the first instance.
        - adding `g` at the end like `:s/<old_word>/<new_word>/g` does a find and replace for ALL instances on the line you're on.
    - for selecting an entire block to change, do
      `:#,#s/<old_word>/<new_word>/g`
    - `:%s/<old_word>/<new_word>/` initiates find and replace for <u>every line</u> in your file.
        - `:%s/<old_word>/<new_word>/gc` initiates find and replace for your whole file.
    - basically you add flags at the end to change the find and replace behviour:
        - `g` for global
        - `c` for a confirmation prompt before you do the swap

    - just remember:
        - `:s` for a single line
        - `#,#s` for a selection

    > [!important] But what if im using relative line numbers??? 😭
    >
    > - the #s in the `:#,#` part also supports relative numbering:
    > - `.` - current line
    > - `+n` - next n lines
    > - `-n` - prev n lines
