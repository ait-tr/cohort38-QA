Feature: Hame page

  @navigates
  Scenario: Verify Home Page is displayed
    Given User launch Chrome browser
    When User open ilcarro Home Page
    Then User checked Home Page title is displayed
    And User quites browser