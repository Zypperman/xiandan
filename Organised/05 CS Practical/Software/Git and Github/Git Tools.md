# Additional tools to make git less painful

## Lazygit

- <https://github.com/jesseduffield/lazygit>
    - just a TUI for git

### TLDR Tips

Lazygit provides a variety of powerful tools for managing your Git workflow directly from your terminal. Here are the key features and capabilities identified in the video:

- **Efficient File Staging** [[00:32](http://www.youtube.com/watch?v=CPLdltN7wgE&t=32)]
    - Use the arrow keys to navigate files and press `Space` to stage or unstage them quickly.
    - Press `a` to toggle the staging status of all files at once.

- **Line-by-Line Staging** [[01:07](http://www.youtube.com/watch?v=CPLdltN7wgE&t=67)]
    - Press `Enter` on a file to view individual lines and select only the specific changes you want to stage with `spacebar`
    - Use `v` to start a range selection for staging multiple lines at a time.

- **Cherry-picking Commits** [[01:54](http://www.youtube.com/watch?v=CPLdltN7wgE&t=114)]
    - Press `c` on a commit to copy it and `v` in another branch to paste (cherry-pick) it.

    - **Discarding Changes and Cleaning Workspace** [[02:18](http://www.youtube.com/watch?v=CPLdltN7wgE&t=138)]
    - Press `d` to discard changes in a specific file.
    - Use `Shift+D` to access advanced reset options, including "nuking" the entire working tree to remove all uncommitted changes.

- **Interactive Rebasing** [[02:55](http://www.youtube.com/watch?v=CPLdltN7wgE&t=175)]
    - Press `e` on a commit in the commits panel to begin an interactive rebase.
    - Easily switch commit actions to squash (`s`), fixup (`f`), or drop (`d`) without manually editing a text file.

- **Reordering Commits** [[04:08](http://www.youtube.com/watch?v=CPLdltN7wgE&t=248)]
    - Use `Ctrl+J` and `Ctrl+K` during a rebase to swap the order of commits.

- **Amending Commits** [[04:21](http://www.youtube.com/watch?v=CPLdltN7wgE&t=261)]
    - Press `Shift+A` to immediately amend your current changes into an existing commit.

- **Fixup Management** [[04:58](http://www.youtube.com/watch?v=CPLdltN7wgE&t=298)]
    - Create a dedicated fixup commit for a specific past commit using `Shift+F`.
    - Use `Shift+S` to automatically squash all "fixup!" commits into their respective targets.

- **Opening Pull Requests** [[05:51](http://www.youtube.com/watch?v=CPLdltN7wgE&t=351)]
    - Press `o` to open the Pull Request creation page for your current branch in your web browser.

- **Reverting Commits** [[06:28](http://www.youtube.com/watch?v=CPLdltN7wgE&t=388)]
    - Press `t` on a commit to generate a new revert commit.

- **Selective Stashing** [[06:48](http://www.youtube.com/watch?v=CPLdltN7wgE&t=408)]
    - Press `Shift+S` to stash only the changes you have staged, allowing you to keep other working changes intact.

- **Moving Changes Between Old Commits** [[07:24](http://www.youtube.com/watch?v=CPLdltN7wgE&t=444)]
    - Select specific files or lines from a past commit and use `Ctrl+P` to move that "patch" into a different commit.

- **Deleting Content from Past Commits** [[08:35](http://www.youtube.com/watch?v=CPLdltN7wgE&t=515)]
    - Remove specific lines from an old commit via the patch menu; Lazygit manages the rebase and handles any resulting conflicts automatically.

- **Upstream Rebasing** [[09:26](http://www.youtube.com/watch?v=CPLdltN7wgE&t=566)]
    - Press `f` to fetch updates and `r` to rebase your current branch onto the upstream master.

- **Smart Branch Switching** [[10:14](http://www.youtube.com/watch?v=CPLdltN7wgE&t=614)]
    - Switch branches even when you have local changes; the tool will offer to automatically stash and unstash them for you to prevent conflicts.

- **Interface Customization** [[11:12](http://www.youtube.com/watch?v=CPLdltN7wgE&t=672)]
    - Personalize the terminal interface by modifying color themes and other UI settings in the configuration file.

---

