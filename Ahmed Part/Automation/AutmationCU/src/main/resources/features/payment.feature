Feature: Payment flow

  Scenario: Complete payment successfully
    Given I open the payment page
    When I enter valid payment details
    And I submit the payment
    Then the order should be placed successfully
