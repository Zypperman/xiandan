# Working with Node.js

(adopted from Mosh programming)

- Node js is meant for using js in a runtime environment outside of the browser.
- Typically used when we want to make the backend for a website.
- Good for highly scalable, data-intensive real-time apps.
- Distinctly good for prototyping and agile dev practices.
- Its fast and flexible to build and has better performance.
- like flask with python, but is even better since both your front and backend use the same language, so same practices can apply.
- Also has access to the largest ecosystems of OSS libraries that you will ever need.

## Setup

- Install both npm and nvm (node package / version manager) on your choice of OS (preferrably linux).
    - It is possible to just install them for windows using `winget` (google what it is).
    - if it doesn't work after you install it, its because your home variables need to be recognised after they are set, so restart your machine and it should be recognisable (do `npm -v` or `nvm -v`).
- Update / get and use the latest version of Node.js.
    - do `nvm install lts` to get the latest version
    - do `nvm use lts` to use the latest version.
- check it works
    - do `node -v` and tally with the official release website for node to make sure you have the right version
    - do `node` to check it actually works on your machine.
        - quit with `.exit`.

## Sources

- [Programming with Mosh | What is Node js](https://youtu.be/uVwtVBpw7RQ?si=YjmiuEn-UwuLiHVl)
