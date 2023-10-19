Feature: Login into application

  @OnlyOneTime
 Scenario Outline: Login to application as valid user
    Given Login to application
    When user input <username> as username
    And user input <password> as password
    And user click submit
    Then Homepage / error should be displayed <status> as status

  Examples:
  |username   | password | status|
  |standard_user  | secret_sauce| success|
  |stand_user  | sec_sauce| failed |