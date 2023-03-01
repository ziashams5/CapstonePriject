Feature: Retail SignIn feature

  @smokeTest @Regression @FunctionalTestCases
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When user click on Sign in option
    And User enter email 'phantom.test@gmail.com' and password 'Tek@12345'
    And User click on login button
    Then User should be logged in into Account

  @registerNewAccount
  Scenario: Verify user can create an account in Retail Website
    Given User is on retail website
    When user click on Sign in option
    And User clik on Create New Account button
    And User fill the sign up information with bolow data
      | name | email       | password | confirmPassword |
      | yzd  | yzp@tek.com | XYb@1234 | XYb@1234        |
    And User click on SignUp button
    Then User should be logged in into account page
