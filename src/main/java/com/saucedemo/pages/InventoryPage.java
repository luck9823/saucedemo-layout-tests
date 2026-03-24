package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private static final By INVENTORY_LIST = By.cssSelector(".inventory_list");
    private static final By SORT_DROPDOWN = By.cssSelector("[data-test='product-sort-container']");
    private static final By FIRST_ITEM_LINK = By.xpath("(//div[@data-test='inventory-item-name'])[1]");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnInventoryPage() {
        return getCurrentUrl().contains("inventory.html")
                && isElementDisplayed(INVENTORY_LIST);
    }

    public boolean isSortDropdownDisplayed() {
        return isElementDisplayed(SORT_DROPDOWN);
    }

    public List<String> getSortDropdownOptions() {
        WebElement dropdown = waitForElement(SORT_DROPDOWN);
        Select select = new Select(dropdown);
        return select.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public InventoryItemPage clickFirstItem() {
        waitForClickable(FIRST_ITEM_LINK).click();
        return new InventoryItemPage(driver);
    }
}
