@Login
Feature: User Login Functionality

  @smoke
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should be logged in successfully

  @regression
  Scenario: Failed login with invalid credentials
    Given User is on the login page
    When User enters invalid username and password
    And User clicks the login button
    Then User should see an error message