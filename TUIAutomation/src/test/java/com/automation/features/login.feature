


@testing
Feature: Validate App Functionality

  Scenario: Validate Successful Login
    Given User launches the app
    When User enters valid credentials
    Then Validate home screen is loaded

  Scenario: Navigate to Hotels
    Given User is on the home screen
    When User selects "Hotels"
    Then Validate "Hotels" screen is loaded

  Scenario: Navigate to Holidays
    Given User is on the home screen
    When User selects "Holidays"
    Then Validate "Holidays" screen is loaded








