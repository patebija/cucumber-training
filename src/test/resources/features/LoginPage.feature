Feature: User is able to login into Flipkart

  Background:
    Given Launch Flipkart application

  @regression
  Scenario Outline: User is able to login with valid username and password

    Given User enters valid <username> in EnterUsername field
    And User enters valid <password> in EnterPassword field
    When User clicks on Login button
    Then User is logged in successfully
    Examples:
      |username              | password |
      |abirocks007@gmail.com | PA33word!|


  @smoke
  Scenario Outline: User is able to login with invalid username and password

    Given User enters invalid <username> in EnterUsername field
    And User enters invalid <password> in EnterPassword field
    When User clicks on Login button
    Then User cannot login into application
    Examples:
      | username             | password |
      |abirocks007@gmail.com | password |
      |abirocks@gmail.com    | PA33word!|



