@e2e @api_test
Feature: Get the room and validate

  Scenario: Send get request do assertion
    Given send get request
    Then validate body