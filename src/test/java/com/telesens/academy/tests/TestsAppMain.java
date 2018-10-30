package com.telesens.academy.tests;

import com.telesens.academy.lesson10.AppMain;
import org.testng.annotations.Test;

public class TestsAppMain {

    @Test
    public void GetHello() {
        String actual = AppMain.GetHello();
        String expected = "Hello";
        assert actual.equals(expected);
    }
}
