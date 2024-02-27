package com.globant.pages;

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
        //String textButtons =buttonProductCart.getText()
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(productButton), "Remove"));
    }

    public CartPage goToCart(){
        cart.click();
        return new CartPage(this.driver);

    }
}
