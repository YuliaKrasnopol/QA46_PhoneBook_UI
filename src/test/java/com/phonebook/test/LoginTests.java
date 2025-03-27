package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTests(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("jul123@gmail.com").setPassword( "Jul12345$"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());

    } @Test
    public void loginNegativeTestWithoutEmail(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Jul12345$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());

    }

}
