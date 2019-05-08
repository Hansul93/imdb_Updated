@All
Feature: Top Rated TV Shows
  This feature to validate Top Rated TV Shows - sub menu functions

  Background: Launch the application
    Given Launch IMDB application
    Then Mouse hover on the main menu "Movies"
    Then Choose the sub menu "Top Rated Tv Shows"

  @Rating
  Scenario: TC_01 Retrieving results based on IMDB rating
    Given get the list of shows having 9.5 ratings
    Then get the list of shows having 9.4 ratings

  @GameOfThrone
  Scenario: TC_02 Verifying Game Of Thrones Tv Show functionality
    Given Click on "Game of Thrones" link
    Then Assert the page navigation to "Game of Thrones"