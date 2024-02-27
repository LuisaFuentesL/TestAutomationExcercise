package com.globant.pages.commons;

import com.globant.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    private final String username="standard_user";
    private final String password="secret_sauce";


    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(name="login-button")
    private WebElement loginButton;

    public LogInPage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver,this);
    }

    public void logIn(){
        //Hice este método acá porque considero que el login no es parte de las pruebas. Entonces no debería ser un test
        LogInPage logInPage = this;
        logInPage.setUsernameInput(username);
        logInPage.setPasswordInput(password);
        logInPage.clickLogInButton();

//        homePage.setBarText("Selenium");
//        softAssert.assertEquals(homePage.getFooterText(),"You can support our work with a donation.");
//        //WebDriverWait wait = new WebDriverWait(driver,20);
////        List<WebElement> lang_list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("central-featured-lang")));
////        softAssert.assertTrue(lang_list.size()!=0);
//        //softAssert.assertTrue(submitButton.isDisplayed());
//        SearchResults searchResults = homePage.clickOnSearch();
//        softAssert.assertEquals(searchResults.getPageText(),"Selenium");
//        softAssert.assertAll();

    }

    public void setUsernameInput(String username){
        this.usernameInput.click();
        this.usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        this.passwordInput.click();
        this.passwordInput.sendKeys(password);
    }

    public void clickLogInButton() {
        this.loginButton.click();
    }
}
