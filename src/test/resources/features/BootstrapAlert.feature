Feature: Alert verification
  Scenario: As a user I want to check if alerts works properly
    Given User open page "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html"
    And Click on alert buttons
    Then Autoclosable alerts are closed after 7 seconds
    And Normal alerts remain opened
    And User close normal alerts