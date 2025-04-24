package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getHome().isHomeComponentPresent()){
            app.getHome().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponent()
    {
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }
}
