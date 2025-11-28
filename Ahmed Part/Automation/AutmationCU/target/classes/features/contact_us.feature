Feature: Submit contact form

  Scenario: Submit contact form successfully
    Given I go to Contact Us page
    When I fill the contact form with valid data
    And I upload a file
    And I submit the contact form
    Then the success message should appear
