@us4
Feature: As a librarian, I want to know who is the most popular user

  @db
  Scenario: verify who is the most popular user who reads the most
    Given Establish the database connection
    When I execute a query to find the most popular user
    Then verify "Test Student 1" is the user who reads the most