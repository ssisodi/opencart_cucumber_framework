Feature: Login with Valid Credentials

@module1
  	Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://awesomeqa.com/ui/"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "sisodiasiddhanth@gmail.com" and Password as "test@123"
    And Click on Login button
    Then User navigates to MyAccount Page

