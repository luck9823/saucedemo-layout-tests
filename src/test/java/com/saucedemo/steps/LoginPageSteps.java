package com.saucedemo.steps;

import com.saucedemo.config.WebDriverFactory;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageSteps {

    private LoginPage loginPage;

    @Given("I open the Login page")
    public void iOpenTheLoginPage() {
        WebDriver driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Then("the page should display {string} text on the top")
    public void thePageShouldDisplayTextOnTheTop(String expectedText) {
        assertTrue(loginPage.isLoginLogoDisplayed(),
                "Login logo should be displayed");
        assertEquals(expectedText, loginPage.getLoginLogoText(),
                "Logo text should be '" + expectedText + "'");
    }

    @Then("the page should contain {string} field")
    public void thePageShouldContainField(String fieldName) {
        switch (fieldName) {
            case "Username":
                assertTrue(loginPage.isUsernameFieldDisplayed(),
                        "Username field should be displayed");
                break;
            case "Password":
                assertTrue(loginPage.isPasswordFieldDisplayed(),
                        "Password field should be displayed");
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
    }

    @Then("the page should contain {string} button")
    public void thePageShouldContainButton(String buttonName) {
        if ("Login".equals(buttonName)) {
            assertTrue(loginPage.isLoginButtonDisplayed(),
                    "Login button should be displayed");
        } else {
            throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }
}
