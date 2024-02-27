package com.globant.pages.commons;

import com.globant.pages.CartPage;
import com.globant.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(className="shopping_cart_link")
    private WebElement cart;

    private WebElement buttonProductCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productButton){
        buttonProductCart = driver.findElement(By.id(productButton));
        buttonProductCart.click();
    }

    public CartPage goToCart(){
        cart.click();
        return new CartPage(this.driver);

    }
}
