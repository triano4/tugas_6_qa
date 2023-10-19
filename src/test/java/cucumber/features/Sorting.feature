Feature: Sorting
  @OnlyOneTIme
  Scenario: Sort price low to high
    Given Login web
    When click sorting button
    And select sorting type
    Then show sort result