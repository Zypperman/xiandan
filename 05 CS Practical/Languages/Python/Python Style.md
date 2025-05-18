# Python style

## TLDR

To Start, get Flake8, Mypy, Black Formatter and Docstring. 

After that, Radon, Pyroma, and docformatter.

Install from VS Code plugins.

## Terminology

Python's style and linting follows PEP-8.

- PEP &#8212; "Python Enhancement Proposals"
    - Proposal 8 / PEP-8 &#8212; refers to the "Style Guide for Python Code".
    - Actual style guide found [here](https://peps.python.org/pep-0008/).

- Lazy way out is just to get a python linter plugin.
    - [Here's an article breaking down linting in python](https://inventwithpython.com/blog/2022/11/19/python-linter-comparison-2022-pylint-vs-pyflakes-vs-flake8-vs-autopep8-vs-bandit-vs-prospector-vs-pylama-vs-pyroma-vs-black-vs-mypy-vs-radon-vs-mccabe/), but TLDR:
        - **Flake8** for Error and style linting
        - **Mypy** for Type checking
            - You can use in tandem with Pydantic, which checks types more accurately. ( Lore: [Docs](https://docs.pydantic.dev/latest/integrations/mypy/) )
            - 