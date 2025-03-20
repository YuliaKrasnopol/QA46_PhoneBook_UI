package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    @Test
    public void newUserRegistrationPositiveTest(){
        //click on login link
        click(By.cssSelector("[href='/login']"));
//enter email
        type(By.name("email"), "jul123@gmail.com");
//enter password
        type(By.name("password"), "Jul12345$");
        //click on reg btn
        click(By.name("registration"));
        //verify Sign out button is displayed
        Assert.assertTrue(isElementPresent(By.cssSelector
                        ("div:nth-child(1) button")));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "jul123@gmail.com");
//enter password
        type(By.name("password"), "Jul12345$");
        //click on reg btn
        click(By.name("registration"));
        //verify Alert is displayed
        Assert.assertTrue(isAlertDisplayed());


    }

}
