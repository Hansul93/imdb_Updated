@All
Feature: Register New User
  This feature is to validate create account functionality - Data from Excel

  @RegisterExcel
  Scenario: TC_05 Register a new user, login and logout - Data from Excel
    Given Launch the email service provider
    Then Launch IMDB application
    Then Click on Sign In button
    Then Click on Create Account button
    Then Fill in the following user details: "Create Account"
    Then Click on Continue button
    Then Click on profile dropdown
    And Click on logout option
    Then Verify the logged out state of the user
    Then Verify email with mail service provider

  @RegisterExcel
  Scenario: TC_06 Verify welcome mail from IMDB
    Given Switch to parent window
    Then Open the mail box of service provider
    Then Switch to parent window
    Then Login to the email service provider
    Then Click on verification email that the user received
    Then Click on account activation link
    And Verify the title "Complete your Registration"
