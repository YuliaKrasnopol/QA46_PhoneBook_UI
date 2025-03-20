package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTests(){
        click(By.cssSelector("[href='/login']"));
//enter email
        type(By.name("email"), "jul123@gmail.com");
//enter password
        type(By.name("password"), "Jul12345$");

        //click on login btn
        click(By.name("login"));

        //verify btn logout is displayed
        Assert.assertTrue(isElementPresent(By.cssSelector
                ("div:nth-child(1) button")));

    }
}
