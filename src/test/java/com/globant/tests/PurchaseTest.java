package com.globant.tests;

import com.globant.pages.*;
import com.globant.pages.commons.HomePage;
import com.globant.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;


public class PurchaseTest extends BaseTest {
    private static final String textDesired = "Thank you for your order!";

    String[] productsNames = {
            "add-to-cart-sauce-labs-backpack",
            "add-to-cart-sauce-labs-bike-light",
            "add-to-cart-sauce-labs-bolt-t-shirt",
            "add-to-cart-sauce-labs-fleece-jacket",
            "add-to-cart-sauce-labs-onesie",
            "add-to-cart-test.allthethings()-t-shirt-(red)"};

    public String pickRandomProduct(){
        Random random = new Random();
        int randomIndex = random.nextInt(productsNames.length);
        return productsNames[randomIndex];
    }

    @Test
    public void testPurchaseProduct() {
        HomePage homePage = getHomePage();
        String buttonName = pickRandomProduct();
        homePage.addToCart(buttonName);
        CartPage cartPage= homePage.goToCart();
        PersonalInfoPage personalInfoPage = cartPage.checkout();
        personalInfoPage.fillPersonalField();
        CheckoutOverviewPage checkoutOverviewPage =  personalInfoPage.clickContinueButton();
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        String textPage = checkoutCompletePage.getPageText();
        Assert.assertEquals(textPage,textDesired);
    }
}
