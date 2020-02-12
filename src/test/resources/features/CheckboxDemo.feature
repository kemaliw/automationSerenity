Feature: As a user I want to check if selecting and deselecting checkboxes works correctly

  Scenario: As a user I want to check if Single Checkbox Demo form works correctly
    Given User open page "https://www.seleniumeasy.com/test/basic-checkbox-demo.html"
    Then User selects checkbox
    And Proper message "Success - Check box is checked" is displayed.

  Scenario: As a user I wan to check if Multiple Checkbox Demo form works correctly
    Given User open page "https://www.seleniumeasy.com/test/basic-checkbox-demo.html"
    When User click on Check All button
    Then All checkboxes are selected
    And Button name was changed to "Uncheck All"
    When User unselect 2 checkboxes
    Then Button name was changed to "Check All"