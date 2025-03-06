@testingallholidayhoteltab
Feature:All Holiday and Hotel Tabs

  @testingalltab
  Scenario: Verify All List Tab Displays Correctly
    Given User launches the app
    When User enters valid credentials
    Then validates all available items with relevant details like name, description, and price


  @testingholidaytab
  Scenario: Verify Holiday List Tab Displays Correctly
    When User selects "Holidays"
    And validates all holiday destination, duration, and pricing

  @testinghoteltab
  Scenario: Verify Hotel List Tab Displays Correctly
    When User selects "Hotels"
    And validates all hotel names, locations, and ratings