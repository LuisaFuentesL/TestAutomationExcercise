package com.globant.pages.commons;

import com.globant.pages.CartPage;
import com.globant.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    @FindBy(className="shopping_cart_link")
    private WebElement cart;

    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id="logout_sidebar_link")
    private WebElement logOutLink;

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

    public LogInPage clickLogOutFromBurguerMenu(){
        burgerMenu.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(logOutLink));
        logOutLink.click();
        return new LogInPage(driver, driver.getCurrentUrl());
    }
}
