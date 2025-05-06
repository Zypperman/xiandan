# Useful characters

- Markdown lets you represent symbols in unicode.

| name |character | unicode |
| ----------- |----------- |----------- |
|left arrow| ←| `&#8592;`  |
|upward arrow| ↑| `&#8593;`  |
|right arrow| →| `&#8594;`  |
|downward arrow| ↓| `&#8595;`|
|en dash| &#8211;| `&#8211;`|
|em dash| &#8212;| `&#8212;`|

Other unicode reprsentations can be found [here](https://www.ssec.wisc.edu/~tomw/java/unicode.html).

add them to your snippets with this:

```json
    "endash": {
        "prefix": [
            "en-"
        ],
        "body": [
            "&#8211;${0}",
        ],
        "description": "endash."
    },
```
