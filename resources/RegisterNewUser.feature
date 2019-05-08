@All
Feature: Register New User
  This feature is to validate create account functionality

  Background: Launch the application
    Given Launch IMDB application
    Then Click on Sign In button

  @Register
  Scenario: TC_03 Register a new user, login and logout
    Given Click on Create Account button
    Then Fill in the following user details to create a new account
      | Field            | Value          |
      | Customer Name    | Hansul Fathima |
      | Email Address    | hf             |
      | Password         | HappyLife!)    |
      | Confirm Password | HappyLife!)    |
    Then Click on Continue button
    Then Click on profile dropdown
    And Click on logout option
    Then Verify the logged out state of the user

  @Register
  Scenario: TC_04 Sign with registered user, login and logout
    Given Sign in with imdb account
    Then Fill in the following user details to sign in
      | Field         | Value       |
      | Email Address | hf          |
      | Password      | HappyLife!) |
    Then click on Submit button
    Then Click on profile dropdown
    And Click on logout option
    Then Verify the logged out state of the user
