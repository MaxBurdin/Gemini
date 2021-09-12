package com.gemini.sandbox.exchange.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    protected static WebDriver driver;
    private WebDriverWait wait;
    public String browser;
    public String baseUrl;
    public Properties properties;
    JavascriptExecutor executor = (JavascriptExecutor)driver;

    private By cookiePolicyAgreementOkButton = By.xpath("//a[@data-testid='cookiePolicyAgreement-close']");
    private final String redLabel = "#D0021B";
    private final String redField = "1a9sz2";

    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 5);
        }
        return wait;
    }

    private void loadProperties() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("/home/max/IdeaProjects/Gemini/src/main/java/com/gemini/sandbox/exchange/config/config.properties");
            properties.load(fis);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToSignInPage() {
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        } catch (Exception e) {
            System.out.println("Unable to navigate to Sign In page");
            e.printStackTrace();
        }
    }

    protected void closeCookiePolicyAgreement() {
        driver.findElement(cookiePolicyAgreementOkButton).click();
    }

    protected void scrollElementIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollPage() {
        executor.executeScript("window.scrollBy(0,500)");
    }

    protected boolean isInputLabelHighlightedRed(By element) {
        return driver.findElement(element).getAttribute("color").equals(redLabel);
    }

    protected boolean isInputHighlightedRed(By element) {
        return driver.findElement(element).getAttribute("class").contains(redField);
    }

    protected boolean isWarningMessageDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    protected boolean isNonEnglishNameWarningMessageDisplayed(String name) {
        By element = By.xpath(String.format
                ("//div[text()='For compliance reasons, please enter your %s name in English characters.']", name));
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }

    protected boolean isExceedingInputLengthWarningMessageDisplayed(String name) {
        By element = By.xpath(String.format
                ("//div[text()='your %s name may not exceed 1000 characters.']", name));
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }
}
