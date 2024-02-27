package com.globant.pages;

import com.globant.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends BasePage {

    private final String firstName = "Luisa";
    private final String lastName = "Fuentes";
    private final String postalCode = "111631";
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id="last-name")
    private WebElement lastNameInput;

    @FindBy(id="postal-code")
    private WebElement postalCodeInput;

    @FindBy(name="continue")
    private WebElement continueButton;

    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillPersonalField(){
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setPostalCodeInput(postalCode);
    }

    public void setFirstNameInput(String username){
        this.firstNameInput.click();
        this.firstNameInput.sendKeys(username);
    }

    public void setLastNameInput(String password) {
        this.lastNameInput.click();
        this.lastNameInput.sendKeys(password);
    }

    public void setPostalCodeInput(String password) {
        this.postalCodeInput.click();
        this.postalCodeInput.sendKeys(password);
    }

    public CheckoutOverviewPage clickContinueButton() {
        this.continueButton.click();
        return new CheckoutOverviewPage(this.driver);
    }
}
