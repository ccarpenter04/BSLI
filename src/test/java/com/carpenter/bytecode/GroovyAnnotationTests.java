package com.carpenter.bytecode;

import com.carpenter.bytecode.hierachy.BytecodeClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.InputStream;

public class GroovyAnnotationTests {
    private BytecodeClass bclass;

    @Before
    public void read() throws Exception {
        InputStream is = getClass().getResourceAsStream("/GroovyAnnotationTest.class");
        Assume.assumeNotNull(is);
        ClassNode cd = new ClassNode();
        new ClassReader(is).accept(cd, ClassReader.SKIP_CODE | ClassReader.SKIP_FRAMES);
        bclass = new BytecodeClass(cd);
    }

    @Test
    public void testWithSrcAttribute() throws Exception {
        Assert.assertEquals(SourceCodeLanguage.GROOVY, SourceCodeLanguage.identify(bclass, true));
    }

    @Test
    public void testWithoutSrcAttribute() throws Exception {
        Assert.assertEquals(SourceCodeLanguage.GROOVY, SourceCodeLanguage.identify(bclass, false));
    }
}
