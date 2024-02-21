package com.globant.tests;

import com.globant.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    WebDriver driver = null;
    String url = "https://www.saucedemo.com/";
   LogInPage logInPage;

    @BeforeTest
    public void beforeTest(){
        String driverPath = "C:\\Users\\luisa.fuentes\\Documents\\WebAutomation\\src\\utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.close();
    }

    public LogInPage getLogInPage(){
        return new LogInPage(driver,url);

    }
}
