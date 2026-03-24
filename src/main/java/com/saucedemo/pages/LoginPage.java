package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String URL = "https://www.saucedemo.com/";

    private static final By USERNAME_FIELD = By.cssSelector("#user-name");
    private static final By PASSWORD_FIELD = By.cssSelector("#password");
    private static final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private static final By LOGIN_LOGO = By.cssSelector(".login_logo");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        waitForElement(LOGIN_LOGO);
        return this;
    }

    public boolean isUsernameFieldDisplayed() {
        return isElementDisplayed(USERNAME_FIELD);
    }

    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(PASSWORD_FIELD);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(LOGIN_BUTTON);
    }

    public boolean isLoginLogoDisplayed() {
        return isElementDisplayed(LOGIN_LOGO);
    }

    public String getLoginLogoText() {
        return waitForElement(LOGIN_LOGO).getText();
    }

    public void enterUsername(String username) {
        waitForElement(USERNAME_FIELD).clear();
        waitForElement(USERNAME_FIELD).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(PASSWORD_FIELD).clear();
        waitForElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForClickable(LOGIN_BUTTON).click();
    }

    public InventoryPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage(driver);
    }
}
