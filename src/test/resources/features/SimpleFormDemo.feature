Feature: Verifying Input Fields
  Scenario: As a user I want to check if Single Input Form works correctly
    Given User open page "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
    When User type  "test message 111" message into input field
    And Press show message button
    Then Message "test message 111" is displayed

  Scenario: As a user I want to verify writing messages into input field
    Given User open page "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
    When Using test data from file "test.csv"
    Then Messages is displayed for all entries

  Scenario: As a user i want to verify two input fields
    Given User open page "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
    Then User enter values A 2 and value B 6 and result is displayed

  Scenario: As a user I want to verify tons of numbers
    Given User open page "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
    Then User can sum 20 random numbers
