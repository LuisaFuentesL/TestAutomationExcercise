package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver,this);
    }
}
