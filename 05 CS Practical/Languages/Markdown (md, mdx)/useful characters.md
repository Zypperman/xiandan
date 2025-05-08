# Useful characters and snippets

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

---

## Alerts

Aka callouts (in obsidian and Notion).

```markdown
> [!NOTE]
> Useful information that users should know, even when skimming content.  
---
> [!TIP]
> Helpful advice for doing things better or more easily.
---
> [!IMPORTANT]
> Key information users need to know to achieve their goal.
---
> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.
---
> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.
```

renders:
  
> [!NOTE]
> Useful information that users should know, even when skimming content.  
---
> [!TIP]
> Helpful advice for doing things better or more easily.
---
> [!IMPORTANT]
> Key information users need to know to achieve their goal.
---
> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.
---
> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.

But note that there is a linting requirement (MD028) where two alerts cant exactly be together, because some parsers (that render your markdown) will treat two blockquotes separated by one or more blank lines as the same blockquote, while others will treat them as separate blockquotes. (see [documentation on MD028](https://github.com/DavidAnson/markdownlint/blob/main/doc/md028.md))

Github representation context can be found [here](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#alerts).
