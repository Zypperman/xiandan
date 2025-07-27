# Git for Intermediate devs

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
