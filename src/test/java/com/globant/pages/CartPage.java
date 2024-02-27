package com.globant.pages;

import com.globant.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(name="checkout")
    private WebElement checkoutButton;
    public CartPage(WebDriver driver) {
        super(driver);
        //this.driver.get(url);
        //PageFactory.initElements(driver,this);
    }
    public PersonalInfoPage checkout(){
        checkoutButton.click();
        return new PersonalInfoPage(this.driver);
    }
}
