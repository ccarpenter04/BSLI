package com.carpenter.bytecode;

/**
 * An enum containing the languages that can currently be identified or are planned to be identified.
 *
 * @author Christopher Carpenter
 */
//TODO Are there any other notable languages to identify?
public enum SourceLanguage {
    JAVA,
    SCALA,
    GROOVY,
    KOTLIN,
    //TODO add identification to BytecodeClass#getSourceLanguage
    CLOJURE,
    JRUBY,
    JYTHON,
    //TODO discover other notable languages
    UNKNOWN
}
