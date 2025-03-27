package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("jul123@gmail.com").setPassword( "Jul12345$"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact().setName("Karl").setLastName("Adam").setNumber("1234567890").setEmail("Karl@gmail.com")
                .setAddress("Tel Aviv").setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Karl"));
        clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore= sizeOfContacts();
        deleteContact();
        pause(5000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }


}
