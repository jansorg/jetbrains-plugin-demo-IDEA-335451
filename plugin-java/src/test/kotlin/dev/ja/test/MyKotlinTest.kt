package dev.ja.test

import org.junit.Assert
import org.junit.Test

class MyKotlinTest {
    @Test
    fun myTest() {
        Assert.assertEquals("gradle build value", System.getProperty("my.project.property"))
    }
}