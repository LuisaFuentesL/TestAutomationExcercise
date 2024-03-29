package com.globant.pages;

import com.globant.utils.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private final static String removedCartItemClass = "removed_cart_item";

    @FindBy(name="checkout")
    private WebElement checkoutButton;

    @FindBy(css=".btn.btn_secondary.btn_small.cart_button")
    private WebElement removeButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartNum;


    public CartPage(WebDriver driver) {
        super(driver);
    }
    public PersonalInfoPage checkout(){
        checkoutButton.click();
        return new PersonalInfoPage(this.driver);
    }

    public boolean getRemoveButton(){
        return this.isElementDisplayed(this.removeButton);
    }

    public int numCartItemsRemoved(){
        return this.getNumOfElementsByClassName(removedCartItemClass);
    }

    public void clickRemove(){
        removeButton.click();
    }

    public boolean getNumCart(){
        try {
            if (cartNum.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
}
