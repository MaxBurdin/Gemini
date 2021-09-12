package com.gemini.sandbox.exchange.pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private By registrationPage = By.xpath("//a[@data-testid='goToRegister']");

    public RegistrationPage openRegistrationPage() {
        driver.findElement(registrationPage).click();
        return new RegistrationPage();
    }
}
