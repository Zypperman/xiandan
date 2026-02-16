# Git and Github Theory

progress: <https://youtu.be/rH3zE7VlIMs?si=q9-4Z9dGVGg0fiia&t=878>

## Sources

- [Boot.Dev | Learn Git - The Full Course](https://youtu.be/rH3zE7VlIMs?si=m3pHJL5pGavN3M7j)

## Self Help strategies

- Ask AI when u need Help
- look through the documentation, either via the `man` pages of git (i.e. `man git-commit` or `git commit --help`)
    - but these aren't very helpful if you're panicking, its more for when you're trying to get something specific done.
    - Navigation of the manual can be found [here](./man%20page%20controls.md).

> [!TIP] Powershell doesn't have help for git
> Apparently there aren't man pages from powershell for Git. Even the The `Git for Windows` package typically doesn't include the necessary man pages or the man command utility itself.
>
> For windows, we either:
>
> - `git help <command>` &#8212; this straight up opens a browser tab with locally stored html
> - `git <command> --help` &#8212; this shows a shorter version of documentation on the terminal.
>
> Also for powershell, the command to get documentation is `Get-Help` and is aliased withk `man` and `help`.
>
> documentation can be found [here](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.core/get-help?view=powershell-7.5).

## Command Types

Git has 2 informal classifications of commands:

<span style="color: cyan;">High level (user-friendly/porcelain) commands like:
</span>

- `git status, add, commit, push, pull, log`
- `git bisect, cherry-pick, reflog`
- part of day to day use, you'll be more familiar with these

<span style="color: magenta;">Low-level (troubleshooting/plumbing) commands like:
</span>

- `git apply, commit-tree, hash-object`
- less used in most work settings, but still important to understand how they work to understand the high-level commands.

---

## 01 setting up your configuration

- Git needs to ID you with your name and email via your config file.
- its literally just a file with your information to attribute you to your commits.

### How the config file is implemented

- stored in:
    - a file located in some globalspace (i.e. your home directory / $HOME)
    - a `.git` folder
- You can view your current git settings with:

    ```powershell
    # for all configuration settings
    git config --list 

    #or
    
    # for all configs and the filepaths of the files where they were declared
    git config --list --show-origin

    #or

    # just certain piecesof information
    git config --get user.name
    git config --get user.email

    #or 

    # straight up get all the content of the config folder
    cat ~/.gitconfig
    ```

you can also pipe the output to `grep` to search for sutff:

`git config --list | grep name` searches the contents of the git config folder with grep, finding your name.

> [!NOTE]
> git config uses the old style of adding flags
>
> - `git config --add --global` &#8212; flags all are prefixed with `--`
>
> The newer, higher level commands don't need it.
>
> - `git stash list`

- add preferences with `git config --add` (ie.`git config ---add --global init.defaultBranch master`)
    - Note, for github the default branch name (by convention) is `main`.
- View your stash with `git stash list`

### Adding config variables

- treat the config file like a list of user defined variables. Add as many as you like, but git will only take the lowest one in the document as the most recent one to use.

- syntax for adding commands is:  
        `git config --add --global <git-recognised-variable> <git-recognised argument>`  
    i.e. `git config --add --global init.defaultBranch master`

    - also fyi you can also set it to `main` or `trunk`, so long as you remember it.

---

## 02 Orientation with repositories

Generally, you'd start a project by creating a repository, and have 1 repository per project.

> [!important] When to use multiple repositories
>
> - when you don't want to mess with the current change histsory
>     - so you fork / make your own copy of the repo and work on it first then merge it back
> - when you are working with large distributed applications that are built as microsevices (i.e. payments, authentication etc) so each component is easy to work with
>     - i.e. frontend and backend for a website are separate github repos
> - sometimes its just a company culture thing for how version control and collaboration is handled.

### Repo vs directory

- Directories are just a technical term for folders on your file explorer.
    - your project is just the folder where your project sits in and has stuff in it, i.. more folders etc, code etc.
- A *directory becomes a repository* when you run `git init` in that directory, and <span style="color: cyan;">**a hidden `.git` directory is created.**</span>
    - this directory represents literally all the changes, worktrees, branches and technical state of the repository.

#### making a repo

- just create a directory of choice, navigate to it from your shell then initalize your repo. With the example of `webflyx`:

    ```powershell
    mkdir webflyx
    cd webflyx
    git init
    ```

- [For random deep cut lore, here's how the .git folder is structured.](whats%20in%20the%20dotgit%20folder.md)

---

## 03 File Statuses

you can run `git status` in a repo to see what states files in your repo have.

- Your file is either:
    - untracked  - means git isn't tracking it
        - means the file / changes associated (if the file's creation is in a commit) has not been added to git's index / staging area
        - <span style="color: magenta;">if u delete the file now, it just never gets tracked.</span>
    - staged - means that the changes for this doc will be saved when you do `git commit`
    - committed - means its current state has been saved in memory.

You can run these commands to make sure things get committed:

- `git status` - check the status of your files, whats being tracked and whats not
- `git add` - turn files from untracked to staged by adding them to the staging area and prepping them to be saved
- `git commit` - create a checkpoint in your codebase (known as a snapshot) then add all staged files to it.

### what happens when i delete staged files???

- <span style="color: magenta;">if you delete the file now, git will also note that it was deleted. and ask if you want to commit that change.</span>
- so technically if you deleted a file but it was staged, you can get it back provided you havent cleared your recycling bin / run any garbage collection protocols.
- Git creates a blob object containing the file's contents and stores it in the .git/objects directory. Even if you delete the file from your disk and the staging area, that blob often lingers in Git's database as a "dangling" object.
    - you can get it back by doing `git fsck --lost-found` to list all deleted stuff, and it will be some hash with the prefix `dangling blob`.
    - from there u can see the file's contents by doing `git cat-file -p <hash_from_above>`
    - and if you wanna restore it do `git cat-file -p <hash> > restored_file.txt`
    - just know this only works if you didn't do garbage collection recently i.e.e with `git gc`.

### The staging area

- helps you manage the git index (helps with thinking about how your changes work)
- <span style="color: yellow;">The index is a continuous list of changes that you have made to your codebase.</span>
    - as per the manual for `git add`:
        > This command updates the index using the current content found in the working tree, to prepare the content staged for the next commit. It typically adds the current content of existing paths as a whole, but with some options it can also be used to add content with only part of the changes made to the working tree files applied, or remove paths that do not exist in the working tree anymore.
        >
        > The "index" holds a snapshot of the content of the working tree, and it is this snapshot that is taken as the contents of the next commit. Thus after making any changes to the working tree, and before running the commit command, you must use the add command to add any new or modified files to the index.
        >
        > This command can be performed multiple times before a commit. It only adds the content of the specified file(s) at the time the add command is run; if you want subsequent changes included in the next commit, then you must run git add again to add the new content to the index.

### `git status` tips

- note that a quick way to add all files in a folder to be tracked is to do `git add .`
- So this works and takes everything in the current directory and throws it into the staging area.
- but if you go to a sub directory then do that, only the contents of that subdirectory get added.
- it just so happens that when u did this in the parent dir, the files in that sub also happen to be considered in that same directory so thats why that works.

To really add everything in that repo apparently u can do `git add -A`, which tells Git to look at your entire working directory and stage every change it finds.

---

## 04 What a commit really is

- Commits are NOT DIFFs.
- we often use the analogy that each commit
