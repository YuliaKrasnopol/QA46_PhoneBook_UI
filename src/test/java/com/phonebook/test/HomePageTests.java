package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponent(){
        Assert.assertTrue(isHomeComponentPresent());
    }
}
