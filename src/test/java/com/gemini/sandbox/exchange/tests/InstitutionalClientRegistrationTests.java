package com.gemini.sandbox.exchange.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class InstitutionalClientRegistrationTests extends BaseTest{

    @BeforeMethod(description = "Navigate to Institutional Client Registration page")
    public void navigateToInstitutionalClientRegistrationPage() {
        signInPage.openRegistrationPage().openInstitutionalClientRegistrationPage();
        institutionalClientRegistrationPage.scrollPage();
    }

    // Tests positive
    @Test(description = "Registration with all fields filled")
    public void registrationWithAllFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutMiddleNameInput(MIDDLE_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with required fields filled")
    public void registrationWithRequiredFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with other company type with all fields filled")
    public void registrationWithOtherCompanyTypeWithAllFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .fillOutOtherCompanyType(COMPANY_TYPE)
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutMiddleNameInput(MIDDLE_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with other company type with required fields filled")
    public void registrationWithOtherCompanyTypeWithRequiredFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .fillOutOtherCompanyType(COMPANY_TYPE)
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with country without states with all fields filled")
    public void registrationWithCountryWithoutStatesWithAllFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectCountry()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutMiddleNameInput(MIDDLE_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with country without states with required fields filled")
    public void registrationWithCountryWithoutStatesWithRequiredFieldsFilledTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectCountry()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Registration with required fields filled")
    public void institutionalAccountApplicationButtonAvailableTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationMessageDisplayed());
    }

    @Test(description = "Test 'Join an existing institutional account?' link")
    public void existingInstitutionalAccountLinkTest() {
        institutionalClientRegistrationPage
                .clickExistingInstitutionalAccountLink();

        Assert.assertTrue(institutionalClientRegistrationPage.isExistingInstitutionalAccountPageOpen());
    }

    // Tests negative
    @Test(description = "Submitting form without any input")
    public void registrationWithoutInputTest() {
        institutionalClientRegistrationPage.clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameWarningMessageDisplayed());

        Assert.assertTrue(institutionalClientRegistrationPage.isCompanyTypeWarningMessageDisplayed());
        Assert.assertTrue(institutionalClientRegistrationPage.isStateWarningMessageDisplayed());

        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameWarningMessageDisplayed());

        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameWarningMessageDisplayed());

        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without business name")
    public void registrationWithoutBusinessNameTest() {
        institutionalClientRegistrationPage
                .fillOutFirstNameInput(FIRST_NAME)
                .selectCompanyType()
                .selectState()
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isBusinessNameWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without company type")
    public void registrationWithoutCompanyTypeTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isCompanyTypeWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without other company type description")
    public void registrationWithoutOtherCompanyTypeDescriptionTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectOtherCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isOtherCompanyTypeInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isOtherCompanyTypeInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isOtherCompanyTypeWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without state")
    public void registrationWithoutStateTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isStateWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without first name")
    public void registrationWithoutFirstNameTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isFirstNameWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without last name")
    public void registrationWithoutLastNameTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isLastNameWarningMessageDisplayed());
    }

    @Test(description = "Submitting form without email")
    public void registrationWithoutEmailAddressTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressInputLabelHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressInputHighlightedRed());
        Assert.assertTrue(institutionalClientRegistrationPage.isEmailAddressWarningMessageDisplayed());
    }

    @Test(description = "Submitting form with invalid email")
    public void registrationWithInvalidEmailAddressTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(INVALID_EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isInvalidEmailAddressWarningMessageDisplayed());
    }

    @Test(description = "Registration with non English business name")
    public void registrationWithNonEnglishBusinessNameTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(NON_ENGLISH_TEXT)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isNonEnglishBusinessNameWarningMessageDisplayed());
    }

    @Test(description = "Registration with non English first name")
    public void registrationWithNonEnglishFirstNameTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(NON_ENGLISH_TEXT)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isNonEnglishFirstNameWarningMessageDisplayed());
    }

    @Test(description = "Registration with non English last name")
    public void registrationWithNonEnglishLastNameTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(NON_ENGLISH_TEXT)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isNonEnglishLastNameWarningMessageDisplayed());
    }

    @Test(description = "Registration with exceeding first name input length")
    public void registrationWithExceedingFirstNameInputLengthTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(LONG_TEXT)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isExceedingFirstNameLengthWarningMessageDisplayed());
    }

    @Test(description = "Registration with exceeding middle name input length")
    public void registrationWithExceedingMiddleNameInputLengthTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutMiddleNameInput(LONG_TEXT)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isExceedingMiddleNameLengthWarningMessageDisplayed());
    }

    @Test(description = "Registration with exceeding last name input length")
    public void registrationWithExceedingLastNameInputLengthTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LONG_TEXT)
                .fillOutEmailAddressInput(EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isExceedingLastNameLengthWarningMessageDisplayed());
    }

    @Test(description = "Registration with exceeding email address input length")
    public void registrationWithExceedingEmailAddressInputLengthTest() {
        institutionalClientRegistrationPage
                .fillOutBusinessNameInput(COMPANY)
                .selectCompanyType()
                .selectState()
                .fillOutFirstNameInput(FIRST_NAME)
                .fillOutLastNameInput(LAST_NAME)
                .fillOutEmailAddressInput(LONG_EMAIL)
                .clickContinueButton();

        Assert.assertTrue(institutionalClientRegistrationPage.isExceedingEmailAddressLengthWarningMessageDisplayed());
    }
}
