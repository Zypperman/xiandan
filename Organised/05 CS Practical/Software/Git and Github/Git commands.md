# commonly used git commands

Start with `git <command>`:

### **Basic Commands**  

- `init` – Initialize a new repository.  
- `clone <repo-url>` – Clone a remote repository to your local machine.  
- `status` – Check the status of your working directory (staged/unstaged changes).  
- `add <file>` – Stage a file for commit.  
    - `add .` – Stage all changes for commit.
- `commit -m "message"` – Commit staged changes with a message.  
- `commit -am "message"` – Stage and commit tracked files in one step.  
- `log` – View commit history.  
- `diff` – See unstaged changes.  
- `diff --staged` – See staged changes.  

### **Branching & Merging**  

- `branch` – List all branches.  
- `branch <branch-name>` – Create a new branch.  
- `checkout <branch-name>` – Switch to a branch.  
- `checkout -b <branch-name>` – Create and switch to a new branch.  
- `merge <branch-name>` – Merge a branch into the current branch.  
- `rebase <branch-name>` – Rebase the current branch onto another branch.  
- `branch -d <branch-name>` – Delete a branch (safe, checks merge status).  
- `branch -D <branch-name>` – Force delete a branch (unmerged changes).  

### **Remote Repositories**  

- `remote -v` – List remote repositories.  
- `remote add <name> <url>` – Add a new remote repository.  
- `fetch` – Download changes from remote without merging.  
- `pull` – Fetch and merge changes from remote.  
- `push` – Push local commits to the remote repository.  
- `push -u origin <branch>` – Push and set upstream branch.  
- `push --force` – Force push (use with caution).  

### **Undoing Changes**  

- `reset <file>` – Unstage a file.  
- `reset --hard` – Discard all local changes (unstaged & staged).  
- `reset --soft HEAD~1` – Undo last commit but keep changes staged.  
- `reset --hard HEAD~1` – Undo last commit and discard changes.  
- `revert <commit-hash>` – Create a new commit that undoes a previous commit.  
- `checkout -- <file>` – Discard changes in a file (before staging).  

### **Stashing**  

- `stash` – Temporarily save uncommitted changes.  
- `stash list` – List all stashed changes.  
- `stash apply` – Reapply the most recent stash.  
- `stash pop` – Apply and remove the most recent stash.  
- `stash drop` – Delete the most recent stash.  

### **Tagging**  

- `tag` – List all tags.  
- `tag <tag-name>` – Create a lightweight tag.  
- `tag -a <tag-name> -m "message"` – Create an annotated tag.  
- `push --tags` – Push tags to remote.

## Sources

- [git docs](https://git-scm.com/docs)