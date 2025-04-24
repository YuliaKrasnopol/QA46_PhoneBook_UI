package com.phonebook.test;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME).setLastName(ContactData.LAST_NAME).setNumber(ContactData.PHONE).setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS).setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));

    }
//    @DataProvider
//    public Iterator<Object[]>addNewContact(){
//        List<Object[]> list =new ArrayList<>();
//        list.add(new Object[]{"Oli", "Kit", "1234567890", "oli@mail.ru", "Holon", "QA"});
//        list.add(new Object[]{"Kit", "Jas", "12345678910", "jas@mail.ru", "Holon", "QA"});
//        list.add(new Object[]{"Oli", "Kit", "123456789012", "oli@mail.ru", "Holon", "QA"});
//        return list.iterator();
//
//    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name,
                                                       String lastName,
                                                       String phone,
                                                       String email,
                                                       String address,
                                                       String description){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setNumber(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));

    }
//    @DataProvider
//    public Iterator<Object[]>addNewContactWithCsv() throws IOException {
//        List<Object[]>list=new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));
//        String line = reader.readLine();
//
//        while (line !=null) {
//
//            String[] split = line.split(",");
//
//            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setNumber(split[2]).setEmail(split[3])
//                    .setAddress(split[4]).setDescription(split[5])});
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }
    @Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));

    }


    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }

}
