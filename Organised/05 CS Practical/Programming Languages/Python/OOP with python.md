# OOP with Python

## Interfaces

- [Real Python](https://realpython.com/python-interface/#formal-interfaces)
    - create interface classes by inheriting from `metaclass=abc.ABCMeta`.
    - together with the `__subclasshook__` method you can enforce membership by using functions to check whether the class meets the requirements to be recognised by the interface. (ie by using `hasattr` and `callable` to check for attributes and functions respectively)
-
