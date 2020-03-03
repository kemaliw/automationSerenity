Feature: Reading property files
  Scenario: Reading property file
    Given "app.properties" property file
    Then Property "app.usr" is not null