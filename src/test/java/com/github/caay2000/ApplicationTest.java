package com.github.caay2000;


import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void test() {
        Assert.assertEquals("hello", new Application().hello());
    }

}