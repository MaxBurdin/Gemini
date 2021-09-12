package com.gemini.sandbox.exchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends BasePage {

    private By registrationConfirmationMessage = By.xpath("//h3[.='Thanks for Registering!']");

    public boolean isRegistrationConfirmationMessageDisplayed() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(registrationConfirmationMessage)).isDisplayed();
    }
}
