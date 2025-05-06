# Vim Command guide

Disclaimer: Vim !=  vim motions.

- ultimately, Vim shines with increased amounts of customization so don't bother if you just want to look cool.
- recommended to first get used to vim motions in your current editor of choice (ie with a plugin).

## Modes

- **Normal Mode** for Navigation
- **insert Mode** for editing and linting
- **Visual Mode** for highlighting and selecting stuff
- **Command mode** for entering commands to do stuff like save

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

- `w` - "word",  jumps rightwards to the start of each word.
- `b` - "back",  jumps backwards to the end of each word.
- `esc` - panic button, always brings you back to normal mode

## Navigation (motion prefixes)

Motions can be formatted as `<command><count><motion>`.

1. you can mod navigation motions with *number prefixes*.
    - `<num><motion>` - move cursor \<motion\> \<num\> times ie. `8k` &#8594; move up 8 lines
        - typically ideal for up and down only.

2. you can mod *commands* using *motions with optional number prefixes*.
    - **Commands** operations that can be chained with navigation
    - `d` - "delete" - prefix to delete, combine with `<num><motion>`
        - `d` (non-chained)- "delete" - double-tap to delete a line.
    - `c`
    - `y`
    - `v`

## Operation history (Undo and Redo)

- `u` - "undo"
- `ctrl+r` - "redo"
