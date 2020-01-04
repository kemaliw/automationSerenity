Feature: Taken search writer for duckduck page
  Scenario: Search possibility
    Given User opend duck page
    And Search for "text"
    Then Results are displayed