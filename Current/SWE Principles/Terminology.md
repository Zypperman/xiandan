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
    - *"What a thing is and what it does"*
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
        - Interacting with yourself (structure as class methods)
            - can work independent of class state
            - basically a function that could exist outside your class, but makes sense to keep in your class since you only need it for that class.
            - ie. calculating interest in a bank class, when your software revolves around a game and you will only ever need the function to calculate interest when banks are involved.
    - can apply to either the class or the object (termed "class methods" and "instance methods")
        - ie. With Students from a school (where students are objects in a student class and school)
- Attributes &#8212; describe the state of an object
    - *"Information about a thing"*

## Sources

- Real Python's [Python OOP method walkthrough](https://realpython.com/instance-class-and-static-methods-demystified/)
- Ryan Parsa on LinkedIn: [Static Method vs Class Method vs Instance Method in Python 3](https://www.linkedin.com/pulse/static-method-vs-class-instance-python-3-ryan-parsa-kvgdc)
