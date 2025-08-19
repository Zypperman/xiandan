# when to use Regex

(from stackexchange)

Don't use regular expressions:

**When there are parsers.**
This doesn't limit to HTML. A simple valid XML cannot be reasonably parsed with a regular expression, even if you know the schema and you know it will never change.

Don't try, for example, to handle C# source code. Parse it instead, to get a meaningful tree structure or the tokens.

More generally, when you have better tools to do your job.
What if you must search for a letter, both small and capital? If you love regular expressions, you'll use them. But isn't it easier/faster/readable to use two searches, one after another? Chances are in most languages you'll achieve better performance and make your code more readable.

For example the sample code in Ingo's answer is a good example when you must not use regular expressions. Just search for foo, then for bar.

When parsing human writing.
A good example is an obscenity filter. Not only it is a bad idea in general to implement it, but you may be tempted to do it using regular expressions, and you'll do it wrong. There are plenty of ways an human can write a word, a number, a sentence and will be understood by another human, but not your regular expression. So instead of catching real obscenity, your regular expression will spend her time hurting other users.

When validating some types of data.
For example, don't validate an e-mail address through a regular expression. In most cases, you'll do it wrong. In a rare case, you'll do it right and finish with a 6 343 characters length coding horror.

When you don't have the right tools or don't care about clean code.
Without the right tools, you will make mistakes. And you will notice them at the last moment, or maybe never. If you don't care about clean code, you'll write a twenty lines string with no comments, no spaces, no newlines.

When your code will be read. And then read again, and again and again, every time by different developers.
