package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final By SWAG_LABS_LOGO = By.cssSelector(".app_logo");
    private static final By CART_ICON = By.cssSelector("#shopping_cart_container");
    private static final By BURGER_MENU_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private static final By MENU_ITEMS = By.cssSelector(".bm-item-list a");
    private static final By TWITTER_LINK = By.cssSelector("a[data-test='social-twitter']");
    private static final By FACEBOOK_LINK = By.cssSelector("a[data-test='social-facebook']");
    private static final By LINKEDIN_LINK = By.cssSelector("a[data-test='social-linkedin']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitForElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSwagLabsLogoDisplayed() {
        return isElementDisplayed(SWAG_LABS_LOGO);
    }

    public String getSwagLabsLogoText() {
        return waitForElement(SWAG_LABS_LOGO).getText();
    }

    public boolean isCartIconDisplayed() {
        return isElementDisplayed(CART_ICON);
    }

    public boolean isMenuButtonDisplayed() {
        return isElementDisplayed(BURGER_MENU_BUTTON);
    }

    public void openMenu() {
        waitForClickable(BURGER_MENU_BUTTON).click();
    }

    public List<String> getMenuItemTexts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".bm-menu-wrap[aria-hidden='false']")));
        List<WebElement> items = waitForElements(MENU_ITEMS);
        return items.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isTwitterLinkDisplayed() {
        return isElementDisplayed(TWITTER_LINK);
    }

    public boolean isFacebookLinkDisplayed() {
        return isElementDisplayed(FACEBOOK_LINK);
    }

    public boolean isLinkedinLinkDisplayed() {
        return isElementDisplayed(LINKEDIN_LINK);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
