package com.saucedemo.steps;

import com.saucedemo.config.WebDriverFactory;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPageSteps {

    private InventoryPage inventoryPage;

    @Given("I login with standard_user credentials")
    public void iLoginWithStandardUserCredentials() {
        WebDriver driver = WebDriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        inventoryPage = loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to the Inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        assertTrue(inventoryPage.isOnInventoryPage(),
                "User should be redirected to the Inventory page");
    }

    @And("the Inventory page should display {string} text on the top")
    public void theInventoryPageShouldDisplayTextOnTheTop(String expectedText) {
        assertTrue(inventoryPage.isSwagLabsLogoDisplayed(),
                "Swag Labs logo should be displayed");
        assertEquals(expectedText, inventoryPage.getSwagLabsLogoText(),
                "Logo text should be '" + expectedText + "'");
    }

    @And("the Inventory page should display a Cart icon")
    public void theInventoryPageShouldDisplayACartIcon() {
        assertTrue(inventoryPage.isCartIconDisplayed(),
                "Cart icon should be displayed");
    }

    @And("the Inventory page should display social network links for Twitter, Facebook, and LinkedIn")
    public void theInventoryPageShouldDisplaySocialNetworkLinks() {
        assertTrue(inventoryPage.isTwitterLinkDisplayed(),
                "Twitter (X) link should be displayed");
        assertTrue(inventoryPage.isFacebookLinkDisplayed(),
                "Facebook link should be displayed");
        assertTrue(inventoryPage.isLinkedinLinkDisplayed(),
                "LinkedIn link should be displayed");
    }

    @And("the Inventory page should display a Sorting dropdown")
    public void theInventoryPageShouldDisplayASortingDropdown() {
        assertTrue(inventoryPage.isSortDropdownDisplayed(),
                "Sorting dropdown should be displayed");
    }

    @And("the Sorting dropdown should contain the following options:")
    public void theSortingDropdownShouldContainTheFollowingOptions(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        List<String> actualOptions = inventoryPage.getSortDropdownOptions();
        assertEquals(expectedOptions, actualOptions,
                "Sorting dropdown should contain the expected options");
    }

    @And("the Inventory page should display a menu icon at the top left corner")
    public void theInventoryPageShouldDisplayAMenuIcon() {
        assertTrue(inventoryPage.isMenuButtonDisplayed(),
                "Menu icon should be displayed at the top left corner");
    }

    @When("I click the menu icon")
    public void iClickTheMenuIcon() {
        inventoryPage.openMenu();
    }

    @Then("the menu should contain the following items:")
    public void theMenuShouldContainTheFollowingItems(DataTable dataTable) {
        List<String> expectedItems = dataTable.asList();
        List<String> actualItems = inventoryPage.getMenuItemTexts();
        assertEquals(expectedItems, actualItems,
                "Menu should contain the expected items");
    }
}
