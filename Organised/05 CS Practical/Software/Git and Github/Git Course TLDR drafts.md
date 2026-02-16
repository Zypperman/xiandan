# Git and Github Theory

From Primagen's Git and Github Course on boot.dev.

- [Full course](https://youtu.be/rH3zE7VlIMs?si=LZOFic8pySAvmiGh)

## Command types

Git has 2 informal classifications of commands:

- High level (user-friendly/porcelain) commands like:
    - `git status, add, commit, push, pull, log`
    - `git bisect, cherry-pick, reflog`
    - part of day to day use, you'll be more familiar with these
- Low-level (troubleshooting/plumbing)
    - `git apply, commit-tree, hash-object`
    - less used, but still important to understand how they work to understand porcelain commands

## Quick Basics refresher

- `man git` to read the manual with a UI
    - q to quit the manual
    - `j` and `k` to go up and down by 1 line
    - `d` and `u` to go up and down by *half a page*
    - `/<term>` to search for something
    - `n` and `shift + n` to search for the next or previous instance
- `git config` information
    - stored in a file located in some global location like your home directory, or a `.git` folder
    - You can view your current git settings with `git config --list` or `git config -list -show-origin`
    - add preferences with `git config --add` (ie.`git config ---add --global init.defaultBranch master`)
        - Note, for github the default branch name (by convention) is `main`.
    - View your stash with `git stash list`

## Intermediate Concepts

### whats in your `.git` folder

-

### `reflog`ing

### `cherry-pick`ing

## `bisect`ing

## Sources

- [Boot.Dev | Learn Git - The Full Course](https://youtu.be/rH3zE7VlIMs?si=m3pHJL5pGavN3M7j)

---

## Tagging

- Fundamentally, it is:
    - just a label for a commit, so you can quickly jump to that commit and show people work up till that stage in your commit history.
    - Used for versioning you software, i.e.:
        - if someone wants to see a presentable version of your codebase, you can just mark a tag for the v1 and write down features that you'd like to present.
        - or if another dev is done with a feature, they can add a tag and some details to the tag, and you can find that feature by just listing the tags (with `git tag`):

        ```bash
        git tag -l ""

        ```

        and you can just specify
    - Coded as an "immutable named pointer":
        - immutable &#8212; a property that means that you don't intend to change this thing over time
        - named &#8212; just means you as a user can define what to call this thing
        - pointer &#8212; a variable storing the memory address for something.

> [!TIP] Docs
>
> - <https://git-scm.com/book/en/v2/Git-Basics-Tagging>

---

## Git Cherrypick

- <https://git-scm.com/docs/git-cherry-pick>

- for when you don't want to merge every single commit in your history.
- you can do

---

## Reverting changes

If you're a few commits down the line and you'd like to revert some changes:

- `git reset --soft HEAD~1` - resets your git history to a specific commit
    - indicating `soft` means the  previous commit is undone, and its associated changes now sit in the staging area
        - indicating `hard` means that you won't store those changes from the prior commit at all, and completely gets deleted.
    - indicating `HEAD~1` means that your destination commit is 1 before the current HEAD.

But note that this won't work if you're on the first commit of your repo.

If you're past your first ommit and you'd liketo undo a a commit:

- `git update -ref -d HEAD` - this deletes the reference to the current branch, effectively making the repository act as if no commits have ever happened, while keeping your files intact.

And if you're worried that you're not undoing the right commit, do:

- `git log --oneline` to check your commit history.

[The docs for `git reset` are also very useful for this.](https://git-scm.com/docs/git-reset)

---
