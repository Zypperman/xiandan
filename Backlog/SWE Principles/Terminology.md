# SWE Terminology

- Program  
    - "A collection of data variables and instructions on how to modify these variables"
- Programming language
    - "A formal language that helps programmers specify precisely what the instructions are at a higher level of abstraction"
    - Balance between precision vs efficiency:
        - Few lines for something that works  
        OR  
        Many lines for something performant
- Compiler
- Interpreter

## Object Oriented Programming

- Class &#8212; a user-defined data type.
    - *"A type of thing, what it is"*
    - Can be used as a blueprint for what an entity or concept is
    - Also contains how entities under this type behave and interact.
- Object &#8212; an instance of a Class.
    - *"The thing itself / an example of it"*
    - Most intuitively used to represent real-world objects / abstract entities.
- Method &#8212; functions that an object can perform
    - *"What a thing can do"*
    - defined within the class
    - methods can act in different capacities:
        - Instance methods &#8212; for Interacting with others
            - dealing with instance-specific data
            - ie. attributes you set when you create a new object (`triangle = shape(3,length=4)`)
        - Class methods &#8212; for Interacting with yourself
            - dealing with class data ie class attributes (values that every object starts with)
                - ie a Bank Class where its' objects represent banks in a town, theres a rule that all banks should have the same base interest rate as a class attribute. Class methods will manipulate that class attribute.
                - ie the same bank class, you have a function that can create a bank instance in a different way (ie `Bank.fromstring('some_string')`)
        - Static methods &#8212; Interacting with yourself (structure as class methods)
            - can work independent of class state
            - basically a function that could exist outside your class, but makes sense to keep in your class since you only need it for that class.
            - ie. calculating interest in a bank class, when your software revolves around a game and you will only ever need the function to calculate interest when banks are involved.
    - can apply to either the class or the object (termed "class methods" and "instance methods")
        - ie. With Students from a school (where students are objects in a student class and school)
- Attributes &#8212; describe the state of an object
    - *"Information about a thing"*

## OOP Concepts

- Reflection &#8212; where you can access and change any information about objects you've created.
    - more relevant when compiling your project takes a while, so being able to inspect and edit aspects of your program at runtime instead of needing to recompile your instance is good.
    - some languages that can do this are python, Go, C# and Java.
    - a good example is python OOP which has no real concept of public or private information, except by syntax (where devs just mark private information by doing [name mangling](https://www.geeksforgeeks.org/python/name-mangling-in-python/)):

        ```python
        class Student:
            def __init__(self, name):
                self.__name = name # name mangled attribute
            
            def getName(self):
                return self.__name
            def __updateName(self,newName): # name mangled method
                self.__name = newName
                
            def updateName(self):
                newName = input("what is your new name?")
                self.__updateName(newName)
                print(f"Name Updated! New name is {newName}")

            
        s1 = Student("Santhosh")
        print(s1.getName())
        s1.updateName()
        print(s1.getName())
        print(dir(s1))
        """Output:
        Santhosh
        what is your new name?Daisy
        Name Updated! New name is Daisy
        Daisy
        ['_Student__name', '_Student__updateName', '__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__getstate__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'getName', 'updateName']
        """
        ```

        Name mangling:

        - when you declare an attribute and want it to be private, you can add 2 underscores in front of it to make its name weirder (formats into `_<class>__<name>`)
        - works with both attributes and methods.
        - but as long as you know this syntax, you can still edit stuff at runtime.
    - Java uses the package `java.lang.reflect` ([Docs here](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html)).

## Sources

- Real Python's [Python OOP method walkthrough](https://realpython.com/instance-class-and-static-methods-demystified/)
- Ryan Parsa on LinkedIn: [Static Method vs Class Method vs Instance Method in Python 3](https://www.linkedin.com/pulse/static-method-vs-class-instance-python-3-ryan-parsa-kvgdc)
