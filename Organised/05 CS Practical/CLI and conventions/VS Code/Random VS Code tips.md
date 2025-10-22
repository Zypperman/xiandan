# Random stuff you learned about: <u>VS Code</u>

- make snippets with searchbar > 'configure snippets' > pick your language > use the format:

    ```json
    // in file 'Code/User/snippets/javascript.json'
    {
    "snippet name": {
        "prefix": ["snippet triggers",],
        "body": ["snippet fillers"],
        "description": "what the snippet does"
    },
    }
    ```

    - also to use variables, it follows syntax `$<varname>` ie `$CURRENT_MONTH` returns the month as two digits ('02' for Feb). | [Variable conventions](https://code.visualstudio.com/docs/editing/userdefinedsnippets#_variables) can be found here.

- `ctrl+k , v` - renders preview in markdown in a side window.
    - `ctrl + shift + v` - default functionality renders preview as a new tab.
