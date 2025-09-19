# Node.js

## What it is

- javascript actually is a front-end language, where if you want to do stuff in the browser you can write logic with it. Backend woulda been something like PHP.
- However, it became a good idea to make everything JS, both front and backend, so Node.js is one such tool that acts like a backend engine for running tools.

## How to use in my project

### Installation

- depends on your version, but first check if you have it from your terminal:

    ```powershell
    node -v
    ```

    This should give the version of your node installation, but otherwise just install it from this website.

- After this, you need npm and nvm &#8212; node package/ version manager respectively, like pip for python to install stuff. By right, it should have been installed with node, so check with this command:

    ```powershell
    npm -v; nvm -v
    ```

    And if its not there, just google and install it for your machine.

## Implementation

- make a file named 'index.js' in your working directory
- Run it with:

    ```powershell
    node index.js
    ```

    And alternatively, it works if you do `node .`, but this only works if the main file running your script is named `index.js`.

## Runtime Keywords

- running node on your machine is different from running it on a webserver, because there are some keywords with some functionality:
    - console &#8212; for interacting with terminal I/O
    - global &#8212; for making certain variables accessible to the entire runtime

![Runtime structure](https://pbs.twimg.com/media/Bt5ywJrIEAAKJQt?format=jpg&name=large)

## Managing packages and versions

- done using npm, do `npm init --yes` in your package folder to generate a `package.json` file that basically represents a register of what packages your repostory needs. ([resources here](https://docs.npmjs.com/creating-a-package-json-file))

- Ultimately, edits your list of installed packages are recorded under the `packages-lock.json`. [Just read this for a better sense of how to use this.](https://docs.npmjs.com/cli/v11/configuring-npm/package-lock-json).

## Sources

- Fireship &#8212; [Node.js Ultimate Beginner’s Guide in 7 Easy Steps](https://youtu.be/ENrzD9HAZK4?si=GTKPgpJPZ1rrmSAb)
