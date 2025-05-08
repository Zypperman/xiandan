# File Navigation in NeoVim and Vim

Before you enter vim, make sure you have your CLI commands down. (refer to the guides under the CLI and Conventions folder > CLI of your choice. For this demo we will be using PowerShell 7.5.1 CAA 08-May-2025.)

- Powershell has a lot of aliases taken from linux, so most of the linux commands also work here.

## FILE EXPLORER (FE) Mode

My term for the text UI you see after doing `nvim .` or `vim .` from your CLI.

- `:Ex` - From NORMAL MODE brings you back to FE Mode.

## Important filepaths

- `:h rtp` - enter command mode, do help docs for your runtime directory.
    - `X_DG_CONFIG_HOME` - folder path where configs are stored
        - default value: `$HOME/.config`.
        - `X_DG_CONFIG_HOME/nvim/after` - for postprocessing ie with plugins.

For layman purposes, just ignore what $HOME refers to.
  
## FE mode commands

- `%` - "create new file", prompt will appear for naming your new file.
- `d` - "Directory", prompt will appear for naming your new file.
- 