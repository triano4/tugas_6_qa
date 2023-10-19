Feature: buying product

  @OnlyOneTime
 Scenario Outline: User buy a product
    Given Logging in to application
    When user add product to cart
    And user checkout product
    And user fill <info> as information
    And user finishing checkout <info> as status
    Then thank you should be displayed <info> as status

  Examples:
  |username   | password | info |
  |standard_user  | secret_sauce| valid |
  |standard_user  | secret_sauce| invalid |

#  Scenario Outline: User input invalid information when checkout
#    Given Logging in to app
#    When user add a product to cart
#    And user checkout a product
#    And user fill invalid information
#    And user continue checkout
#    Then error message should be displayed
#
#    Examples:
#      |username   | password |
#      |standard_user  | secret_sauce|