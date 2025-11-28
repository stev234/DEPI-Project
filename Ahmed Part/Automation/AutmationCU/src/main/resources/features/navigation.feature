Feature: User navigation

  Scenario: User navigates through pages
    Given I open the website
    When I navigate to Products page
    And I navigate to Cart page
    And I navigate to Login page
    And I navigate to Contact Us page
    Then I navigate back to Home page
