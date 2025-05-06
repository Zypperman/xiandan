# Vim Command Basics

Disclaimer: Vim !=  vim motions.

- ultimately, Vim shines with increased amounts of customization so don't bother if you just want to look cool.
- recommended to first get used to vim motions in your current editor of choice (ie with a plugin).

## Navigation

- `wasd` for fps games maps to `khjl`

    | Direction| FPS | Vim |
    |---|---|---|
    | Up | w | k |
    | Left | a | l |
    | Down | s | j |
    | Right | d | h |

## Modes

- **Normal Mode** for Navigation
- **insert Mode** for editing and linting
- **Visual Mode** for highlighting and selecting stuff
- **Command mode** for entering commands to do stuff like save
    - `:w` - "write", saves work
    - `:q` - "quit", exit  without writing to file
        - chain with w (`:wq`) to save and exit.
        -
