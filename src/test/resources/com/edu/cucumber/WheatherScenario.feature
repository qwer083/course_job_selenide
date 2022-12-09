Feature: Wheather feature

  @All
  Scenario: Get booking
    When open main wheather page
    Then input city name: "Краснодар"
    And choice city name
    And  check that cities is open: "Краснодар"
    Then choice ten day forecasts
    And print all forecasts