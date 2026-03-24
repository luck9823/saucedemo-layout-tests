package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends BasePage {

    private static final By ITEM_IMAGE = By.cssSelector(".inventory_details_img");
    private static final By ITEM_NAME = By.cssSelector("[data-test='inventory-item-name']");
    private static final By ITEM_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
    private static final By ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button[data-test^='add-to-cart']");
    private static final By BACK_TO_PRODUCTS_LINK = By.cssSelector("[data-test='back-to-products']");

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnItemPage() {
        return getCurrentUrl().contains("inventory-item.html");
    }

    public boolean isItemImageDisplayed() {
        return isElementDisplayed(ITEM_IMAGE);
    }

    public boolean isItemNameDisplayed() {
        return isElementDisplayed(ITEM_NAME);
    }

    public String getItemName() {
        return waitForElement(ITEM_NAME).getText();
    }

    public boolean isItemDescriptionDisplayed() {
        return isElementDisplayed(ITEM_DESCRIPTION);
    }

    public boolean isItemPriceDisplayed() {
        return isElementDisplayed(ITEM_PRICE);
    }

    public boolean isAddToCartButtonDisplayed() {
        return isElementDisplayed(ADD_TO_CART_BUTTON);
    }

    public boolean isBackToProductsLinkDisplayed() {
        return isElementDisplayed(BACK_TO_PRODUCTS_LINK);
    }
}
