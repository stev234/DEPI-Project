Feature: User Signup Scenarios

  Background:
    Given User is on the homepage
    When User navigates to Signup/Login

  # -------------------------
  # Successful Signup Scenario
  # -------------------------
  Scenario: Successful signup
    And User enters name "Test User" and email "testuser+{rand}@example.com"
    And User fills all account information
    Then Account should be created successfully

  # -------------------------
  # Signup With Existing Email
  # -------------------------
  Scenario: Signup with existing email
    And User enters name "Existing User" and email "existing@example.com"
    And User fills all account information
    Then Signup should fail because email already exists

  # -------------------------
  # Signup Missing Required Fields
  # -------------------------
  Scenario: Signup missing required fields
    And User enters name "" and email "missing@example.com"
    And User submits incomplete account form
    Then The site should show validation errors

  # -------------------------
  # Delete Account Scenario
  # -------------------------
  Scenario: Delete account
    And User enters name "Delete Me" and email "deleteme+{rand}@example.com"
    And User fills all account information
    Then User deletes the account successfully
