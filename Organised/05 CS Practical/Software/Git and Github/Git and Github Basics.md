# Git / Github Basics

## Preface

Git is a way to handle version control for code you write.  
Github is just where you do this with other people, alongside other cool stuff like automated testing that you see with continuous Integration and Development (CI/CD).  

- frankly its just one of many collaboration tools, you got gitlab, codeberg and more that effectively do the same thing.

Each projects is managed with Git by creating a repository, where a hidden `git` folder will be created in your project folder. This folder contains everything it needs for internal tracking and versioning.

This `.git` folder represents the state of your project's version management.

### Important features

- Git
    - every change is tracked and checkpoints are added to each save, so you can access previous versions of your codebase
    - Every checkpoint can be uniquely identified and your codebase can be restored to that state, and users can add documentation at each checkpoint
    - progress can be restored quickly
- Github
    - changes can be uploaded online where you can collaborate with others
    - different ways to set up and develop stuff
    - everyone can work on their own version and add to the main working version, but still have as few conflicts as possible.

## Important stuff

- Make sure to private your email address on the email settings page

    ![GitHub Settings page showing Email visibility options.](https://raw.githubusercontent.com/TheOdinProject/curriculum/725b80d126105d2f717697f97e7eaefb5f886c7b/foundations/installations/setting_up_git/imgs/01.png)

- you can also set up 2FA but its a bit messy.

- open the git bash program on windows or literally just type git into your terminal (for non windows) and set up some configs:

    ```sh
    # your github login details
    git config --global user.name "Your Name"
    git config --global user.email yourname@example.com

    # name based on github's default branch, which has the name "main"
    git config --global init.defaultBranch main 
    
    # This setting makes it such that if there are conflicts, github merges your branch instead of rebasing it and making it the new norm, where you cant properly revert any commits prior  
    git config --global pull.rebase false

    # For mac users, make sure to ignore DS_store files that just store file positions on your desktop
    echo .DS_Store >> ~/.gitignore_global
    git config --global core.excludesfile ~/.gitignore_global

    # for making sure your commit messages don't get missed
    git config --global core.editor "code --wait"
    ```

- secure your account with SSH keys
    - SSH &#8212; "Secure Shell" is like a login key that authenticates your machine so you can just work with your repo without needing to relogin all the time. Its a form of asymmetric cryptography where its easy to create a "lock", but not easy to recreate the input parameters for making the lock.

    - just follow the [odin project's guide](https://www.theodinproject.com/lessons/foundations-setting-up-git#step-23-create-an-ssh-key) to check if you have an existing SSH key (and generate it if you dont) then link it to your github and check that it works.

## Git commands and orientation

### Making a github repository

The main homepage has a plus icon, from there it should guide you on some initialization stuff like whether you want the repo to be public or private, what kind of license you want on it for distribution and whether you need a preset readme or gitignore file (to indicate the files that have changes, but don't need to be tracked).

Note that this creates a remote repository under your name.

### Making it safe

1. Make sure that you've set up merge rules, like that no one can self approve their own PRs.

### connecting this repo

From your repo page, press the green code button to see a few different ways to access your code:

1. via HTTP requests
    - gives you a link to work with.
    - on your machine, open the directory that you want to set up your codebase, then do `git clone <link>` to copy the code base in.
2. via SSH
    - if you already have an established SSH connection between your account with your machine, using the SSH version of the code just saves you authentication.
3. Code spaces
    - if you're lazy to open an entire repo, you can just set up a VM in the cloud and work on it there. Good for small changes.

### checking it all works

- just navigate into the project folder and do 'git remote -v' to see all connections.
    - [here's git's docs for what `git remote` does](https://git-scm.com/docs/git-remote)
    - if its a fresh and new git repo, this returns:

        ```sh
        origin  git@github.com:USER-NAME:git_test.git (fetch)
        origin  git@github.com:USER-NAME:git_test.git (push) 
        ```

        The `origin` label is just a default name for the branches, they can be edited and straightened out later.

### Workflow

1. add and edit files in your tracked codebase
2. do `git status` to check what files have been changed thus far
3. do `git add <file>` for all the files listed from step 2
4. do `git commit -m <message>` to create a savepoint for all changes thus far, and give it a message to document what was edited
5. To send your code to your remote repo on github, do `git push origin main`.
    - the `origin` is just the label you give to the main branch, and it adopts this as the default.
    - the alternative line `git push` only works if you ae not dealing with other lines.

## Best practices

Make atomic commits &#8212; each commit should be a checkpoint for  each single feature or task in your project. This makes reverting features easy since they won't conflict with each other.

### Commit message conventions

structure your commits (within 72 characters) with:

```txt
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

- Type &#8212; categories for your change, from a selection of words (ie. fix, feat, build, chore, ci, docs, style, refactor, test)
- scope &#8212; a noun describing the context for the change
    - indicate here whether breaking changes are present with `!` (ie. `feat(api)!: send an email to the customer when a product is shipped`)
    - otherwise just add it in the footer.
- description &#8212; written in the imperative (pretend its present tense even though you did it in the past)
- optional body &#8212; add detail to changes ie reason + implementation quirks, but dont use them unless you need them
- optional footer &#8212; more for using with an issue tracker, but outlines meta-information like design patterns, breaking changes or mentioning other collaborators.

Best to read from the article [conventionalCommits](https://www.conventionalcommits.org/en/v1.0.0/) and this [github cheatsheet](https://gist.github.com/qoomon/5dfcdf8eec66a051ecd85625518cfd13) (and if that still isn't enough, [this video should help, and even covers how to automate your commits](https://youtu.be/OJqUWvmf4gg?si=tWCoEpu767a99fBa&t=40)).

Conventional Commits is also a good way to:

- compare projects and familiarize yourself with the latest changes (since most of them use the same format ie. Vue, angular)
- generate test logs since the format is standardised
- make it easier for collaboration and coming back to after taking a break

## Sources

- [For the Odin Project](https://www.theodinproject.com/lessons/foundations-setting-up-git)
    - [SSH Key pairs](https://winscp.net/eng/docs/ssh_keys)
    - [what asymmetric encryption is](https://www.youtube.com/watch?v=AQDCe585Lnc)
