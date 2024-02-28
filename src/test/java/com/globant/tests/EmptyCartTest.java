package com.globant.tests;

import com.globant.pages.*;
import com.globant.pages.commons.HomePage;
import com.globant.utils.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmptyCartTest extends BaseTest {
    private List<String> productsNames = new ArrayList<>();
    private int numElementsToAdd = 3;
    SoftAssert softAssert = new SoftAssert();

    public void fillList(){
        productsNames.add("add-to-cart-sauce-labs-backpack");
        productsNames.add("add-to-cart-sauce-labs-bike-light");
        productsNames.add("add-to-cart-sauce-labs-bolt-t-shirt");
        productsNames.add("add-to-cart-sauce-labs-fleece-jacket");
        productsNames.add("add-to-cart-sauce-labs-onesie");
        productsNames.add("add-to-cart-test.allthethings()-t-shirt-(red)");
    }

    public String pickRandomProduct(){
        Random random = new Random();
        int randomIndex = random.nextInt(productsNames.size());
        return productsNames.get(randomIndex);
    }

    @Test
    public void testEmptyCart() {
        HomePage homePage = getHomePage();
        fillList();
        for (int i = 0; i < numElementsToAdd; i++){
            String buttonName = pickRandomProduct();
            homePage.addToCart(buttonName);
            productsNames.remove(buttonName);
        }
        CartPage cartPage= homePage.goToCart();
        while (true){
            try {
                if (cartPage.getRemoveButton()) {
                    cartPage.clickRemove();
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        int numRemovedElements = cartPage.numCartItemsRemoved();
        softAssert.assertEquals(numElementsToAdd, numRemovedElements);
        boolean isCartNumDisplayed = cartPage.getNumCart();
        softAssert.assertFalse(isCartNumDisplayed);
        softAssert.assertAll();
    }
}
