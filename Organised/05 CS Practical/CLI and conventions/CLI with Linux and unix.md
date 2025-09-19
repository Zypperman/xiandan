# CLI with Linux

- CLI : Command line interface
    - the terminal window where you enter commands and stuff will happen.

## random trivia (from Odinproject)

The window that opens will be mostly blank, with the exception of some text that will vary based on your operating system. On Linux and older Macs, the line will end with `$` and on newer Macs, the line will end with `%`. This symbol - called the prompt - indicates that the terminal is waiting for you to enter a command.

---

`apt`  advanced package tool, basically a package manager.

- learn more from the [wiki](https://en.wikipedia.org/wiki/APT_(software))
- wsl users use `wget`
- powershell users use `winget`

## Cool commands

- `whoami` - returns your username
- `sudo` - to indicate whatever you're doing uses admin rights
    - "substitute user DO"
- `help`- summary of commands
    - ie `help ls`
        - `d` ie `help -d ls` for shorter info
        - `s` ie `help -s ls` for syntax only
        - `m` ie `help -m ls` for the manual format
    - alternative: `ls --help`, prints a short message.
- `info [command]`
- `man [command]` for full documentation
    - ie. `man ls`
    - type "/<str_pattern>" to find specific words.
- `clear` clears your terminal. alternatively, do `CTRL + L`.
- `CTRL + C` quits your terminal.
- `wc [file]` returns the lines, words and charas in a text file.
    - Setting the file to a general search like regex ie with `*` gives you more options, and returns a list of files that match eht regex pattern.
    - the l,w and c options show lines, words and characters only.

- `cat` just shows the contents of a file, chain with multiple filepaths to see all of it in succession.
- `diff` &#8212; used to compare the contents of 2 files.

---

Autocomplete with `tab`, if it doesnt work type more, else double-tap to see possible completion results

## File Navigation

CLI command structure: `$ [command] -[options] [args]`

commands:

- `ls` - lists what you have in your current directory
    - options: modify your view of files listed
    - args : what directory you wanna see.
- `pwd` - returns the directory that your CLI is currently focussed on
    - by default you start in your home directory, or wherever you set your environment variable `$HOME` as.
- `cd` - change directory into a file with relative or absolute filepaths
    - `cd` on its own brings you to the home directory
    - `~` is used to refer to the home directory also.
    - `cd -` is used like a back button. Not the same as `cd ..` which brings you to the parent directory

## File editing and more navigation

- `mkdir` makes folders
- `touch` makes files
    - `nano` to edit them, nano is a low level text editor
    - write to the file with `CTRL + O`
    - looks like:
        ![editor](https://swcarpentry.github.io/shell-novice/fig/nano-screenshot.png)
- `rm` to delete files
    - `rm -rf` to delete directories recursively.
- `mv [original obj] [new location]` to move files
    - also can be used to rename files
- `cp [original obj] [new name]` copies object to new name
    - good for backing up data
    - copy recursively with the `r` option
- `which` &#8212; follow with a command  for a program as an arg to see what executable gets run
- `where` &#8212; shows all locations where a program is installed. Important for containerization.
- `find` &#8212; for finding files, usage is `find <dir> -name '<str_pattern>'`
- `open` &#8212; opens the directory in your file explorer program (or whatever GUI program you have to find stuff.)
-`alias` &#8212; set a custom keyword to run a command or a script.
    - usage: `alias [option] [alias]='[command-or-path]'`, but just note its temporary.
- `>` after a command lets you log the output to a filepath, but will overwrite its contents.
    - `<` does the opposite and is used when you want to redirect the contents of a file into your output.
- using `>>` after a command concatonates the output to the end of a filepath.
- `cut` removes certain sections of each lne in the file, with a `tab` delimiter.
    - option `d` is for using a custom delimiter
    - option `f` is for specifying a column of data to extract from
- `head` and `tail` &#8212; get the first or last 10 lines of a file, pass the file name as an arg. (ie. `$ head sonnets.txt`)
- `less` &#8212; call with a file as an arg, gives a ui for reading your text interactively.
    - `spacebar/CTRL + F/B` to navigate, `q` to quit.
    - include `/<keyword>` to search for specific words, `n/N` to navigate back and forth, `G/1G` to go back 1 line or to the beginning.
- `more` &#8212; gives you a ui to work with for viewing large documents.

### intermediate file IO: File perms

#### reading file perms

- use `ls -l <filename>` to read file permissions
    - formatted as <user_perms><group_perms><other_user_perms>
    - each perm segment is split into `rwx`: read, write and execute rights. if a perm has `-` for a perm, it means it doesn't have that perm.
    - you can also represent these states with 0-7, where r=4, w=2 and x=1 and the perm is a computed sum.

- `chmod <perm_pattern> <file>` &#8212; edit file perms.
    - perm pattern can come in the form of:
        - for 1 group = `o-w`
        - for all groups with number notation = `666` (all users have read and write perms)

## Wildcards (kinda like regex)

- \* is a wildcard, which represents zero or more other characters. Let’s consider the shell-lesson-data/exercise-data/alkanes directory: *.pdb represents ethane.pdb, propane.pdb, and every file that ends with ‘.pdb’. On the other hand, p*.pdb only represents pentane.pdb and propane.pdb, because the ‘p’ at the front can only represent filenames that begin with the letter ‘p’.

- ? is also a wildcard, but it represents exactly one character. So ?ethane.pdb could represent methane.pdb whereas *ethane.pdb represents both ethane.pdb and methane.pdb.

## Cool shortcuts

- ``
- `CTRL A` &#8212; jump to start of line
- `CTRL E` &#8212; jump to end of line
- `CTRL U` &#8212; delete everything
- `CTRL D` &#8212; exit terminal and logs out.
- `CTRL R` &#8212; "reverse search", Recall the last command matching the characters you provide, use again to navigate through the matching commands
- hold shift for windows, hold option for mac, use mouse to click whatever you want and insert stuff. Release button only after you're done editing.

### (From NUS CS2030s)

- `CTRL D` &#8212; if your program requests for input, use this to denote the end of your input. its also how you exit from a shell (by telling it you don't have any more commands for it)
- `CTRL Z` &#8212; suspend the current running program. This pauses the execution of the program (but not terminates it). In the bash shell, the most recently suspended program can resume executing in the background with the command `bg` or be brought back to execution in the foreground again with the command `fg`.
- `CTRL S` &#8212; freeze the terminal.
- `CTRL Q` &#8212; resumes the terminal.

## Intermediate features

- `curl` &#8212; a unix-specific feature that lets you interact with URLs in a CLI.
- `!` (termed 'bang') &#8212; uses a previously called command.
    - chain in 1 command to use the direct previous command.
    - you can also just vaguely concat to the end of a command with what you think the previous command looked like, be it file interactions or the command itself ie:
        - `!!` (straight up use the last command)
            - really good for cases like when you didn't know u need `sudo` perms, sometimes commands need to be called twice, etc (like `curl` sometimes)
        - `!l` (to find previously called ls)
        - `!?file.txt` (to find command with filename)
        - `!7` (call the 7th command you used since terminal window opened)
        - `!-5` (call the 5th command you last used)
    - [more found here.](https://www.redhat.com/en/blog/bash-bang-commands)
- `history` &#8212; shows the last few commands called.
- `sort` in a file contents, sorts lines in a file by alphanumeric order. (numbers before letters, lower and upper case are mixed ie aAbBcC)
    - indicate option `n` to sort by number.

- `uniq` &#8212; gets the unique results, and can get basic statistics about it.
    - option `c` returns each entry with a frequency count.

### grep (global regular expression print)

- `grep <str_pattern> <file>` Used to find a string pattern in a file.
    - case sensitive.

### pipes

- `|` &#8212; for chaining commands onto an output.
    - The L way of doing stuff: redirecting to a new file to store your output and dealing with it

        ```bash
        head sonnets.txt > sonnets_head.txt 
        wc sonnets_head.txt 
        ```

    - The W way of doing stuff: letting linux handle it with pipes and work on the buffer with `$ head sonnets.txt | wc`

- note, if you just want to call commands that aren't related to each other, just do `cmd1 ; cmd2`.

---

- `ps aux` &#8212; see all processes running on your system ("process status")
    - can pipe with grep to find processes by name
- `kill` terminates processes by arg
    - use options `15` cuz thats linux's trminate code
    - refer to processes by PID (process id), sample output looks like:

        ```bash
        USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
        root           1  0.0  0.1 165976 10832 ?        Ss   11:07   0:01 /sbin/init
        root           2  0.0  0.0   3060  1760 ?        Sl   11:07   0:00 /init
        ```

- `pkill -15 -f <str_pattern>` &#8212; does the above 2 together.

- `top` &#8212; shows processes sorted.

## Loops

```bash
$ for filename in basilisk.dat minotaur.dat unicorn.dat
> do
>     echo $filename
>     head -n 2 $filename | tail -n 1
> done
```

- iterable is defined manually and space-separated.  
- Files that contain spaces need to be double-quoted.  
- commonly reused with the `history` command if you can allow for it.
- But at this point, just look up bash syntax.

## Installation stuff

- `$ ./configure ; make ; make install` &#8212;
    - too much to explain, [see here](https://thoughtbot.com/blog/the-magic-behind-configure-make-make-install) but tldr:
        - the 'configure' dir in a project is used to set up the environment for code to run and set up stuff, so we run `./configure`
        - `make` looks at the makefile in your project to build it and runs stuff in order (usually looks like bash script)
        - `make install` &#8212; preps all files that have been created to be moved to their correct and final locations in your machine ie manuals and documentation.
    - alt version: `$ ./configure && make && make install`
        - technically safer since they each only runs if the previous succeeds.

## Cheatsheets

- <https://cht.sh> ([Original repo](https://github.com/chubin/cheat.sh))
    - even works from CURL so you can use it with the terminal
        - just do `curl cht.sh` ([more on usage](https://github.com/chubin/cheat.sh?tab=readme-ov-file#usage) cuz theres a lot of syntax to it)
    - community driven so you know its good
- <https://linuxblog.io/90-linux-commands-frequently-used-by-linux-sysadmins/>
- <https://ss64.com/bash/>

## Sources

- <https://explainshell.com/>
- <https://swcarpentry.github.io/shell-novice/>
- <https://www.learnenough.com/command-line-tutorial>
    - book recommended by odin proj, its pretty short
- <https://developers.redhat.com/cheat-sheets/advanced-linux-commands?intcmp=701f20000012ngPAAQ&utm_name=inlinelinuxcheatshee&_gl=1*o64goq*_gcl_au*MTE4MTA3ODgwNS4xNzQ3Mzc5ODgy>
    - redhats' linux cheatsheet, the place to learn cybersec.
- <https://learnxinyminutes.com/bash/>
    - for writing bash script, which is what you use to script linux commands.
    - theyre known as Bourne Again SHell (bash)
    - file extension is `.sh` cuz shell, use `nano <file>` for quick script editing.
    - call the script with `bash <script_file>.sh <target_file>`
