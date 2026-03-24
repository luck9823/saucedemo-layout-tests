# SauceDemo Layout Validation Tests

Automated layout validation tests for [SauceDemo](https://www.saucedemo.com/) web application using Selenium WebDriver with BDD approach.

## Tech Stack

- **Language:** Java 11
- **Build Tool:** Maven
- **Test Framework:** Cucumber 7 + JUnit 5
- **Browser Automation:** Selenium WebDriver 4
- **Design Pattern:** Page Object Model (POM)
- **Locators:** CSS Selectors, XPath
- **Reporting:** Allure Report
- **Logging:** Log4j2
- **Browsers:** Chrome, Firefox

## Test Scenarios

| ID   | Scenario                    | Description                                      |
|------|-----------------------------|--------------------------------------------------|
| UC-1 | Login Page Layout           | Verify Username, Password fields, Login button   |
| UC-2 | Inventory Page Layout       | Verify logo, cart, social links, sorting, menu   |
| UC-3 | Inventory Item Page Layout  | Verify product image, name, price, buttons       |

## Prerequisites

- Java 11+ installed
- Maven 3.6+ installed
- Chrome and/or Firefox browser installed

## How to Run Tests

### Run on Chrome (default):
```
mvn clean test
```

### Run on Firefox:
```
mvn clean test -Dbrowser=firefox
```

### Run on both browsers in parallel:
```
mvn clean test -Dbrowser=chrome & mvn test -Dbrowser=firefox
```

## Generate Allure Report

### Generate report:
```
mvn allure:report
```

### Open report in browser:
```
mvn allure:serve
```

Report will be available at `target/site/allure-maven-plugin/index.html`

## Project Structure
```
src/
├── main/java/com/saucedemo/pages/
│   ├── BasePage.java            # Common page methods
│   ├── LoginPage.java           # Login page POM
│   ├── InventoryPage.java       # Inventory page POM
│   └── InventoryItemPage.java   # Item detail page POM
└── test/
    ├── java/com/saucedemo/
    │   ├── config/
    │   │   └── WebDriverFactory.java  # Browser driver management
    │   ├── runners/
    │   │   └── TestRunner.java        # Cucumber test runner
    │   └── steps/
    │       ├── Hooks.java             # Before/After hooks
    │       ├── LoginPageSteps.java
    │       ├── InventoryPageSteps.java
    │       └── InventoryItemPageSteps.java
    └── resources/
        └── features/
            ├── login_page_layout.feature
            ├── inventory_page_layout.feature
            └── inventory_item_page_layout.feature
```
