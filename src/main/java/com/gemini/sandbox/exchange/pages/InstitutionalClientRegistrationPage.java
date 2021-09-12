package com.gemini.sandbox.exchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InstitutionalClientRegistrationPage extends BasePage {

    private By businessNameInput = By.name("company.legalName");
    private By companyTypeDropdown = By.xpath("//label[@data-testid='companyTypeDropdown-label']");
    private By otherCompanyType = By.id("react-select-2-option-11");
    private By otherCompanyTypeInput = By.name("company.companyTypeDetail");
    private By countryDropdown = By.xpath("//label[@data-testid='countryDropdown-label']");
    private By stateDropdown = By.xpath("//label[@data-testid='stateDropdown-label']");
    private By firstNameInput = By.name("personal.legalName.firstName");
    private By middleNameInput = By.name("personal.legalName.middleName");
    private By lastNameInput = By.name("personal.legalName.lastName");
    private By emailAddressInput = By.name("personal.email");
    private By continueButton = By.xpath("//button[@data-testid='InstitutionSubmit']");
    private By existingInstitutionalAccountLink = By.xpath("//a[.='Join an existing institutional account?']");
    private By businessNameInputLabel = By.xpath("//div[text()='Legal Business Name']");
    private By businessNameWarningMessage = By.xpath("//li[.='Legal Business Name is required.']");
    private By companyTypeWarningMessage = By.xpath("//li[.='Company type is required.']");
    private By otherCompanyTypeInputLabel = By.xpath("//div[text()='Other Description']");
    private By otherCompanyTypeWarningMessage = By.xpath("//li[.='Description is required if company type is &lsquo;Other&rsquo;.']");
    private By stateWarningMessage = By.xpath("//li[.='Company state is required.']");
    private By firstNameInputLabel = By.xpath("//div[text()='Legal First Name']");
    private By firstNameWarningMessage = By.xpath("//li[.='First name is required.']");
    private By lastNameInputLabel = By.xpath("//div[text()='Legal Last Name']");
    private By lastNameWarningMessage = By.xpath("//li[.='Last name is required.']");
    private By emailAddressInputLabel = By.xpath("//div[text()='Your Email Address']");
    private By emailAddressWarningMessage = By.xpath("//li[.='Please enter a valid email address.']");
    private By invalidEmailAddressWarningMessage = By.xpath("//div[text()='Please specify a valid email domain.']");
    private By longEmailAddressWarningMessage = By.xpath("//div[text()='Please enter an email address less than 255 characters.']");

    public InstitutionalClientRegistrationPage fillOutBusinessNameInput(String businessName) {
        driver.findElement(businessNameInput).sendKeys(businessName);
        return this;
    }

    public InstitutionalClientRegistrationPage selectCompanyType() {
        driver.findElement(companyTypeDropdown).click();
        List<WebElement> companyTypes = driver.findElements(By.xpath("//div[contains(@id, 'react-select-2-option-')]"));
        int randomInt = ThreadLocalRandom.current().nextInt(0, companyTypes.size() - 1);
        By randomCompanyType = By.id(String.format("react-select-2-option-%s", randomInt));
        driver.findElement(randomCompanyType).click();
        return this;
    }

    public InstitutionalClientRegistrationPage selectState() {
        driver.findElement(stateDropdown).click();
        List<WebElement> states = driver.findElements(By.xpath("//div[contains(@id, 'react-select-4-option-')]"));
        int randomInt = ThreadLocalRandom.current().nextInt(0, states.size());
        By randomState = By.id(String.format("react-select-4-option-%s", randomInt));
        driver.findElement(randomState).click();
        return this;
    }

    public InstitutionalClientRegistrationPage fillOutFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public InstitutionalClientRegistrationPage fillOutMiddleNameInput(String middleName) {
        driver.findElement(middleNameInput).sendKeys(middleName);
        return this;
    }

    public InstitutionalClientRegistrationPage fillOutLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public InstitutionalClientRegistrationPage fillOutEmailAddressInput(String email) {
        driver.findElement(emailAddressInput).sendKeys(email);
        return this;
    }

    public InstitutionalClientRegistrationPage selectOtherCompanyType() {
        driver.findElement(companyTypeDropdown).click();
        scrollElementIntoView(otherCompanyType);
        driver.findElement(otherCompanyType).click();
        return this;
    }

    public InstitutionalClientRegistrationPage fillOutOtherCompanyType(String company) {
        selectOtherCompanyType();
        driver.findElement(otherCompanyTypeInput).sendKeys(company);
        return this;
    }

    public InstitutionalClientRegistrationPage selectCountry() {
        driver.findElement(countryDropdown).click();
        List<WebElement> countries = driver.findElements(By.xpath("//div[contains(@id, 'react-select-3-option-')]"));
        int randomInt = ThreadLocalRandom.current().nextInt(0, countries.size());
        By randomCountry = By.id(String.format("react-select-3-option-%s", randomInt));
        driver.findElement(randomCountry).click();
        return this;
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).submit();
    }

    public void clickExistingInstitutionalAccountLink() {
        scrollElementIntoView(existingInstitutionalAccountLink);
        driver.findElement(existingInstitutionalAccountLink).click();
    }

    public boolean isExistingInstitutionalAccountPageOpen() {
        return driver.getCurrentUrl().equals("https://exchange.sandbox.gemini.com/register?type=institution");
    }

    public boolean isBusinessNameInputLabelHighlightedRed() {
        return isInputLabelHighlightedRed(businessNameInputLabel);
    }

    public boolean isBusinessNameInputHighlightedRed() {
        return isInputHighlightedRed(businessNameInput);
    }

    public boolean isBusinessNameWarningMessageDisplayed() {
        return isWarningMessageDisplayed(businessNameWarningMessage);
    }

    public boolean isCompanyTypeWarningMessageDisplayed() {
        return isWarningMessageDisplayed(companyTypeWarningMessage);
    }

    public boolean isOtherCompanyTypeInputLabelHighlightedRed() {
        return isInputLabelHighlightedRed(otherCompanyTypeInputLabel);
    }

    public boolean isOtherCompanyTypeInputHighlightedRed() {
        return isInputHighlightedRed(otherCompanyTypeInput);
    }

    public boolean isOtherCompanyTypeWarningMessageDisplayed() {
        return isWarningMessageDisplayed(otherCompanyTypeWarningMessage);
    }

    public boolean isStateWarningMessageDisplayed() {
        return isWarningMessageDisplayed(stateWarningMessage);
    }

    public boolean isFirstNameInputLabelHighlightedRed() {
        return isInputLabelHighlightedRed(firstNameInputLabel);
    }

    public boolean isFirstNameInputHighlightedRed() {
        return isInputHighlightedRed(firstNameInput);
    }

    public boolean isFirstNameWarningMessageDisplayed() {
        return isWarningMessageDisplayed(firstNameWarningMessage);
    }

    public boolean isLastNameInputLabelHighlightedRed() {
        return isInputLabelHighlightedRed(lastNameInputLabel);
    }

    public boolean isLastNameInputHighlightedRed() {
        return isInputHighlightedRed(lastNameInput);
    }

    public boolean isLastNameWarningMessageDisplayed() {
        return isWarningMessageDisplayed(lastNameWarningMessage);
    }

    public boolean isEmailAddressInputLabelHighlightedRed() {
        return isInputLabelHighlightedRed(emailAddressInputLabel);
    }

    public boolean isEmailAddressInputHighlightedRed() {
        return isInputHighlightedRed(emailAddressInput);
    }

    public boolean isEmailAddressWarningMessageDisplayed() {
        return isWarningMessageDisplayed(emailAddressWarningMessage);
    }

    public boolean isInvalidEmailAddressWarningMessageDisplayed() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(invalidEmailAddressWarningMessage)).isDisplayed();
    }

    public boolean isNonEnglishBusinessNameWarningMessageDisplayed() {
        return isNonEnglishNameWarningMessageDisplayed("business");
    }

    public boolean isNonEnglishFirstNameWarningMessageDisplayed() {
        return isNonEnglishNameWarningMessageDisplayed("first");
    }

    public boolean isNonEnglishLastNameWarningMessageDisplayed() {
        return isNonEnglishNameWarningMessageDisplayed("last");
    }

    public boolean isExceedingFirstNameLengthWarningMessageDisplayed() {
        return isExceedingInputLengthWarningMessageDisplayed("first");
    }

    public boolean isExceedingMiddleNameLengthWarningMessageDisplayed() {
        return isExceedingInputLengthWarningMessageDisplayed("middle");
    }

    public boolean isExceedingLastNameLengthWarningMessageDisplayed() {
        return isExceedingInputLengthWarningMessageDisplayed("last");
    }

    public boolean isExceedingEmailAddressLengthWarningMessageDisplayed() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(longEmailAddressWarningMessage)).isDisplayed();
    }
}
