package com.globant.tests;

import com.globant.pages.commons.HomePage;
import com.globant.pages.commons.LogInPage;
import com.globant.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Test
    public void testLogOut() {
        HomePage homePage = getHomePage();
        LogInPage logInPage = homePage.clickLogOutFromBurguerMenu();
        Assert.assertTrue(logInPage.checkIfLoginButtonIsDisplayed());
    }
}
