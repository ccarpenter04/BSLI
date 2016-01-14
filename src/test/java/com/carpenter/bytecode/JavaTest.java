package com.carpenter.bytecode;

import com.carpenter.bytecode.hierachy.BytecodeClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.InputStream;

public class JavaTest {
    @Test
    public void testIdentifyEnumWithSrcAttribute() throws Exception {
        InputStream is = getClass().getResourceAsStream("/JavaEnumTest.class");
        Assume.assumeNotNull(is);
        ClassNode cd = new ClassNode();
        new ClassReader(is).accept(cd, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
        Assert.assertEquals(SourceCodeLanguage.JAVA, SourceCodeLanguage.identify(new BytecodeClass(cd), true));
    }

    @Test
    public void testIdentifyEnumWithoutSrcAttribute() throws Exception {
        InputStream is = getClass().getResourceAsStream("/JavaEnumTest.class");
        Assume.assumeNotNull(is);
        ClassNode cd = new ClassNode();
        new ClassReader(is).accept(cd, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
        Assert.assertEquals(SourceCodeLanguage.JAVA, SourceCodeLanguage.identify(new BytecodeClass(cd), false));
    }
}
