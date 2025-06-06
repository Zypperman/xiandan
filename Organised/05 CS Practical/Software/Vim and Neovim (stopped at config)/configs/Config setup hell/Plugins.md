# NeoVim plugins

First, make sure you have a package manager of your choice and use the appropriate syntax for installing stuff with it. We use lazy.nvim (tutorial uses packer but its now unmaintained, see [Packer's Github Repository](https://github.com/wbthomason/packer.nvim?tab=readme-ov-file).)

[Find plugins here. Thank RockBOO.](https://github.com/rockerBOO/awesome-neovim)

## Using Packer

after writing everything nicely, check if your packer file compiles properly with `:so`, then 

## Essentials

- Telescope - for fuzzy-finding files and git history

- Treesitter - for parsing but on crack.
    - Parses code super fast
    - changes are stored as incremental trees
    - provides highlighting, indenting and everything.

    installation: (Add into your plugins.lua file)

    ```lua
    use('nvim-treesitter/nvim-treesitter', {run: ':TSUpdate'})
    ```

- [neovim trees-tter playground](https://github.com/nvim-treesitter/playground)

    - run `:TSPlaygroundToggle` to get an abstract syntax tree (AST) that you can move your cursor to highlight sections of code that they map to.
    - Good for developing plugins.

- [Harpoon](https://github.com/ThePrimeagen/harpoon)
    - basically the minecraft hotbar but you set what you hotswitch to.
    - `<space>a` - add file to hotbar
    - `Ctrl + e` - open hotbar menu
        - edit your paths like a mini text editor, cut and paste accordingly
        - `Ctrl h/t/n/s` - navigate to paths specified in lines 1 2 3 4 of the menu.

    installation: (Add into your plugins.lua file)

    ```lua
    use('theprimeagen/harpoon')
    ```

- [undotree](https://github.com/mbbill/undotree)
    - tracks edits over time as a tree with timestamps.
    - `<space>u` - toggles the tree in a right window.
    installation: (Add into your plugins.lua file)

    ```lua
    use('mbbill/undotree')
    ```

    >[!WARNING] Windows error
    >
    > - you will get an error while using your shell with windows instead of lunux, because UndoTree uses linux commands. [This post explains why](https://www.reddit.com/r/neovim/comments/18o8ag3/comment/kg2hu6o/?utm_source=share&utm_medium=web2x&context=3) and fixes it by changing they keyword for it to FC since thats the powershell equivalent.
    > fix it by including this line at the start of your file `nvim/afterplugin/undotree.lua`:
    >
    >    ```lua
    >    vim.g.undotree_DiffCommand = "FC"
    >    ```

- [Fugitive](https://github.com/tpope/vim-fugitive)
    - Vim integration for Git.
    - `<space>gs` - "git status", pulls a dialog box out.

- [copilot](https://github.com/github/copilot.vim)
    - github copilot for vim.