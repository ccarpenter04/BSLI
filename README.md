## BSLI - Bytecode Source Language Identifier
A library that attempts to identify the source code languages that bytecode classes were compiled from.

Pull requests that add support for detecting new source code languages, fix detection methods, and/or improve detection methods are welcome.

### Supported languages
* Java
* Scala
* Groovy
* Kotlin
* Ceylon

### Common uses
* Determining which standard libraries need to be accessible to be analyzed before you begin in depth static analysis.
* Determining which standard libraries need to be on the class path before loading a class to predict/prevent ClassNotFoundExceptions.
* Determining if you're going to be able to get reasonable output from a decompiler by checking if the classes source code language is the target language of the decompiler.
