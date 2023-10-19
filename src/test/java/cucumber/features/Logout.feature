Feature: Logout

  @OnlyOneTime
 Scenario: Logout from application
    Given Login
    When click burger button
    And click logout
    Then back to homepage
