Feature: Contact Us Form

  Scenario: Submit Contact Us successfully
    Given I open Contact Us page
    When I enter name "Khaled"
    And I enter email "test@test.com"
    And I enter message "Hello"
    And I submit the form
    Then I should see a success message
