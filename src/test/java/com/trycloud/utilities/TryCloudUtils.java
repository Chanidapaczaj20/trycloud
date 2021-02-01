package com.trycloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TryCloudUtils {

    public static void validLoginToTryCloud(WebDriver driver) {
        //1. Enter username: “User7”
        WebElement inputValidUserName = driver.findElement(By.xpath("//input[@id='user']"));
        inputValidUserName.sendKeys("User7");
        //2. Enter password: “Userpass123”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("Userpass123");

        //3. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='submit-form']"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();

        verifyValidLoginUrl(driver, actualUrl);

    }
    public static void inValidLoginToTryCloud(WebDriver driver) {
        WebElement inputInValidUserName = driver.findElement(By.xpath("//input[@id='user']"));
        inputInValidUserName.sendKeys("User0");

        //2. Enter password: “Userpass123”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("Userpass123");

        //3. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='submit']"));
        loginButton.click();
    }
    public static void verifyValidLoginUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = "http://app.trycloud.net/index.php/apps/files/?dir=/&fileid=82309";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    public static void verifyInvalidLoginUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = "http://app.trycloud.net/index.php/login?user=User0";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
/*
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = "Files - Trycloud"
         //  Assert.assertEquals(expectedTitle, actualTitle,"success!");
    }
    /*
 */

//http://app.trycloud.net/index.php/login





