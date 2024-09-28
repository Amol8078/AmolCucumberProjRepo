Feature: Validate login functionality

  @login
  Scenario: Validate login functionality
    Given User is on home page
    When User enter Username and Password
    And User click on login button
#    And User enter and validate the otp
#      | 000000 |
    Then User should able to login


