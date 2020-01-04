Feature: Day offer on allegro page
  Scenario: User can see offer day in the page
    Given User open page "https://allegro.pl"
    Then User can wait until day offer ends in 00 hours 00 minutes