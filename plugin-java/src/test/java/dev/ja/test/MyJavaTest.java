package dev.ja.test;

import org.junit.Assert;
import org.junit.Test;

public class MyJavaTest {
    @Test
    public void myJavaTest() {
        Assert.assertEquals("gradle build value", System.getProperty("my.project.property"));
    }
}
