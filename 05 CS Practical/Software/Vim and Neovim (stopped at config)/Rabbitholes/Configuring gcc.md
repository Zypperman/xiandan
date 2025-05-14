# Configuring Language servers

Just to install luals I had to:
- figure out what ninja was
    - apparently its a build system so you can do `ninja <command>` if you set it up right
        - you're supposd to download stuff from repos meant for users from the `releases` tab, and just get the latest installation
    - after downloading, just unzip and throw the .exe file somewhere you'll prolly never touch, then add it to your PATH under your environmental variables to use.
- figure out how to check my version of C++
    - by that, people mean the standard of C++ which your compilers use like clangd and gcc so check for that i guess
        - download msys2 and open the shell for it
        - intsall mingw with `pacman -S --needed base-devel mingw-w64-ucrt-x86_64-toolchain`
        - run `pacman -Suy` to update whatever's in it if you have it already
        - update the package list by running this command from the msys2 shell: `mingw-get update`
        - then run `mingw-get upgrade` to implement changes
        - 
