Feature: Alert verification
  Scenario: As a user I want to check if alerts works properly
    Given User open page "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html"
    And Click on alert button - autoclosable
      |id                       |Expected popup                |
      |autoclosable-btn-success |autocloseable success  message|
      |autoclosable-btn-warning |autocloseable warning message |
      |autoclosable-btn-danger  |autocloseable danger message  |
      |autoclosable-btn-info    |autocloseable info message    |
    And Click on alert button - normal
      |id                       |Expected popup        |
      |normal-btn-success       |normal success message|
      |normal-btn-warning       |normal warning message|
      |normal-btn-danger        |normal danger message |
      |normal-btn-info          |normal info message   |
