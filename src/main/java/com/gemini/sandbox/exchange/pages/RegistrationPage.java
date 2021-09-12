package com.gemini.sandbox.exchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private By institutionalClientRegistrationPage = By.xpath("//a[@data-testid='register-go-to-institution-register']");

    public void openInstitutionalClientRegistrationPage() {
        closeCookiePolicyAgreement();
        scrollElementIntoView(institutionalClientRegistrationPage);
        getWait().until(ExpectedConditions.elementToBeClickable(institutionalClientRegistrationPage)).click();
    }
}
