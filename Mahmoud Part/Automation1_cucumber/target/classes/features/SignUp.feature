Feature: User signup and account management

  Background:
    Given User is on the homepage

  Scenario: Successful signup
    When User navigates to Signup/Login
    And User enters name "Test User" and email "testuser+{rand}@example.com"
    And User fills all account information
    Then Account should be created successfully

  Scenario: Signup with existing email
    When User navigates to Signup/Login
    And User enters name "Existing User" and email "existing@example.com"
    And User fills all account information
    Then Signup should fail because email already exists

  Scenario: Signup missing required fields
    When User navigates to Signup/Login
    And User enters name "" and email "missing@example.com"
    And User submits incomplete account form
    Then The site should show validation errors

  Scenario: Delete account
    When User navigates to Signup/Login
    And User enters name "Delete Me" and email "deleteme+{rand}@example.com"
    And User fills all account information
    Then User deletes the account successfully
