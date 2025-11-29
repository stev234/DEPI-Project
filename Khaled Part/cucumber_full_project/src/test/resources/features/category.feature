Feature: Category Browsing

  Scenario: Browse Women Tops
    Given I am on Home page
    When I click Women category
    And I select Tops subcategory
    Then I should see category products displayed
