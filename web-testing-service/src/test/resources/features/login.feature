@Login
Feature: User Login

  Scenario: Successful Login
    Given User is on the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should be logged in successfully