@item-layout
Feature: UC-3 Inventory Item Page Layout
  As a logged-in user
  I want to see the Inventory Item page layout
  So that I can view product details

  Scenario: Verify Inventory Item page contains all required elements
    Given I login with standard_user credentials
    Then I should be redirected to the Inventory page
    When I click on any inventory item
    Then I should be redirected to the item detail page
    And the item page should display "Swag Labs" text on the top
    And the item page should display the product image
    And the item page should display the product name
    And the item page should display the product description
    And the item page should display the product price
    And the item page should display an "Add to cart" button
    And the item page should display a "Back to products" link
    And the item page should display a Cart icon
    And the item page should display a Menu button
    And the item page should display social network links for Twitter, Facebook, and LinkedIn
