package com.globant.pages;

import com.globant.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    @FindBy(className="complete-header")
    private WebElement successfullText;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getPageText(){
        this.isElementDisplayed(this.successfullText);
        return this.successfullText.getText();
    }


}
