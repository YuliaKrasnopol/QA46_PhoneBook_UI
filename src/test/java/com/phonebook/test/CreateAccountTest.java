package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        clickOnLoginLink();
       fillRegisterLoginForm(new User().setEmail("jul123@gmail.com").setPassword( "Jul12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("jul123@gmail.com").setPassword( "Jul12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}