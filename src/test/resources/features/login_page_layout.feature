@login-layout
Feature: UC-1 Login Page Layout
  As a user
  I want to see the Login page layout
  So that I can understand how to authenticate

  Scenario: Verify Login page contains all required elements
    Given I open the Login page
    Then the page should display "Swag Labs" text on the top
    And the page should contain "Username" field
    And the page should contain "Password" field
    And the page should contain "Login" button
