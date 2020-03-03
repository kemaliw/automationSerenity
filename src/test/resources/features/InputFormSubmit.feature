Feature: As a user I want to check Input Form Submit page

  Scenario: As a user I want to verify if Input Form Submit page works correctly
    Given User open page "https://www.seleniumeasy.com/test/input-form-demo.html"
    When All input fields are filled in
      | name       | text                      |
      | first_name | Jan                       |
      | last_name  | Kowalski                  |
      | email      | jan.kowalski@gmail.com    |
      | phone      | 501 894 685               |
      | address    | ul. Rogatki 26c           |
      | city       | Warszawa                  |
      | zip        | 97-802                    |
      | website    | http://jankowalski.com.pl |
      | comment    | Testowy komentarz         |
    And Dropdown state "Florida" is correctly set
    And Hosting radio button "yes" is selected
    Then User click on send button