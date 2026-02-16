# Useful Powershell commands

- `where <executable>` &#8594; tells you where all instances of executables with a specific name are in your com ie. `where java`
    - the order of files from top to bottom is also the order that your system checks whether your code runs.
    - helps with checking what version of your language or package exists, and why theyre running first. (if you want to change this order just reorder your PATH variable under your environment variables.)

- `Get-Alias` &#8211; gets a list of the shorter version of some commands that u can use instead to call these commands.

## linux `cd`-ing

- with `cd` you can do `cd -` to go back to the previous filepath.

## finding stuff

- for linux, we find documents with `find <folder_path> -name "<filename>"`
- for powershell: `Get-ChildItem -Path ".\" -Filter "filename.txt" -File`
