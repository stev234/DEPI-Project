Feature: Search Product

  Scenario: Search existing product
    Given I am on Products page
    When I search for "Dress"
    Then Products list should be displayed
