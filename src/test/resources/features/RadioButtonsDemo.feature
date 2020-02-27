Feature: As a user I want to check radio button options
  Scenario: As a user I want to check Radio Button Demo page
    Given User open page "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html"
    When Click on the "Male" radio button
    And Click on the "Get Checked value" button
    Then "Radio button 'Male' is checked" message is displayed

  Scenario: As a user I want to check Radio Button Demo page2
    Given User open page "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html"
    When User select next radio button from Radio Button Demo
    And Click on the "Get Checked value" button
    Then Correct radio button message is displayed
