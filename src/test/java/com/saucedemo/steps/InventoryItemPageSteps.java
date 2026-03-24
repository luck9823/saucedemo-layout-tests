package com.saucedemo.steps;

import com.saucedemo.config.WebDriverFactory;
import com.saucedemo.pages.InventoryItemPage;
import com.saucedemo.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryItemPageSteps {

    private InventoryItemPage itemPage;

    @When("I click on any inventory item")
    public void iClickOnAnyInventoryItem() {
        InventoryPage inventoryPage = new InventoryPage(WebDriverFactory.getDriver());
        itemPage = inventoryPage.clickFirstItem();
    }

    @Then("I should be redirected to the item detail page")
    public void iShouldBeRedirectedToTheItemDetailPage() {
        assertTrue(itemPage.isOnItemPage(),
                "User should be redirected to the item detail page");
    }

    @And("the item page should display {string} text on the top")
    public void theItemPageShouldDisplayTextOnTheTop(String expectedText) {
        assertTrue(itemPage.isSwagLabsLogoDisplayed(),
                "Swag Labs logo should be displayed on item page");
    }

    @And("the item page should display the product image")
    public void theItemPageShouldDisplayTheProductImage() {
        assertTrue(itemPage.isItemImageDisplayed(),
                "Product image should be displayed");
    }

    @And("the item page should display the product name")
    public void theItemPageShouldDisplayTheProductName() {
        assertTrue(itemPage.isItemNameDisplayed(),
                "Product name should be displayed");
    }

    @And("the item page should display the product description")
    public void theItemPageShouldDisplayTheProductDescription() {
        assertTrue(itemPage.isItemDescriptionDisplayed(),
                "Product description should be displayed");
    }

    @And("the item page should display the product price")
    public void theItemPageShouldDisplayTheProductPrice() {
        assertTrue(itemPage.isItemPriceDisplayed(),
                "Product price should be displayed");
    }

    @And("the item page should display an {string} button")
    public void theItemPageShouldDisplayAnButton(String buttonName) {
        if ("Add to cart".equals(buttonName)) {
            assertTrue(itemPage.isAddToCartButtonDisplayed(),
                    "Add to cart button should be displayed");
        }
    }

    @And("the item page should display a {string} link")
    public void theItemPageShouldDisplayALink(String linkName) {
        if ("Back to products".equals(linkName)) {
            assertTrue(itemPage.isBackToProductsLinkDisplayed(),
                    "Back to products link should be displayed");
        }
    }

    @And("the item page should display a Cart icon")
    public void theItemPageShouldDisplayACartIcon() {
        assertTrue(itemPage.isCartIconDisplayed(),
                "Cart icon should be displayed on item page");
    }

    @And("the item page should display a Menu button")
    public void theItemPageShouldDisplayAMenuButton() {
        assertTrue(itemPage.isMenuButtonDisplayed(),
                "Menu button should be displayed on item page");
    }

    @And("the item page should display social network links for Twitter, Facebook, and LinkedIn")
    public void theItemPageShouldDisplaySocialNetworkLinks() {
        assertTrue(itemPage.isTwitterLinkDisplayed(),
                "Twitter (X) link should be displayed on item page");
        assertTrue(itemPage.isFacebookLinkDisplayed(),
                "Facebook link should be displayed on item page");
        assertTrue(itemPage.isLinkedinLinkDisplayed(),
                "LinkedIn link should be displayed on item page");
    }
}
