# `man` Page Controls

Man pages (short for manual pages) are the lifeblood of Linux terminal mastery. Think of them as the "RTFM" source code for every command on your system.

Here is a streamlined cheatsheet to help you navigate them like a pro.

---

## 01 Opening & Searching

To view a manual, use `man <command_name>`.

| Command | Action |
| --- | --- |
| `man ls` | Opens the manual for the `ls` command. |
| `man -k [keyword]` | Searches all man pages for a specific keyword (useful if you forgot the command name). and basically uses `apropos` |
| `man [section] [command]` | Opens a command from a specific section (e.g., `man 5 passwd` for the config file, not the command). |

---

## 02 Navigation

Most systems use `less` to display man pages, so these shortcuts are standard:

### Moving Around (actually follows vim commands)

* **`Space`** / **`f`**: Page down (forward).
* **`b`**: Page up (backward).
* **`d`**: Half-page down.
* **`u`**: Half-page up.
* **`j`** / **`Enter`**: Move down one line.
* **`k`**: Move up one line.
* **`g`**: Go to the very top.
* **`G`**: Go to the very bottom.

### Searching Within a Page

* **`/pattern`**: Search forward for "pattern".
* **`?pattern`**: Search backward for "pattern".
* **`n`**: Find the next occurrence of the search.
* **`N`**: Find the previous occurrence.

---

## Understanding the Sections

Actually the Man pages is more like the full manual, and you do `man command` to jump to that section.

If you see a reference like `chmod(1)`, the number in parentheses refers to the section of the manual:

1. **Section 1**: Executable programs or shell commands.
2. **Section 2**: System calls (functions provided by the kernel).
3. **Section 3**: Library calls (functions within program libraries).
4. **Section 4**: Special files (usually found in `/dev`).
5. **Section 5**: File formats and conventions (e.g., `/etc/passwd`).
6. **Section 8**: System administration commands (usually for root).

---

Sometimes a command name exists in multiple places (e.g., `passwd` is a command and a file). Specify the section to get the right one: `man [section] [command]`.

| Section | Content Type | Examples |
| --- | --- | --- |
| **1** | User Commands | `ls`, `grep`, `ssh` |
| **2** | System Calls | `open`, `read` |
| **5** | File Formats / Configs | `/etc/passwd`, `/etc/hosts` |
| **8** | Admin Commands | `iptables`, `fdisk`, `reboot` |

### How to interpret the synopsis part

* **`bold text`**: Type exactly as shown.
* **`[ option ]`**: Items inside brackets are **optional**.
* **`variable`**: Replace with your specific value (e.g., a filename).
* **`|`**: A pipe means "OR" (choose one of the options).
* **`...`**: You can repeat this argument multiple times.

i.e `*man* [man options] [[section] page ...] ...`

## Exiting

* **`q`**: Quit the man page and return to the terminal.

> **Pro Tip:** If you find the default man page view too "dense," try running `man [command] | col -b > command.txt` to export it to a clean text file you can read in a GUI editor.

---

## Manual Sections

Sometimes a command name exists in multiple places (e.g., `passwd` is a command and a file). Specify the section to get the right one: `man [section] [command]`.

| Section | Content Type | Examples |
| --- | --- | --- |
| **1** | User Commands | `ls`, `grep`, `ssh` |
| **2** | System Calls | `open`, `read` |
| **5** | File Formats / Configs | `/etc/passwd`, `/etc/hosts` |
| **8** | Admin Commands | `iptables`, `fdisk`, `reboot` |

## Reading the Synopsis

When looking at the **SYNOPSIS** header, the syntax tells you how to structure your command:

* **`bold text`**: Type exactly as shown.
* **`[ option ]`**: Items inside brackets are **optional**.
* **`variable`**: Replace with your specific value (e.g., a filename).
* **`|`**: A pipe means "OR" (choose one of the options).
* **`...`**: You can repeat this argument multiple times.

## `apropos` - what it do baby

Think of `apropos` as the **search engine** for your terminal's documentation.

While `man` opens a specific manual you already know the name of, `apropos` helps you find the right command when you only know *what* you want to do. It searches the short descriptions at the top of every man page on your system for a specific keyword.

---

### `apropos` usage

| Command | Action |
| --- | --- |
| `apropos partition` | Lists every command related to "partition." |
| `apropos "network interface"` | Searches for a multi-word phrase (use quotes). |
| `apropos -s 8 firewall` | Searches for "firewall" only in **Section 8** (Admin commands). |
| `man -k [keyword]` | This is exactly the same as running `apropos`. |

### 🛠️ Example Output

If you forgot how to zip a file, you might run:
`apropos compress`

The output would look something like this:

* **bzip2 (1)** - a block-sorting file compressor, v1.0.8
* **gzip (1)** - compress or expand files
* **zip (1)** - package and compress (archive) files

---

### 💡 Pro Tip: Keeping it Updated

`apropos` relies on a local database (usually called `mandb`). If you just installed a new tool and `apropos` can't find it, you can manually update the index by running:

```bash
sudo mandb

```

---

## Powershell documentation

PowerShell has `Get-Help` and `Get-Command`. Arguably more "discoverable" because it follows a very strict **Verb-Noun** naming convention.

| Linux / Man | PowerShell | Purpose |
| --- | --- | --- |
| `man <command>` | `Get-Help <command>` | View the manual for a specific cmdlet. |
| `apropos <keyword>` | `Get-Help *keyword*` | Search for commands related to a topic. |
| `man -k <keyword>` | `Get-Command *keyword*` | List all commands matching a pattern. |

---

### 1. Finding Commands (`Get-Command`)

Since PowerShell commands are always `Verb-Noun`, you can search by either part:

* `Get-Command *Network*`: Finds everything related to networking.
* `Get-Command -Verb Get`: Lists every command that "retrieves" data.
* `Get-Command -Noun Service`: Lists every command that interacts with system services.

### 2. Viewing Documentation (`Get-Help`)

PowerShell documentation is broken into "views" so you don't get overwhelmed:

* `Get-Help <command> -Examples`: **The most useful one.** Shows real-use cases.
* `Get-Help <command> -Detailed`: Shows parameter descriptions and examples.
* `Get-Help <command> -Full`: Shows everything (all parameters, technical notes, etc.).
* `Get-Help <command> -Online`: Opens the latest Microsoft documentation in your web browser.

### 3. Conceptual Help (`about_`)

Linux has "Sections" (1, 5, 8). PowerShell has **About Topics**. These cover general concepts like loops, variables, or security:

* `Get-Help about_Variables`
* `Get-Help about_Execution_Policies`

---

## updating docs with `Update-Help`

Unlike Linux, where man pages usually ship with the package, Windows often requires you to download the latest help files manually. If `Get-Help` gives you a tiny, useless summary, run this in an **Administrator** terminal:

```powershell
Update-Help -Force
```

Also for powershell, the command to get documentation is `Get-Help` and is aliased withk `man` and `help`.
