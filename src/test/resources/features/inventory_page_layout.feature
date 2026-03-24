@inventory-layout
Feature: UC-2 Inventory Page Layout
  As a logged-in user
  I want to see the Inventory page layout
  So that I can navigate and sort products

  Scenario: Verify Inventory page contains all required elements
    Given I login with standard_user credentials
    Then I should be redirected to the Inventory page
    And the Inventory page should display "Swag Labs" text on the top
    And the Inventory page should display a Cart icon
    And the Inventory page should display social network links for Twitter, Facebook, and LinkedIn
    And the Inventory page should display a Sorting dropdown

  Scenario: Verify sorting dropdown contains all required options
    Given I login with standard_user credentials
    Then I should be redirected to the Inventory page
    And the Sorting dropdown should contain the following options:
      | Name (A to Z)      |
      | Name (Z to A)      |
      | Price (low to high) |
      | Price (high to low) |

  Scenario: Verify menu contains all required items
    Given I login with standard_user credentials
    Then I should be redirected to the Inventory page
    And the Inventory page should display a menu icon at the top left corner
    When I click the menu icon
    Then the menu should contain the following items:
      | All Items       |
      | About           |
      | Logout          |
      | Reset App State |
