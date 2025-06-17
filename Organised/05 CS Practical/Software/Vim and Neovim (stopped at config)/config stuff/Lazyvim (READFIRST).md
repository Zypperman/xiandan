# Using LazyVim and Lazy.nvim

LazyVim &#8212; neovim if it looked like vs code out of the box. Its just a config distribution.  
  
Lazy-nvim &#8212; a package manager. Packer was used for some tutorials here, but is no longer maintained.

Lazyvim getting started guide: <https://www.lazyvim.org/>  
lazy.nvim Repo: <https://github.com/folke/lazy.nvim>

Anyway, just use LazyVim (the distro) if you want to quickly start. See this [reddit post](https://www.reddit.com/r/neovim/comments/1l4k6lw/lazyvim_vs_neovim/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button) for opinions on this.

## LazyVim Requirements FAQ

- Whats a "curl for blink.cmp"?
    - curl &#8212; Client for URLs.
    - blink.cmp &#8212; an extensible completion plugin for neovim. ( [Repo](https://github.com/Saghen/blink.cmp) )
    - when they ask for this, it just 

## support

> [!caution] Backing up existing neovim configs
> If you already have one, make sure to not override your existing profile.  
> Manage profiles with this [video](https://www.youtube.com/watch?v=LkHjJlSgKZY&ab_channel=ElijahManor).
> It says to use the nightly version of neovim, but what nightly is a tag used to describe versions of a repository that are still under development and updated every day (so its the m)
> For powershell, add script and translate it from .zshrc by doing `code $PROFILE`, which automatically opens a text editor for what you want to script.
>
> Refer to section "Configuring profile switching" for how to do it for windows.
> For me, i used [this guy's script](https://gist.github.com/elijahmanor/b279553c0132bfad7eae23e34ceb593b?permalink_comment_id=4588061#gistcomment-4588061). Don't worry about the runes, theyre just not rendered but theyre correct. The commands to use are nvim_<config> and nvims still works.

- Free book by [@dusty-phillips](https://github.com/dusty-phillips), "[LazyVim for Ambitious Developers](https://lazyvim-ambitious-devs.phillips.codes/)"

## Configuring profile switching  (LazyVim example with windows)

1. Install your new repo, but for the install line:  
    `git clone https://github.com/LazyVim/starter $env:LOCALAPPDATA\nvim`  
    Realise that this basically means:  
    `git clone <repository address> <somewhere on your computer>`  
    and this "somewhere" is based on where your environment variable.

    So, we can edit it into:  
    `git clone https://github.com/LazyVim/starter $env:LOCALAPPDATA\LazyVim`
    and our config is saved under the folder name `LazyVim`.  
2. Set up a profile for Powershell to refer for scripts you want to run.
    - Check if you already have a profile file:

        ```powershell
        Test-Path $PROFILE
        ```

        and if it returns False, create one:

        ```powershell
        New-Item -Path $PROFILE -Type File -Force
        ```

        This automatically sets up the file that powershell will check before loading in.

    - Open Your Profile for Editing
        - do it with

        ```powershell
        notepad $PROFILE # opens with notepad
        # or
        code $PROFILE # opens with vs code
        ```

3. Dump this code in:

    ```powershell
    # Aliases for different Neovim configurations
    function nvim-lazy { $env:NVIM_APPNAME = "LazyVim"; nvim @args }
    #function nvim-kick { $env:NVIM_APPNAME = "kickstart"; nvim @args }
    #function nvim-chad { $env:NVIM_APPNAME = "NvChad"; nvim @args }

    # Function to select Neovim configuration
    function nvims {
        $items = @("default", "LazyVim")
        #$items = @("default", "kickstart", "LazyVim", "NvChad", "AstroNvim") # list that the original video uses.
        
        # Using fzf to select configuration
        $config = $items | fzf --prompt=" Neovim Config  " # don't worry about the runes, theyre correct but dont render in vs code unless you're using a nerdfont
        --height=~50% --layout=reverse --border --exit-0
        
        if (-not $config) {
            Write-Host "Nothing selected"
            return
        }
        elseif ($config -eq "default") {
            $config = ""
        }
        
        $env:NVIM_APPNAME = $config
        nvim @args
    }

    # Set up key binding (Ctrl+A) to launch nvims
    Set-PSReadLineKeyHandler -Key Ctrl+A -ScriptBlock {
        [Microsoft.PowerShell.PSConsoleReadLine]::RevertLine()
        [Microsoft.PowerShell.PSConsoleReadLine]::Insert("nvims")
        [Microsoft.PowerShell.PSConsoleReadLine]::AcceptLine()
    }
    ```
