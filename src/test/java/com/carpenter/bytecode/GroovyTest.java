package com.carpenter.bytecode;

import com.carpenter.bytecode.hierachy.BytecodeClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.InputStream;

public class GroovyTest {
    @Test
    public void testIdentifyEnumWithSrcAttribute() throws Exception {
        InputStream stream = getClass().getResourceAsStream("/GroovyEnumTest.class");
        Assume.assumeNotNull(stream);
        ClassNode cd = new ClassNode();
        new ClassReader(stream).accept(cd, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
        Assert.assertEquals(SourceCodeLanguage.GROOVY, SourceCodeLanguage.identify(new BytecodeClass(cd), true));
    }

    @Test
    public void testIdentifyEnumWithoutSrcAttribute() throws Exception {
        InputStream is = getClass().getResourceAsStream("/GroovyEnumTest.class");
        Assume.assumeNotNull(is);
        ClassNode cd = new ClassNode();
        new ClassReader(is).accept(cd, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
        Assert.assertEquals(SourceCodeLanguage.GROOVY, SourceCodeLanguage.identify(new BytecodeClass(cd), false));
    }
}