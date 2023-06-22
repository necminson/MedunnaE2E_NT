@e2e @ui_test
Feature: US05_Admin_Can_Create_Room

  Background:Sign in as admin

    Given user goes to "https://www.medunna.com/"
    When user clicks on user icon
    And user clicks on sign in link
    And user enters "mark_twain" and "Mark.123"
    And user clicks on sign in submit button

  Scenario Outline: Create Room

    Given user clicks on ItemsAndTitles dropdown
    When user clicks on Room link
    And user clicks on Create a new room link
    And user enters Room Number "<Room Number>"
    And user selects "<Room Type>"
    And user clicks on Status
    And user enters Price "<Price>"
    And user enters Description "<Description>"
    And user clicks on Save button
    Then assert the alert
    And close application

    Examples:
      | Room Number | Room Type | Price | Description            |
      | 65635899    | DAYCARE   | 222   | Created For E2E Test 1 |