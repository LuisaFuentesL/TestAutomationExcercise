package com.globant.utils;

import com.globant.pages.commons.HomePage;
import com.globant.pages.commons.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static final String driverPath = "drivers/chromedriver.exe";
    String url = "https://www.saucedemo.com/";
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
    }

    @BeforeTest
    public LogInPage getLogInPage(){
        LogInPage logInPage = new LogInPage(driver, url);
        logInPage.logIn();
        return logInPage;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }
}
