package com.globant.tests;

import com.globant.pages.commons.LogInPage;
import com.globant.utils.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testPurchaseProduct(){
        LogInPage logInPage = getLogInPage();

    }
}
