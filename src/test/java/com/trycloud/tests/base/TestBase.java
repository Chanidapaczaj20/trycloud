package com.trycloud.tests.base;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.TryCloudUtils;
import com.trycloud.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {

        public WebDriver driver;

    // Story: As a user, I should be able to login.
    //Test case #1 - verify user login successfully
    //1. Navigate to login page http://qa.trycloud.net/index.php/login?clear=1
    // 2. Enter valid username
    //3. Enter valid password
    //4. Click login button
    //5. Verify the URL is changed to homepage’s url
    // (Put this test case in testBase class with an annotation so it runs for all the test case)
        @BeforeMethod
        public void setUp(){
            driver = WebdriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfigurationReader.getProperty("tryCloudUrl"));

            //#1- Create Properties class object
            Properties properties = new Properties();
            //#2- Open the file in JVM Memory and pass the path of the file
            String path = "configuration.properties";
            //For windows > copy path > copy path from content root

            FileInputStream file = null;
            try {
                file = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //#3- Load the opened file into the Properties object.

            try {
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String url = properties.getProperty("tryCloudUrl");

            driver.get(url);

            TryCloudUtils.validLoginToTryCloud(driver);

            //This is re-usable method we created in BrowserUtil class to replace Thread.sleep
            BrowserUtils.sleep(1);

            TryCloudUtils.verifyValidLoginUrl(driver, "http://app.trycloud.net/index.php/apps/files/?dir=/&fileid=82309");




        }

        @AfterMethod
        public void tearDown(){
            driver.close();
        }


    public void login() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();
    }




}
