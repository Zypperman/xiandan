# Why Go? (not golang)

## TLDR: Modern C thats not C

<div>
<img src='..\..\source\Go\9vx6gy.jpg' alt="bruh skelly">
</div>

## Motivation

- Made by Google in 2007, open-sourced in 2009
- Leverages newer Technologies in parallel computing and computation at scale, ie:
    - multicore processsors
    - cloud infrastructure
    - computation clusters that work in large networks
- Most functionality also you can do multiple things at once, but most languages don't have specific ways to handle this.
- Designed to run on multiple cores and support concurrency
    - Not many languages offer multi-core concurrency support (ie python and node js), while those that do (ie C++ and Java) are complex to maintain, therefore are very expensive and slow to handle (since you're more prone to human error).
    - Syntax for dealing with concurrency is easy in Go (with Go routines and coroutines)
- Syntax is easier like python, so maintaining codebases becomes easier
- Speed and efficiency can be better optimized, like in C++

## Favorable language properties

- Designed for simplicity and efficiency
- statically typed, but has type inference
    - typically variable declaration: `var <var_name> <var_type> = <value>`
    - variable declaration with type inference: `<var_name> := <value>`
    - you also can create multiple variables in 1 line.
- compiles quickly to machine code so it outperforms interpreted languages like python
- Package and module system exists for fast imports and exports (like python)
- in-built hash-maps and arrays
- variables can store pointer addresses but not do arithmetic with them
    - Good because even if you know what you're doing, pointer arithmetic makes your program dangerous (ie you cant figure out where in memory something was changed, so it never gets cleaned and creates a memory leak)
- Concurrency support
    - that means you can do multithreading
        - multithreading &#8594; you can run functions simultaneously by using diff threads in your CPU, so you compute "in parallel" and its faster.
- Fast compile time into a binary that works on different platforms
- Fewer resources are required like CPU and RAM

## Use cases

- high performance server-side apps
    - Google docs, when you have multiple users working on the same doc
    - multiple users booking a system at the same time without double booking
    - Microservices
    - webapps
    - Database services
  
    Basically, situations that requires concurrency for dealing with a large volume of requests to prevent conflict between users, and you need to update the same database.
- Famous projects:
    - Docker
    - Cockroach DB
    - Dgraph
    - Kubernetes
    - HashiCorp Vault
- Apps that run on scaled, distributed systems (where they can best leverage technologies that are enhanced by concurrency)

In general, its a backend tool.

## Sources

- Fireship
    - [Go in 100 seconds](https://youtu.be/446E-r0rXHI?si=SEtF4HNWsdyML0EH)
