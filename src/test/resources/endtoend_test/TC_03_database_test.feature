@e2e @database_test
Feature: DataBase Room Test
  Scenario: Validate Room By JDBC
    Given connect to database
    Then read the room and validate body