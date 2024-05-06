Feature: Login

  Background: open browser
    Given User launch Chrome browser
    When User open ilcarro Home Page
    And User click Log in link

  @validLogin
  Scenario: Login with valid data
    And User enter email "neuer+1@gm.com", and password  "Manuel1234!"
    And User click Y'alla!
    And User checked success message after login
    And User quites browser

  @incorrectLogin
  Scenario Outline: Login with incorrect data
    And User enter email, and password as data
      | email   | password   |
      | <email> | <password> |
    And User click Y'alla!
    And User checked incorrect message after login
    And User quites browser

    Examples:
      | email          | password   |
      | neuer+1@gm.com | Manuel1234 |
      | neuer+1@gm.com | MAnuel134! |
      | neeur+1@gm.com | Mauel1234! |
      | neuer+1@gm.com | Manuellll  |