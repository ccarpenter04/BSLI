package com.carpenter.bytecode.hierachy;

import com.carpenter.bytecode.SourceCodeLanguage;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * A simple wrapper around asm's ClassNode object
 *
 * @author Christopher Carpenter
 */
public class BytecodeClass {
    private final ClassNode asm;
    private SourceCodeLanguage language;

    public BytecodeClass(ClassNode asm) {
        this.asm = asm;
    }

    /**
     * Gets the ClassNode that is being analysed.
     */
    public ClassNode asm() {
        return asm;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isPublic() {
        return (asm.access & Opcodes.ACC_PUBLIC) == Opcodes.ACC_PUBLIC;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isProtected() {
        return (asm.access & Opcodes.ACC_PROTECTED) == Opcodes.ACC_PROTECTED;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isPrivate() {
        return (asm.access & Opcodes.ACC_PRIVATE) == Opcodes.ACC_PRIVATE;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isPackageLocal() {
        return !isPublic() && !isProtected() && !isPrivate();
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isEnum() {
        return (asm.access & Opcodes.ACC_ENUM) == Opcodes.ACC_ENUM;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isInterface() {
        return (asm.access & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isAnnotation() {
        return (asm.access & Opcodes.ACC_ANNOTATION) == Opcodes.ACC_ANNOTATION;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isFinal() {
        return (asm.access & Opcodes.ACC_FINAL) == Opcodes.ACC_FINAL;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isAbstract() {
        return (asm.access & Opcodes.ACC_ABSTRACT) == Opcodes.ACC_ABSTRACT;
    }

    /**
     * Gets if the class is static. Used exclusively for inner classes.
     */
    public boolean isStatic() {
        return (asm.access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC;
    }

    /**
     * Provided in case it can be used to help determine the source language of the class.
     */
    public boolean isSynthetic() {
        return (asm.access & Opcodes.ACC_SYNTHETIC) == Opcodes.ACC_SYNTHETIC;
    }

    /**
     * Should almost always be set.
     * <p>
     * "Treat superclass methods specially when invoked by the invokespecial instruction."
     * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokespecial
     * <p>
     * "In Java SE 8 and above, the Java Virtual Machine considers the ACC_SUPER flag to be set in every class file,
     * regardless of the actual value of the flag in the class file and the version of the class file."
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.1-200-E.1
     */
    public boolean hasSuperFlag() {
        return (asm.access & Opcodes.ACC_SUPER) == Opcodes.ACC_SUPER;
    }


    public SourceCodeLanguage getSourceLanguage() {
        if (language == null) {
            language = SourceCodeLanguage.identify(this);
        }
        return language;
    }
}
