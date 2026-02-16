# Whats in the dotgit folder

## What a fresh `.git` folder has

If you've ever looked inside the `.git` folder after creating it, you'll notice it has:

- **Some examples under the `hooks` folder:** These are shell script templates (like `pre-push.sample`) that you can activate to automate tasks
- **Some default exclusion rules in `info/exclude`:** This acts as a local-only `.gitignore` that doesn't get checked into version control.
- **An initial `config` file:** This contains repository-specific settings, such as whether the file system is case-sensitive and where your "origin" remote might eventually live.
- **A `description` file:** A legacy file used by the GitWeb CGI interface to name the project; most modern developers leave this untouched.
- **The `HEAD` file:** This is the most important pointer; in a fresh repo, it usually contains `ref: refs/heads/main` (or `master`), telling Git which branch you are currently on.
- **Empty `objects` and `refs` directories:** These are the skeletons of your database. `objects/` will soon hold your file data, while `refs/` will hold your branch and tag pointers.

> [!TIP] What exactly is a `HEAD`?
>
> - TLDR, it is the symbolic reference to the latest commit in your history.
> - another thing called the `FETCH_HEAD` is a thing that records the branch which you fetched from a remote repository with your last git fetch invocation.
>
> For a deepdive and proper answers from stackoverflow:  
>
> - [What is the HEAD in git?](https://stackoverflow.com/questions/2529971/what-is-the-head-in-git)
> - [HEAD and ORIG_HEAD in Git](https://stackoverflow.com/questions/964876/head-and-orig-head-in-git/964927#964927)
