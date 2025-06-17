# Go's `fmt` Standard Library Tips (and other useful packages)

In general, if unsure, visit the [packages website](https://pkg.go.dev/strings#section-sourcefiles) (this links to the strings package). Non-package docs can be found in laymans terms under the [effective go](https://go.dev/doc/effective_go#functions) doc.
<!-- TODO: Find official docs for go non-package keywords ie `range` -->

## fmt

- `Print`, `Println`, `printf`
    - Printf &#8212; "Print Formatter" this function allows you to format numbers, variables and strings into the first string parameter you give it  
    (ie. `fmt.Printf("%T", FirstName)`)
    - Print &#8212; "Print" This cannot format anything, it simply takes a string and print it
    - Println &#8212; "Print Line" same thing as Print() however it will append a newline character \n at the end.
    Source: [StackOverflow](https://stackoverflow.com/questions/53879154/println-vs-printf-vs-print-in-go)

- printf placeholders
    - syntax: `printf('text with placeholders', references*)`  
        ie. `var word1, word2 string = 'is', 'this'; printf('what %v $%v$', word1,word2)`
    - [Docs can be found here.](https://pkg.go.dev/fmt#hdr-Printing)
    - `%v` &#8212; default value, no change required
    - `%T` &#8212; reference's type

- Type Conversion from Integers to Strings
    - use fmt.Sprintf. Its a function that you ca pass a template string and some variables with the content for replacement.  
        function syntax: `func Sprintf(format string, a ...any) string`
    - alt: if you want to be clean about it, you can import the `strconv` package and do `strconv.Itoa(intValue)`. does the same thing.

## strings

- `Fields()` &#8212; splits your string with white spaces a separator
