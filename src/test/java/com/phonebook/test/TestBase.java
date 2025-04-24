package com.phonebook.test;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

   // @BeforeMethod
    @BeforeSuite
    public void SetUp(){
        app.init();

    }

   // @AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown(){

        app.stop();
    }
@BeforeMethod
    public void startTest(Method method, Object[]p){
        logger.info("start test" + method.getName()+ Arrays.asList(p));
}
@AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("Passsed" + result.getMethod().getMethodName());
        }
        else {
            try {
                logger.error("Failed: "+result.getMethod().getMethodName()+"screenshor path: "+app.getUser().takeScreenshot());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Stop test");
        logger.info("+++++++++++++++++++++++");
}
}
