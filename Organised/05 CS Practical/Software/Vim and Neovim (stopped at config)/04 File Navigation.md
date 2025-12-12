# File Navigation in NeoVim and Vim

Before you enter vim, make sure you have your CLI commands down. (refer to the guides under the CLI and Conventions folder > CLI of your choice. For this demo we will be using PowerShell 7.5.1 CAA 08-May-2025.)

- Powershell has a lot of aliases taken from linux, so a lot of the linux commands also work here (but less than you think so don't count on it, get used to the long-asf command syntax.)

## FILE EXPLORER (FE) Mode

I term "FE" as the text UI you see after doing `nvim .` or `vim .` from your CLI. The game title screen, if you will.

![Imagine the Nvim title card here](https://user-images.githubusercontent.com/81827001/146725450-5c3ddc5b-e4aa-47b9-88b1-446810bebcea.png)

- `:Ex` - From NORMAL MODE brings you back to FE Mode.
    - remapped to `<space>pv` in my machine. See [this section](https://github.com/Zypperman/xiandan/blob/ccec36ddf2278bee6dbde8b4dbf13c5012ee4e1e/Organised/05%20CS%20Practical/Software/Vim%20and%20Neovim%20(stopped%20at%20config)/configs/Config%20setup%20hell/.Vim%20Config.md) in my config articles.

## Important filepaths

- `:h rtp` - enter command mode and help docs for your runtime directory.
    - `X_DG_CONFIG_HOME` - folder path where configs are stored
        - default value: `$HOME/.config`.
            - `$HOME` or `~` is where your nvim is installed. by defualt for windows, its `~/AppData/Local/nvim-data`
        - `X_DG_CONFIG_HOME/nvim/after` - for postprocessing ie with plugins.

For layman purposes, just ignore what $HOME refers to.
  
## FE mode commands

- `%` - "create new file", prompt will appear for naming your new file.
- `d` - "Directory", prompt will appear for naming your new file.

## File handling commands

<!-- TODO: check if this is correct -->

- `:so` - "source", from NORMAL mode, checks if your file compiles successfully.
    - But it only works for vim scripts i think
- `:e` - "edit", enter INSERT mode, but now you open a new register / buffer (so you don't have access to what you copied if you had insert mode on another buffer.)
    - buffers can be listed using `:ls`.

## More Vim register Tricks

- apparently `<number>dd` deletes `<number>` lines
    - same for the other motions, just a faster highlighting trick
    - [refer here for semantics.](https://vi.stackexchange.com/a/31432)

## running external commands from vim's command mode / bar / thing

Referring to that one line where you can do `:<command>`.

- `:!<shell_cmd>` runs shell commands
    - i.e. `:!dir` or `:ls` to see file contents

- `:w file.ext` lets you create a file in your command line's current working directory
    - highlighting stuff then doing `:w file.ext` save selections to a file with that name, storing relative to wherever you opened nvim from.
        - it also automatically give you the `:'<','>'` starting command template so you know you're working with the highlighted stuff.
- `:r file.ext` reads file content and throws it up after your cursor.

- `Ctrl + d` - tab completion for internal commands, or it just shows you what options you have from your current input.
    - `<tab>` itself also works.

- `:e file.ext` opens the file in a new buffer.
    - but this can be changed with `:h autowriteall` to autosave when you open a new buffer.

