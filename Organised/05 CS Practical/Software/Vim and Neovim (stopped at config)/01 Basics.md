# Vim Command guide

Disclaimer: Vim !=  vim motions.

- ultimately, Vim shines with increased amounts of customization so don't bother if you just want to look cool.
- recommended to first get used to vim motions in your current editor of choice (ie with a plugin).

## Modes

- **Normal Mode** for Navigation
- **Insert Mode** for editing and linting
- **Visual Mode** for highlighting and selecting stuff and clipboard functions
- **Command Mode** for entering commands to do stuff like save

Less used:

- **Replace Mode** for replacing text (enter from NORMAL mode with `R`)

----

## Navigation (motions)

Motions = anything that moves the cursor.

- `wasd` for fps games maps to `khjl` (alternatively, map keyboard order to just the directions directly: hjkl to left down up right)

    | Direction| FPS | Vim |
    |---|---|---|
    | Left | a | l |
    | Down | s | j |
    | Up | w | k |
    | Right | d | h |

- `w` - "word",  jumps forwards to the start of each word.
- `b` - "back",  jumps backwards to the start of each word.
- `e` - "end",  jumps forward to the end of the next word.
- `ge` - "gostan end", jumps end to the end of the next word.
- `x` - "cut", deletes the current character under the cursor.
    - also saves it to your clipboard buffer.

## Navigation (motion prefixes)

Motions can be formatted as `<command><count><motion>`.

1. you can mod navigation motions with *number prefixes*.
    - `<num><motion>` - move cursor \<motion\> \<num\> times ie. `8k` &#8594; move up 8 lines
        - typically ideal for up and down only.

2. you can mod *commands* using *motions with optional number prefixes*.
    - **Commands** operations that can be chained with navigation
    - `d` - "delete" - prefix to delete, combine with `<num><motion>`
        - `dd` - deletes the entire line.
            - Behaves functionally like cut, cuz anyway whatever's deleted is sent to the same buffer.
        - `d$` - deletes till the end of the line
        - `ndd` - deletes n lines
    - `c` - "change" (basically, you remove some shit and enter insert mode to make your edit.)
    - `y` - "yank/copy"
    - `v` - "visual mode" - for highlighting

## Operation history (Undo and Redo)

- `u` - "undo"
    - `shift + u` - "undo all actions on that line"
- `ctrl+r` - "redo"

## Insert Mode

- `i` - from NORMAL mode, enters INSERT mode, edits start on CURSOR LEFT.

    The left side of your cursor now is the reference point for edits. (or if its a thin line, whatever you type goes after the thin line.)
- `a` - from NORMAL mode, enters INSERT mode <span style="color:skyblue"> **edits start on cursor right**.</span>

Also, `shift + i` and `shift + a` to insert from the start and or end of the line respectively.

- `esc` - panic button, always brings you back to normal mode
    - Alternatively,
    - `ctrl + [` and `ctrl + c` do the same thing.

<!--- TODO: figure out the difference between ctrl + c or ( and esc -->

## Visual Mode and clipboard operations

- `v` - from NORMAL mode, enters VISUAL mode.  

    Motions now highlight content from cursor position on entering VISUAL mode. enter analogously to when you wanna highlight stuff with your mouse.

- `y` - "yank", copies selected content then deselects it
- `p` - "paste", pastes the contents to the right of your cursor. No new line entered, only contents.
    - `shift + p` - Pastes content before your cursor

- `shift + v` - from NORMAL mode, enters VISUAL LINE mode.  
    - now when content is yanked, its pasted as a new line. indentation is maintained with content before pasting, cursor also ends up on the first character of the line.
- `yy` - from NORMAL mode, it just takes the entire line and copies it to your clipboard.

- `r` - "replace" - wherever your cursor currently is, replace that character with the next typed character.

- `c` is also just used in general as a replace command, and can be used like `d`

    - `c$` or `shift + C` - change everything till the end of the line
    - `ce` - "change to end-of-word" - delete the rest of the word from your cursor, enter insert mode and type to replace it with whatever you type until you exit insert mode.

### Visual Mode Tricks

- you can highlight stuff, yank, then highlight something else and paste over it.
    - note, this removes the last thing you yanked from your clipboard.
- if your clipboard is presumably empty, the next thing you paste will be the last item you deleted (ie from doing `dd`)
    - <span style="color:skyblue"> **Yanking and Deleting go to the same buffer.**</span> Same for the cut action.
        - that means when you paste over some highlighted content, the deleted stuff goes into the same buffer and its stored there, so when you do `p` again it pastes whatever you just overwrote.

## Command mode

- **Command mode** is for entering commands to do system operations like save, you enter it with `:` from normal mode.
    - `:' - From NORMAL mode, enter COMMAND mode
    - `:w` - "write", saves work
    - `:q` - "quit", exit  without writing to file
        - with no modifier, you just have a "swap" file that vim will prompt whether you want to keep working on this or not.
        - chain after w (`:wq`) to save and exit.
            - `:wq` has 2 variants, `:x` and `shift + Z + Z`
        - chain with ! (`:q!`) to force-exit.

- `h` - "help" - safeword to see what a keyword does. Open from command mode.

## quitting Vim

- `:q!` - exits the editor without saving changes
    - `!` modifier forces changes to be discarded.
