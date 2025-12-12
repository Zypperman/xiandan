# Vim help

## the `:help` command

- in general, doing `:help` accesses the online manual.
    - or press the `<F1>` key to open the general help page for `:help`

## Config stuff

so apparently you can set up your config with:

```txt
:call mkdir(stdpath('config'),'p')
:exe 'edit' stdpath('config'),,`/init.vim`
```

but ideally make your changes with init.lua which is a better language in general cuz of its community support.

