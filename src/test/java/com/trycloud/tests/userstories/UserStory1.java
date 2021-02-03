package com.trycloud.tests.userstories;

import com.trycloud.utilities.TryCloudUtils;
import com.trycloud.tests.base.TestBase;
import org.testng.annotations.Test;

public class UserStory1 extends TestBase {


    // Test case #2 - verify user cannot login with invalid credentials
    //1. Navigate to login page http://qa.trycloud.net/index.php/login?clear=1
    // 2. Enter valid username invalid password
    //3. Click login button
    //4. Message “Invalid user name or password.” should be displayed
    //5. Page title and url should be same

    @Test
    public void TestCase2() {
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        TryCloudUtils.inValidLoginToTryCloud(driver);

    }



}
