@us6
Feature: As a data consumer, I want UI and DB book categories match.
  @db @ui @wip
  Scenario: verify book categories with DB
    Given Establish the database connection
    When I navigate to "Books" page
    And I take all book categories in webpage
    And I execute query to get book categories
    Then verify book categories must match the book_categories table from DB