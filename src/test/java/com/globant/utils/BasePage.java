package com.globant.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    protected int getNumOfElementsByClassName(String className) {
        return driver.findElements(By.className(className)).size();
    }
}
