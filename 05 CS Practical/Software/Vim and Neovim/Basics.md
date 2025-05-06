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

## Navigation

Motions = anything that moves the cursor.

- `wasd` for fps games maps to `khjl` (alternatively, map keyboard order to just the directions directly: hjkl to left down up right)

    | Direction| FPS | Vim |
    |---|---|---|
    | Left | a | l |
    | Down | s | j |
    | Up | w | k |
    | Right | d | h |

- `w` - "walk",  jumps rightwards to the start of each word.
- `b` - "back",  jumps backwards to the end of each word.
- `esc` - panic button, always brings you back to normal mode

## Navigation (Intermediate): motion prefixes

- you can mod navigation motions with prefixes.
    - `<num><motion>` - move cursor \<motion\> \<num\> times ie. 8k ---> move up 8 lines




