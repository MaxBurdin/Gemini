package com.gemini.sandbox.exchange.tests;

import com.gemini.sandbox.exchange.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {

    protected SignInPage signInPage;
    protected RegistrationPage registrationPage;
    protected InstitutionalClientRegistrationPage institutionalClientRegistrationPage;
    protected RegistrationConfirmationPage registrationConfirmationPage;

    // Test data
    protected static final String COMPANY = "Clancy's Farm";
    protected static final String FIRST_NAME = "Clancy";
    protected static final String MIDDLE_NAME = "Duncan";
    protected static final String LAST_NAME = "Gilroy";
    protected static final String EMAIL = "clancy.gilroy@mail.com";
    protected static final String COMPANY_TYPE = "space farm";
    protected static final String INVALID_EMAIL = "clancy.gilroymailcom";
    protected static final String NON_ENGLISH_TEXT = "текст";
    protected static final String LONG_TEXT = FIRST_NAME.repeat(200);
    protected static final String LONG_EMAIL = EMAIL.repeat(15);

    // Navigate to Institutional Client Registration page
    @BeforeMethod
    public void setup() {
        goToSignInPage();

        signInPage = new SignInPage();
        registrationPage = new RegistrationPage();
        institutionalClientRegistrationPage = new InstitutionalClientRegistrationPage();
        registrationConfirmationPage = new RegistrationConfirmationPage();
    }

    // Close browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
