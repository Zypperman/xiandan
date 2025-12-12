# Test Driven development with Python

Conventionally, most people write tests with either:

- Pytest &#8212; industry recognised, but ultimately not maintained as part of the core package
    - known for its simplicity, scalability, and powerful features such as fixture support and parameterization
    - concise syntax and a rich plugin ecosystem
    - offers advantages like automatic test discovery, skip/xfail tests, and powerful assertion introspection
    - supports parallel test execution and offers easy mocking and patching.
    - However, it is not part of the Python Standard Library and may have a moderate learning curve for beginners
- unittest &#8212; maintained and shipped with python itself, but clunky
    - built-in testing framework that follows the xUnit style
    - has features such as test discovery, fixture support and consistent test isolation
    - more vebose and limited testing parts i.e. theres limited parameterization support
- Ultimately just go with what works best and what your project team uses.
- if not for convenience just use pytest.

## Annoying imports: how to drag  your  functions into  your test  folder for testing

> [!important] Sources
>
> - From [g4g](https://www.geeksforgeeks.org/python/python-import-module-outside-directory/).

### Basic Method: `__init__.py`

- you can  use  an `__init__.py` file to  trick python into treating the folder with ll your tests  for your module as a package, which then  lets you use imports.

## Sources

- [Tech With Tim: Please Learn How To Write Tests in Python… • Pytest Tutorial](https://youtu.be/EgpLj86ZHFQ?si=VCZs7dzEBzwirBqK)
- [Pytest docs](https://docs.pytest.org/en/stable/)
- [unittest docs](https://docs.python.org/3/library/unittest.html)
