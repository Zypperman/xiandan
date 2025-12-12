# How Vim Works

- [ ] IMPORTANT transcribe notes for [the rest of this video](https://youtu.be/5JGVtttuDQA?si=3TXonoyg6HCRc_Bi&t=240)

## Buffers

- each time you open a new file, you get 2 things:
    - a buffer where your file gets edited
    - a register attached to the buffer acting as your clipboard

### Managing buffers

- `:ls` - lists all your buffers
- `:bnext / :bn` and `:bprev / bp` - toggles between buffers
    - alternatively `ctrl + o` and `ctrl + i` can toggle between buffers by jumping between cursor histories.

### register stuff

> [!important] Sources
> How do I use vim registers? - <https://stackoverflow.com/a/1498026>

- Registers are listed alphabetically, and accessed ia `"<register_num><clipboard_cmd>`, except:
    - `"+` - system / linux keyboard (basically the same register in Windows)
    - `"*` - selection / windows clipboard
    - `"` - default register if none has been explicitly declared from the user.

- `:reg` - view all defined registers
- `"kyy` - copy the current line into register k
- `ctrl + r` &#8594; `register_index` to paste from a register
    - `"` is the default register so `ctrl + r` &#8594; `"`

### resizing splits

- `CTRL-W + +`  - increase height of current split
- `CTRL-W + -`  - decrease height of current split
- `CTRL-W + >`  - increase width of current split
- `CTRL-W + <`  - decrease width of current split
- `CTRL-W + =`  - make all splits equal size

Think of it like cells, only really works if you have 2 in the same "cell" where adjusting sizes makes sense.

### Spellchecker

once enabled, vim will just highlight as a text editor what words it thinks are wrong.

- `:setlocal spell spelllang=en_gb` - set language spellchecking to match british english

#### Spellchecker Navigation

- `]s`  - Move to the next misspelled word
- `[s`  - Move to the previous misspelled word
- `z=`  - Suggest corrections for the word under the cursor
    - note, this is kinda sucky. its a manual spellchecker.
- `zg`  - Add the word under the cursor to the spell file
- `zw`  - Mark the word as incorrect
